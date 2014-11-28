package com.ovionmedia.wizbox.movies;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ovionmedia.wizbox.launcher.R;

class MyAdapter extends BaseAdapter {
    private List<Item> items = new ArrayList<Item>();
    private LayoutInflater inflater;

    public MyAdapter(Context context, int position) {
        inflater = LayoutInflater.from(context);
    // Hindi
        if(position==0)
        {
        items.add(new Item("Action",   R.drawable.movie_action));
        items.add(new Item("Drama",   R.drawable.movie_drama));
        items.add(new Item("Comedy",   R.drawable.movie_comedy));
        items.add(new Item("Romance",   R.drawable.movie_romance));
        items.add(new Item("Religious",   R.drawable.movie_religious));
        items.add(new Item("Family",   R.drawable.movie_family));
        items.add(new Item("Animation",   R.drawable.movie_animated));
        items.add(new Item("Horror",   R.drawable.movie_horror));
        }
        // English
   else if(position==1)
        {
        	items.add(new Item("Action",   R.drawable.movie_action));
            items.add(new Item("Drama",   R.drawable.movie_drama));
            items.add(new Item("Comedy",   R.drawable.movie_comedy));
            items.add(new Item("Romance",   R.drawable.movie_romance));
            items.add(new Item("Documentary",   R.drawable.movie_documentary));
            items.add(new Item("Family",   R.drawable.movie_family));
            items.add(new Item("Animation",   R.drawable.movie_animated));
            items.add(new Item("Horror",   R.drawable.movie_horror)); 
             
        }
        // Telugu
        
   else if(position==2)
   {
       items.add(new Item("Action",   R.drawable.movie_action));
       items.add(new Item("Drama",   R.drawable.movie_drama));
       items.add(new Item("Comedy",   R.drawable.movie_comedy));
       items.add(new Item("Romance",   R.drawable.movie_romance));
       items.add(new Item("Religious",   R.drawable.movie_religious));
       items.add(new Item("Family",   R.drawable.movie_family));
       items.add(new Item("Horror",   R.drawable.movie_horror)); 
        
   }
        // Tamil
   else if(position==3)
   {
       items.add(new Item("Action",   R.drawable.movie_action));
       items.add(new Item("Drama",   R.drawable.movie_drama));
       items.add(new Item("Comedy",   R.drawable.movie_comedy));
       items.add(new Item("Romance",   R.drawable.movie_romance));
       items.add(new Item("Religious",   R.drawable.movie_religious));
       items.add(new Item("Family",   R.drawable.movie_family));
       items.add(new Item("Animation",   R.drawable.movie_animated));
       items.add(new Item("Horror",   R.drawable.movie_horror)); 
        
   }
        //Malyalam
   else if(position==4)
   {
	   items.add(new Item("Action",   R.drawable.movie_action));
	   items.add(new Item("Drama",   R.drawable.movie_drama));
	   items.add(new Item("Comedy",   R.drawable.movie_comedy));
	   items.add(new Item("Romance",   R.drawable.movie_romance));
	   items.add(new Item("Religious",   R.drawable.movie_religious));
	   items.add(new Item("Family",   R.drawable.movie_family));
	   items.add(new Item("Animation",   R.drawable.movie_animated));
	   items.add(new Item("Horror",   R.drawable.movie_horror)); 
	   
   }
        // Bengali
   else if(position==5)
   {
	   items.add(new Item("Action",   R.drawable.movie_action));
	   items.add(new Item("Drama",   R.drawable.movie_drama));
	   items.add(new Item("Comedy",   R.drawable.movie_comedy));
	   items.add(new Item("Romance",   R.drawable.movie_romance));
	   items.add(new Item("Family",   R.drawable.movie_family));
	   items.add(new Item("Horror",   R.drawable.movie_horror));
   }
        // Kannada
        else if(position==6)
        {
     	   items.add(new Item("Action",   R.drawable.movie_action));
     	   items.add(new Item("Drama",   R.drawable.movie_drama));
     	   items.add(new Item("Comedy",   R.drawable.movie_comedy));
     	   items.add(new Item("Romance",   R.drawable.movie_romance));
     	   items.add(new Item("Family",   R.drawable.movie_family));
     	   items.add(new Item("Horror",   R.drawable.movie_horror));
     	   
        }  
             // Marathi
         else if(position==7)
         {
      	   
      	   items.add(new Item("Drama",   R.drawable.movie_drama));
      	   items.add(new Item("Comedy",   R.drawable.movie_comedy));
      	   items.add(new Item("Romance",   R.drawable.movie_romance));
      	   items.add(new Item("Family",   R.drawable.movie_family));
      	   
      	   
         } 
             // Punjabi
          else if(position==8)
          {
       	   items.add(new Item("Action",   R.drawable.movie_action));
       	   items.add(new Item("Drama",   R.drawable.movie_drama));
       	   items.add(new Item("Comedy",   R.drawable.movie_comedy));
       	   items.add(new Item("Romance",   R.drawable.movie_romance));
       	   items.add(new Item("Religious",   R.drawable.movie_religious));
       	   items.add(new Item("Family",   R.drawable.movie_family));
       	   items.add(new Item("Animation",   R.drawable.movie_animated));
       	  
       	   
          }  
             // Gujarati
          else if(position==9)
          {
       	   items.add(new Item("Action",   R.drawable.movie_action));
       	   items.add(new Item("Drama",   R.drawable.movie_drama));
       	   items.add(new Item("Comedy",   R.drawable.movie_comedy));
       	   items.add(new Item("Romance",   R.drawable.movie_romance));
       	   items.add(new Item("Religious",   R.drawable.movie_religious));
       	   items.add(new Item("Family",   R.drawable.movie_family));
       	  
       	  
       	   
          }  
          
        // Bhojpuri
   else if(position==10)
   {
	   items.add(new Item("Action",   R.drawable.movie_action));
	   items.add(new Item("Drama",   R.drawable.movie_drama));
	   items.add(new Item("Comedy",   R.drawable.movie_comedy));
	   items.add(new Item("Romance",   R.drawable.movie_romance));
	   items.add(new Item("Family",   R.drawable.movie_family));
	   
   }
     
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return items.get(i).drawableId;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        ImageView picture;
        TextView name;

        if(v == null) {
            v = inflater.inflate(R.layout.moviecategory_gird_item, viewGroup, false);
            v.setTag(R.id.picture, v.findViewById(R.id.picture));
          //  v.setTag(R.id.text, v.findViewById(R.id.text));
        }

        picture = (ImageView)v.getTag(R.id.picture);
        //name = (TextView)v.getTag(R.id.text);

        Item item = (Item)getItem(i);

        picture.setImageResource(item.drawableId);
        //name.setText(item.name);

        return v;
    }

    private class Item {
        final String name;
        final int drawableId;

        Item(String name, int drawableId) {
            this.name = name;
            this.drawableId = drawableId;
        }
    }
}