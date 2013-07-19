package com.approductions.minecraft.chunks;

import com.approductions.minecraft.SimplexNoise;
import com.approductions.minecraft.blocks.BlockDirt;
import com.approductions.minecraft.blocks.BlockStone;
import com.approductions.minecraft.blocks.IBlock;
import com.approductions.minecraft.gui.GuiManager;
import com.approductions.minecraft.utils.UtilityMethods;

public class Chunk {
	private boolean generated = false;
	
	private long xCoord;
	private long zCoord;
	//             x z y
	private IBlock[][][] blocks = new IBlock[16][16][255];
	
	public Chunk(long x, long z) {
		for(long a=x; a < x + 16; a++) {
			for(long b=z; b < z + 16; b++) {
				double height = SimplexNoise.noise(x, z);
				//Negate any negative noise values.
				if(height < 0) {
					height = -height;
				}
				//Multiply by the max height (255), then round up
				height = Math.ceil(height * 255);
				//TODO: Implement the randomness of this...
				int dirtHeight = 3;
				for(short h = 0; h < height; h++) {
					if(height - h <= dirtHeight) {
						blocks[(int) (a - x)][(int) (b - z)][h] = new BlockDirt();
					}
					else {
						blocks[(int) (a - x)][(int) (b - z)][h] = new BlockStone();
					}
				}
			}
		}
		xCoord = x;
		zCoord = z;
	}
	public boolean isDisplayListGenerated() {
		return generated;
	}
	public void generateDisplayList() {
		
		generated = true;
	}
	public boolean isInBounds(long x, long z) {
		if(x < xCoord) {
			return false;
		}
		if(x > xCoord) {
			return false;
		}
		if(z < zCoord) {
			return false;
		}
		if(z < zCoord) {
			return false;
		}
		return true;
	}
	/**
	 * Handles all clicking actions (Yay for abstraction!)
	 * 
	 * 
	 * @param x The X-coord of the click
	 * @param z The Z-coord of the click
	 * @param mouseButton TRUE if left, FALSE if right
	 * @param shift Was shift pressed when we clicked (Or, was the player sneaking?)
	 */
	public void onClick(long x, short y, long z, boolean mouseButton, boolean shift) {
		//NOTE: mouseButton is TRUE if left, FALSE if right
		//TODO: Finish up this method.
		if(!isInBounds(x,z)) {
			System.err.println("Click sent to the wrong chunk. Now sending to correct chunk");
			ChunkManager.onClick(x, y, z, mouseButton, shift);
		}
		IBlock block = blocks[(int) (x - xCoord)][(int) (z - zCoord)][y];
		if(block.hasGUI()) {
			if(!mouseButton) {
				if(shift) {
					byte side = UtilityMethods.getSide(x, y, z);
					switch(side) {
						case UtilityMethods.LEFT_SIDE:
							//TODO: Finish off...
							blocks[(int) ((x - xCoord) - 1)][(int) (z - zCoord)][y] = null;
							
					}
				}
				else {
					GuiManager.displayGUI(block.getGUI());
				}
			}
			
		}
		else if(!mouseButton) {
			
		}
		else {
			
		}
	}
}
