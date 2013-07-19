package com.approductions.minecraft.texture;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import javax.imageio.ImageIO;

import com.approductions.minecraft.Main;

public class TextureSheetParser {
	BufferedImage imageSheet;
	int textureSize;
	
	public TextureSheetParser(String file) {
		this(new File(file));
	}
	public TextureSheetParser(File file) {
		try {
			imageSheet = ImageIO.read(file);
		} catch (IOException e) {
			Main.logger.log(Level.SEVERE, "Exception in creating a Buffered Image...", e);
		}
		textureSize = imageSheet.getHeight() / 16;
	}
	public int getTextureBySheetId(short id) {
		BufferedImage part = imageSheet.getSubimage(id * textureSize, id * textureSize, textureSize, textureSize);
		return TextureLoader.loadTexture(part);
	}
}
