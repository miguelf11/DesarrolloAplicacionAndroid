package edu.galileo.android.facebookrecipes.recipemain.di;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import edu.galileo.android.facebookrecipes.api.RecipeClient;
import edu.galileo.android.facebookrecipes.api.RecipeService;
import edu.galileo.android.facebookrecipes.recipemain.GetNextRecipeInteractor;
import edu.galileo.android.facebookrecipes.recipemain.GetNextRecipeInteractorImpl;
import edu.galileo.android.facebookrecipes.recipemain.RecipeMainPresenter;
import edu.galileo.android.facebookrecipes.recipemain.RecipeMainPresenterImpl;
import edu.galileo.android.facebookrecipes.recipemain.RecipeMainRepository;
import edu.galileo.android.facebookrecipes.recipemain.RecipeMainRepositoryImpl;
import edu.galileo.android.facebookrecipes.recipemain.SaveRecipeInteractor;
import edu.galileo.android.facebookrecipes.recipemain.SaveRecipeInteractorImpl;
import edu.galileo.android.facebookrecipes.recipemain.ui.RecipeMainView;

/**
 * Created by Miguel on 04-07-2016.
 */
@Module
public class RecipeMainModule {

    RecipeMainView view;

    public RecipeMainModule(RecipeMainView view) {
        this.view = view;
    }

    @Provides @Singleton
    RecipeMainView providesRecipeMainView(){
        return this.view;
    }

    @Provides @Singleton
    RecipeMainPresenter providesRecipeMainPresenter(RecipeMainView view,
                                                    GetNextRecipeInteractor getNextInteractor,
                                                    SaveRecipeInteractor saveInteractor,
                                                    EventBus eventBus){

        return new RecipeMainPresenterImpl(view,getNextInteractor,
                                            saveInteractor,eventBus);
    }

    @Provides @Singleton
    SaveRecipeInteractor providesSaveRecipeInteractor(RecipeMainRepository repository){
        return new SaveRecipeInteractorImpl(repository);
    }

    @Provides @Singleton
    GetNextRecipeInteractor providesGetNextRecipeInteractor(RecipeMainRepository repository){
        return new GetNextRecipeInteractorImpl(repository);
    }

    @Provides @Singleton
    RecipeMainRepository providesRecipeMainRepository (EventBus eventBus, RecipeService service){
        return new RecipeMainRepositoryImpl(eventBus,service);
    }


    /*
        esto podría ir en la librería
     */
    @Provides @Singleton
    RecipeService providesRecipeService (){
        return new RecipeClient().getRecipeService();
    }



}
