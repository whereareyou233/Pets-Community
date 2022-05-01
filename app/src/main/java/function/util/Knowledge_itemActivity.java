package function.util;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.pats_community.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class Knowledge_itemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge_item);
        Intent intent = getIntent();
        String knowledgeName = intent.getStringExtra("title");
       // String knowledgeName = "hc";
   //     int knowledgeId = intent.getIntExtra("picture",0);

        String knowledgeContent = intent.getStringExtra("content");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        ImageView knowledgeView = (ImageView) findViewById(R.id.knowledge_item);
        TextView knowledgeText = (TextView) findViewById(R.id.knowledge_content);
        setSupportActionBar(toolbar);	//设置支持标题栏
        //设置返回键
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setTitle(knowledgeName);
        Bitmap knowledgeId = (Bitmap) getIntent().getParcelableExtra("picture");
        Glide.with(this).load(knowledgeId).into(knowledgeView);
    //    knowledgeView.setImageBitmap((Bitmap) getIntent().getParcelableExtra("picture"));
        knowledgeText.setText(knowledgeContent);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case android.R.id.home: finish();
                return true;
        }

        return false;
    }
}