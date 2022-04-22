package function;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.pats_community.MainActivity;
import com.example.pats_community.R;

import java.util.ArrayList;
import java.util.List;


public class PrivateFragment extends Fragment {

    private List<Private> privateList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        initPrivate();
        View view = inflater.inflate(R.layout.fragment_private, container, false);
        PrivateAdapter adapter = new PrivateAdapter(getContext(),R.layout.private_item,privateList);
        ListView listView = (ListView) view.findViewById(R.id.prv_rlv);
        listView.setAdapter(adapter);
        ImageView imageView = (ImageView) view.findViewById(R.id.private_setting);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),SettingActivity.class);
                getActivity().startActivity(intent);
            }
        });
        return view;
    }

    private void initPrivate() {
            Private private1 = new Private(R.mipmap.private_publish);
            privateList.add(private1);
            Private private2 = new Private(R.mipmap.private_collection);
            privateList.add(private2);
            Private private3 = new Private(R.mipmap.private_service);
            privateList.add(private3);
            Private private4 = new Private(R.mipmap.private_goods);
            privateList.add(private4);
    }
}