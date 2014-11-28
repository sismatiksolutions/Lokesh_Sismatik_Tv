package com.ovionmedia.wizbox.launcher;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import com.ovionmedia.wizbox.launcher.R;

public class MainActivity extends Activity {
	
	static final String TAG = "DevicePolicyDemoActivity";
	static final int ACTIVATION_REQUEST = 47; // identifies our request id
	DevicePolicyManager devicePolicyManager;
	ComponentName demoDeviceAdmin;

	
/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	
		
		devicePolicyManager = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
		demoDeviceAdmin = new ComponentName(this, DemoDeviceAdminReceiver.class);
		
	
		Intent intent = new Intent(
				DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
		intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN,
				demoDeviceAdmin);
		intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,
				"Your boss told you to do this");
		startActivityForResult(intent, ACTIVATION_REQUEST);
		
		
	}
	
	
//	public void onBackPressed() {
//		// Nothing to do
//	}
//	
//
//	public boolean dispatchKeyEvent(KeyEvent event) {
//		if (event.getAction() == KeyEvent.ACTION_DOWN) {
//			switch (event.getKeyCode()) {
//			case KeyEvent.KEYCODE_BACK:
//				onBackPressed();
//				return true;
//
//			}
//		} else if (event.getAction() == KeyEvent.ACTION_UP) {
//			switch (event.getKeyCode()) {
//
//			case KeyEvent.KEYCODE_BACK:
//				if (!event.isCanceled()) {
//					// Do BACK behavior.
//					onBackPressed();
//				}
//				Log.w("hello", "ggggggg");
//				return true;
//				
////			case KeyEvent.KEYCODE_HOME:
////	            if (!event.isCanceled()) {
////	            	onHomePressed();
////	            }
////	            return true;
//
//			}
//		}
//
//		return super.dispatchKeyEvent(event);
//	}


//	public void onHomePressed() {
//		// TODO Auto-generated method stub
//		
//	}
	
	 @Override
     public void onBackPressed()
         {
        
         }
} 