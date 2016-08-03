package com.example.okhttpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.okhttpdemo.iview.IMainView;
import com.example.okhttpdemo.presenter.MainPresenter;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, IMainView {
    private String TAG = MainActivity.class.getSimpleName();
    private TextView tvResult;

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenter(this);
        initVIew();
    }

    private void initVIew() {
        findViewById(R.id.data_result_label).setOnClickListener(this);
        tvResult = (TextView) findViewById(R.id.data_result);
        findViewById(R.id.taskList).setOnClickListener(this);
        findViewById(R.id.getRecords).setOnClickListener(this);
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
        }

    }


    @Override
    public void setResult(String result) {
        tvResult.setText(result);
    }
}
