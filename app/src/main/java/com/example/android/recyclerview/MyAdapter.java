package com.example.android.recyclerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private List<String> Datas;
    private Context mContext;

    public MyAdapter(List<String> datas, Context mContext) {
        Datas = datas;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return Datas.size();
    }

    @Override
    public Object getItem(int i) {
        return Datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = LayoutInflater.from(mContext).inflate(R.layout.image_item,viewGroup,false);
        ImageView imageView1 = (ImageView) view1.findViewById(R.id.image1);
//        imageView1.setImageResource(R.drawable.testpic1);
//        ImageView imageView2 = (ImageView) view1.findViewById(R.id.image);
//        imageView2.setImageResource(R.drawable.testpic1);
//        ImageView imageView3 = (ImageView) view1.findViewById(R.id.image);
//        imageView3.setImageResource(R.drawable.testpic1);
        Bitmap bm = BitmapFactory.decodeFile(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath() + "/" + (i+1) + ".jpg");
        Log.d("mzl", "getView i ：" + i + " view: " + view1);
        imageView1.setImageBitmap(bm);
        TextView textView1 = (TextView) view1.findViewById(R.id.word);
        textView1.setText(Datas.get(i));
//        此处需要返回view 不能是view中某一个
        return view1;
    }
}
