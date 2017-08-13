package com.lin.amusement.ui.listener;

import android.support.v7.widget.RecyclerView;
import android.util.Log;


/**
 * Created by 18374 on 2017/8/12.
 */

public abstract class EndlessRecyclerOnScrollListener extends RecyclerView.OnScrollListener {


    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        if(recyclerView==null){
            Log.i("tag:","recyclerView is null");
        }
        Log.i("tag:",""+recyclerView.computeVerticalScrollExtent()+" "+recyclerView.computeVerticalScrollOffset()+" "+recyclerView.computeVerticalScrollRange());
        if(recyclerView.computeVerticalScrollExtent()+recyclerView.computeVerticalScrollOffset()>=recyclerView.computeVerticalScrollRange()){
            onLoadMore();
        }else{
            Log.i("tag:","onscrolled not");
        }
    }

    public abstract void onLoadMore();
}
