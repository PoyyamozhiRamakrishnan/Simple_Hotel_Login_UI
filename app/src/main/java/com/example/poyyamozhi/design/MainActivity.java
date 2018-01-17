package com.example.poyyamozhi.design;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import spencerstudios.com.bungeelib.Bungee;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text1, text2, text3;
        Button button;
        text1 = findViewById(R.id.text);
        text2 = findViewById(R.id.hotel);
        text3 = findViewById(R.id.stay);
        button = findViewById(R.id.login);
        int[] color = {Color.rgb(119, 20, 248), Color.rgb(41, 139, 247)};

        Shader shader = new LinearGradient(100, 100, 0, 0, color[0], color[1], Shader.TileMode.REPEAT);
        text1.getPaint().setShader(shader);
        text2.getPaint().setShader(shader);
        text3.getPaint().setShader(shader);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                MainActivity.this.overridePendingTransition(R.anim.slide_left_enter, R.anim.slide_left_exit);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MainActivity.this.overridePendingTransition(R.anim.slide_up_enter, R.anim.slide_up_exit);
    }
}
