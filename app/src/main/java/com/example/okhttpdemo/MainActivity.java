package com.example.okhttpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.okhttpdemo.okhttutils.OkHttpManager;
import com.example.okhttpdemo.okhttutils.RequestManager;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RequestManager requestManager;
    OkHttpManager okHttpManager;
    String url = "test.php";
    String url1 = "http://192.168.253.13/test.php";
    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestManager = RequestManager.getInstance(this);
        okHttpManager = OkHttpManager.instance(this);
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

        findViewById(R.id.down1).setOnClickListener(this);
        findViewById(R.id.down2).setOnClickListener(this);
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

            case R.id.down1:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        testdown1();
                    }
                }).start();
                break;

            case R.id.down2:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        testdown2();
                    }
                }).start();
                break;

        }

    }

    String downUrl = "http://mbdapp.iqiyi.com/j/ap/qiyi.196.apk";
    private String filesavepath = "/sdcard";
    String filepath = "/sdcard/aa.apk";
    String filepath1 = "/sdcard/logfile.txt";

    private void testdown2() {
        requestManager.downLoadFile(downUrl, "aiqiyi.apk", filesavepath, new RequestManager.ReqProgressCallBack<File>() {
            @Override
            public void onProgress(long total, long current) {
                Log.e(TAG, "testdown2 onProgress  total----->" + total + "  current-->" + current);
            }

            @Override
            public void onReqSuccess(File result) {
                Log.e(TAG, "testdown2 onReqSuccess----->" + result.getName());
            }

            @Override
            public void onReqFailed(String errorMsg) {
                Log.e(TAG, "testdown2 onReqFailed----->" + errorMsg);
            }
        });
    }


    private void testdown1() {
        requestManager.downLoadFile(downUrl, "aiqiyi.apk", filesavepath, new RequestManager.ReqCallBack<File>() {
            @Override
            public void onReqSuccess(File result) {
                Log.e(TAG, "testdown1 onReqSuccess----->" + result.getName());
            }

            @Override
            public void onReqFailed(String errorMsg) {

                Log.e(TAG, "testdown1 onReqFailed----->" + errorMsg);
            }
        });


    }

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
                Log.e(TAG, "testUpload3 onProgress total----->" + total + "   current----->" + current);
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
        try {
            okHttpManager.get(url1).
                    params(paramsMap).
                    buidRequest().
                    build().
                    enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            Log.e(TAG, "testenget onReqSuccess----->" + e.toString());
                            e.printStackTrace();
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            Log.e(TAG, "testenget onReqSuccess----->" + response.body().string());
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }


        //requestManager.requestSyn(url, RequestManager.TYPE_GET, paramsMap);
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
