package linkyou.ru.linkyou.ui.users;

import android.content.SharedPreferences;
import android.os.Bundle;
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
import linkyou.ru.linkyou.adapters.FavoritesAdapter;
import linkyou.ru.linkyou.api.LinkAPI;
import linkyou.ru.linkyou.models.users.favorites.FavoritesData;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavoritesActivity extends AppCompatActivity {
    List<FavoritesData> favoritesDataList;
    private RecyclerView mRecyclerView;

    SharedPreferences sPref;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Избранные");

        sPref = getSharedPreferences("mSettings", MODE_PRIVATE);
        token = sPref.getString("token", "");

        favoritesDataList = new ArrayList<>();

        mRecyclerView = findViewById(R.id.favoritesRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        FavoritesAdapter favoritesAdapter = new FavoritesAdapter(favoritesDataList);
        mRecyclerView.setAdapter(favoritesAdapter);
        final LinkAPI linkAPI = LinkAPI.retrofit.create(LinkAPI.class);

        final Call<List<FavoritesData>> call = linkAPI.getFavorites(token);
        call.enqueue(new Callback<List<FavoritesData>>() {
            @Override
            public void onResponse(Call<List<FavoritesData>> call, Response<List<FavoritesData>> response) {
                if (response.isSuccessful()) {
                    favoritesDataList.addAll(response.body());
                    mRecyclerView.getAdapter().notifyDataSetChanged();

                    actionBar.setTitle("Избранные " + String.valueOf(response.body().size()));
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
            public void onFailure(Call<List<FavoritesData>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Что-то пошло не так",
                        Toast.LENGTH_SHORT).show();
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
}
