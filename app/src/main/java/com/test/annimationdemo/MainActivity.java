package com.test.annimationdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {
    private ImageView imgPic;
    private Button btnAlpha, btnScale, btnTranslate, btnRotate;
    private Animation myAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiView();
        initData();
    }

    /**
     * 初始化组件
     */
    private void intiView() {
        imgPic = (ImageView) findViewById(R.id.imgPic);
        btnAlpha = (Button) findViewById(R.id.btnAlpha);
        btnScale = (Button) findViewById(R.id.btnScale);
        btnTranslate = (Button) findViewById(R.id.btnTranslate);
        btnRotate = (Button) findViewById(R.id.btnRotate);
    }

    /**
     * 初始化数据
     */
    private void initData() {
        btnAlpha.setOnClickListener(this);
        btnScale.setOnClickListener(this);
        btnTranslate.setOnClickListener(this);
        btnRotate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAlpha:
                /**
                 * 使用XML中的动画效果 第一个参数Context为程序的上下文 第二个参数id为动画XML文件的引用
                 */
                AlphaAnimation myAnimation_Alpha = new AlphaAnimation(0.5f,1.0f);
                myAnimation_Alpha.setDuration(10000);
                imgPic.startAnimation(myAnimation_Alpha);

//                myAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha);
//                imgPic.startAnimation(myAnimation);
                break;

            case R.id.btnScale:
                myAnimation = AnimationUtils.loadAnimation(this, R.anim.scale);
                imgPic.startAnimation(myAnimation);
                break;

            case R.id.btnTranslate:
                myAnimation = AnimationUtils.loadAnimation(this,
                        R.anim.translate);
                imgPic.startAnimation(myAnimation);
                break;

            case R.id.btnRotate:
                myAnimation = AnimationUtils
                        .loadAnimation(this, R.anim.rotate);
                imgPic.startAnimation(myAnimation);
                break;

        }
    }
}