package com.approductions.minecraft.blocks;

import com.approductions.minecraft.gui.IGui;

public interface IBlock {
	public void onClick(boolean mouseButton);
	public boolean hasGUI();
	public IGui getGUI();
	public int getLeftTextureId();
	public int getRightTextureId();
	public int getTopTextureId();
	public int getBottomTextureId();
	public int getFrontTextureId();
	public int getBackTextureId();
	public void draw();
}
