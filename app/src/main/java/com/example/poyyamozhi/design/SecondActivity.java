package com.example.poyyamozhi.design;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button login = findViewById(R.id.login);
        final ImageView imageView = findViewById(R.id.image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(SecondActivity.this,
                        imageView, "next");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    startActivity(intent, optionsCompat.toBundle());
                    //overridePendingTransition(R.anim.windmill_enter,R.anim.windmill_exit);
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.windmill_enter,R.anim.windmill_exit);
                //Bungee.zoom(getApplicationContext());
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        SecondActivity.this.overridePendingTransition(R.anim.diagonal_right_enter, R.anim.diagonal_right_exit);
    }
}
