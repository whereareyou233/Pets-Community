package function;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pats_community.R;
import com.example.pats_community.User;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class PrivateFragment extends Fragment {

    private ImageView headshot;
    //   private LoginUser loginUser = LoginUser.getInstance();
    //   private User user;
    private TextView info_name;

    private List<Private> privateList = new ArrayList<>();


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        switch (requestCode) {
            case 1:
                if (resultCode != RESULT_OK) {
                    User user = DataSupport.findLast(User.class);
                    Toast.makeText(getContext(), user.getName(), Toast.LENGTH_SHORT).show();

                    info_name.setText(user.getName());
                    headshot.setImageResource(user.getImageId());
                }

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_private, container, false);
        headshot = (ImageView) view.findViewById(R.id.private_headshot);
        info_name = (TextView) view.findViewById(R.id.private_name);

        User user = DataSupport.findFirst(User.class);

        /*     headshot.setImageResource(user.getImageId());*/
        /* info_name.setText(user.getName());*/

        initPrivate();

        PrivateAdapter adapter = new PrivateAdapter(getContext(), R.layout.private_item, privateList);
        ImageView img_edit = (ImageView) view.findViewById(R.id.private_edit);
        img_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Private_editActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        ListView listView = (ListView) view.findViewById(R.id.prv_rlv);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //    Private aprivate = privateList.get(position);
                if (position == 3) {
                    Intent intent = new Intent(getActivity(), Private_businessActivity.class);
                    getActivity().startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(getActivity(), Private_serviceActivity.class);
                    getActivity().startActivity(intent);
                } else {
                    Toast.makeText(getActivity(), "You clicked this", Toast.LENGTH_SHORT).show();
                }
                //     Log.d(TAG,"position="+position);
            }
        });
        ImageView img_setting = (ImageView) view.findViewById(R.id.private_setting);
        img_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SettingActivity.class);
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