package com.meedamian.twoWayBinding;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;

import com.meedamian.twoWayBinding.databinding.ActivityMainBinding;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding amb = DataBindingUtil.setContentView(this,
            R.layout.activity_main);

        final MainState ms = new MainState();
        amb.setState(ms);

        // Enable interface only after 2s for some reason
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            ms.fieldsEnabled.set(true);
            }
        }, 2000);
    }
}
