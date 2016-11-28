package com.administrator.readhome;

import java.util.List;

/**
 * Created by Administrator on 2016/11/22.
 */

public class BaseEntity {
    private boolean success;
    private String error;
    private List<BookEntity> data;

    public BaseEntity(List<BookEntity> data, String error, boolean success) {
        this.data = data;
        this.error = error;
        this.success = success;
    }

    public List<BookEntity> getData() {
        return data;
    }

    public String getError() {
        return error;
    }

    public boolean isSuccess() {
        return success;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "data=" + data +
                ", success=" + success +
                ", error='" + error + '\'' +
                '}';
    }
}
