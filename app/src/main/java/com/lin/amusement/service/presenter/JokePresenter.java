package com.lin.amusement.service.presenter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.lin.amusement.service.entity.Joke;
import com.lin.amusement.service.manager.DataManager;
import com.lin.amusement.service.view.JokeView;
import com.lin.amusement.service.view.View;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by 18374 on 2017/8/13.
 */

public class JokePresenter implements Presenter {
    private DataManager manager;
    private CompositeSubscription compositeSubscription;
    private Context context;
    private JokeView jokeView;
    private Joke mjoke;
    public JokePresenter(Context context) {
        this.context=context;
    }

    @Override
    public void onCreate() {
        manager=new DataManager(context);
        compositeSubscription=new CompositeSubscription();
        Log.i("tag:","执行了PicturePersenter里的onCreate（）");
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        if (compositeSubscription.hasSubscriptions()){
            compositeSubscription.unsubscribe();
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void attachView(View view) {
        jokeView=(JokeView)view;
    }

    @Override
    public void attachIncomingIntent(Intent intent) {

    }

    public void getJokes(String url){
        compositeSubscription.add(manager.getJokes(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Joke>() {
                    @Override
                    public void onCompleted() {
                        Log.i("tag:","onCompleted");
                        if(mjoke!=null){
                            jokeView.onSuccess(mjoke);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        jokeView.onError("请求失败!");
                    }

                    @Override
                    public void onNext(Joke joke) {
                        Log.i("tag:",joke.getData().get(0).getContent());
                        mjoke=joke;
                        Log.i("tag:","得到joke");
                    }
                })
        );
    }
}
