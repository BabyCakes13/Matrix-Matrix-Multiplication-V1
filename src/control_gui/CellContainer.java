package control_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import gui.Container;
import items.Cell;

public class CellContainer extends Container{
	private Cell[][] cells;
	private JPanel cellContainer;
	JTable matrixTable;
	
	private Color[] COLORS = {new Color(255, 237, 186),
							  new Color(186, 255, 249),
							  new Color(244, 219, 255),
							  new Color(255, 255, 255)
	};
	
	public CellContainer(JFrame frame, Cell[][] cells) {
		super(frame, "Processors.");
		this.cells = cells;
		this.cellContainer = this.container;
		this.cellContainer.setLayout(new BorderLayout());
		
		this.matrixTable = addTable();
		// initially populate the matrix with 0's so we can see the structure.
		float[][] zeroMatrix = this.createZeroMatrix(this.cells.length);
		this.populateTable(zeroMatrix,
						   zeroMatrix,
						   zeroMatrix);

		frame.getContentPane().add( new JScrollPane(this.matrixTable), BorderLayout.CENTER);
		frame.pack();
	}
	
	protected void populateTable(float[][] previousAOutputs,
			  				   float[][] previousBOutputs,
			  				   float[][] previousCOutputs) {
		for(int i = 0; i < this.cells.length; ++i) {
			for (int j = 0; j < this.cells.length; ++j) {
				this.setTableItem(previousAOutputs[i][j], i*2+0, j*2+0);
				this.setTableItem(previousBOutputs[i][j], i*2+1, j*2+0);
				this.setTableItem(previousCOutputs[i][j], i*2+0, j*2+1);
				//this.setTableItems(Float.NaN, i*2+0, j*2+1); we do not set anything for the fourth row since we don't have the fourth matrix
			}
		}
		
		this.cellContainer.revalidate();
		this.cellContainer.repaint();
	}
	
	@SuppressWarnings("serial")
	public class MatrixColumnCellRenderer extends DefaultTableCellRenderer {
		  @Override
		  public Component getTableCellRendererComponent(JTable table, Object value, 
				  boolean isSelected, boolean hasFocus, int i, int j) {

		    //Cells are by default rendered as a JLabel.
		    JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, i, j);

		    if(i%2==0 && j%2==0) {
		    	l.setBackground(COLORS[0]);
		    } else if(i%2==0 && j%2==1) {
		    	l.setBackground(COLORS[1]);
		    } else if(i%2==1 && j%2==0) {
		    	l.setBackground(COLORS[2]);
		    } if(i%2==1 && j%2==1) {
		    	l.setBackground(COLORS[3]);
		    }

		  return l;

		}
	}
	
	private JTable addTable() {
		JTable table = new JTable(this.cells.length * 2, this.cells.length * 2); // * 2 so the cell is formed of 4 table slots as a square.
		table.setTableHeader(null);
		table.setFont(new Font("Serif", Font.BOLD, 10));
		table.setDefaultRenderer(Object.class, new MatrixColumnCellRenderer());
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
