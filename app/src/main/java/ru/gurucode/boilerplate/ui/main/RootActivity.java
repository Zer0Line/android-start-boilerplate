package ru.gurucode.boilerplate.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import ru.gurucode.boilerplate.R;
import ru.gurucode.boilerplate.ui.AbstractSlidingActivity;

public class RootActivity extends AbstractSlidingActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBar.setTitle(R.string.root_title);
        menuItemChecked = 0;
    }

    @Override
    protected Fragment createFragment() {
        return new RootFragment();
    }
}