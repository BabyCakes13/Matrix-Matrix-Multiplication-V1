package control_gui;

import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.Container;
import items.Cell;

public class CellContainer extends Container{
	private JPanel cellContainer;
	private Cell[][] cells;
	
	public CellContainer(JFrame frame, Cell[][] cells) {
		super(frame, "Processors.");
		this.cellContainer = this.container;
		this.cells = cells;
		
		this.populateCells();
		
		frame.add(this.cellContainer);
		frame.pack();
	}
	
	private void populateCells() {
		for(int i = 0; i < this.cells.length; ++i) {
			for (int j = 0; j < this.cells.length; ++j) {
				String partialSum = Float.toString(this.cells[i][j].getCoefficient());
				this.makebutton(partialSum, i, j);
			}
		}
	}
	
	private void makebutton(String name, int gridy, int gridx) {
		JButton newButton = new JButton(name);
		this.setLayoutConstraints(newButton, gridy, gridx);
		container.add(newButton);
	}
	
	private GridBagConstraints setLayoutConstraints(JComponent object, int gridy, int gridx) {
		GridBagConstraints constraints = new GridBagConstraints();
		//constraints.gridheight = this.cells.length;
		//constraints.gridwidth = this.cells.length;
		constraints.weightx = 1.0;
        constraints.weighty = 1.0;
		
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridy = gridy;
		constraints.gridx = gridx;
		
		this.containerLayout.setConstraints(object, constraints);
		
		return constraints;
		
	}
}
