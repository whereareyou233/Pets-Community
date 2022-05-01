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
            new Talk("和金金在一起的时光总是特别短暂，但是非常的欢乐，马上就要假期了，它也很期待和我一起去郊游呢~", "COCO妈妈",
                    R.mipmap.talk_item_1_1, "4546", R.mipmap.jinmaohead, R.mipmap.talk_item_1_2, R.mipmap.talk_item_1_3),
            new Talk("新手养狗日记|今天闹米也超级乖~决定和爸爸带闹米出去好好玩一玩！", "闹米是只犬喵",
                    R.mipmap.talk_item_1_4, "4546", R.mipmap.jinmaohead, R.mipmap.talk_item_1_5, R.mipmap.talk_item_1_6)

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