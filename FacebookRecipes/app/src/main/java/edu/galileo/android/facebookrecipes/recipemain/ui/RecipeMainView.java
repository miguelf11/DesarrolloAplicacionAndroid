package edu.galileo.android.facebookrecipes.recipemain.ui;

import edu.galileo.android.facebookrecipes.entities.Recipe;

/**
 * Created by Miguel on 03-07-2016.
 */
public interface RecipeMainView {

    void showProgress();
    void hideProgress();
    void showUIElements();
    void hideUIElements();
    void saveAnimation();
    void dismissAnimation();

    void onRecipeSaved();

    void setRecipe(Recipe recipe);
    void onGetRecipeError(String error);



}
