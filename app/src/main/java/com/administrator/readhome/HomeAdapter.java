package com.administrator.readhome;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/21.
 */

public class HomeAdapter extends BaseAdapter {

    private List<BookEntity> bookList;

    public HomeAdapter() {
        this.bookList = new ArrayList();
    }

    @Override
    public int getCount() {
        return bookList.size();
    }

    @Override
    public BookEntity getItem(int i) {
        return bookList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder vh;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_data,
                    viewGroup, false);
            vh = new ViewHolder(view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }
        BookEntity bookEntity = getItem(i);
        vh.tv_title.setText(bookEntity.getTitle());
        vh.tv_author.setText(bookEntity.getAuthor());
        vh.tv_publisher.setText(bookEntity.getPublisher());
        vh.tv_price.setText(bookEntity.getPrice());
        vh.tv_price.setVisibility(bookEntity.getPrice() == null ? View.VISIBLE : View.VISIBLE);

        Glide.with(vh.iv_cover.getContext())
                .load(bookEntity.getImg())
                .into(vh.iv_cover);
        return view;
    }

    public void setBooks(List<BookEntity> books) {
        bookList.clear();
        bookList.addAll(books);
        notifyDataSetChanged();
    }

    private class ViewHolder {
        private ImageView iv_cover; //封面
        private TextView tv_title;  //标题
        private TextView tv_author; //作者
        private TextView tv_price;  //价格
        private TextView tv_publisher;  //出版社

        public ViewHolder(View itemView) {
            iv_cover = (ImageView) itemView.findViewById(R.id.iv_cover);
            tv_author = (TextView) itemView.findViewById(R.id.tv_author);
            tv_price = (TextView) itemView.findViewById(R.id.tv_price);
            tv_publisher = (TextView) itemView.findViewById(R.id.tv_publisher);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}
