package control_gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.Container;
import multiplication.Multiplication;

public class ControlContainer extends Container {
	private JPanel controlContainer;
	private CellContainer cellContainer;
	private ResultContainer resultContainer;
	
	private Multiplication multiplication;
	
	public ControlContainer(JFrame frame, CellContainer cellContainer, ResultContainer resultContainer, Multiplication multiplication) {
		super(frame, "Control");
		this.controlContainer = this.container;
		this.controlContainer.setLayout(new BorderLayout());
		this.multiplication = multiplication;
		this.cellContainer = cellContainer;
		this.resultContainer = resultContainer;
		
		this.addPush();
		
		frame.add(this.controlContainer);
		frame.pack();
	}
	
	private void addPush() {
		JButton pushButton = new JButton("PUSH");
		
		pushButton.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent ae){
			      handlePush();
			   }
			});
		
		this.setInputLayoutConstraints(pushButton);
		this.controlContainer.add(pushButton, BorderLayout.CENTER);
	}
	
	private void handlePush() {
		System.out.println("PUSH CALLED.");
		this.makeStep();
	}
	
	private void makeStep() {
		boolean done = this.multiplication.handlePush();
		if(!done) {
			float[][] previousAOutputs = this.multiplication.getPreviousAOutputs();
			float[][] previousBOutputs = this.multiplication.getPreviousBOutputs();
			float[][] previousCOutputs = this.multiplication.getPreviousCOutputs();
			float[][] result = this.multiplication.getResult();
			
			System.out.println(previousAOutputs.length + ":" + previousBOutputs.length + ":" + previousCOutputs.length);
			this.cellContainer.populateTable(previousAOutputs, previousBOutputs, previousCOutputs);
			this.resultContainer.populateTable(result);
		} else {
			System.out.println("DONE.");
		}
		
	}
}
