package com.manan.appteam.elementsculmyca;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.melnykov.fab.FloatingActionButton;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;
import com.tiancaicc.springfloatingactionmenu.MenuItemView;
import com.tiancaicc.springfloatingactionmenu.OnMenuActionListener;
import com.tiancaicc.springfloatingactionmenu.SpringFloatingActionMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by naman on 1/22/2017.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CarouselView carouselView;
    private List<DataObject> listItems;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private static int[] frameAnimRes = new int[]{
            R.mipmap.compose_anim_1,
            R.mipmap.compose_anim_2,
            R.mipmap.compose_anim_3,
            R.mipmap.compose_anim_4,
            R.mipmap.compose_anim_5,
            R.mipmap.compose_anim_6,
            R.mipmap.compose_anim_7,
            R.mipmap.compose_anim_8,
            R.mipmap.compose_anim_9,
            R.mipmap.compose_anim_10,
            R.mipmap.compose_anim_11,
            R.mipmap.compose_anim_12,
            R.mipmap.compose_anim_13,
            R.mipmap.compose_anim_14,
            R.mipmap.compose_anim_15,
            R.mipmap.compose_anim_15,
            R.mipmap.compose_anim_16,
            R.mipmap.compose_anim_17,
            R.mipmap.compose_anim_18,
            R.mipmap.compose_anim_19
    };

    private SpringFloatingActionMenu springFloatingActionMenu;
    private int frameDuration = 20;
    private AnimationDrawable frameAnim;
    private AnimationDrawable frameReverseAnim;


    int[] sampleImages = {R.drawable.administrator, R.drawable.cashier, R.drawable.drama, R.drawable.cook, R.drawable.coding};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme1);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.rv);

        createFabFrameAnim();
        createFabReverseFrameAnim();

        final FloatingActionButton fab = new FloatingActionButton(this);
        fab.setType(FloatingActionButton.TYPE_NORMAL);
        fab.setImageDrawable(frameAnim);
        fab.setColorPressedResId(R.color.colorPrimary);
        fab.setColorNormalResId(R.color.fab);
        fab.setColorRippleResId(R.color.text_color);
        fab.setShadow(true);

        springFloatingActionMenu = new SpringFloatingActionMenu.Builder(this)
                .fab(fab)
                .addMenuItem(R.color.photo, R.mipmap.ic_messaging_posttype_photo, "About", R.color.text_color, this)
                .addMenuItem(R.color.chat, R.mipmap.ic_messaging_posttype_chat, "Location", R.color.text_color, this)
                .addMenuItem(R.color.quote, R.mipmap.ic_messaging_posttype_quote, "Days", R.color.text_color, this)
                .addMenuItem(R.color.link, R.mipmap.ic_messaging_posttype_link, "Developers", R.color.text_color, this)
                .addMenuItem(R.color.audio, R.mipmap.ic_messaging_posttype_audio, "Sponsors", R.color.text_color, this)
                .animationType(SpringFloatingActionMenu.ANIMATION_TYPE_TUMBLR)
                .revealColor(R.color.colorPrimary)
                .gravity(Gravity.RIGHT | Gravity.BOTTOM)
                .onMenuActionListner(new OnMenuActionListener() {
                    @Override
                    public void onMenuOpen() {
                        fab.setImageDrawable(frameAnim);
                        frameReverseAnim.stop();
                        frameAnim.start();
                    }

                    @Override
                    public void onMenuClose() {
                        fab.setImageDrawable(frameReverseAnim);
                        frameAnim.stop();
                        frameReverseAnim.start();
                    }
                })
                .build();
        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);

        // CardView

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        listItems = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            DataObject listItem = new DataObject("Category Name" + i, R.drawable.cashier);              //Data Addition TODO
            listItems.add(listItem);
        }

        adapter = new RVAdapter(listItems, this);
        recyclerView.setAdapter(adapter);


        TextView day1textView = (TextView) findViewById(R.id.day1);
        day1textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, EventsByDayActivity.class);
                startActivity(i);
                //Position to be specified. TODO
            }
        });

        TextView day2textView = (TextView) findViewById(R.id.day2);
        day2textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, EventsByDayActivity.class);
                startActivity(i);
                //Position to be specified. TODO
            }
        });

        TextView day3textView = (TextView) findViewById(R.id.day3);
        day3textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, EventsByDayActivity.class);
                startActivity(i);
                //Position to be specified. TODO
            }
        });

    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);     //For carousel images
        }
    };


    private void createFabFrameAnim() {
        frameAnim = new AnimationDrawable();
        frameAnim.setOneShot(true);
        Resources resources = getResources();
        for (int res : frameAnimRes) {
            frameAnim.addFrame(resources.getDrawable(res), frameDuration);
        }
    }

    private void createFabReverseFrameAnim() {
        frameReverseAnim = new AnimationDrawable();
        frameReverseAnim.setOneShot(true);
        Resources resources = getResources();
        for (int i = frameAnimRes.length - 1; i >= 0; i--) {
            frameReverseAnim.addFrame(resources.getDrawable(frameAnimRes[i]), frameDuration);
        }
    }

    @Override
    public void onBackPressed() {
        if (springFloatingActionMenu.isMenuOpen()) {
            springFloatingActionMenu.hideMenu();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View v) {
        Log.d("TAG eg", "onclick");
        MenuItemView menuItemView = (MenuItemView) v;
        //Toast.makeText(this, menuItemView.getLabelTextView().getText(), Toast.LENGTH_SHORT).show();  //ClickListener
        springFloatingActionMenu.hideMenu();
        Intent i = new Intent(MainActivity.this, EventsByDayActivity.class);
        startActivity(i);

    }
}