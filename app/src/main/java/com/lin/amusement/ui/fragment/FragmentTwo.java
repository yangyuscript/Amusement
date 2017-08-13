package com.lin.amusement.ui.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lin.amusement.R;
import com.lin.amusement.service.entity.Picture;

import com.lin.amusement.service.entity.SmallPicture;
import com.lin.amusement.service.presenter.PicturePresenter;
import com.lin.amusement.service.view.PictureView;
import com.lin.amusement.ui.adapter.WaterFallAdapter;
import com.lin.amusement.ui.listener.EndlessRecyclerOnScrollListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;


/**
 * Created by 18374 on 2017/8/10.
 * nflate()的作用就是将一个用xml定义的布局文件查找出来，注意与findViewById()的区别，
 * inflate是加载一个布局文件，而findViewById则是从布局文件中查找一个控件。
 */

public class FragmentTwo extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private WaterFallAdapter mAdapter;
    private PicturePresenter picturePresenter;
    private Context context;
    private List<SmallPicture> dataList=new ArrayList<>();
    //上拉刷新，下拉加载
    private SwipeRefreshLayout swipeRefreshLayout;
    private View viewfuck;
    private HashSet hs=new HashSet();
    private String pn;
    private PictureView pictureView=new PictureView() {
        @Override
        public void onSuccess(Picture picture) {
            Log.i("tag:picture is",picture.getData().get(0).getThumbURL());
            for(int i=0,len=picture.getData().size();i<len;i++){
                SmallPicture smallPicture=new SmallPicture();
                smallPicture.setSrc(picture.getData().get(i).getThumbURL());
                smallPicture.setImgHeight(i%2*100+400);
                dataList.add(smallPicture);
            }
            mAdapter.notifyDataSetChanged();
            Log.i("tag:","此时已执行notifyDataSetChanged");
        }

        @Override
        public void onError(String result) {
            Toast.makeText(context,result,Toast.LENGTH_SHORT).show();
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_two,container,false);
        context=view.getContext();
        viewfuck=view;
        picturePresenter=new PicturePresenter(view.getContext());
        picturePresenter.onCreate();
        picturePresenter.attachView(pictureView);
        picturePresenter.getPictures("https://image.baidu.com/search/acjson?tn=resultjson_com&ipn=rj&ct=201326592&is=&fp=result&queryWord=%E7%BE%8E%E5%A5%B3&cl=2&lm=-1&ie=utf-8&oe=utf-8&adpicid=&st=-1&z=&ic=0&word=%E7%BE%8E%E5%A5%B3&s=&se=&tab=&width=&height=&face=0&istype=2&qc=&nc=1&fr=&cg=girl&pn=120&rn=30&gsm=78&1502355291876=");
        swipeRefreshLayout=(SwipeRefreshLayout)view.findViewById(R.id.swipeRefreshLayout_pic);
        swipeRefreshLayout.setColorSchemeResources(R.color.google_blue,R.color.google_green,R.color.google_red,R.color.google_yellow);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Observable.timer(2, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                          .map(new Func1<Long, Object>() {
                              @Override
                              public Object call(Long aLong) {
                                  swipeRefreshLayout.setRefreshing(false);
                                  //mAdapter.notifyDataSetChanged();
                                  return null;
                              }
                          }).subscribe();
            }
        });
        mRecyclerView=(RecyclerView)view.findViewById(R.id.pictureListView);
        mRecyclerView.setHasFixedSize(true);
        //设置布局管理器为2列，纵向
        mLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter=new WaterFallAdapter(context,dataList);
        mRecyclerView.setAdapter(mAdapter);
        //为RecyclerView添加HeaderView和FooterView
        //上拉加载
        mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
            @Override
            public void onLoadMore() {
                Observable.timer(2, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                        .map(new Func1<Long, Object>() {
                            @Override
                            public Object call(Long aLong) {
                                getPN();
                                Log.i("PN is:",pn);
                                picturePresenter.getMorePictures("https://image.baidu.com/search/acjson?tn=resultjson_com&ipn=rj&ct=201326592&is=&fp=result&queryWord=%E7%BE%8E%E5%A5%B3&cl=2&lm=-1&ie=utf-8&oe=utf-8&adpicid=&st=-1&z=&ic=0&word=%E7%BE%8E%E5%A5%B3&s=&se=&tab=&width=&height=&face=0&istype=2&qc=&nc=1&fr=&cg=girl&rn=30&gsm=78&1502355291876=",pn);
                                Toast.makeText(viewfuck.getContext(), "加载完成", Toast.LENGTH_SHORT).show();
                                Log.i("tag:","上拉加载数据");
                                return null;
                            }
                        }).subscribe();
            }
        });
        Log.i("tag:","what the fuck!");
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        picturePresenter.onStop();
    }

    //get a never appear num
    public void getPN(){
        int pnInt=new Random().nextInt(2000)+1;
        if(hs.add(pnInt)){
            pn=String.valueOf(pnInt);
        }else{
            getPN();
        }
    }

}
