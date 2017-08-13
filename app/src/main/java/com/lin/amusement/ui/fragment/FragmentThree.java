package com.lin.amusement.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lin.amusement.R;

/**
 * Created by 18374 on 2017/8/10.
 * nflate()的作用就是将一个用xml定义的布局文件查找出来，注意与findViewById()的区别，
 * inflate是加载一个布局文件，而findViewById则是从布局文件中查找一个控件。
 */

public class FragmentThree extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_three,container,false);
    }
}
