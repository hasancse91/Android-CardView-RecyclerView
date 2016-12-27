package co.megaminds.p1exam.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import co.megaminds.p1exam.Adapter.HorizontalAdapter;
import co.megaminds.p1exam.HelperClasses.NetworkCheckingClass;
import co.megaminds.p1exam.Interface.ApiInterface;
import co.megaminds.p1exam.Model.JsonData;
import co.megaminds.p1exam.Model.Popular;
import co.megaminds.p1exam.R;
import co.megaminds.p1exam.Retrofit.RetrofitApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Popular> popularList;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.horizontal_recycler_view);
        popularList = Collections.<Popular>emptyList();
        apiInterface = RetrofitApiClient.getClient().create(ApiInterface.class);
        
        if(NetworkCheckingClass.isNetworkAvailable(this))
            fetchData();
        else
            Toast.makeText(this, "No internet Connection", Toast.LENGTH_LONG).show();

    }

    private void fetchData() {



        Call<JsonData> call = apiInterface.apiCall();
        call.enqueue(new Callback<JsonData>() {
            @Override
            public void onResponse(Call<JsonData> call, Response<JsonData> response) {

                JsonData jsonData = response.body();

                popularList = jsonData.getPopular();

                loadRecyclerView();
            }

            @Override
            public void onFailure(Call<JsonData> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();

            }
        });
    }

    private void loadRecyclerView() {
        HorizontalAdapter horizontalAdapter = new HorizontalAdapter(getApplicationContext(), popularList);
        recyclerView.setAdapter(horizontalAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
}
