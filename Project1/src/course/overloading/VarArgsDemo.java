package course.overloading;

public class VarArgsDemo {

	public static void main(String[] args) {
		
		VarArgsDemo demo = new VarArgsDemo();
		
		int numbers[] = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		int result = 0;
//		for (int i = 0; i < numbers.length; i++) {
//			result = demo.add(result, numbers[i]);
//		}
		result = demo.add(numbers);
		result = demo.add(new int[] {10, 20, 30});
		result = demo.add(10, 20, 30, 40, 50, 60);
		result = demo.add(10, 20);
		System.out.println("result = " + result);

	}
	
//	private int add(int nums[]) {
	private int add(int...nums) {
		int r = 0;
		for (int i = 0; i < nums.length; i++) {
			r += nums[i];
		}
		return r;
	}
	private int add(int num1, int num2) {
		return num1 + num2;
	}

	private int add(int num1, int num2, int num3) {
		return num1 + num2 + num3;
	}
	
}
