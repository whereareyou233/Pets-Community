package function;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.pats_community.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class VideoFragment extends Fragment {

    private List<video> videoList = new ArrayList<>();
    private VideoAdapter adapter;

    private video[] videos = {

            new video("抓住今日份可爱1,今天去了最喜欢的楼下", "金毛查理的日常", R.drawable.jinmao, "4546", R.mipmap.jinmaohead),
            new video("抓住今日份可爱2", "金毛查理的日常", R.drawable.jinmao, "4546", R.mipmap.jinmaohead),
            new video("抓住今日份可爱3", "金毛查理的日常", R.drawable.jinmao, "666", R.mipmap.jinmaohead),
            new video("抓住今日份可爱4,今天去了最喜欢的楼下", "金毛查理的日常", R.drawable.jinmao, "4546", R.mipmap.jinmaohead),
            new video("抓住今日份可爱5", "金毛查理的日常", R.drawable.jinmao, "666", R.mipmap.jinmaohead),
            new video("抓住今日份可爱6", "金毛查理的日常", R.drawable.jinmao, "666", R.mipmap.jinmaohead)
    };
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_video, container, false);

        initVideo();

        RecyclerView recyclerView = view.findViewById(R.id.recycle_view);
        StaggeredGridLayoutManager layoutManager = new
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new VideoAdapter(videoList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void initVideo() {
        videoList.clear();
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            int index = random.nextInt(videos.length);
            videoList.add(videos[index]);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}