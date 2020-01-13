package items;

public class Cell {
	private float retainValue;
	
	public Cell(float sum) {
		this.retainValue = sum;
	}
	
	public float getSum() {
		return this.retainValue;
	}
	
	
	public float calcA   (float a, float b, float c) {
		return a;
	}
	public float calcB   (float a, float b, float c) {
		return b;
	}
	public float calcC   (float a, float b, float c) {
		return c + a * b;
	}
	
	/*
	
	public float updateSum(float a, float b) {
		this.retainValue = retainValue + a*b;
		return this.retainValue;
	}
	
	public float updateA(float c, float b) {
		c = this.retainValue * b;
		return this.retainValue;
	}
	
	public float updateB(float a, float c) {
		c = this.retainValue * a;
		return this.retainValue;
	}
	*/
	@Override
	public String toString() {
		return "Cell[" + this.retainValue + "]";
	}

	public float getCoefficient() {
		// TODO Auto-generated method stub
		return this.retainValue;
	}
}
