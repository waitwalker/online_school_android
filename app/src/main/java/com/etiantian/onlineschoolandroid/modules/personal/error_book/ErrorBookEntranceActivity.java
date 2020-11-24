package com.etiantian.onlineschoolandroid.modules.personal.error_book;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.CompoundButtonCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.base.BaseActivity;
import com.etiantian.onlineschoolandroid.modules.personal.my_card_record.MyCardRecordActivity;
import com.jaeger.library.StatusBarUtil;
import com.wuhenzhizao.titlebar.widget.CommonTitleBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ErrorBookEntranceActivity extends BaseActivity implements View.OnClickListener {

    private ViewGroup backButton;
    private ViewGroup navigationBar;
    private TextView back_button;
    private CommonTitleBar commonTitleBar;
    private Button knowledgeButton;

    private ErrorBookEntranceGridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_book_enterance);
        initActionBar();
        initView();
        initData();
    }

    ///
    /// @description actionBar
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/29 9:09 AM
    ///
    private void initActionBar() {
        hideActionBar();
        navigationBar = findViewById(R.id.navigation_bar);
        navigationBar.setBackgroundColor(Color.parseColor("#5FACEF"));
        commonTitleBar = findViewById(R.id.actionbar);
        commonTitleBar.setBackgroundColor(Color.parseColor("#5FACEF"));
        StatusBarUtil.setColor(ErrorBookEntranceActivity.this, Color.parseColor("#5FACEF"));

        backButton = findViewById(R.id.back_container);
        backButton.setOnClickListener(this);
        back_button = findViewById(R.id.action_bar_title);
        back_button.setText("错题本");
        back_button.setTextColor(Color.WHITE);
        back_button.setOnClickListener(this);

        knowledgeButton = findViewById(R.id.right_button);
        knowledgeButton.setOnClickListener(this);
        knowledgeButton.setVisibility(View.INVISIBLE);
    }

    private void initView() {
        gridView = findViewById(R.id.error_book_entrance_grid);
    }

    private void initData() {
        ArrayList<Map> data = new ArrayList<Map>();
        Map map1 = new HashMap();
        // type: 1系统, 2上传, 3数校, 4单元质检
        map1.put("type","1");
        data.add(map1);

        Map map2 = new HashMap();
        // type: 1系统, 2上传, 3数校, 4单元质检
        map2.put("type","2");
        data.add(map2);

        Map map3 = new HashMap();
        // type: 1系统, 2上传, 3数校, 4单元质检
        map3.put("type","3");
        data.add(map3);

        Map map4 = new HashMap();
        // type: 1系统, 2上传, 3数校, 4单元质检
        map4.put("type","4");
        data.add(map4);
        ErrorBookGridViewAdapter adapter = new ErrorBookGridViewAdapter(this, data);
        gridView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_container:
                finish();
                break;
        }
    }
}