package com.ovionmedia.wizbox.tvshows;

import java.util.List;

import com.ovionmedia.wizbox.launcher.R;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

@SuppressWarnings("rawtypes")
public class SelectedAdapter extends ArrayAdapter{

    // used to keep selected position in ListView
    private int selectedPos = -1;   // init value for not-selected

    @SuppressWarnings("unchecked")
	public SelectedAdapter(Context context, int textViewResourceId,
                   List objects) {
         super(context, textViewResourceId, objects);
    }
    public void setSelectedPosition(int pos){
    selectedPos = pos;
         // inform the view of this change
         notifyDataSetChanged();
    }
    public int getSelectedPosition(){
         return selectedPos;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
             View v = convertView;
             // only inflate the view if it's null
             // if (v == null) {
                    LayoutInflater vi =   (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    v = vi.inflate(R.layout.tvchannel_list_item, null);
             //  }

             // get text view
                 TextView label = (TextView)v.findViewById(R.id.speakerName);
                
                 // change the row color based on selected state
                 if(selectedPos == position){
                    label.setBackgroundResource(R.drawable.tv_columnoneselected);
                  
                 }
                 else{
                	  label.setBackgroundResource(R.drawable.tv_listitembackground);
                 }

                 label.setText(this.getItem(position).toString());       
                 return(v);
    }
}