package com.example.salecalculator;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import static com.example.salecalculator.R.*;
import static com.example.salecalculator.R.id.et_original;

public class MainActivity extends AppCompatActivity {

        private View mSBcontainer;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(layout.activity_main);
                Toolbar toolbar = findViewById(id.toolbar);
                setSupportActionBar(toolbar);

                FloatingActionButton fab = findViewById(id.fab);
                fab.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                double mOriginalPrice= getOriginalPrice();
                                double mPercentDiscount=getPercentDiscount();
                                double mSaved=calculateSaved(mOriginalPrice,mPercentDiscount);
                                double mTotal=calculateTotal(mOriginalPrice, mSaved);

                                Intent intent = new Intent(getApplicationContext(),ResultsActivity.class);
                                intent.putExtra("ORIGINAL_PRICE",mOriginalPrice);
                                intent.putExtra("PERCENT_DISCOUNT",mPercentDiscount);
                                intent.putExtra("SAVED",mSaved);
                                intent.putExtra("TOTAL",mTotal);
                                startActivity(intent);
                        }
                });
        }

        private double getOriginalPrice() {
                double mOriginalPrice=Double.parseDouble(String.valueOf(findViewById(id.et_original)));;
                if (mOriginalPrice<0)
                {
                        Snackbar.make(mSBcontainer,"The original price must be greater than zero",Snackbar.LENGTH_LONG).show();
                }

                return mOriginalPrice;
        }

        private double getPercentDiscount()
        {
                double mPercentDiscount=Double.parseDouble(String.valueOf(findViewById(id.et_discount)));;
                if (mPercentDiscount<0)
                {
                        Snackbar.make(mSBcontainer,"The percent discount must be greater than 0%",Snackbar.LENGTH_LONG).show();
                }
                else if (mPercentDiscount>100)
                {
                        Snackbar.make(mSBcontainer,"The percent discount must be less than 100%",Snackbar.LENGTH_LONG).show();
                }
                return mPercentDiscount;
        }



        private double calculateTotal(double mOriginalPrice, double mSaved) {
                double mTotal=mOriginalPrice-mSaved;
                return mTotal;
        }

        private double calculateSaved(double mOriginalPrice, double mPercentDiscount) {
                double mSaved= (100-mPercentDiscount)*mOriginalPrice;
                return mSaved;
        }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.menu_main, menu);
                return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
                // Handle action bar item clicks here. The action bar will
                // automatically handle clicks on the Home/Up button, so long
                // as you specify a parent activity in AndroidManifest.xml.
                int id = item.getItemId();

                //noinspection SimplifiableIfStatement
                if (id == R.id.action_settings) {
                        return true;
                }

                return super.onOptionsItemSelected(item);
        }
}
