/****************************************************************************
 *
 * Copyright (c) 2016 Elektrotehnički fakultet
 * Patre 5, Banja Luka
 *
 * All Rights Reserved
 *
 * \file StavkaAdapter.java
 * \brief
 * Adapter class for Stavka items.
 *
 * Created on 10.04.2016.
 *
 * @Author Milan Bojic
 *
 **********************************************************************/

package net.etfbl.prs.stavka;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import prs.etfbl.net.prs112709_z1.R;

public class StavkaAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Stavka> mStavke;

    /************************************************************************/
    /**
     * @brief Constructor for StavkaAdapter
     *
     * @param context - Context
     *
     * @return StavkaAdapter
     *************************************************************************/
    public StavkaAdapter (Context context){
        mContext = context;
        mStavke = new ArrayList<Stavka>();
    }

    /************************************************************************/
    /**
     * @brief Adds new item in array list
     *
     * @param stavka - Item to be added
     *
     * @return void
     *************************************************************************/
    public void addStavka (Stavka stavka){
        mStavke.add(stavka);
        notifyDataSetChanged();
    }

    /************************************************************************/
    /**
     * @brief Remove item in given position
     *
     * @param postion - position of item whom will be removed
     *
     * @return bool
     *************************************************************************/
    public boolean removeItem(int postion){
        if(mStavke.remove(postion) != null){
            notifyDataSetChanged();
            return true;
        }else
            return false;
    }

    /************************************************************************/
    /**
     * @brief Remove given item.
     *
     * @param object - Object to be removed
     *
     * @return bool
     *************************************************************************/
    public boolean removeItem(Object object){
        if(mStavke.remove(object)){
            notifyDataSetChanged();
            return  true;
        }else
            return false;
    }

    @Override
    public int getCount() {
        return mStavke.size();
    }

    @Override
    public Object getItem(int position) {
        Object rv = null;
        try{
            rv = mStavke.get(position);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return rv;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if(view == null){
            LayoutInflater inflater =
                    (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.stavka_row,null);
        }

        ImageView image = (ImageView) view.findViewById(R.id.image);
        TextView opis = (TextView) view.findViewById(R.id.opis);

        Stavka stavka = (Stavka)getItem(position);
        if(stavka.gotova){
            image.setImageResource(R.drawable.ico_done);
        }else{
            image.setImageResource(R.drawable.ico_in_progress);
        }
        opis.setText(stavka.opis);
        return view;
    }
}
