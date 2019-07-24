package com.example.salecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ResultsActivity extends AppCompatActivity {
    private TextView mOriginalPrice, mPercentDiscount, mSaved, mTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        setUpFab();
        mOriginalPrice = findViewById(R.id.tv_orig);
        mPercentDiscount=findViewById(R.id.tv_discount);
        mSaved=findViewById(R.id.tv_saved);
        mTotal=findViewById(R.id.tv_total);

        getkeys();

    }

    private void setUpFab() {
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });
    }

    private void getkeys() {
        Bundle extras= getIntent().getExtras();
        if(extras != null){
            double orig =extras.getDouble("ORIGINAL_PRICE");
            double discount = extras.getDouble("PERCENT_DISCOUNT");
            double save= extras.getDouble("SAVED");
            double total= extras.getDouble("TOTAL");

            mOriginalPrice.setText("Original Price: " + orig);
            mPercentDiscount.setText("Discount amount: "+ discount);
            mSaved.setText("You save: "+save);
            mTotal.setText("Your Total: "+ total);
        }
    }


}
