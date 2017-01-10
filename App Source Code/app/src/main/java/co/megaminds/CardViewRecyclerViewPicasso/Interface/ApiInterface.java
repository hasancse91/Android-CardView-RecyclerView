package co.megaminds.CardViewRecyclerViewPicasso.Interface;

import co.megaminds.CardViewRecyclerViewPicasso.Model.JsonData;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("u/82144031/All%20Public%20JSON%20API/CardView-RecyclerView-Picasso-Test/cardView_recyclerView_picasso_test.json")
    Call<JsonData> apiCall();

}

