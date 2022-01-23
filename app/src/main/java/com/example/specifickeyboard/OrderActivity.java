package com.example.specifickeyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {
    TextView txt_show_ordered_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        // reference txt_show_order_item
        txt_show_ordered_item = findViewById(R.id.txtvShowingOrder);

        // getting intent
        Intent intent = getIntent();
        String orered_item = intent.getStringExtra(MainActivity.ExtraFromMain);
        txt_show_ordered_item.setText(orered_item);
    }

    public void radioButtonClicked(View view) {
        switch (view.getId()) {

            case R.id.sameday:
                showToast("you will get delivery on the same day");
                break;

            case R.id.nextday:
                showToast("you will get delivery on the next day");
                break;

            case R.id.pickup:
                showToast("Pick on your behalf");
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}