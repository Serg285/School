package com.softdesign.school.ui.activities;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;
import com.softdesign.school.R;
import com.softdesign.school.ui.fragments.ContactsFragment;
import com.softdesign.school.ui.fragments.ProfileFragment;
import com.softdesign.school.ui.fragments.SettingFragment;
import com.softdesign.school.ui.fragments.TaskFragment;
import com.softdesign.school.ui.fragments.TeamFragment;
import com.softdesign.school.utils.Lg;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

 //   public static final String TCURRENT_COLOR = "toolbar_color";
 //   public static final String SCURRENT_COLOR = "statusbar_color";


  //  private Toolbar mToolbar;
   @Bind(R.id.toolbar) Toolbar mToolbar;

  //  public NavigationView mNavigationView;
    @Bind(R.id.navigation_view)
    public NavigationView mNavigationView;

   // private DrawerLayout mNavigationDrawer;
    @Bind(R.id.navigation_drawer) DrawerLayout mNavigationDrawer;

    // public CollapsingToolbarLayout mCollapsingToolbar;
    @Bind(R.id.collapsing_toolbar)
    public CollapsingToolbarLayout mCollapsingToolbar;

    //private AppBarLayout mAppBar;
    @Bind(R.id.appbar_layout) AppBarLayout mAppBar;

    //private NestedScrollView mNestedScrollView;
    @Bind(R.id.main_frame_conteiner) NestedScrollView mNestedScrollView;

    //private View mHeaderLayout;
    //private FloatingActionButton mFab;




    private Fragment mFragment;
    public AppBarLayout.LayoutParams params = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Lg.e(this.getLocalClassName(), "onCreate");
        ButterKnife.bind(this);
       // mToolbar = (Toolbar) findViewById(R.id.toolbar);
       // mNavigationDrawer = (DrawerLayout) findViewById(R.id.navigation_drawer);
      //  mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        //mAppBar = (AppBarLayout) findViewById(R.id.appbar_layout);
        //mCollapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        //mNestedScrollView = (NestedScrollView) findViewById(R.id.main_frame_conteiner);

        setupToolbar();
        setupDawer();
        setTitle(this.getClass().getSimpleName());

        if (savedInstanceState != null) {

        }else {
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

    public void lockAppBar(boolean collapse) {
        params = (AppBarLayout.LayoutParams) mCollapsingToolbar.getLayoutParams();
        params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED | AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP);
        mCollapsingToolbar.setLayoutParams(params);
        if(collapse) {
            /*Свернуть AppBar*/
            mAppBar.setExpanded(false);}
        /*Развернуть AppBar*/
        else {
            mAppBar.setExpanded(true);
            params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED | AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP);
            mCollapsingToolbar.setLayoutParams(params);
        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {

            mNavigationDrawer.openDrawer(GravityCompat.START);
        }
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
                      //  Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.drawer_contacts:

                        mFragment = new ContactsFragment();
                        //  mNavigationView.getMenu().findItem(R.id.drawer_contacts).setChecked(true);
                        //Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.drawer_team:

                        mFragment = new TeamFragment();
                        //  mNavigationView.getMenu().findItem(R.id.drawer_team).setChecked(true);
                       // Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.drawer_task:

                        mFragment = new TaskFragment();
                        // mNavigationView.getMenu().findItem(R.id.drawer_task).setChecked(true);
                       // Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.drawer_setting:

                        mFragment = new SettingFragment();
                        //mNavigationView.getMenu().findItem(R.id.drawer_setting).setChecked(true);
                        //Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
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

        switch (mNestedScrollView.getChildAt(0).getId()){

            case R.id.fragment_profile:
             //   mNavigationView.getMenu().findItem(R.id.drawer_profile).setChecked(true);
                break;
            case R.id.contacts_recyclerview:
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

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Lg.e(this.getLocalClassName(), "on Restore Instance State");

    }
}
