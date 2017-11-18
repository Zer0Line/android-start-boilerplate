package ru.gurucode.boilerplate.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.gurucode.boilerplate.R;
import ru.gurucode.boilerplate.ui.main.RootActivity;
import ru.gurucode.boilerplate.ui.second.SecondActivity;

/**
 * Created by Leon on 18.11.2017.
 */

public abstract class AbstractSlidingActivity extends AbstractBaseActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    public ActionBar actionBar;
    ActionBarDrawerToggle drawerToggle;

    protected int menuItemChecked = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        drawerToggle = new ActionBarDrawerToggle(
                this,
                drawer,
                toolbar,
                R.string.nav_open_drawer,
                R.string.nav_close_drawer){

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                navigationView.getMenu()
                        .getItem(menuItemChecked).setChecked(true);
            }
        };
        drawer.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent = null;

        switch(id) {
            case R.id.nav_root:
                intent = new Intent(this, RootActivity.class);
                break;
            case R.id.nav_second:
                intent = new Intent(this, SecondActivity.class);
                break;
            case R.id.nav_feedback:
                intent = new Intent(this, RootActivity.class);
                break;
            default:
                intent = new Intent(this, RootActivity.class);
        }

        startActivity(intent);

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}
