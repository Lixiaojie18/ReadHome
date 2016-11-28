package com.administrator.readhome;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class HomeActivity extends Activity implements HomeView {

    private ListView listView;
    private HomeAdapter adapter;
    private HomePresenter presenter;
    private SwipeRefreshLayout layout_refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        layout_refresh = (SwipeRefreshLayout) findViewById(R.id.layout_refresh);
        listView = (ListView) findViewById(R.id.listView);
        presenter = new HomePresenter();
        presenter.onCreate();
        presenter.attachView(this);

        adapter = new HomeAdapter();
        listView.setAdapter(adapter);

        layout_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override public void onRefresh() {
                presenter.getBooks(true);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getBooks(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
        presenter.onDestory();
    }

    @Override
    public void setBooks(List<BookEntity> books) {
        adapter.setBooks(books);
    }

    @Override
    public void setRefreshing(boolean refreshing) {
        layout_refresh.setRefreshing(refreshing);
    }

    @Override
    public void showRefreshFail(String msg) {
        Toast.makeText(this, "刷新失败", Toast.LENGTH_SHORT).show();
    }

}
