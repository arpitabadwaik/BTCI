package com.bynry.bpal.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bynry.bpal.R;

import com.bynry.bpal.ui.adapters.ViewPagerAdapter;
import com.bynry.bpal.ui.fragments.BazaarFragment;
import com.bynry.bpal.ui.fragments.ConnectFragment;
import com.bynry.bpal.ui.fragments.MyFeedbackFragment;
import com.bynry.bpal.ui.fragments.QuizFragment;
import com.bynry.bpal.ui.fragments.TechBitesFragment;
import com.bynry.bpal.ui.fragments.WhatsUpFragment;

import de.hdodenhof.circleimageview.CircleImageView;

public class LandingActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, QuizFragment.OnFragmentInteractionListener, MyFeedbackFragment.OnFragmentInteractionListener {

    private Context context;
    private Toolbar toolbar;
    private TabLayout tabLayout, tabex;
    private ViewPager viewPager;
    private NavigationView navigationViewLeft, navigationViewRight;
    private View headerLayoutLeft, headerLayoutRight;
    private ImageView imgLeftDrawer, imgRightDrawer, imgSearch;
    private CircleImageView imgProfilePicture;
    private DrawerLayout drawer;
    private AppBarLayout appBarLayout;
    private RatingBar ratingBar;
    private TextView txtBPal;
    private CheckBox chkMostTrending, chkMostRecent, chkTravel, chkFood, chkFitnessAndWellness, chkTechnology, chkParty;
    private Button btnCancel, btnApply;
    private FloatingActionButton floatingActionButton;
    private int positions;
    private int[] tabIcons = {
            R.drawable.ic_action_whats_up,
            R.drawable.ic_action_tech_bites,
            R.drawable.ic_action_bazaar,
            R.drawable.ic_action_connect
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        toolbar = findViewById(R.id.toolbar);

        tabLayout = findViewById(R.id.tab_layout);

        viewPager = findViewById(R.id.viewpager);

        navigationViewLeft = findViewById(R.id.nav_view_left);
        navigationViewRight = findViewById(R.id.nav_view_right);

        headerLayoutLeft = navigationViewLeft.getHeaderView(0);
        headerLayoutRight = navigationViewRight.getHeaderView(0);

        appBarLayout = findViewById(R.id.app_bar_layout);

        imgLeftDrawer = appBarLayout.findViewById(R.id.img_left_drawer);
        imgRightDrawer = appBarLayout.findViewById(R.id.img_right_drawer);
        imgSearch = appBarLayout.findViewById(R.id.img_search);
        imgProfilePicture = headerLayoutLeft.findViewById(R.id.img_profile_picture);

        drawer = findViewById(R.id.drawer_layout);

        ratingBar = headerLayoutLeft.findViewById(R.id.rating_bar);

        txtBPal = findViewById(R.id.txt_b_pal);

     /*   chkMostTrending = headerLayoutRight.findViewById(R.id.chk_most_trending);
        chkMostRecent = headerLayoutRight.findViewById(R.id.chk_most_recent);
        chkTravel = headerLayoutRight.findViewById(R.id.chk_travel);
        chkFood = headerLayoutRight.findViewById(R.id.chk_food);
        chkFitnessAndWellness = headerLayoutRight.findViewById(R.id.chk_fitness_and_wellness);
        chkTechnology = headerLayoutRight.findViewById(R.id.chk_technology);
        chkParty = headerLayoutRight.findViewById(R.id.chk_party);*/

        btnCancel = findViewById(R.id.btn_cancel);
        btnApply = findViewById(R.id.btn_apply);

        floatingActionButton = findViewById(R.id.floating_action_btn);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(null);

        setupViewPager(viewPager);

        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

               positions = position;

               if (position == 3){
                   floatingActionButton.setImageResource(R.drawable.ic_action_floating_action_calendar_white);
               }

                /*LayoutInflater li = getLayoutInflater();
                View drawerWhatsUp = li.inflate(R.layout.nav_header_landing_right_whats_up, (ViewGroup) findViewById(R.id.layout_nav_right_whats_up));
                View drawerTechBites = li.inflate(R.layout.nav_header_landing_right_tech_bites, (ViewGroup) findViewById(R.id.layout_nav_right_tech_bites));
                View drawerBazaar = li.inflate(R.layout.nav_header_landing_right_bazaar, (ViewGroup) findViewById(R.id.linear_layout_nav_right_bazaar));
                View drawerConnect = li.inflate(R.layout.nav_header_landing_right_connect, (ViewGroup) findViewById(R.id.layout_nav_right_connect));

                if (viewPager.getParent() == null) {
                    if (position == 0) {
                        navigationViewRight.removeHeaderView(drawerTechBites);
                        navigationViewRight.removeHeaderView(drawerBazaar);
                        navigationViewRight.removeHeaderView(drawerConnect);
                        navigationViewRight.addHeaderView(drawerWhatsUp);

                    } else if (position == 1) {
                        navigationViewRight.removeHeaderView(drawerWhatsUp);
                        navigationViewRight.removeHeaderView(drawerBazaar);
                        navigationViewRight.removeHeaderView(drawerConnect);
                        navigationViewRight.addHeaderView(drawerTechBites);

                    } else if (position == 2) {
                        navigationViewRight.removeHeaderView(drawerWhatsUp);
                        navigationViewRight.removeHeaderView(drawerTechBites);
                        navigationViewRight.removeHeaderView(drawerConnect);
                        navigationViewRight.addHeaderView(drawerBazaar);

                    } else if (position == 3) {
                        navigationViewRight.removeHeaderView(drawerWhatsUp);
                        navigationViewRight.removeHeaderView(drawerTechBites);
                        navigationViewRight.removeHeaderView(drawerBazaar);
                        navigationViewRight.addHeaderView(drawerConnect);
                    }
                }*/
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                /*int position = tab.getPosition();
                LayoutInflater li = getLayoutInflater();
                View drawerWhatsUp = li.inflate(R.layout.nav_header_landing_right_whats_up, (ViewGroup) findViewById(R.id.layout_nav_right_whats_up));
                View drawerTechBites = li.inflate(R.layout.nav_header_landing_right_tech_bites, (ViewGroup) findViewById(R.id.layout_nav_right_tech_bites));
                View drawerBazaar = li.inflate(R.layout.nav_header_landing_right_bazaar, (ViewGroup) findViewById(R.id.linear_layout_nav_right_bazaar));
                View drawerConnect = li.inflate(R.layout.nav_header_landing_right_connect, (ViewGroup) findViewById(R.id.layout_nav_right_connect));

                if (position == 0) {
                    navigationViewRight.removeHeaderView(drawerTechBites);
                    navigationViewRight.removeHeaderView(drawerBazaar);
                    navigationViewRight.removeHeaderView(drawerConnect);
                    navigationViewRight.addHeaderView(drawerWhatsUp);

                } else if (position == 1) {
                    navigationViewRight.removeHeaderView(drawerWhatsUp);
                    navigationViewRight.removeHeaderView(drawerBazaar);
                    navigationViewRight.removeHeaderView(drawerConnect);
                    navigationViewRight.addHeaderView(drawerTechBites);

                } else if (position == 2) {
                    navigationViewRight.removeHeaderView(drawerWhatsUp);
                    navigationViewRight.removeHeaderView(drawerTechBites);
                    navigationViewRight.removeHeaderView(drawerConnect);
                    navigationViewRight.addHeaderView(drawerBazaar);

                } else if (position == 3) {
                    navigationViewRight.removeHeaderView(drawerWhatsUp);
                    navigationViewRight.removeHeaderView(drawerTechBites);
                    navigationViewRight.removeHeaderView(drawerBazaar);
                    navigationViewRight.addHeaderView(drawerConnect);
                }*/
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        navigationViewLeft.setNavigationItemSelectedListener(this);
        navigationViewRight.setNavigationItemSelectedListener(this);
        floatingActionButton.setOnClickListener(this);
        imgLeftDrawer.setOnClickListener(this);
        imgRightDrawer.setOnClickListener(this);
        imgSearch.setOnClickListener(this);
    }

