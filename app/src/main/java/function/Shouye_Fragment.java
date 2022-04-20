package function;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.pats_community.R;

import java.util.ArrayList;
import java.util.List;

public class Shouye_Fragment extends Fragment {


    VideoFragment videoFragment = new VideoFragment();
    TalkFragment talkFragment = new TalkFragment();
    List<Fragment> video_fragment = new ArrayList<>();
    ViewPager viewPager;


    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_shouye, container, false);
        Button button_video_fragment;
        Button button_talk_fragment;

        viewPager = view.findViewById(R.id.ViewPager);
        video_fragment.add(videoFragment);
        video_fragment.add(talkFragment);

        myAdapter adapter = new myAdapter(getFragmentManager(), video_fragment);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);

        button_talk_fragment = view.findViewById(R.id.video_talk);
        button_video_fragment = view.findViewById(R.id.video_shipin);

        button_talk_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });
        button_video_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
    }


    private static class myAdapter extends FragmentPagerAdapter {

        private final List<Fragment> fragments;

        public myAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @NonNull
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

    }
}