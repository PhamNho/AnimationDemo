package com.nho.pham.animationdemo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imgObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgObj = (ImageView) findViewById(R.id.imgObj);

        // Property Animation
        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(imgObj,"translationX",0,500);
        // chạy trong bao lâu
        objectAnimator.setDuration(2000);
        // sô lần lặp lại
        objectAnimator.setRepeatCount(5);
        // di chuyển liên tục 5 lần và đảo ngược
        objectAnimator.setRepeatMode(ObjectAnimator.REVERSE);

        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }

            @Override
            public void onAnimationPause(Animator animation) {
                super.onAnimationPause(animation);
            }

            @Override
            public void onAnimationResume(Animator animation) {
                super.onAnimationResume(animation);
            }
        });
//        objectAnimator.start();

        Animator animator=AnimatorInflater.loadAnimator(this, R.animator.my_animation);
        // áp dụng lên đối tượng nào
        animator.setTarget(imgObj);
        animator.start();
        // lồng file nhạc vào ứng dụng
        MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.yoona_love_yoona);
        try {
            mPlayer.start();
        } catch (Exception e) {
            // xử lý sau
        }

        // drawable animation
        imgObj.setImageResource(R.drawable.anh);
        AnimationDrawable animationDrawable = (AnimationDrawable) imgObj.getDrawable();
        animationDrawable.start();

        // view animation
        Animation hyperspaceJump = AnimationUtils.loadAnimation(this, R.anim.slide_out);
        imgObj.startAnimation(hyperspaceJump);

    }
}
