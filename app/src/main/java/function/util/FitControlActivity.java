package function.util;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pats_community.R;

import java.util.ArrayList;
import java.util.List;

import function.Knowledge;

public class FitControlActivity extends AppCompatActivity {

    private List<Knowledge> knowledgesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fit_control);
        initKnowledge();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.service_recycle);
        GridLayoutManager layoutManager = new GridLayoutManager(FitControlActivity.this,2);
        recyclerView.setLayoutManager(layoutManager);
        ServiceAdapter adapter = new ServiceAdapter(knowledgesList);
        recyclerView.setAdapter(adapter);
    }

    private void initKnowledge() {

        Knowledge knowledge1 = new Knowledge(R.mipmap.logoeat, "进食",
                "约8.0g", 1, "需进食20.0g");
        knowledgesList.add(knowledge1);
        Knowledge knowledge2 = new Knowledge(R.mipmap.logochueat, "出粮",
                "约9.0g", 1, "需出粮20.0g");
        knowledgesList.add(knowledge2);
        Knowledge knowledge3 = new Knowledge(R.mipmap.logoshit, "如厕",
                "第1次", 1, "建议如厕3次");
        knowledgesList.add(knowledge3);
        Knowledge knowledge4 = new Knowledge(R.mipmap.logosleep, "睡眠",
                "共4h", 1, "建议睡眠时间14h");
        knowledgesList.add(knowledge4);
        Knowledge knowledge5 = new Knowledge(R.mipmap.logosport, "活动",
                "共1h", 1, "建议活动时间2h");
        knowledgesList.add(knowledge5);
        Knowledge knowledge6 = new Knowledge(R.mipmap.logogowalk, "遛宠",
                "5min", 1, "建议遛宠时间30min");
        knowledgesList.add(knowledge6);

    }
}