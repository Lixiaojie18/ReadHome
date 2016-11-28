package com.administrator.readhome;

/**
 * Created by Administrator on 2016/11/21.
 */

public class BookEntity {

    private String objectId;
    private String title; // 标题
    private String publisher; // 出版社
    private String price; // 价格
    private String img; // 图像
    private String author; // 作者

    public String getAuthor() {
        return author;
    }

    public String getImg() {
        return img;
    }

    public String getObjectId() {
        return objectId;
    }

    public String getPrice() {
        return price;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "author='" + author + '\'' +
                ", objectId='" + objectId + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price='" + price + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
