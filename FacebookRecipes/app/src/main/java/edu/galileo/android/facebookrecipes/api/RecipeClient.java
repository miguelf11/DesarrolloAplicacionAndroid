package edu.galileo.android.facebookrecipes.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Miguel on 28-06-2016.
 */
public class RecipeClient {
    private Retrofit retrofit;

    /*
        este objeto puedo
        1- Construirlo en el cliente

        2- Puedo recibirlo como un parámetro en este caso
          lo que haría es inyectarlo al construirlo.

          la diferencia básica es el tipo de prueba que quiero
          realizar sobre el cliente

          si lo recibo como un parámetro el testing va a ser
          más "granular", es decir no puedo realizar pruebas
           internas cambiando por ejemplo a donde hago la
           petición,etc.

     */

    private final static String BASE_URL = "http://food2fork.com/api/";

    public RecipeClient() {
        this.retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
    }

    public RecipeService getRecipeService(){
        return this.retrofit.create(RecipeService.class);
    }
}
