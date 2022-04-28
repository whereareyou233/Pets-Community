package function;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.pats_community.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Private_businessActivity extends AppCompatActivity {

   // private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_business);
        String[] tabTitle = getResources().getStringArray(R.array.tab_titles);
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new Order_fg1());
        fragmentList.add(new Order_fg2());
        fragmentList.add(new Order_fg3());
        fragmentList.add(new Order_fg4());
        fragmentList.add(new Order_fg5());
        ViewPager viewPager = (ViewPager) findViewById(R.id.order_vp);
        viewPager.setAdapter(new Business_fragmentPagerAdapter(getSupportFragmentManager(),fragmentList,tabTitle));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        TabLayout tabLayout = (TabLayout) findViewById(R.id.business_tab);
        tabLayout.setupWithViewPager(viewPager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.order_toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case android.R.id.home: finish();
                return true;
        }
        return false;
    }
}