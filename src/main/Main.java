package main;

import gui.GUIInput;
import multiplication.Multiplication;

public class Main {

	public static void main(String[] args) {
		/*float[][] aMatrix = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		
		float[][] bMatrix = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};*/
		
		GUIInput guiInput = new GUIInput("Coefficients input.");
		guiInput.displayGUI();
		
		//Multiplication m = new Multiplication(aMatrix, bMatrix);
		//m.displayMatrix(aMatrix);
		//m.displayMatrix(m.getMultiplicationMatrix());
	}
}
