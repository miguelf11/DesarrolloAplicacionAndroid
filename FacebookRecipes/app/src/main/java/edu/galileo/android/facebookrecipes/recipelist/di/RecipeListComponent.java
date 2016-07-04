package edu.galileo.android.facebookrecipes.recipelist.di;

import javax.inject.Singleton;

import dagger.Component;

import edu.galileo.android.facebookrecipes.libs.di.LibsModule;
import edu.galileo.android.facebookrecipes.recipelist.RecipeListPresenter;
import edu.galileo.android.facebookrecipes.recipelist.ui.adapters.RecipesAdapter;


/**
 * Created by Miguel on 04-07-2016.
 */
@Singleton
@Component(modules = {RecipeListModule.class, LibsModule.class})
public interface RecipeListComponent {

    RecipesAdapter getAdapter();
    RecipeListPresenter getPresenter();

}
