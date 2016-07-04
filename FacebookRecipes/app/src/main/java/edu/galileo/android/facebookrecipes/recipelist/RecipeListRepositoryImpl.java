package edu.galileo.android.facebookrecipes.recipelist;

/**
 * Created by Miguel on 04-07-2016.
 */
public class RecipeListRepositoryImpl implements RecipeListInteractor {

    private RecipeListRepository repository;

    public RecipeListRepositoryImpl(RecipeListRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        repository.getSavedRecipes();
    }
}
