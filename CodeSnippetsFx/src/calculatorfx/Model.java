package calculatorfx;


public class Model {
	
	public static float calculate(long number1, long number2, String operator) {
		
		switch (operator) {
			case "*":
				return number1 * number2;
			case "-":
				return number1 - number2;
			case "+":
				return number1 + number2;
			case "/":
				if (number2 != 0) // divider must be != 0
					return number1 / number2;
			default:
				return 0;
		}
	}
	
}
