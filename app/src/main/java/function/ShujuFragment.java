package function;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pats_community.R;

import java.util.ArrayList;
import java.util.List;


public class ShujuFragment extends Fragment {


    CardView view_1;
    CardView view_2;
    CardView view_3;
    CardView view_4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment_shuju, container, false);

       view_4=view.findViewById(R.id.c4);
       view_4.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent intent=new Intent(getActivity(),PhotoActivity.class);
               startActivity(intent);

           }
       });
       /* list.add(new CardView().findViewById())*/
        return  view;
    }


}