package org.chzz.adapter.demo.ui.activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import org.chzz.adapter.demo.R;
import org.chzz.adapter.demo.ui.fragment.RecyclerIndexDemoFragment;
import org.chzz.adapter.demo.ui.fragment.GridViewDemoFragment;
import org.chzz.adapter.demo.ui.fragment.ListChatDemoFragment;
import org.chzz.adapter.demo.ui.fragment.ListIndexViewDemoFragment;
import org.chzz.adapter.demo.ui.fragment.ListViewDemoFragment;
import org.chzz.adapter.demo.ui.fragment.RecyclerChatDemoFragment;
import org.chzz.adapter.demo.ui.fragment.RecyclerViewDemoFragment;
import org.chzz.adapter.demo.util.SnackbarUtil;

/**
 * 作者:copy 邮件:2499551993@qq.com
 * 创建时间:15/5/28 10:23
 * 描述:
 */
public class MainActivity extends AppCompatActivity {
    private Class[] mFragmentClasses = new Class[]{GridViewDemoFragment.class, ListViewDemoFragment.class, RecyclerViewDemoFragment.class, ListChatDemoFragment.class, RecyclerChatDemoFragment.class, ListIndexViewDemoFragment.class, RecyclerIndexDemoFragment.class};
    private CoordinatorLayout mCoordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setIcon(R.mipmap.logo);

        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        ContentPagerAdapter contentPagerAdapter = new ContentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(contentPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabsFromPagerAdapter(contentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void showSnackbar(String msg) {
        SnackbarUtil.show(mCoordinatorLayout, msg);
    }

    private class ContentPagerAdapter extends FragmentStatePagerAdapter {

        public ContentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return Fragment.instantiate(MainActivity.this, mFragmentClasses[position].getName());
        }

        @Override
        public int getCount() {
            return mFragmentClasses.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentClasses[position].getSimpleName().replace("Fragment", "");
        }
    }

}