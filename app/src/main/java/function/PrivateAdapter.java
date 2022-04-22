package function;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.pats_community.R;

import java.util.List;

public class PrivateAdapter extends ArrayAdapter<Private> {

    private int resourceId;

    public PrivateAdapter(Context context, int textViewResourceId, List<Private> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Private aPrivate = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView privateImage = (ImageView) view.findViewById(R.id.prv_item);
        privateImage.setImageResource(aPrivate.getImageId());
        return view;
    }
}
