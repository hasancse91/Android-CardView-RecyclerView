package co.megaminds.CardViewRecyclerViewPicasso.Activity;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import co.megaminds.CardViewRecyclerViewPicasso.Adapter.HorizontalAdapter;
import co.megaminds.CardViewRecyclerViewPicasso.Adapter.VerticalAdapter;
import co.megaminds.CardViewRecyclerViewPicasso.HelperClasses.GridSpacingItemDecoration;
import co.megaminds.CardViewRecyclerViewPicasso.HelperClasses.NetworkCheckingClass;
import co.megaminds.CardViewRecyclerViewPicasso.Interface.ApiInterface;
import co.megaminds.CardViewRecyclerViewPicasso.Model.Datum;
import co.megaminds.CardViewRecyclerViewPicasso.Model.JsonData;
import co.megaminds.CardViewRecyclerViewPicasso.Model.Popular;
import co.megaminds.CardViewRecyclerViewPicasso.R;
import co.megaminds.CardViewRecyclerViewPicasso.Retrofit.RetrofitApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewHorizontal;
    RecyclerView recyclerViewVertical;
    HorizontalAdapter horizontalAdapter;
    VerticalAdapter verticalAdapter;
    List<Popular> popularList;
    List<Datum> dataList;
    ProgressBar progressBar;
    RelativeLayout relativeLayout;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = findViewById(R.id.activity_main);

        recyclerViewHorizontal = findViewById(R.id.horizontal_recycler_view);
        recyclerViewVertical = findViewById(R.id.vertical_recycler_view);
        recyclerViewHorizontal.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerViewVertical.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        progressBar = findViewById(R.id.progressBar);

        popularList = Collections.emptyList();
        dataList = Collections.emptyList();
        apiInterface = RetrofitApiClient.getClient().create(ApiInterface.class);

        if (NetworkCheckingClass.isNetworkAvailable(this)) {
            progressBar.setVisibility(View.VISIBLE);
            fetchData();
        } else {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(this, "No internet Connection", Toast.LENGTH_LONG).show();
        }

    }

    private void fetchData() {

        Call<JsonData> call = apiInterface.apiCall();
        call.enqueue(new Callback<JsonData>() {
            @Override
            public void onResponse(@NonNull Call<JsonData> call, @NonNull Response<JsonData> response) {

                progressBar.setVisibility(View.GONE);

                JsonData jsonData = response.body();

                if (jsonData != null) {
                    popularList = jsonData.getPopular();
                    dataList = jsonData.getData();

                    int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin);

                    //for spacing after every item
                    if (popularList.size() > 0)
                        recyclerViewHorizontal.addItemDecoration(new GridSpacingItemDecoration(popularList.size(), spacingInPixels, true, 0));

                    relativeLayout.setBackgroundColor(Color.parseColor("#3481c1"));

                    horizontalAdapter = new HorizontalAdapter(MainActivity.this, popularList);
                    recyclerViewHorizontal.setAdapter(horizontalAdapter);
                    verticalAdapter = new VerticalAdapter(MainActivity.this, dataList);
                    recyclerViewVertical.setAdapter(verticalAdapter);
                } else {
                    Toast.makeText(MainActivity.this, "JSON body is null", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(@NonNull Call<JsonData> call, @NonNull Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

}