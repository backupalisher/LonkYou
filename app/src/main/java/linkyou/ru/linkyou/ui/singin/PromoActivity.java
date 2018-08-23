package linkyou.ru.linkyou.ui.singin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import linkyou.ru.linkyou.R;

public class PromoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo);

        Button regButton = (Button) findViewById(R.id.regButton);
        Button signButton = (Button) findViewById(R.id.signButton);

        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PromoActivity.this, SigninActivity.class);
                intent.putExtra("page",0);
                startActivity(intent);
            }
        });

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PromoActivity.this, SigninActivity.class);
                intent.putExtra("page",1);
                startActivity(intent);
            }
        });

    }
}
