package com.example.salecalculator;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ResultsActivity extends AppCompatActivity {
    private TextView mOriginalPrice, mPercentDiscount, mSaved, mTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        setUpFab();
        setUpToolbar();
        mOriginalPrice = findViewById(R.id.tv_orig);
        mPercentDiscount=findViewById(R.id.tv_discount);
        mSaved=findViewById(R.id.tv_saved);
        mTotal=findViewById(R.id.tv_total);

        getkeys();

    }

    private void setUpToolbar() {
        Toolbar toolbar = findViewById (R.id.toolbar);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_results, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if(id==android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
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


    public void showAbout(MenuItem item) {
        Utils.showInfoDialog(this,"About Menu","Created by Dina Leah Garber, Chana Lavian,+" +
                "Laya KleinKaufman C 2019-Proffessor Abromson's class Summer 2019!");
    }
}
