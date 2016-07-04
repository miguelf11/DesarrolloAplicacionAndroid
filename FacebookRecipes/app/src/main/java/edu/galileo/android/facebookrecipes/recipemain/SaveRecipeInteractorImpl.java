package edu.galileo.android.facebookrecipes.recipemain;

import edu.galileo.android.facebookrecipes.entities.Recipe;

/**
 * Created by Miguel on 03-07-2016.
 */
public class SaveRecipeInteractorImpl implements SaveRecipeInteractor{

    RecipeMainRepository repository;

    public SaveRecipeInteractorImpl(RecipeMainRepository repository){
        this.repository = repository;
    }

    @Override
    public void execute(Recipe recipe) {
        repository.saveRecipe(recipe);
    }
}
