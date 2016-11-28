package com.administrator.readhome;

import android.util.Log;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2016/11/21.
 */

public class HomeData {

    private static HomeData sInstance;

    public static HomeData getsInstance(){
        if(sInstance == null){
            sInstance = new HomeData();
        }
        return sInstance;
    }

    public HomeData() {
        this.eventbus = EventBus.getDefault();
        this.gson = new Gson();
    }

    private String url = "http://cloud.bmob.cn/5a3f440fff51573e/books";
    private EventBus eventbus;
    private Gson gson;

    public void asynGetBooks(){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                BaseEntity entity = new BaseEntity(null, e.getMessage(), false);
                Log.i(TAG, "onFailure: -------------"+entity);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    String content = response.body().string();
                    BaseEntity entity = gson.fromJson(content, BaseEntity.class);
                    eventbus.post(entity);
                }
            }
        });


    }
}
