package com.ovionmedia.wizbox.launcher;



import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class LogoFragment extends Fragment {
	ImageView l;
	int[] arr = new int[2];
	 int i1=0;
	 Handler handler;
	  Runnable r;
	  ImageView imageview=null;
	 
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.e("BottomButtonsFragment", "inside onCreate");
//		 arr[0] = R.drawable.img_logo_medium;
//	        arr[1] = R.drawable.img_logo_medium;
	}

	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.logo, container, false);
		  l = (ImageView)view.findViewById(R.id.imageView1);
		  
		  
//		  handler =new Handler();
//	        Log.w("creating handler",":"+handler);
//	      r = new Runnable()
//	        {
//	        	 
//	            public void run() 
//	            {
//	            	
//	            	
//		                if(i1== 1){
//		                    i1=0;            
//		                }
//		                
//		              try{
//   					
//		            	  final Animation b1 = AnimationUtils.loadAnimation(getActivity(), R.anim.alpha);
//       					b1.reset();
//		            	
//		            	 
//		                l.setImageResource(arr[i1]);
//		               
//   			
//   					
//   					l.startAnimation(b1);
//		                
//
//		              }catch(Exception e){
//		            	 
//		              }
//
//	           
//	               
//	                handler.postDelayed(this, 6000);
//	                Log.w("entering to postdelay","postdelay");
//	                i1++;
//	                Log.w("i1 count",":"+i1);
//	            }
//	           
//	        };
//
//	        handler.postDelayed(r,6000);
//	            
	               
	           
		
		return view;
	}

} 