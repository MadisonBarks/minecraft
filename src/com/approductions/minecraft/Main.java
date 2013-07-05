/**
 * @author Austin Bolstridge
 */
package com.approductions.minecraft;

import java.io.File;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.PixelFormat;

/**
 * @author Austin
 *
 */
public class Main {
	
	/**
	 * Returns a string containing the name of the OS.
	 * Mainly used for the library loading function.
	 * @return The type of OS
	 */
	public static String getOs() {
		String var0 = System.getProperty("os.name").toLowerCase();

		return var0.contains("win") ? "Windows" : (var0.contains("mac") ? "Macosx" : (var0.contains("solaris") ? "Solaris" : (var0.contains("sunos") ? "Solaris" : (var0.contains("linux") ? "Linux" : (var0.contains("unix") ? "Linux" : "Unknown")))));
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//======================BEGIN LIBRARY LOADING==========================
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

}
