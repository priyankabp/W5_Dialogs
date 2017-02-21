package com.example.android.w5_dialogs;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    Configuration configuration;

    @BindView(R.id.btn_date_ma)
    Button dateBtn;
    //show date in textview
    @BindView(R.id.MA_textView)
    TextView textView;
    @BindView(R.id.activity_main)
    LinearLayout rootlayout;

    int numOfViews = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // copied from https://github.com/JakeWharton/butterknife
        // it does the binding
        ButterKnife.bind(this);
        configuration = getResources().getConfiguration();

        dateBtn.setOnClickListener(new MyLsntr());

        ScrollView scrollView = new ScrollView(this);
        LinearLayout subLayer = new LinearLayout(this);

        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
            subLayer.setOrientation(LinearLayout.HORIZONTAL);
        else
            subLayer.setOrientation(LinearLayout.VERTICAL);

        for (int i = 0; i <= numOfViews; i++) {
            Button btn = new Button(this);
            btn.setText("Btn " + i);
            btn.setWidth(20);
            btn.setHeight(10);
            subLayer.addView(btn);
        }
        scrollView.addView(subLayer);
        rootlayout.addView(scrollView);
    }

    class MyLsntr implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                            //show date in textView
                            textView.setText("" + year + "/" + month + "/" + day);
                        }
                    }, 2016, 0, 0);
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
