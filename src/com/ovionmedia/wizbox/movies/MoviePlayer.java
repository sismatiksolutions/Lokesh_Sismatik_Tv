package com.ovionmedia.wizbox.movies;

import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.PlayerStyle;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerFragment;

import com.ovionmedia.wizbox.launcher.R;

public class MoviePlayer extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    // browser key
static private final String DEVELOPER_KEY = "AIzaSyAoHG1bz2y1pqPEJDQ2Z4pz-5D2SKwBLCA";
static private   String VIDEO = "Z9OMUapNaWE"; 
//private String movieId[]={"Z9OMUapNaWE", "fXwu1ldph6Q", "yeF_b8EQcK0", "LfiCIISeIws", "4jUlXaPHQ1Y", "GbS2YuclXr4"};
	 
YouTubePlayer youTubePlayer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.movieplayer);
		
		VIDEO=getIntent().getExtras().getString("MOVIE_ID");
		  
		 YouTubePlayerFragment youTubePlayerFragment =
			        (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.youtube_fragment);
		 youTubePlayerFragment.initialize(DEVELOPER_KEY, this);
		 
	}

	@Override
	protected void onPause() {
		
		if(youTubePlayer!=null){
			youTubePlayer.pause();
		}
		super.onPause();
	}
	
	 @Override
	protected void onResume() {
		 
		super.onResume();
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}

	@Override
	public void onInitializationFailure(Provider provider, YouTubeInitializationResult error) {
		Toast.makeText(this, "Oh no! "+error.toString(), Toast.LENGTH_LONG).show();
	}

	@Override
	public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
		//player.setPlayerStyle(PlayerStyle.MINIMAL);
		youTubePlayer=player;
		youTubePlayer.setFullscreen(true);
		youTubePlayer.setShowFullscreenButton(false);
		youTubePlayer.loadVideo(VIDEO);
	}

}
