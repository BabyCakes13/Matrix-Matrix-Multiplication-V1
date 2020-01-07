package items;

public class Cell {
	private float sum;
	
	public Cell(float sum) {
		this.sum = sum;
	}
	
	public float getSum() {
		return this.sum;
	}
	
	public float computeSum(float aInput, float bInput) {
		this.sum = sum + aInput*bInput;
		return this.sum;
	}
	
	@Override
	public String toString() {
		return "Cell[" + this.sum + "]";
	}
}
