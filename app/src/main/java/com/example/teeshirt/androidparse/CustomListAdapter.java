package com.example.teeshirt.androidparse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter{
    private ArrayList listData;
    private LayoutInflater layoutInflater;

    public CustomListAdapter(Context context, ArrayList listData){
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            convertView = layoutInflater.inflate(R.layout.list_items,null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.pic);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }


        if (holder.imageView !=null){
            new ImageDownloaderTask(holder.imageView).execute();
        }
        return convertView;
    }

    static class ViewHolder{
        ImageView imageView;
    }
}
