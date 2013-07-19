package com.approductions.minecraft.texture;

import java.util.HashMap;

import org.lwjgl.opengl.GL11;

public class TextureManager {
	public static HashMap<Short, Integer> textures = new HashMap<Short, Integer>();
	public static TextureSheetParser textureSheet = new TextureSheetParser("/res/terrain.png");
	
	private static void addTexture(short textId) {
		if(textures.containsKey(textId)) {
			return;
		}
		else {
			int texture = textureSheet.getTextureBySheetId(textId);
			textures.put(textId, texture);
		}
	}
	public static int getTexture(short textId) {
		if(!textures.containsKey(textId)) {
			addTexture(textId);
		}
		return textures.get(textId);
	}
	public static void bindTexture(short textId) {
		bindTexture(getTexture(textId));
	}
	public static void bindTexture(int glTextId) {
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, glTextId);
	}
}
