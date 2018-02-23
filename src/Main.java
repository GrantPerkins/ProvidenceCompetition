import java.text.*; //For DecimalFormat
import java.util.*; //For Scanner, ArrayList
import java.util.regex.Pattern;

public class Main {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		problemThree();
	}
	
	public static String format(double n, String pattern) {
		DecimalFormat df = new DecimalFormat(pattern);
		return df.format(n);
	}
	
	public static void problemOne() {
		int position = in.nextInt();
		System.out.println(Integer.highestOneBit(position));
	}
	
	public static void problemTwo() {
		System.out.print("Enter number of feeders: ");
		int numberOfFeeders = in.nextInt();
		double[] feeders = new double[numberOfFeeders];
		
		System.out.println("Enter the amount of seed each feeder holds (in cups)");
		for (int i = 0; i < numberOfFeeders; i++) {
			feeders[i] = in.nextDouble();
		}
		
		System.out.println("Enter how empty each feeder is, as a decimal no bigger than 1:");
		double sum = 0;
		for (int i = 0; i < numberOfFeeders; i++) {
			double next = in.nextDouble();
			sum += feeders[i] * next;
		}
		String s = format(sum, "#.#");
		System.out.format("Betsy will use %s cups of birdseed to refill the feeders", s);
	}
	
	public static void problemThree() {
		Pattern p = in.delimiter();
		int x,y,z;
		for (int i=0; i < 6; i++){
			in.useDelimiter(""); //Used for taking in one digit of serial at a time
			x=in.nextInt();
			y=in.nextInt();
			z=in.nextInt();
			in.useDelimiter(" ");
			in.nextLine();
			if (!isPrime(x) && isPrime(y) && isPrime(z)) {
				System.out.println(30);
			} else {
				System.out.println(20);
			}
			in.useDelimiter(p);
		}
	}
	
	public static boolean isPrime(int n) {
		if (n<2) return false;
		for (int  i = 2; i <= Math.round(Math.sqrt(n)); i++) {
			if (n%i==0) return false;
		}
		return true;
	}
}
