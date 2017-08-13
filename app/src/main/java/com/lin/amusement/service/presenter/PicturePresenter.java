package com.lin.amusement.service.presenter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;


import com.lin.amusement.service.entity.Picture;
import com.lin.amusement.service.manager.DataManager;
import com.lin.amusement.service.view.PictureView;
import com.lin.amusement.service.view.View;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by 18374 on 2017/8/10.
 */

public class PicturePresenter implements Presenter {
    private DataManager manager;
    private CompositeSubscription compositeSubscription;
    private Context context;
    private PictureView pictureView;
    private Picture picturebody;
    public PicturePresenter(Context context) {
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
        pictureView=(PictureView)view;
    }

    @Override
    public void attachIncomingIntent(Intent intent) {

    }

    public void getPictures(String url){
        Log.i("tag:","执行了PicturePersenter里的getPictures（）");
        compositeSubscription.add(manager.getPictures(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Picture>() {
                    @Override
                    public void onCompleted() {
                        Log.i("tag:","onCompleted");
                        if(picturebody!=null){
                            Log.i("tag:","onCompleted中picturebody不为null"+picturebody.getData().get(0).getThumbURL());
                            pictureView.onSuccess(picturebody);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Log.i("tag:","未能得到picture，请求失败");
                        pictureView.onError("请求失败!");
                    }

                    @Override
                    public void onNext(Picture picture) {
                        Log.i("tag:","还未得到picture");
                        Log.i("tag:",picture.getData().get(0).getThumbURL());
                        picturebody=picture;
                        Log.i("tag:","得到picture");
                    }
                })
        );
        //Log.i("tag:","fuckyou"+picturebody.getData().get(0).getThumbURL());
    }
    public void getMorePictures(String url,String pn){
        Log.i("tag:","执行了PicturePersenter里的getMorePictures（）");
        compositeSubscription.add(manager.getMorePictures(url,pn)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Picture>() {
                    @Override
                    public void onCompleted() {
                        Log.i("tag:","onCompleted");
                        if(picturebody!=null){
                            Log.i("tag:","onCompleted中picturebody不为null"+picturebody.getData().get(0).getThumbURL());
                            pictureView.onSuccess(picturebody);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Log.i("tag:","未能得到picture，请求失败");
                        pictureView.onError("请求失败!");
                    }

                    @Override
                    public void onNext(Picture picture) {
                        Log.i("tag:","还未得到picture");
                        Log.i("tag:",picture.getData().get(0).getThumbURL());
                        picturebody=picture;
                        Log.i("tag:","得到picture");
                    }
                })
        );
        //Log.i("tag:","fuckyou"+picturebody.getData().get(0).getThumbURL());
    }
}
