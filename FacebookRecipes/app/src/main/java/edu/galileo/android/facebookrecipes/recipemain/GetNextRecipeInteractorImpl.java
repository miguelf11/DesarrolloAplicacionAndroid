package edu.galileo.android.facebookrecipes.recipemain;

import java.util.Random;

/**
 * Created by Miguel on 03-07-2016.
 */
public class GetNextRecipeInteractorImpl implements GetNextRecipeInteractor {

    RecipeMainRepository repository;

    public GetNextRecipeInteractorImpl(RecipeMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        int recipePage = new Random().nextInt(RecipeMainRepository.RECIPE_RANGE);
        repository.setRecipePage(recipePage);
        repository.getNextRecipe();
    }
}
