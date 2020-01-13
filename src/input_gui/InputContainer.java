package input_gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.Container;
import multiplication.Multiplication;

public class InputContainer extends Container{
	private JPanel inputContainer;
	private float[][] firstMatrix, secondMatrix;
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
	
	private void setAMatrix(float[][] matrix) {
		this.firstMatrix = matrix;
		System.out.println("Matrix has been set");
		this.displayMatrix(this.firstMatrix);
	}
	
	public float[][] getAMatrix() {
		return this.firstMatrix;
	}
	
	private void setBMatrix(float[][] matrix) {
		this.secondMatrix = matrix;
		System.out.println("Matrix has been set");
		this.displayMatrix(this.secondMatrix);
	}
	
	public float[][] getBMatrix() {
		return this.secondMatrix;
	}
	
	private void addCoefficients(MatrixDisplayContainer matrixDC) {
		JLabel sizeLabel = new JLabel();
		sizeLabel.setText("Matrix size:");
		JTextField sizeInputField = new JTextField(10);
		JButton sizeButton = new JButton("FIRST MATRIX SIZE");

		JLabel matrixLabel = new JLabel();
		matrixLabel.setText("Matrix:");
		JTextField matrixInputField = new JTextField(10);
		JButton matrixButton = new JButton("FIRST MATRIX");
		
		sizeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputValue = sizeInputField.getText();
				int matrixSize = buildMatrixSize(inputValue, sizeLabel, matrixLabel);
				setMatrixSize(matrixSize);
			}
		});
		
		matrixButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputValue = matrixInputField.getText();
				float[][] matrix = buildMatrix(inputValue, matrixLabel);
				if(matrix != null) {
					setAMatrix(matrix);
					matrixDC.displayMatrix(matrix, "ADDED FIRST MATRIX:\n");
					
					if(secondMatrix != null) {
						System.out.println("INITIATE");
						// initiate multiplication screen
						Multiplication multiplication = new Multiplication(firstMatrix, secondMatrix);
					}
				}
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
		
		JLabel secondSizeLabel = new JLabel();
		secondSizeLabel.setText("Matrix size:");
		JTextField secondSizeInputField = new JTextField(10);
		JButton secondSizeButton = new JButton("SECOND MATRIX SIZE");

		JLabel secondMatrixLabel = new JLabel();
		secondMatrixLabel.setText("Matrix:");
		JTextField secondMatrixInputField = new JTextField(10);
		JButton secondMatrixButton = new JButton("SECOND MATRIX");
		
		secondSizeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputValue = secondSizeInputField.getText();
				int matrixSize = buildMatrixSize(inputValue, secondSizeLabel, secondMatrixLabel);
				setMatrixSize(matrixSize);
			}
		});
		
		secondMatrixButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputValue = secondMatrixInputField.getText();
				float[][] matrix = buildMatrix(inputValue, secondMatrixLabel);
				if(matrix != null) {
					setBMatrix(matrix);
					matrixDC.displayMatrix(matrix, "ADDED SECOND MATRIX:\n");
					
					if(firstMatrix != null) {
						System.out.println("INITIATE");
						// initiate multiplication screen
						Multiplication multiplication = new Multiplication(firstMatrix, secondMatrix);
					}
				}
			}
		});

		this.setInputLayoutConstraints(secondSizeLabel, 3, 1);
		this.setInputLayoutConstraints(secondSizeInputField, 3, 2);
		this.setInputLayoutConstraints(secondSizeButton, 3, 3);
		this.setInputLayoutConstraints(secondMatrixLabel, 4, 1);
		this.setInputLayoutConstraints(secondMatrixInputField, 4, 2);
		this.setInputLayoutConstraints(secondMatrixButton, 4, 3);
		
		this.inputContainer.add(secondSizeLabel);
		this.inputContainer.add(secondSizeInputField);
		this.inputContainer.add(secondSizeButton);
		this.inputContainer.add(secondMatrixLabel);
		this.inputContainer.add(secondMatrixInputField);
		this.inputContainer.add(secondMatrixButton);
	}
	
	/**
	 * @param input
	 * @param label
	 * @return
	 */
	private int buildMatrixSize(String input, JLabel sizeLabel, JLabel matrixLabel) {
		String stringMatrixSize = input;

		int matrixSize = 0;
		try {
				matrixSize = Integer.parseInt(stringMatrixSize);
			} catch (NumberFormatException e) {
				System.out.println("Please enter a matrix size larger than 0.");
			}
		
		if(matrixSize > 0) {
			sizeLabel.setText("Good job, human. We shall proceed to the next step...");
			matrixLabel.setText("Enter the elements of the matrix " + matrixSize + "*" + matrixSize);
		}
		
		return matrixSize;
	}
	
	private float[][] buildMatrix(String input, JLabel label) {
		System.out.println("Building the matrix...");
		float[][] matrix = new float[this.matrixSize][this.matrixSize];
		label.setText("Matrix added.");
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
		System.out.println("Matrix build.");
		this.displayMatrix(matrix);
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
	
	private void displayMatrix(float[][] matrix) {
		for(int i = 0; i < this.matrixSize; ++i) {
			for(int j = 0; j < this.matrixSize; ++j) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
