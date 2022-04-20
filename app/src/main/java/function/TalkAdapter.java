package function;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pats_community.R;

import java.util.List;

public class TalkAdapter extends RecyclerView.Adapter<function.TalkAdapter.ViewHolder> {

    private List<Talk> mTalk;
    private Context mContent;

    static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView TalkImage_1;
        TextView TalkNum;
        TextView TalkID;
        ImageView TalkImageHead;
        TextView TalkText;
        ImageView TalkImage_2;
        ImageView TalkImage_3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.talk_cardview);
            TalkID = cardView.findViewById(R.id.home_talk_username);

            TalkImage_1 = cardView.findViewById(R.id.talk_image_1);
            TalkImage_2 = cardView.findViewById(R.id.talk_image_2);
            TalkImage_3 = cardView.findViewById(R.id.talk_image_3);
            TalkNum = cardView.findViewById(R.id.talk_num);
            TalkText = cardView.findViewById(R.id.talk_text_title);
            TalkImageHead = cardView.findViewById(R.id.talk_item_head);

        }
    }

    public TalkAdapter(List<Talk> TalkList) {
        mTalk = TalkList;
    }

    @NonNull
    @Override
    public function.TalkAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (mContent == null) {
            mContent = parent.getContext();
        }
        View view = LayoutInflater.from(mContent).inflate(R.layout.talk_item, parent, false);

        final function.TalkAdapter.ViewHolder holder = new function.TalkAdapter.ViewHolder(view);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int position = holder.getAdapterPosition();
                Talk talk = mTalk.get(position);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull function.TalkAdapter.ViewHolder holder, int position) {
        Talk talk = mTalk.get(position);
        holder.TalkID.setText(talk.getID());
        holder.TalkText.setText(talk.gettext());

        holder.TalkNum.setText(talk.getNum());
        Glide.with(mContent).load(talk.getImageId_1()).into(holder.TalkImage_1);
        Glide.with(mContent).load(talk.getImageHead()).into(holder.TalkImageHead);
        Glide.with(mContent).load(talk.getImageId_2()).into(holder.TalkImage_2);
        Glide.with(mContent).load(talk.getImageId_3()).into(holder.TalkImage_3);
    }

    @Override
    public int getItemCount() {
        return mTalk.size();
    }
}


