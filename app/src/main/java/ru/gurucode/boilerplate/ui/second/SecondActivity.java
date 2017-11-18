package ru.gurucode.boilerplate.ui.second;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import ru.gurucode.boilerplate.R;
import ru.gurucode.boilerplate.ui.AbstractActionBarActivity;

/**
 * Created by Leon on 18.11.2017.
 */

public class SecondActivity extends AbstractActionBarActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBar.setTitle(R.string.second_title);
    }

    @Override
    protected Fragment createFragment() {
        return new SecondFragment();
    }

}
