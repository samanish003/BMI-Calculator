package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class bmiactivity extends AppCompatActivity {

    android.widget.Button mrecalculatebmi;

    TextView mbmidisplay, mbmicategory, mgender;
    Intent intent ;
    ImageView  mimageview;
    String mbmi;

    float intbmi;
    String height;
    String weight;
    float intheight, intweight;
    RelativeLayout mbackgound;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color = \"white\"></font>"));
        getSupportActionBar().setTitle("Result");

        ColorDrawable colorDrawable= new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);



        intent = getIntent();

        mbmidisplay = findViewById(R.id.bmidisplay);
        mbmicategory = findViewById(R.id.bmicategory);
        mgender = findViewById(R.id.genderdisplay);
        mbackgound = findViewById(R.id.contentlayout);

        mimageview = findViewById(R.id.imageview);
        mrecalculatebmi = findViewById(R.id.recalculatebmi);


        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");

        intheight= Float.parseFloat(height);
        intweight = Float.parseFloat(weight);


        intheight = intheight/100;
        intbmi = intweight/(intheight* intheight);


        mbmi= Float.toString(intbmi);

        if(intbmi<16)
        {
            mbmicategory.setText("Severe Thinness");
            mbackgound.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);
        }

        else  if(intbmi<16.9 && intbmi>16)
        {
            mbmicategory.setText("Moderate Thinness");
            mbackgound.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }
        else  if(intbmi<18.4 && intbmi>1)
        {
            mbmicategory.setText("Mild Thinness");
            mbackgound.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }
        else  if(intbmi< 25 && intbmi>18.4)
        {
            mbmicategory.setText("Normal");

            mimageview.setImageResource(R.drawable.ok);

        }
        else  if(intbmi< 29.4 && intbmi>25)
        {
            mbmicategory.setText("Overweight");
            mbackgound.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }
        else
        {
            mbmicategory.setText("Obese Class 1");
            mbackgound.setBackgroundColor(Color.YELLOW);
            mimageview.setImageResource(R.drawable.ok);

        }

        mgender.setText(intent.getStringExtra("Gender"));
        mbmidisplay.setText(mbmi);




        getSupportActionBar().hide();
        mrecalculatebmi= findViewById(R.id.recalculatebmi);


        mrecalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(bmiactivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

}