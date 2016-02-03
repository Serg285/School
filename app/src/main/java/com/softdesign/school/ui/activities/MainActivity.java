package com.softdesign.school.ui.activities;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.softdesign.school.R;
import com.softdesign.school.utils.Lg;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String VISIBLE_KEY = "visible";
    public static final String TCURRENT_COLOR = "toolbar_color";
    public static final String SCURRENT_COLOR = "statusbar_color";
    CheckBox mCheckBox;
    EditText mEditText;
    EditText mEditText2;
    Toolbar mToolbar;
    Button mBtnBlue;
    Button mBtnRed;
    Button mBtnGreen;
    private NavigationView mNavigationView;
    private DrawerLayout mNavigationDrawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Lg.e(this.getLocalClassName(), "=========================");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("School lesson 1");
        Lg.e(this.getLocalClassName(), "onCreate");

        mCheckBox = (CheckBox) findViewById(R.id.checkBox);
        mCheckBox.setOnClickListener(this);

        mBtnBlue = (Button) findViewById(R.id.btnBlue);
        mBtnBlue.setOnClickListener(this);

        mBtnRed = (Button) findViewById(R.id.btnRed);
        mBtnRed.setOnClickListener(this);

        mBtnGreen = (Button) findViewById(R.id.btnGreen);
        mBtnGreen.setOnClickListener(this);


        mEditText2 = (EditText) findViewById(R.id.editText2);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        mNavigationDrawer = (DrawerLayout)findViewById(R.id.navigation_drawer);
        mNavigationView =(NavigationView)findViewById(R.id.navigation_view);
        setupToolbar();
        setupDawer();
        setTitle(this.getClass().getSimpleName());

    }

    private void setupToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       if (item.getItemId() == android.R.id.home) {
           Toast.makeText(this,"Menu Click",Toast.LENGTH_SHORT).show();
       }
      return super.onOptionsItemSelected(item);
    }



    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.checkBox:
                Toast.makeText(this, "Click!", Toast.LENGTH_SHORT).show();
                if (mCheckBox.isChecked()) {
                    mEditText2.setVisibility(View.INVISIBLE);
                } else {
                    mEditText2.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.btnBlue:
                mToolbar.setBackgroundColor(getResources().getColor(R.color.blueToolBar_color));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.blueStatusBar_color));
                }

                break;
            case R.id.btnRed:
                mToolbar.setBackgroundColor(getResources().getColor(R.color.redToolBar_color));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.redStatusBar_color));
                }
                break;

            case R.id.btnGreen:
                mToolbar.setBackgroundColor(getResources().getColor(R.color.greenToolBar_color));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.greenStatusBar_color));
                }
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        Lg.e(this.getLocalClassName(), "onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Lg.e(this.getLocalClassName(), "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Lg.e(this.getLocalClassName(), "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Lg.e(this.getLocalClassName(), "onStop");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Lg.e(this.getLocalClassName(), "onRestart");
    }

    private void setupDawer(){

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Lg.e(this.getLocalClassName(), "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Lg.e(this.getLocalClassName(), "on Save Instance State");
        outState.putBoolean(VISIBLE_KEY, mEditText2.getVisibility() == View.VISIBLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            outState.putInt(SCURRENT_COLOR, getWindow().getStatusBarColor());
        }
        outState.putInt(TCURRENT_COLOR, ((ColorDrawable) mToolbar.getBackground()).getColor());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Lg.e(this.getLocalClassName(), "on Restore Instance State");
        int visibleState = savedInstanceState.getBoolean(VISIBLE_KEY) ? View.VISIBLE : View.INVISIBLE;
        mEditText2.setVisibility(visibleState);
        mToolbar.setBackgroundColor(savedInstanceState.getInt(TCURRENT_COLOR));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(savedInstanceState.getInt(SCURRENT_COLOR));
        }
    }
}
