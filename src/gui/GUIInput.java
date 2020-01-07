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
		this.displayFrame(1000, 1000);
	}
	
	private void setUpContainers() {
		MatrixDisplayContainer equationContainer = new MatrixDisplayContainer(this.frame, "Matrices to be multiplied.");
		@SuppressWarnings("unused")
		InputContainer inputContainer = new InputContainer(equationContainer, this.frame, "Input matrices.");
	}
	
}
