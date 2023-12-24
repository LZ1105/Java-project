package course.object_as_superclass;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

public class ObjectAsSuperclassDemo {
	
	int a = 10;
	
	final protected void doTask(int n, String s, long m) {
		System.out.println("doTask: n = " + n + ", s = " + s + ", m = " + m + ", a = " + a);
	}
	
	public ObjectAsSuperclassDemo(int a) {
		this.a = a;
	}

	public static void main(String[] args) {
		ObjectAsSuperclassDemo object = new ObjectAsSuperclassDemo(20);
		try {
			Class clazz = object.getClass();
			System.out.println("Class type: " + clazz.getName());
			System.out.println("Fields:");
			Field fields[] = clazz.getDeclaredFields();
			for (Field field : fields) {
				String fieldName = field.getName();
				Class fieldType = field.getType();
				System.out.printf("  %s: %s\n", fieldType.getName(), field.get(object));
				if ("a".equals(fieldName)) {
					field.setInt(object, 30);
				}
			}
			System.out.println("Methods:");
			Method methods[] = clazz.getDeclaredMethods();
			for (Method method : methods) {
				String methodName = method.getName();
				Parameter params[] = method.getParameters();
				Class returnType = method.getReturnType();
				int modifier = method.getModifiers();
				System.out.printf("%s %s %s(%s)\n", modifierStr(modifier), returnType.getName(), methodName, paramsStr(params));
				if (methodName.equals("doTask")) {
					method.invoke(object, 123, "Task name", 9901L);
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
//		int modifiers[] = {Modifier.ABSTRACT, Modifier.FINAL, Modifier.INTERFACE, Modifier.NATIVE, Modifier.PRIVATE, Modifier.PROTECTED, Modifier.PUBLIC, Modifier.STATIC, 
//				Modifier.STRICT, Modifier.SYNCHRONIZED, Modifier.TRANSIENT, Modifier.VOLATILE};
//		for (int m : modifiers) {
//			System.out.printf("%04X\n", m);
//		}
//		int b1 		= 0b01101101;
//		int b2 		= 0b01010110;
//		int b1ORb2	= 0b01111111;
//		int b1ANDb2 = 0b01000100;
//		System.out.println("b1 & b2 = "+ Integer.toBinaryString(b1 & b2));
//		System.out.println("b1 | b2 = "+ Integer.toBinaryString(b1 | b2));
//		System.out.println("NOT(b1) = "+ Integer.toBinaryString(~b1));

	}
	
	private static String paramsStr(Parameter[] params) {
		String result = "";
		
		for(Parameter p : params) {
			Type type = p.getParameterizedType();
			String name = p.getName();
			result += type.getTypeName() + " " + name + ", "; // Assignment: remove the last ", "
		}
		return result;
	}

	static int MODIFIERS[] = {Modifier.ABSTRACT, Modifier.FINAL, Modifier.INTERFACE, Modifier.NATIVE, Modifier.PRIVATE, Modifier.PROTECTED, Modifier.PUBLIC, Modifier.STATIC, 
			Modifier.STRICT, Modifier.SYNCHRONIZED, Modifier.TRANSIENT, Modifier.VOLATILE};

	static String MODIFIER_NAMES[] = {"abstract", "final", "interface", "native", "private", "protected", "public", "static", 
			"strict", "synchronized", "transient", "vilotile"};

	private static String modifierStr(int modifier) {
//		return Integer.toString(modifier);
		String result = "";
		// relation: AND (&&), OR(||), NOT(!)
		// bitwise: AND(&), OR(|), NOT(^)
		for (int i = 0; i < MODIFIERS.length; i++) {
			if ((modifier & MODIFIERS[i]) != 0) {
				result += MODIFIER_NAMES[i] + " "; // Assignment: remove the last extra space " "
			}
		}
		// Assignment: use bitwise-shift to implement the same logic as above.
		return result;
	}

}
