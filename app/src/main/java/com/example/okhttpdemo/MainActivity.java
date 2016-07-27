package com.example.okhttpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.okhttpdemo.okhttutils.RequestManager;

import java.io.File;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RequestManager requestManager;
    String url = "test.php";
    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestManager = RequestManager.getInstance(this);
        initVIew();
    }

    private void initVIew() {
        findViewById(R.id.synget).setOnClickListener(this);
        findViewById(R.id.synpost).setOnClickListener(this);
        findViewById(R.id.enget).setOnClickListener(this);
        findViewById(R.id.enpost).setOnClickListener(this);

        findViewById(R.id.upload1).setOnClickListener(this);
        findViewById(R.id.upload2).setOnClickListener(this);
        findViewById(R.id.upload3).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.synget:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        testSynGet();
                    }
                }).start();

                break;
            case R.id.synpost:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        testSynpost();
                    }
                }).start();

                break;
            case R.id.enget:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        testenget();
                    }
                }).start();

                break;
            case R.id.enpost:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        testenpost();
                    }
                }).start();
            case R.id.upload1:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        testUpload1();
                    }
                }).start();
            case R.id.upload2:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        testUpload2();
                    }
                }).start();
            case R.id.upload3:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        testUpload3();
                    }
                }).start();


                break;

        }

    }

    String filepath ="/sdcard/aa.apk";
    String filepath1 ="/sdcard/logfile.txt";
    private void testUpload1() {
        requestManager.upLoadFile(url, filepath, new RequestManager.ReqCallBack<String>() {
            @Override
            public void onReqSuccess(String result) {
                Log.e(TAG, "testUpload1 onReqSuccess----->" + result);
            }

            @Override
            public void onReqFailed(String errorMsg) {
                Log.e(TAG, "testUpload1 onReqSuccess----->" + errorMsg);
            }
        });
    }

    private void testUpload2() {
        HashMap<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("name", "gzk");
        paramsMap.put("age", "22");
        paramsMap.put("file", new File(filepath));
        paramsMap.put("file1", new File(filepath1));
        requestManager.upLoadFile(url, paramsMap, new RequestManager.ReqCallBack<String>() {
            @Override
            public void onReqSuccess(String result) {
                Log.e(TAG, "testUpload2 onReqSuccess----->" + result);
            }

            @Override
            public void onReqFailed(String errorMsg) {
                Log.e(TAG, "testUpload2 onReqSuccess----->" + errorMsg);
            }
        });
    }

    private void testUpload3() {
        HashMap<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("name", "gzk");
        paramsMap.put("age", "22");
        paramsMap.put("file", new File(filepath));
        paramsMap.put("file1", new File(filepath1));

        requestManager.upLoadFile(url, paramsMap, new RequestManager.ReqProgressCallBack<String>() {
            @Override
            public void onProgress(long total, long current) {
                Log.e(TAG, "testUpload3 onProgress total----->" + total+ "   current----->" + current);
            }

            @Override
            public void onReqSuccess(String result) {
                Log.e(TAG, "testUpload3 onReqSuccess----->" + result);
            }

            @Override
            public void onReqFailed(String errorMsg) {
                Log.e(TAG, "testUpload3 onReqSuccess----->" + errorMsg);
            }
        });

     /*   requestManager.upLoadFile(RequestManager.MEDIA_OBJECT_STREAM, new File(filepath), new RequestManager.ReqProgressCallBack<String>() {
            @Override
            public void onProgress(long total, long current) {
                Log.e(TAG, "testUpload3 onProgress total----->" + total);
                Log.e(TAG, "testUpload3 onProgress current----->" + current);
            }

            @Override
            public void onReqSuccess(String result) {
                Log.e(TAG, "testUpload3 onReqSuccess----->" + result);
            }

            @Override
            public void onReqFailed(String errorMsg) {
                Log.e(TAG, "testUpload3 onReqSuccess----->" + errorMsg);
            }
        });*/
    }


    private void testSynGet() {
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("name", "gzk");
        paramsMap.put("age", "22");
        requestManager.requestSyn(url, RequestManager.TYPE_GET, paramsMap);
    }

    private void testSynpost() {
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("name", "gzk");
        paramsMap.put("age", "22");
        requestManager.requestSyn(url, RequestManager.TYPE_POST_FORM, paramsMap);

    }

    private void testenget() {
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("name", "gzk");
        paramsMap.put("age", "22");
        requestManager.requestAsyn(url, RequestManager.TYPE_GET, paramsMap, new RequestManager.ReqCallBack<Object>() {
            @Override
            public void onReqSuccess(Object result) {
                Log.e(TAG, "testenget onReqSuccess----->" + result);
            }

            @Override
            public void onReqFailed(String errorMsg) {
                Log.e(TAG, "testenget onReqFailed----->" + errorMsg);
            }
        });
    }

    private void testenpost() {
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("name", "gzk");
        paramsMap.put("age", "22");
        requestManager.requestAsyn(url, RequestManager.TYPE_POST_FORM, paramsMap, new RequestManager.ReqCallBack<Object>() {
            @Override
            public void onReqSuccess(Object result) {
                Log.e(TAG, "testenpost onReqSuccess----->" + result);
            }

            @Override
            public void onReqFailed(String errorMsg) {
                Log.e(TAG, "testenpost onReqFailed----->" + errorMsg);
            }
        });
    }


}
