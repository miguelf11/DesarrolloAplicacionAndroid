package edu.galileo.android.facebookrecipes.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Miguel on 28-06-2016.
 */
public interface RecipeService {
    /*
        esto es un servicio y requiere de un cliente
     */

    @GET("search")
    Call<RecipeSearchResponse> search(@Query("key") String key,
                                      @Query("sort") String sort,
                                      @Query("count") int count,
                                      @Query("page") int page);
}
