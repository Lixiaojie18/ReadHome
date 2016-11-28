package com.administrator.readhome;

import java.util.List;

/**
 * Created by Administrator on 2016/11/21.
 */

public interface HomeView extends MvpView {

    void setBooks(List<BookEntity> books);

    void setRefreshing(boolean refreshing);

    void showRefreshFail(String msg);

    HomeView NULL = new HomeView() {
        @Override
        public void setBooks(List<BookEntity> books) {

        }

        @Override
        public void setRefreshing(boolean refreshing) {

        }

        @Override
        public void showRefreshFail(String msg) {

        }
    };
}
