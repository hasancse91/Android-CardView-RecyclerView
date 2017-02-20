package co.megaminds.CardViewRecyclerViewPicasso.Interface;

import co.megaminds.CardViewRecyclerViewPicasso.Model.JsonData;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("data.json")
    Call<JsonData> apiCall();

}

