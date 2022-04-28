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

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ViewHolder> {

    private List<Knowledge> mKnowledgeList;

    public ServiceAdapter(List<Knowledge> knowledgesList) {
        mKnowledgeList = knowledgesList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView picture;
        TextView contentX;
        TextView text;
        TextView contentx;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            picture = (ImageView) itemView.findViewById(R.id.service_image);
            contentX = (TextView) itemView.findViewById(R.id.service_message);
            contentx = (TextView) itemView.findViewById(R.id.service_moment);

            text = (TextView) itemView.findViewById(R.id.service_aim);
        }
    }

    @NonNull
    @Override
    public ServiceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.petmessage_cardview, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Knowledge knowledge = mKnowledgeList.get(position);
        holder.text.setText(knowledge.getText());
        holder.contentX.setText(knowledge.getContentX());
        holder.picture.setImageResource(knowledge.getPicture());
        holder.contentx.setText(knowledge.getContentx());
    }

    @Override
    public int getItemCount() {
        return mKnowledgeList.size();
    }
}
