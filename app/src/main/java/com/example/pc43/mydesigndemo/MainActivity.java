package com.example.pc43.mydesigndemo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.pc43.mydesigndemo.fragments.Books;
import com.example.pc43.mydesigndemo.fragments.Games;
import com.example.pc43.mydesigndemo.fragments.Movies;
import com.example.pc43.mydesigndemo.models.Userresponse;
import com.example.pc43.mydesigndemo.mydesigndemosdk.MyDesignDemoSdk;
import com.example.pc43.mydesigndemo.mydesigndemosdk.Service;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadadata();
        TabLayout mtabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mtabLayout.setupWithViewPager(mViewPager);

    }

    public void setUpViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Games(), "Games");
        adapter.addFragment(new Movies(), "Movies");
        adapter.addFragment(new Books(), "Books");
        viewPager.setAdapter(adapter);

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        void addFragment(Fragment fragment, String title) {

            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    private void loadadata() {
        Service service = new MyDesignDemoSdk.Builder().build(this).getService();
        //mrecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        service.requestUserDetails().enqueue(new Callback<Userresponse>() {
            @Override
            public void onResponse(Call<Userresponse> call, Response<Userresponse> response) {
                Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                if (response.isSuccessful()) {
                    ResponseSingleton.getInstance().setUserResponseData(response.body());
                    setUpViewPager(mViewPager);
                }
            }

            @Override
            public void onFailure(Call<Userresponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
