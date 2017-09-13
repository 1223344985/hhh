package com.bwie.action.tianzhaoyang1507a20170911;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

/**
 * Created by ASUS on 2017/9/11.
 */
public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<Data.DataEntity.ComicsEntity> list;
    ImageLoader imageLoader;
    DisplayImageOptions options;

    public MyAdapter(Context context, List<Data.DataEntity.ComicsEntity> list) {
        this.context = context;
        this.list = list;

        //创建默认的ImageLoader配置参数
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration
                .createDefault(context);

        //将configuration配置到imageloader中
        imageLoader= ImageLoader.getInstance();
        imageLoader.init(configuration);
        options=new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.ARGB_8888)
                .showImageOnLoading(R.mipmap.ic_launcher)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .build();
    }

    @Override
    public int getCount() {
        return list==null?0:list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            convertView = View.inflate(context,R.layout.item,null);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.name2 = (TextView) convertView.findViewById(R.id.name2);
            holder.img = (ImageView) convertView.findViewById(R.id.img);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        Data.DataEntity.ComicsEntity bean = list.get(position);
        holder.name.setText(bean.getTopic().getTitle());
        holder.name2.setText(bean.getTitle());
        imageLoader.displayImage(bean.getCover_image_url(),holder.img,options);
        return convertView;
    }
    class ViewHolder{
        TextView name,name2;
        ImageView img;
    }
}
