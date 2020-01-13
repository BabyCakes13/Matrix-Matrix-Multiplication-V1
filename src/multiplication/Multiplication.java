package multiplication;

import items.Cell;

public class Multiplication {
	
	private float[][] firstMatrix, secondMatrix, zeroMatrix;
	private float[][] previousAOutputs, previousBOutputs;
	private float[][] currentAOutputs, currentBOutputs;
	private float[][] previousCOutputs, currentCOutputs;
	
	private float[][] resultMatrix;
	
	private Cell[][] cells;
	
	private int matrixSize;
	private float FLUSH_VALUE =  0;//Float.NaN; // TODO check if 0 needed instead of NaN
	
	private int totalTimeToRun; // TODO calculate the total time to run;
	private int time;
	
	private int variant = 1;
	
	public Multiplication(float[][] aMatrix, float[][] bMatrix) {
		System.out.println("MULTIPLICATION CONSTRUCTOR BEFORE INITIALISE" + aMatrix.length + " " + bMatrix.length);
		
		this.firstMatrix = aMatrix; // this.convertFloatToCell(aMatrix);
		this.secondMatrix = bMatrix; // this.convertFloatToCell(bMatrix);
		
		this.matrixSize = aMatrix.length;
		this.totalTimeToRun = this.firstMatrix.length + this.secondMatrix.length; // TODO wrong! Check the actual time.
		this.time = 0;
		this.initialiseResultMatrix();
		
		this.startTraversing();
	}
	
	public float[][] getMultiplicationMatrix() {
		return this.resultMatrix;
	}
	
	public Cell[][] getCells() {
		return this.cells;
	}
	
	public float[][] getFirstMatrix() {
		return this.firstMatrix;
	}
	
	public float[][] getSecondMatrix() {
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
		this.previousCOutputs = new float[this.matrixSize][this.matrixSize];
		this.previousAOutputs = new float[this.matrixSize][this.matrixSize];
		this.previousBOutputs = new float[this.matrixSize][this.matrixSize];
		this.cells = new Cell[this.matrixSize][this.matrixSize];
		
		for(int i = 0; i < this.matrixSize; ++i) {
			for(int j = 0; j < this.matrixSize; ++j) {
				this.previousCOutputs[i][j] = 0F;
				this.previousAOutputs[i][j] = FLUSH_VALUE;
				this.previousBOutputs[i][j] = FLUSH_VALUE;
				this.cells[i][j] = new Cell(0);
			}
		}
	}
	
	public void startTraversing() {
		
		int traverseTime = this.firstMatrix.length*2; // to handle delays
		for(int i = 0; i < traverseTime; ++i) {
			traverseCells();
			this.time++;
		}
	}
	
	public float[][] propagateHorizontal(float[][] feedData, 
										 float[][] horizontalData, int time) {
		for (int i = this.matrixSize - 1; i >= 0; --i) {
			float inputOnRowI;
			
			if((this.time - i) < 0) {
				inputOnRowI = FLUSH_VALUE;
			} else if((this.time - i ) >= this.matrixSize) {
				inputOnRowI = FLUSH_VALUE;
			} else {
				inputOnRowI = feedData[i][this.time - i];
			}
			
			// TODO: get Result:  a_res[i] = stateData[i][this.matrixSize - 1];
			for (int j = this.matrixSize - 1; j >= 1; --j) {
				horizontalData[i][j] = horizontalData[i][j - 1]; 
			}
			horizontalData[i][0] = inputOnRowI;
		}
		
		return horizontalData;
	}
	
	public float[][] propagateVertical(float[][] feedData, 
			 float[][] verticalData, int time) {
		for (int j = this.matrixSize - 1; j >= 0; --j) {
			float inputOnColumnJ;
			
			if((this.time - j) < 0) {
				inputOnColumnJ = FLUSH_VALUE;
			} else if((this.time - j ) >= this.matrixSize) {
				inputOnColumnJ = FLUSH_VALUE;
			} else {
				inputOnColumnJ = feedData[this.time - j][j];
			}
			
			// TODO: get Result:  b_res[j] = this.previousBOutputs[this.matrixSize - 1][j];
			for (int i = this.matrixSize - 1; i >= 1; --i) {
				verticalData[i][j] = verticalData[i - 1][j]; 
			}
			verticalData[0][j] = inputOnColumnJ;
		}	
		
		return verticalData;
}
	
	public float[][] retainValue(float[][] stateData) {
		return stateData;
	}
	
	public void traverseCells() {
		if (variant == 1) { 
			this.previousAOutputs = propagateHorizontal(this.firstMatrix, 
														this.previousAOutputs, 
														this.time);
			this.previousBOutputs = propagateVertical(this.secondMatrix, 
					this.previousBOutputs, 
					this.time);
			this.previousCOutputs = retainValue(this.previousCOutputs);
		} else if (variant == 2) {
			this.previousAOutputs = propagateHorizontal(this.firstMatrix, 
					this.previousAOutputs, 
					this.time);
			this.previousBOutputs = retainValue(this.previousBOutputs);
			this.previousCOutputs = propagateVertical(this.zeroMatrix, 
					this.previousCOutputs,
					this.time);
		} else if (variant == 3) {
			this.previousAOutputs = retainValue(this.previousAOutputs);
			this.previousBOutputs = propagateVertical(this.secondMatrix, 
					this.previousBOutputs, 
					this.time);
			this.previousCOutputs = propagateHorizontal(this.zeroMatrix, 
					this.previousCOutputs,
					this.time);
		}
		
		displayMatrix(this.previousAOutputs, "this.previousAOutputs");
		displayMatrix(this.previousBOutputs, "this.previousBOutputs");
		displayMatrix(this.previousCOutputs, "this.previousCOutputs");
		
		this.currentAOutputs = new float[this.matrixSize][this.matrixSize];
		this.currentBOutputs = new float[this.matrixSize][this.matrixSize];
		this.currentCOutputs = new float[this.matrixSize][this.matrixSize];

		for(int i = 0 ; i < this.matrixSize; ++i) {	
			for(int j = 0 ; j < this.matrixSize; ++j) {
				this.currentAOutputs[i][j] = this.cells[i][j].calcA(
						this.previousAOutputs[i][j],
						this.previousBOutputs[i][j], 
						this.previousCOutputs[i][j]);
				this.currentBOutputs[i][j] = this.cells[i][j].calcB(
						this.previousAOutputs[i][j],
						this.previousBOutputs[i][j], 
						this.previousCOutputs[i][j]);
				this.currentCOutputs[i][j] = this.cells[i][j].calcC(
						this.previousAOutputs[i][j],
						this.previousBOutputs[i][j], 
						this.previousCOutputs[i][j]);
			}
		}
		if(variant == 1) {
			this.resultMatrix = this.currentCOutputs;
			this.displayMatrix(resultMatrix, "resultMatrix");
		}
				
		this.previousAOutputs = this.currentAOutputs;
		this.previousBOutputs = this.currentBOutputs;
		this.previousCOutputs = this.currentCOutputs;
	}
	
	public void displayMatrix(float[][] matrix, String name) {
		System.out.println("\nDisplaying matrix..." + name);

		for(int i = 0; i < this.matrixSize; ++i){
			for(int j = 0; j < this.matrixSize; ++j){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
