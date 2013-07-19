package com.approductions.minecraft.chunks;

import java.util.ArrayList;

public class ChunkManager {
	private static ArrayList<Chunk> chunks = new ArrayList<Chunk>();
	public static Chunk generateChunk(long x, long y) {
		Chunk cnk = new Chunk(x,y);
		addChunk(cnk);
		return cnk;
	}
	public static void addChunk(Chunk chunk) {
		if(!chunk.isDisplayListGenerated()) {
			chunk.generateDisplayList();
		}
		chunks.add(chunk);
	}
	public static void onClick(long x, short y, long z, boolean mouseButton, boolean shift) {
		for(Chunk chunk : chunks) {
			if(chunk.isInBounds(x, z)) {
				chunk.onClick(x, y, z, mouseButton, shift);
			}
		}
	}
}
