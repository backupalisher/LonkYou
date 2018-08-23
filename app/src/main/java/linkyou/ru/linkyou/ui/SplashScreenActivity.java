package linkyou.ru.linkyou.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import linkyou.ru.linkyou.R;
import linkyou.ru.linkyou.ui.singin.PromoActivity;

public class SplashScreenActivity extends AppCompatActivity {

    SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        sPref = getSharedPreferences("mSettings", MODE_PRIVATE);
        final String tokenRes = sPref.getString("token", "");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (tokenRes.equals("")) {
                    Intent intent = new Intent(SplashScreenActivity.this, PromoActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        }, 2*1000);

    }
}
