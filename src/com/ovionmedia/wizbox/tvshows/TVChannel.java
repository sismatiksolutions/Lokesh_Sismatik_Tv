package com.ovionmedia.wizbox.tvshows;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;


import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.MapBuilder;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.PlayerStyle;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.ovionmedia.wizbox.launcher.R;

public class TVChannel extends Activity implements YouTubePlayer.OnInitializedListener{

    // browser key
   static private final String DEVELOPER_KEY = "AIzaSyAoHG1bz2y1pqPEJDQ2Z4pz-5D2SKwBLCA";

   YouTubePlayer tvyouTubePlayer;
   TextView tvcategory;
 
   TextView tvshow;
   TextView tvdescription;

   Button tvfullscreen;
   ImageView tvImageView;
 
 //  private SelectedAdapter selectedAdapter;

	
    private   int tvNo=0;
    YouTubePlayerFragment youTubePlayerFragment;

        private static final String TAG_TV_SHOW_CATEGORY = "tv_show_category";
        private static final String TAG_TV_SHOW_CATEGORY_SUB_CON = "tv_show_category_sub_con";
	    private static final String TAG_TV_DESCRIPTION = "tv_description";
	    private static final String TAG_TV_VIDEO_ID = "tv__video_id";
	    private static final String TAG_TV_SHOW_ID = "tv__show_id";
        private static final String TAG_TV_IMAGE = "tv_image";
	
	    private static String TAG_TV_SHOW_CATEGORY1 = "tv_show_category1";
		private static String TAG_TV_DESCRIPTION1 = "tv_description1";
		private static String TAG_TV_VIDEO_ID1 = "tv__video_id1";
		private static String TAG_TV_IMAGE1 = "tv_image1";
	
	    String description;
	    String video_id;
	    String show_id;
	    String image;
	    String  show_category;
	    String  show_category_sub;
	    String  show_category_sub_con;
	    
		String description1;
	    String video_id1;
	    String image1;
	    String  show_category1;
	 
	    String showid;
	
	    ProgressDialog mProgressDialog;

	
	   static int i;
	   int i2 = 0;
	   int i3 = 1;
	
	
	  public static String url ="";
	  String tvChannelUrl;
	 
