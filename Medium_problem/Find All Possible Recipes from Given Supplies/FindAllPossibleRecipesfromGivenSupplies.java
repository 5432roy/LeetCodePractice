package Medium_problem.Find All Possible Recipes from Given Supplies;
/*
 * 2115. Find All Possible Recipes from Given Supplies
 * https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/description/?envType=daily-question&envId=2025-03-21
 * 
 * Key Point: Deadlock will occur if a recipe required itself to make, or two recipes required each other
 * Solution: Similar to backtracking, we set the current recipe to false before we figure out the actual result, if we reach a loop back to same recipe, we can avoid the loop
 * Time Complexity: O(N+M), where N is the lenght of recipes, and M is the length of the ingredients, because we only visit every ingredient once
 */
class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String, List<String>> recipesMap = new HashMap<>();
        HashMap<String, Boolean> seen = new HashMap<>();
        List<String> res = new ArrayList<>();
        int n = recipes.length;

        for(int i = 0; i < n; i++) {
            ArrayList<String> cur = new ArrayList<>();
            for(String ingredient : ingredients.get(i)) {
                cur.add(ingredient);
            }
            recipesMap.put(recipes[i], cur);
        }

        for(String supply : supplies) {
            seen.put(supply, true);
        }

        for(int i = 0; i < n; i++) {
            if(canMake(recipesMap, recipes[i], seen)) {
                res.add(recipes[i]);
            }
        }
        
        return res;
    }

    private boolean canMake(HashMap<String, List<String>> map, String recipe, HashMap<String, Boolean> seen) {
        if(seen.containsKey(recipe)) {
            return seen.get(recipe);
        }

        if(!map.containsKey(recipe)) {
            seen.put(recipe, false);
            return false;
        }
        // System.out.print(recipe + ", ");
        boolean res = true;
        for(String ingredient : map.get(recipe)) {
            seen.put(recipe, false);
            if(canMake(map, ingredient, seen)) {
                seen.put(ingredient, true);
            } else {
                res = false;
                seen.put(ingredient, false);
            }
        }
        seen.put(recipe, res);
        return res;
    }
}
