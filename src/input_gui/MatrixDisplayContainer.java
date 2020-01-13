package input_gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import gui.Container;

public class MatrixDisplayContainer extends Container{
	private JPanel equationDisplayContainer;
	private JTextArea displayScreen;
	
	public MatrixDisplayContainer(JFrame frame, String containerTitle) {
		super(frame, containerTitle);
		this.equationDisplayContainer = this.container;
		this.equationDisplayContainer.setLayout(new BorderLayout());

		this.displayScreen = this.addDisplayScreen();

		frame.add(this.equationDisplayContainer);
		frame.pack();
	}
	
	public JTextArea addDisplayScreen() {
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Monospace", Font.PLAIN, 18));
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		this.equationDisplayContainer.add(scrollPane);
		this.equationDisplayContainer.revalidate();
		
		return textArea;
	}
	
	private String buildDisplayMatrix(float[][] matrix) {
		StringBuilder matrixBuilder = new StringBuilder();
		int matrixSize = matrix.length;
		
		for(int i = 0; i < matrixSize; ++i) {
			for(int j = 0; j < matrixSize; ++j) {
				matrixBuilder.append(matrix[i][j] + " ");
			}
			matrixBuilder.append("\n");
		}
		
		return matrixBuilder.toString();
	}
	
	public void displayMatrix(float[][] matrix, String name) {
		String matrixString = this.buildDisplayMatrix(matrix);
		System.out.println(matrix);
		
		this.displayScreen.append(name + "\n");
		this.displayScreen.append(matrixString);
		this.displayScreen.append("\n");
		
		this.equationDisplayContainer.revalidate();
		this.equationDisplayContainer.repaint();
	}
	
	
}
