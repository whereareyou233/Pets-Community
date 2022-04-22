package function;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;


import com.example.pats_community.R;

import java.util.ArrayList;
import java.util.List;

public class SettingActivity extends AppCompatActivity {

    private List<Settings> settingsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initSettings();
        SettingAdapter adapter = new SettingAdapter(SettingActivity.this,R.layout.setting_item,settingsList);
        ListView listView = (ListView) findViewById(R.id.rlv_setting);
        listView.setAdapter(adapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.setting_toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }

    }

    private void initSettings() {
        Settings settings1 = new Settings(R.mipmap.setting_secure);
        settingsList.add(settings1);
        Settings settings2 = new Settings(R.mipmap.setting_address);
        settingsList.add(settings2);
        Settings settings3 = new Settings(R.mipmap.setting_clean);
        settingsList.add(settings3);
        Settings settings4 = new Settings(R.mipmap.setting_feedback);
        settingsList.add(settings4);
        Settings settings5 = new Settings(R.mipmap.setting_about);
        settingsList.add(settings5);
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