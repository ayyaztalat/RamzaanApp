package com.tecjaunt.ramzanapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.tecjaunt.ramzanapp.PreferenceDir.Preferences;
import com.tecjaunt.ramzanapp.R;

public class CountrySelector extends AppCompatActivity {

    ImageView country_first,country_second,country_Third,selector1,selector2,selector3;
    Button select;
    Preferences preferences;
    String countryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.country_select);

        preferences=new Preferences(this);

        country_first=findViewById(R.id.country_first);
        country_second=findViewById(R.id.country_second);
        country_Third=findViewById(R.id.country_Third);

        select=findViewById(R.id.select);
        selector1=findViewById(R.id.selector1);
        selector2=findViewById(R.id.selector2);
        selector3=findViewById(R.id.selector3);

        onclick();
    }

    private void onclick() {

        country_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selector1.setVisibility(View.VISIBLE);
                countryName="USA";
                selector2.setVisibility(View.GONE);
                selector3.setVisibility(View.GONE);
            }
        });

        country_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selector1.setVisibility(View.GONE);
                countryName="PAKISTAN";
                selector2.setVisibility(View.VISIBLE);
                selector3.setVisibility(View.GONE);
            }
        });

        country_Third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selector1.setVisibility(View.GONE);
                countryName="SPAIN";
                selector2.setVisibility(View.GONE);
                selector3.setVisibility(View.VISIBLE);
            }
        });

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(countryName)){
                    Toast.makeText(CountrySelector.this, "First Select Any Country", Toast.LENGTH_SHORT).show();
                }else{
                    preferences.setCountry(countryName);
                    startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                }
            }
        });
    }

}
