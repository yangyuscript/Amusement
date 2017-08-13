package com.lin.amusement.service.manager;

import android.content.Context;

import com.lin.amusement.service.RetrofitHelper;
import com.lin.amusement.service.RetrofitService;
import com.lin.amusement.service.entity.Book;
import com.lin.amusement.service.entity.Joke;
import com.lin.amusement.service.entity.Picture;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by 18374 on 2017/8/8.
 * 在它的构造方法中，我们得到了RetrofitService 的实例化，然后定义了一个和RetrofitService 中同名的方法，
 * 里面其实就是调用RetrofitService 中的这个方法。这样，把RetrofitService 中定义的方法都封装到DataManager 中，
 * 以后无论在哪个要调用方法时直接在DataManager 中调用就可以了，而不是重复建立RetrofitService 的实例化，再调用其中的方法。
 */

public class DataManager {
    private RetrofitService mRetrofitService;
    public DataManager(Context context){
        this.mRetrofitService= RetrofitHelper.getInstance(context).getServer();
    }
    public Observable<Book> getSearchBooks(String name, String tag, int start, int count){
        return mRetrofitService.getSearchBooks(name,tag,start,count);
    }
    public Observable<Picture> getPictures(String url){
        return mRetrofitService.getPictures(url);
    }
    public Observable<Picture> getMorePictures(String url,String pn){
        return mRetrofitService.getMorePictures(url,pn);
    }
    public Observable<Joke> getJokes(String url){
        return mRetrofitService.getJoke(url);
    }
}