	  final ArrayList<HashMap<String, String>> tvShowCategoryList = new ArrayList<HashMap<String, String>>();
	  final ArrayList<HashMap<String, String>> tvShowCategoryList1 = new ArrayList<HashMap<String, String>>();
	  ArrayList<String> tvShowCat = new ArrayList<String>();
	  ListView lv;
	  ListView lv1;
	  String TV_Channel;
	  @Override 
	  public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tvchannel);		
	  }
	  @Override
		protected void onStart() {
			// TODO Auto-generated method stub
			super.onStart();
			EasyTracker.getInstance(this).activityStart(this);
			
			TV_Channel = getIntent().getExtras().getString("TV_Channel");
			  youTubePlayerFragment =  (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.tvyoutube_fragment);
			  tvcategory = (TextView) findViewById(R.id.tvcategory);
			  tvshow = (TextView) findViewById(R.id.tvshow);
			  tvdescription=(TextView) findViewById(R.id.tvdescription);
			  lv1 = (ListView) findViewById(R.id.list);
			  lv=(ListView) findViewById(R.id.list1);
			
			  
			  if(TV_Channel.toString().contains("SunTv")){
			  tvcategory.setText("SunTv");
			  }
			  else if(TV_Channel.toString().contains("StarVijay")) {
				  tvcategory.setText("StarVijay");
			  }
			 
			  else if(TV_Channel.toString().contains("ZeeTamil")) {
				  tvcategory.setText("ZeeTamil");
			  }
			  else if(TV_Channel.toString().contains("Polimer")) {
				  tvcategory.setText("Polimer");
			  }
			  else if(TV_Channel.toString().contains("Star Plus")) {
				  tvcategory.setText("Star Plus");
			  }
			 
			  else if(TV_Channel.toString().contains("MTV")) {
				  tvcategory.setText("MTV");
			  }
			  else if(TV_Channel.toString().contains("Colors TV")) {
				  tvcategory.setText("Colors TV");
			  }
			  else if(TV_Channel.toString().contains("Bindass")) {
				  tvcategory.setText("Bindass");
			  }
			 
			  else if(TV_Channel.toString().contains("Sony")) {
				  tvcategory.setText("Sony");
			  }
			  else if(TV_Channel.toString().contains("Sahara One")) {
				  tvcategory.setText("Sahara One");
			  }
			  else if(TV_Channel.toString().contains("Disney XD")) {
				  tvcategory.setText("Disney XD");
			  }
			 
			  else if(TV_Channel.toString().contains("Hungama TV")) {
				  tvcategory.setText("Hungama TV");
			  }
			  else if(TV_Channel.toString().contains("Pogo")) {
				  tvcategory.setText("Pogo");
			  }
			  else if(TV_Channel.toString().contains("Zee TV")) {
				  tvcategory.setText("Zee TV");
			  }
			 
			  else if(TV_Channel.toString().contains("Sab TV")) {
				  tvcategory.setText("Sab TV");
			  }
			  else if(TV_Channel.toString().contains("Doordarshan")) {
				  tvcategory.setText("Doordarshan");
			  }
			  else if(TV_Channel.toString().contains("ETVKannada")) {
				  tvcategory.setText("ETV Kannada");
			  }
			  else if(TV_Channel.toString().contains("ZeeKannada")) {
				  tvcategory.setText("Zee Kannada");
			  }
			 
			  else if(TV_Channel.toString().contains("Suvarna")) {
				  tvcategory.setText("Suvarna");
			  }
			  else if(TV_Channel.toString().contains("Udaya")) {
				  tvcategory.setText("Udaya");
			  }
			  else if(TV_Channel.toString().contains("MaaTV")) {
				  tvcategory.setText("Maa");
			  }
			  else if(TV_Channel.toString().contains("ETVTelugu")) {
				  tvcategory.setText("ETV Telugu");
			  }
			 
			  else if(TV_Channel.toString().contains("Gemini")) {
				  tvcategory.setText("Gemini");
			  }
			  else if(TV_Channel.toString().contains("ZeeTelugu")) {
				  tvcategory.setText("Zee Telugu");
			  }
			  else if(TV_Channel.toString().contains("Asianet")) {
				  tvcategory.setText("Asianet");
			  }
			  else if(TV_Channel.toString().contains("Surya")) {
				  tvcategory.setText("Surya");
			  }
			  else if(TV_Channel.toString().contains("ZeeMarathi")) {
				  tvcategory.setText("Zee Marathi");
			  }
			  else if(TV_Channel.toString().contains("ETVMarathi")) {
				  tvcategory.setText("ETV Marathi");
			  }
			  else if(TV_Channel.toString().contains("HistoryIndia")) {
				  tvcategory.setText("History India");
			  }
			  else if(TV_Channel.toString().contains("ZeeBengali")) {
				  tvcategory.setText("Zee Bengali");
			  }
			  else if(TV_Channel.toString().contains("ETVBengali")) {
				  tvcategory.setText("ETVBengali");
			  }
			  else if(TV_Channel.toString().contains("ETVGujarati")) {
				  tvcategory.setText("ETV Gujarati");
			  }
			  
			  tvfullscreen=(Button) findViewById(R.id.tvfullscreen);
			 
		      tvfullscreen.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					boolean isConnected=isNetworkConnected();
					if(!isConnected)
						Toast.makeText(TVChannel.this, "Please check Internet Connection", Toast.LENGTH_LONG).show();
					else
					{
						
					
					if(tvyouTubePlayer!=null)
					{
						if(i2 == 0 && i3 == 1){
							HashMap<String, String> test = tvShowCategoryList.get(tvNo);
							String tvVideoId = test.get(TAG_TV_VIDEO_ID);
						//	Toast.makeText(getApplicationContext(), "Cat"+tvShowCategoryList.get(tvNo), Toast.LENGTH_LONG).show();
							Intent intent=new Intent(TVChannel.this,TVPlayer.class);
							intent.putExtra("MOVIE_ID", tvVideoId);
							startActivity(intent);
							}
							
							if(i2 == 1 && i3 == 0){
								HashMap<String, String> test = tvShowCategoryList1.get(tvNo);
								String tvVideoId = test.get(TAG_TV_VIDEO_ID1);
						//		Toast.makeText(getApplicationContext(), "Cat1"+tvShowCategoryList1.get(tvNo), Toast.LENGTH_LONG).show();
								Intent intent=new Intent(TVChannel.this,TVPlayer.class);
								intent.putExtra("MOVIE_ID", tvVideoId);
								startActivity(intent);
								}
					
					}
					else
					{
						Toast.makeText(TVChannel.this, "Please check Internet Connection", Toast.LENGTH_LONG).show();
					}
					}
				}
			});
			
			if (android.os.Build.VERSION.SDK_INT > 9) {
			    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
			    StrictMode.setThreadPolicy(policy);
			}
			     if(TV_Channel.toString().contains("SunTv")){
			    	 tvChannelUrl = "http://166.78.8.58/appstore/mobileapi/tv_suntv.php";
				  }
				  else if(TV_Channel.toString().contains("StarVijay")) {
					  tvChannelUrl = "http://166.78.8.58/appstore/mobileapi/tv_starVijay.php";
				  }
				  else if(TV_Channel.toString().contains("ZeeTamil")) {
					  tvChannelUrl = "http://166.78.8.58/appstore/mobileapi/tv_zeeTamil.php";
				  }
				  else if(TV_Channel.toString().contains("Polimer")) {
					  tvChannelUrl = "http://166.78.8.58/appstore/mobileapi/tv_polimer.php";
				  }
				  else if(TV_Channel.toString().contains("Star Plus")) {
					  tvChannelUrl = "http://166.78.8.58/appstore/mobileapi/tv_starplus.php";
				  }
				  else if(TV_Channel.toString().contains("MTV")) {
					  tvChannelUrl = "http://166.78.8.58/appstore/mobileapi/tv_mtv.php";
				  }
				  else if(TV_Channel.toString().contains("Colors TV")) {
					  tvChannelUrl = "http://166.78.8.58/appstore/mobileapi/tv_colors.php";
				  }
				  else if(TV_Channel.toString().contains("Bindass")) {
					  tvChannelUrl = "http://166.78.8.58/appstore/mobileapi/tv_bindass.php";
				  }
				  else if(TV_Channel.toString().contains("Sony")) {
					  tvChannelUrl = "http://166.78.8.58/appstore/mobileapi/tv_sonytv.php";
				  }
				  else if(TV_Channel.toString().contains("Sahara One")) {
					  tvChannelUrl = "http://166.78.8.58/appstore/mobileapi/tv_saharatv.php";
				  }
				  else if(TV_Channel.toString().contains("Disney XD")) {
					  tvChannelUrl = "http://166.78.8.58/appstore/mobileapi/tv_disneyXD.php";
				  }
				  else if(TV_Channel.toString().contains("Hungama TV")) {
					  tvChannelUrl = "http://166.78.8.58/appstore/mobileapi/tv_hungam.php";
				  }
				  else if(TV_Channel.toString().contains("Pogo")) {
					  tvChannelUrl = "http://166.78.8.58/appstore/mobileapi/tv_pogo.php";
				  }
				  else if(TV_Channel.toString().contains("Zee TV")) {
					  tvChannelUrl = "http://166.78.8.58/appstore/mobileapi/tv_zeetv.php";
				  }
				  else if(TV_Channel.toString().contains("Sab TV")) {
					  tvChannelUrl = "http://166.78.8.58/appstore/mobileapi/tv_sabtv.php";
				  }
				  else if(TV_Channel.toString().contains("Doordarshan")) {
					  tvChannelUrl = "http://166.78.8.58/appstore/mobileapi/tv_doordarshanNational.php";
				  }
				  else if(TV_Channel.toString().contains("ETVKannada")) {
					  tvChannelUrl = "http://166.78.8.58/appstore/mobileapi/tv_etvKannada.php";
				  }
				  else if(TV_Channel.toString().contains("ZeeKannada")) {
					  tvChannelUrl = "http://166.78.8.58/appstore/mobileapi/tv_zeeKannada.php";
				  }
				  else if(TV_Channel.toString().contains("Suvarna")) {
					  tvChannelUrl = "http://166.78.8.58/appstore/mobileapi/tv_suvaranaKannada.php";
				  }
				  else if(TV_Channel.toString().contains("Udaya")) {
					  tvChannelUrl = "http://166.78.8.58/appstore/mobileapi/tv_udayaKannada.php";
				  }
				  else if(TV_Channel.toString().contains("MaaTV")) {
					  tvChannelUrl = "http://166.78.8.58/appstore/mobileapi/tv_maaTelugu.php";
				  }
				  else if(TV_Channel.toString().contains("ETVTelugu")) {
					  tvChannelUrl = "http://166.78.8.58/appstore/mobileapi/tv_etvTelugu.php";
				  }
				  else if(TV_Channel.toString().contains("Gemini")) {
					  tvChannelUrl = "http://166.78.8.58/appstore/mobileapi/tv_geminiTelugu.php";
				  }
				  else if(TV_Channel.toString().contains("ZeeTelugu")) {
					  tvChannelUrl = "http://166.78.8.58/appstore/mobileapi/tv_zeeTelugu.php";
				  }
				  else if(TV_Channel.toString().contains("Asianet")) {
					  tvChannelUrl = "http://166.78.8.58/appstore/mobileapi/tv_asianetGlobal.php";
				  }
				  else if(TV_Channel.toString().contains("Surya")) {
					  tvChannelUrl = "http://166.78.8.58/appstore/mobileapi/tv_surya.php";
				  }
				  else if(TV_Channel.toString().contains("ZeeMarathi")) {
					  tvChannelUrl = "http://166.78.8.58/appstore/mobileapi/tv_zeeMarathi.php";
				  }
				  else if(TV_Channel.toString().contains("ETVMarathi")) {
					  tvChannelUrl = "http://166.78.8.58/appstore/mobileapi/tv_etvMarathi.php";
				  }
				  else if(TV_Channel.toString().contains("HistoryIndia")) {
					  tvChannelUrl = "http://166.78.8.58/appstore/mobileapi/tv_historyIndiaMarathi.php";
				  }
				  else if(TV_Channel.toString().contains("ZeeBengali")) {
					  tvChannelUrl = "http://166.78.8.58/appstore/mobileapi/tv_zeeBengali.php";
				  }
				  else if(TV_Channel.toString().contains("ETVBengali")) {
					  tvChannelUrl = "http://166.78.8.58/appstore/mobileapi/tv_etvBengali.php";
				  }
				  else if(TV_Channel.toString().contains("ETVGujarati")) {
					  tvChannelUrl = "http://166.78.8.58/appstore/mobileapi/tv_etvGujarati.php";
				  }
			
			 DownloadWebPageTask task = new DownloadWebPageTask(getApplicationContext(), tvChannelUrl);
			 task.execute();
				
		}
		

		  private class DownloadWebPageTask extends AsyncTask<Void, Void, String> {    	
		    	String url;
		    	private Context mContext;
		        public DownloadWebPageTask(Context mContext,
		    			String url) {
		    		// TODO Auto-generated constructor stub
		        	this.mContext = mContext;
		        	this.url = url;
		    	}

		    	@Override
		        protected String doInBackground(Void... params)  {
		        	
		    		String is = null;
		    		is = SyncToServer(mContext, url);
		          return is;
		        }

		    	@Override
		        protected void onPostExecute(String bmp) {
		        	if(bmp == null){
		    				    			
		    		}
		    		else{
		    	      Log.i("GIRISH : ","RESULT " +  bmp);
		    	      getResultToDisplay(bmp);
		    		}
		        }	    	
		      }
		  
		  public void getResultToDisplay(String res){
				//final ArrayList<HashMap<String, String>> Spe = new ArrayList<HashMap<String, String>>();
		 	   String result = res;
		 	   JSONArray event_table = null;
		 	
				try {
					event_table = new JSONArray(result);
			        } 
				catch (JSONException e1) 
				    {
					e1.printStackTrace();
					}  
					for(i = 0; i < event_table.length(); i++){
					JSONObject c = null ;
					try {
						c = event_table.getJSONObject(i);
						show_category = c.getString("name");
						show_category_sub = show_category.substring(0, show_category.indexOf(":"));
						long count=show_category_sub.length();
						Log.w("girish","count"+count);
						if(count>=10){
							String name=show_category_sub.substring(0,10);
							show_category_sub_con=name.concat("...");
							tvShowCat.add(name.concat("..."));
							
						}else{
							show_category_sub_con=show_category_sub;
							tvShowCat.add(show_category_sub);
						}
					
				    } catch (Exception e) {
					e.printStackTrace();
				    }
					try {
					c = event_table.getJSONObject(i);
					video_id = c.getString("model");
					} catch (Exception e) {
						e.printStackTrace();
					}
						try {
							c = event_table.getJSONObject(i);
							show_id = c.getString("location");
						} catch (Exception e) {
								e.printStackTrace();
							}
						
						
						
					try {
						c = event_table.getJSONObject(i);
						description = c.getString("meta_description");
					} catch (Exception e) {
							e.printStackTrace();
						}
					
					
					try {
						c = event_table.getJSONObject(i);
						image = c.getString("image");
						
			        } catch (Exception e) {
							e.printStackTrace();
						}
						
						// creating new HashMap
						HashMap<String, String> map = new HashMap<String, String>();
						
						// adding each child node to HashMap key => value
					
						map.put(TAG_TV_SHOW_CATEGORY, show_category_sub);
						map.put(TAG_TV_SHOW_CATEGORY_SUB_CON, show_category_sub_con);
						map.put(TAG_TV_VIDEO_ID, video_id);
						map.put(TAG_TV_SHOW_ID, show_id);
						map.put(TAG_TV_DESCRIPTION, description);
						map.put(TAG_TV_IMAGE, image);
						
						tvShowCategoryList.add(map);
					
						   
					}
					// initialising first time
					HashMap<String, String> test = tvShowCategoryList.get(0);
					Log.d("123", tvShowCategoryList.get(0).toString());
					
					 String showCategory = test.get(TAG_TV_SHOW_CATEGORY);
					 String description = test.get(TAG_TV_DESCRIPTION);
					 String image = test.get(TAG_TV_IMAGE);
					 showid = test.get(TAG_TV_SHOW_ID);
					 url = "http://166.78.8.58/appstore/image/cache/"+image.toString();
					 tvImageView = (ImageView)findViewById(R.id.categoryimage);
					 new DownloadImage().execute(url.toString());
					 find_Description_Cast_Director_ReleasedYear(description);
					 tvshow.setText(showCategory);
					 
					
					 youTubePlayerFragment.initialize(DEVELOPER_KEY, this);
					 //initialising first time end
					 
					 String url1 = "http://166.78.8.58/appstore/mobileapi/BiggBoss.php";
					 DownloadWebPageTask1 task1 = new DownloadWebPageTask1(getApplicationContext(), url1);
					 task1.execute();
					
				/**
				 * Updating parsed JSON data into ListView
				 * */
				ListAdapter adapter = new SimpleAdapter(this, tvShowCategoryList,
					
						R.layout.tvchannel_list_item,
						new String[] { TAG_TV_SHOW_CATEGORY_SUB_CON}, new int[] {
							R.id.speakerName});
				
			/*	selectedAdapter = new SelectedAdapter(this,0,tvShowCat);
			    selectedAdapter.setNotifyOnChange(true);
	*/
			   
//			    lv.setAdapter(selectedAdapter);

			//	lv.setSelected(true); 
				lv.setAdapter(adapter);
			    lv.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int position, long id) {
						
						i2 = 0;
						i3 = 1;
						 tvShowCategoryList1.clear();
						 
					//	 selectedAdapter.setSelectedPosition(position);				
						boolean isConnected=isNetworkConnected();
						if(!isConnected)
							Toast.makeText(TVChannel.this, "Please check Internet Connection", Toast.LENGTH_LONG).show();
						else
						{
						tvNo=position;
						 
						if(tvyouTubePlayer!=null){
						    tvyouTubePlayer.release();
								}
						playNextTrailer();
						HashMap<String, String> test = tvShowCategoryList.get(position);
						 String showCategory = test.get(TAG_TV_SHOW_CATEGORY);
						 String description = test.get(TAG_TV_DESCRIPTION);
						 String image = test.get(TAG_TV_IMAGE);
						 showid = test.get(TAG_TV_SHOW_ID);
						 url = "http://166.78.8.58/appstore/image/cache/"+image.toString();
						 tvImageView = (ImageView)findViewById(R.id.categoryimage);
						 new DownloadImage().execute(url.toString());
						 tvshow.setText(showCategory);				 
						 find_Description_Cast_Director_ReleasedYear(description);
						 String url1 = "http://166.78.8.58/appstore/mobileapi/BiggBoss.php";
						 DownloadWebPageTask1 task1 = new DownloadWebPageTask1(getApplicationContext(), url1);
						 task1.execute();
						 
						  
						
						
						}
					}
				}); //end of on click listener
		
				lv.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int position, long id) {
						
						i2 = 0;
						i3 = 1;
						 tvShowCategoryList1.clear();
					//	 selectedAdapter.setSelectedPosition(position);
						boolean isConnected=isNetworkConnected();
						if(!isConnected)
							Toast.makeText(TVChannel.this, "Please check Internet Connection", Toast.LENGTH_LONG).show();
						else
						{
							tvNo=position;
							
							if(tvyouTubePlayer!=null){
							    tvyouTubePlayer.release();
									}
					    playNextTrailer();
	                     HashMap<String, String> test = tvShowCategoryList.get(position);
	                     String showCategory = test.get(TAG_TV_SHOW_CATEGORY);
	                     String description = test.get(TAG_TV_DESCRIPTION);
						 String image = test.get(TAG_TV_IMAGE);
						 showid = test.get(TAG_TV_SHOW_ID);
						 

			            	EasyTracker easyTracker = EasyTracker.getInstance(TVChannel.this);

							  // MapBuilder.createEvent().build() returns a Map of event fields and values
							  // that are set and sent with the hit.
							  easyTracker.send(MapBuilder
							      .createEvent("Vinay",     // Event category (required)
							    		 "WizBox_TVShows",  // Event action (required)
							                  showCategory,   // Event label
							                   null)            // Event value
							      .build()
							  );	
						 url = "http://166.78.8.58/appstore/image/cache/"+image.toString();
						 tvImageView = (ImageView)findViewById(R.id.categoryimage);
						 new DownloadImage().execute(url.toString());
						 tvshow.setText(showCategory);			 
						 find_Description_Cast_Director_ReleasedYear(description);
						 String url1 = "http://166.78.8.58/appstore/mobileapi/BiggBoss.php";
						 DownloadWebPageTask1 task1 = new DownloadWebPageTask1(getApplicationContext(), url1);
						 task1.execute();
						 
						  
						
						}
						
						
					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub
						
					}
				});
				
				
			}  
			
			
		  
		  private class DownloadWebPageTask1 extends AsyncTask<Void, Void, String> {    	
		    	String url;
		    	private Context mContext;
		        public DownloadWebPageTask1(Context mContext,
		    			String url) {
		    		// TODO Auto-generated constructor stub
		        	this.mContext = mContext;
		        	this.url = url;
		    	}

		    	@Override
		        protected String doInBackground(Void... params)  {
		        	
		    		String is = null;
		    		is = SyncToServer1(mContext, url);
		          return is;
		        }

		    	@Override
		        protected void onPostExecute(String bmp) {
		        	if(bmp == null){
		    				    			
		    		}
		    		else{
		    	      Log.i("GIRISH : ","RESULT1 " +  bmp);
		    	      getResultToDisplay1(bmp);
		    		}
		        }	    	
		      }
		  
		  public void getResultToDisplay1(String res){
				//final ArrayList<HashMap<String, String>> Spe = new ArrayList<HashMap<String, String>>();
		 	   String result = res;
		 	  JSONArray event_table = null;
		 	
		 		try {
					event_table = new JSONArray(result);
			    } catch (JSONException e1) {
					
					e1.printStackTrace();
					
				}  
					for(i = 0; i < event_table.length(); i++){
					JSONObject c = null ;
					
					
					try {
						c = event_table.getJSONObject(i);
						show_category1 = c.getString("upc");
				} catch (Exception e) {
					e.printStackTrace();
				}
						try {
							c = event_table.getJSONObject(i);
							video_id1 = c.getString("model");
					} catch (Exception e) {
						e.printStackTrace();
					}
						
					try {
						c = event_table.getJSONObject(i);
						description1 = c.getString("meta_description");
					} catch (Exception e) {
							e.printStackTrace();
						}
					
					
					try {
						c = event_table.getJSONObject(i);
						image1 = c.getString("image");
						
			        } catch (Exception e) {
							e.printStackTrace();
						}
						
						// creating new HashMap
						HashMap<String, String> map = new HashMap<String, String>();
						map.put(TAG_TV_SHOW_CATEGORY1, show_category1);
						map.put(TAG_TV_VIDEO_ID1, video_id1);
						map.put(TAG_TV_DESCRIPTION1, description1);
						map.put(TAG_TV_IMAGE1, image1);
						
						tvShowCategoryList1.add(map);
					
						   
					}
					// initialising first time
//					 HashMap<String, String> test = tvShowCategoryList1.get(0);
//					 
//					 String description = test.get(TAG_TV_DESCRIPTION1);
//					 String image = test.get(TAG_TV_IMAGE1);
//					 url = "http://166.78.8.58/appstore/image/cache/"+image.toString();
//					 tvImageView = (ImageView)findViewById(R.id.categoryimage);
//					 new DownloadImage().execute(url.toString());
//					
//									 
//					 find_Description_Cast_Director_ReleasedYear1(description);
					 
					
					 //initialising first time end
					
				/**
				 * Updating parsed JSON data into ListView
				 * */
					 
					
				ListAdapter adapter = new SimpleAdapter(this, tvShowCategoryList1,
					
						R.layout.tvchannel_list_item,
						new String[] { TAG_TV_SHOW_CATEGORY1}, new int[] {
							R.id.speakerName});
				
				lv1.setSelected(true); 
				lv1.setAdapter(adapter);
				lv1.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int position, long id) {
						
						i2 = 1;
						i3 = 0;
						boolean isConnected=isNetworkConnected();
						if(!isConnected)
							Toast.makeText(TVChannel.this, "Please check Internet Connection", Toast.LENGTH_LONG).show();
						else
						{
						tvNo=position;
						 
						if(tvyouTubePlayer!=null){
						    tvyouTubePlayer.release();
								}
						playNextTrailer();
//						HashMap<String, String> test = tvShowCategoryList1.get(position);
//						
//						 String description = test.get(TAG_TV_DESCRIPTION1);
//						 String image = test.get(TAG_TV_IMAGE1);
//						
//						 url = "http://166.78.8.58/appstore/image/cache/"+image.toString();
//						 tvImageView = (ImageView)findViewById(R.id.categoryimage);
//						 new DownloadImage().execute(url.toString());
//										 
//						 find_Description_Cast_Director_ReleasedYear1(description);
//						
						 
						  
						
						
						}
					}
				}); //end of on click listener
		       
				lv1.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int position, long id) {
						
						i2 = 1;
						i3 = 0;
						boolean isConnected=isNetworkConnected();
						if(!isConnected)
							Toast.makeText(TVChannel.this, "Please check Internet Connection", Toast.LENGTH_LONG).show();
						else
						{
							tvNo=position;
							if(tvyouTubePlayer!=null){
					    tvyouTubePlayer.release();
							}
					    playNextTrailer();
//	                    HashMap<String, String> test = tvShowCategoryList1.get(position);
//						
//						String description = test.get(TAG_TV_DESCRIPTION1);
//						String image = test.get(TAG_TV_IMAGE1);
//						
//						 url = "http://166.78.8.58/appstore/image/cache/"+image.toString();
//						 tvImageView = (ImageView)findViewById(R.id.categoryimage);
//						 new DownloadImage().execute(url.toString());
//						 
//					
//						
//										 
//						 find_Description_Cast_Director_ReleasedYear1(description);
//						
						 
						  
						
						}
						
						
					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub
						
					}
				});
				
				
			}  
					
			
			//download icon image 
			
			
			private void setImage(Drawable drawable)
			
			
			{
			    tvImageView.setImageDrawable(drawable);
			}

			public class DownloadImage extends AsyncTask<String, Integer, Drawable> {
				


			    @Override
			    protected Drawable doInBackground(String... arg0) {
			        // This is done in a background thread
			        return downloadImage(arg0[0]);
			    }

			    /**
			     * Called after the image has been downloaded
			     * -> this calls a function on the main thread again
			     */
			    protected void onPostExecute(Drawable image)
			    {
			        setImage(image);
			       // mProgressDialog.dismiss();
			    }


			    /**
			     * Actually download the Image from the _url
			     * @param _url
			     * @return
			     */
			    @SuppressWarnings("deprecation")
				private Drawable downloadImage(String _url)
			    {
			        //Prepare to download image
			        URL url;        
			        InputStream in;
			        BufferedInputStream buf;

			     
			        try {
			            url = new URL(_url);
			            in = url.openStream();


			            
			            buf = new BufferedInputStream(in);

			          
			            Bitmap bMap = BitmapFactory.decodeStream(buf);
			            if (in != null) {
			                in.close();
			            }
			            if (buf != null) {
			                buf.close();
			            }

			            return new BitmapDrawable(bMap);

			        } catch (Exception e) {
			            Log.e("Error reading file", e.toString());
			        }

			        return null;
			    }
			    
			   

			}
			
			private String SyncToServer(Context mContext, String url) {
				final HttpClient httpclient = new DefaultHttpClient();
				HttpPost httppost = new HttpPost(url);
				 String result = null;
				    InputStream is = null;
				    StringBuilder sb=null;
				   
				  

				    try {
	              	
						
				        HttpResponse response = httpclient.execute(httppost);
						is = response.getEntity().getContent();
					
				    } catch (Exception e) {
				    	Log.d("blah","addressBook.build().http exception" + e);
				    	
				    }
				    try{
				        BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
				         sb = new StringBuilder();
				         sb.append(reader.readLine() + "\n");

				         String line="0";
				         while ((line = reader.readLine()) != null) {
				                        sb.append(line + "\n");
				          }
				          is.close();
				          result=sb.toString();
				    }catch(Exception e){
				                Log.e("log_tag", "Error converting result "+e.toString());
				          }
					return result;
			}
			
			
			private String SyncToServer1(Context mContext, String url) {
				final HttpClient httpclient = new DefaultHttpClient();
				HttpPost httppost = new HttpPost(url);
				Log.d("TAG", "SyncToServer1"+ url);
				 String result = null;
				    InputStream is = null;
				    StringBuilder sb=null;
				    JSONObject json = new JSONObject();

				    try {
				    	
				    	String show = showid.toString().trim();
				    	Log.d("TAG", "json"+ show);
				    	json.put("lang", show);					
						//	json.put("password", Password);
				    	Log.d("TAG", "json"+ json);
						JSONArray postjson=new JSONArray();
						postjson.put(json);
						
						httppost.setHeader("json",json.toString());
						httppost.getParams().setParameter("jsonpost",postjson);


				        HttpResponse response = httpclient.execute(httppost);
						is = response.getEntity().getContent();
					
				    } catch (Exception e) {
				    	Log.d("blah","addressBook.build().http exception" + e);
				    	
				    }
				    try{
				        BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
				         sb = new StringBuilder();
				         sb.append(reader.readLine() + "\n");

				         String line="0";
				         while ((line = reader.readLine()) != null) {
				                        sb.append(line + "\n");
				          }
				          is.close();
				          result=sb.toString();
				    }catch(Exception e){
				                Log.e("log_tag", "Error converting result "+e.toString());
				          }
					return result;
			}
			
			//download apk
			
		
			



			private boolean isNetworkConnected() {
				  ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
				  NetworkInfo ni = cm.getActiveNetworkInfo();
				  if (ni == null) {
				   // There are no active networks.
				   return false;
				  } else
				   return true;
				 }
			@Override
			protected void onPause() {
				
			if(tvyouTubePlayer!=null){
				tvyouTubePlayer.pause();
			}
			
			 	
				super.onPause();
			}
			@Override
			protected void onResume() {
				
				super.onResume();
			}
			
			public void playNextTrailer(){
				youTubePlayerFragment.initialize(DEVELOPER_KEY, this);
			}
			
			
			public void find_Description_Cast_Director_ReleasedYear(String description){
				
				 
				// getting description
				 int start=description.indexOf("sodescription");
				 int end=description.indexOf("eodescription");
				 int ln="sodescription".length();
				 String movie_description=description.substring(start+ln, end);
				 
				 long count=movie_description.length();
					Log.w("girish","count"+count);
					if(count>=85){
						String name=movie_description.substring(0,85);
						String movie_description1=name.concat("..........more");
						tvdescription.setText(movie_description1.trim());
					}
				
				 Log.d("movieDescription", movie_description);
				// getting cast
				
				// getting director
				 int dstart=description.indexOf("sodirector");
				 int dend=description.indexOf("eodirector");
				 String director="sodirector";
				 int dlenth=director.length();
				 String mdirector=description.substring(dstart+dlenth, dend);
				 Log.d("type", mdirector.toString()); 
			
				
				 
		//		 if(mdirector.length()!=0){
				
		//		 }
				 
				  
				
			}
			public void find_Description_Cast_Director_ReleasedYear1(String description){
				
				String movie_description1 = "Not Available";
				try
				{
				try{
					
				
				// getting description
				 int start=description.indexOf("sodescription");
				 int end=description.indexOf("eodescription");
				 int ln="sodescription".length();
	             String movie_description=description.substring(start+ln, end);
				 long count=movie_description.length();
					Log.w("girish","count"+count);
					if(count>=85){
						String name=movie_description.substring(0,85);
					    movie_description1=name.concat("..........more");
						tvdescription.setText(movie_description1.trim());
					}
				 Log.d("movieDescription", movie_description);
				// getting cast
				}catch(Exception e){
					tvdescription.setText(movie_description1.trim());
				}
			}
			catch(StringIndexOutOfBoundsException e)
			{
				tvdescription.setText(movie_description1.trim());
			}
			catch(Exception e)
			{

				tvdescription.setText(movie_description1.trim());
			}
				
				
				
			}
			@Override
			public void onInitializationFailure(Provider provider,
					YouTubeInitializationResult error) {
				  
				//Toast.makeText(this, "Oh no! "+error.toString(), Toast.LENGTH_LONG).show(); 
				Toast.makeText(this, "Please check your Internet Connection", Toast.LENGTH_LONG).show();
				
			}
	    	@Override
			public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
				tvyouTubePlayer=player;
				tvfullscreen.setVisibility(View.VISIBLE);
				tvyouTubePlayer.setPlayerStyle(PlayerStyle.CHROMELESS);
				 
				if(i2 == 0 && i3 == 1){
				HashMap<String, String> test = tvShowCategoryList.get(tvNo);
				 String TRAILERID = test.get(TAG_TV_VIDEO_ID);
				tvyouTubePlayer.loadVideo(TRAILERID); 
				}
				
				if(i2 == 1 && i3 == 0){
					HashMap<String, String> test = tvShowCategoryList1.get(tvNo);
					 String TRAILERID = test.get(TAG_TV_VIDEO_ID1);
					tvyouTubePlayer.loadVideo(TRAILERID); 
					}
				
			}
	    	public void onStop() {
	    	    super.onStop();
	    	  EasyTracker.getInstance(this).activityStop(this);
	    	  }

		}
		  
    	
    	
	 
