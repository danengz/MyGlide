package com.yu.myglide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView1, imageView2, imageView3;

    private String imageUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1567589097119&di=47cb2fddc139770ab97e0eaf30432125&imgtype=0&src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2F0413ec5313a0034c2541242760e073451b0e5ed366f33-M6guKm_fw658";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
    }

    public void showImage1(View view) {
//        Glide.with(this).load(imageUrl).into(imageView1);
    }

    public void showImage2(View view) {
    }

    public void showImage3(View view) {
    }
}
