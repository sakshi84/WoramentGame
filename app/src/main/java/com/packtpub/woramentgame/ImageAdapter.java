package com.packtpub.woramentgame;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.Random;

/**
 * Created by sakshi on 30/5/17.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private final Wordament wordament;
    //private final int[] matrix ;
    public int i;
    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.a, R.drawable.b,
            R.drawable.c, R.drawable.d,
            R.drawable.e, R.drawable.f,
            R.drawable.g, R.drawable.h,
            R.drawable.i, R.drawable.j,
            R.drawable.k, R.drawable.l,
            R.drawable.m, R.drawable.n,
            R.drawable.o, R.drawable.p,
            R.drawable.q, R.drawable.r,
            R.drawable.s, R.drawable.t,
            R.drawable.u, R.drawable.v,
            R.drawable.w, R.drawable.x,
            R.drawable.y, R.drawable.z
    };

    //Consturtor
    public ImageAdapter(View.OnClickListener c, Wordament wordament) {
        mContext = (Context) c;
        this.wordament = wordament;
        //matrix = new int[26];
        i=-1;
    }

    public int getCount() {

        return (mThumbIds.length-10);
    }

    public Object getItem(int position) {

        return mThumbIds[position];
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ImageView ib;
        //creating grid
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            ib = new ImageView(mContext);
            ib.setLayoutParams(new GridView.LayoutParams(250,250));
            ib.setScaleType(ImageView.ScaleType.FIT_CENTER);
            ib.setPadding(2, 2, 2, 2);
        } else {
            ib = (ImageView) convertView;
        }
/*
        ib.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      ib.setLayoutParams(new GridView.LayoutParams(200, 200));
                                      ib.requestLayout();
                                  }
                              });
*/
        //random image
        Random r = new Random();
        int i1 = r.nextInt(1000)%26;
        ib.setImageResource(mThumbIds[i1]);
        //matrix[i]=i1;
        i++;
        //send to wordament

        wordament.setChar(i1,i);
        return ib;
    }

    public void display(){
        for(int i=4;i<20;i++)
            System.out.println("image print");//+matrix[i]);
    }

}