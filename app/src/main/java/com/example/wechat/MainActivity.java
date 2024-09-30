package com.example.wechat;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private LinearLayout navWechat, navContacts, navDiscover, navMe;
    private ImageView iconWechat, iconContacts, iconDiscover, iconMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navWechat = findViewById(R.id.nav_wechat);
        navContacts = findViewById(R.id.nav_contacts);
        navDiscover = findViewById(R.id.nav_discover);
        navMe = findViewById(R.id.nav_me);

        iconWechat = findViewById(R.id.icon_wechat);
        iconContacts = findViewById(R.id.icon_contacts);
        iconDiscover = findViewById(R.id.icon_discover);
        iconMe = findViewById(R.id.icon_me);

        // Set default page
        loadFragment(new WeChatFragment());
        updateIcons(0);

        navWechat.setOnClickListener(v -> {
            loadFragment(new WeChatFragment());
            updateIcons(0);
        });

        navContacts.setOnClickListener(v -> {
            loadFragment(new ContactsFragment());
            updateIcons(1);
        });

         navDiscover.setOnClickListener(v -> {
            loadFragment(new ExploreFragment());
            updateIcons(2);
        });

        navMe.setOnClickListener(v -> {
            loadFragment(new MeFragment());
            updateIcons(3);
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

    private void updateIcons(int selectedIndex) {
        iconWechat.setImageResource(R.drawable.wechat);
        iconContacts.setImageResource(R.drawable.contacts);
        iconDiscover.setImageResource(R.drawable.explore);
        iconMe.setImageResource(R.drawable.me);

        switch (selectedIndex) {
            case 0:
                iconWechat.setImageResource(R.drawable.wechat_filled);
                break;
            case 1:
                iconContacts.setImageResource(R.drawable.contacts_filled);
                break;
            case 2:
                iconDiscover.setImageResource(R.drawable.explore_filled);
                break;
            case 3:
                iconMe.setImageResource(R.drawable.me_filled);
                break;
        }
    }
}
