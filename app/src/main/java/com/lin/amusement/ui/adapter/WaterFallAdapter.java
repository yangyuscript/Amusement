package com.lin.amusement.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.lin.amusement.R;
import com.lin.amusement.service.entity.Picture;
import com.lin.amusement.service.entity.SmallPicture;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 18374 on 2017/8/10.
 */

public class WaterFallAdapter extends RecyclerView.Adapter {
    private Context mcontext;
    //private Picture picture;
    private List<SmallPicture> dataList=new ArrayList<>();

    public WaterFallAdapter(Context mcontext,List<SmallPicture> dataList) {
        this.mcontext=mcontext;
        this.dataList=dataList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.pictureitem,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            MyViewHolder mvh=(MyViewHolder)holder;
            SmallPicture smallPicture=dataList.get(position);
            if(smallPicture.getSrc()==null){
                Log.i("tag:","这个smallpic为空");
            }else {
                Log.i("tag:uri", smallPicture.getSrc());
                Uri uri = Uri.parse(smallPicture.getSrc());
                mvh.picture_item.setImageURI(uri);
                mvh.picture_item.getLayoutParams().height = smallPicture.getImgHeight();
            }
    }

    @Override
    public int getItemCount() {
        if(dataList!=null){
            return dataList.size();
        }
        return 0;
    }


    //定义自己的ViewHolder，将View的控件引用在成员变量上（通过view对象.findViewById()找到要绑定数据的控件）
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public SimpleDraweeView picture_item;
        public MyViewHolder(View itemView){
            super(itemView);
            picture_item=(SimpleDraweeView)itemView.findViewById(R.id.picture);
        }
    }
}
