package ru.gurucode.boilerplate.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import ru.gurucode.boilerplate.R;

/**
 * Created by Leon on 18.11.2017.
 */

public abstract class AbstractBaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.content_frame);

        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.content_frame, fragment)
                    .commit();
        }
    }

    protected abstract Fragment createFragment();
}
