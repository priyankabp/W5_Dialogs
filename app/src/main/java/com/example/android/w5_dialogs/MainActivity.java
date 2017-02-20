package com.example.android.w5_dialogs;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_date_ma)
    Button dateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // copied from https://github.com/JakeWharton/butterknife
        ButterKnife.bind(this);
        dateBtn.setOnClickListener(new MyLsntr());
    }

    class MyLsntr implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                        }
                    }, 0, 0, 0);
            datePickerDialog.show();

        }
    }

    public void showAlert(View view) {

    }

    public void showDate(View view) {
        AlertDialog.Builder alertbuilder = new AlertDialog.Builder(this);
        alertbuilder.setTitle("The title of the alert")
                .setMessage("Message body to go int this area...")
                .setPositiveButton("Agreee", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        alertbuilder.show();
    }
}
