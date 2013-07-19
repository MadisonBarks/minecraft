package com.approductions.minecraft.render;
import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glOrtho;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

import com.approductions.minecraft.Main;

public class RenderController {
	public static void make2D() {
	    //TODO: Correct for MY USAGE
		glEnable(GL_BLEND);
	    GL11.glMatrixMode(GL11.GL_PROJECTION);
	    GL11.glLoadIdentity();
	    glOrtho(0.0f, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT, 0.0f, 0.0f, 1.0f);
	    
	    GL11.glMatrixMode(GL11.GL_MODELVIEW);
	    GL11.glLoadIdentity();
	}

	public static void make3D() {
		//TODO: Correct for MY usage.
	    glDisable(GL_BLEND);
	    GL11.glMatrixMode(GL11.GL_PROJECTION);
	    GL11.glLoadIdentity(); // Reset The Projection Matrix
	    GLU.gluPerspective(45.0f, ((float) Main.SCREEN_WIDTH / (float) Main.SCREEN_HEIGHT), 0.1f, 100.0f); // Calculate The Aspect Ratio Of The Window

	    GL11.glMatrixMode(GL11.GL_MODELVIEW);
	    glLoadIdentity();
	}
	public static void disableAllFeatures() {
		
	}
}
