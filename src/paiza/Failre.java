package paiza;

import java.util.*;

public class Failre {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int student = sc.nextInt();
			int failure = sc.nextInt();
			int[][] students = new int[student][3];
			int[] studentsResult = new int[student];
			int minPointPeople = 0;
			int ofject = 0;
			for(int i=0;i<student;i++) {
				students[i][0] = sc.nextInt();
				students[i][1] = sc.nextInt();
				students[i][2] = sc.nextInt();
			}
			for(int i=0;i<3;i++) {
				ofject = i;
				studentsResult = searchFailure(students, studentsResult, failure, ofject, minPointPeople, student);
			}

			for(int i:studentsResult) {
				System.out.println(i);
			}
		}

	}

	public static int[] searchFailure(int[][]students,int[]studentsResult,int failure,int ofject,int minPointPeople,int student) {
		int minPoint = calcMinPoint(students, ofject, student);
		minPointPeople +=  calcMinPointPeople(students, ofject, student, minPoint);
		students = scoring(students, studentsResult, minPoint, ofject);
		if(failure > minPointPeople) {
			return searchFailure(students, studentsResult, failure, ofject, minPointPeople, student);
		}
		return studentsResult;
	}

	public static int calcMinPoint(int[][] students,int ofject,int student){
		int minPoint = 100;
		for(int i=0;i<student;i++) {
			if(minPoint > students[i][ofject]) {
				minPoint = students[i][ofject];
			}
		}
		return minPoint;
	}

	public static int calcMinPointPeople(int[][]students,int ofject,int student,int minPoint) {
		int minPointPeople = 0;
		for(int i=0;i<student;i++) {
			if(minPoint == students[i][ofject]) {
				minPointPeople++;
			}
		}
		return minPointPeople;
	}

	public static int[][] scoring(int[][]students,int[]studentsResult,int minPoint,int ofject){
		for(int i=0;i<students.length;i++) {
			if(minPoint == students[i][ofject]) {
				students[i][ofject] = 101;
				studentsResult[i]++;
			}
		}
		return students;
	}

}