    public void onBackPressed() {
        drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_landing_left_drawer, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        /*//noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_profile) {
            Intent intent = new Intent(this, AddEditProfileActivity.class);
            intent.putExtra("from", "EditProfile");
            startActivity(intent);

        } else if (id == R.id.nav_quiz) {
            FragmentManager fm = getSupportFragmentManager();
            QuizFragment editNameDialogFragment = QuizFragment.newInstance("Some title", "gh");
            editNameDialogFragment.show(fm, "");

        } else if (id == R.id.nav_my_feedback) {
            FragmentManager fm = getSupportFragmentManager();
            MyFeedbackFragment editNameDialogFragment = MyFeedbackFragment.newInstance("Some title", "gh");
            editNameDialogFragment.show(fm, "");

        } else if (id == R.id.nav_saved_posts_and_ads) {
            Toast.makeText(this, "You clicked on Saved posts and ads", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_settings) {
            Toast.makeText(this, "You clicked on settings", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_assist) {
            Intent intent = new Intent(this, AssistActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_logout) {
            Toast.makeText(this, "You have successfully Logged out", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setupTabIcons() {

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab_layout, null);
        tabOne.setText("What's Up?");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_action_whats_up, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab_layout, null);
        tabTwo.setText("Tech Bites");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_action_tech_bites, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab_layout, null);
        tabThree.setText("Bazaar");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_action_bazaar, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);

        TextView tabFour = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab_layout, null);
        tabFour.setText("Connect");
        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_action_connect, 0, 0);
        tabLayout.getTabAt(3).setCustomView(tabFour);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new WhatsUpFragment(), "What's Up?");
        adapter.addFrag(new TechBitesFragment(), "Tech Bites");
        adapter.addFrag(new BazaarFragment(), "Bazaar ");
        adapter.addFrag(new ConnectFragment(), "Connect ");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        if (view == floatingActionButton) {
            Intent intent = new Intent(this, StartDiscussionActivity.class);
            if (positions == 0){
                startActivity(intent);
            }else if (positions == 2){
                intent.putExtra("bazaar","bazaar");
                startActivity(intent);
            }

        } else if (view == imgLeftDrawer) {
            drawer.openDrawer(Gravity.LEFT);
        } else if (view == imgRightDrawer) {
            drawer.openDrawer(Gravity.RIGHT);
        } else if (view == imgSearch) {
            Intent intent = new Intent(this, SearchActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
