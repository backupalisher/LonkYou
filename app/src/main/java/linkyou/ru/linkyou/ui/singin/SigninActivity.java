package linkyou.ru.linkyou.ui.singin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import linkyou.ru.linkyou.R;
import linkyou.ru.linkyou.api.http_api.httpApi;
import linkyou.ru.linkyou.ui.MainActivity;

public class SigninActivity extends AppCompatActivity {

    SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        final Button button = (Button) findViewById(R.id.button);
        final TextView textView = (TextView) findViewById(R.id.text);
        final TextView textRules = (TextView) findViewById(R.id.rules);
        final ImageButton closeBtn = (ImageButton) findViewById(R.id.close_blue);

        final EditText lgonEdit = (EditText) findViewById(R.id.emailEdit);
        final EditText passwordEdit = (EditText) findViewById(R.id.passwordEdit);

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SigninActivity.this, PromoActivity.class);
                startActivity(intent);
            }
        });

        tabLayout.setTabGravity(1);

        Intent intent = getIntent();
        final int i = intent.getIntExtra("page",0);

        tabLayout.getTabAt(i).select();

        if (tabLayout.getSelectedTabPosition() == 0) {
            button.setText("Войти");
            textView.setText("Забыли пароль?");
            textRules.setVisibility(View.GONE);
        } else {
            button.setText("Регистрация");
            textView.setText("Регистрируясь на сайте вы соглашаетесь с");
            textRules.setVisibility(View.VISIBLE);
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0){
                    button.setText("Войти");
                    textView.setText("Забыли пароль?");
                    textRules.setVisibility(View.GONE);

                } else {
                    button.setText(tab.getText());
                    textView.setText("Регистрируясь на сайте вы соглашаетесь с");
                    textRules.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    //89260201642
                    String[] lp = {"login", String.valueOf(lgonEdit.getText()), "password", String.valueOf(passwordEdit.getText())};
//                    Log.d("mData","login:" + String.valueOf(lgonEdit.getText()) + ", password:"+ String.valueOf(passwordEdit.getText()));
                    try {
                        String res = httpApi.Post("http://linkyou2.klendev.ru/v2/auth/signin", lp);
//                        String res = httpApi.Post("http://logistic.part4.ru/api/auth", lp);
//                        Log.d("mData", res);

                        if (res.equals("401")){
                            Toast.makeText(getApplicationContext(),"Невнрный логин или пароль",Toast.LENGTH_LONG).show();
                        } else {
                            JSONObject jsonObject = new JSONObject(res);
                            String tokenRes = jsonObject.getString("token");
//                            Log.d("mData", jsonObject.getString("token"));

                            sPref = getSharedPreferences("mSettings", MODE_PRIVATE);
                            SharedPreferences.Editor ed = sPref.edit();
                            ed.putString("token", "Bearer " + tokenRes);
                            ed.commit();

                            Intent intent = new Intent(SigninActivity.this, MainActivity.class);
                            startActivity(intent);
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        textRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SigninActivity.this, RulesActivity.class);
                startActivity(intent);
            }
        });

    }
}
