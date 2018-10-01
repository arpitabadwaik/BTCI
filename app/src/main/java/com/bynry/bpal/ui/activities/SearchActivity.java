package com.bynry.bpal.ui.activities;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bynry.bpal.R;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {

    private AppBarLayout appBarLayout;
    private ImageView imgLeftDrawer, imgRightDrawer, imgSearch, imgClose;
    private EditText edtSearchText;
    private DrawerLayout drawer;
    private NavigationView navigationViewLeft, navigationViewRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        appBarLayout = findViewById(R.id.app_bar);

        imgLeftDrawer = appBarLayout.findViewById(R.id.img_left_drawer_search);
        imgRightDrawer = appBarLayout.findViewById(R.id.img_right_drawer_search);
        imgSearch = appBarLayout.findViewById(R.id.img_search_text);
        imgClose = appBarLayout.findViewById(R.id.img_close);

        edtSearchText = findViewById(R.id.edt_search_text);

        drawer = findViewById(R.id.drawer);

        navigationViewLeft = findViewById(R.id.navigation_view_left);
        navigationViewRight = findViewById(R.id.navigation_view_right);

        imgLeftDrawer.setOnClickListener(this);
        imgRightDrawer.setOnClickListener(this);
        imgClose.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == imgLeftDrawer){
            drawer.openDrawer(Gravity.LEFT);
        }else if (view == imgRightDrawer){
            drawer.openDrawer(Gravity.RIGHT);
        }else if (view == imgClose){
            edtSearchText.setText("");
        }
    }
}
