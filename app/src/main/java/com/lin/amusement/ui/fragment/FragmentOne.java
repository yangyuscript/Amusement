package com.lin.amusement.ui.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lin.amusement.R;
import com.lin.amusement.service.entity.Joke;
import com.lin.amusement.service.entity.SmallJoke;
import com.lin.amusement.service.presenter.JokePresenter;
import com.lin.amusement.service.view.JokeView;
import com.lin.amusement.ui.adapter.JokeAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;

/**
 * Created by 18374 on 2017/8/10.
 * nflate()的作用就是将一个用xml定义的布局文件查找出来，注意与findViewById()的区别，
 * inflate是加载一个布局文件，而findViewById则是从布局文件中查找一个控件。
 */

public class FragmentOne extends Fragment {
    private RecyclerView mRecyclerView;
    private Context mContext;
    private JokePresenter jokePresenter;
    private RecyclerView.Adapter mAdapter;
    private List<SmallJoke> dataList=new ArrayList<>();
    //下拉刷新
    private SwipeRefreshLayout swipeRefreshLayout_joke;
    private JokeView jokeView=new JokeView() {
        @Override
        public void onSuccess(Joke joke) {
            dataList.clear();
            for(int i=0,len=joke.getData().size();i<len;i++){
                SmallJoke sj=new SmallJoke(joke.getData().get(i).getContent());
                dataList.add(sj);
            }
            mAdapter.notifyDataSetChanged();
        }

        @Override
        public void onError(String result) {
            Toast.makeText(mContext,result,Toast.LENGTH_SHORT).show();
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_one,container,false);
        mContext=view.getContext();
        jokePresenter=new JokePresenter(mContext);
        init();
        mRecyclerView=(RecyclerView)view.findViewById(R.id.jokesRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        swipeRefreshLayout_joke=(SwipeRefreshLayout)view.findViewById(R.id.swipeRefreshLayout_joke);
        swipeRefreshLayout_joke.setColorSchemeResources(R.color.google_blue,R.color.google_green,R.color.google_red,R.color.google_yellow);
        swipeRefreshLayout_joke.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Observable.timer(2, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                        .map(new Func1<Long, Object>() {
                            @Override
                            public Object call(Long aLong) {
                                swipeRefreshLayout_joke.setRefreshing(false);
                                jokePresenter.getJokes("http://napi.uc.cn/3/classes/topic/lists/%E6%AE%B5%E5%AD%90?_app_id=hottopic&_size=100&_fetch=1&_fetch_incrs=1&_select=like_start%2Cdislike_start%2Cshare_start%2Ctitle%2Ctag%2Cmedia_data%2Ccontent%2Cavatar%2Cuser_name%2Coriginal%2Cis_hot%2Cis_finish%2Ctv_duration");
                                return null;
                            }
                        }).subscribe();
            }
        });
        mAdapter=new JokeAdapter(mContext,dataList);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        jokePresenter.onStop();
    }
    public void init(){
        jokePresenter.attachView(jokeView);
        jokePresenter.onCreate();
        jokePresenter.getJokes("http://napi.uc.cn/3/classes/topic/lists/%E6%AE%B5%E5%AD%90?_app_id=hottopic&_size=100&_fetch=1&_fetch_incrs=1&_select=like_start%2Cdislike_start%2Cshare_start%2Ctitle%2Ctag%2Cmedia_data%2Ccontent%2Cavatar%2Cuser_name%2Coriginal%2Cis_hot%2Cis_finish%2Ctv_duration");
    }
}
