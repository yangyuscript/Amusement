package com.lin.amusement.service;





import com.lin.amusement.service.entity.Book;
import com.lin.amusement.service.entity.Joke;
import com.lin.amusement.service.entity.Picture;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by 18374 on 2017/8/8.
 *
 */

public interface RetrofitService {
    @GET("book/search")
    Observable<Book> getSearchBooks(@Query("q") String name,
                                    @Query("tag") String tag,
                                    @Query("start") int start,
                                    @Query("count") int count);
    @GET
    Observable<Picture> getPictures(@Url String url);

    @GET
    Observable<Picture> getMorePictures(@Url String url,@Query("pn") String pn);

    @GET
    Observable<Joke> getJoke(@Url String url);
}
