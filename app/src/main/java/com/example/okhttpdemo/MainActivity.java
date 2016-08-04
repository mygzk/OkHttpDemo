package com.example.okhttpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.okhttpdemo.iview.IMainView;
import com.example.okhttpdemo.presenter.MainPresenter;
import com.okhttp.libary.OkHttpManager;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, IMainView {
    private String TAG = MainActivity.class.getSimpleName();
    private TextView tvResult;

    private MainPresenter mainPresenter;
    private OkHttpManager okHttpManager = OkHttpManager.getInstance();
    private Map<String, Object> params = new HashMap<>();
    private TextView tvResultLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenter(this);

        initVIew();
    }

    private void initVIew() {
        tvResultLabel = (TextView) findViewById(R.id.data_result_label);
        tvResultLabel.setOnClickListener(this);
        tvResult = (TextView) findViewById(R.id.data_result);
        findViewById(R.id.taskList).setOnClickListener(this);
        findViewById(R.id.getRecords).setOnClickListener(this);
        findViewById(R.id.down).setOnClickListener(this);
        findViewById(R.id.upload).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.data_result_label:
                tvResult.setText("");
                break;
            case R.id.taskList:
                mainPresenter.getMyTaskList("15021362837");
                break;
            case R.id.getRecords:
                mainPresenter.getRecordList("15021362837");
                break;
            case R.id.down:
                mainPresenter.down();
                break;
            case R.id.upload:
                mainPresenter.upload();
                break;
        }

    }


    @Override
    public void setResult(String result) {
        tvResult.setText(result);
    }

    @Override
    public void setResultProgress(long total, long current) {
        tvResultLabel.setText("总长度：" + total + "  进度:" + current);
    }
}
