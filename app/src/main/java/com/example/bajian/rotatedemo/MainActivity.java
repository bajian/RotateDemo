package com.example.bajian.rotatedemo;

import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int MAX_LEVEL = 10000;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animateArrow(false);
//        animateArrow(true);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateArrow(true);
            }
        });

    }

    /**
     * @param shouldRotateUp 顺时针还是逆时针
     */
    private void animateArrow(boolean shouldRotateUp) {
//        Drawable mDrawable = getResources().getDrawable(android.R.drawable.ic_delete);
        Drawable basicDrawable = ContextCompat.getDrawable(this, R.drawable.arrow);
         tv = (TextView) findViewById(R.id.tv);
        tv.setCompoundDrawablesWithIntrinsicBounds(null, null, basicDrawable, null);
        int start = shouldRotateUp ? 0 : MAX_LEVEL;
        int end = shouldRotateUp ? MAX_LEVEL : 0;
        ObjectAnimator animator = ObjectAnimator.ofInt(basicDrawable, "level", start, end);
        animator.setInterpolator(new LinearOutSlowInInterpolator());
        animator.setDuration(1000);//1秒
        animator.setRepeatCount(-1);//一直重复循环
        animator.start();
//        animator.cancel();
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
