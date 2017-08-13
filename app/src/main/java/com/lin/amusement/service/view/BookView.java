package com.lin.amusement.service.view;

import com.lin.amusement.service.entity.Book;

/**
 * Created by 18374 on 2017/8/8.
 */

public interface BookView extends View {
    void onSuccess(Book book);
    void onError(String result);
}
