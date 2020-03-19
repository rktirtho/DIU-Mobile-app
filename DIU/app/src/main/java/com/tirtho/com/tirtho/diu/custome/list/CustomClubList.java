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

import com.tirtho.diu.R;
import com.tirtho.diu.StudentsCommunity;
import com.tirtho.pojo.Faculaty;
import com.tirtho.pojo.StudentCommunity;

import java.util.List;

public class CustomClubList extends ArrayAdapter<StudentCommunity> {

    List<StudentCommunity> communities;

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;

    //constructor initializing the values
    public CustomClubList(Context context, int resource, List<StudentCommunity> communities) {
        super(context, resource, communities);
        this.context = context;
        this.resource = resource;
        this.communities = communities;
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
        ImageView image = view.findViewById(R.id.iv_logo);
        TextView name = view.findViewById(R.id.tv_name);
        TextView designation = view.findViewById(R.id.tv_designation);

        //getting the hero of the specified position
        StudentCommunity community = communities.get(position);

        //adding values to the list item
        image.setImageDrawable(context.getResources().getDrawable(community.getLogo()));
        name.setText(community.getName());

        //adding a click listener to the button to remove item from the list

        //finally returning the view
        return view;
    }


}
