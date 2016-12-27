package co.megaminds.p1exam.Interface;

import co.megaminds.p1exam.Model.JsonData;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("dummy.php")
    Call<JsonData> apiCall();

}

