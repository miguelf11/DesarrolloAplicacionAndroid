package edu.galileo.android.facebookrecipes.recipelist.ui;

import java.util.List;

import edu.galileo.android.facebookrecipes.entities.Recipe;

/**
 * Created by Miguel on 04-07-2016.
 */
public interface RecipeListView {
    void setRecipes(List<Recipe> data);
    void recipeUpdate();
    void recipeDeleted(Recipe recipe);

}
