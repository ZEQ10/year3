package com.example.ltdtdd_contentprovider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SMSAdapter extends ArrayAdapter<sms> {
    private Context context;
    private int resource;
    private List<sms> ARRsms;


    public SMSAdapter(@NonNull Context context, int resource, @NonNull List<sms> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.ARRsms = objects;
    }

    @Override
    public View getView(int postion, View convertView, ViewGroup parent){
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.row_listview,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.addressSms = convertView.findViewById(R.id.tvaddressSMS);
            viewHolder.contentSms = convertView.findViewById(R.id.tvcontentSMS);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        sms smss = ARRsms.get(postion);
        viewHolder.addressSms.setText(smss.getAddress());
        viewHolder.contentSms.setText(smss.getBody());
        return convertView;
    }

    public class ViewHolder{
        TextView addressSms, contentSms;
    }

}
