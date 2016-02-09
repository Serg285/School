package com.softdesign.school.ui.activities;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.softdesign.school.R;
import com.softdesign.school.ui.fragments.ContactsFragment;
import com.softdesign.school.ui.fragments.ProfileFragment;
import com.softdesign.school.ui.fragments.SettingFragment;
import com.softdesign.school.ui.fragments.TaskFragment;
import com.softdesign.school.ui.fragments.TeamFragment;
import com.softdesign.school.utils.Lg;

public class MainActivity extends AppCompatActivity {

    public static final String TCURRENT_COLOR = "toolbar_color";
    public static final String SCURRENT_COLOR = "statusbar_color";

   // public static String FRAGMENT_TAG = "current_fragment" ;


    Toolbar mToolbar;

    public NavigationView mNavigationView;
    private DrawerLayout mNavigationDrawer;
    private Fragment mFragment;
    private FrameLayout mFrameContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Lg.e(this.getLocalClassName(), "onCreate");
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mNavigationDrawer = (DrawerLayout) findViewById(R.id.navigation_drawer);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mFrameContainer = (FrameLayout) findViewById(R.id.main_frame_conteiner);
        setupToolbar();
        setupDawer();
        setTitle(this.getClass().getSimpleName());
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_conteiner, new ProfileFragment()).commit();
        }
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

            mNavigationDrawer.openDrawer(GravityCompat.START);

        }
     /**   if (FRAGMENT_TAG == "ContactsFragment"){
            mNavigationView.getMenu().findItem(R.id.drawer_contacts).setChecked(true);
        }
        if (FRAGMENT_TAG == "PrfileFragment"){
            mNavigationView.getMenu().findItem(R.id.drawer_profile).setChecked(true);
        }*/
        return super.onOptionsItemSelected(item);
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


    private void setupDawer() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                 switch (item.getItemId()) {
                    case R.id.drawer_profile:

                        mFragment = new ProfileFragment();
                       // mNavigationView.getMenu().findItem(R.id.drawer_profile).setChecked(true);
                        Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.drawer_contacts:

                        mFragment = new ContactsFragment();
                      //  mNavigationView.getMenu().findItem(R.id.drawer_contacts).setChecked(true);
                        Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.drawer_team:

                        mFragment = new TeamFragment();
                      //  mNavigationView.getMenu().findItem(R.id.drawer_team).setChecked(true);
                        Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.drawer_task:

                        mFragment = new TaskFragment();
                       // mNavigationView.getMenu().findItem(R.id.drawer_task).setChecked(true);
                        Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.drawer_setting:

                        mFragment = new SettingFragment();
                       // mNavigationView.getMenu().findItem(R.id.drawer_setting).setChecked(true);
                        Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        break;
                }
                if (mFragment != null) {

                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_conteiner, mFragment).addToBackStack(null).commit();
                }

                mNavigationDrawer.closeDrawers();

                return false;

            }

        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        switch (mFrameContainer.getChildAt(0).getId()){

            case R.id.fragment_profile:
             //   mNavigationView.getMenu().findItem(R.id.drawer_profile).setChecked(true);
                break;
            case R.id.fragment_contacts:
               // mNavigationView.getMenu().findItem(R.id.drawer_contacts).setChecked(true);
                break;
            case R.id.fragment_task:
              //  mNavigationView.getMenu().findItem(R.id.drawer_task).setChecked(true);
                break;
            case R.id.fragment_team:
             // mNavigationView.getMenu().findItem(R.id.drawer_team).setChecked(true);
                break;
            case R.id.fragment_setting:
              //  mNavigationView.getMenu().findItem(R.id.drawer_setting).setChecked(true);
                break;
        }
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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            outState.putInt(SCURRENT_COLOR, getWindow().getStatusBarColor());
        }
        outState.putInt(TCURRENT_COLOR, ((ColorDrawable) mToolbar.getBackground()).getColor());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Lg.e(this.getLocalClassName(), "on Restore Instance State");

        mToolbar.setBackgroundColor(savedInstanceState.getInt(TCURRENT_COLOR));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(savedInstanceState.getInt(SCURRENT_COLOR));
        }
    }


}
