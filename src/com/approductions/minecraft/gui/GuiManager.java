package com.approductions.minecraft.gui;

import com.approductions.minecraft.render.RenderController;

public class GuiManager {
	public static void displayGUI(IGui gui) {
		
	}
	public static void renderActiveGUIs() {
		RenderController.make2D();
		RenderController.disableAllFeatures();
	}
}
