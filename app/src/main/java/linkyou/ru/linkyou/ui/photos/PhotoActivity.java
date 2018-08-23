package linkyou.ru.linkyou.ui.photos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.squareup.picasso.Picasso;

import java.util.List;

import linkyou.ru.linkyou.R;
import linkyou.ru.linkyou.api.LinkAPI;
import linkyou.ru.linkyou.models.photos.user_gallery.UserGalleryData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoActivity extends AppCompatActivity {

    String imgURL, imgID, imgUserID;
    ViewFlipper flipper;

    float fromPosition;
    private float MOVE_LENGTH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        Display display = getWindowManager().getDefaultDisplay();
        final int screenWidth = display.getWidth();
        MOVE_LENGTH = screenWidth / 2;

        flipper = (ViewFlipper) findViewById(R.id.viewFlipper1);

        Intent intent = getIntent();
        imgURL = intent.getStringExtra("url");
        imgID = intent.getStringExtra("id");
        imgUserID = intent.getStringExtra("user_id");

        final LinkAPI linkAPI = LinkAPI.retrofit.create(LinkAPI.class);
        final String baerer = "Bearer NnSGgDzo19_7PRKfOQCBbGSBCl-AZJt1";

        final Call<List<UserGalleryData>> callPhotos = linkAPI.getUserGallery(imgUserID, 15, baerer);

        callPhotos.enqueue(new Callback<List<UserGalleryData>>() {

            @Override
            public void onResponse(Call<List<UserGalleryData>> call, Response<List<UserGalleryData>> response) {
                if (response.isSuccessful()){
                    List<UserGalleryData> userPhotosData = null;
                    try {
                        userPhotosData = response.body();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < userPhotosData.size(); i++) {
                        flipper = (ViewFlipper) findViewById(R.id.viewFlipper1);

//                        Log.d("mData", String.valueOf(i));
                        ImageView imageView = new ImageView(getApplicationContext());
//                        ImageView imageView = new ImageView(PhotoActivity.this);
                        Picasso.with(getApplicationContext())
                                .load("https:" + userPhotosData.get(i).getSrc().getOrigin())
                                .fit().centerInside()
                                .into(imageView);
                        flipper.addView(imageView);
//                        mViewFlipper.setFlipInterval(1000);// setting the interval 1500 milliseconds
//                        mViewFlipper.startFlipping(); // views flipping starts.
                    }
                }
            }

            @Override
            public void onFailure(Call<List<UserGalleryData>> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        return gestureDetector.onTouchEvent(event);
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                fromPosition = event.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                float toPosition = event.getX();
                // MOVE_LENGTH - расстояние по оси X, после которого можно переходить на след. экран
                // В моем тестовом примере MOVE_LENGTH = 150
                if ((fromPosition - MOVE_LENGTH) > toPosition)
                {
                    fromPosition = toPosition;
                    flipper.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.go_next_in));
                    flipper.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.go_next_out));
                    flipper.showNext();
                }
                else if ((fromPosition + MOVE_LENGTH) < toPosition)
                {
                    fromPosition = toPosition;
                    flipper.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.go_prev_in));
                    flipper.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.go_prev_out));
                    flipper.showPrevious();
                }
        }
        return true;
    }
}