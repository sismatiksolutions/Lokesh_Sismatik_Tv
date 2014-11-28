package com.ovionmedia.wizbox.launcher;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.ovionmedia.wizbox.launcher.R;

	public class AdvImgLayoutFragment extends Fragment {
//		 int[] arr = new int[14];
//		 int i1=0;
//		 Handler handler;
//		  Runnable r;
//		  ImageView imageview=null;
		  View view ;
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
//			Log.e("PromotionAppsAndVideoFragment", "inside onCreate");
//			arr[0] = R.drawable.img1;
// 	        arr[1] = R.drawable.img1;
// 	        arr[2] = R.drawable.img1;
// 	        arr[3] = R.drawable.img1;
// 	        arr[4] = R.drawable.img1;
// 	        arr[5] = R.drawable.img1;
// 	        arr[6] = R.drawable.img1;
// 	        arr[7] = R.drawable.img1;
// 	        arr[8] = R.drawable.img1;
// 	        arr[9] = R.drawable.img1;
// 	        arr[10] = R.drawable.img1;
// 	        arr[11] = R.drawable.img1;
// 	        arr[12] = R.drawable.img1;
		}

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			
			 view = inflater.inflate(R.layout.home_adv_image, container, false);
		//	 imageview=(ImageView)view.findViewById(R.id.adv_banner_img);

//			   handler =new Handler();
//		        Log.w("creating handler",":"+handler);
//		      r = new Runnable()
//		        {
//		        	 
//		            public void run() 
//		            {
//		            	
//		            	
//			                if(i1== 13){
//			                    i1=0;            
//			                }
//			                
//			              try{
//			                imageview.setImageResource(arr[i1]);
//			              }catch(Exception e){
//			            	 
//			              }
//
//		           
//		               
//		                handler.postDelayed(this, 5000);
//		                Log.w("entering to postdelay","postdelay");
//		                i1++;
//		                Log.w("i1 count",":"+i1);
//		            }
//		           
//		        };
//
//		        handler.postDelayed(r,5000);
//		            
		               
		           
			
			return view;
		}
		
	} 