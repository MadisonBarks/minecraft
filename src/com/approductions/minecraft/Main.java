/**
 * @author Austin Bolstridge
 */
package com.approductions.minecraft;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.PixelFormat;

/**
 * @author Austin
 *
 */
public class Main {
	
	public static final short SCREEN_HEIGHT = 600;
	public static final short SCREEN_WIDTH = 800;
	
	/**
	 * Returns a string containing the name of the OS.
	 * Mainly used for the library loading function.
	 * @return The type of OS
	 */
	public static String getOs() {
		String var0 = System.getProperty("os.name").toLowerCase();

		return var0.contains("win") ? "Windows" : (var0.contains("mac") ? "Macosx" : (var0.contains("solaris") ? "Solaris" : (var0.contains("sunos") ? "Solaris" : (var0.contains("linux") ? "Linux" : (var0.contains("unix") ? "Linux" : "Unknown")))));
	}
	
	public static Logger logger = null;
	
	public void loadLibraries() {
		//======================BEGIN LIBRARY LOADING==========================
		//FIXME: The following DOES NOT LOAD THE LIBRARIES.
		File libDir = new File("libs/native/" + getOs() + "/");
		if(libDir.equals(null)) {
			System.err.println("GAHH!");
		}
		String[] lists = libDir.list();
		int inc = 1;
		String cpu = System.getProperty("sun.cpu.isalist");
		boolean bit64 = false;
		if(cpu.equals("amd64")) {
			bit64 = true;
		}
		for(String lib : lists) {
			System.out.println("In loop, adding libraries");
			if(bit64) {
				if(inc%2 == 0) {
					System.load(System.getProperty("user.dir") + "/libs/native/" + getOs() + "/" + lib);
				}
			}
			else {
				if(inc%2 == 1) {
					System.load(System.getProperty("user.dir") + "/libs/native/" + getOs() + "/" + lib);
				}
			}
			inc++;
		}
		//==================END LIBRARY LOADING==============================
	}
	
	/**
	 * Here we set up the display.
	 */
	public void displaySetup() {
		try {
			Display.setDisplayMode(new DisplayMode(900, 700));
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		Display.setInitialBackground(0, 0, 0);
		Display.setVSyncEnabled(false);
		Display.setResizable(true);
		PixelFormat format = new PixelFormat();
		format = format.withDepthBits(16);
		try {
			Display.create(format);
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Here we set up some native in-code support for mods.
	 */
	public void modSetup() {
		//TODO Decide on whether we actually want to do this or not.
	}
	
	/**
	 * Here we set up the input systems.
	 */
	public void inputSetup() {
		Mouse.setGrabbed(true);
		
	}
	
	/**
	 * The main loop, where everything is done
	 */
	public void loop() {
		//NOTE: Render all like blocks together, in the same glBegin/glEnd set.
		//Also, use display lists
		
		//NOTE: In here, we need to check any generation threads, and make sure that
		//They have not finished, and finish up the finished ones.
		//Also, use a fork-join relationship.
		System.out.println(Mouse.getX() + ":" + Mouse.getY());
		Display.update();
		Display.sync(2);
	}
	
	/**
	 * Here we set up the log4j logging system.
	 */
	public void logSetup() {
		logger = Logger.getLogger("minecraft");
		FileHandler fileTxt;
		try {
			fileTxt = new FileHandler("minecraft.log");
			SimpleFormatter formatterTxt = new SimpleFormatter();
		    fileTxt.setFormatter(formatterTxt);
		    logger.addHandler(fileTxt);
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
	    
	}
	
	/**
	 * The main called method.
	 */
	public void start() {
		loadLibraries();
		displaySetup();
		inputSetup();
		modSetup();
		logSetup();
		while(!Display.isCloseRequested()) {
			loop();
		}
		closeProgram();
		System.exit(0);
	}
	
	/**
	 * The following is called whenever the window is wanting to close.
	 */
	public void closeProgram() {
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Main main = new Main();
		main.start();
		
	}

}
