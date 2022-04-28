package function;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.pats_community.R;

import function.util.AnimalActivity;
import function.util.ConvenientServiceActivity;
import function.util.DataRestoreActivity;
import function.util.FitControlActivity;


public class ShujuFragment extends Fragment {

    CardView view_pat;
    CardView view_1;
    CardView view_2;
    CardView view_3;
    CardView view_4;


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case 1:if(resultCode==RESULT_OK){

            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shuju, container, false);

        view_4 = view.findViewById(R.id.c4);
        view_pat=view.findViewById(R.id.card_pat);
        view_1=view.findViewById(R.id.c1);
        view_2=view.findViewById(R.id.c2);
        view_pat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        view_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FitControlActivity.class);
                startActivityForResult(intent,1);
            }
        });
        view_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ConvenientServiceActivity.class);
                startActivityForResult(intent,1);
            }
        });

        view_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), AnimalActivity.class);
                startActivity(intent);

            }
        });

        view_3=view.findViewById(R.id.c3);
        view_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),AnimalActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }


}