package com.administrator.readhome;

import android.support.annotation.NonNull;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2016/11/22.
 */

public abstract class MvpPresenter <V extends MvpView> {

    private V view;

    public final void onCreate(){
        EventBus.getDefault().register(this);
    }

    public final void attachView(V view){
        this.view = view;
    }

    public final void detachView(){
        this.view = getNullObject();
    }

    public final void onDestory(){
        EventBus.getDefault().unregister(this);
    }

    protected final V getView(){
        return view;
    }

    protected abstract @NonNull V getNullObject();
}
