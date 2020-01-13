package gui;

import java.awt.GridLayout;

import input_gui.MatrixDisplayContainer;
import input_gui.InputContainer;

public class GUIInput extends GUIBase{
	public GUIInput(String title) {
		super(title);
		this.frame.setLayout(new GridLayout(2, 1));
	}
	
	public void displayGUI() {
		this.setUpContainers();
		this.displayFrame(1500, 750);
	}
	
	private void setUpContainers() {
		MatrixDisplayContainer firstDisplayContainer = new MatrixDisplayContainer(this.frame, "MATRIX.");
		@SuppressWarnings("unused")
		InputContainer firstInputContainer = new InputContainer(firstDisplayContainer, this.frame, "MATRIX INPUT SCREEN.");
	}
	
}
