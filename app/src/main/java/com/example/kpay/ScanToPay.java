package com.example.kpay;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

public class ScanToPay extends AppCompatActivity {

    TextView show ;

    SurfaceView cameraView;
    BarcodeDetector barcodeDetector;
    CameraSource cameraSource;
    final int requestCameraPermissionID=1;

    String accountNumber;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surfaceview);



        cameraView = findViewById(R.id.cameraPreview);

        barcodeDetector = new  BarcodeDetector.Builder(this).setBarcodeFormats(Barcode.QR_CODE)
                .build();

        cameraSource = new CameraSource.Builder(this,barcodeDetector).setAutoFocusEnabled(true)
                .setRequestedPreviewSize(640,480).build();


          cameraView.getHolder().addCallback(new SurfaceHolder.Callback() {
              @Override
              public void surfaceCreated(SurfaceHolder holder) {

                  if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){

                      ActivityCompat.requestPermissions(ScanToPay.this,new String[]{Manifest.permission.CAMERA}, requestCameraPermissionID);
                      return;


                  }
                  try { // StartCamera
                      cameraSource.start(cameraView.getHolder());

                  } catch (Exception e){
                      Toast.makeText(ScanToPay.this,e.getMessage(),Toast.LENGTH_LONG).show();
                  }

              }

              @Override
              public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

              }

              @Override
              public void surfaceDestroyed(SurfaceHolder holder) {

                  cameraSource.stop();

              }
          });


barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
    @Override
    public void release() {

    }

    @Override
    public void receiveDetections(Detector.Detections<Barcode> detections) {

        final SparseArray<Barcode> sparseArray=detections.getDetectedItems();
        if (sparseArray.size() != 0){


          




                    // getting the value from the QR code
                    accountNumber = sparseArray.valueAt(0).rawValue;


                    if (accountNumber.equals("1610019009")){

                        Vibrator vibrator =(Vibrator)getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                        vibrator.vibrate(30);



                        Intent intent = new Intent(ScanToPay.this,ScannedActivity.class);
                        intent.putExtra("account",accountNumber);
                        startActivity(intent);
                        cameraSource.release();




                    }














        }

    }
});






    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

   switch (requestCode){

       case requestCameraPermissionID:
           if (grantResults[0]==PackageManager.PERMISSION_GRANTED){

               if(ActivityCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){

                   return;
               }

               try { // StartCamera
                     cameraSource.start(cameraView.getHolder());

               } catch (Exception e){
                   Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
               }



           }






   }



    }
}
