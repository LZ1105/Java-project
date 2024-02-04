package course.tree.binary_expression;

public class Operand extends Operation {
	
	public int data;
	
	public Operand(int data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return " " + Integer.toString(data) + " ";
	}

	@Override
	public int evaluate() {
		return data;
	}

}
