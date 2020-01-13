package multiplication;

import items.Cell;

public class Multiplication {
	
	private Cell[][] firstMatrix, secondMatrix;
	private Cell[][] previousAOutputs, previousBOutputs;
	private Cell[][] currentAOutputs, currentBOutputs;
	private Cell[][] resultMatrix;
	private Cell[][] cells;
	
	private int matrixSize;
	private float FLUSH_VALUE = Float.NaN; // TODO check if 0 needed instead of NaN
	
	private int totalTimeToRun; // TODO calculate the total time to run;
	private int time;
	
	public Multiplication(float[][] aMatrix, float[][] bMatrix) {
		System.out.println("MULTIPLICATION CONSTRUCTOR BEFORE INITIALISE" + aMatrix.length + " " + bMatrix.length);
		
		this.firstMatrix = this.convertFloatToCell(aMatrix);
		this.secondMatrix = this.convertFloatToCell(bMatrix);
		
		this.matrixSize = aMatrix.length;
		this.totalTimeToRun = this.firstMatrix.length + this.secondMatrix.length; // TODO wrong! Check the actual time.
		this.initialiseResultMatrix();
	}
	
	public Cell[][] getMultiplicationMatrix() {
		return this.resultMatrix;
	}
	
	public Cell[][] getCells() {
		return this.cells;
	}
	
	public Cell[][] getFirstMatrix() {
		return this.firstMatrix;
	}
	
	public Cell[][] getSecondMatrix() {
		return this.secondMatrix;
	}
	
	private Cell[][] convertFloatToCell(float[][] matrix) {
		Cell[][] cellMatrix = new Cell[this.matrixSize][this.matrixSize];
		
		for(int i = 0; i < this.matrixSize; ++i) {
			for(int j = 0; j < this.matrixSize; ++j) {
				float coefficient = matrix[i][j];
				cellMatrix[i][j] = new Cell(coefficient);
			}
		}
		
		return cellMatrix;
	}
	
	/**
	 * Set the sum as 0 for the matrix which will represent the multiplication of aMatrix and bMatrix.}=
	 * @param matrixSize: int: The size of the result matrix.
	 */
	private void initialiseResultMatrix() {
		this.resultMatrix = new Cell[this.matrixSize][this.matrixSize];
		this.previousAOutputs = new Cell[this.matrixSize][this.matrixSize];
		this.previousBOutputs = new Cell[this.matrixSize][this.matrixSize];
		this.cells = new Cell[this.matrixSize][this.matrixSize];
		
		for(int i = 0; i < this.matrixSize; ++i) {
			for(int j = 0; j < this.matrixSize; ++j) {
				this.resultMatrix[i][j] = new Cell(0);
				this.previousAOutputs[i][j] = new Cell(FLUSH_VALUE);
				this.previousBOutputs[i][j] = new Cell(FLUSH_VALUE);
				this.cells[i][j] = new Cell(0);
			}
		}
	}
	
	public void traverseCells(float aInput, float bInput) {
		this.currentAOutputs = new Cell[this.matrixSize][this.matrixSize];
		this.currentBOutputs = new Cell[this.matrixSize][this.matrixSize];
		
		/*
		 * this.previousTimeOutputs.add(0, 0f); // add 0*x for the first ax + b
		 * this.previousTimeXes.add(0, newX); 
		 * TODO NOT NECESSARY because we always have something to feed the first time.
		 */
		
		// TODO implement traverse
		// TODO MATRICES CAN ME OF DIFFERENCT M AND N
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
