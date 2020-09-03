package paiza;

import java.util.*;

public class Recipe {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int howManyRecipe = sc.nextInt();
			int numberOfMenu = 0;
			Map<String, Integer> recipe = new HashMap<>();
			for(int i=0;i<howManyRecipe;i++) {
				String name = sc.next();
				int value = sc.nextInt();
				recipe.put(name,value);
			}
			int HowManyFoodstuff = sc.nextInt();
			Map<String,Integer> foodstuff = new HashMap<>();
			for(int i=0;i<HowManyFoodstuff;i++) {
				String name = sc.next();
				int value = sc.nextInt();
				foodstuff.put(name,value);
			}
			numberOfMenu = serchFoodstuff(recipe, foodstuff, numberOfMenu, howManyRecipe);
			System.out.println(numberOfMenu);
		}
	}


	public static int serchFoodstuff (Map<String, Integer>recipe,Map<String, Integer>foodstuff,int numberOfMenu, int howManyRecipe) {
		int check = 0;
		for (String key : recipe.keySet()) {
			if(foodstuff.containsKey(key)) {
				int recipeSize = recipe.get(key);
				int foodstuffSize = foodstuff.get(key);
				int result = foodstuffSize - recipeSize;
				foodstuff.put(key,result);
				if(result >= 0) {
					check++;
				}
			}
		}
		if(check == howManyRecipe) {
			numberOfMenu++;
			return serchFoodstuff(recipe, foodstuff, numberOfMenu, howManyRecipe);
		}
		return numberOfMenu;
	}
}