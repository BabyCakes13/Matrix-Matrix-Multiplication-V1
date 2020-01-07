package multiplication;

public class Multiplication {
	
	private float[][] aMatrix, bMatrix;
	private float[][] mMatrix; // multiplication matrix
	
	public Multiplication(float[][] aMatrix, float[][] bMatrix) {
		this.aMatrix = aMatrix;
		this.bMatrix = bMatrix;
		
		this.initialiseMultiplicationMatrix(this.aMatrix.length);
	}
	
	public float[][] getMultiplicationMatrix() {
		return this.mMatrix;
	}
	
	private void initialiseMultiplicationMatrix(int size) {
		this.mMatrix = new float[size][size];
		
		for(int i = 0; i < size; ++i) {
			for(int j = 0; j < size; ++j) {
				this.mMatrix[i][j] = 0;
			}
		}
	}
	
	public void displayMatrix(float[][] matrix) {
		System.out.println("\nDisplaying matrix...");
		int size = matrix.length;
		for(int i = 0; i < size; ++i){
			for(int j = 0; j < size; ++j){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
