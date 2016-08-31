package com.zwhkj.todaynews.todaynews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import java.util.ArrayList;
import java.util.List;

public abstract class CommonAdapter<T> extends BaseAdapter {
    protected LayoutInflater mInflater;
    protected Context mContext;
    protected List<T> mDatas;
    protected final int mItemLayoutId;

    public CommonAdapter(Context context, List<T> mDatas, int itemLayoutId) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        this.mDatas = mDatas;
        this.mItemLayoutId = itemLayoutId;
    }

    public CommonAdapter(Context context, int itemLayoutId) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        this.mItemLayoutId = itemLayoutId;
    }

    public List<T> getmDatas() {
        return mDatas;
    }
    public void setmDatas(List<T> mDatas) {
        this.mDatas = mDatas;
    }

    public void addList(List<T> datas)
    {
        if (null == mDatas)
        {
            mDatas = new ArrayList<T>();
        }
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    public  void clear()
    {
       clear(false);
    }

    public  void clear(boolean refresh)
    {
        if(null != mDatas)
        {
            mDatas.clear();
        }
        if(refresh)notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return null != mDatas?mDatas.size():0;
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolderCome viewHolder = getViewHolder(position, convertView,
                parent);
        convert(viewHolder, getItem(position));
        return viewHolder.getConvertView();

    }

    public abstract void convert(ViewHolderCome helper, T item);

    private ViewHolderCome getViewHolder(int position, View convertView,
                                         ViewGroup parent) {
        return ViewHolderCome.get(mContext, convertView, parent, mItemLayoutId,
                position);
    }

}
