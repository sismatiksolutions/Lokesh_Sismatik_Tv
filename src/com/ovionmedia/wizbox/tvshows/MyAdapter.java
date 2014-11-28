package com.ovionmedia.wizbox.tvshows;

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

    public MyAdapter(Context context,int position) {
        inflater = LayoutInflater.from(context);

        // Hindi channels 
    if(position==0){
        
    	 items.add(new Item("M TV",   R.drawable.tv_mtvhindi));
         items.add(new Item("Colors TV",   R.drawable.tv_colorshindi));
         items.add(new Item("Bindass",   R.drawable.tv_bindasshindi));
         items.add(new Item("Sony",   R.drawable.tv_sonyhindi));
         items.add(new Item("Sahara One",   R.drawable.tv_saharaonehindi));
         items.add(new Item("Disney XD",   R.drawable.tv_disneyxdhindi));
         items.add(new Item("Hungama TV",   R.drawable.tv_hangamahindi));
  	     items.add(new Item("Pogo TV",   R.drawable.tv_pogohindi));
  	     items.add(new Item("Zee TV",   R.drawable.tv_zeetvhindi));
  	     items.add(new Item("SAB TV",   R.drawable.tv_sabhindi));
  	     items.add(new Item("Doordrshan",   R.drawable.tv_doordarshanhindi));
        
    	
   
        }
    //kannada channels
   else if(position==1){
	   items.add(new Item("ETV Kannada",   R.drawable.tv_etvkannada));
       items.add(new Item("Zee Kannada",   R.drawable.tv_zeekannada));
       items.add(new Item("Suvarna",   R.drawable.tv_suvarnakannada));
       items.add(new Item("Udaya TV",   R.drawable.tv_udayakannada));
     
           
        }
 // telugu channels
   else if(position==2){
	   items.add(new Item("Maa TV",   R.drawable.tv_maatelugu));
       items.add(new Item("ETV Telugu",   R.drawable.tv_etvtelugu));
       items.add(new Item("Gemini",   R.drawable.tv_geminitelugu));
       items.add(new Item("Zee Telugu",   R.drawable.tv_zeetelugu));
   }
  //tamil channels
   else if(position==3){
	      items.add(new Item("Sun TV",   R.drawable.tv_suntvtamil));
	      items.add(new Item("Star Vijay",   R.drawable.tv_vijaytamil));
	      items.add(new Item("Zee Tamil",   R.drawable.tv_zeetamil));
	      items.add(new Item("Polimer",   R.drawable.tv_polimertamil));
	    
   }
 // malayalam channels
   else if(position==4){
	   items.add(new Item("AsianetGlobal",   R.drawable.tv_asianetmalayalam));
	   items.add(new Item("Surya",   R.drawable.tv_suryamalayalam));
   }
  //marathi channels	
   else if(position==5){
	   items.add(new Item("Zee Marathi",   R.drawable.tv_zeemarathi));
	   items.add(new Item("ETV Marathi",   R.drawable.tv_etvmarathi));
	   items.add(new Item("History India",   R.drawable.tv_historyindiamarathi));
	     }
 // Bengali channels
   else if(position==6){
	   items.add(new Item("Zee Bengali",   R.drawable.tv_zeebangali));
	   items.add(new Item("ETV Bengali",   R.drawable.tv_etvbangali));
   }
 // Gujarati channels
   else if(position==7){
	   items.add(new Item("ETV Gujarati",   R.drawable.tv_etvgujarati));
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
            v = inflater.inflate(R.layout.tvchannel_grid_item, viewGroup, false);
            v.setTag(R.id.picture, v.findViewById(R.id.picture));
            v.setTag(R.id.text, v.findViewById(R.id.text));
        }

        picture = (ImageView)v.getTag(R.id.picture);
        name = (TextView)v.getTag(R.id.text);

        Item item = (Item)getItem(i);

        picture.setImageResource(item.drawableId);
        name.setText(item.name);

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