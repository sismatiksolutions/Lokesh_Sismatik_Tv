package com.ovionmedia.wizbox.movies;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
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

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.support.v4.view.ViewPager.LayoutParams;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
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

public class Family extends ListActivity implements YouTubePlayer.OnInitializedListener{

    // browser key
static private final String DEVELOPER_KEY = "AIzaSyAoHG1bz2y1pqPEJDQ2Z4pz-5D2SKwBLCA";
static private String VIDEO = "FyXXgpPqe6w"; 
YouTubePlayer youTubePlayer;
private TextView movieName;
private TextView movieDescription;
private TextView movieType;
private TextView movieDuration;
private TextView castText;
private TextView releasedYear;
private TextView movieDirector;

private RatingBar ratingBar;
private Button fullscreen;
private String []movieArray;
int selectedLanguage;
private String[] languageName;
String langname;

//private String trailerId[]={"92n47Nkjp30", "ddRE9_xYby8", "05beZnFlZKM", "B2KN9HefMZc", "_uNDm6YfN2k", "GbS2YuclXr4"};
	
private   int movieNo=0;
YouTubePlayerFragment youTubePlayerFragment;

private static final String TAG_MOVIENAME = "MOVIENAME";
	private static final String TAG_TRAILERID = "TRAILERID";
	private static final String TAG_DESCRIPTION = "description";
	private static final String TAG_LINKEDIN = "linkedin_profile";
	private static final String TAG_PRODUCT_ID = "product_id";
	private static final String TAG_MOVIE_ID = "MOVIE_ID";
	private static final String TAG_MOVIE_TYPE = "MOVIE_TYPE";
	private static final String TAG_MOVIE_DURATION = "MOVIE_DURATION";
	private static final String TAG_RATING_BAR = "RATING_BAR";
	 
	
	private static final String TAG_IMAGE = "image";
	
	private String trailer_id;
	private String movie_name;
	public String description;
	private String linkedin_profile;
	private String product_id;
	private String movie_id;
	private String movie_duration;
	private String movie_type;
	private String rating_bar;
	 
	private String image;
	LinearLayout rel;
	LayoutInflater layoutInflater;
	View itemView;
	ImageView mImageView;
	ProgressDialog mProgressDialog;

	static String[] product = new String[100];
	static int i;
	
	public static String imageurl = "http://166.78.8.58/appstore/image/cache/";
	 String URL;
	 
	 public static String apkurl ="";
	 public static String url ="";
	
	final ArrayList<HashMap<String, String>> movieList = new ArrayList<HashMap<String, String>>();
	 ListView lv = null;
	 
