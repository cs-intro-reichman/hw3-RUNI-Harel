// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {

	static double epsilon = 0.001; // Approximation accuracy
	static int iterationCounter; // Number of iterations

	// Gets the loan data and computes the periodical payment.
	// Expects to get three command-line arguments: loan amount (double),
	// interest rate (double, as a percentage), and number of payments (int).
	public static void main(String[] args) {
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), the number of periods (n), and the
	// periodical payment.
	private static double endBalance(double loan, double rate, int n, double payment) {
		// Replace the following statement with your code
		double loanTwo=loan;
		for (int i = 0; i < n; i++) {
			loanTwo = loanTwo * rate;
			loanTwo = loanTwo - payment;
			//System.out.println("New loan: " + loanTwo);

		}
		return loanTwo; //thats whats left
	}

	// Uses sequential search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
	public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		// Replace the following statement with your code
		double g = (loan / n);
		//System.out.println("DEBUG RATE PASSED TO SOLVER: " + rate);
		double newRate=1.0+(rate/100.0);
		iterationCounter = 0;
		double newLoan = loan;
		//System.out.println("DEBUG RATE PASSED TO SOLVER: " + newRate);
		while (newLoan > epsilon) {
			newLoan = loan;
			iterationCounter++;
			// System.out.println("G: " + g);
			for (int i = 0; i < n; i++) {
				newLoan = newLoan - g;
				newLoan = newLoan * newRate;
				// System.out.println("New loan: " + newLoan);
				// // i was first adding then substracting which caused the inconsistence
				//newLoan = newLoan - g;
				//System.out.println("New loan: " + newLoan);
			}
			g = g + 0.001;
		}
		g = (g - 0.001);
		//System.out.println("using brute force: " + g);
		//System.out.println("number of iterations: " + iterationCounter);
		iterationCounter--;
		//System.out.println("Whats left: " + endBalance(loan,rate,n,g));
		return g;
	}

	// Uses bisection search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
	public static double bisectionSolver(double loan, double rate, int n, double epsilon) {
		// Replace the following statement with your code
		//TODO: Fix all this
		double l = (loan / n);
		double h = loan;
		double g = (l+h)/2;
		double newRate=1.0+(rate/100.0);
		iterationCounter = 0;
		double newLoan = loan;
		while (h-l>epsilon) {
			for (int i = 0; i < n; i++) {
				newLoan = newLoan - g;
				newLoan = newLoan * newRate;
				// System.out.println("New loan: " + newLoan);
				//newLoan = newLoan - g;
				//System.out.println("New loan: " + newLoan);
			}
			if (newLoan>0) {
				l=g;
			}else{
				h=g;
			}
			g=(h+l)/2;
			newLoan=loan;
			iterationCounter++;
		}
		//System.out.println("Periodical payment, using bi-section search: " + g);
		//System.out.println("number of iterations: " + iterationCounter);
		return g;
	}
}