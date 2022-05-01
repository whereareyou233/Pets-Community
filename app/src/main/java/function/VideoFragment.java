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


public class VideoFragment extends Fragment {

    private List<video> videoList = new ArrayList<>();
    private VideoAdapter adapter;

    private video[] videos = {

            new video("大金毛的游玩日记|今天去了最喜欢的楼下小区！", "金毛查理的日常", R.mipmap.jinmao, "4546", R.mipmap.jinmaohead),
            new video("想给入坑蜜袋鼯的新手一些建议 避坑 最近也有一些朋友私...", "丹丹的蜜袋鼯", R.mipmap.video_item_1, "2231", R.mipmap.video_item_1_head),
            new video("抓住今日份可爱！", "精灵妞妞、", R.mipmap.video_item_2, "666", R.mipmap.video_item_2_head),
            new video("软软的兔兔 抱在怀里实在是太治愈了#荷兰垂耳兔", "揪小兔耳朵", R.mipmap.video_item_4, "242", R.mipmap.video_item_4_head),
            new video("抓住今日份可爱5", "金毛查理的日常", R.mipmap.video_item_5, "666", R.mipmap.jinmaohead),
            new video("抓住今日份可爱6", "金毛查理的日常", R.mipmap.video_item_6, "666", R.mipmap.video_item_4_head)
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
        for (int w = 0; w < 10; w++) {
            for (int i = 0; i < videos.length; i++) {
                videoList.add(videos[i]);
            }
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}