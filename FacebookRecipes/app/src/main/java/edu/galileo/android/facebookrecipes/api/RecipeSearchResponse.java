package edu.galileo.android.facebookrecipes.api;

import java.util.List;

import edu.galileo.android.facebookrecipes.entities.Recipe;

/**
 * Created by Miguel on 28-06-2016.
 */
public class RecipeSearchResponse {

    /*
        la respuesta incluye un conteo de cuantas recetas tenemos de
        respuesta, puede ser 1 o 0 ya que enviamos un valor aleatorio y el
        listado de esta receta
     */

    private int count;
    private List<Recipe> recipes;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public Recipe getFirstRecipe(){
        Recipe first = null;
        if (!recipes.isEmpty()){
            first = recipes.get(0);
        }
        return  first;
    }
}
