package com.approductions.minecraft.blocks;

import org.lwjgl.opengl.GL11;

import com.approductions.minecraft.gui.IGui;

public class BlockStone implements IBlock {

	@Override
	public void onClick(boolean mouseButton) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasGUI() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IGui getGUI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLeftTextureId() {
		return 1;
	}

	@Override
	public int getRightTextureId() {
		return 1;
	}

	@Override
	public int getTopTextureId() {
		return 1;
	}

	@Override
	public int getBottomTextureId() {
		return 1;
	}

	@Override
	public int getFrontTextureId() {
		return 1;
	}

	@Override
	public int getBackTextureId() {
		return 1;
	}

	@Override
	public void draw() {
		
	}

	

}
