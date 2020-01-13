package items;

public class Cell {
	private float partialSum;
	
	public Cell(float sum) {
		this.partialSum = sum;
	}
	
	public float getSum() {
		return this.partialSum;
	}
	
	public float computeSum(float aInput, float bInput) {
		this.partialSum = partialSum + aInput*bInput;
		return this.partialSum;
	}
	
	@Override
	public String toString() {
		return "Cell[" + this.partialSum + "]";
	}

	public float getCoefficient() {
		// TODO Auto-generated method stub
		return this.partialSum;
	}
}
