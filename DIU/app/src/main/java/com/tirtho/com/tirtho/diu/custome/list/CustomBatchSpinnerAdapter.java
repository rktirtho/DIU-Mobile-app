package com.tirtho.com.tirtho.diu.custome.list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tirtho.com.tirtho.registration.Batch;
import com.tirtho.com.tirtho.registration.Depertment;
import com.tirtho.diu.R;

import java.util.List;


public class CustomBatchSpinnerAdapter extends ArrayAdapter<Batch> {
    public CustomBatchSpinnerAdapter(Context context, List<Batch> depertments) {
        super(context, 0, depertments);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }
    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.model_simple_spinner, parent, false
            );
        }

        TextView textViewName = convertView.findViewById(R.id.name);
        Batch currentItem = getItem(position);
        if (currentItem != null) {
            textViewName.setText(currentItem.getBatchName());
        }
        return convertView;
    }
}