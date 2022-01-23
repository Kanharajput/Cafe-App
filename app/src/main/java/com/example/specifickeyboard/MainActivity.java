package com.example.specifickeyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String item_selected;
    public static final String ExtraFromMain = "com.example.MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void donutSelected(View view) {
        showToast(getString(R.string.donut_order_message));
    }

    public void froyoSelected(View view) {
        showToast(getString(R.string.froyo_order_message));
    }

    public void IcecreamSelected(View view) {
        showToast(getString(R.string.ice_cream_order_message));
    }

    private void showToast(String message) {
        item_selected = message;
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    public void fabClicked(View view) {
        Intent intent = new Intent(this,OrderActivity.class);
        intent.putExtra(ExtraFromMain,item_selected);
        startActivity(intent);
    }
}