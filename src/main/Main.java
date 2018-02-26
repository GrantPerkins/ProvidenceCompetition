package main;

import java.text.*; //For DecimalFormat
import java.util.*; //For Scanner, ArrayList
import java.util.regex.Pattern;

public class Main {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		problemFive();
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
	
	public static void problemFour() {
		int[] answer = {0, 0, 0};
		int zilka = 1;
		int morka = in.nextInt();
		int lotska = in.nextInt()*morka;
		int billka = in.nextInt()*lotska;
		
		int coins[] = {zilka, morka, lotska};
        int n = in.nextInt()%billka;
        
        while (n != 0) {
            for (int i=coins.length - 1 ; i>=0 ; i--) {
                if (coins[i] <= n) {
                    n = n - coins[i];
                    answer[i]++;
                    i++; 
                }
            }
        }
        
        System.out.print("Change is ");
        System.out.print(answer[2]+" lotska, ");
        System.out.print(answer[1]+" morka, ");
        System.out.println(answer[0]+" zilka");
	}
	
	static int start;
	static int k;
	public static void problemFive() {
		for (int i = 0; i<5; i++) {
			System.out.print("Enter the start integer and the number of terms to display: ");
			start = in.nextInt();
			k = in.nextInt();
			f(start,1);
		}

	}
    
	public static void f(int n, int i) {
		int product = 1;
		int copyN = n;
		while (copyN > 0) {
			int digit = copyN % 10;
			if (digit != 0) product *= digit;
			copyN = (int)Math.floor((double)copyN / 10d);
		}
	
		if (i<k) {
			System.out.print(n+", ");
			f(n+product, i+1);
		} else {
			System.out.println(n);
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
