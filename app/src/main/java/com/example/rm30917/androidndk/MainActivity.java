package com.example.rm30917.androidndk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private TextView tvCurrentDate;
    private EditText etValue1;
    private EditText etValue2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = (TextView) findViewById(R.id.txtResult);
        tvCurrentDate = (TextView) findViewById(R.id.txtCurrentDate);
        etValue1 = (EditText) findViewById(R.id.edtNumber1);
        etValue2 = (EditText) findViewById(R.id.edtNumber2);

        // Call current date
        tvCurrentDate.setText(getDataAtualJNI());
    }

    public void sum(View v){
        tvResult.setText(String.valueOf(somaJNI(
                Integer.parseInt(etValue1.getText().toString()),
                Integer.parseInt(etValue2.getText().toString())
        )));
    }

    // Call which library we're gonna use
    static {
        System.loadLibrary("hello-jni"); // lib's name defined in gradle
    }

    // What native methods will be called
    public native String getDataAtualJNI();
    public native int somaJNI(int i, int j);
}
