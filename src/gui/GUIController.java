package gui;

import multiplication.Multiplication;

import java.awt.GridLayout;

import control_gui.CellContainer;
import control_gui.ControlContainer;
import control_gui.ResultContainer;

// import evaluation_gui.CellContainer;
// import evaluation_gui.ControlContainer;
// import evaluation_gui.ParseContainer;
// import evaluation_gui.ResultContainer;

public class GUIController extends GUIBase{
	private Multiplication multiplication;

	public GUIController(String title, Multiplication multiplication) {
		super(title);
		this.frame.setLayout(new GridLayout(3, 1));
		this.multiplication = multiplication;
	}
	
	public void displayGUI() {
		this.setUpContainers();
		this.displayFrame(500, 500);
	}
	
	private void setUpContainers() {
		@SuppressWarnings("unused")
		CellContainer cellContainer = new CellContainer(this.frame, this.multiplication.getCells());
		ResultContainer resultContainer = new ResultContainer(this.frame, this.multiplication.getCells());
		ControlContainer controlContainer = new ControlContainer(this.frame, cellContainer, resultContainer, this.multiplication);
	}
	
}
