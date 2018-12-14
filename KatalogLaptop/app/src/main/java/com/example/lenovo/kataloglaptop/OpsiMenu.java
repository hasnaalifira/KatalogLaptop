package com.example.lenovo.kataloglaptop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class OpsiMenu extends AppCompatActivity{

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent mIntent;
        switch (item.getItemId()) {

            case R.id.menuListSuka:
                mIntent = new Intent(this, MainActivity.class);
                startActivity(mIntent);
                return true;

            case R.id.menuTambahTransSuka:
                mIntent = new Intent(this, LayarDetail.class);
                startActivity(mIntent);
                return true;

            case R.id.menuListLaptop:
                mIntent = new Intent(this, LayarListLaptop.class);
                startActivity(mIntent);
                return true;

            case R.id.menuInsertDataLaptop:
                mIntent = new Intent(this, LayarInsertLaptop.class);
                startActivity(mIntent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
