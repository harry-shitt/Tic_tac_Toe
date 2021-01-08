package com.example.tic_toc_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean gameactive =true;
    // 0 - X
    // 1 - O
    int activeplayer  = 0; // X is active player.
    int gamestate [] = {2,2,2,2,2,2,2,2,2};
    /*
        0 - x
        1 - O
        2 is null
     */
    int winning_position[][] ={
                                {0,1,2},{3,4,5},
                                {6,7,8},{0,3,6},
                                {1,4,7},{2,5,8},
                                {0,4 ,8},{2,4,6}
                            };
    public void tapTap(View view)
    {
        ImageView img = (ImageView)view;
        int tappedimg = Integer.parseInt(img.getTag().toString());
        if(!gameactive) gamereset(view);
        if(gamestate[tappedimg] == 2 && gameactive)
        {
            gamestate[tappedimg] = activeplayer;
            img.setTranslationY(-1000f);
            if(activeplayer ==0) {
                img.setImageResource(R.drawable.x);
                activeplayer =1;
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn Tap the box to play");
            }
            else
            {
                activeplayer=0;
                img.setImageResource((R.drawable.o));
                TextView status = findViewById(R.id.status);
                status.setText("X's Turn Tap the box to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }

        //checking if player won
        for(int [] winpos :winning_position )
        {
            if(gamestate[winpos[0]]== gamestate[winpos[1]] &&
                    gamestate[winpos[1]] == gamestate[winpos[2]] &&
                    gamestate[winpos[0]] != 2 )
            {
                String winner;
                if(gamestate[winpos[0]] == 0)
                {
                    winner = "X has won";
                }
                else
                {
                    winner = "O has won";
                }
                gameactive =false;
                TextView status = findViewById(R.id.status);
                status.setText(winner);
            }
        }
    }

    public void gamereset(View view)
    {
        gameactive =true;
        activeplayer =0 ;
        for(int i=0;i<gamestate.length ; i++)
        {
            gamestate[i] =2;
        }
        ((ImageView)findViewById(R.id.imageView11)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView12)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView13)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView14)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView15)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView16)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView17)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView18)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView19)).setImageResource(0);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
