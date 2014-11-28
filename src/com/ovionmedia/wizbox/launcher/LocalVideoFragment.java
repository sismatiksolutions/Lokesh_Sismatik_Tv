package com.ovionmedia.wizbox.launcher;

//import android.app.Fragment;
//import android.database.Cursor;
//import android.media.MediaPlayer;
//import android.media.MediaPlayer.OnCompletionListener;
//import android.net.Uri;
//import android.os.Bundle;
//import android.provider.MediaStore;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ListView;
//import android.widget.VideoView;
//
//public class LocalVideoFragment extends Fragment {
//
//	Uri video[] = new Uri[3];
//	int i1 = 0;
//	VideoView videoview;
//
//	private Cursor videocursor;
//	private int video_column_index;
//	ListView videolist;
//	int count = 0;
//
//	int count1 = 0;
//
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		Log.e("PromotionAppsAndVideoFragment", "inside onCreate");
//
//	}
//
//	@Override
//	public void onActivityCreated(Bundle savedInstanceState) {
//		super.onActivityCreated(savedInstanceState);
//	}
//
//	@SuppressWarnings("deprecation")
//	@Override
//	public View onCreateView(LayoutInflater inflater, ViewGroup container,
//			Bundle savedInstanceState) {
//
//		View view = inflater.inflate(R.layout.home_video, container, false);
//
//		videoview = (VideoView) view.findViewById(R.id.prom_video);
//
//		String[] proj = { MediaStore.Video.Media._ID,
//				MediaStore.Video.Media.DATA,
//				MediaStore.Video.Media.DISPLAY_NAME,
//				MediaStore.Video.Media.SIZE };
//
//		Uri video = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
//		videocursor = getActivity().managedQuery(video, proj, "", null, "");
//		count = videocursor.getCount();
//		count1 = videocursor.getCount() - 1;
//		if (videocursor != null) {
//			setup();
//		} else {
//
//		}
//
//		return view;
//
//	}
//
//	private void setup() {
//		setup1();
//
//	}
//
//	private void setup1() {
//		// TODO Auto-generated method stub
//		video_column_index = videocursor
//				.getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
//		if (count1 == 0) {
//			videocursor.moveToPosition(0);
//		} else {
//			videocursor.moveToPosition(count - count1);
//		}
//		try {
//			String filename = videocursor.getString(video_column_index);
//			videoview.setVideoPath(filename);
//			videoview.requestFocus();
//			videoview.start();
//
//			videoview.setOnCompletionListener(new OnCompletionListener() {
//
//				@Override
//				public void onCompletion(MediaPlayer mp) {
//					mp.stop();
//					if (count1 == 1) {
//						count1 = videocursor.getCount() - 1;
//					} else if (count1 == 0) {
//						count1 = videocursor.getCount();
//					} else if (count1 >= 2) {
//						count1--;
//					}
//					setup1();
//
//				}
//			});
//
//		} catch (Exception ex) {
//
//			if (count1 == 1) {
//				count1 = videocursor.getCount() - 1;
//			} else if (count1 == 0) {
//				count1 = videocursor.getCount();
//			} else if (count1 >= 2) {
//				count1--;
//			}
//			setup();
//			Log.d("DEBUG_TAG", "Video failed: '" + ex + "'");
//		}
//
//	}
//
//	@Override
//	public void onResume() {
//		if (count1 == 1) {
//			count1 = videocursor.getCount() - 1;
//		} else if (count1 == 0) {
//			count1 = videocursor.getCount();
//		} else if (count1 >= 2) {
//			count1--;
//		}
//
//		if (count != 0) {
//			setup();
//		}
//
//		super.onResume();
//	}
//
//}

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ComponentName;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

	public class LocalVideoFragment extends Fragment {
		Uri video;
		 VideoView videoview;
		
		@Override
		
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			Log.e("PromotionAppsAndVideoFragment", "inside onCreate");
			video = Uri.parse("android.resource://" + "com.ovionmedia.wizbox.launcher" + "/" 
					+ R.raw.wizbox_tour);
		}

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View view = inflater.inflate(R.layout.home_video, container, false);
		    videoview=(VideoView)view.findViewById(R.id.prom_video);
			videoview.setVideoURI(video);
			videoview.start();
			videoview.setOnCompletionListener(new OnCompletionListener() {
				
				@Override
				public void onCompletion(MediaPlayer mp) {
					mp.stop();
					videoview.setVideoURI(video);
					videoview.start();
				}
			});
			return view;
		}
		
		@Override
		public void onResume() {
			videoview.setVideoURI(video);
			videoview.start();
	
			super.onResume();
		}
	} 