	@Override 
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.moviecategory);		
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		EasyTracker.getInstance(this).activityStart(this);
		youTubePlayerFragment =
		        (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.youtube_fragment);
		
	    
		  movieName = (TextView) findViewById(R.id.movie_name);
		TextView heading = (TextView) findViewById(R.id.heading);
		 movieDescription = (TextView) findViewById(R.id.descriptionText);
		movieType=(TextView) findViewById(R.id.movieType);
		movieDuration=(TextView) findViewById(R.id.movieDuration);
		castText=(TextView) findViewById(R.id.castText);
		releasedYear=(TextView) findViewById(R.id.releasedYear);
		movieDirector=(TextView) findViewById(R.id.director);
		
		heading.setText("Family");
		  fullscreen=(Button) findViewById(R.id.fullscreen);
		 
	  ratingBar=(RatingBar) findViewById(R.id.ratingBar1);
	  
	  fullscreen.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				boolean isConnected=isNetworkConnected();
				if(!isConnected)
					Toast.makeText(Family.this, "Please check Internet Connection", Toast.LENGTH_LONG).show();
				else
				{
					
				
				if(youTubePlayer!=null)
				{
				HashMap<String, String> test = movieList.get(movieNo);
				String MOVIE_ID = test.get(TAG_MOVIE_ID);
				
				Intent intent=new Intent(Family.this,MoviePlayer.class);
				intent.putExtra("MOVIE_ID", MOVIE_ID);
				startActivity(intent);
				}
				else
				{
					Toast.makeText(Family.this, "Please check Internet Connection", Toast.LENGTH_LONG).show();
				}
				}
			}
		});
		
		if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}
	
		//getting selected language
				selectedLanguage=getIntent().getExtras().getInt("selectedLanguage");
				languageName=getResources().getStringArray(R.array.language);
				 
				 langname=languageName[selectedLanguage];
				String movieUrl=null;
				switch(selectedLanguage)
				{
				
				case 0:
					movieUrl="http://166.78.8.58/appstore/mobileapi/family.php";
					break;
				case 1:
					movieUrl="http://166.78.8.58/appstore/mobileapi/English_Family.php";
					break;
				case 2:
					movieUrl="http://166.78.8.58/appstore/mobileapi/Telugu_Family.php";
					break;
				case 3:
					movieUrl="http://166.78.8.58/appstore/mobileapi/Tamil_Family.php";
					break;
				case 4:
					movieUrl="http://166.78.8.58/appstore/mobileapi/Malyalam_Family.php";
					break;
				case 5:
					movieUrl="http://166.78.8.58/appstore/mobileapi/Bengali_Family.php";
					break;
				case 6:
					movieUrl="http://166.78.8.58/appstore/mobileapi/Kannada_Family.php";
					break;
				case 7:
					movieUrl="http://166.78.8.58/appstore/mobileapi/Marathi_Family.php";
					break;
				case 8:
					movieUrl="http://166.78.8.58/appstore/mobileapi/Punjabi_Family.php";
					break;
				case 9:
					movieUrl="http://166.78.8.58/appstore/mobileapi/Gujarati_Family.php";
					break;
				case 10:
					movieUrl="http://166.78.8.58/appstore/mobileapi/Bhojpuri_Family.php";
					break;
				}
		//String url = "http://166.78.8.58/appstore/mobileapi/family.php";
		//String url = "http://166.78.8.58/appstore/mobileapi/tv_starplus.php";
		 DownloadWebPageTask task = new DownloadWebPageTask(getApplicationContext(), movieUrl);
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
	    	      Log.i("ARUNA : ","RESULT " +  bmp);
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
		} catch (JSONException e1) {
				
				e1.printStackTrace();
				
			}  

			// initialising movieArray
						movieArray=new String[event_table.length()];
				for(i = 0; i < event_table.length(); i++){
				JSONObject c = null ;
				
				try {
					c = event_table.getJSONObject(i);
					movie_name = c.getString("name");
					Log.d("bharathi", movie_name);
				} catch (Exception e) {
						e.printStackTrace();
					}
					try {
						c = event_table.getJSONObject(i);
						trailer_id = c.getString("model");
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
					linkedin_profile = c.getString("filename");
					Log.d("bharathi", linkedin_profile);
				} catch (Exception e) {
						e.printStackTrace();
					}
				// Getting movie id
				try {
					c = event_table.getJSONObject(i);
					movie_id = c.getString("sku");
					Log.d("MOVIE_ID", movie_id);   
				} catch (Exception e) {
						e.printStackTrace();
					}
				// Getting movie type
				try {
					c = event_table.getJSONObject(i);
					movie_type = c.getString("upc");
					Log.d("MOVIE_TYPE", movie_type);   
				} catch (Exception e) {
						e.printStackTrace();
					}
				// Getting movie duration
				try {
					c = event_table.getJSONObject(i);
					movie_duration = c.getString("location");
					Log.d("MOVIE_DURATION", movie_duration);   
				} catch (Exception e) {
						e.printStackTrace();
					}
				// Getting movie rating bar
				try {
					c = event_table.getJSONObject(i);
					rating_bar = c.getString("price");
					Log.d("RATING_BAR", rating_bar);   
				} catch (Exception e) {
						e.printStackTrace();
					}
				 
//				
//				try {
//					c = event_table.getJSONObject(i);
//					product_id = c.getString("product_id");
//					
//				} catch (Exception e) {
//						e.printStackTrace();
//					}
				
				try {
					c = event_table.getJSONObject(i);
					image = c.getString("image");
					
//					
//					URL = imageurl+image;
//					Log.d("bharathi", URL);
//					final ImageView iv = (ImageView) findViewById(R.id.speaker_image);
//					 img[i] = URL;
//					 
//					 imageUrls = new String[img.length];
//						List<String> urls = new ArrayList<String>();
//						urls.addAll(Arrays.asList(img));
//						imageUrls = (String[]) urls.toArray(new String[0]);
//					
//					Log.d("Bharathi", image);
				} catch (Exception e) {
						e.printStackTrace();
					}
					
					// creating new HashMap
					HashMap<String, String> map = new HashMap<String, String>();
					
					// adding each child node to HashMap key => value
				
					map.put(TAG_MOVIENAME, movie_name);
					map.put(TAG_TRAILERID, trailer_id);
					map.put(TAG_DESCRIPTION, description);
					map.put(TAG_LINKEDIN, linkedin_profile);
					map.put(TAG_PRODUCT_ID, product_id);
					map.put(TAG_MOVIE_ID, movie_id);
					map.put(TAG_MOVIE_TYPE, movie_type);
					map.put(TAG_MOVIE_DURATION, movie_duration);
					map.put(TAG_RATING_BAR, rating_bar);
					map.put(TAG_IMAGE, image);
					
					//map.put(TAG_ADDL_INFO, additional_info);
					
					// adding HashList to ArrayList
					movieList.add(map);
//					 // putting data into movieArray
					movieArray[i]=movie_name;
//					lv = (ListView) findViewById(android.R.id.list);
//					((ListView) lv).setAdapter(new ItemAdapter());
					
					   
				}
				// initialising first time
				HashMap<String, String> test = movieList.get(0);
				Log.d("123", movieList.get(0).toString());
				
				 String MOVIENAME = test.get(TAG_MOVIENAME);
				 String MOVIE_TYPE = test.get(TAG_MOVIE_TYPE);
				 String MOVIE_DURATION = test.get(TAG_MOVIE_DURATION);
				 //String TRAILERID = test.get(TAG_TRAILERID);
				 String description = test.get(TAG_DESCRIPTION);
				 String image = test.get(TAG_IMAGE);
				 String ratingbar=test.get(TAG_RATING_BAR);
				 
				// Toast.makeText(getBaseContext(), TRAILERID, Toast.LENGTH_LONG).show();
				//downloading and setting image
				 url = "http://166.78.8.58/appstore/image/cache/"+image.toString();
				 mImageView = (ImageView)findViewById(R.id.movie_poster);
				 new DownloadImage().execute(url.toString());
				 
				 movieName.setText(MOVIENAME);
				 movieType.setText(MOVIE_TYPE);
				 movieDuration.setText(MOVIE_DURATION);
				 ratingBar.setRating(Float.parseFloat(ratingbar));
				 
				 find_Description_Cast_Director_ReleasedYear(description);
				
				 
				 //movieDescription.setText(description);
				// movieDescription.setText(movie_description);
				// after editing rating bar, make it not editable by user
				 ratingBar.setIsIndicator(true);
				 youTubePlayerFragment.initialize(DEVELOPER_KEY, this);
				 //initialising first time end
				
			/**
			 * Updating parsed JSON data into ListView
			 * */
				 /*
			ListAdapter adapter = new SimpleAdapter(this, movieList,
				
					R.layout.speaker_list_item,
					new String[] { TAG_MOVIENAME}, new int[] {
						R.id.speakerName});

			setListAdapter(adapter);
			*/
			
				//setting list adapter
				    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				             R.layout.moviehome_list,R.id.textView1, movieArray);
				        setListAdapter(adapter);
			lv = getListView();
		/*
			lv.setOnItemSelectedListener(new OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int position, long id) {
					// TODO Auto-generated method stub
					
					Log.d("123", "created");
					
					HashMap<String, String> test = speakersList.get(position);
					
					 String speaker_name = test.get(TAG_SPEAKER);
					 String title = test.get(TAG_TITLE);
					 String description = test.get(TAG_DESCRIPTION);
					 String linkedin_profile = test.get(TAG_LINKEDIN);
					 String product_id = test.get(TAG_PRODUCT_ID);
					 String image = test.get(TAG_IMAGE);
					
					 
					 rel = (LinearLayout) findViewById(R.id.rightLayout1);
					 
					 
						rel.removeAllViews();
						
						layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
						itemView = layoutInflater.inflate(
								R.layout.list_item, null);
						
						TextView movietitle = (TextView)itemView. findViewById(R.id.movietitle);
						movietitle.setText(speaker_name);
						
						TextView tv2 = (TextView)itemView. findViewById(R.id.movietype);
						tv2.setText("Action");
						
						TextView name = (TextView) findViewById(R.id.movie);
						name.setText(speaker_name);
					url = "http://166.78.8.58/appstore/image/cache/"+image.toString();
					Log.d("imageurl", url.toString());
					
					apkurl = "http://166.78.8.58/appstore/download/"+linkedin_profile.toString();
			        Log.d("Url", apkurl.toString());
						
					 mImageView = (ImageView)itemView. findViewById(R.id.movie_poster);
					 
					 Button install = (Button)itemView.findViewById(R.id.install);
				        
						new DownloadImage().execute(url.toString());
						
						
						rel.addView(itemView, new LinearLayout.LayoutParams(
								LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
						
						
						install.setOnClickListener(new OnClickListener() {
				          	 
							public void onClick(View arg0) {
								
								
					            
					            downloadInstall(apkurl);
					
			Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_LONG).show();
			
			
				        }
				    });  
					
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					
				}
				
				
				
			});
			*/
			lv.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int position, long id) {
					
					boolean isConnected=isNetworkConnected();
					if(!isConnected)
						Toast.makeText(Family.this, "Please check Internet Connection", Toast.LENGTH_LONG).show();
					else
					{
						try{
					movieNo=position;
					 if(youTubePlayer!=null)
					youTubePlayer.release();
					playNextTrailer();
					HashMap<String, String> test = movieList.get(position);
					
					 String MOVIENAME = test.get(TAG_MOVIENAME);
					 String MOVIE_TYPE = test.get(TAG_MOVIE_TYPE);
					 String MOVIE_DURATION = test.get(TAG_MOVIE_DURATION);
					 String TRAILERID = test.get(TAG_TRAILERID);
					 String description = test.get(TAG_DESCRIPTION);
					 String ratingbar=test.get(TAG_RATING_BAR);
					 String image = test.get(TAG_IMAGE);
					 
					 EasyTracker easyTracker = EasyTracker.getInstance(Family.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		  langname+"_Family",  // Event action (required)
					                   MOVIENAME,   // Event label
					                   null)            // Event value
					      .build()
					  );	
					 //Toast.makeText(getBaseContext(), TRAILERID, Toast.LENGTH_LONG).show();
					 //downloading and setting image
					 url = "http://166.78.8.58/appstore/image/cache/"+image.toString();
					 mImageView = (ImageView)findViewById(R.id.movie_poster);
					 new DownloadImage().execute(url.toString());
					 
					 find_Description_Cast_Director_ReleasedYear(description);
					 
					 movieName.setText(MOVIENAME);
					 movieType.setText(MOVIE_TYPE);
					 movieDuration.setText(MOVIE_DURATION);
					 // make editable rating bar
					 ratingBar.setIsIndicator(false);
					 ratingBar.setRating(Float.parseFloat(ratingbar));
					// after editing rating bar, make it not editable by user
					 ratingBar.setIsIndicator(true);
					 //movieDescription.setText(description);
					 
					  
					//VIDEO=trailerId[position];
					//youTubePlayer.setPlayerStyle(PlayerStyle.CHROMELESS);
				//	Toast.makeText(getBaseContext(), VIDEO, Toast.LENGTH_LONG).show();
					//youTubePlayer.loadVideo(TRAILERID);
						}catch(Exception e){
							Toast.makeText(Family.this, "An exception occured", Toast.LENGTH_LONG).show();
						}
					}
				}
			}); //end of on click listener
	
			lv.setOnItemSelectedListener(new OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int position, long id) {
					
					boolean isConnected=isNetworkConnected();
					if(!isConnected)
						Toast.makeText(Family.this, "Please check Internet Connection", Toast.LENGTH_LONG).show();
					else
					{
						try{
						movieNo=position;
						if(youTubePlayer!=null)	
				    youTubePlayer.release();
				    playNextTrailer();
					HashMap<String, String> test = movieList.get(position);
					
					 String MOVIENAME = test.get(TAG_MOVIENAME);
					 String MOVIE_TYPE = test.get(TAG_MOVIE_TYPE);
					 String MOVIE_DURATION = test.get(TAG_MOVIE_DURATION);
					 String TRAILERID = test.get(TAG_TRAILERID);
					 String description = test.get(TAG_DESCRIPTION);
					 String ratingbar=test.get(TAG_RATING_BAR);
					 String image = test.get(TAG_IMAGE);
					 
					 EasyTracker easyTracker = EasyTracker.getInstance(Family.this);

					  // MapBuilder.createEvent().build() returns a Map of event fields and values
					  // that are set and sent with the hit.
					  easyTracker.send(MapBuilder
					      .createEvent("Vinay",     // Event category (required)
					    		  langname+"_Family",  // Event action (required)
					                   MOVIENAME,   // Event label
					                   null)            // Event value
					      .build()
					  );	
					 
					// Toast.makeText(getBaseContext(), TRAILERID, Toast.LENGTH_LONG).show();
					//downloading and setting image
					 url = "http://166.78.8.58/appstore/image/cache/"+image.toString();
					 mImageView = (ImageView)findViewById(R.id.movie_poster);
					 new DownloadImage().execute(url.toString());
					 
					 find_Description_Cast_Director_ReleasedYear(description);
					 movieName.setText(MOVIENAME); 
					 movieType.setText(MOVIE_TYPE);
					 movieDuration.setText(MOVIE_DURATION);
					 // make editable rating bar
					 ratingBar.setIsIndicator(false);
					 ratingBar.setRating(Float.parseFloat(ratingbar));
					// after editing rating bar, make it not editable by user
					 ratingBar.setIsIndicator(true);
					 
					// movieDescription.setText(description);
					 
					
				//	VIDEO=trailerId[position];
				//	youTubePlayer.pause();
					
					//youTubePlayer.loadVideo(TRAILERID);
						}catch(Exception e){
							Toast.makeText(Family.this, "An exception occured", Toast.LENGTH_LONG).show();
						}
					}
					
					
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			
			/*
			lv.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int position, long id) {
                      Log.d("123", "created");
					
					HashMap<String, String> test = speakersList.get(position);
					
					 String speaker_name = test.get(TAG_SPEAKER);
					 String title = test.get(TAG_TITLE);
					 String description = test.get(TAG_DESCRIPTION);
					 String linkedin_profile = test.get(TAG_LINKEDIN);
					 String product_id = test.get(TAG_PRODUCT_ID);
					 String image = test.get(TAG_IMAGE);
					
					 rel = (LinearLayout) findViewById(R.id.rightLayout1);
					 
					 
						rel.removeAllViews();
						
						layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
						itemView = layoutInflater.inflate(
								R.layout.list_item, null);
						
						TextView movietitle = (TextView)itemView. findViewById(R.id.movietitle);
						movietitle.setText(speaker_name);
						
						TextView name = (TextView)itemView.findViewById(R.id.movie);
						name.setText(speaker_name);
					//	Log.d("test", speaker_name.toString());
						
						TextView tv2 = (TextView)itemView.findViewById(R.id.movietype);
						tv2.setText("Action");
						Log.d("test1", tv2.toString());
						
						
					url = "http://166.78.8.58/appstore/image/cache/"+image.toString();
					Log.d("imageurl", url.toString());
					
					apkurl = "http://166.78.8.58/appstore/download/"+linkedin_profile.toString();
			        Log.d("Url", apkurl.toString());
						
					 mImageView = (ImageView)itemView. findViewById(R.id.movie_poster);
					 
					 Button install = (Button)itemView.findViewById(R.id.install);
				        
						new DownloadImage().execute(url.toString());
						
						
						rel.addView(itemView, new LinearLayout.LayoutParams(
								LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
						
						
						install.setOnClickListener(new OnClickListener() {
				          	 
							public void onClick(View arg0) {
								
								
					            
					            downloadInstall(apkurl);
					
			Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_LONG).show();
			
			
				        }
				    });  
					
				}
			});*/
			
		}  
		
		
		//download icon image 
		
		@SuppressWarnings("deprecation")
		private void setImage(Drawable drawable)
		{
		    mImageView.setBackgroundDrawable(drawable);
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
		        BufferedOutputStream out;
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
		
		
		//download apk
		
		public void downloadInstall(String apkurl){
			
			
	       
            try {
	        	
	        	
	        	
//	              URL url = new URL(apkurl);
//	              HttpURLConnection c = (HttpURLConnection) url.openConnection();
	        	
	        	URL url = new URL(apkurl.replaceAll(" ","%20"));

	        	 HttpURLConnection c = (HttpURLConnection) url.openConnection();

	        	  c.setRequestProperty("User-agent", "Mozilla/4.0");
	              c.setRequestMethod("GET");
	              c.setDoOutput(true);
	              c.connect();

	              String PATH = Environment.getExternalStorageDirectory() + "/download/";
	              File file = new File(PATH);
	              file.mkdirs();
	              File outputFile = new File(file, "action.apk");
	              FileOutputStream fos = new FileOutputStream(outputFile);

	              InputStream is = c.getInputStream();

	              byte[] buffer = new byte[1024];
	              int len1 = 0;
	              while ((len1 = is.read(buffer)) != -1) {
	                  fos.write(buffer, 0, len1);
	              }
	              fos.close();
	              is.close();


	             
	       Intent intent = new Intent(Intent.ACTION_VIEW);
	       intent.setDataAndType(Uri.fromFile(new File(Environment.getExternalStorageDirectory() +
	    		   "/download/" + "action.apk")), "application/vnd.android.package-archive");
	       startActivity(intent); 

	          } catch (IOException e) {
	              Toast.makeText(getApplicationContext(), "download error!", Toast.LENGTH_LONG).show();
	          }
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
		@Override
		protected void onPause() {
			
		if(youTubePlayer!=null){
			youTubePlayer.release();
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
			
			 
			String movie_description="Not Available";
			String movie_cast="Not Available";
			String movie_releasedYear="Not Available";
			String mdirector="Not Available";
			try{
				
			try
			{
			// getting description
			 int start=description.indexOf("sodescription");
			 int end=description.indexOf("eodescription");
			 int ln="sodescription".length();
			   movie_description=description.substring(start+ln, end);
			 movieDescription.setText("Description :\n"+movie_description.trim());
			 Log.d("movieDescription", movie_description);
		
			}catch(Exception e){
				movieDescription.setText("Description : "+movie_description.trim());
			}
			
			try
			{
			
			// getting cast
			 int cstart=description.indexOf("socast");
			 int cend=description.indexOf("eocast");
			 String mcast="socast";
			 int clenth=mcast.length();
			   movie_cast=description.substring(cstart+clenth, cend);
			 castText.setText("Cast :\n"+movie_cast.trim());
			 Log.d("movie_cast", movie_cast);
			 
			}catch(Exception e){
				castText.setText("Cast : "+movie_cast.trim());
			}
			
			try
			{
			// getting released year
			 int rstart=description.indexOf("soreleasedyear");
			 int rend=description.indexOf("eoreleasedyear");
			 String released_Year="soreleasedyear";
			 int rlenth=released_Year.length();
			   movie_releasedYear=description.substring(rstart+rlenth, rend);
			 releasedYear.setText("Released Year :"+movie_releasedYear.trim());
			 Log.d("movie_releasedYear", movie_releasedYear);
			}catch(Exception e){
				releasedYear.setText("Released Year : "+movie_releasedYear.trim());
			}
			
			try
			{
			// getting director
			 int dstart=description.indexOf("sodirector");
			 int dend=description.indexOf("eodirector");
			 String director="sodirector";
			 int dlenth=director.length();
			  mdirector=description.substring(dstart+dlenth, dend);
			 movieDirector.setText("Director :"+mdirector.trim());
			 Log.d("mdirector", mdirector); 
			}catch(Exception e){
				movieDirector.setText("Director : "+mdirector.trim());
			}
			
			}
			catch(StringIndexOutOfBoundsException e)
			{
				 movieDescription.setText("Description : "+movie_description.trim());	
				 castText.setText("Cast : "+movie_cast.trim());
				 releasedYear.setText("Released Year : "+movie_releasedYear.trim());
				 movieDirector.setText("Director : "+mdirector.trim());
			}
			catch(Exception e)
			{

				 movieDescription.setText("Description : "+movie_description.trim());	
				 castText.setText("Cast : "+movie_cast.trim());
				 releasedYear.setText("Released Year : "+movie_releasedYear.trim());
				 movieDirector.setText("Director : "+mdirector.trim());
			}
			  
			
		}
		@Override
		public void onInitializationFailure(Provider provider,
				YouTubeInitializationResult error) {
			  
			//Toast.makeText(this, "Oh no! "+error.toString(), Toast.LENGTH_LONG).show(); 
			Toast.makeText(this, "No Internet Connection Or Very Slow Speed", Toast.LENGTH_LONG).show();
			
		}
	@Override
		public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
			youTubePlayer=player;
			fullscreen.setVisibility(View.VISIBLE);
			youTubePlayer.setPlayerStyle(PlayerStyle.CHROMELESS);
			 
			
			HashMap<String, String> test = movieList.get(movieNo);
			 String TRAILERID = test.get(TAG_TRAILERID);
			youTubePlayer.loadVideo(TRAILERID); 
			
		}

	public void onStop() {
	    super.onStop();
	  EasyTracker.getInstance(this).activityStop(this);
	  }
	}
	
		  
	 
