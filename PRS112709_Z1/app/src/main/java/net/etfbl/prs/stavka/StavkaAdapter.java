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

/**
 * Created by Milan on 10-Apr-16.
 */
public class StavkaAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Stavka> mStavke;

    public StavkaAdapter (Context context){
        mContext = context;
        mStavke = new ArrayList<Stavka>();
    }

    public void addStavka (Stavka stavka){
        mStavke.add(stavka);
        notifyDataSetChanged();
    }

    public boolean removeItem(int postion){
        if(mStavke.remove(postion) != null){
            notifyDataSetChanged();
            return true;
        }else
            return false;
    }

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
