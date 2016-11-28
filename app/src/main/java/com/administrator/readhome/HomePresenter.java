package com.administrator.readhome;

import android.support.annotation.NonNull;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * Created by Administrator on 2016/11/21.
 */

public class HomePresenter extends MvpPresenter<HomeView> {

    private List<BookEntity> books;


    public final void getBooks(boolean isLoader){
        if(!isLoader){
            if(books != null){
                getView().setBooks(books);
                return;
            }
            getView().setRefreshing(true);
        }
        HomeData.getsInstance().asynGetBooks();
    }

    @NonNull
    @Override
    protected HomeView getNullObject() {
        return HomeView.NULL;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(BaseEntity entity){
        getView().setRefreshing(false);
        if(entity.isSuccess()){
            books = entity.getData();
            getView().setBooks(books);
        } else{
            getView().showRefreshFail(entity.getError());
        }
    }
}
