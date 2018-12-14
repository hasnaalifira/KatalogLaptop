package com.example.nurul.userlaptop;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class LayarHome extends AppCompatActivity {
    RelativeLayout btnLaptopList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLaptopList = findViewById(R.id.btnListLaptop);
        btnLaptopList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(getApplicationContext(), LayarListLaptop.class);
                startActivity(mIntent);
            }
        });
    }
}
