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

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    private List<video> mVideo;
    private Context mContent;
    static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView videoImage;
        TextView videoNum;
        TextView videoID;
        ImageView videoImageHead;
        TextView videoText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.video_cardview);
            videoID = cardView.findViewById(R.id.home_video_username);
            videoImage = cardView.findViewById(R.id.video_image);
            videoNum=cardView.findViewById(R.id.video_num);
            videoText = cardView.findViewById(R.id.vide_text_title);
            videoImageHead=cardView.findViewById(R.id.home_item_head);

        }
    }

    public VideoAdapter(List<video> VideoList) {
        mVideo = VideoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (mContent == null) {
            mContent = parent.getContext();
        }
        View view = LayoutInflater.from(mContent).inflate(R.layout.video_item, parent, false);

        final ViewHolder holder = new ViewHolder(view);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int position = holder.getAdapterPosition();
                video video = mVideo.get(position);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.ViewHolder holder, int position) {
        video video = mVideo.get(position);
        holder.videoID.setText(video.getID());
        holder.videoText.setText(video.gettext());

        holder.videoNum.setText(video.getNum());
        Glide.with(mContent).load(video.getImageId()).into(holder.videoImage);
        Glide.with(mContent).load(video.getImageHead()).into(holder.videoImageHead);
    }

    @Override
    public int getItemCount() {
        return mVideo.size();
    }
}
