package function.util;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
        adapter.setOnItemClickListener(new KnowledgeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (position == 0) {
                    Intent intent1 = new Intent(getActivity(), Knowledge_itemActivity.class);
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.knowledge_1);
                    intent1.putExtra("title","猫咪耳朵突然发臭？");
                    intent1.putExtra("content","        耳螨是最常见的猫咪疾病，虽没有生命危险，但其传染性往往让铲屎官十分头疼。猫咪患有耳螨后，会出现频繁挠耳朵和摇头的症状，同时耳道里有明显的黑色分泌物和异味。\n        猫咪感染耳螨后，一般2-3周才会开始出现明显的症状，当铲屎官看到猫咪有频繁挠耳朵的行为时，就需要注意了，扒开猫咪的耳朵检查检查。耳螨虽然是小病，但如果拖延不治疗，严重的情况下会引起猫咪中耳炎甚至是继发脑炎。\n        如何治疗耳螨？千万不要用棉签给猫咪掏耳朵，因为猫咪的耳道是L形的，直接掏容易对猫咪耳朵造成伤害，一定要用猫咪专用洗耳液进行清洁。需要注意的是，耳螨的生命周期大约在21天左右，三周中，它们会从一粒虫卵变为能产卵的成虫，这意味着，我们要想彻底消灭耳螨，治疗周期需要涵盖整个生命周期。\n        猫咪耳螨康复后，也不能掉以轻心.因为耳螨的生长周期长，很容易复发，一定要治疗完整个周期，痊愈后也要定期给猫咪检查耳朵。\n        除了耳螨，宠物容易感染的寄生虫多达几十种，寄生虫的存在不仅影响宠物的生长发育，而且还会给其它病原体的侵入创造条件，从而引起各种健康问题。更严重的是，许多寄生虫我们肉眼无法识别，部分寄生虫在感染宠物的同时，与宠物亲密接触的人类，也不能幸免。如果不及时治疗任其发展，会直接威胁到我们和家人的健康。为了宠物和家人的健康，定期做寄生虫检测很有必要。");
                    intent1.putExtra("picture",bitmap);
                    startActivity(intent1);
                }
                else if (position == 1) {
                    Intent intent2 = new Intent(getActivity(), Knowledge_itemActivity.class);
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.knowledge_2);
                    intent2.putExtra("title","训练狗狗小Tips");
                    intent2.putExtra("content","        养一条狗无疑会给我们带来很多快乐，但是快乐的同时狗狗不良的习惯也会给我们带来很多困扰，铲屎官最头疼的事情莫过于每天下班满地狗狗粪便。其实狗是有良好生活习惯且非常爱干净的动物，只要稍加引导，狗狗就会养成习惯定点大小便。\n        准备训练日程。小狗需要一致的日程安排来学习他们应该在哪里排泄。你一把它带回家，就开始教小狗在想要排泄时去室外是很重要的。计划每天按照固定的日程把她带到外面去：早上一起床，每顿饭后，游乐时间后，还有睡觉前。\n        2.把小狗限制在房间里的特定区域里。开始几个月你要盯好你的狗，这样一旦她要去上厕所，你就能马上把她带出去。如果一开始你在房子里给予她太大的自由，她就会随地大小便，而你没办法及时地抓住她。在夜里以及你不在家的时候把她放在箱子里。\n        3.在户外选一个指定的位置排泄。让小狗把一个特定位置和上厕所联系起来，可以帮助她学会不要在房子里拉撒。她会开始想要在那个指定地点排泄，而最终她会学着等待你把她带到外面去，而不是在房子里上厕所。\n        4.当你的小狗表现好时，表扬她。当小狗成功学会在她指定的地点上厕所时，表扬她，抚摸她并给她点好吃的。奖励会鼓励她再这样好好表现。\n        5.知道如何处理特殊情况。当你的小狗在房间里大小便了，不要反应过激地朝她吼叫或吓唬她。在她排泄的时候打断她，把她抱起来并赶快带到她的排泄地。当在那里排泄完后，表扬她。\n        6.让你的小狗和其他小狗一起玩。小狗自然会通过和其他小狗一起玩来学会如何交际的。很多年轻的小狗不知道他们的牙齿会伤到别人。他们可以通过玩耍来学习；当一条小狗把另一条咬得太用力时，这只狗就会叫唤而不玩了。这样，小狗就会学会控制咬的力度。\n        7.不要让你的小狗咬你。看看其他的小狗怎么和你的小狗玩，学着用同样的方法和她玩耍。你可以挠她痒逗她直到她开始追着你咬。当她咬你的手时，发出一个尖声的喊叫，就像其他小狗会做的一样。让你的手停下来并不和她玩了。这样你的小狗会学到当她咬你时，她就不再受到关注了。\n        8.设置一个“惩罚区”。如果你的小狗对于学习不咬人有困难，你可能需要创建一个“惩罚区”。在这里你会教她如果她不能友善地玩耍，她就不能玩。在她玩耍的房间隔出一片地方，并在她开始咬人时马上把她放到这里。\n        Tips:除了日常训练，还要说话算话，给她动力去遵从（好吃的，奖励），要严格并且公平。");
                    intent2.putExtra("picture",bitmap);
                    startActivity(intent2);
                }
                else if (position == 2) {
                    Intent intent3 = new Intent(getActivity(), Knowledge_itemActivity.class);
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.knowledge_3);
                    intent3.putExtra("title","兔子的睡姿那些事");
                    intent3.putExtra("content","        从兔子的睡姿上我们可以大致地判断出，此时兔子的心里是怎么样的，在一定程度上，我们也能够判断出兔子的性格是如何的。其实这与我们从睡姿来判断狗狗的性格很类似，比如如果狗狗睡觉时蜷缩着，表明它们很谨慎。如果是四脚朝天则表明它们很放松，有安全感。其实这些依据同样能够用到兔子身上。\n        有些兔子似乎从不闭上眼睛睡觉，最多是把四肢藏在肚子下，窝在那里眯着眼打盹，似乎从不闭眼，也不会躺下睡。这确实有可能，因为兔子处于生物链的最底端，有很多天敌都需要他它们去防范，所以兔子才会格外的警惕、谨慎以及胆小，因而它们的睡眠状况与狗差不多，处于深度睡眠的时间基本上不是很多，基本都更像是打盹，稍有动静就清醒，所以一有动静很容易就会惊扰到它们。\n        兔子睡觉的姿势不仅能反映出兔子这种动物本身的行为特点，也能反映出兔子的性格及心情等。比如说有的兔子睡觉就和鸡睡觉一样，蹲在那边，这样的姿势可以保证肚子不会着凉，而且也是最容易应急的一种睡姿，这表明兔子对现在的环境还不是很放心，也表明了它们谨慎的性格。\n        不过生病的兔子，尤其是消化道疾病，会肚子痛，，兔子也会出现像这样母鸡蹲的姿势，紧紧蜷缩起身体。如果要判断它们是睡觉还是不舒服，需要我们来观察兔子的神情。一般生病的兔子神情会表现得相对的紧张一些，而且在醒着的时候，兔子也会表现出一些异常的行为及症状。\n        除了这个姿势，有些兔子睡觉采用的是横躺的姿势，一般这样睡的兔子表明了它对家庭的居住环境很放心，它觉得自己现在是安全的。能够这样睡，说明不仅环境让兔子感觉很安全很安心，而且气候温度肯定也是很适宜的。这也是一种非常放松的睡姿，养熟了的兔子应该常常能看到它们贴着笼子壁这么随意的弯曲身体，下巴都放到了地面上，此时的兔子睡眠程度也比较熟，兔子能够伸展身体睡的姿势，说明它此刻感觉很放松，很舒适，相应的身体也是很舒服的。若兔子病后能出现如此的休息姿势，也是反映它在康复中了。\n        通常情况下如果兔子的睡姿比较随意放松，那么表明它们对于周围的环境并没有多少戒备心理，如果它们能够在你的脚边很舒服的躺下，则表明了它们对于你还是有着充分的信任的，最起码它们觉得在你的周围会让它们很安全。虽然兔子处于深度睡眠的时间并不长，所以白天的时候也会利用一定的时间来睡觉，但是也不会像狗狗那样需要用那么多的时间来补充睡眠。如果发现兔子总是想睡觉，最好留意一下它们的健康状况。");
                    intent3.putExtra("picture",bitmap);
                    startActivity(intent3);
                }
                else if (position == 3) {
                    Intent intent4 = new Intent(getActivity(), Knowledge_itemActivity.class);
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.knowledge_4);
                    intent4.putExtra("title","鹦鹉语言解析");
                    intent4.putExtra("content","        鸟类的很多姿态很是讨人喜爱，但你知道这些动作背后的玄机吗? 很多人都说鸟儿不像猫狗那样会有情绪的表现，跟人的互动也较少，其实这是因为大多数的人都不了解鸟儿的肢体语言，所以造成对鸟的错误认知。那下面就来学习一下鸟类的肢体语言吧！\n1、翅膀身体擅抖\n        擅抖的翅膀通常表示鸟儿正处于惊慌、紧张、不安或不信任的情绪。此时应停止进一步的接触，同时以柔和及令鸟儿放心的声线向它说话以缓和鸟儿的情绪。\n2、调节身体体温\n        鸟儿全身擅抖，特别是下腹部，你可以看到下腹的羽毛在震动，表示鸟儿正调较身体温度以适应环境中突如其来的气温转变。\n3、拍动双翼运动\n        拍动双翅对鸟儿来??说是很好的运动，鸟儿若是被关在笼中一段长时间，或是在早上首次被拿出笼外时，经常便会见到它们拍翼。\n4、要警告入侵者\n        一般都会站在笼面拍翼，有时力道强大得足以让它们上升或起飞。有时鸟儿亦会借着拍翼警告地盘入侵者，若入侵者不理会的话，必定会被鸟儿追着咬。\n5、单脚站步休息\n        表示鸟儿觉得身处一个舒适及安全的环境。一只安心的鸟儿睡觉时会把一只脚缩起并藏于腹部，并拧转头部藏在背后的羽毛内。\n6、采取蹲伏姿态\n        鸟儿若是蹲伏着，压低头部并向前伸，尾羽如扇状展开，身上羽毛竖起，以及瞳孔不断扩张缩小，表示鸟儿极为愤怒，这时候绝对不要接近鸟儿。\n7、鹦鹉拼死反抗\n        若鸟儿生命受到严重威胁，但却全无机会飞走或逃走，它们会转身躺在地上，双爪及喙部张开预备噬咬。这行为表示「我跟你拼了!」，通常见于亚马逊鹦鹉。\n8、上下摆动尾部\n        鸟儿上下摆动尾部并不一定代表生病，有些鸟儿在说话及唱歌时也会摆动尾部;但若鸟儿在吸气及呼气时尾部有上下摆动，这就可能是鸟儿生病的征兆了。\n9、尾部如扇张开\n        这行为是鸟儿想攻击的指标，表示鸟儿很不满、愤怒和烦厌，而且预备咬人。常见于鸟儿看到它讨厌的人接近鸟笼，或是鸟儿对于不断重复的训练觉得烦厌。\n10、左右摆动尾部\n        一般来说，大部份会出现此行为是鸟儿愉快的表示，例如看到喜欢的人(鸟主)或正进行它喜欢的活动。鸟儿会呈现开心和雀跃的情绪。\n11、伸懒腰动一动\n        跟人类一样，鸟儿有时会伸伸懒腰以松一松??，这对于它们是非常重要的，因为它们一整天都是站着。鸟儿会同时伸展翼和脚，以促进血液循环及消除肌肉疲劳。");
                    intent4.putExtra("picture",bitmap);
                    startActivity(intent4);
                }
            }
        });
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