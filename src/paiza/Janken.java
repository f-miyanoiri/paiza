package paiza;
import java.util.*;
public class Janken {
	public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			int people = sc.nextInt();
			int rock = 0;
			int paper = 0;
			int scissors = 0;
			for(int i=0;i<people;i++){
			    String type = sc.next();
			    if(type.equals("paper")){
			        paper++;
			    }else if(type.equals("rock")){
			        rock++;
			    }else{
			        scissors++;
			    }
			}
			String anser = judge(people,rock,paper,scissors);
			System.out.println(anser);
		}
    }

    public static String judge(int people,int rock,int paper,int scissors){
        if(people == rock || people == paper || people == scissors){
            return "draw";
        }

        if(rock >= 1 && paper >=1 && scissors >= 1) {
        	return "draw";
        }

        if(rock == 0) {
        	return "scissors";
        }

        if(paper == 0) {
        	return "rock";
        }

        if(scissors == 0) {
        	return "paper";
        }

        return "draw";
    }

}