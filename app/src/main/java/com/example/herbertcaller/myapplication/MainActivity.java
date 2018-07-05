package com.example.herbertcaller.myapplication;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.provider.FontRequest;
import android.support.v4.provider.FontsContractCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.BulletSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView helloWorld;
    TextView ciaoMondo;
    TextView bonjourMonde;
    TextView inclusiveExclusive;
    TextView inclusiveInclusive;
    TextView exclusiveExclusive;
    TextView exclusiveInclusive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloWorld = findViewById(R.id.helloWorld);
        ciaoMondo = findViewById(R.id.ciaoMondo);
        bonjourMonde = findViewById(R.id.bonjourMonde);
        inclusiveExclusive = findViewById(R.id.inclusiveExclusive);
        inclusiveInclusive = findViewById(R.id.inclusiveInclusive);
        exclusiveExclusive = findViewById(R.id.exclusiveExclusive);
        exclusiveInclusive = findViewById(R.id.exclusiveInclusive);

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

        //final Typeface myTypeface = Typeface.createFromAsset(getAssets(), "Helvetica.otf");

        String example = "0123456789";
        SpannableStringBuilder builder = new SpannableStringBuilder(example);
        builder.setSpan(new StyleSpan(Typeface.BOLD), 0, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.insert(0, "ABC");
        builder.insert(8, "XYZ");
        exclusiveExclusive.setText(builder);
        builder = new SpannableStringBuilder(example);
        builder.setSpan(new ForegroundColorSpan(Color.GREEN), 0, 5, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        builder.insert(0, "ABC");
        builder.insert(8, "XYZ");
        exclusiveInclusive.setText(builder);
        builder = new SpannableStringBuilder(example);
        builder.setSpan(new BackgroundColorSpan(Color.YELLOW), 0, 5, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        builder.insert(0, "ABC");
        builder.insert(8, "XYZ");
        inclusiveExclusive.setText(builder);
        builder = new SpannableStringBuilder(example);
        builder.setSpan(new AbsoluteSizeSpan(30, true), 0, 5, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        builder.insert(0, "ABC");
        builder.insert(8, "XYZ");
        inclusiveInclusive.setText(builder);

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

    public TypefaceSpan typefaceSpan (final Typeface typeface){
        return new TypefaceSpan("sans-serif") {

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setTypeface(typeface);
            }

            @Override
            public void updateMeasureState(TextPaint paint) {
                super.updateMeasureState(paint);
                paint.setTypeface(typeface);
            }

        };
    }

}
