package com.tirtho.com.tirtho.diu.custome.list;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tirtho.diu.R;
import com.tirtho.pojo.Notice;
import com.tirtho.pojo.StudentCommunity;

import java.util.List;
import java.util.Random;

public class NoticeAdepter extends ArrayAdapter<Notice> {

    List<Notice> notices;

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;

    //constructor initializing the values
    public NoticeAdepter(Context context, int resource, List<Notice> notices) {
        super(context, resource, notices);
        this.context = context;
        this.resource = resource;
        this.notices = notices;
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
        TextView date= view.findViewById(R.id.tv_date);
        TextView title = view.findViewById(R.id.tv_title);
        TextView text = view.findViewById(R.id.tv_text);

        Random random = new Random();
        int r=random.nextInt(255);
        int g=random.nextInt(255);
        int b=random.nextInt(255);

        date.setBackgroundColor(Color.rgb(r,g,b));

        //getting the hero of the specified position
        Notice notice = notices.get(position);

        //adding values to the list item
        date.setText(notice.getDate());
        title.setText(notice.getTitle());
        text.setText(notice.getText());

        //adding a click listener to the button to remove item from the list

        //finally returning the view
        return view;
    }


}
