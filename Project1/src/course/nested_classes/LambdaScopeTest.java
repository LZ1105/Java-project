package course.nested_classes;

public class LambdaScopeTest {
	public int x = 0;

	class FirstLevel {
        public int x = 1;
        void methodInFirstLevel(int x) {
            // The following statement causes the compiler to generate the error "local variables
            // referenced from a lambda expression must be final or effectively final" in statement A:
            // x = 99;
            java.util.function.Consumer<Integer> myConsumer = (y) -> 
            {
                System.out.println("x = " + x); // Statement A
                System.out.println("y = " + y);
                System.out.println("this.x = " + this.x);
                System.out.println("LambdaScopeTest.this.x = " +
                    LambdaScopeTest.this.x);
            };
            this.x = 2;
            LambdaScopeTest.this.x = 100;
            myConsumer.accept(x);
        }
	}
	
	public static void main(String[] args) {
		LambdaScopeTest st = new LambdaScopeTest();
        LambdaScopeTest.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
	}
}
