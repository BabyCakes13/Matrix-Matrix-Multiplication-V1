package input_gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import gui.Container;
import gui.GUIController;
import multiplication.Multiplication;

public class InputContainer extends Container{
	private JPanel inputContainer;
	private float[][] firstMatrix, secondMatrix;
	private int matrixSize;
	private int versionSelected;
	private ButtonGroup radioButtonGroup;
	
	public InputContainer(MatrixDisplayContainer equationContainer, JFrame frame, String containerTitle) {
		super(frame, containerTitle);
		this.inputContainer = this.container;
		this.radioButtonGroup = new ButtonGroup();
		versionSelected = 0;
		
		this.addCoefficients(equationContainer);
		this.createRadioButtons();
		
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
		JLabel firstSizeLabel = new JLabel();
		firstSizeLabel.setText("Matrix size:");
		JTextField firstSizeInputField = new JTextField(10);
		firstSizeInputField.setText("2");
		JButton sizeButton = new JButton("FIRST MATRIX SIZE");

		JLabel firstMatrixLabel = new JLabel();
		firstMatrixLabel.setText("Matrix:");
		JTextField firstMatrixInputField = new JTextField(10);
		firstMatrixInputField.setText("1, 2, 3, 4");
		
		sizeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputValue = firstSizeInputField.getText();
				int matrixSize = buildMatrixSize(inputValue, firstSizeLabel, firstMatrixLabel);
				setMatrixSize(matrixSize);
			}
		});

		this.setInputLayoutConstraints(firstSizeLabel, 1, 1);
		this.setInputLayoutConstraints(firstSizeInputField, 1, 3);
		this.setInputLayoutConstraints(firstMatrixLabel, 2, 1);
		this.setInputLayoutConstraints(firstMatrixInputField, 2, 3);
		
		this.inputContainer.add(firstSizeLabel);
		this.inputContainer.add(firstSizeInputField);
		this.inputContainer.add(firstMatrixLabel);
		this.inputContainer.add(firstMatrixInputField);
		
		JLabel secondSizeLabel = new JLabel();
		secondSizeLabel.setText("Matrix size:");
		JTextField secondSizeInputField = new JTextField(10);
		secondSizeInputField.setText("2");
		JButton secondSizeButton = new JButton("SECOND MATRIX SIZE");

		JLabel secondMatrixLabel = new JLabel();
		secondMatrixLabel.setText("Matrix:");
		JTextField secondMatrixInputField = new JTextField(10);
		secondMatrixInputField.setText("5, 6, 7, 8");
		JButton matricesInput = new JButton("SET MATRICES.");
		
		secondSizeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputValue = secondSizeInputField.getText();
				int matrixSize = buildMatrixSize(inputValue, secondSizeLabel, secondMatrixLabel);
				setMatrixSize(matrixSize);
			}
		});
		
		matricesInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstMatrixSizeText = firstSizeInputField.getText();
				String secondMatrixSizeText = secondSizeInputField.getText();
				String firstMatrixText = firstMatrixInputField.getText();
				String secondMatrixText = secondMatrixInputField.getText();
				
				int firstMatrixSize = buildMatrixSize(firstMatrixSizeText, firstSizeLabel, firstMatrixLabel);
				int secondMatrixSize = buildMatrixSize(secondMatrixSizeText, secondSizeLabel, secondMatrixLabel);
				setMatrixSize(firstMatrixSize);
				setMatrixSize(secondMatrixSize);
				
				float[][] firstMatrix = buildMatrix(firstMatrixText, firstMatrixLabel);
				float[][] secondMatrix = buildMatrix(secondMatrixText, secondMatrixLabel);
				
				if((firstMatrix != null) && (secondMatrix != null)) {
					matrixDC.displayMatrix(firstMatrix, "ADDED FIRST MATRIX:\n");
					matrixDC.displayMatrix(secondMatrix, "ADDED SECOND MATRIX:\n");
					
					System.out.println(" first Matrix size: " + firstMatrixSize);
					System.out.println(" second Matrix size: " + secondMatrixSize);
					System.out.println("Matrix size: " + matrixSize);
					
					displayMatrix(firstMatrix);
					displayMatrix(secondMatrix);
					
					System.out.println("VERSION: " + versionSelected);
					Multiplication multiplication = new Multiplication(firstMatrix, secondMatrix, versionSelected);
					GUIController guiController = new gui.GUIController("MATRIX-MATRIX MULTIPLICATION", multiplication);
					System.out.println("MATRICES BEFORE DISPLAY GUI " + multiplication.getFirstMatrix().length + " - " + multiplication.getSecondMatrix().length);
					guiController.displayGUI();
				}
			}
		});

		this.setInputLayoutConstraints(secondSizeLabel, 3, 1);
		this.setInputLayoutConstraints(secondSizeInputField, 3, 3);
		this.setInputLayoutConstraints(secondMatrixLabel, 4, 1);
		this.setInputLayoutConstraints(secondMatrixInputField, 4, 3);
		
		this.inputContainer.add(secondSizeLabel);
		this.inputContainer.add(secondSizeInputField);
		this.inputContainer.add(secondMatrixLabel);
		this.inputContainer.add(secondMatrixInputField);
		
		this.setInputLayoutConstraints(matricesInput, 5, 2);
		this.inputContainer.add(matricesInput);
	} 
	
	private void createRadioButtons() {
		this.addRadioButton("1", 300, 300);
		this.addRadioButton("2", 315, 300);
		this.addRadioButton("3", 330, 300);
	}
	
	private JRadioButton addRadioButton(String option, int a, int b) {
		JRadioButton jRadioButton = new JRadioButton(); 
		jRadioButton .setName(option); 
        jRadioButton.setBounds(a, b, 10, 10); 
        
        this.inputContainer.add(jRadioButton);
        this.radioButtonGroup.add(jRadioButton);
        
        jRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JRadioButton btn = (JRadioButton) e.getSource();
	            versionSelected = Integer.parseInt(btn.getName());
			}
		});
        
        
        return jRadioButton;
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
		System.out.println(this.matrixSize);
		float[][] matrix = new float[this.matrixSize][this.matrixSize];
		label.setText("Matrix added.");
		String[] stringElements = input.split(",");
		
		int stringIndex = 0;
		for(int i = 0; i < this.matrixSize; ++i) {
			for(int j = 0; j < this.matrixSize; ++j) {
				String element = stringElements[stringIndex];
				if(checkNumber(element)) {
					System.out.println("Parsing element " + stringElements[stringIndex]);
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
			System.out.println("Parsing element in checkNumber " + input);
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
