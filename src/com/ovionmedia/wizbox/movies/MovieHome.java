package com.ovionmedia.wizbox.movies;



 
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.analytics.tracking.android.MapBuilder;
import com.google.analytics.tracking.android.EasyTracker;
import com.ovionmedia.wizbox.launcher.R;


public class MovieHome extends ListActivity{
	
	private ListView listView;
	private GridView gridView;
	private static int selectedLanguage=0;
	private TextView languageName; 
	 
	Context context;
	
	private String []languagelist;
	 
	
	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.moviehome);
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		EasyTracker.getInstance(this).activityStart(this);

		  //getting reference
		    listView=getListView();
		    gridView = (GridView)findViewById(R.id.gridview);
		    languageName=(TextView) findViewById(R.id.languageName); 
		    
		    
		    //getting language list from String.xml
		    languagelist=getResources().getStringArray(R.array.language);
		    // setting language name first time
		    
		    //setting list adapter
		    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		             R.layout.moviehome_list,R.id.textView1, languagelist);
		        setListAdapter(adapter);
		        
		    languageName.setText(languagelist[0]);
		      gridView = (GridView)findViewById(R.id.gridview);
		    gridView.setAdapter(new MyAdapter(this,0));
		    		
		    		
		    		// setting onclick listener on listview
		    		listView.setOnItemClickListener(new OnItemClickListener() {

						@Override
						public void onItemClick(AdapterView<?> arg0, View v,
								int position, long id) {
							
							gridView.setAdapter(new MyAdapter(MovieHome.this,position)); 
							selectedLanguage=position;
							languageName.setText(languagelist[position]);
							EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

							  // MapBuilder.createEvent().build() returns a Map of event fields and values
							  // that are set and sent with the hit.
							  easyTracker.send(MapBuilder
							      .createEvent("Vinay",     // Event category (required)
							                   "WizBox_Movies",  // Event action (required)
							                   languagelist[position]+"Movies",   // Event label
							                   null)            // Event value
							      .build()
							  );

						}
					});
		    		
		    		// setting on selected listener on listview
		    		listView.setOnItemSelectedListener(new OnItemSelectedListener() {

						@Override
						public void onItemSelected(AdapterView<?> arg0, View arg1,
								int position, long id) {
							 
							 gridView.setAdapter(new MyAdapter(MovieHome.this,position)); 
							 selectedLanguage=position;
							 languageName.setText(languagelist[position]); 
							 EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

							  // MapBuilder.createEvent().build() returns a Map of event fields and values
							  // that are set and sent with the hit.
							  easyTracker.send(MapBuilder
							      .createEvent("Vinay",     // Event category (required)
							                   "WizBox_Movies",  // Event action (required)
							                   languagelist[position]+"Movies",   // Event label
							                   null)            // Event value
							      .build()
							  );
						}

						@Override
						public void onNothingSelected(AdapterView<?> arg0) {
							// TODO Auto-generated method stub
							
						}
					});
		    		
		    		//setting on click listener on gridview item
		    gridView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				
					public void onItemClick(AdapterView<?> parent, View v,
							int position, long id) {
				
			boolean isConnected=isNetworkConnected();
			if(!isConnected)
				Toast.makeText(MovieHome.this, "Please check Internet Connection", Toast.LENGTH_LONG).show();
			else
			{
				// Hindi language
				if(selectedLanguage==0)
				{
					
				
				if (position==0)
				{
					EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		  "WizBox_Movies",  // Event action (required)
					                   "Hindi_Action",   // Event label
					                   null)            // Event value
					      .build()
					  );	
				Intent intent=new Intent(MovieHome.this,ActionMovies.class);
				intent.putExtra("selectedLanguage", selectedLanguage);
				startActivity(intent);
				}
				
		else if(position==1)
		       {
			EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

			  // MapBuilder.createEvent().build() returns a Map of event fields and values
			  // that are set and sent with the hit.
			  easyTracker.send(MapBuilder
			      .createEvent("Vinay",     // Event category (required)
			    		  "WizBox_Movies",  // Event action (required)
			                   "Hindi_Drama",   // Event label
			                   null)            // Event value
			      .build()
			  );	
			    Intent intent=new Intent(MovieHome.this,Drama.class);
			    intent.putExtra("selectedLanguage", selectedLanguage);
			    startActivity(intent);
			
				}
					
		else if(position==2)
		       {
			EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

			  // MapBuilder.createEvent().build() returns a Map of event fields and values
			  // that are set and sent with the hit.
			  easyTracker.send(MapBuilder
			      .createEvent("Vinay",     // Event category (required)
			    		  "WizBox_Movies",  // Event action (required)
			                   "Hindi_Comedy",   // Event label
			                   null)            // Event value
			      .build()
			  );	
				Intent intent=new Intent(MovieHome.this,Comedy.class);
				intent.putExtra("selectedLanguage", selectedLanguage);
				startActivity(intent);
		    	}

		else  if(position==3)
				{
			EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

			  // MapBuilder.createEvent().build() returns a Map of event fields and values
			  // that are set and sent with the hit.
			  easyTracker.send(MapBuilder
			      .createEvent("Vinay",     // Event category (required)
			    		  "WizBox_Movies",  // Event action (required)
			                   "Hindi_Romance",   // Event label
			                   null)            // Event value
			      .build()
			  );	
			   Intent intent=new Intent(MovieHome.this,Romance.class);
			   intent.putExtra("selectedLanguage", selectedLanguage);
			   startActivity(intent);
		     	}
			
		else  if(position==4)
		       {
			EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

			  // MapBuilder.createEvent().build() returns a Map of event fields and values
			  // that are set and sent with the hit.
			  easyTracker.send(MapBuilder
			      .createEvent("Vinay",     // Event category (required)
			    		  "WizBox_Movies",  // Event action (required)
			                   "Hindi_Religious",   // Event label
			                   null)            // Event value
			      .build()
			  );	
			   Intent intent=new Intent(MovieHome.this,Religious.class);
			   intent.putExtra("selectedLanguage", selectedLanguage);
			   startActivity(intent);
				}
		else  if(position==5)
		       {
			EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

			  // MapBuilder.createEvent().build() returns a Map of event fields and values
			  // that are set and sent with the hit.
			  easyTracker.send(MapBuilder
			      .createEvent("Vinay",     // Event category (required)
			    		  "WizBox_Movies",  // Event action (required)
			                   "Hindi_Family",   // Event label
			                   null)            // Event value
			      .build()
			  );	
			   Intent intent=new Intent(MovieHome.this,Family.class);
			   intent.putExtra("selectedLanguage", selectedLanguage);
			   startActivity(intent);				
				}
		else  if(position==6)
		      {
			EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

			  // MapBuilder.createEvent().build() returns a Map of event fields and values
			  // that are set and sent with the hit.
			  easyTracker.send(MapBuilder
			      .createEvent("Vinay",     // Event category (required)
			    		  "WizBox_Movies",  // Event action (required)
			                   "Hindi_Animation",   // Event label
			                   null)            // Event value
			      .build()
			  );	
			   Intent intent=new Intent(MovieHome.this,Animation.class);
			   intent.putExtra("selectedLanguage", selectedLanguage);
			   startActivity(intent);	
			
				}
	   else  if(position==7)
	          {
		   EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

			  // MapBuilder.createEvent().build() returns a Map of event fields and values
			  // that are set and sent with the hit.
			  easyTracker.send(MapBuilder
			      .createEvent("Vinay",     // Event category (required)
			    		  "WizBox_Movies",  // Event action (required)
			                   "Hindi_Horror",   // Event label
			                   null)            // Event value
			      .build()
			  );	
		      Intent intent=new Intent(MovieHome.this,Horror.class);
		      intent.putExtra("selectedLanguage", selectedLanguage);
		      startActivity(intent);					
				}
				
		}//end of Hindi language
				
		// English language
				
		else if(selectedLanguage==1)
			
			{
					
			if (position==0)
					{
				EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		  "WizBox_Movies",  // Event action (required)
				                   "English_Action",   // Event label
				                   null)            // Event value
				      .build()
				  );	
					Intent intent=new Intent(MovieHome.this,ActionMovies.class);
					intent.putExtra("selectedLanguage", selectedLanguage);
					startActivity(intent);
					}
					
			else if(position==1)
			       {
				EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		  "WizBox_Movies",  // Event action (required)
				                   "English_Drama",   // Event label
				                   null)            // Event value
				      .build()
				  );	
				    Intent intent=new Intent(MovieHome.this,Drama.class);
				    intent.putExtra("selectedLanguage", selectedLanguage);
				    startActivity(intent);
				
					}
						
			else if(position==2)
			       {
				EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		  "WizBox_Movies",  // Event action (required)
				                   "English_Comedy",   // Event label
				                   null)            // Event value
				      .build()
				  );	
					Intent intent=new Intent(MovieHome.this,Comedy.class);
					intent.putExtra("selectedLanguage", selectedLanguage);
					startActivity(intent);
			    	}

			else  if(position==3)
					{
				EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		  "WizBox_Movies",  // Event action (required)
				                   "English_Romance",   // Event label
				                   null)            // Event value
				      .build()
				  );	
				   Intent intent=new Intent(MovieHome.this,Romance.class);
				   intent.putExtra("selectedLanguage", selectedLanguage);
				   startActivity(intent);
			     	}
				
			else  if(position==4)
			       {
				// for English it will work as Documentary
				//documentary=Religious
				EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		  "WizBox_Movies",  // Event action (required)
				                   "English_Religious",   // Event label
				                   null)            // Event value
				      .build()
				  );	
				   Intent intent=new Intent(MovieHome.this,Religious.class);
				   intent.putExtra("selectedLanguage", selectedLanguage);
				   startActivity(intent);
					}
			else  if(position==5)
			       {
				EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		  "WizBox_Movies",  // Event action (required)
				                   "English_Family",   // Event label
				                   null)            // Event value
				      .build()
				  );	
				   Intent intent=new Intent(MovieHome.this,Family.class);
				   intent.putExtra("selectedLanguage", selectedLanguage);
				   startActivity(intent);				
					}
			else  if(position==6)
			      {
				EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		  "WizBox_Movies",  // Event action (required)
				                   "English_Animation",   // Event label
				                   null)            // Event value
				      .build()
				  );	
				
				   Intent intent=new Intent(MovieHome.this,Animation.class);
				   intent.putExtra("selectedLanguage", selectedLanguage);
				   startActivity(intent);	
				
					}
		   else  if(position==7)
		          {
			   EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		  "WizBox_Movies",  // Event action (required)
				                   "English_Horror",   // Event label
				                   null)            // Event value
				      .build()
				  );	
			      Intent intent=new Intent(MovieHome.this,Horror.class);
			      intent.putExtra("selectedLanguage", selectedLanguage);
			      startActivity(intent);					
					}
			
		}//end of  English language
				
		// Telugu language 		
		else if(selectedLanguage==2)
		{
			if (position==0)
			{
				EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		  "WizBox_Movies",  // Event action (required)
				                   "Telugu_Action",   // Event label
				                   null)            // Event value
				      .build()
				  );	
			Intent intent=new Intent(MovieHome.this,ActionMovies.class);
			intent.putExtra("selectedLanguage", selectedLanguage);
			startActivity(intent);
			}
			
	else if(position==1)
	       {
		EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

		  // MapBuilder.createEvent().build() returns a Map of event fields and values
		  // that are set and sent with the hit.
		  easyTracker.send(MapBuilder
		      .createEvent("Vinay",     // Event category (required)
		    		  "WizBox_Movies",  // Event action (required)
		                   "Telugu_Drama",   // Event label
		                   null)            // Event value
		      .build()
		  );	
		    Intent intent=new Intent(MovieHome.this,Drama.class);
		    intent.putExtra("selectedLanguage", selectedLanguage);
		    startActivity(intent);
		
			}
				
	else if(position==2)
	       {
		EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

		  // MapBuilder.createEvent().build() returns a Map of event fields and values
		  // that are set and sent with the hit.
		  easyTracker.send(MapBuilder
		      .createEvent("Vinay",     // Event category (required)
		    		  "WizBox_Movies",  // Event action (required)
		                   "Telugu_Comedy",   // Event label
		                   null)            // Event value
		      .build()
		  );	
			Intent intent=new Intent(MovieHome.this,Comedy.class);
			intent.putExtra("selectedLanguage", selectedLanguage);
			startActivity(intent);
	    	}

	else  if(position==3)
			{
		EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

		  // MapBuilder.createEvent().build() returns a Map of event fields and values
		  // that are set and sent with the hit.
		  easyTracker.send(MapBuilder
		      .createEvent("Vinay",     // Event category (required)
		    		  "WizBox_Movies",  // Event action (required)
		                   "Telugu_Romance",   // Event label
		                   null)            // Event value
		      .build()
		  );	
		   Intent intent=new Intent(MovieHome.this,Romance.class);
		   intent.putExtra("selectedLanguage", selectedLanguage);
		   startActivity(intent);
	     	}
		
	else  if(position==4)
	       {
		EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

		  // MapBuilder.createEvent().build() returns a Map of event fields and values
		  // that are set and sent with the hit.
		  easyTracker.send(MapBuilder
		      .createEvent("Vinay",     // Event category (required)
		    		  "WizBox_Movies",  // Event action (required)
		                   "Telugu_Religious",   // Event label
		                   null)            // Event value
		      .build()
		  );	
		   Intent intent=new Intent(MovieHome.this,Religious.class);
		   intent.putExtra("selectedLanguage", selectedLanguage);
		   startActivity(intent);
			}
	else  if(position==5)
	       {
		EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

		  // MapBuilder.createEvent().build() returns a Map of event fields and values
		  // that are set and sent with the hit.
		  easyTracker.send(MapBuilder
		      .createEvent("Vinay",     // Event category (required)
		    		  "WizBox_Movies",  // Event action (required)
		                   "Telugu_Family",   // Event label
		                   null)            // Event value
		      .build()
		  );	
		   Intent intent=new Intent(MovieHome.this,Family.class);
		   intent.putExtra("selectedLanguage", selectedLanguage);
		   startActivity(intent);				
			}

	else  if(position==6)
	      {
		EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

		  // MapBuilder.createEvent().build() returns a Map of event fields and values
		  // that are set and sent with the hit.
		  easyTracker.send(MapBuilder
		      .createEvent("Vinay",     // Event category (required)
		    		  "WizBox_Movies",  // Event action (required)
		                   "Telugu_Horror",   // Event label
		                   null)            // Event value
		      .build()
		  );	
	      Intent intent=new Intent(MovieHome.this,Horror.class);
	      intent.putExtra("selectedLanguage", selectedLanguage);
	      startActivity(intent);					
			}
			
		}//end of Telugu language
				
			// Tamil language
		else if(selectedLanguage==3)
		{
			if (position==0)
			{
				EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		  "WizBox_Movies",  // Event action (required)
				                   "Tamil_Action",   // Event label
				                   null)            // Event value
				      .build()
				  );	
			Intent intent=new Intent(MovieHome.this,ActionMovies.class);
			intent.putExtra("selectedLanguage", selectedLanguage);
			startActivity(intent);
			}
			
	else if(position==1)
	       {
		EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

		  // MapBuilder.createEvent().build() returns a Map of event fields and values
		  // that are set and sent with the hit.
		  easyTracker.send(MapBuilder
		      .createEvent("Vinay",     // Event category (required)
		    		  "WizBox_Movies",  // Event action (required)
		                   "Tamil_Drama",   // Event label
		                   null)            // Event value
		      .build()
		  );	
		    Intent intent=new Intent(MovieHome.this,Drama.class);
		    intent.putExtra("selectedLanguage", selectedLanguage);
		    startActivity(intent);
		
			}
				
	else if(position==2)
	       {
		EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

		  // MapBuilder.createEvent().build() returns a Map of event fields and values
		  // that are set and sent with the hit.
		  easyTracker.send(MapBuilder
		      .createEvent("Vinay",     // Event category (required)
		    		  languagelist[3],  // Event action (required)
		    		  "WizBox_Movies",   // Event label
		                   null)            // Event value
		      .build()
		  );	
			Intent intent=new Intent(MovieHome.this,Comedy.class);
			intent.putExtra("selectedLanguage", selectedLanguage);
			startActivity(intent);
	    	}

	else  if(position==3)
			{
		EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

		  // MapBuilder.createEvent().build() returns a Map of event fields and values
		  // that are set and sent with the hit.
		  easyTracker.send(MapBuilder
		      .createEvent("Vinay",     // Event category (required)
		    		  "WizBox_Movies",  // Event action (required)
		                   "Tamil_Romance",   // Event label
		                   null)            // Event value
		      .build()
		  );	
		   Intent intent=new Intent(MovieHome.this,Romance.class);
		   intent.putExtra("selectedLanguage", selectedLanguage);
		   startActivity(intent);
	     	}
		
	else  if(position==4)
	       {
		EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

		  // MapBuilder.createEvent().build() returns a Map of event fields and values
		  // that are set and sent with the hit.
		  easyTracker.send(MapBuilder
		      .createEvent("Vinay",     // Event category (required)
		    		  "WizBox_Movies",  // Event action (required)
		                   "Tamil_Religious",   // Event label
		                   null)            // Event value
		      .build()
		  );	
		   Intent intent=new Intent(MovieHome.this,Religious.class);
		   intent.putExtra("selectedLanguage", selectedLanguage);
		   startActivity(intent);
			}
	else  if(position==5)
	       {
		EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

		  // MapBuilder.createEvent().build() returns a Map of event fields and values
		  // that are set and sent with the hit.
		  easyTracker.send(MapBuilder
		      .createEvent("Vinay",     // Event category (required)
		    		  "WizBox_Movies",  // Event action (required)
		                   "Tamil_Family",   // Event label
		                   null)            // Event value
		      .build()
		  );	
		   Intent intent=new Intent(MovieHome.this,Family.class);
		   intent.putExtra("selectedLanguage", selectedLanguage);
		   startActivity(intent);				
			}
	else  if(position==6)
	      {
		EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

		  // MapBuilder.createEvent().build() returns a Map of event fields and values
		  // that are set and sent with the hit.
		  easyTracker.send(MapBuilder
		      .createEvent("Vinay",     // Event category (required)
		    		  "WizBox_Movies",  // Event action (required)
		                   "Tamil_Animation",   // Event label
		                   null)            // Event value
		      .build()
		  );	
		   Intent intent=new Intent(MovieHome.this,Animation.class);
		   intent.putExtra("selectedLanguage", selectedLanguage);
		   startActivity(intent);	
		
			}
	else  if(position==7)
	      {
		EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

		  // MapBuilder.createEvent().build() returns a Map of event fields and values
		  // that are set and sent with the hit.
		  easyTracker.send(MapBuilder
		      .createEvent("Vinay",     // Event category (required)
		    		  "WizBox_Movies",  // Event action (required)
		                   "Tamil_Horror",   // Event label
		                   null)            // Event value
		      .build()
		  );	
	      Intent intent=new Intent(MovieHome.this,Horror.class);
	      intent.putExtra("selectedLanguage", selectedLanguage);
	      startActivity(intent);					
			}
		}// end of Tamil language
			
				//Malyalam language
		else if(selectedLanguage==4)
		{
			

			if (position==0)
			{
				EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		  "WizBox_Movies",  // Event action (required)
				                   "Malyalam_Action",   // Event label
				                   null)            // Event value
				      .build()
				  );	
			Intent intent=new Intent(MovieHome.this,ActionMovies.class);
			intent.putExtra("selectedLanguage", selectedLanguage);
			startActivity(intent);
			}
			
	else if(position==1)
	       {
		EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

		  // MapBuilder.createEvent().build() returns a Map of event fields and values
		  // that are set and sent with the hit.
		  easyTracker.send(MapBuilder
		      .createEvent("Vinay",     // Event category (required)
		    		  languagelist[4],  // Event action (required)
		                   "Malyalam_Drama",   // Event label
		                   null)            // Event value
		      .build()
		  );	
		    Intent intent=new Intent(MovieHome.this,Drama.class);
		    intent.putExtra("selectedLanguage", selectedLanguage);
		    startActivity(intent);
		
			}
				
	else if(position==2)
	       {
		EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

		  // MapBuilder.createEvent().build() returns a Map of event fields and values
		  // that are set and sent with the hit.
		  easyTracker.send(MapBuilder
		      .createEvent("Vinay",     // Event category (required)
		    		  "WizBox_Movies",  // Event action (required)
		                   "Malyalam_Comedy",   // Event label
		                   null)            // Event value
		      .build()
		  );	
			Intent intent=new Intent(MovieHome.this,Comedy.class);
			intent.putExtra("selectedLanguage", selectedLanguage);
			startActivity(intent);
	    	}

	else  if(position==3)
			{
		EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

		  // MapBuilder.createEvent().build() returns a Map of event fields and values
		  // that are set and sent with the hit.
		  easyTracker.send(MapBuilder
		      .createEvent("Vinay",     // Event category (required)
		    		  "WizBox_Movies",  // Event action (required)
		                   "Malyalam_Romance",   // Event label
		                   null)            // Event value
		      .build()
		  );	
		   Intent intent=new Intent(MovieHome.this,Romance.class);
		   intent.putExtra("selectedLanguage", selectedLanguage);
		   startActivity(intent);
	     	}
		
	else  if(position==4)
	       {
		EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

		  // MapBuilder.createEvent().build() returns a Map of event fields and values
		  // that are set and sent with the hit.
		  easyTracker.send(MapBuilder
		      .createEvent("Vinay",     // Event category (required)
		    		  "WizBox_Movies",  // Event action (required)
		                   "Malyalam_Religious",   // Event label
		                   null)            // Event value
		      .build()
		  );	
		   Intent intent=new Intent(MovieHome.this,Religious.class);
		   intent.putExtra("selectedLanguage", selectedLanguage);
		   startActivity(intent);
			}
	else  if(position==5)
	       {
		EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

		  // MapBuilder.createEvent().build() returns a Map of event fields and values
		  // that are set and sent with the hit.
		  easyTracker.send(MapBuilder
		      .createEvent("Vinay",     // Event category (required)
		    		  "WizBox_Movies",  // Event action (required)
		                   "Malyalam_Family",   // Event label
		                   null)            // Event value
		      .build()
		  );	
		   Intent intent=new Intent(MovieHome.this,Family.class);
		   intent.putExtra("selectedLanguage", selectedLanguage);
		   startActivity(intent);				
			}
	else  if(position==6)
	      {
		EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

		  // MapBuilder.createEvent().build() returns a Map of event fields and values
		  // that are set and sent with the hit.
		  easyTracker.send(MapBuilder
		      .createEvent("Vinay",     // Event category (required)
		    		  "WizBox_Movies",  // Event action (required)
		                   "Malyalam_Animation",   // Event label
		                   null)            // Event value
		      .build()
		  );	
		   Intent intent=new Intent(MovieHome.this,Animation.class);
		   intent.putExtra("selectedLanguage", selectedLanguage);
		   startActivity(intent);	
		
			}
	else  if(position==7)
	      {
		EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

		  // MapBuilder.createEvent().build() returns a Map of event fields and values
		  // that are set and sent with the hit.
		  easyTracker.send(MapBuilder
		      .createEvent("Vinay",     // Event category (required)
		    		  "WizBox_Movies",  // Event action (required)
		                   "Malyalam_Horror",   // Event label
		                   null)            // Event value
		      .build()
		  );	
	      Intent intent=new Intent(MovieHome.this,Horror.class);
	      intent.putExtra("selectedLanguage", selectedLanguage);
	      startActivity(intent);					
			}

		}// end of Malyalam language
				
	// Bengali language
		else if(selectedLanguage==5)
		{
			

			if (position==0)
			{
				EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		  "WizBox_Movies",  // Event action (required)
				                   "Bengali_Action",   // Event label
				                   null)            // Event value
				      .build()
				  );	
			Intent intent=new Intent(MovieHome.this,ActionMovies.class);
			intent.putExtra("selectedLanguage", selectedLanguage);
			startActivity(intent);
			}
			
	else if(position==1)
	       {
		EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

		  // MapBuilder.createEvent().build() returns a Map of event fields and values
		  // that are set and sent with the hit.
		  easyTracker.send(MapBuilder
		      .createEvent("Vinay",     // Event category (required)
		    		  "WizBox_Movies",  // Event action (required)
		                   "Bengali_Drama",   // Event label
		                   null)            // Event value
		      .build()
		  );		
		    Intent intent=new Intent(MovieHome.this,Drama.class);
		    intent.putExtra("selectedLanguage", selectedLanguage);
		    startActivity(intent);
		
			}
				
	else if(position==2)
	       {
		EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

		  // MapBuilder.createEvent().build() returns a Map of event fields and values
		  // that are set and sent with the hit.
		  easyTracker.send(MapBuilder
		      .createEvent("Vinay",     // Event category (required)
		    		  "WizBox_Movies",  // Event action (required)
		                   "Bengali_Comedy",   // Event label
		                   null)            // Event value
		      .build()
		  );	
			Intent intent=new Intent(MovieHome.this,Comedy.class);
			intent.putExtra("selectedLanguage", selectedLanguage);
			startActivity(intent);
	    	}

	else  if(position==3)
			{
		EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

		  // MapBuilder.createEvent().build() returns a Map of event fields and values
		  // that are set and sent with the hit.
		  easyTracker.send(MapBuilder
		      .createEvent("Vinay",     // Event category (required)
		    		  "WizBox_Movies",  // Event action (required)
		                   "Bengali_Romance",   // Event label
		                   null)            // Event value
		      .build()
		  );	
		   Intent intent=new Intent(MovieHome.this,Romance.class);
		   intent.putExtra("selectedLanguage", selectedLanguage);
		   startActivity(intent);
	     	}
		
	else  if(position==4)
	       {
		EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

		  // MapBuilder.createEvent().build() returns a Map of event fields and values
		  // that are set and sent with the hit.
		  easyTracker.send(MapBuilder
		      .createEvent("Vinay",     // Event category (required)
		    		  "WizBox_Movies",  // Event action (required)
		                   "Bengali_Religious",   // Event label
		                   null)            // Event value
		      .build()
		  );	
		   Intent intent=new Intent(MovieHome.this,Religious.class);
		   intent.putExtra("selectedLanguage", selectedLanguage);
		   startActivity(intent);
			}
	else  if(position==5)
	       {
		EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

		  // MapBuilder.createEvent().build() returns a Map of event fields and values
		  // that are set and sent with the hit.
		  easyTracker.send(MapBuilder
		      .createEvent("Vinay",     // Event category (required)
		    		  "WizBox_Movies",  // Event action (required)
		                   "Bengali_Family",   // Event label
		                   null)            // Event value
		      .build()
		  );	
		   Intent intent=new Intent(MovieHome.this,Family.class);
		   intent.putExtra("selectedLanguage", selectedLanguage);
		   startActivity(intent);				
			}
	else  if(position==6)
	      {
		EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

		  // MapBuilder.createEvent().build() returns a Map of event fields and values
		  // that are set and sent with the hit.
		  easyTracker.send(MapBuilder
		      .createEvent("Vinay",     // Event category (required)
		    		  "WizBox_Movies",  // Event action (required)
		                   "Bengali_Animation",   // Event label
		                   null)            // Event value
		      .build()
		  );	
		   Intent intent=new Intent(MovieHome.this,Animation.class);
		   intent.putExtra("selectedLanguage", selectedLanguage);
		   startActivity(intent);	
		
			}
	else  if(position==7)
	      {
		EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

		  // MapBuilder.createEvent().build() returns a Map of event fields and values
		  // that are set and sent with the hit.
		  easyTracker.send(MapBuilder
		      .createEvent("Vinay",     // Event category (required)
		    		  "WizBox_Movies",  // Event action (required)
		                   "Bengali_Horror",   // Event label
		                   null)            // Event value
		      .build()
		  );	
	      Intent intent=new Intent(MovieHome.this,Horror.class);
	      intent.putExtra("selectedLanguage", selectedLanguage);
	      startActivity(intent);					
			}

		}// end of Bengali language
			
				//Kannada language
	else if(selectedLanguage==6)
				{
					

					if (position==0)
					{
						EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

						  // MapBuilder.createEvent().build() returns a Map of event fields and values
						  // that are set and sent with the hit.
						  easyTracker.send(MapBuilder
						      .createEvent("Vinay",     // Event category (required)
						    		  "WizBox_Movies",  // Event action (required)
						                   "Kannada_Action",   // Event label
						                   null)            // Event value
						      .build()
						  );	
					Intent intent=new Intent(MovieHome.this,ActionMovies.class);
					intent.putExtra("selectedLanguage", selectedLanguage);
					startActivity(intent);
					}
					
			else if(position==1)
			       {
				EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		  "WizBox_Movies",  // Event action (required)
				                   "Kannada_Drama",   // Event label
				                   null)            // Event value
				      .build()
				  );		
				    Intent intent=new Intent(MovieHome.this,Drama.class);
				    intent.putExtra("selectedLanguage", selectedLanguage);
				    startActivity(intent);
				
					}
						
			else if(position==2)
			       {
				EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		  "WizBox_Movies",  // Event action (required)
				                   "Kannada_Comedy",   // Event label
				                   null)            // Event value
				      .build()
				  );	
					Intent intent=new Intent(MovieHome.this,Comedy.class);
					intent.putExtra("selectedLanguage", selectedLanguage);
					startActivity(intent);
			    	}

			else  if(position==3)
					{
				EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		  "WizBox_Movies",  // Event action (required)
				                   "Kannada_Romance",   // Event label
				                   null)            // Event value
				      .build()
				  );	
				   Intent intent=new Intent(MovieHome.this,Romance.class);
				   intent.putExtra("selectedLanguage", selectedLanguage);
				   startActivity(intent);
			     	}
				
			else  if(position==4)
			       {
				EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		  "WizBox_Movies",  // Event action (required)
				                   "Kannada_Family",   // Event label
				                   null)            // Event value
				      .build()
				  );	
				   Intent intent=new Intent(MovieHome.this,Family.class);
				   intent.putExtra("selectedLanguage", selectedLanguage);
				   startActivity(intent);				
					}
			
			else  if(position==5)
			      {
				EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		  "WizBox_Movies",  // Event action (required)
				                   "Kannada_Horror",   // Event label
				                   null)            // Event value
				      .build()
				  );	
			      Intent intent=new Intent(MovieHome.this,Horror.class);
			      intent.putExtra("selectedLanguage", selectedLanguage);
			      startActivity(intent);					
					}

				}// end of kannada language
		
				//Marathi language
	else if(selectedLanguage==7)
				{
					

									
			 if(position==0)
			       {
				 EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		  "WizBox_Movies",  // Event action (required)
				                   "Marathi_Drama",   // Event label
				                   null)            // Event value
				      .build()
				  );	
				    Intent intent=new Intent(MovieHome.this,Drama.class);
				    intent.putExtra("selectedLanguage", selectedLanguage);
				    startActivity(intent);
				
					}
						
			else if(position==1)
			       {EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		  "WizBox_Movies",  // Event action (required)
					                   "Marathi_Comedy",   // Event label
					                   null)            // Event value
					      .build()
					  );	
					Intent intent=new Intent(MovieHome.this,Comedy.class);
					intent.putExtra("selectedLanguage", selectedLanguage);
					startActivity(intent);
			    	}

			else  if(position==2)
					{
				EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		  "WizBox_Movies",  // Event action (required)
				                   "Marathi_Romance",   // Event label
				                   null)            // Event value
				      .build()
				  );	
				   Intent intent=new Intent(MovieHome.this,Romance.class);
				   intent.putExtra("selectedLanguage", selectedLanguage);
				   startActivity(intent);
			     	}
				
			else  if(position==3)
			       {
				EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		  "WizBox_Movies",  // Event action (required)
				                   "Marathi_Family",   // Event label
				                   null)            // Event value
				      .build()
				  );	
				   Intent intent=new Intent(MovieHome.this,Family.class);
				   intent.putExtra("selectedLanguage", selectedLanguage);
				   startActivity(intent);				
					}
			
				}// end of Marathi language
			
				//Punjabi language
	else if(selectedLanguage==8)
				{
					

					if (position==0)
					{
						EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

						  // MapBuilder.createEvent().build() returns a Map of event fields and values
						  // that are set and sent with the hit.
						  easyTracker.send(MapBuilder
						      .createEvent("Vinay",     // Event category (required)
						    		  "WizBox_Movies",  // Event action (required)
						                   "Punjabi_Action",   // Event label
						                   null)            // Event value
						      .build()
						  );	
					Intent intent=new Intent(MovieHome.this,ActionMovies.class);
					intent.putExtra("selectedLanguage", selectedLanguage);
					startActivity(intent);
					}
					
			else if(position==1)
			       {
				EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		  "WizBox_Movies",  // Event action (required)
				                   "Punjabi_Drama",   // Event label
				                   null)            // Event value
				      .build()
				  );	
				    Intent intent=new Intent(MovieHome.this,Drama.class);
				    intent.putExtra("selectedLanguage", selectedLanguage);
				    startActivity(intent);
				
					}
						
			else if(position==2)
			       {
				EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		  "WizBox_Movies",  // Event action (required)
				                   "Punjabi_Comedy",   // Event label
				                   null)            // Event value
				      .build()
				  );	
					Intent intent=new Intent(MovieHome.this,Comedy.class);
					intent.putExtra("selectedLanguage", selectedLanguage);
					startActivity(intent);
			    	}

			else  if(position==3)
					{
				EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		  "WizBox_Movies",  // Event action (required)
				                   "Punjabi_Romance",   // Event label
				                   null)            // Event value
				      .build()
				  );	
				   Intent intent=new Intent(MovieHome.this,Romance.class);
				   intent.putExtra("selectedLanguage", selectedLanguage);
				   startActivity(intent);
			     	}
			else  if(position==4)
		       {
				EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		  "WizBox_Movies",  // Event action (required)
				                   "Punjabi_Religious",   // Event label
				                   null)            // Event value
				      .build()
				  );	
			   Intent intent=new Intent(MovieHome.this,Religious.class);
			   intent.putExtra("selectedLanguage", selectedLanguage);
			   startActivity(intent);
				}
			else  if(position==5)
			       {
				EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		  "WizBox_Movies",  // Event action (required)
				                   "Punjabi_Family",   // Event label
				                   null)            // Event value
				      .build()
				  );	
				   Intent intent=new Intent(MovieHome.this,Family.class);
				   intent.putExtra("selectedLanguage", selectedLanguage);
				   startActivity(intent);				
					}
			else  if(position==6)
		      {
				EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		  "WizBox_Movies",  // Event action (required)
				                   "Punjabi_Animation",   // Event label
				                   null)            // Event value
				      .build()
				  );	
			   Intent intent=new Intent(MovieHome.this,Animation.class);
			   intent.putExtra("selectedLanguage", selectedLanguage);
			   startActivity(intent);	
			
				}
			}// end of Punjabi language
			
				//Gujarati language
				else if(selectedLanguage==9)
							{
								

								if (position==0)
								{
									EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

									  // MapBuilder.createEvent().build() returns a Map of event fields and values
									  // that are set and sent with the hit.
									  easyTracker.send(MapBuilder
									      .createEvent("Vinay",     // Event category (required)
									    		  "WizBox_Movies",  // Event action (required)
									                   "Gujrati_Action",   // Event label
									                   null)            // Event value
									      .build()
									  );	
								Intent intent=new Intent(MovieHome.this,ActionMovies.class);
								intent.putExtra("selectedLanguage", selectedLanguage);
								startActivity(intent);
								}
								
						else if(position==1)
						       {
							EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

							  // MapBuilder.createEvent().build() returns a Map of event fields and values
							  // that are set and sent with the hit.
							  easyTracker.send(MapBuilder
							      .createEvent("Vinay",     // Event category (required)
							    		  "WizBox_Movies",  // Event action (required)
							                   "Gujrati_Drama",   // Event label
							                   null)            // Event value
							      .build()
							  );	
							    Intent intent=new Intent(MovieHome.this,Drama.class);
							    intent.putExtra("selectedLanguage", selectedLanguage);
							    startActivity(intent);
							
								}
									
						else if(position==2)
						       {
							EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

							  // MapBuilder.createEvent().build() returns a Map of event fields and values
							  // that are set and sent with the hit.
							  easyTracker.send(MapBuilder
							      .createEvent("Vinay",     // Event category (required)
							    		  "WizBox_Movies",  // Event action (required)
							                   "Gujrati_Comedy",   // Event label
							                   null)            // Event value
							      .build()
							  );	
								Intent intent=new Intent(MovieHome.this,Comedy.class);
								intent.putExtra("selectedLanguage", selectedLanguage);
								startActivity(intent);
						    	}

						else  if(position==3)
								{
							EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

							  // MapBuilder.createEvent().build() returns a Map of event fields and values
							  // that are set and sent with the hit.
							  easyTracker.send(MapBuilder
							      .createEvent("Vinay",     // Event category (required)
							    		  "WizBox_Movies",  // Event action (required)
							                   "Gujrati_Romance",   // Event label
							                   null)            // Event value
							      .build()
							  );	
							   Intent intent=new Intent(MovieHome.this,Romance.class);
							   intent.putExtra("selectedLanguage", selectedLanguage);
							   startActivity(intent);
						     	}
						else  if(position==4)
					       {
							EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

							  // MapBuilder.createEvent().build() returns a Map of event fields and values
							  // that are set and sent with the hit.
							  easyTracker.send(MapBuilder
							      .createEvent("Vinay",     // Event category (required)
							    		  "WizBox_Movies",  // Event action (required)
							                   "Gujrati_Religious",   // Event label
							                   null)            // Event value
							      .build()
							  );	
						   Intent intent=new Intent(MovieHome.this,Religious.class);
						   intent.putExtra("selectedLanguage", selectedLanguage);
						   startActivity(intent);
							}
						else  if(position==5)
						       {
							EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

							  // MapBuilder.createEvent().build() returns a Map of event fields and values
							  // that are set and sent with the hit.
							  easyTracker.send(MapBuilder
							      .createEvent("Vinay",     // Event category (required)
							    		  "WizBox_Movies",  // Event action (required)
							                   "Gujrati_Family",   // Event label
							                   null)            // Event value
							      .build()
							  );	
							   Intent intent=new Intent(MovieHome.this,Family.class);
							   intent.putExtra("selectedLanguage", selectedLanguage);
							   startActivity(intent);				
								}
										

							}// end of Gujarati language

				//Bhojpuri language
		else if(selectedLanguage==10)
		{
			if (position==0)
			{
				EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				    		  "WizBox_Movies",  // Event action (required)
				                   "Bhojpuri_Action",   // Event label
				                   null)            // Event value
				      .build()
				  );	
			Intent intent=new Intent(MovieHome.this,ActionMovies.class);
			intent.putExtra("selectedLanguage", selectedLanguage);
			startActivity(intent);
			}
			
	else if(position==1)
	       {
		EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

		  // MapBuilder.createEvent().build() returns a Map of event fields and values
		  // that are set and sent with the hit.
		  easyTracker.send(MapBuilder
		      .createEvent("Vinay",     // Event category (required)
		    		  "WizBox_Movies",  // Event action (required)
		                   "Bhojpuri_Drama",   // Event label
		                   null)            // Event value
		      .build()
		  );	
		    Intent intent=new Intent(MovieHome.this,Drama.class);
		    intent.putExtra("selectedLanguage", selectedLanguage);
		    startActivity(intent);
		
			}
				
	else if(position==2)
	       {
		EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

		  // MapBuilder.createEvent().build() returns a Map of event fields and values
		  // that are set and sent with the hit.
		  easyTracker.send(MapBuilder
		      .createEvent("Vinay",     // Event category (required)
		    		  "WizBox_Movies",  // Event action (required)
		                   "Bhojpuri_Comedy",   // Event label
		                   null)            // Event value
		      .build()
		  );	
			Intent intent=new Intent(MovieHome.this,Comedy.class);
			intent.putExtra("selectedLanguage", selectedLanguage);
			startActivity(intent);
	    	}

	else  if(position==3)
			{
		EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

		  // MapBuilder.createEvent().build() returns a Map of event fields and values
		  // that are set and sent with the hit.
		  easyTracker.send(MapBuilder
		      .createEvent("Vinay",     // Event category (required)
		    		  "WizBox_Movies",  // Event action (required)
		                   "Bhojpuri_Romance",   // Event label
		                   null)            // Event value
		      .build()
		  );	
		   Intent intent=new Intent(MovieHome.this,Romance.class);
		   intent.putExtra("selectedLanguage", selectedLanguage);
		   startActivity(intent);
	     	}
		
	else  if(position==4)
	       {
		EasyTracker easyTracker = EasyTracker.getInstance(MovieHome.this);

		  // MapBuilder.createEvent().build() returns a Map of event fields and values
		  // that are set and sent with the hit.
		  easyTracker.send(MapBuilder
		      .createEvent("Vinay",     // Event category (required)
		    		  "WizBox_Movies",  // Event action (required)
		                   "Bhojpuri_Family",   // Event label
		                   null)            // Event value
		      .build()
		  );	
		   Intent intent=new Intent(MovieHome.this,Family.class);
		   intent.putExtra("selectedLanguage", selectedLanguage);
		   startActivity(intent);				
			}
			
		}// end of Bhojpuri
				
				
			}  
		}
		    
			});
		    
		    
		
		}
		
		private boolean isNetworkConnected() {
			  ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
			  NetworkInfo ni = cm.getActiveNetworkInfo();
			  if (ni == null) {
			   // There are no active networks.
			   return false;
			  } else
			   return true;
			 }
		public void onStop() {
		    super.onStop();
		  EasyTracker.getInstance(this).activityStop(this);
		  }
		}
	
	
	
	

	
	

