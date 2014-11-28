package com.ovionmedia.wizbox.launcher;

import java.util.ArrayList;
import java.util.Random;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ComponentName;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;
import com.ovionmedia.wizbox.launcher.R;

public class LocalImageFragment extends Fragment {

	// Handler handler = new Handler();
	//
	// protected int counter = 0;
	// private ImageView mImageView;
	// private Bitmap currentBitmap = null;
	// Cursor cur;
	//
	// View view;
	//
	// @Override
	// public void onCreate(Bundle savedInstanceState) {
	// super.onCreate(savedInstanceState);
	// Log.e("PromotionAppsAndVideoFragment", "inside onCreate");
	//
	// }
	//
	// @Override
	// public void onActivityCreated(Bundle savedInstanceState) {
	// super.onActivityCreated(savedInstanceState);
	// }
	//
	// @SuppressWarnings("deprecation")
	// @Override
	// public View onCreateView(LayoutInflater inflater, ViewGroup container,
	// Bundle savedInstanceState) {
	// view = inflater.inflate(R.layout.home_gridview, container, false);
	//
	// mImageView = (ImageView) view.findViewById(R.id.imageView1);
	//
	// String[] projection = new String[] { MediaStore.Images.Media.DATA, };
	//
	// Uri images = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
	//
	// cur = getActivity().managedQuery(images, projection, "", null, "");
	//
	// // Boolean isSDPresent =
	// //
	// android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
	// //
	// // if(isSDPresent)
	// // {
	// // // yes SD-card is present
	// // }
	// // else
	// // {
	// // // Sorry
	// // }
	//
	// int count1 = cur.getCount();
	//
	// if (count1 != 0) {
	//
	// final ArrayList<String> imagesPath = new ArrayList<String>();
	// if (cur.moveToFirst()) {
	//
	// int dataColumn = cur
	// .getColumnIndex(MediaStore.Images.Media.DATA);
	// do {
	// imagesPath.add(cur.getString(dataColumn));
	// } while (cur.moveToNext());
	// }
	//
	// final Random random = new Random();
	// final int count = imagesPath.size();
	// handler.post(new Runnable() {
	// @Override
	// public void run() {
	// int number = random.nextInt(count);
	// String path = imagesPath.get(number);
	// if (currentBitmap != null)
	// currentBitmap.recycle();
	// currentBitmap = BitmapFactory.decodeFile(path);
	// final Animation b1 = AnimationUtils.loadAnimation(
	// getActivity(), R.anim.translate);
	// b1.reset();
	// mImageView.setImageBitmap(currentBitmap);
	// mImageView.startAnimation(b1);
	// handler.postDelayed(this, 4000);
	//
	// }
	// });
	//
	// } else {
	//
	// }
	// return view;
	// }
	// }

	int[] arr = new int[9];
	int i1 = 0;
	Handler handler;
	Runnable r;
	ImageView imageview = null;
	View view;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.e("PromotionAppsAndVideoFragment", "inside onCreate");

		arr[0] = R.drawable.scenery2;
		arr[1] = R.drawable.scenery3;
		arr[2] = R.drawable.scenery4;
		arr[3] = R.drawable.ad1;
		arr[4] = R.drawable.ad2;
		arr[5] = R.drawable.ad3;
		arr[6] = R.drawable.ad4;
		arr[7] = R.drawable.ad5;
		arr[8] = R.drawable.scenery1;

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.home_gridview, container, false);
		imageview = (ImageView) view.findViewById(R.id.imageView1);

		handler = new Handler();
		Log.w("creating handler", ":" + handler);
		r = new Runnable() {

			public void run() {

				if (i1 == 8) {
					i1 = 0;
				}

				try {

					final Animation b1 = AnimationUtils.loadAnimation(
							getActivity(), R.anim.translate);
					b1.reset();

					imageview.setImageResource(arr[i1]);

					imageview.startAnimation(b1);

				} catch (Exception e) {

				}

				handler.postDelayed(this, 6000);
				Log.w("entering to postdelay", "postdelay");
				i1++;
				Log.w("i1 count", ":" + i1);
			}

		};

		handler.postDelayed(r, 6000);

		return view;
	}

}
