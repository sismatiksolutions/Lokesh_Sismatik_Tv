package com.ovionmedia.wizbox.tvshows;





import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.MapBuilder;
import com.ovionmedia.wizbox.launcher.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;


public class TVHome extends Activity{
	
	private ListView listView;
	private GridView gridView;
	private TextView tvcat;
	
	private int listItem=0;
	
	Context context;
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.tvhome);
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		EasyTracker.getInstance(this).activityStart(this);
		
		//getting reference
	    listView=(ListView) findViewById(R.id.listView1);
	    gridView = (GridView)findViewById(R.id.gridview);
	    tvcat = (TextView) findViewById(R.id.tvshowcategory);
	 
/*	    String[] values = new String[] { "Entertainment", 
                "Music",
                "Lifestyle",
                "Sports", 
                "Movies",
                "Kids", 
                "Business", 
                "Science"
                };*/
	    
	    
	    String[] values = new String[] { "Hindi", 
                "Kannada",
                "Telugu",
                "Tamil", 
                "Malayalam",
                "Marathi", 
                "Bengali", 
                "Gujarati"
                };

	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	            R.layout.tvhome_list_item, R.id.text1, values);
	    
	    listView.setAdapter(adapter); 
	    gridView.setAdapter(new MyAdapter(TVHome.this,0));
		
	    //setting on click listener listview
	    listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long id) {
				 if(position==0){
					 listItem=position;
					// tvcat.setText("Entertainment");
					 tvcat.setText("Hindi");
					 gridView.setAdapter(new MyAdapter(TVHome.this,position));
					 EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		  "WizBox_TVShows",  // Event action (required)
					                  "Hindi_TVShow",   // Event label
					                   null)            // Event value
					      .build()
					  );	
				 }
				 else if(position==1){
					 listItem=position;
					// tvcat.setText("Music");
					 tvcat.setText("Kannada");
					 gridView.setAdapter(new MyAdapter(TVHome.this,position));
					 EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		  "WizBox_TVShows",  // Event action (required)
					                  "Kannada_TVShow",   // Event label
					                   null)            // Event value
					      .build()
					  );	
				 }
				 else if(position==2){
					 listItem=position;
					// tvcat.setText("Lifestyle");
					 tvcat.setText("Telugu");
					 gridView.setAdapter(new MyAdapter(TVHome.this,position));
					 EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		  "WizBox_TVShows",  // Event action (required)
					                  "Telugu_TVShow",   // Event label
					                   null)            // Event value
					      .build()
					  );	
				 }
				 else if(position==3){
					 listItem=position;
					 tvcat.setText("Tamil");
					// tvcat.setText("Sports");
					 gridView.setAdapter(new MyAdapter(TVHome.this,position));
					 EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		  "WizBox_TVShows",  // Event action (required)
					                  "Tamil_TVShow",   // Event label
					                   null)            // Event value
					      .build()
					  );	
				 }
				 else if(position==4){
					 listItem=position;
					 tvcat.setText("Malayalam");
					// tvcat.setText("Movies");
					 gridView.setAdapter(new MyAdapter(TVHome.this,position));
					 EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		  "WizBox_TVShows",  // Event action (required)
					                  "Malyalam_TVShow",   // Event label
					                   null)            // Event value
					      .build()
					  );	
				 }
				 else if(position==5){
					 listItem=position;
					// tvcat.setText("Kids");
					 tvcat.setText("Marathi");
					 gridView.setAdapter(new MyAdapter(TVHome.this,position));
					 EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		  "WizBox_TVShows",  // Event action (required)
					                  "Marathi_TVShow",   // Event label
					                   null)            // Event value
					      .build()
					  );	
				 }
				 else if(position==6){
					 listItem=position;
					// tvcat.setText("Business");
					 tvcat.setText("Bengali");
					 gridView.setAdapter(new MyAdapter(TVHome.this,position));
					 EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		  "WizBox_TVShows",  // Event action (required)
					                  "Bengali_TVShow",   // Event label
					                   null)            // Event value
					      .build()
					  );	
				 }
				 else if(position==7){
					 listItem=position;
					// tvcat.setText("Science");
					 tvcat.setText("Gujarati");
					 gridView.setAdapter(new MyAdapter(TVHome.this,position));
					 EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		  "WizBox_TVShows",  // Event action (required)
					                  "Gujrati_TVShow",   // Event label
					                   null)            // Event value
					      .build()
					  );	
				 }
				 
				
			}
		});
	     
	    //setting on selected listener on listview
	    listView.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long id) {
				 
			 
				 if(position==0){
					 listItem=position;
					// tvcat.setText("Entertainment");
					 tvcat.setText("Hindi");
					 gridView.setAdapter(new MyAdapter(TVHome.this,position));
					 EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		  "WizBox_TVShows",  // Event action (required)
					                  "Hindi_TVShow",   // Event label
					                   null)            // Event value
					      .build()
					  );	
				 }
				 else if(position==1){
					 listItem=position;
					// tvcat.setText("Music");
					 tvcat.setText("Kannada");
					 gridView.setAdapter(new MyAdapter(TVHome.this,position));
					 EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		  "WizBox_TVShows",  // Event action (required)
					                  "Kannada_TVShow",   // Event label
					                   null)            // Event value
					      .build()
					  );	
				 }
				 else if(position==2){
					 listItem=position;
					// tvcat.setText("Lifestyle");
					 tvcat.setText("Telugu");
					 gridView.setAdapter(new MyAdapter(TVHome.this,position));
					 EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		  "WizBox_TVShows",  // Event action (required)
					                  "Telugu_TVShow",   // Event label
					                   null)            // Event value
					      .build()
					  );	
				 }
				 else if(position==3){
					 listItem=position;
					 tvcat.setText("Tamil");
					// tvcat.setText("Sports");
					 gridView.setAdapter(new MyAdapter(TVHome.this,position));
					 EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		  "WizBox_TVShows",  // Event action (required)
					                  "Tamil_TVShow",   // Event label
					                   null)            // Event value
					      .build()
					  );	
				 }
				 else if(position==4){
					 listItem=position;
					 tvcat.setText("Malayalam");
					// tvcat.setText("Movies");
					 gridView.setAdapter(new MyAdapter(TVHome.this,position));
					 EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		  "WizBox_TVShows",  // Event action (required)
					                  "Malyalam_TVShow",   // Event label
					                   null)            // Event value
					      .build()
					  );	
				 }
				 else if(position==5){
					 listItem=position;
					// tvcat.setText("Kids");
					 tvcat.setText("Marathi");
					 gridView.setAdapter(new MyAdapter(TVHome.this,position));
					 EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		  "WizBox_TVShows",  // Event action (required)
					                  "Marathi_TVShow",   // Event label
					                   null)            // Event value
					      .build()
					  );	
				 }
				 else if(position==6){
					 listItem=position;
					// tvcat.setText("Business");
					 tvcat.setText("Bengali");
					 gridView.setAdapter(new MyAdapter(TVHome.this,position));
					 EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		  "WizBox_TVShows",  // Event action (required)
					                  "Bengali_TVShow",   // Event label
					                   null)            // Event value
					      .build()
					  );	
				 }
				 else if(position==7){
					 listItem=position;
					// tvcat.setText("Science");
					 tvcat.setText("Gujarati");
					 gridView.setAdapter(new MyAdapter(TVHome.this,position));
					 EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		  "WizBox_TVShows",  // Event action (required)
					                  "Gujrati_TVShow",   // Event label
					                   null)            // Event value
					      .build()
					  );	
				 }
				 
				
			}
		

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	    
	    // setting on click listener on gridview
	    
	    gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			
				public void onItemClick(AdapterView<?> parent, View v,
						int position, long id) {
			
				 // hindi category
		if(listItem==0){
					
			
		 		 if(position==0)
	            {
		 			EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		 "WizBox_TVShows",  // Event action (required)
					                  "MTV",   // Event label
					                   null)            // Event value
					      .build()
					  );	
	            	Intent i = new Intent(TVHome.this,TVChannel.class);
	            	i.putExtra("TV_Channel","MTV");
	            	startActivity(i);
	            }
	            else if(position==1)
	            {
	            	EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		 "WizBox_TVShows",  // Event action (required)
					                  "Colors TV",   // Event label
					                   null)            // Event value
					      .build()
					  );	
	            	Intent i = new Intent(TVHome.this,TVChannel.class);
	            	i.putExtra("TV_Channel","Colors TV");
	            	startActivity(i);
	            }
	            else if(position==2)
	            {
	            	EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		 "WizBox_TVShows",  // Event action (required)
				                  "Bindass",   // Event label
				                   null)            // Event value
				      .build()
				  );	
	            	Intent i = new Intent(TVHome.this,TVChannel.class);
	            	i.putExtra("TV_Channel","Bindass");
	            	startActivity(i);
	            }
	            else if(position==3)
	            {
	            	EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		 "WizBox_TVShows",  // Event action (required)
					                  "Sony",   // Event label
					                   null)            // Event value
					      .build()
					  );	
	            	Intent i = new Intent(TVHome.this,TVChannel.class);
	            	i.putExtra("TV_Channel","Sony");
	            	startActivity(i);
	            }
	            else if(position==4)
	            {
	            	EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		 "WizBox_TVShows",  // Event action (required)
					                  "Sahara One",   // Event label
					                   null)            // Event value
					      .build()
					  );	
	            	Intent i = new Intent(TVHome.this,TVChannel.class);
	            	i.putExtra("TV_Channel","Sahara One");
	            	startActivity(i);
	            }
	            else if(position==5)
	            {
	            	EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		 "WizBox_TVShows",  // Event action (required)
					                  "Disney XD",   // Event label
					                   null)            // Event value
					      .build()
					  );	
	            	Intent i = new Intent(TVHome.this,TVChannel.class);
	            	i.putExtra("TV_Channel","Disney XD");
	            	startActivity(i);
	            }
	            else if(position==6)
	            {
	            	EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		 "WizBox_TVShows",  // Event action (required)
					                  "Hungama TV",   // Event label
					                   null)            // Event value
					      .build()
					  );	
	            	Intent i = new Intent(TVHome.this,TVChannel.class);
	            	i.putExtra("TV_Channel","Hungama TV");
	            	startActivity(i);
	            }
	            else if(position==7)
	            {
	            	EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		 "WizBox_TVShows",  // Event action (required)
					                  "Pogo",   // Event label
					                   null)            // Event value
					      .build()
					  );	
	            	Intent i = new Intent(TVHome.this,TVChannel.class);
	            	i.putExtra("TV_Channel","Pogo");
	            	startActivity(i);
	            }
	            else if(position==8)
	            {
	            	EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		 "WizBox_TVShows",  // Event action (required)
					                  "Zee TV",   // Event label
					                   null)            // Event value
					      .build()
					  );	
	            	Intent i = new Intent(TVHome.this,TVChannel.class);
	            	i.putExtra("TV_Channel","Zee TV");
	            	startActivity(i);
	            }
	            else if(position==9)
	            {
	            	EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		 "WizBox_TVShows",  // Event action (required)
					                  "Sab TV",   // Event label
					                   null)            // Event value
					      .build()
					  );	
	            	Intent i = new Intent(TVHome.this,TVChannel.class);
	            	i.putExtra("TV_Channel","Sab TV");
	            	startActivity(i);
	            }
	            else if(position==10)
	            {
	            	EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		 "WizBox_TVShows",  // Event action (required)
					                  "Doordarshan",   // Event label
					                   null)            // Event value
					      .build()
					  );	
	            	Intent i = new Intent(TVHome.this,TVChannel.class);
	            	i.putExtra("TV_Channel","Doordarshan");
	            	startActivity(i);
	            }
	           
				}
		// kannada category
	    else if(listItem==1){
	    	 if(position==0){
	    		 EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		 "WizBox_TVShows",  // Event action (required)
				                  "ETVKannada",   // Event label
				                   null)            // Event value
				      .build()
				  );	
	            	Intent i = new Intent(TVHome.this,TVChannel.class);
	            	i.putExtra("TV_Channel","ETVKannada");
	            	startActivity(i);
	            }
		 			
	            else if(position==1)
	            {
	            	EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		 "WizBox_TVShows",  // Event action (required)
					                  "ZeeKannada",   // Event label
					                   null)            // Event value
					      .build()
					  );	
	            	Intent i = new Intent(TVHome.this,TVChannel.class);
	            	i.putExtra("TV_Channel","ZeeKannada");
	            	startActivity(i);
	            }
	            else if(position==2)
	            {
	            	EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		 "WizBox_TVShows",  // Event action (required)
					                  "Suvarna",   // Event label
					                   null)            // Event value
					      .build()
					  );	
	            	Intent i = new Intent(TVHome.this,TVChannel.class);
	            	i.putExtra("TV_Channel","Suvarna");
	            	startActivity(i);
	            }
	            else if(position==3)
	            {
	            	EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		 "WizBox_TVShows",  // Event action (required)
					                  "Udaya",   // Event label
					                   null)            // Event value
					      .build()
					  );	
	            	Intent i = new Intent(TVHome.this,TVChannel.class);
	            	i.putExtra("TV_Channel","Udaya");
	            	startActivity(i);
	            }
				}
		//Telugu category
	    else if(listItem==2){
	    	 if(position==0){
	    		 EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		 "WizBox_TVShows",  // Event action (required)
				                  "MaaTV",   // Event label
				                   null)            // Event value
				      .build()
				  );	
	            	Intent i = new Intent(TVHome.this,TVChannel.class);
	            	i.putExtra("TV_Channel","MaaTV");
	            	startActivity(i);
	            }
		 			
	            else if(position==1)
	            {
	            	EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		 "WizBox_TVShows",  // Event action (required)
					                  "ETVTelugu",   // Event label
					                   null)            // Event value
					      .build()
					  );	
	            	Intent i = new Intent(TVHome.this,TVChannel.class);
	            	i.putExtra("TV_Channel","ETVTelugu");
	            	startActivity(i);
	            }
	            else if(position==2)
	            {
	            	
	            	EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		 "WizBox_TVShows",  // Event action (required)
					                  "Gemini",   // Event label
					                   null)            // Event value
					      .build()
					  );	
	            	Intent i = new Intent(TVHome.this,TVChannel.class);
	            	i.putExtra("TV_Channel","Gemini");
	            	startActivity(i);
	            }
	            else if(position==3)
	            {
	            	EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		 "WizBox_TVShows",  // Event action (required)
					                  "ZeeTelugu",   // Event label
					                   null)            // Event value
					      .build()
					  );	
	            	Intent i = new Intent(TVHome.this,TVChannel.class);
	            	i.putExtra("TV_Channel","ZeeTelugu");
	            	startActivity(i);
	            }
	            } 
		//Tamil category
	    else if(listItem==3){
	    	
		            if(position==0){
		            	EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

						  // MapBuilder.createEvent().build() returns a Map of event fields and values
						  // that are set and sent with the hit.
						  easyTracker.send(MapBuilder
						      .createEvent("Vinay",     // Event category (required)
						    		 "WizBox_TVShows",  // Event action (required)
						                  "SunTv",   // Event label
						                   null)            // Event value
						      .build()
						  );	

		            	Intent i = new Intent(TVHome.this,TVChannel.class);
		            	i.putExtra("TV_Channel","SunTv");
		            	startActivity(i);
		            }
			 			
		            else if(position==1)
		            {
		            	EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

						  // MapBuilder.createEvent().build() returns a Map of event fields and values
						  // that are set and sent with the hit.
						  easyTracker.send(MapBuilder
						      .createEvent("Vinay",     // Event category (required)
						    		 "WizBox_TVShows",  // Event action (required)
						                  "StarVijay",   // Event label
						                   null)            // Event value
						      .build()
						  );	

		            	Intent i = new Intent(TVHome.this,TVChannel.class);
		            	i.putExtra("TV_Channel","StarVijay");
		            	startActivity(i);
		            }
		            else if(position==2)
		            {
		            	EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

						  // MapBuilder.createEvent().build() returns a Map of event fields and values
						  // that are set and sent with the hit.
						  easyTracker.send(MapBuilder
						      .createEvent("Vinay",     // Event category (required)
						    		 "WizBox_TVShows",  // Event action (required)
						                  "ZeeTamil",   // Event label
						                   null)            // Event value
						      .build()
						  );	

		            	Intent i = new Intent(TVHome.this,TVChannel.class);
		            	i.putExtra("TV_Channel","ZeeTamil");
		            	startActivity(i);
		            }
		            else if(position==3)
		            {
		            	EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

						  // MapBuilder.createEvent().build() returns a Map of event fields and values
						  // that are set and sent with the hit.
						  easyTracker.send(MapBuilder
						      .createEvent("Vinay",     // Event category (required)
						    		 "WizBox_TVShows",  // Event action (required)
						                  "Polimer",   // Event label
						                   null)            // Event value
						      .build()
						  );	

		            	Intent i = new Intent(TVHome.this,TVChannel.class);
		            	i.putExtra("TV_Channel","Polimer");
		            	startActivity(i);
		            }
		            
	            }
		//Malayalam category
	    else if(listItem==4){
	    	 if(position==0){
	    		 EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		 "WizBox_TVShows",  // Event action (required)
				                  "Asianet",   // Event label
				                   null)            // Event value
				      .build()
				  );	

	            	Intent i = new Intent(TVHome.this,TVChannel.class);
	            	i.putExtra("TV_Channel","Asianet");
	            	startActivity(i);
	            }
		 			
	            else if(position==1)
	            {
	            	EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		 "WizBox_TVShows",  // Event action (required)
					                  "Surya",   // Event label
					                   null)            // Event value
					      .build()
					  );	
	            	Intent i = new Intent(TVHome.this,TVChannel.class);
	            	i.putExtra("TV_Channel","Surya");
	            	startActivity(i);
	            }
		           
	            }
		//Marathi category	
         else if(listItem==5){
        	 if(position==0){
        		 EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		 "WizBox_TVShows",  // Event action (required)
				                  "ZeeMarathi",   // Event label
				                   null)            // Event value
				      .build()
				  );	
	            	Intent i = new Intent(TVHome.this,TVChannel.class);
	            	i.putExtra("TV_Channel","ZeeMarathi");
	            	startActivity(i);
	            }
		 			
	            else if(position==1)
	            {
	            	 EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		 "WizBox_TVShows",  // Event action (required)
					                  "ETVMarathi",   // Event label
					                   null)            // Event value
					      .build()
					  );	
	            	Intent i = new Intent(TVHome.this,TVChannel.class);
	            	i.putExtra("TV_Channel","ETVMarathi");
	            	startActivity(i);
	            }
	            else if(position==2)
	            { EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		 "WizBox_TVShows",  // Event action (required)
				                  "HistoryIndia",   // Event label
				                   null)            // Event value
				      .build()
				  );	
	            	Intent i = new Intent(TVHome.this,TVChannel.class);
	            	i.putExtra("TV_Channel","HistoryIndia");
	            	startActivity(i);
	            }
	            }	
		// Bengali category
         else if(listItem==6){
        	 if(position==0){
        		 EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		 "WizBox_TVShows",  // Event action (required)
				                  "ZeeBengali",   // Event label
				                   null)            // Event value
				      .build()
				  );	
	            	Intent i = new Intent(TVHome.this,TVChannel.class);
	            	i.putExtra("TV_Channel","ZeeBengali");
	            	startActivity(i);
	            }
		 			
	            else if(position==1)
	            {
	            	EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		 "WizBox_TVShows",  // Event action (required)
					                  "ETVBengali",   // Event label
					                   null)            // Event value
					      .build()
					  );	
	            	Intent i = new Intent(TVHome.this,TVChannel.class);
	            	i.putExtra("TV_Channel","ETVBengali");
	            	startActivity(i);
	            }
                }
		// Gujarati category
         else if(listItem==7){
        	 if(position==0){
        		 EasyTracker easyTracker = EasyTracker.getInstance(TVHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		 "WizBox_TVShows",  // Event action (required)
				                  "ETVGujrati",   // Event label
				                   null)            // Event value
				      .build()
				  );	
	            	Intent i = new Intent(TVHome.this,TVChannel.class);
	            	i.putExtra("TV_Channel","ETVGujarati");
	            	startActivity(i);
	            }
                }
			}
	    
		});
	}
	
	public void onStop() {
	    super.onStop();
	  EasyTracker.getInstance(this).activityStop(this);
	  }
		  
		
	}
	   
	

