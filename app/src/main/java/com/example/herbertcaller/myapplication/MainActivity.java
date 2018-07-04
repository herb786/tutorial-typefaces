package com.example.herbertcaller.myapplication;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.provider.FontsContract;
import android.support.v4.provider.FontRequest;
import android.support.v4.provider.FontsContractCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView helloWorld;
    TextView ciaoMondo;
    TextView bonjourMonde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloWorld = findViewById(R.id.helloWorld);
        ciaoMondo = findViewById(R.id.ciaoMondo);
        bonjourMonde = findViewById(R.id.bonjourMonde);

        String wendyOne400 = "name=Wendy One&weight=400";
        String lobsterTwo700Italic = "name=Lobster Two&weight=400&italic=1";
        String fasterOne400 = "name=Faster One&weight=400";

        String providerAuthority = "com.google.android.gms.fonts";
        String providerPackage = "com.google.android.gms";
        int certificates = R.array.com_google_android_gms_fontscerts;

        FontRequest request1 = new FontRequest(providerAuthority, providerPackage, wendyOne400, certificates);
        FontRequest request2 = new FontRequest(providerAuthority, providerPackage, lobsterTwo700Italic, certificates);
        FontRequest request3 = new FontRequest(providerAuthority, providerPackage, fasterOne400, certificates);

        FontsContractCompat.FontRequestCallback callback1 = new FontsContractCompat.FontRequestCallback() {
            @Override
            public void onTypefaceRetrieved(Typeface typeface) {
                loadHelloWorld(typeface);
            }
        };
        FontsContractCompat.requestFont(this, request1, callback1, new Handler());

        FontsContractCompat.FontRequestCallback callback2 = new FontsContractCompat.FontRequestCallback() {
            @Override
            public void onTypefaceRetrieved(Typeface typeface) {
                loadCiaoMondo(typeface);
            }
        };
        FontsContractCompat.requestFont(this, request2, callback2, new Handler());

        FontsContractCompat.FontRequestCallback callback3 = new FontsContractCompat.FontRequestCallback() {
            @Override
            public void onTypefaceRetrieved(Typeface typeface) {
                loadBonjourMonde(typeface);
            }
        };
        FontsContractCompat.requestFont(this, request3, callback3, new Handler());

    }

    private void loadHelloWorld(Typeface typeface) {
        helloWorld.setTypeface(typeface);
    }

    private void loadCiaoMondo(Typeface typeface) {
        ciaoMondo.setTypeface(typeface);
    }

    private void loadBonjourMonde(Typeface typeface) {
        bonjourMonde.setTypeface(typeface);
    }

}
