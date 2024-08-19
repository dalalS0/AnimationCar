package com.example.globle;

import androidx.appcompat.app.AppCompatActivity;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    ImageView redLight,greenLight,orangeLight;
    ImageView car;
    Animation animationCar;
    ImageView animationRock;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        redLight = findViewById(R.id.red_light);
        greenLight = findViewById(R.id.green_light);
        orangeLight = findViewById(R.id.orange_light);

        ImageView animationTarget = findViewById(R.id.sun);
        @SuppressLint("ResourceType") Animation animation = AnimationUtils.loadAnimation(this, R.xml.rotate);
        animationTarget.startAnimation(animation);



        handlerLight();

        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @SuppressLint("ResourceType")
            @Override
            public void run() {

                car = findViewById(R.id.car);
                animationCar = AnimationUtils.loadAnimation(getApplicationContext(), R.xml.rotate_car);
                car.startAnimation(animationCar);


            }
        }, 5000);



        final Handler stone = new Handler(Looper.getMainLooper());
        stone.postDelayed(new Runnable() {
            @Override
            public void run() {
                animationRock  = findViewById(R.id.stone);
                @SuppressLint("ResourceType") Animation rockAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.xml.rotate_rock);
                animationRock.startAnimation(rockAnimation);

                ObjectAnimator fallAnimation1 = ObjectAnimator.ofFloat(animationRock, "rotation", 0f, 3f);
                ObjectAnimator fallAnimationX = ObjectAnimator.ofFloat(animationRock, "translationX", -200f, 0f);
                ObjectAnimator fallAnimationY = ObjectAnimator.ofFloat(animationRock, "translationY", 0f, 805f);
                fallAnimationY.setDuration(1500); // seconds
                 fallAnimation1.start();
                 fallAnimationX.start();
                fallAnimationY.start();
                animationCar.setDuration(4099);
            }
        }, 7000);




        final Handler stoneRotate = new Handler(Looper.getMainLooper());
        stoneRotate.postDelayed(new Runnable() {
            @Override
            public void run() {
                ObjectAnimator fallAnimationX = ObjectAnimator.ofFloat(animationRock, "translationX", 0f, -450f);
             fallAnimationX.start();



            }
        }, 7700);



        ImageView cloudAnimation = findViewById(R.id.cloud1);
        @SuppressLint("ResourceType") Animation moveLeftAnimation = AnimationUtils.loadAnimation(this, R.xml.rotate_cloud1);
        cloudAnimation.startAnimation(moveLeftAnimation);


        ImageView cloudAnimation2 = findViewById(R.id.cloud2);
        @SuppressLint("ResourceType") Animation moveRightAnimation = AnimationUtils.loadAnimation(this, R.xml.rotate_cloud2);
        cloudAnimation2.startAnimation(moveRightAnimation);


    }



    private void carRotation() {
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @SuppressLint("ResourceType")
            @Override
            public void run() {

                car = findViewById(R.id.car);
                animationCar = AnimationUtils.loadAnimation(getApplicationContext(), R.xml.rotate_car);
                car.startAnimation(animationCar);
                animationCar.setDuration(4000);



            }
        }, 5400);


    }


    private void handlerLight() {
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                redLight.setVisibility(View.GONE);
                orangeLight.setVisibility(View.VISIBLE);
            }
        }, 3000); // 3000 milliseconds (3 seconds)

        final Handler handler1 = new Handler(Looper.getMainLooper());
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {

                orangeLight.setVisibility(View.GONE);
                greenLight.setVisibility(View.VISIBLE);
                redVisibility();


            }
        }, 5000); // 5000 milliseconds (5 seconds)


    }

    private void redVisibility() {
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                greenLight.setVisibility(View.GONE);
                redLight.setVisibility(View.VISIBLE);
                car.clearAnimation();

                handlerLight();
                carRotation();



            }
        }, 4230);



    }


}


