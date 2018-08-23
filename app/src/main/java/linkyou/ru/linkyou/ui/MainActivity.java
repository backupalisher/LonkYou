package linkyou.ru.linkyou.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import linkyou.ru.linkyou.R;
import linkyou.ru.linkyou.adapters.UsersDailyAdapter;
import linkyou.ru.linkyou.api.LinkAPI;
import linkyou.ru.linkyou.models.users.user_current.UserCurrentData;
import linkyou.ru.linkyou.models.users.users_daily.UsersDailyData;
import linkyou.ru.linkyou.ui.singin.PromoActivity;
import linkyou.ru.linkyou.ui.users.FavoritesActivity;
import linkyou.ru.linkyou.ui.users.GuestsActivity;
import linkyou.ru.linkyou.ui.users.TopActivity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    SharedPreferences sPref;
    String token;

    List<UsersDailyData> usersDailyDataList;
    private RecyclerView mRecyclerView;

    private NavigationView navigationView;
    private View headerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Люди дня");

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        loadUser();
        loadUsersDailyData();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_exit) {
            sPref = getSharedPreferences("mSettings", MODE_PRIVATE);
            SharedPreferences.Editor ed = sPref.edit();
            ed.remove("token");
            ed.commit();
            Intent intent = new Intent(getApplicationContext(), PromoActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_profile_views) {
            Intent intent = new Intent(getApplicationContext(), GuestsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_favorittes) {
            Intent intent = new Intent(getApplicationContext(), FavoritesActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_top) {
            Intent intent = new Intent(getApplicationContext(), TopActivity.class);
            startActivity(intent);
        }

            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void loadUser(){
        sPref = getSharedPreferences("mSettings", MODE_PRIVATE);
        token = sPref.getString("token", "");

        final LinkAPI linkAPI = LinkAPI.retrofit.create(LinkAPI.class);

        final Call<UserCurrentData> call = linkAPI.getUserCurrent(token);
        call.enqueue(new Callback<UserCurrentData>() {
            @Override
            public void onResponse(Call<UserCurrentData> call, Response<UserCurrentData> response) {
                if (response.isSuccessful()) {
                    UserCurrentData userCurrent = response.body();

                    headerView = navigationView.getHeaderView(0);
                    TextView navUsername = (TextView) headerView.findViewById(R.id.nameTextView);
                    TextView textView = (TextView) headerView.findViewById(R.id.textView);
                    ImageView imageView = (ImageView) headerView.findViewById(R.id.imageView);

//                    Log.d("mData", userCurrent.getName() + ", " + userCurrent.getBirthday().getAge());
//                    Log.d("mData", "https:" + userCurrent.getAvatar().getSmall());

                    navUsername.setText(userCurrent.getName() + ", " + userCurrent.getBirthday().getAge());
                    textView.setText(userCurrent.getJob().getProfession());

                    Picasso.with(headerView.getContext())
                            .load("https:" + userCurrent.getAvatar().getSmall())
                            .fit().centerCrop()
//                            .transform(new CircularTransformation(0))
                            .into(imageView);
                }
            }

            @Override
            public void onFailure(Call<UserCurrentData> call, Throwable t) {
                Log.i("mData", "Что-то пошло не так: " + t.getMessage());
                Toast.makeText(getApplicationContext(),"Что-то пошло не так" + t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
//        final String baerer = "Bearer NnSGgDzo19_7PRKfOQCBbGSBCl-AZJt1";

//        sPref = getSharedPreferences("mSettings", MODE_PRIVATE);
//        SharedPreferences.Editor ed = sPref.edit();
//        ed.putString("token", "Bearer " + tokenRes);
//        ed.commit();

    }

    private void loadUsersDailyData(){
        usersDailyDataList = new ArrayList<>();

        mRecyclerView = findViewById(R.id.UsersDailyRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        UsersDailyAdapter userDailyAdapter = new UsersDailyAdapter(usersDailyDataList);
        mRecyclerView.setAdapter(userDailyAdapter);
        final LinkAPI linkAPI = LinkAPI.retrofit.create(LinkAPI.class);

        sPref = getSharedPreferences("mSettings", MODE_PRIVATE);
        token = sPref.getString("token", "");

        final Call<List<UsersDailyData>> call = linkAPI.getUsersNew("580",1,50, token);
        call.enqueue(new Callback<List<UsersDailyData>>() {
            @Override
            public void onResponse(Call<List<UsersDailyData>> call, Response<List<UsersDailyData>> response) {
                if (response.isSuccessful()) {
                    usersDailyDataList.addAll(response.body());
                    mRecyclerView.getAdapter().notifyDataSetChanged();
//                    sPref = getSharedPreferences("mSettings", MODE_PRIVATE);
//                    SharedPreferences.Editor ed = sPref.edit();
//                    ed.putString("name", );
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
            public void onFailure(Call<List<UsersDailyData>> call, Throwable t) {
                Log.d("mData", t.toString());
                Toast.makeText(getApplicationContext(), "Что-то пошло не так",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

}
