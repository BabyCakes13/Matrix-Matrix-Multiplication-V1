package control_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.Container;
import items.Cell;

public class ResultContainer extends Container{
	private Cell[][] cells;
	private JPanel cellContainer;
	JTable matrixTable;
	
	public ResultContainer(JFrame frame, Cell[][] cells) {
		super(frame, "Result.");
		this.cells = cells;
		this.cellContainer = this.container;
		this.cellContainer.setLayout(new BorderLayout());
		
		this.matrixTable = addTable();
		// initially populate the matrix with 0's so we can see the structure.
		float[][] zeroMatrix = this.createZeroMatrix(this.cells.length);
		this.populateTable(zeroMatrix);

		frame.getContentPane().add( new JScrollPane(this.matrixTable), BorderLayout.CENTER);
		frame.pack();
	}
	
	protected void populateTable(float[][] result) {
		for(int i = 0; i < this.cells.length; ++i) {
			for (int j = 0; j < this.cells.length; ++j) {
				this.setTableItem(result[i][j], i, j);
			}
		}
		
		this.cellContainer.revalidate();
		this.cellContainer.repaint();
	}
	
	private JTable addTable() {
		JTable table = new JTable(this.cells.length * 2, this.cells.length * 2); // * 2 so the cell is formed of 4 table slots as a square.
		table.setPreferredSize(new Dimension(250, 250));
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		table.setFont(new Font("Serif", Font.BOLD, 10));
		return table;
	}
	
	private void setTableItem(float value,int i, int j) {
		String stringValue = Float.toString(value);
		this.matrixTable.setValueAt(stringValue, i, j);
	}
	
	private float[][] createZeroMatrix(int size) {
		float[][] zeroMatrix = new float[size][size];
		
		for(int i = 0; i < size; ++i) {
			for(int j = 0; j < size; ++j) {
				zeroMatrix[i][j] = 0;
			}
		}
		
		return zeroMatrix;
	}
}
