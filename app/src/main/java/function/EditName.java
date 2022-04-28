package function;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.pats_community.R;
import com.example.pats_community.User;

import org.litepal.crud.DataSupport;

import util.ActivityCollector;
import widget.TitleLayout;

public class EditName extends AppCompatActivity {
    private TitleLayout tl_title;
    private EditText edit_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
        setContentView(R.layout.activity_edit_name);

        User user = DataSupport.findLast(User.class);

        tl_title = (TitleLayout) findViewById(R.id.tl_title);
        edit_name = (EditText) findViewById(R.id.et_edit_name);
        edit_name.setText(user.getName());

        //设置监听器
        //如果点击完成，则更新loginUser并销毁
        tl_title.getTextView_forward().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setName(edit_name.getText().toString());
                user.save();
                setResult(RESULT_OK);
                finish();
            }
        });
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}