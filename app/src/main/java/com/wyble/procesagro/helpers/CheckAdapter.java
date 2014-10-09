package com.wyble.procesagro.helpers;

import java.util.ArrayList;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.wyble.procesagro.R;
import com.wyble.procesagro.models.PasoOferta;

/**
 * Created by david on 10/3/14.
 */
public class CheckAdapter extends ArrayAdapter<PasoOferta> {


    private ArrayList<PasoOferta> mData = new ArrayList();
    private LayoutInflater mInflater;

    public CheckAdapter(Context context, int textViewResourceId, ArrayList<PasoOferta> pasosOferta) {
        super(context, textViewResourceId, pasosOferta);
        this.mData.addAll(pasosOferta);
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public static class ViewHolder {
        //public TextView textView;
        public CheckBox checkBox;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (convertView == null) {

            convertView = mInflater.inflate(R.layout.check_list_item, null);

            holder = new ViewHolder();
            //holder.textView = (TextView) convertView.findViewById(R.id.checkTextItem);
            holder.checkBox = (CheckBox) convertView.findViewById(R.id.checkBoxItem);
            convertView.setTag(holder);
            holder.checkBox.setOnClickListener( new View.OnClickListener() {
                public void onClick(View v) {
                    CheckBox cb = (CheckBox) v ;
                    PasoOferta pasoOferta = (PasoOferta) cb.getTag();
                    pasoOferta.setIsChecked(cb.isChecked());
                }
            });
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        PasoOferta pasoOferta = mData.get(position);

        //holder.textView.setText(pasoOferta.getTitulo());
        holder.checkBox.setText(pasoOferta.getTitulo());
        holder.checkBox.setChecked(pasoOferta.getIsChecked());
        holder.checkBox.setTag(pasoOferta);

        return convertView;

    }

}
