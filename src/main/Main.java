package main;

import java.text.*; //For DecimalFormat
import java.util.*; //For Scanner, ArrayList
import java.util.regex.Pattern;

public class Main {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		problemSeventeen();
	}
	
	public static String format(double n, String pattern) {
		DecimalFormat df = new DecimalFormat(pattern);
		return df.format(n);
	}
	
	public static void problemOne() {
		//Power 2
		int position = in.nextInt();
		System.out.println(Integer.highestOneBit(position));
	}
	
	public static void problemTwo() {
		//Betsy's Bird Feeder Problem
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
		//Bonus coupon
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
		//Whatska the Changeska
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
		//Digit Product Sequences
		for (int i = 0; i<5; i++) {
			System.out.print("Enter the start integer and the number of terms to display: ");
			start = in.nextInt();
			k = in.nextInt();
			f(start,1);
		}
	}
	
	public static void problemSix() {
		//Chord Problem
		start = in.nextInt();
		int n = in.nextInt();
		System.out.println(format(chord2(start/(int)(Math.pow(2, n))), "#.#"));
	}
	
	public static void problemSeven() {
		//Primitive Computer
		int[] reg = new int[4];
		reg[0] = 0;
		int iar = in.nextInt();
		for (int i =1; i < 4; i++) reg[i] = in.nextInt();
		int[] op = new int[3];
		int opCode = in.nextInt();
		for (int i = 0; i < 3; i++) op[i] = in.nextInt();
		switch (opCode){
		case 0:
			if (op[2] != 0) {
				reg[op[2]] = op[0] + reg[op[1]];
			}
			iar++;
			break;
		case 1:
			if (op[2] != 0) {
				reg[op[2]] = reg[op[0]] + reg[op[1]];
			}
			iar++;
			break;
		case 2:
			if (reg[op[1]] != reg[op[2]]) {
				iar = op[0];
			} else {
				iar++;
			}
		case 3:
			if (reg[op[1]] == reg[op[2]]) {
				iar = op[0];
			} else {
				iar++;
			}
		}
		System.out.println(iar+" 0 "+reg[1]+" "+reg[2]+" "+reg[3]);
	}
	
	public static void problemEight() {
		//Parens
		// (Hi (Ho To) Bye (Why (Not Do) It))
		String[] input = in.nextLine().split(" ");
		int level = 0;
		for (String s: input) {
			int localLevel = level;
			String word = "";
			for (char c: s.toCharArray()) {
				if(c == '(') {
					level++;
					localLevel++;
				} else if (c == ')') {
					level--;
				} else {
					word += c;
				}
			}
			
			for (int i = 1; i< localLevel; i++) {
				System.out.print("    ");
			}
			System.out.println(word);
		}
	}
	
	public static int problemNine() {
		//Kindergarten Sudoku Checker
		String[] english = {"first", "second", "third", "fourth"};
		char[][] original = new char[4][4];
		for (int i = 0; i<4; i++) {
			original[i] = in.next().toCharArray();
		}
		char[][] inputArray = new char[4][4];
		for (int i = 0; i<4; i++) {
			inputArray[i] = in.next().toCharArray();
			for (int index = 0; index < 4; index++) {
				if (original[i][index] != '.') {
					if (original[i][index] != inputArray[i][index]) {
						System.out.println("The digit "+original[i][index]+" in the "+english[i]+" row and the "+english[index]+
								" column has been changed");
						return 0;
					}
				}
			}
			char[] line = inputArray[i];
			if (!contains(line, '1')) {
				System.out.println("1 not found in the "+english[i]+" row");
				return 0;
			}
			if (!contains(line, '2')) {
				System.out.println("2 not found in the "+english[i]+" row");
				return 0;
			}
			if (!contains(line, '3')) {
				System.out.println("3 not found in the "+english[i]+" row");
				return 0;
			}
			if (!contains(line, '4')) {
				System.out.println("4 not found in the "+english[i]+" row");
				return 0;
			}
		}
		for (int i = 0; i<4; i++) {
			char[] line = {inputArray[0][i],inputArray[1][i],inputArray[2][i],inputArray[3][i]};
			if (!contains(line, '1')) {
				System.out.println("1 not found in the "+english[i]+" column");
				return 0;
			}
			if (!contains(line, '2')) {
				System.out.println("2 not found in the "+english[i]+" column");
				return 0;
			}
			if (!contains(line, '3')) {
				System.out.println("3 not found in the "+english[i]+" column");
				return 0;
			}
			if (!contains(line, '4')) {
				System.out.println("4 not found in the "+english[i]+" column");
				return 0;
			}
		}
		System.out.println("Valid Solution");
		return 0;
	}
	
	public static void problemTen() {
		//Power 3
		String input = Integer.toString(in.nextInt(), 3);
		int index = 0;
		if (input.charAt(0) == '1') {
			index = 1;
		}
		System.out.println((int)Math.pow(3, input.length() - index));
	}
	
	public static void problemEleven() {
		//Fundraiser
		Pattern p = in.delimiter();
		int x,y,z;
		for (int i=0; i < 6; i++){
			in.useDelimiter(""); //Used for taking in one digit of serial at a time
			x=in.nextInt();
			y=in.nextInt();
			z=in.nextInt();
			in.useDelimiter(" ");
			in.nextLine();
			if (isPrime(x) && !isPrime(y) && isPrime(z)) {
				System.out.println("Winner");
			} else { 
				System.out.println("Not a Winner");
			}
			in.useDelimiter(p);
		}
	}
	
	public static void problemTwelve() {
		//Pairs
		ArrayList<String> words = new ArrayList<String>();
		String word;
		while (true) {
			word=in.next();
			if (!word.equals("*")) {
				if (!word.equals("#")) {
					words.add(word);
				}
			} else {
				break;
			}
		}
		ArrayList<String> pairs = getAllLists(words, 2);
		Collections.sort(pairs);
		for (String pair : pairs) {
			System.out.println(pair);
		}
	}
	
	public static void problemThirteen() {
		//Digit Sum Sequences
		for (int i = 0; i<5; i++) {
			System.out.print("Enter the start integer and the number of terms to display: ");
			start = in.nextInt();
			k = in.nextInt();
			g(start,1);
		}
	}
	
	public static void problemFourteen() {
		//Egyptian Multiplication
		int n = in.nextInt();
		int x = in.nextInt();
		ArrayList<String> products = new ArrayList<String>();
		for (int i = 0; Math.pow(2, i-1) < x; i++) {
			System.out.println((int)Math.pow(2, i)*n + " " +(int)Math.pow(2, i));
		}
		while (x != 0) {
			int high = Integer.highestOneBit(x);
			products.add(Integer.toString(high));
			x-=high;
		}
		System.out.println(String.join(x+" is sum of "+" and ", products));
		for (int i = 0; i<products.size(); i++) {
			products.set(i, Integer.toString(Integer.parseInt(products.get(i))*n));
		}
		System.out.println("Product is sum of " + String.join(" and ", products));
	}
	
	public static void problemFifteen() {
		//Simple Computer
		int[] reg = new int[4];
		reg[0] = 0;
		int iar = in.nextInt();
		for (int i =1; i < 4; i++) reg[i] = in.nextInt();
		int[] op = new int[3];
		int opCode = in.nextInt();
		for (int i = 0; i < 3; i++) op[i] = in.nextInt();
		switch (opCode){
		case 0:
			if (op[0] != 0) {
				reg[op[0]] = reg[op[1]] + reg[op[2]];
			}
			iar++;
			break;
		case 1:
			if (op[0] != 0) {
				reg[op[0]] = reg[op[1]] + op[1];
			}
			iar++;
			break;
		case 2:
			if (reg[op[0]] != reg[op[1]]) {
				iar = op[2];
			} else {
				iar++;
			}
		case 3:
			if (reg[op[0]] != reg[op[1]]) {
				iar = op[2];
			} else {
				iar++;
			}
		}
		System.out.println(iar+" 0 "+reg[1]+" "+reg[2]+" "+reg[3]);
	}
	
	public static void problemSixteen() {
		//New List Form
		//Oh1 No2 Not3 This2 Why1 Yes2
		String[] input = in.nextLine().split(" ");
		int level = 0;
		for (String s: input) {
			String word = "";
			for (char c: s.toCharArray()) {
				if ("0123456789".contains(Character.toString(c))) {
					level=c-'0';
				} else {
					word += c;
				}
			}
			
			for (int i = 1; i< level; i++) {
				System.out.print("    ");
			}
			System.out.println(word);
		}
	}
	
	static char[][] sudoku;
	public static void problemSeventeen() {
		sudoku = new char[4][4];
		for (int i =0; i < 4; i++) {
			sudoku[i] = in.nextLine().toCharArray();
		}
		boolean solved = solve(sudoku);
		if (solved) {
			System.out.print("Solution:");
			for (char[] line : sudoku) {
				for (char c : line) System.out.print(c);
				System.out.println();
			}
		} else {
			System.out.println("No Valid Solution");
		}
	}
	 
	public static boolean solve(char[][] board){
	    for(int i=0; i<4; i++){
	        for(int j=0; j<4; j++){
	            if(board[i][j]!='.')
	                continue;
	            for(int k=1; k<=4; k++){
	                board[i][j] = (char) (k+'0');
	                if(isValid(board, i, j) && solve(board))
	                    return true;
	                board[i][j] = '.';    
	            }
	 
	            return false;
	        }
	    }
	 
	    return true; // does not matter
	}
	 
	public static boolean isValid(char[][] board, int i, int j){
	    HashSet<Character> set = new HashSet<Character>();
	 
	    for(int k=0; k<4; k++){
	        if(set.contains(board[i][k]))
	            return false;
	 
	        if(board[i][k]!='.' ){
	            set.add(board[i][k]);
	        }
	    }
	 
	    set.clear();
	 
	    for(int k=0; k<4; k++){
	        if(set.contains(board[k][j]))
	            return false;
	 
	        if(board[k][j]!='.' ){
	            set.add(board[k][j]);
	        }
	    }
	 
	    set.clear();
	 
	    for(int m=0; m<2; m++){
	        for(int n=0; n<2; n++){
	            int x=i/2*2+m;
	            int y=j/2*2+n;
	            if(set.contains(board[x][y]))
	                return false;
	 
	            if(board[x][y]!='.'){
	                set.add(board[x][y]);
	            }    
	        }
	    }
	 
	    return true;
	}

	
	public static void g(int n, int i) {
		int sum = 0;
		int copyN = n;
		while (copyN > 0) {
			int digit = copyN % 10;
			sum += digit;
			copyN = (int)Math.floor((double)copyN / 10d);
		}
		if (i<k) {
			System.out.print(n+", ");
			g(n+sum, i+1);
		} else {
			System.out.println(n);
		}
	}
	
	public static boolean contains(char[] array, char item) {
		for (char c : array) {
			if (c == item) return true;
		}
		return false;
	}
	
	public static ArrayList<String> getAllLists(ArrayList<String> words, int lengthOfList) {
	    ArrayList<String> allLists = new ArrayList<String>();
	    if(lengthOfList == 1) { return words; 
	    } else {
	        ArrayList<String> allSublists = getAllLists(words, lengthOfList - 1);
	        for(int i = 0; i < words.size(); i++){
	            for(int j = 0; j < allSublists.size(); j++){
	                allLists.add(words.get(i) +" "+ allSublists.get(j));
	            }
	        }
	        return allLists;
	    }
	}
	
	public static double chord1(double x) {
		double r = 3438;
		System.out.println("chord 1 x:"+x+" chord:"+(int)Math.sqrt(Math.pow(2*r,2)-Math.pow(chord2(x), 2)));
		return Math.sqrt(Math.pow(2*r,2)-Math.pow(chord2(x), 2));
	}
	
	public static double chord2(double x) {
		double r = 3438;
		if (x == 60) {
			return r;
		} else if (x == 90) {
			return 4862;
		}
		System.out.println("chord 2 x:"+x+" chord:"+(int)Math.sqrt(r*(2*r - chord1(2*x))));
		return Math.sqrt(r*(2*r - chord1(2*x)));
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
