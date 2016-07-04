package edu.galileo.android.facebookrecipes.recipelist;

import com.raizlabs.android.dbflow.list.FlowCursorList;

import org.greenrobot.eventbus.EventBus;

import java.util.Arrays;
import java.util.List;

import edu.galileo.android.facebookrecipes.entities.Recipe;
import edu.galileo.android.facebookrecipes.recipelist.events.RecipeListEvent;

/**
 * Created by Miguel on 04-07-2016.
 */
public class RecipeListInteractorImpl implements RecipeListInteractor{

    private RecipeListRepository repository;

    public RecipeListInteractorImpl(RecipeListRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        repository.getSavedRecipes();
    }
}
