package com.lin.amusement.service.view;

import com.lin.amusement.service.entity.Joke;

/**
 * Created by 18374 on 2017/8/13.
 */

public interface JokeView extends View{
    void onSuccess(Joke joke);
    void onError(String result);
}
