package com.example.kpay;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PayFragment extends Fragment {

    ImageView generateQr,scanQr;

    public PayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_pay, container, false);
        generateQr = view.findViewById(R.id.generateQr);
        scanQr = view.findViewById(R.id.scanQr);


        scanQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(),ScanToPay.class);
                startActivity(intent);

            }
        });

        generateQr.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent intent = new Intent(getContext(),GeneratorActivity.class);
                                              startActivity(intent);
                                          }
                                      }

        );



        return view;
    }















}


