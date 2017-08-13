package com.lin.amusement.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lin.amusement.R;
import com.lin.amusement.service.entity.SmallJoke;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 18374 on 2017/8/13.
 */

public class JokeAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<SmallJoke> dataList=new ArrayList<>();
    public JokeAdapter(Context context,List<SmallJoke> dataList) {
        this.context=context;
        this.dataList=dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.jokeitem,null);
        return new JokeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        JokeViewHolder jvh=(JokeViewHolder)holder;
        //Log.i("tag:first time:"," datalist size is"+dataList.size());
        SmallJoke sj=dataList.get(position);
        if(sj.getContent()==null||"".equals(sj.getContent())){
            Log.i("tag:","该段子没有内容");
        }else{
            jvh.jokeTextView.setText(sj.getContent());
        }
    }

    @Override
    public int getItemCount() {
        if(dataList.size()!=0){
            return dataList.size();
        }
        return 0;
    }

    public class JokeViewHolder extends RecyclerView.ViewHolder{
        private TextView jokeTextView;
        public JokeViewHolder(View itemView) {
            super(itemView);
            jokeTextView=(TextView)itemView.findViewById(R.id.joke);//找到单个段子里的textview
        }
    }
}
