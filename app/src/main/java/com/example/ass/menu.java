package com.example.ass;

import static com.example.ass.R.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

public class menu extends AppCompatActivity {
    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_menu);
        getSupportActionBar().setTitle("menu");

        mainGrid =(GridLayout) findViewById(R.id.mainGrid);

        setSingleEvent(mainGrid);


    }

    private void setSingleEvent(GridLayout mainGrid) {
        for(int i=0; i< mainGrid.getChildCount(); i++){
            CardView cardView =(CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    if (finalI == 0) {
                        Intent intent = new Intent(menu.this, AboutUs.class);
                        startActivity(intent);
                    } else if (finalI == 1) {
                        Intent intent = new Intent(menu.this, Information.class);
                        startActivity(intent);

                    } else if (finalI == 2) {
                        Intent intent = new Intent(menu.this, ZakatCalculate.class);
                        startActivity(intent);

                    } else if (finalI == 3) {
                        Intent intent = new Intent(menu.this, resc.class);
                        startActivity(intent);

                    }
                }



            });
        }
    }
}