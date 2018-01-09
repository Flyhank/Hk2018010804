package com.n9s.flyjet.hk2018010804;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Student on 2018/1/9.
 */

public class MyAdapter extends BaseAdapter
{
    ArrayList<Map<String, Object>> mylist = new ArrayList();

    boolean chks[] = new boolean[8]; //有8筆資料: 避免勾選資料移動畫面時消失

    Context context;

    public MyAdapter(Context context, ArrayList<Map<String, Object>> mylist, boolean chks[])
    {
        this.context = context;
        this.mylist = mylist;
        this.chks = chks; //顯示勾選之項目
    }  //因BaseAdapter是抽象類別,一定要繼承

        @Override
        public int getCount()
        {
            //return str.length;   //Array用.length; 共幾個選項
            return mylist.size(); //ArrayList用.size
        }

        @Override
        public Object getItem(int i)  //根據position取得項目資訊
        {
            return null;
        }

        @Override
        public long getItemId(int i)    //根據position取得row id
        {
            return 0;
        }

        @Override
        public View getView(final int position, View v, ViewGroup viewGroup) //將資料呈現在列表元件上
        {
            ViewHolder viewHolder;  //在ListView中有時我們需要加載大量數據，如果每次都創建一個View，
                                    // 這樣會佔據大量內存，影響性能。這時就可以考慮用ViewHolder了
            if(v == null)
            {
                //Log.d("GatView", "position:" + position);
                LayoutInflater inflater = LayoutInflater.from(context); //Inflater:解檔案成layout view
                v = inflater.inflate(R.layout.myitem, null);

                viewHolder = new ViewHolder();
                viewHolder.tv = v.findViewById(R.id.textView);
                viewHolder.tv2 = v.findViewById(R.id.textView2);
                viewHolder.img = v.findViewById(R.id.imageView);
                viewHolder.chk = (CheckBox) v.findViewById(R.id.checkBox);
            }
            else
            {
                viewHolder = (ViewHolder) v.getTag(); //用getTag()將v內打勾的儲存值取回
            }

            //View v = inflater.inflate(R.layout.myitem, null);

            //TextView tv = v.findViewById(R.id.textView);
            //TextView tv2 = v.findViewById(R.id.textView2);
            //ImageView img = v.findViewById(R.id.imageView);
            //CheckBox chk = (CheckBox) v.findViewById(R.id.checkBox);  //避免勾選資料移動畫面時消失
            //tv.setText(str[position]);

            //tv.setText(mylist.get(position).get("city").toString());

            //tv2.setText(mylist.get(position).get("code").toString());

            //img.setImageResource((Integer) mylist.get(position).get("img"));


            //chk.setChecked(chks[position]);

            //chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
            //{
            //    @Override
            //    public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            //  {
            //        chks[position] = b;
                    // }});

            //return v;       //回傳整頁圖
        //}

        viewHolder.tv.setText(mylist.get(position).get("city").toString());
        viewHolder.tv2.setText(mylist.get(position).get("code").toString());
        viewHolder.img.setImageResource((Integer) mylist.get(position).get("img"));
        viewHolder.chk.setOnCheckedChangeListener(null); //避免進資源回收後回來被清除, boolean T->F
        viewHolder.chk.setChecked(chks[position]);
        viewHolder.chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
        @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
            chks[position] = b;
            }
        });
        v.setTag(viewHolder);
        return v;
    }
    static class ViewHolder
    {
        TextView tv;
        TextView tv2;
        ImageView img;
        CheckBox chk;
    }

}

