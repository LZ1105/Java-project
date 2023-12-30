package course.queue_and_stack.arithmatic_ops;

/**
 * An Expression can be a number (num != null, op == exp1 == exp2 == null) 
 * or an expression (num == null, op != null, exp1 != null, exp2 != null) 
 * @author User
 *
 *
 */
public class Expression {
	
	private Operator op = null;
	private Expression exp1 = null, exp2 = null;
	private Integer num = null;
	
	public Expression(Operator op, Expression exp1, Expression exp2) {
		this.op = op;
		this.exp1 = exp1;
		this.exp2 = exp2;
	}
	
	public int calculate() {
		// TODO: implement this method.
		return 0;
	}

	public Expression(Integer num) {
		this.num = num;
	}

	public Operator getOp() {
		return op;
	}

	public Expression getExp1() {
		return exp1;
	}

	public Expression getExp2() {
		return exp2;
	}
	
	public Integer getNum() {
		return num;
	}

	@Override
	public String toString() {
		// TODO: implement this method.
		return super.toString();
	}
}
