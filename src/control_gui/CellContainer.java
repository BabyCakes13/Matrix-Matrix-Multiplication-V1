package control_gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import gui.Container;
import items.Cell;

public class CellContainer extends Container{
	private JPanel cellContainer;
	private Cell[][] cells;
	private JTable matrixTable;
	
	private Color[] COLORS = {new Color(255, 237, 186),
							  new Color(186, 255, 249),
							  new Color(244, 219, 255),
							  new Color(255, 255, 255)
	};
	
	public CellContainer(JFrame frame, Cell[][] cells) {
		super(frame, "Processors.");
		this.cellContainer = this.container;
		this.cells = cells;
		
		this.matrixTable = addTable();
		this.populateTable();

		frame.add(this.matrixTable);
		frame.pack();
	}
	
	private void populateTable() {
		for(int i = 0; i < this.cells.length; ++i) {
			for (int j = 0; j < this.cells.length; ++j) {
				// float partialSum = this.cells[i][j].getCoefficient();
				this.setTableItems(0, Color.red, i*2+0, j*2+0);
				this.setTableItems(1, Color.blue, i*2+1, j*2+1);
				this.setTableItems(2, Color.green, i*2+1, j*2+0);
				//this.setTableItems(3, Color.white, i*2+0, j*2+1);
			}
		}
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
		table.setFont(new Font("Serif", Font.BOLD, 10));
		table.setDefaultRenderer(Object.class, new MatrixColumnCellRenderer());
		return table;
	}
	
	private void setTableItems(float value, Color color, int i, int j) {
		String stringValue = Float.toString(value);
		this.matrixTable.setValueAt(stringValue, i, j);
	}
	
	private GridBagConstraints setLayoutConstraints(JComponent object, int gridy, int gridx) {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.weightx = 1.0;
        constraints.weighty = 1.0;
		
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridy = gridy;
		constraints.gridx = gridx;
		
		this.containerLayout.setConstraints(object, constraints);
		
		return constraints;
		
	}
}
