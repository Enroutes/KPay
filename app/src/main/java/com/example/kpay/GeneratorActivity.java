package com.example.kpay;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class GeneratorActivity extends AppCompatActivity {

    Button generateBtn;
    EditText amount;
    ImageView imageQR;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator);

        amount = findViewById(R.id.Amount);
        generateBtn = findViewById(R.id.Generate_btn);
        imageQR = findViewById(R.id.imageQr);

        generateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Generate();
                hideKeyboard(v);

            }
        });



    }

    private void hideKeyboard(View v) {

        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(),0);
        }catch (Exception ignored){}

    }


    private void Generate() {

        String text = amount.getText().toString().trim();

        try{

            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.encodeBitmap(text, BarcodeFormat.QR_CODE,600,600);
            imageQR.setImageBitmap(bitmap);
        } catch (Exception e){}




    }
}
