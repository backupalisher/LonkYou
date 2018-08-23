package linkyou.ru.linkyou.ui.photos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import linkyou.ru.linkyou.R;
import linkyou.ru.linkyou.adapters.PhotoCommentsAdapter;
import linkyou.ru.linkyou.api.LinkAPI;
import linkyou.ru.linkyou.models.photos.photo_comments.PhotoCommentsData;
import linkyou.ru.linkyou.models.photos.user_photo.UserPhotoData;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoCommentsActivity extends AppCompatActivity {

    List<PhotoCommentsData> photoCommentsDataList;
    private RecyclerView mRecyclerView;
    String imgUserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_comments);

        Intent intent = getIntent();
        final String imgID = intent.getStringExtra("id");
        final String imgURL = intent.getStringExtra("imgURL");
        imgUserID = intent.getStringExtra("imgUserID");
        final ImageView imageView = (ImageView) findViewById(R.id.imageView);

        Picasso.with(PhotoCommentsActivity.this)
                .load(imgURL)
                .fit().centerCrop()
                .into(imageView);
//        Log.d("mData",imgURL);

        LinkAPI linkAPI = LinkAPI.retrofit.create(LinkAPI.class);
        String baerer = "Bearer NnSGgDzo19_7PRKfOQCBbGSBCl-AZJt1";

        Call<List<UserPhotoData>> callPhotosID = linkAPI.getPhotoID(imgID,  baerer);
        callPhotosID.enqueue(new Callback<List<UserPhotoData>>() {
            @Override
            public void onResponse(Call<List<UserPhotoData>> call, Response<List<UserPhotoData>> response) {
                if (response.isSuccessful()) {
                    List<UserPhotoData> photoID = null;
                    try {
                        photoID = response.body();


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<UserPhotoData>> call, Throwable t) {

            }
        });

        Call<List<PhotoCommentsData>> callPhotos = linkAPI.getPhotoComments(imgID,  baerer);
        callPhotos.enqueue(new Callback<List<PhotoCommentsData>>() {
            @Override
            public void onResponse(Call<List<PhotoCommentsData>> call, Response<List<PhotoCommentsData>> response) {
                if (response.isSuccessful()) {
                    List<PhotoCommentsData> photoComments = null;
                    try {
                        photoComments = response.body();



//                        for (int i = 0; i < userPhotosData.size(); i++) {
//
//                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<PhotoCommentsData>> call, Throwable t) {

            }
        });
    }

    private void loadPhotoComments(){
        photoCommentsDataList = new ArrayList<>();

        mRecyclerView = findViewById(R.id.PhotoCommentsRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        PhotoCommentsAdapter photoCommentsAdapter = new PhotoCommentsAdapter(photoCommentsDataList);
        mRecyclerView.setAdapter(photoCommentsAdapter);
        final LinkAPI linkAPI = LinkAPI.retrofit.create(LinkAPI.class);

        final String baerer = "Bearer NnSGgDzo19_7PRKfOQCBbGSBCl-AZJt1";

        final Call<List<PhotoCommentsData>> call = linkAPI.getPhotoComments(imgUserID, baerer);
        call.enqueue(new Callback<List<PhotoCommentsData>>() {
            @Override
            public void onResponse(Call<List<PhotoCommentsData>> call, Response<List<PhotoCommentsData>> response) {
                if (response.isSuccessful()) {
                    photoCommentsDataList.addAll(response.body());
                    mRecyclerView.getAdapter().notifyDataSetChanged();
                } else { // Обрабатываем ошибку
                    ResponseBody errorBody = response.errorBody();
                    try {
                        Toast.makeText(PhotoCommentsActivity.this, errorBody.string(),
                                Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<PhotoCommentsData>> call, Throwable t) {
                Log.d("mData", t.toString());
                Toast.makeText(PhotoCommentsActivity.this, "Что-то пошло не так",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
