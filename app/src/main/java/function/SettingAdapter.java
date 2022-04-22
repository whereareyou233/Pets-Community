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

public class SettingAdapter extends ArrayAdapter<Settings> {
    private int resourceId;

    public SettingAdapter(Context context, int textViewResourceId, List<Settings> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Settings settings = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView privateImage = (ImageView) view.findViewById(R.id.setting_image);
        privateImage.setImageResource(settings.getImageId());
        return view;
    }
}
