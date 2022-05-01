package function.util;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pats_community.R;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import function.DataBean;
import function.ImageAdapter;
import function.Knowledge;

public class KnowledgeFragment extends Fragment {

    private List<Knowledge> knowledgesList = new ArrayList<>();

    private DataBean[] datas = {new DataBean(R.mipmap.banner_1), new DataBean(R.mipmap.banner_2), new DataBean(R.mipmap.banner_3), new DataBean(R.mipmap.banner_4)};
    List<DataBean> mDatas = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        initKnowledge();
        View view = inflater.inflate(R.layout.fragment_knowledge, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_knowledge);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        KnowledgeAdapter adapter = new KnowledgeAdapter(knowledgesList);
        recyclerView.setAdapter(adapter);
        Banner banner = view.findViewById(R.id.banner);
        for (int i = 0; i < 4; i++) {
            mDatas.add(datas[i]);
        }
        ImageAdapter adapterBanner = new ImageAdapter(mDatas);
        banner.addBannerLifecycleObserver(this)
                .setBannerRound(50)
                .setAdapter(adapterBanner);
        return view;
    }


    private void initKnowledge() {
        for (int i = 0; i < 5; i++) {
            Knowledge knowledge1 = new Knowledge(R.mipmap.knowledge_1, "猫咪耳朵突然发臭别慌！是耳螨！",
                    "耳螨是最常见的猫咪疾病，虽没有生命危险，但其传染性往往让铲屎官十分头疼...", R.mipmap.v1, "科普社区");
            knowledgesList.add(knowledge1);
            Knowledge knowledge2 = new Knowledge(R.mipmap.knowledge_2, "训练狗狗小Tips",
                    "为什么别人家的狗狗那么听话，并且拥有各种各样的本领？！如何训练自家的崽崽成...", R.mipmap.v1, "科普社区");
            knowledgesList.add(knowledge2);
            Knowledge knowledge3 = new Knowledge(R.mipmap.knowledge_3, "兔子的睡姿与性格有哪些关系？",
                    "有些兔子似乎从不闭上眼睛睡觉，最多是把四肢藏在肚子下，眯着眼睛打盹，也不会...", R.mipmap.v2, "Lili的小知识");
            knowledgesList.add(knowledge3);
            Knowledge knowledge4 = new Knowledge(R.mipmap.knowledge_4, "新手养鸟 | 16种鹦鹉语言解析",
                    "当面低头、整理羽毛、贴贴、展翅拍打、眼睛呈三角状、瞳孔缩小、敲击物品、抬高...", R.mipmap.v2, "沃克和牡丹鹦鹉");
            knowledgesList.add(knowledge4);
        }
    }
}