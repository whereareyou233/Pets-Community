package function;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.pats_community.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class TalkFragment extends Fragment {


    private List<Talk> TalkList = new ArrayList<>();
    private TalkAdapter adapter;

    private Talk[] talks = {
            new Talk("抓住今日份可爱1,今天去了最喜欢的楼下", "金毛查理的日常",
                    R.drawable.jinmao, "4546", R.mipmap.jinmaohead, R.drawable.jinmao, R.drawable.jinmao),
            new Talk("抓住今日份可爱1,今天去了最喜欢的楼下", "金毛查理的日常",
                    R.drawable.jinmao, "4546", R.mipmap.jinmaohead, R.drawable.jinmao, R.drawable.jinmao),
            new Talk("抓住今日份可爱1,今天去了最喜欢的楼下", "金毛查理的日常",
                    R.drawable.jinmao, "4546", R.mipmap.jinmaohead, R.drawable.jinmao, R.drawable.jinmao),
            new Talk("抓住今日份可爱1,今天去了最喜欢的楼下", "金毛查理的日常",
                    R.drawable.jinmao, "4546", R.mipmap.jinmaohead, R.drawable.jinmao, R.drawable.jinmao)

    };
    private View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_talk, container, false);
        initVideo();

        RecyclerView recyclerView = view.findViewById(R.id.talk_recycle);
        StaggeredGridLayoutManager layoutManager = new
                StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new TalkAdapter(TalkList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void initVideo() {
        TalkList.clear();
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            int index = random.nextInt(talks.length);
            TalkList.add(talks[index]);
        }
    }
}