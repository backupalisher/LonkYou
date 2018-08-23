package linkyou.ru.linkyou.ui.users;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import linkyou.ru.linkyou.R;
import linkyou.ru.linkyou.adapters.GuestsAdapter;
import linkyou.ru.linkyou.api.LinkAPI;
import linkyou.ru.linkyou.models.users.guests.GuestsData;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GuestsActivity extends AppCompatActivity {
    private List<GuestsData> guestsDataList;
    private RecyclerView mRecyclerView;
    private GuestsAdapter guestsAdapter;
    private SearchView searchView;

    SharedPreferences sPref;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guests);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        actionBar.setTitle("Просмотры анкеты");

        sPref = getSharedPreferences("mSettings", MODE_PRIVATE);
        token = sPref.getString("token", "");

        guestsDataList = new ArrayList<>();

        mRecyclerView = findViewById(R.id.guestsRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        GuestsAdapter guestsAdapter= new GuestsAdapter(guestsDataList);
        mRecyclerView.setAdapter(guestsAdapter);
        final LinkAPI linkAPI = LinkAPI.retrofit.create(LinkAPI.class);

        final Call<List<GuestsData>> call = linkAPI.getGuests(token);
        call.enqueue(new Callback<List<GuestsData>>() {
            @Override
            public void onResponse(Call<List<GuestsData>> call, Response<List<GuestsData>> response) {
                if (response.isSuccessful()) {
                List<GuestsData> test = response.body();
//                for (int i = 0; i < test.size(); i++){
//                    Log.d("mData", test.get(i).getUser().getName() + ", " + test.get(i).getUser().getBirthday().getAge());
//                    Log.d("mData", test.get(i).getUser().getJob().getProfession());
//                    Log.d("mData", test.get(i).getUser().getJob().getOccupation());
//                    Log.d("mData", test.get(i).getUser().getPhotosCount());
//                    Log.d("mData", test.get(i).getUser().getLocation().getCityName());
//
//                }

                    guestsDataList.addAll(response.body());
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
            public void onFailure(Call<List<GuestsData>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Что-то пошло не так",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
//
//        // Associate searchable configuration with the SearchView
//        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        searchView = (SearchView) menu.findItem(R.id.search)
//                .getActionView();
//        searchView.setSearchableInfo(searchManager
//                .getSearchableInfo(getComponentName()));
//        searchView.setMaxWidth(Integer.MAX_VALUE);
//
//        // listening to search query text change
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                // filter recycler view when query submitted
//                guestsAdapter.getFilter().filter(query);
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String query) {
//                // filter recycler view when text is changed
//                guestsAdapter.getFilter().filter(query);
//                return false;
//            }
//        });
//        return true;
//    }
//
//
//    private void search(SearchView searchView) {
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                if (guestsAdapter != null) {
//                    Log.d("mData", newText);
//                    guestsAdapter.getFilter().filter(newText);
//                }
//                return true;
//            }
//
//        });
//    }


//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.search) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

//    @Override
//    public void onBackPressed() {
        // close search view on back button pressed
//        if (!searchView.isIconified()) {
//            searchView.setIconified(true);
//            return;
//        }
//        super.onBackPressed();
//    }

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
