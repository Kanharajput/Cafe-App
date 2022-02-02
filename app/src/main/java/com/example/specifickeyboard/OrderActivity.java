package com.example.specifickeyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.transition.Explode;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView txt_show_ordered_item;
    private EditText edtPhoneText;
    private int check = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        // setting onclickListener
        Spinner spinner = findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        // creates ArrayAdapter and layout when a default item show at top from list
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.labels_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource
                            (android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

        // set an exit transition
        getWindow().setEnterTransition(new Explode());

        // reference txt_show_order_item
        txt_show_ordered_item = findViewById(R.id.txtvShowingOrder);

        // getting intent
        Intent intent = getIntent();
        String orered_item = intent.getStringExtra(MainActivity.ExtraFromMain);
        txt_show_ordered_item.setText(orered_item);

        //reference the editText to the phone label
        edtPhoneText = findViewById(R.id.phone_text);

        // setting onclickListner for the enter button in device inbuilt keyboard
        edtPhoneText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEND) {
                    dialNumber();
                    return true;             //  return true if action handled
                }
                return false;       // otherwise false if not handled
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(++check > 1) {
            String spinnerLabel = parent.getItemAtPosition(position).toString();
            showToast(spinnerLabel);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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

    // method to send implicit for open an phone application to dial number
    private void dialNumber() {
        String phone_number = edtPhoneText.getText().toString();
        Uri uri = Uri.parse("tel:"+phone_number);
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(uri);
        startActivity(intent);
    }

}