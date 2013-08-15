package com.approductions.minecraft.utils;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.ARBVertexBufferObject;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GLContext;

public class UtilityMethods {
	public static final byte LEFT_SIDE = 1;
	public static final byte RIGHT_SIDE = 2;
	public static final byte TOP_SIDE = 3;
	public static final byte BOTTOM_SIDE = 4;
	public static final byte FRONT_SIDE = 5;
	public static final byte BACK_SIDE = 6;
	
	public static byte getSide(long x, long y, long z) {
		//TODO: Implement
		return -1;
	}
	public static int createVBOId() {
		if(GLContext.getCapabilities().OpenGL15) {
			return GL15.glGenBuffers();
		}
		else if(GLContext.getCapabilities().GL_ARB_vertex_buffer_object) {
			IntBuffer buffer = BufferUtils.createIntBuffer(1);
			ARBVertexBufferObject.glGenBuffersARB(buffer);
			return buffer.get(0);
		}
		else {
			return 0;
		}
	}
	
	public static void vertexBufferData(int id, FloatBuffer data) {
		if(GLContext.getCapabilities().OpenGL15){
			GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, id);
			GL15.glBufferData(id, data, GL15.GL_DYNAMIC_DRAW);
		}
		else if(GLContext.getCapabilities().GL_ARB_vertex_buffer_object) {
			ARBVertexBufferObject.glBindBufferARB(ARBVertexBufferObject.GL_ARRAY_BUFFER_ARB, id);
			ARBVertexBufferObject.glBufferDataARB(id, data, ARBVertexBufferObject.GL_DYNAMIC_DRAW_ARB);
		}
		else {
			//TODO We can't do anything with the VBO, considering the extension isn't there. Throw something. Like a wrench.
		}
	}
	
}
