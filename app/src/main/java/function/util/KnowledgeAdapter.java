package function.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pats_community.R;

import java.util.List;

import function.Knowledge;

public class KnowledgeAdapter extends RecyclerView.Adapter<KnowledgeAdapter.ViewHolder> {

    private List<Knowledge> mKnowledgeList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView picture;
        TextView contentX;
        ImageView imageId;
        TextView text;
        TextView contentx;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            picture = (ImageView) itemView.findViewById(R.id.picture);
            contentX = (TextView) itemView.findViewById(R.id.contentX);
            contentx = (TextView) itemView.findViewById(R.id.contentx);
            imageId = (ImageView) itemView.findViewById(R.id.imageId);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }

    public KnowledgeAdapter(List<Knowledge> KnowledgeList) {
        mKnowledgeList = KnowledgeList;
    }

    @NonNull
    @Override
    public KnowledgeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.knowledge_item,parent,false);
       ViewHolder holder = new ViewHolder(view);
       return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull KnowledgeAdapter.ViewHolder holder, int position) {

        Knowledge knowledge = mKnowledgeList.get(position);
        holder.text.setText(knowledge.getText());
        holder.contentX.setText(knowledge.getContentX());
        holder.imageId.setImageResource(knowledge.getImageId());
        holder.picture.setImageResource(knowledge.getPicture());
        holder.contentx.setText(knowledge.getContentx());
    }

    @Override
    public int getItemCount() {
        return mKnowledgeList.size();
    }
}
