// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
		// Tests some of the operations
		/*
		 * System.out.println(plus(2,3)); // 2 + 3
		 * System.out.println(minus(7,2)); // 7 - 2
		 * System.out.println(minus(2,7)); // 2 - 7
		 * System.out.println(times(3,4)); // 3 * 4
		 * System.out.println(plus(2,times(4,2))); // 2 + 4 * 2
		 * System.out.println(pow(5,3)); // 5^3
		 * System.out.println(pow(3,5)); // 3^5
		 * System.out.println(div(12,3)); // 12 / 3
		 * System.out.println(div(5,5)); // 5 / 5
		 * System.out.println(div(25,7)); // 25 / 7
		 * System.out.println(mod(25,7)); // 25 % 7
		 * System.out.println(mod(120,6)); // 120 % 6
		 * System.out.println(sqrt(36));
		 * System.out.println(sqrt(263169));
		 * System.out.println(sqrt(76123));
		 */

		// System.out.println(plus(-5, 3)); // 2 + 3
		// System.out.println(minus(-5, 3));
		// System.out.println(minus(-5, 8));
		// System.out.println(minus(0, 3));
		// System.out.println(minus(9, 3));
		// System.out.println(minus(50, -3));
		// System.out.println(times(5, 3));
		// System.out.println(times(5, -3));
		// System.out.println(times(-5, -3));
		// System.out.println(times(5, 3));
		// System.out.println(times(0, 6));
		// System.out.println(pow(2, 1));
		// System.out.println(pow(2, 2));
		// System.out.println(pow(2, 10));
		// System.out.println(pow(1, 50));
		// System.out.println(pow(2, 0));

		//System.out.println(div(5, 30)); //0
		//System.out.println(div(-5, 30)); //0
		//System.out.println(div(5, -30)); //0
		//System.out.println(div(0, 10)); //0
		//System.out.println(div(10, 0)); //Error -1
		//System.out.println(div(30, 5)); //6
		//System.out.println(div(30, -5)); //-6
		//System.out.println(div(-30, 5)); //-6
		//System.out.println(div(-30, -5)); //6
		//System.out.println(div(5, -5)); //-1
		//System.out.println(div(-5, 5)); //-1
		//System.out.println(div(-5, -5)); //1

		//System.out.println(mod(10, 3));
		//System.out.println(mod(10, 5));
		//System.out.println(mod(3, 7));
		//System.out.println(mod(25,7)); // 25 % 7
		//System.out.println(mod(120,6)); // 120 % 6

		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
		System.out.println(sqrt(76123));
	}

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		// Replace the following statement with your code
		int retNum = 0;
		if (x1 > 0) {
			for (int i = 0; i < x1; i++) {
				retNum++;
			}
		}
		if (x1 < 0) {
			for (int i = 0; i > x1; i--) {
				retNum--;
			}
		}
		if (x2 > 0) {
			for (int i = 0; i < x2; i++) {
				retNum++;
			}
		}
		if (x2 < 0) {
			for (int i = 0; i > x2; i--) {
				retNum--;
			}
		}
		return retNum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// Replace the following statement with your code
		int retNum = 0;
		if (x1 > 0) {
			for (int i = 0; i < x1; i++) {
				retNum++;
			}
		}
		if (x1 < 0) {
			for (int i = 0; i > x1; i--) {
				retNum--;
			}
		}
		if (x2 > 0) {
			for (int i = 0; i < x2; i++) {
				retNum--;
			}
		}
		if (x2 < 0) {
			for (int i = 0; i > x2; i--) {
				retNum++;
			}
		}
		return retNum;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		// Replace the following statement with your code
		int retNum = 0;
		if (x2 > 0) {
			for (int i = 0; i < x2; i++) {
				retNum = plus(retNum, x1);
			}
		}
		if (x2 < 0) {
			for (int i = 0; i > x2; i--) {
				retNum = minus(retNum, x1);
			}
		}
		return retNum;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		// Replace the following statement with your code
		int retNum = 1;
		if (n > 0) {
			for (int i = 0; i < n; i++) {
				retNum = times(retNum, x);
			}
		}

		// TODO: Check if it is valid for X<0, no need since it's int?
		return retNum;
	}

	// Returns the integer part of x1 / x2
	public static int div(int x1, int x2) {
		// Replace the following statement with your code
		// TODO: Fix negative numbers
		int curX1 = x1;
		int cnt = 0;
		if (x2 == 0) { // 5, 0
			System.out.print("Cant divide by zero! ");
			return -1;
		}
		if (x1 == x2) { // 5, 5
			return 1;
		}
		/*
		 * if (x1 < x2 && x2 != 0) {
		 * return 0;
		 * }
		 */
		/*if ((x1 < x2 && x1 > 0 && x2 > 0) || (x1>x2 && x1 < 0 && x2 < 0) || (x1>x2 && x1 > 0 && x2 < 0) || (x1<x2 && x1 < 0 && x2 > 0)) { // 5 30 		-5 -30		5 -30		-5 30 
			return 0;
		}*/

		if (x1>x2 && x2 > 0) { // 30 5
			while (curX1 >= x2) {
			curX1 = minus(curX1, x2);
			cnt++;
			}
		}

		if (x1<x2 && x2 < 0) { // -30 -5
			while (curX1 <= x2) {
			curX1 = minus(curX1, x2);
			cnt++;
			}
		}

		if (x1>x2 && x2 < 0 && plus(x1, x2)>x2) { // 30 -5
			//how to not take -30 5, yet still take 5 -5
			//tried with the  && plus(x1, x2)>x2
			while (curX1 > 0) {
			curX1 = plus(curX1, x2);
			cnt--;
			}
		}

		if (x1<x2 && x2 > 0 && plus(x1, x2)<x2) { // -30 5
			//how to not take -5 30, yet still take -5 5
			while (curX1 < 0) {
			curX1 = plus(curX1, x2);
			cnt--;
			}
		}

		/*else if ((x1 < x2 && x1 > 0 && x2 > 0) || (x1>x2 && x1 < 0 && x2 < 0) || (x1>x2 && x1 > 0 && x2 < 0) || (x1<x2 && x1 < 0 && x2 > 0)) { // 5 30 		-5 -30		5 -30		-5 30 
			return 0;
		}*/

		return cnt;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {

				int curX1 = x1;
		int cnt = 0;
		if (x2 == 0) { // 5, 0
			System.out.print("Cant divide by zero! ");
			return -1;
		}
		if (x1 == x2) { // 5, 5
			return 0;
		}
		/*
		 * if (x1 < x2 && x2 != 0) {
		 * return 0;
		 * }
		 */
		/*if ((x1 < x2 && x1 > 0 && x2 > 0) || (x1>x2 && x1 < 0 && x2 < 0) || (x1>x2 && x1 > 0 && x2 < 0) || (x1<x2 && x1 < 0 && x2 > 0)) { // 5 30 		-5 -30		5 -30		-5 30 
			return 0;
		}*/

		if (x1>x2 && x2 > 0) { // 30 5
			while (curX1 >= x2) {
			curX1 = minus(curX1, x2);
			cnt++;
			}
		}

		if (x1<x2 && x2 < 0) { // -30 -5
			while (curX1 <= x2) {
			curX1 = minus(curX1, x2);
			cnt++;
			}
		}

		if (x1>x2 && x2 < 0 && plus(x1, x2)>x2) { // 30 -5
			//how to not take -30 5, yet still take 5 -5
			//tried with the  && plus(x1, x2)>x2
			while (curX1 > 0) {
			curX1 = plus(curX1, x2);
			cnt--;
			}
		}

		if (x1<x2 && x2 > 0 && plus(x1, x2)<x2) { // -30 5
			//how to not take -5 30, yet still take -5 5
			while (curX1 < 0) {
			curX1 = plus(curX1, x2);
			cnt--;
			}
		}

		/*else if ((x1 < x2 && x1 > 0 && x2 > 0) || (x1>x2 && x1 < 0 && x2 < 0) || (x1>x2 && x1 > 0 && x2 < 0) || (x1<x2 && x1 < 0 && x2 > 0)) { // 5 30 		-5 -30		5 -30		-5 30 
			return 0;
		}*/

		return curX1;


		// Replace the following statement with your code
		/*int curX1 = x1;
		int cnt = 0;
		if (x2 == 0) {
			System.out.print("Cant divide by zero! ");
			return -1;
		}
		if (x1 < x2 && x2 != 0) {
			return x1;
		}
		while (curX1 >= x2) {
			curX1 = minus(curX1, x2);
			cnt++;
		}
		return curX1;*/
	}

	// Returns the integer part of sqrt(x)
	public static int sqrt(int x) {
		// Replace the following statement with your code
		int powx=0;
		int i=0;
		while(powx<x){
			i++;
			powx=pow(i, 2);
		}
		if (x==pow(i, 2)){ //exactly equals
			return i;
		}else{ //bigger than
			return i-1;
		}
	}
}