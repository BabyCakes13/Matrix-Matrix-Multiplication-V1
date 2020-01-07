package input_gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.Container;

public class InputContainer extends Container{
	private JPanel inputContainer;
	private float[][] aMatrix, bMatrix;
	
	public InputContainer(MatrixDisplayContainer equationContainer, JFrame frame, String containerTitle) {
		super(frame, containerTitle);
		this.inputContainer = this.container;
		
		this.addCoefficients(equationContainer);
		
		frame.add(this.inputContainer);
		frame.pack();
	}
	
	public float[][] getAMatrix() {
		return this.aMatrix;
	}
	
	public float[][] getBMatrix() {
		return this.bMatrix;
	}
	
	private void addCoefficients(MatrixDisplayContainer equationContainer) {
		JLabel addElementsLabel = new JLabel();
		addElementsLabel.setText("Enter the two matrices to be multiplied.");
		JTextField inputField = new JTextField(20);
		JButton addAButton = new JButton("ADD FIRST MATRIX");
		JButton addBButton = new JButton("ADD SECOND MATRIX");
		
		addAButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputValue = inputField.getText();
				/*coefficients = addCoefficients(inputValue, addElementsLabel);

				if(coefficients != null) {
					equationContainer.displayEquation(coefficients);
					Collections.reverse(coefficients);
					// PolynomialEvaluator evaluator = new PolynomialEvaluator(coefficients);
					// GUIController guiController = new gui.GUIController("Polynomial evaluation", evaluator);
					// guiController.displayGUI();
				}*/
			}
		});
		
		addBButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputValue = inputField.getText();
				/*coefficients = addCoefficients(inputValue, addElementsLabel);

				if(coefficients != null) {
					equationContainer.displayEquation(coefficients);
					Collections.reverse(coefficients);
					// PolynomialEvaluator evaluator = new PolynomialEvaluator(coefficients);
					// GUIController guiController = new gui.GUIController("Polynomial evaluation", evaluator);
					// guiController.displayGUI();
				}*/
			}
		});
		
		this.setInputLayoutConstraints(addElementsLabel);
		this.setInputLayoutConstraints(inputField);
		this.setInputLayoutConstraints(addAButton);
		this.setInputLayoutConstraints(addBButton);
		
		this.inputContainer.add(addElementsLabel);
		this.inputContainer.add(inputField);
		this.inputContainer.add(addAButton);
		this.inputContainer.add(addBButton);
	}
	
	private ArrayList<Float> addCoefficients(String input, JLabel label) {
		String[] stringCoefficients = input.split(",");
		ArrayList<Float> coefficients = new ArrayList<Float>();
		
		for(String coefficient:stringCoefficients) {
			if (checkNumber(coefficient)) {
				coefficients.add(Float.parseFloat(coefficient));
			} else {
				label.setText("The coefficients must be numbers.");
				return null;
			}
		}
		
		label.setText("Good job, human. We shall proceed to the next step...");
		return coefficients;
	}
	
	private boolean checkNumber(String input) {
		try {
			Float.parseFloat(input);
		} catch (NumberFormatException e) {
			System.out.println("Please enter a number for x.");
			return false;
		}
		return true;
	}
}
