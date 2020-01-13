package gui;

import multiplication.Multiplication;

import java.awt.GridLayout;

// import evaluation_gui.CellContainer;
// import evaluation_gui.ControlContainer;
// import evaluation_gui.ParseContainer;
// import evaluation_gui.ResultContainer;

public class GUIController extends GUIBase{
	private Multiplication multiplication;

	public GUIController(String title, Multiplication multiplication) {
		super(title);
		this.frame.setLayout(new GridLayout(4, 1));
		this.multiplication = multiplication;
	}
	
	public void displayGUI() {
		// this.setUpContainers();
		this.displayFrame(1000, 1000);
	}
	
	/*private void setUpContainers() {
		@SuppressWarnings("unused")
		CellContainer cellContainer = new CellContainer(this.frame, this.multiplication.getCells());
		ParseContainer parseContainer = new ParseContainer(this.frame, this.multiplication.getCells().size());
		ResultContainer resultContainer = new ResultContainer(this.frame);
		@SuppressWarnings("unused")
		ControlContainer controlContainer = new ControlContainer(this.frame, parseContainer, resultContainer, this.multiplication);
	}*/
	
}
