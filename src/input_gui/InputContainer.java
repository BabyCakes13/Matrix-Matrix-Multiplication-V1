package input_gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.Container;

public class InputContainer extends Container{
	private JPanel inputContainer;
	private float[][] aMatrix, bMatrix;
	private int matrixSize;
	
	public InputContainer(MatrixDisplayContainer equationContainer, JFrame frame, String containerTitle) {
		super(frame, containerTitle);
		this.inputContainer = this.container;
		
		this.addCoefficients(equationContainer);
		frame.add(this.inputContainer);
		frame.pack();
	}
	
	private void setMatrixSize(int size) {
		this.matrixSize = size;
		System.out.println("Class matrix size is set to: " + this.matrixSize);
	}
	
	private void setAMatrix(float[][] aMatrix) {
		this.aMatrix = aMatrix;
	} 
	
	private void setBMatrix(float[][] bMatrix) {
		this.bMatrix = bMatrix;
	}
	
	public float[][] getAMatrix() {
		return this.aMatrix;
	}
	
	public float[][] getBMatrix() {
		return this.bMatrix;
	}
	
	private void addCoefficients(MatrixDisplayContainer matrixDC) {
		JLabel sizeLabel = new JLabel();
		sizeLabel.setText("Matrix size:");
		JTextField sizeInputField = new JTextField(10);
		JButton sizeButton = new JButton("ADD MATRIX SIZE");

		JLabel matrixLabel = new JLabel();
		matrixLabel.setText("Matrix:");
		JTextField matrixInputField = new JTextField(10);
		JButton matrixButton = new JButton("ADD MATRIX");
		
		sizeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputValue = sizeInputField.getText();
				matrixSize = buildMatrixSize(inputValue, sizeLabel);
				setMatrixSize(matrixSize);
			}
		});
		
		matrixButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputValue = matrixInputField.getText();
				float[][] matrix = buildMatrix(inputValue, matrixLabel);
				setAMatrix(matrix);
				matrixDC.displayMatrix(matrix, "ADDED MATRIX:\n");
			}
		});

		this.setInputLayoutConstraints(sizeLabel, 1, 1);
		this.setInputLayoutConstraints(sizeInputField, 1, 2);
		this.setInputLayoutConstraints(sizeButton, 1, 3);
		this.setInputLayoutConstraints(matrixLabel, 2, 1);
		this.setInputLayoutConstraints(matrixInputField, 2, 2);
		this.setInputLayoutConstraints(matrixButton, 2, 3);
		
		this.inputContainer.add(sizeLabel);
		this.inputContainer.add(sizeInputField);
		this.inputContainer.add(sizeButton);
		this.inputContainer.add(matrixLabel);
		this.inputContainer.add(matrixInputField);
		this.inputContainer.add(matrixButton);
	}
	
	/**
	 * @param input
	 * @param label
	 * @return
	 */
	private int buildMatrixSize(String input, JLabel label) {
		String stringMatrixSize = input;

		int matrixSize = 0;
		try {
				matrixSize = Integer.parseInt(stringMatrixSize);
			} catch (NumberFormatException e) {
				System.out.println("Please enter a matrix size larger than 0.");
			}
		
		if(matrixSize > 0) {
			label.setText("Good job, human. We shall proceed to the next step...");
		}
		
		return matrixSize;
	}
	
	private float[][] buildMatrix(String input, JLabel label) {
		float[][] matrix = new float[this.matrixSize][this.matrixSize];
		label.setText("Enter the elements of the matrix.");
		String[] stringElements = input.split(",");
		
		int stringIndex = 0;
		for(int i = 0; i < this.matrixSize; ++i) {
			for(int j = 0; j < this.matrixSize; ++j) {
				String element = stringElements[stringIndex];
				if(checkNumber(element)) {
					matrix[i][j] = Float.parseFloat(stringElements[stringIndex]);
					stringIndex++;
				} else {
					label.setText("The elements must be numbers.");
					return null;
				}
			}
		}
		
		return matrix;
		
	}
	
	private boolean checkNumber(String input) {
		try {
			Float.parseFloat(input);
		} catch (NumberFormatException e) {
			System.out.println("Please enter a valid number.");
			return false;
		}
		return true;
	}
}
