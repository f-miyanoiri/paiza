package paiza;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class FortuneName {
	public static Map<String,Integer> changeWords = new HashMap<>();
	public static int[] firstAnser;
	public static int[] secondAnser;

	public FortuneName(Map<String,Integer> changeWords) {
		FortuneName.changeWords = changeWords;
		FortuneName.firstAnser = new int[1];
		FortuneName.secondAnser = new int[1];
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String firstPerson = sc.next();
		String secondPerson = sc.next();
		Map<String,Integer> changeWords = new HashMap<>();
		String[] english = "abcdefghijklmnopqrstuvwxyz".split("");
		for(int i=1;i<27;i++) {
			changeWords.put(english[i-1],i);
		}
		@SuppressWarnings("unused")
		FortuneName main = new FortuneName(changeWords);
		firstAnser = joinName(firstPerson,secondPerson);
		secondAnser = joinName(secondPerson, firstPerson);
		if(firstAnser[0] > secondAnser[0]) {
			System.out.println(firstAnser[0]);
		}else {
			System.out.println(secondAnser[0]);
		}
	}

	public static int[] joinName(String first,String second) {
		String[] name = (first+second).split("");
		return changeNumberByChar(name);
	}

	public static int[] changeNumberByChar(String[] words) {
		int[] numbers = new int[words.length];
		for(int i=0;i<numbers.length;i++) {
			numbers[i]= changeWords.get(words[i]);
		}
		return fortune(numbers);
	}

	public static int[] fortune(int[] numbers) {
		int number = numbers.length-1;
		int[] comparision = new int[number];
		for(int i=0;i<number;i++) {
			comparision[i] = numbers[i]+numbers[i+1];
			if(comparision[i] >= 101) {
				comparision[i] -= 101;
			}
		}
		if(number == 1) {
			return comparision;
		}else {
			int[]numb = new int[numbers.length-1];
			for(int i=0;i<numb.length;i++) {
				numb[i]= comparision[i];
			}
			return fortune(numb);
		}
	}
}
