package edu.galileo.android.facebookrecipes.recipelist;

import edu.galileo.android.facebookrecipes.entities.Recipe;

/**
 * Created by Miguel on 04-07-2016.
 */
public class StoredRecipesInteractorImpl implements StoredRecipesInteractor {

    private RecipeListRepository repository;

    public StoredRecipesInteractorImpl(RecipeListRepository repository) {
        this.repository = repository;
    }

    @Override
    public void executeUpdate(Recipe recipe) {
        repository.updateRecipe(recipe);
    }

    @Override
    public void executeDelete(Recipe recipe) {
        repository.removeRecipe(recipe);
    }
}
