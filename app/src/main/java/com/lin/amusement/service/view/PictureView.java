package com.lin.amusement.service.view;

import com.lin.amusement.service.entity.Picture;

import java.util.List;

/**
 * Created by 18374 on 2017/8/10.
 */

public interface PictureView extends View {
    void onSuccess(Picture picture);
    void onError(String result);
}
