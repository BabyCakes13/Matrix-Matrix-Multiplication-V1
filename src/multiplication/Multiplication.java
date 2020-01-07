package multiplication;

import items.Cell;

public class Multiplication {
	
	private float[][] aMatrix, bMatrix;
	private float[][] previousAOutputs, previousBOutputs;
	private float[][] currentAOutputs, currentBOutputs;
	private Cell[][] resultMatrix;
	
	private int matrixSize;
	private float FLUSH_VALUE = Float.NaN; // TODO check if 0 needed instead of NaN
	
	private int totalTimeToRun; // TODO calculate the total time to run;
	private int time;
	
	public Multiplication(float[][] aMatrix, float[][] bMatrix) {
		this.aMatrix = aMatrix;
		this.bMatrix = bMatrix;
		
		this.matrixSize = aMatrix.length;
		this.totalTimeToRun = this.aMatrix.length + this.bMatrix.length; // TODO wrong! Check the actual time.
		this.initialiseResultMatrix();
	}
	
	public Cell[][] getMultiplicationMatrix() {
		return this.resultMatrix;
	}
	
	/**
	 * Set the sum as 0 for the matrix which will represent the multiplication of aMatrix and bMatrix.}=
	 * @param matrixSize: int: The size of the result matrix.
	 */
	private void initialiseResultMatrix() {
		this.resultMatrix = new Cell[this.matrixSize][this.matrixSize];
		
		for(int i = 0; i < this.matrixSize; ++i) {
			for(int j = 0; j < this.matrixSize; ++j) {
				this.resultMatrix[i][j] = new Cell(0);
				this.previousAOutputs[i][j] = FLUSH_VALUE;
				this.previousBOutputs[i][j] = FLUSH_VALUE;
			}
		}
	}
	
	public void traverseCells(float aInput, float bInput) {
		this.currentAOutputs = new float[this.matrixSize][this.matrixSize];
		this.currentBOutputs = new float[this.matrixSize][this.matrixSize];
		
		/*
		 * this.previousTimeOutputs.add(0, 0f); // add 0*x for the first ax + b
		 * this.previousTimeXes.add(0, newX); 
		 * TODO NOT NECESSARY because we always have something to feed the first time.
		 */
		
		// TODO implement traverse
	}
	
	public void displayMatrix(Cell[][] matrix) {
		System.out.println("\nDisplaying matrix...");

		for(int i = 0; i < this.matrixSize; ++i){
			for(int j = 0; j < this.matrixSize; ++j){
				System.out.print(matrix[i][j].getSum() + " ");
			}
			System.out.println("");
		}
	}

}
