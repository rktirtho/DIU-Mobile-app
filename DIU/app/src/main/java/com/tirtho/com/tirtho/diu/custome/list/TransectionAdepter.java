package com.tirtho.com.tirtho.diu.custome.list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tirtho.com.tirtho.account.TuitionFee;
import com.tirtho.diu.R;
import com.tirtho.pojo.Faculaty;

import java.util.List;

public class TransectionAdepter extends ArrayAdapter<TuitionFee> {

    List<TuitionFee> fees;

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;

    //constructor initializing the values
    public TransectionAdepter(Context context, int resource, List<TuitionFee> fees) {
        super(context, resource, fees);
        this.context = context;
        this.resource = resource;
        this.fees = fees;
    }

    //this will return the ListView Item as a View
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //we need to get the view of the xml for our list item
        //And for this we need a layoutinflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //getting the view
        View view = layoutInflater.inflate(resource, null, false);

        //getting the view elements of the list from the view

        TextView date = view.findViewById(R.id.tv_date);
        TextView receipt = view.findViewById(R.id.tv_receipt);
        TextView perpose = view.findViewById(R.id.tv_perpose);
        TextView ammount = view.findViewById(R.id.tv_ammount);

        //getting the hero of the specified position
        TuitionFee fee= fees.get(position);

        //adding values to the list item

        date.setText(fee.getPayDate());
        receipt.setText(fee.getReceiptNo());
        perpose.setText(fee.getPurposePay().getName());
        ammount.setText(fee.getAmount());


        return view;
    }


}
