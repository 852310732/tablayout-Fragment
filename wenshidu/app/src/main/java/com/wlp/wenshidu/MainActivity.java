package com.wlp.wenshidu;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import gragment.Fragment1;
import gragment.Fragment2;
import gragment.Fragment3;


public class MainActivity extends AppCompatActivity {
    private List<String> titles;
    private List<Fragment> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button a = findViewById(R.id.a);
        Button b = findViewById(R.id.b);
        Button c = findViewById(R.id.c);
        Button d = findViewById(R.id.d);
        Button e = findViewById(R.id.e);
        Button f = findViewById(R.id.f);
        Button g = findViewById(R.id.g);

        Button j = findViewById(R.id.j);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DashboardView2 mDashboardView2 = (DashboardView2) findViewById(R.id.dashboard_view_2);
                mDashboardView2.setCreditValueWithAnim(1);
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DashboardView2 mDashboardView2 = (DashboardView2) findViewById(R.id.dashboard_view_2);
                mDashboardView2.setCreditValueWithAnim(5);
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DashboardView2 mDashboardView2 = (DashboardView2) findViewById(R.id.dashboard_view_2);
                mDashboardView2.setCreditValueWithAnim(4);
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DashboardView2 mDashboardView2 = (DashboardView2) findViewById(R.id.dashboard_view_2);
                mDashboardView2.setCreditValueWithAnim(6);
            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DashboardView2 mDashboardView2 = (DashboardView2) findViewById(R.id.dashboard_view_2);
                mDashboardView2.setCreditValueWithAnim(10);
            }
        });

        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DashboardView3 mDashboardView3 = (DashboardView3) findViewById(R.id.dashboard_view_3);
                mDashboardView3.setCreditValueWithAnim(2);
            }
        });
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DashboardView3 mDashboardView3 = (DashboardView3) findViewById(R.id.dashboard_view_3);
                mDashboardView3.setCreditValueWithAnim(4);
            }
        });

        j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DashboardView3 mDashboardView3 = (DashboardView3) findViewById(R.id.dashboard_view_3);
                mDashboardView3.setCreditValueWithAnim(10);
            }
        });


        inView();
    }

    private void inView() {

        TabLayout mTabLayout = findViewById(R.id.tab_layout);
        ViewPager mViewPager = findViewById(R.id.view_pager);


        titles = new ArrayList<>();
        titles.add("温度");
        titles.add("湿度");
        titles.add("定时");


        list = new ArrayList<>();
        list.add(new Fragment1());
        list.add(new Fragment2());
        list.add(new Fragment3());



      mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles.get(position);
            }
        });
        mViewPager.setOffscreenPageLimit(2);
        mTabLayout.setupWithViewPager(mViewPager);
      //  mTabLayout.removeAllTabs();
    }

}



/*
        //设置adapter
        mViewPager.setAdapter(new SimpleFragmentPagerAdapter(getSupportFragmentManager()));
        //关联viewpager
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setOffscreenPageLimit(2);



        //设置图标
        Objects.requireNonNull(mTabLayout.getTabAt(0)).setCustomView(getTabView("温度",R.mipmap.shidu));
        Objects.requireNonNull(mTabLayout.getTabAt(1)).setCustomView(getTabView("雾量",R.mipmap.shidu));
        Objects.requireNonNull(mTabLayout.getTabAt(2)).setCustomView(getTabView("定时",R.mipmap.shidu));
        Objects.requireNonNull(mTabLayout.getTabAt(3)).setCustomView(getTabView("定时",R.mipmap.shidu));
        //设置默认选中
        Objects.requireNonNull(mTabLayout.getTabAt(0)).select();
        //设置监听
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //选中


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //未选中

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //再次选中
            }
        });
    }

    private class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

        private String[] tabTitles = new String[]{"","","",""};
        private Fragment[] mFragment = new Fragment[]{new Fragment1(), new Fragment2(), new Fragment3(),new Fragment3()};

        private SimpleFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragment[position];
        }

        @Override
        public int getCount() {
            return mFragment.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }

    }

    public View getTabView(String title, int image_src) {
        View v = LayoutInflater.from(getApplicationContext()).inflate(R.layout.tab_item_view, null);
        TextView textView = v.findViewById(R.id.textview);
        textView.setText(title);
        ImageView imageView =v.findViewById(R.id.imageview);
        imageView.setImageResource(image_src);
        return v;
    }


}



*/






