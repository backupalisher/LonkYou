package linkyou.ru.linkyou.ui.users;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import linkyou.ru.linkyou.R;
import linkyou.ru.linkyou.adapters.TopAdapter;
import linkyou.ru.linkyou.api.LinkAPI;
import linkyou.ru.linkyou.models.users.top.TopData;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopActivity extends AppCompatActivity {
    List<TopData> topDataList;
    private RecyclerView mRecyclerView;

    SharedPreferences sPref;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Топ 100");

        sPref = getSharedPreferences("mSettings", MODE_PRIVATE);
        token = sPref.getString("token", "");

        loadDataMale();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    loadDataMale();
                } else {
                    loadDataFemale();
//                    Toast.makeText(getApplicationContext(), tab.getText(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
//                Toast.makeText(getApplicationContext(), tab.getText(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
//                Toast.makeText(getApplicationContext(), tab.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void loadDataFemale(){
        topDataList = new ArrayList<>();

        mRecyclerView = findViewById(R.id.topRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        TopAdapter topAdapter = new TopAdapter(topDataList);
        mRecyclerView.setAdapter(topAdapter);
        final LinkAPI linkAPI = LinkAPI.retrofit.create(LinkAPI.class);

        final Call<List<TopData>> call = linkAPI.getTop("female", token);
        call.enqueue(new Callback<List<TopData>>() {
            @Override
            public void onResponse(Call<List<TopData>> call, Response<List<TopData>> response) {
                if (response.isSuccessful()) {
                    topDataList.addAll(response.body());
                    mRecyclerView.getAdapter().notifyDataSetChanged();

                } else { // Обрабатываем ошибку
                    ResponseBody errorBody = response.errorBody();
                    try {
                        Toast.makeText(getApplicationContext(), errorBody.string(),
                                Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<TopData>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Что-то пошло не так",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadDataMale(){
        topDataList = new ArrayList<>();

        mRecyclerView = findViewById(R.id.topRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        TopAdapter topAdapter = new TopAdapter(topDataList);
        mRecyclerView.setAdapter(topAdapter);
        final LinkAPI linkAPI = LinkAPI.retrofit.create(LinkAPI.class);

        final Call<List<TopData>> call = linkAPI.getTop("male", token);
        call.enqueue(new Callback<List<TopData>>() {
            @Override
            public void onResponse(Call<List<TopData>> call, Response<List<TopData>> response) {
                if (response.isSuccessful()) {
                    topDataList.addAll(response.body());
                    mRecyclerView.getAdapter().notifyDataSetChanged();

                } else { // Обрабатываем ошибку
                    ResponseBody errorBody = response.errorBody();
                    try {
                        Toast.makeText(getApplicationContext(), errorBody.string(),
                                Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<TopData>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Что-то пошло не так",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
