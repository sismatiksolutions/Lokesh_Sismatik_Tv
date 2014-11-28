package com.ovionmedia.wizbox.launcher;

import android.app.Fragment;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.google.analytics.tracking.android.MapBuilder;
import com.google.analytics.tracking.android.EasyTracker;
import com.ovionmedia.wizbox.launcher.R;
import com.ovionmedia.wizbox.movies.MovieHome;
import com.ovionmedia.wizbox.tvshows.TVHome;

	public class BottomButtonsFragment extends Fragment {
		EasyTracker easytracker;
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			Log.e("BottomButtonsFragment", "inside onCreate");
			this.easytracker = EasyTracker.getInstance(this.getActivity());
		}


		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View view = inflater.inflate(R.layout.main_bottom_switcher_page, container, false);
			
			final Button wizapps = (Button)view.findViewById(R.id.lib);
			final Button wizmovies = (Button)view.findViewById(R.id.music);
			final Button explore = (Button)view.findViewById(R.id.allapps);
			final Button wiztvshows = (Button)view.findViewById(R.id.movie);
			final Button media = (Button)view.findViewById(R.id.communication);
			final Button livetv = (Button)view.findViewById(R.id.games);
			final Button setting = (Button)view.findViewById(R.id.shopping);
			wizapps.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					easytracker.send(MapBuilder
						      .createEvent("Vinay",     // Event category (required)
						                   "WizBox_app",  // Event action (required)
						                   "WizBox_app",   // Event label
						                   null)            // Event value
						      .build()
						  );


					Intent i = new Intent(Intent.ACTION_MAIN);
					i.addCategory(Intent.CATEGORY_LAUNCHER);
					i.setClassName("com.ovionmedia.wizbox.apps","com.ovionmedia.wizbox.apps.OpenBoxWareActivity");
				    i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
					startActivity(i);
				}
			});
			

			
			
			
			wizmovies.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {

					easytracker.send(MapBuilder
						      .createEvent("Vinay",     // Event category (required)
						                   "WizBox_Movies",  // Event action (required)
						                   "WizBox_Movies",   // Event label
						                   null)            // Event value
						      .build()
						  );

					Intent intent =new Intent(getActivity(),MovieHome.class);
					startActivity(intent);
				}
			});
	
			
			
			wiztvshows.setOnClickListener(new OnClickListener() {
				
			
				@Override
				public void onClick(View v) {
					easytracker.send(MapBuilder
						      .createEvent("Vinay",     // Event category (required)
						                   "WizBox_TVShows",  // Event action (required)
						                   "WizBox_TVShows",   // Event label
						                   null)            // Event value
						      .build()
						  );

					Intent intent =new Intent(getActivity(),TVHome.class);
					startActivity(intent);
		 		
	         	}
			});
			

			
			media.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					easytracker.send(MapBuilder
						      .createEvent("Vinay",     // Event category (required)
						                   "Media_center",  // Event action (required)
						                   "Media_center",   // Event label
						                   null)            // Event value
						      .build()
						  );
					Intent i = new Intent(Intent.ACTION_MAIN);
					i.addCategory(Intent.CATEGORY_LAUNCHER);
					i.setClassName("com.videon.android.mediaplayer","com.videon.android.mediaplayer.Splash");
					i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
					startActivity(i);
				}
			});
			
			

			
			
			livetv.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					easytracker.send(MapBuilder
						      .createEvent("Vinay",     // Event category (required)
						                   "WizBox_LiveTV",  // Event action (required)
						                   "WizBox_LiveTV",   // Event label
						                   null)            // Event value
						      .build()
						  );
					Intent i = new Intent(Intent.ACTION_MAIN);
					i.addCategory(Intent.CATEGORY_LAUNCHER);
					i.setClassName("com.rockchip.mediacenter","com.rockchip.mediacenter.IndexActivity");
					i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
					startActivity(i);
				}
			});
			
	
			setting.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					easytracker.send(MapBuilder
						      .createEvent("Vinay",     // Event category (required)
						                   "WizBox_Setting",  // Event action (required)
						                   "WizBox_Setting",   // Event label
						                   null)            // Event value
						      .build()
						  );
					Intent intent =new Intent(getActivity(),SetupWizardWelcomeActivity.class);
			
					startActivity(intent);
				}
			});
			

			
			explore.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					
					
					 boolean installed  =   appInstalledOrNot("com.android.rockchip");  
			            if(installed)
			            {
			            //This intent will help you to launch if the package is already installed
			            	easytracker.send(MapBuilder
								      .createEvent("Vinay",     // Event category (required)
								                   "WizBox_Explorer",  // Event action (required)
								                   "WizBox_Explorer",   // Event label
								                   null)            // Event value
								      .build()
								  );
			            	Intent i = new Intent(Intent.ACTION_MAIN);
							i.addCategory(Intent.CATEGORY_LAUNCHER);
							i.setClassName("com.android.rockchip","com.android.rockchip.RockExplorer");
							startActivity(i);
			                      System.out.println("App already installed om your phone");


			            }
			            else
			            {
			            	
			            	Intent i = new Intent(Intent.ACTION_MAIN);
							i.addCategory(Intent.CATEGORY_LAUNCHER);
							i.setClassName("com.fb.FileBrower","com.fb.FileBrower.FileBrower");
							startActivity(i);
			                System.out.println("App is not installed om your phone");
			            }
			          //i.setClassName("com.fb.FileBrower","com.fb.FileBrower.FileBrower");
					
				}
			});
			

			
			
			return view;
		}
		  private boolean appInstalledOrNot(String uri)
	        {
	            PackageManager pm = getActivity().getPackageManager();
	            boolean app_installed = false;
	            try
	            {
	                   pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
	                   app_installed = true;
	            }
	            catch (PackageManager.NameNotFoundException e)
	            {
	                   app_installed = false;
	            }
	            return app_installed ;
	    }
	} 