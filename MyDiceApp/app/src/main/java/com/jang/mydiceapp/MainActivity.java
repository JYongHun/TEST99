package com.jang.mydiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

//    ImageView di1 = null;
//    ImageView di2 = null;

    int num1;
    int num2;
    ImageView diceImg1;
    ImageView diceImg2;
    int[] diceImages;

    SoundPool pool;
    int dice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRoll = findViewById(R.id.btnR);
        int[] intArr = {1,2,3,4,5,6};
        final int[] diceImages = {R.drawable.dice1, R.drawable.dice2,R.drawable.dice3,
                R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};
        diceImg1 = findViewById(R.id.dice1);
        diceImg2 = findViewById(R.id.dice2);
        final Random rnd = new Random();
        final MediaPlayer player = MediaPlayer.create(this,R.raw.dice_sound);



        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("으아아아악","나니!!");
                Random rand = new Random();
                int firstDiceNumber = rand.nextInt(6);
                Log.i("DDDDDD",""+firstDiceNumber);

                num1 = rand.nextInt(6);
                num2 = rand.nextInt(6);

                diceImg1.setImageResource(diceImages[num1]);
                YoYo.with(Techniques.Wave)
                        .duration(30)
                        .repeat(0)
                        .playOn(findViewById(R.id.dice1));

                diceImg2.setImageResource(diceImages[num2]);

                YoYo.with(Techniques.DropOut)
                        .duration(1000)
                        .repeat(0)
                        .playOn(findViewById(R.id.dice2));
                player.start();
                //pool.play(dice,1,1,0,0,1);

            }
        });







//        Button button = (Button)findViewById(R.id.btnR);
//        di1 = (ImageView)findViewById(R.id.dice1);
//        di2 = (ImageView)findViewById(R.id.dice2);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Random rnd = new Random();
//                int num1 = rnd.nextInt(6);
//                int num2 = rnd.nextInt(6);
//
//                if (num1 == 0) {
//                    di1.setImageResource(R.drawable.dice1);
//                } else if (num1 == 1) {
//                    di1.setImageResource(R.drawable.dice2);
//                } else if (num1 == 2) {
//                    di1.setImageResource(R.drawable.dice3);
//                } else if (num1 == 3) {
//                    di1.setImageResource(R.drawable.dice4);
//                } else if (num1 == 4) {
//                    di1.setImageResource(R.drawable.dice5);
//                } else if (num1 == 5) {
//                    di1.setImageResource(R.drawable.dice6);
//                }
//
//                if (num2 == 0) {
//                    di2.setImageResource(R.drawable.dice1);
//                } else if (num2 == 1) {
//                    di2.setImageResource(R.drawable.dice2);
//                } else if (num2 == 2) {
//                    di2.setImageResource(R.drawable.dice3);
//                } else if (num2 == 3) {
//                    di2.setImageResource(R.drawable.dice4);
//                } else if (num2 == 4) {
//                    di2.setImageResource(R.drawable.dice5);
//                } else if (num2 == 5) {
//                    di2.setImageResource(R.drawable.dice6);
//                }

//                Context context = getApplicationContext();
//                CharSequence text = "result: " + (num1+1) +", "+ (num2+1);
//                int duration = Toast.LENGTH_SHORT;
//
//                Toast toast = Toast.makeText(context, text, duration);
//                toast.show();
//            }
//        });
    }
}
