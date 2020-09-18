package paiza;

import java.util.Arrays;
import java.util.Scanner;

public class Combination {
	private int[] elements;
	public int[] test;
	private static int border;
	public static int anser = 0;
	public static int borderCheck = 0;
	public static int totalDifference = 0;

	public Combination(int[] elements,int[] test,int border) {
		super();
		this.elements = elements;
		this.test =  test;
		Combination.border = border;
	}

	public void print(int r) {
		int c = this.elements.length;
		if (r < 0 || r > c) {
			throw new IllegalArgumentException();
		}
		printRecursively(c, r, new Integer[r], 0, 0);
	}

	private void printRecursively(int c, int r, Integer[] determined,
			int determining, int currentIndex) {
		if (determining == r) {
			int check=0;
			for(int i=0;i<c;i++) {
				if(!(Arrays.asList(determined).contains(i))) {
					test[check] = i;
					check++;
				}
			}
			System.out.print(Arrays.toString(determined));
			System.out.println(Arrays.toString(test));
			totalDifference = 0;
			for(int i=0;i<test.length;i++) {
				comparisionOfSize(determined[i], test[i]);
			}
			if(totalDifference <= border) {
				anser++;
			}
			return;
		}

		if (r - determining > c - currentIndex) {
			return;
		}
		for (int i = currentIndex; i < c; i++) {
			determined[determining] = this.elements[i];
			printRecursively(c, r, determined, determining + 1, i + 1);
		}
	}

	public static void comparisionOfSize(int first,int second) {
		if(first > second) {
			judgeBorder(first,second);
		}else {
			judgeBorder(second,first);
		}
	}

	public static void judgeBorder(int first,int second) {
		totalDifference += first - second;
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int item = sc.nextInt();
			int total = item * 2;
			int border = sc.nextInt();
			int[] elements = new int[total];
			for(int i=0;i<total;i++) {
				elements[i] = i;
			}
			int[] test = new int[item];
			Combination combination = new Combination(elements,test,border);
			combination.print(item);
		}
		System.out.println(anser);
	}
}