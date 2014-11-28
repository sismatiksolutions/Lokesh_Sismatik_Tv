package com.ovionmedia.wizbox.launcher;



import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.GoogleAnalytics;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.analytics.tracking.android.MapBuilder;
public class SetupWizardWelcomeActivity extends Activity {
	
	//public static String name ="Anu";
	
	public static final String PREFS_NAME = "NewPrefsFile";

	
	/** Called when the activity is first created. */

	public Button BackBtnSetup, NextBtnSetup, txt3e, txt3b, txt3b1, txt3d,txt3d1,
			txt3f, txt3c,btn_setup_wizard_welcome_close;

	public TextView network_setting, welcome_text, display_setting,
			acyn_setting, lang_setting, date_time_setting;
	public LinearLayout wifiset, resolutionset, positionset, acset,acset1, langset,
			inputset, datetimeset, lanset;
	LinearLayout rel;
	LayoutInflater layoutInflater;
	View itemView;
	SharedPreferences shr;
	Bundle savedInstanceState1;
	public static RelativeLayout relay_setup_wizard;
	EasyTracker easyTracker;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 savedInstanceState1 = savedInstanceState;
		}
	 @Override
	  public void onStart() {
	    super.onStart();
	    
	    EasyTracker.getInstance(this).activityStart(this);  // Add this method.
	    //savedInstanceState1 = savedInstanceState;
		shr = this.getSharedPreferences(SetupWizardWelcomeActivity.PREFS_NAME, 0);
		setContentView(R.layout.settings_setup_wizard_welcome);
		Log.w("SetupWizardWelcomeActivity","SetupWizardWelcomeActivity");
		
		Editor editor = shr.edit();
		editor.putInt("nextbackid", 1);
		editor.commit();

		welcome_text = (TextView) findViewById(R.id.txt_welcome);
		network_setting = (TextView) findViewById(R.id.txt_net_settings);
		display_setting = (TextView) findViewById(R.id.txt_display);
		acyn_setting = (TextView) findViewById(R.id.txt_acnts_sync);
		lang_setting = (TextView) findViewById(R.id.txt_lang_input);
		date_time_setting = (TextView) findViewById(R.id.txt_date_time);
		BackBtnSetup = (Button) findViewById(R.id.btn_setup_wizard_welcome_back);
		NextBtnSetup = (Button) findViewById(R.id.btn_setup_wizard_welcome_next);
		
		
		
		btn_setup_wizard_welcome_close= (Button) findViewById(R.id.btn_setup_wizard_welcome_close);
		btn_setup_wizard_welcome_close.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 easyTracker = EasyTracker.getInstance(SetupWizardWelcomeActivity.this);
				

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				                   "WizBox_Setting",  // Event action (required)
				                   "btn_setup_wizard_welcome_close",   // Event label
				                   null)            // Event value
				      .build()
				  );
				  

				Intent i = new Intent(Intent.ACTION_MAIN);
				i.addCategory(Intent.CATEGORY_LAUNCHER);
				i.setClassName("com.ovionmedia.wizbox.launcher","com.ovionmedia.wizbox.launcher.MainActivity");
				i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
				startActivity(i);
				
	    			
					
			}
		});
		
		
		welcome_text.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EasyTracker easyTracker = EasyTracker.getInstance(SetupWizardWelcomeActivity.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				                   "WizBox_Setting",  // Event action (required)
				                   "welcome_text",   // Event label
				                   null)            // Event value
				      .build()
				  );
				change_textview_color();
				welcome_text.setTextColor(Color.parseColor("#00c6ff"));
				rel = (LinearLayout) findViewById(R.id.right_inflate_layout);
				rel.removeAllViews();
				layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
				itemView = layoutInflater.inflate(
						R.layout.welcome_settings_right_layout, null);
				rel.addView(itemView, new LinearLayout.LayoutParams(
						LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
				Editor editor = shr.edit();// vkj
				editor.putInt("nextbackid", 1);// vkj
				editor.commit();
				
			}
		});	


		network_setting.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EasyTracker easyTracker = EasyTracker.getInstance(SetupWizardWelcomeActivity.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				                   "WizBox_Setting",  // Event action (required)
				                   "network_setting",   // Event label
				                   null)            // Event value
				      .build()
				  );
				change_textview_color();
				network_setting.setTextColor(Color.parseColor("#00c6ff"));
				rel = (LinearLayout) findViewById(R.id.right_inflate_layout);
				rel.removeAllViews();
				layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
				itemView = layoutInflater.inflate(
						R.layout.network_settings_right_layout, null);
				rel.addView(itemView, new LinearLayout.LayoutParams(
						LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
				Editor editor = shr.edit();// vkj
				editor.putInt("nextbackid", 3);// vkj
				editor.commit();
				wifiset = (LinearLayout) rel.findViewById(R.id.pr3);
				wifiset.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						// TODO Auto-generated method stub
						EasyTracker easyTracker = EasyTracker.getInstance(SetupWizardWelcomeActivity.this);

						  // MapBuilder.createEvent().build() returns a Map of event fields and values
						  // that are set and sent with the hit.
						  easyTracker.send(MapBuilder
						      .createEvent("Vinay",     // Event category (required)
						                   "WizBox_Setting",  // Event action (required)
						                   "wifisetting",   // Event label
						                   null)            // Event value
						      .build()
						  );
						startActivity(new Intent(
								android.provider.Settings.ACTION_WIFI_SETTINGS));
					}
				});
				txt3b = (Button) rel.findViewById(R.id.txt3b);
				txt3b.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						// TODO Auto-generated method stub
						EasyTracker easyTracker = EasyTracker.getInstance(SetupWizardWelcomeActivity.this);

						  // MapBuilder.createEvent().build() returns a Map of event fields and values
						  // that are set and sent with the hit.
						  easyTracker.send(MapBuilder
						      .createEvent("Vinay",     // Event category (required)
						                   "WizBox_Setting",  // Event action (required)
						                   "txt3b",   // Event label
						                   null)            // Event value
						      .build()
						  );
						startActivity(new Intent(
								android.provider.Settings.ACTION_WIFI_SETTINGS));
					}
				});

				lanset = (LinearLayout) rel.findViewById(R.id.pr31);
				lanset.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						// TODO Auto-generated method stub
						EasyTracker easyTracker = EasyTracker.getInstance(SetupWizardWelcomeActivity.this);

						  // MapBuilder.createEvent().build() returns a Map of event fields and values
						  // that are set and sent with the hit.
						  easyTracker.send(MapBuilder
						      .createEvent("Vinay",     // Event category (required)
						                   "WizBox_Setting",  // Event action (required)
						                   "lanset",   // Event label
						                   null)            // Event value
						      .build()
						  );
						startActivity(new Intent(
								android.provider.Settings.ACTION_WIRELESS_SETTINGS));

					}
				});

				txt3b1 = (Button) rel.findViewById(R.id.txt3b1);
				txt3b1.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						// TODO Auto-generated method stub
						startActivity(new Intent(
								android.provider.Settings.ACTION_WIRELESS_SETTINGS));

					}
				});
			}
		});	

		display_setting.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EasyTracker easyTracker = EasyTracker.getInstance(SetupWizardWelcomeActivity.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				                   "WizBox_Setting",  // Event action (required)
				                   "Display setting",   // Event label
				                   null)            // Event value
				      .build()
				  );
				change_textview_color();
				display_setting.setTextColor(Color.parseColor("#00c6ff"));
				rel = (LinearLayout) findViewById(R.id.right_inflate_layout);
				rel.removeAllViews();
				layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
				itemView = layoutInflater.inflate(
						R.layout.display_settings_right_layout, null);
				rel.addView(itemView, new LinearLayout.LayoutParams(
						LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
				Editor editor = shr.edit();// vkj
				editor.putInt("nextbackid", 6);// vkj
				editor.commit();
				positionset = (LinearLayout) rel.findViewById(R.id.pr2);
				positionset.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						// TODO Auto-generated method stub
						startActivity(new Intent(
								android.provider.Settings.ACTION_DISPLAY_SETTINGS));
					}
				});

				txt3c = (Button) rel.findViewById(R.id.txt3c);
				txt3c.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						// TODO Auto-generated method stub
						startActivity(new Intent(
								android.provider.Settings.ACTION_DISPLAY_SETTINGS));
					}
				});

			}
		});	

		acyn_setting.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EasyTracker easyTracker = EasyTracker.getInstance(SetupWizardWelcomeActivity.this);

				  // MapBuilder.createEvent().build() returns a Map of event fields and values
				  // that are set and sent with the hit.
				  easyTracker.send(MapBuilder
				      .createEvent("Vinay",     // Event category (required)
				                   "WizBox_Setting",  // Event action (required)
				                   "Acyn Setting",   // Event label
				                   null)            // Event value
				      .build()
				  );
				change_textview_color();
				acyn_setting.setTextColor(Color.parseColor("#00c6ff"));
				rel = (LinearLayout) findViewById(R.id.right_inflate_layout);
				rel.removeAllViews();
				layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
				itemView = layoutInflater.inflate(
						R.layout.accounts_settings_right_layout, null);
				rel.addView(itemView, new LinearLayout.LayoutParams(
						LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
				Editor editor = shr.edit();// vkj
				editor.putInt("nextbackid", 4);// vkj
				editor.commit();
				acset = (LinearLayout) rel.findViewById(R.id.pr4);
				acset.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						// TODO Auto-generated method stub
						startActivity(new Intent(
								android.provider.Settings.ACTION_ADD_ACCOUNT));
					}
				});

				txt3d = (Button) rel.findViewById(R.id.txt3d);
				txt3d.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						// TODO Auto-generated method stub
						startActivity(new Intent(
								android.provider.Settings.ACTION_ADD_ACCOUNT));
					}
				});
				acset = (LinearLayout) rel.findViewById(R.id.pr41);
				acset.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						// TODO Auto-generated method stub
						startActivity(new Intent(SetupWizardWelcomeActivity.this,Login.class));
												
					}
				});

				txt3d = (Button) rel.findViewById(R.id.txt3d1);
				txt3d.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						// TODO Auto-generated method stub
						startActivity(new Intent(SetupWizardWelcomeActivity.this,Login.class));
					}
					
				});
			}
		});	

		lang_setting.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				change_textview_color();
				lang_setting.setTextColor(Color.parseColor("#00c6ff"));
				rel = (LinearLayout) findViewById(R.id.right_inflate_layout);
				rel.removeAllViews();
				layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
				itemView = layoutInflater.inflate(
						R.layout.lang_settings_right_layout, null);
				rel.addView(itemView, new LinearLayout.LayoutParams(
						LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
				Editor editor = shr.edit();// vkj
				editor.putInt("nextbackid", 2);// vkj
				editor.commit();

				langset = (LinearLayout) rel.findViewById(R.id.pr5);
				langset.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						EasyTracker easyTracker = EasyTracker.getInstance(SetupWizardWelcomeActivity.this);

						  // MapBuilder.createEvent().build() returns a Map of event fields and values
						  // that are set and sent with the hit.
						  easyTracker.send(MapBuilder
						      .createEvent("Vinay",     // Event category (required)
						                   "WizBox_Setting",  // Event action (required)
						                   "Language Setting",   // Event label
						                   null)            // Event value
						      .build()
						  );
						Intent intent = new Intent(Intent.ACTION_MAIN);
						intent.setClassName("com.android.settings",
								"com.android.settings.LanguageSettings");
						startActivity(intent);
					}
				});

				txt3e = (Button) rel.findViewById(R.id.txt3e);
				txt3e.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						Intent intent = new Intent(Intent.ACTION_MAIN);
						intent.setClassName("com.android.settings",
								"com.android.settings.LanguageSettings");
						startActivity(intent);
					}
				});
			}
		});	
		
		date_time_setting.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				change_textview_color();
				date_time_setting.setTextColor(Color.parseColor("#00c6ff"));
				rel = (LinearLayout) findViewById(R.id.right_inflate_layout);
				rel.removeAllViews();
				layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
				itemView = layoutInflater.inflate(
						R.layout.datetime_settings_right_layout, null);
				rel.addView(itemView, new LinearLayout.LayoutParams(
						LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
				Editor editor = shr.edit();// vkj
				editor.putInt("nextbackid", 5);// vkj
				editor.commit();
				datetimeset = (LinearLayout) rel.findViewById(R.id.pr7);
				datetimeset.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						// TODO Auto-generated method stub
						EasyTracker easyTracker = EasyTracker.getInstance(SetupWizardWelcomeActivity.this);

						  // MapBuilder.createEvent().build() returns a Map of event fields and values
						  // that are set and sent with the hit.
						  easyTracker.send(MapBuilder
						      .createEvent("Vinay",     // Event category (required)
						                   "WizBox_Setting",  // Event action (required)
						                   "Datetime Setting",   // Event label
						                   null)            // Event value
						      .build()
						  );
						startActivity(new Intent(
								android.provider.Settings.ACTION_DATE_SETTINGS));
					}
				});

				txt3f = (Button) rel.findViewById(R.id.txt3f);
				txt3f.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						// TODO Auto-generated method stub
						startActivity(new Intent(
								android.provider.Settings.ACTION_DATE_SETTINGS));

					}
				});
			}
		});	

		BackBtnSetup.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				if (shr.getInt("nextbackid", 0) == 1) {
					Intent i = new Intent(Intent.ACTION_MAIN);
					i.addCategory(Intent.CATEGORY_LAUNCHER);
					i.setClassName("com.ovionmedia.wizbox.launcher","com.ovionmedia.wizbox.launcher.MainActivity");
					i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
					startActivity(i);
					
				}

				else if (shr.getInt("nextbackid", 0) == 2) {
					change_textview_color();
					welcome_text.setTextColor(Color.parseColor("#00c6ff"));
					rel = (LinearLayout) findViewById(R.id.right_inflate_layout);
					rel.removeAllViews();
					layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
					itemView = layoutInflater.inflate(
							R.layout.welcome_settings_right_layout, null);
					rel.addView(itemView, new LinearLayout.LayoutParams(
							LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
					Editor editor = shr.edit();// vkj
					editor.putInt("nextbackid", 1);// vkj
					editor.commit();
				} else if (shr.getInt("nextbackid", 0) == 3) {

					change_textview_color();
					lang_setting.setTextColor(Color.parseColor("#00c6ff"));
					rel = (LinearLayout) findViewById(R.id.right_inflate_layout);
					rel.removeAllViews();
					layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
					itemView = layoutInflater.inflate(
							R.layout.lang_settings_right_layout, null);
					rel.addView(itemView, new LinearLayout.LayoutParams(
							LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
					Editor editor = shr.edit();// vkj
					editor.putInt("nextbackid", 2);// vkj
					editor.commit();

					langset = (LinearLayout) rel.findViewById(R.id.pr5);
					langset.setOnClickListener(new OnClickListener() {

						public void onClick(View v) {
							Intent intent = new Intent(Intent.ACTION_MAIN);
							intent.setClassName("com.android.settings",
									"com.android.settings.LanguageSettings");
							startActivity(intent);
						}
					});

					txt3e = (Button) rel.findViewById(R.id.txt3e);
					txt3e.setOnClickListener(new OnClickListener() {

						public void onClick(View v) {
							Intent intent = new Intent(Intent.ACTION_MAIN);
							intent.setClassName("com.android.settings",
									"com.android.settings.LanguageSettings");
							startActivity(intent);
						}
					});

				} else if (shr.getInt("nextbackid", 0) == 4) {
					change_textview_color();
					network_setting.setTextColor(Color.parseColor("#00c6ff"));
					rel = (LinearLayout) findViewById(R.id.right_inflate_layout);
					rel.removeAllViews();
					layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
					itemView = layoutInflater.inflate(
							R.layout.network_settings_right_layout, null);
					rel.addView(itemView, new LinearLayout.LayoutParams(
							LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
					Editor editor = shr.edit();// vkj
					editor.putInt("nextbackid", 3);// vkj
					editor.commit();
					wifiset = (LinearLayout) rel.findViewById(R.id.pr3);
					wifiset.setOnClickListener(new OnClickListener() {

						public void onClick(View v) {
							startActivity(new Intent(
									android.provider.Settings.ACTION_WIFI_SETTINGS));
						}
					});

					txt3b = (Button) rel.findViewById(R.id.txt3b);
					txt3b.setOnClickListener(new OnClickListener() {

						public void onClick(View v) {
							// TODO Auto-generated method stub
							startActivity(new Intent(
									android.provider.Settings.ACTION_WIFI_SETTINGS));
						}
					});

					lanset = (LinearLayout) rel.findViewById(R.id.pr31);
					lanset.setOnClickListener(new OnClickListener() {

						public void onClick(View v) {
							// TODO Auto-generated method stub
							startActivity(new Intent(
									android.provider.Settings.ACTION_WIRELESS_SETTINGS));

						}
					});

					txt3b1 = (Button) rel.findViewById(R.id.txt3b1);
					txt3b1.setOnClickListener(new OnClickListener() {

						public void onClick(View v) {
							// TODO Auto-generated method stub
							startActivity(new Intent(
									android.provider.Settings.ACTION_WIRELESS_SETTINGS));

						}
					});

				} else if (shr.getInt("nextbackid", 0) == 5) {

					change_textview_color();
					acyn_setting.setTextColor(Color.parseColor("#00c6ff"));
					rel = (LinearLayout) findViewById(R.id.right_inflate_layout);
					rel.removeAllViews();
					layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
					itemView = layoutInflater.inflate(
							R.layout.accounts_settings_right_layout, null);
					rel.addView(itemView, new LinearLayout.LayoutParams(
							LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
					Editor editor = shr.edit();// vkj
					editor.putInt("nextbackid", 4);// vkj
					editor.commit();
					acset = (LinearLayout) rel.findViewById(R.id.pr4);
					acset.setOnClickListener(new OnClickListener() {

						public void onClick(View v) {
							// TODO Auto-generated method stub
							startActivity(new Intent(
									android.provider.Settings.ACTION_ADD_ACCOUNT));
						}
					});

					txt3d = (Button) rel.findViewById(R.id.txt3d);
					txt3d.setOnClickListener(new OnClickListener() {

						public void onClick(View v) {
							// TODO Auto-generated method stub
							startActivity(new Intent(
									android.provider.Settings.ACTION_ADD_ACCOUNT));
						}
					});
					acset = (LinearLayout) rel.findViewById(R.id.pr41);
					acset.setOnClickListener(new OnClickListener() {

						public void onClick(View v) {
							// TODO Auto-generated method stub
							startActivity(new Intent(SetupWizardWelcomeActivity.this,Login.class));
													
						}
					});

					txt3d = (Button) rel.findViewById(R.id.txt3d1);
					txt3d.setOnClickListener(new OnClickListener() {

						public void onClick(View v) {
							// TODO Auto-generated method stub
							startActivity(new Intent(SetupWizardWelcomeActivity.this,Login.class));
						}
						
					});

				} else if (shr.getInt("nextbackid", 0) == 6) {
					change_textview_color();
					date_time_setting.setTextColor(Color.parseColor("#00c6ff"));

					rel = (LinearLayout) findViewById(R.id.right_inflate_layout);
					rel.removeAllViews();
					layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
					itemView = layoutInflater.inflate(
							R.layout.datetime_settings_right_layout, null);
					rel.addView(itemView, new LinearLayout.LayoutParams(
							LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
					Editor editor = shr.edit();// vkj
					editor.putInt("nextbackid", 5);// vkj
					editor.commit();
					datetimeset = (LinearLayout) rel.findViewById(R.id.pr7);
					datetimeset.setOnClickListener(new OnClickListener() {

						public void onClick(View v) {
							// TODO Auto-generated method stub
							startActivity(new Intent(
									android.provider.Settings.ACTION_DATE_SETTINGS));

						}
					});

					txt3f = (Button) rel.findViewById(R.id.txt3f);
					txt3f.setOnClickListener(new OnClickListener() {

						public void onClick(View v) {
							// TODO Auto-generated method stub
							startActivity(new Intent(
									android.provider.Settings.ACTION_DATE_SETTINGS));

						}
					});

				}

			}
		});

		NextBtnSetup.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				if (shr.getInt("nextbackid", 0) == 1) {

					change_textview_color();
					lang_setting.setTextColor(Color.parseColor("#00c6ff"));
					rel = (LinearLayout) findViewById(R.id.right_inflate_layout);
					rel.removeAllViews();
					// layoutInflater =
					// (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
					layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
					itemView = layoutInflater.inflate(
							R.layout.lang_settings_right_layout, null);
					rel.addView(itemView, new LinearLayout.LayoutParams(
							LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
					Editor editor = shr.edit();// vkj
					editor.putInt("nextbackid", 2);// vkj
					editor.commit();
					langset = (LinearLayout) rel.findViewById(R.id.pr5);
					langset.setOnClickListener(new OnClickListener() {

						public void onClick(View v) {
							// TODO Auto-generated method stub
							Intent intent = new Intent(Intent.ACTION_MAIN);
							intent.setClassName("com.android.settings",
									"com.android.settings.LanguageSettings");
							startActivity(intent);
						}

					});
					txt3e = (Button) rel.findViewById(R.id.txt3e);
					txt3e.setOnClickListener(new OnClickListener() {

						public void onClick(View v) {
							// TODO Auto-generated method stub
							Intent intent = new Intent(Intent.ACTION_MAIN);
							intent.setClassName("com.android.settings",
									"com.android.settings.LanguageSettings");
							startActivity(intent);
						}
					});

				} else if (shr.getInt("nextbackid", 0) == 2) {
					change_textview_color();
					network_setting.setTextColor(Color.parseColor("#00c6ff"));
					rel = (LinearLayout) findViewById(R.id.right_inflate_layout);
					rel.removeAllViews();
					layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
					itemView = layoutInflater.inflate(
							R.layout.network_settings_right_layout, null);
					rel.addView(itemView, new LinearLayout.LayoutParams(
							LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
					Editor editor = shr.edit();// vkj
					editor.putInt("nextbackid", 3);// vkj
					editor.commit();
					wifiset = (LinearLayout) rel.findViewById(R.id.pr3);
					wifiset.setOnClickListener(new OnClickListener() {

						public void onClick(View v) {
							// TODO Auto-generated method stub
							startActivity(new Intent(
									android.provider.Settings.ACTION_WIFI_SETTINGS));
						}
					});
					txt3b = (Button) rel.findViewById(R.id.txt3b);
					txt3b.setOnClickListener(new OnClickListener() {

						public void onClick(View v) {
							// TODO Auto-generated method stub
							startActivity(new Intent(
									android.provider.Settings.ACTION_WIFI_SETTINGS));
						}
					});

					lanset = (LinearLayout) rel.findViewById(R.id.pr31);
					lanset.setOnClickListener(new OnClickListener() {

						public void onClick(View v) {
							// TODO Auto-generated method stub
							startActivity(new Intent(
									android.provider.Settings.ACTION_WIRELESS_SETTINGS));

						}
					});

					txt3b1 = (Button) rel.findViewById(R.id.txt3b1);
					txt3b1.setOnClickListener(new OnClickListener() {

						public void onClick(View v) {
							// TODO Auto-generated method stub
							startActivity(new Intent(
									android.provider.Settings.ACTION_WIRELESS_SETTINGS));

						}
					});

				} else if (shr.getInt("nextbackid", 0) == 3) {

					change_textview_color();
					acyn_setting.setTextColor(Color.parseColor("#00c6ff"));
					rel = (LinearLayout) findViewById(R.id.right_inflate_layout);
					rel.removeAllViews();
					layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
					itemView = layoutInflater.inflate(
							R.layout.accounts_settings_right_layout, null);
					rel.addView(itemView, new LinearLayout.LayoutParams(
							LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
					Editor editor = shr.edit();// vkj
					editor.putInt("nextbackid", 4);// vkj
					editor.commit();
					acset = (LinearLayout) rel.findViewById(R.id.pr4);
					acset.setOnClickListener(new OnClickListener() {

						public void onClick(View v) {
							// TODO Auto-generated method stub
							startActivity(new Intent(
									android.provider.Settings.ACTION_ADD_ACCOUNT));
						}
					});

					txt3d = (Button) rel.findViewById(R.id.txt3d);
					txt3d.setOnClickListener(new OnClickListener() {

						public void onClick(View v) {
							// TODO Auto-generated method stub
							startActivity(new Intent(
									android.provider.Settings.ACTION_ADD_ACCOUNT));
						}
					});
					acset = (LinearLayout) rel.findViewById(R.id.pr41);
					acset.setOnClickListener(new OnClickListener() {

						public void onClick(View v) {
							// TODO Auto-generated method stub
							startActivity(new Intent(SetupWizardWelcomeActivity.this,Login.class));
													
						}
					});

					txt3d = (Button) rel.findViewById(R.id.txt3d1);
					txt3d.setOnClickListener(new OnClickListener() {

						public void onClick(View v) {
							// TODO Auto-generated method stub
							startActivity(new Intent(SetupWizardWelcomeActivity.this,Login.class));
						}
						
					});
				}

				else if (shr.getInt("nextbackid", 0) == 4) {
					change_textview_color();
					date_time_setting.setTextColor(Color.parseColor("#00c6ff"));
					rel = (LinearLayout) findViewById(R.id.right_inflate_layout);
					rel.removeAllViews();
					layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
					itemView = layoutInflater.inflate(
							R.layout.datetime_settings_right_layout, null);
					rel.addView(itemView, new LinearLayout.LayoutParams(
							LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
					Editor editor = shr.edit();// vkj
					editor.putInt("nextbackid", 5);// vkj
					editor.commit();
					datetimeset = (LinearLayout) rel.findViewById(R.id.pr7);
					datetimeset.setOnClickListener(new OnClickListener() {

						public void onClick(View v) {
							// TODO Auto-generated method stub
							startActivity(new Intent(
									android.provider.Settings.ACTION_DATE_SETTINGS));
						}
					});

					txt3f = (Button) rel.findViewById(R.id.txt3f);
					txt3f.setOnClickListener(new OnClickListener() {

						public void onClick(View v) {
							// TODO Auto-generated method stub
							startActivity(new Intent(
									android.provider.Settings.ACTION_DATE_SETTINGS));

						}
					});

				}

				else if (shr.getInt("nextbackid", 0) == 5) {

					change_textview_color();
					display_setting.setTextColor(Color.parseColor("#00c6ff"));
					rel = (LinearLayout) findViewById(R.id.right_inflate_layout);
					rel.removeAllViews();
					layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
					itemView = layoutInflater.inflate(
							R.layout.display_settings_right_layout, null);
					rel.addView(itemView, new LinearLayout.LayoutParams(
							LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
					Editor editor = shr.edit();// vkj
					editor.putInt("nextbackid", 6);// vkj
					editor.commit();
					positionset = (LinearLayout) rel.findViewById(R.id.pr2);
					positionset.setOnClickListener(new OnClickListener() {

						public void onClick(View v) {
							// TODO Auto-generated method stub
							startActivity(new Intent(
									android.provider.Settings.ACTION_DISPLAY_SETTINGS));
						}
					});

					txt3c = (Button) rel.findViewById(R.id.txt3c);
					txt3c.setOnClickListener(new OnClickListener() {

						public void onClick(View v) {
							// TODO Auto-generated method stub
							startActivity(new Intent(
									android.provider.Settings.ACTION_DISPLAY_SETTINGS));
						}
					});

				} else if (shr.getInt("nextbackid", 0) == 6) {
					Editor editor = shr.edit();
					editor.putInt("nextbackid", 1);
					editor.commit();
					Intent i = new Intent(Intent.ACTION_MAIN);
					i.addCategory(Intent.CATEGORY_LAUNCHER);
					i.setClassName("com.ovionmedia.wizbox.launcher","com.ovionmedia.wizbox.launcher.MainActivity");
					i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
					startActivity(i);
					
				}

			}

		});

	
	  }


	public void change_textview_color() {
		welcome_text = (TextView) findViewById(R.id.txt_welcome);
		welcome_text.setTextColor(Color.parseColor("#FFFFFF"));
		network_setting = (TextView) findViewById(R.id.txt_net_settings);
		network_setting.setTextColor(Color.parseColor("#FFFFFF"));
		display_setting = (TextView) findViewById(R.id.txt_display);
		display_setting.setTextColor(Color.parseColor("#FFFFFF"));
		acyn_setting = (TextView) findViewById(R.id.txt_acnts_sync);
		acyn_setting.setTextColor(Color.parseColor("#FFFFFF"));
		lang_setting = (TextView) findViewById(R.id.txt_lang_input);
		lang_setting.setTextColor(Color.parseColor("#FFFFFF"));
		date_time_setting = (TextView) findViewById(R.id.txt_date_time);
		date_time_setting.setTextColor(Color.parseColor("#FFFFFF"));

	}

	public void onContentChanged() {
//		if (shr.getInt("nextbackid", 0) == 0) {
//			View v = new View(getApplicationContext());
//			Intent i = new Intent(Intent.ACTION_MAIN);
//			i.addCategory(Intent.CATEGORY_LAUNCHER);
//			i.setClassName("com.ovionmedia.wizbox.launcher","com.ovionmedia.wizbox.launcher.MainActivity");
//			i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//			startActivity(i);
//			Toast.makeText(getApplicationContext(), "Checked Once", Toast.LENGTH_LONG).show();
//			Editor editor = shr.edit();
//			editor.putInt("nextbackid", 1);
//			editor.commit();
//		}
		if (shr.getInt("nextbackid", 0) == 1) {
			welcome_text = (TextView) findViewById(R.id.txt_welcome);
			welcome_text.setTextColor(Color.parseColor("#00c6ff"));
//			Editor editor = shr.edit();
//			editor.putInt("nextbackid", 1);
//			editor.commit();

		}

		if (shr.getInt("nextbackid", 0) == 2) {

			change_textview_color();
			lang_setting.setTextColor(Color.parseColor("#00c6ff"));
			rel = (LinearLayout) findViewById(R.id.right_inflate_layout);
			rel.removeAllViews();
			layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
			itemView = layoutInflater.inflate(
					R.layout.lang_settings_right_layout, null);
			rel.addView(itemView, new LinearLayout.LayoutParams(
					LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
			Editor editor = shr.edit();// vkj
			editor.putInt("nextbackid", 2);// vkj
			editor.commit();
			langset = (LinearLayout) rel.findViewById(R.id.pr5);
			langset.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(Intent.ACTION_MAIN);
					intent.setClassName("com.android.settings",
							"com.android.settings.LanguageSettings");
					startActivity(intent);
				}

			});
			txt3e = (Button) rel.findViewById(R.id.txt3e);
			txt3e.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(Intent.ACTION_MAIN);
					intent.setClassName("com.android.settings",
							"com.android.settings.LanguageSettings");
					startActivity(intent);
				}
			});

		}

		if (shr.getInt("nextbackid", 0) == 3) {
			change_textview_color();
			network_setting.setTextColor(Color.parseColor("#00c6ff"));
			rel = (LinearLayout) findViewById(R.id.right_inflate_layout);
			rel.removeAllViews();
			layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
			itemView = layoutInflater.inflate(
					R.layout.network_settings_right_layout, null);
			rel.addView(itemView, new LinearLayout.LayoutParams(
					LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
			Editor editor = shr.edit();// vkj
			editor.putInt("nextbackid", 3);// vkj
			editor.commit();
			wifiset = (LinearLayout) rel.findViewById(R.id.pr3);
			wifiset.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					// TODO Auto-generated method stub
					startActivity(new Intent(
							android.provider.Settings.ACTION_WIFI_SETTINGS));
				}
			});
			txt3b = (Button) rel.findViewById(R.id.txt3b);
			txt3b.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					// TODO Auto-generated method stub
					startActivity(new Intent(
							android.provider.Settings.ACTION_WIFI_SETTINGS));
				}
			});

			lanset = (LinearLayout) rel.findViewById(R.id.pr31);
			lanset.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					// TODO Auto-generated method stub
					startActivity(new Intent(
							android.provider.Settings.ACTION_WIRELESS_SETTINGS));

				}
			});

			txt3b1 = (Button) rel.findViewById(R.id.txt3b1);
			txt3b1.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					// TODO Auto-generated method stub
					startActivity(new Intent(
							android.provider.Settings.ACTION_WIRELESS_SETTINGS));

				}
			});
		}

		if (shr.getInt("nextbackid", 0) == 4) {

			change_textview_color();
			acyn_setting.setTextColor(Color.parseColor("#00c6ff"));
			rel = (LinearLayout) findViewById(R.id.right_inflate_layout);
			rel.removeAllViews();
			layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
			itemView = layoutInflater.inflate(
					R.layout.accounts_settings_right_layout, null);
			rel.addView(itemView, new LinearLayout.LayoutParams(
					LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
			Editor editor = shr.edit();// vkj
			editor.putInt("nextbackid", 4);// vkj
			editor.commit();
			acset = (LinearLayout) rel.findViewById(R.id.pr4);
			acset.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					// TODO Auto-generated method stub
					startActivity(new Intent(
							android.provider.Settings.ACTION_ADD_ACCOUNT));
				}
			});
			txt3d = (Button) rel.findViewById(R.id.txt3d);
			txt3d.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					// TODO Auto-generated method stub
					startActivity(new Intent(
							android.provider.Settings.ACTION_ADD_ACCOUNT));
				}
			});
			acset = (LinearLayout) rel.findViewById(R.id.pr41);
			acset.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					// TODO Auto-generated method stub
					startActivity(new Intent(SetupWizardWelcomeActivity.this,Login.class));
											
				}
			});

			txt3d = (Button) rel.findViewById(R.id.txt3d1);
			txt3d.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					// TODO Auto-generated method stub
					startActivity(new Intent(SetupWizardWelcomeActivity.this,Login.class));
				}
				
			});
		}
		if (shr.getInt("nextbackid", 0) == 5) {
			change_textview_color();
			date_time_setting.setTextColor(Color.parseColor("#00c6ff"));
			rel = (LinearLayout) findViewById(R.id.right_inflate_layout);
			rel.removeAllViews();
			layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
			itemView = layoutInflater.inflate(
					R.layout.datetime_settings_right_layout, null);
			rel.addView(itemView, new LinearLayout.LayoutParams(
					LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
			Editor editor = shr.edit();// vkj
			editor.putInt("nextbackid", 5);// vkj
			editor.commit();

			datetimeset = (LinearLayout) rel.findViewById(R.id.pr7);
			datetimeset.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					// TODO Auto-generated method stub
					startActivity(new Intent(
							android.provider.Settings.ACTION_DATE_SETTINGS));
				}
			});

			txt3f = (Button) rel.findViewById(R.id.txt3f);
			txt3f.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					// TODO Auto-generated method stub
					startActivity(new Intent(
							android.provider.Settings.ACTION_DATE_SETTINGS));

				}
			});
		}
		if (shr.getInt("nextbackid", 0) == 6) {

			change_textview_color();
			display_setting.setTextColor(Color.parseColor("#00c6ff"));
			rel = (LinearLayout) findViewById(R.id.right_inflate_layout);
			rel.removeAllViews();
			layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
			itemView = layoutInflater.inflate(
					R.layout.display_settings_right_layout, null);
			rel.addView(itemView, new LinearLayout.LayoutParams(
					LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
			Editor editor = shr.edit();// vkj
			editor.putInt("nextbackid", 6);// vkj
			editor.commit();
			positionset = (LinearLayout) rel.findViewById(R.id.pr2);
			positionset.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					// TODO Auto-generated method stub
					startActivity(new Intent(
							android.provider.Settings.ACTION_DISPLAY_SETTINGS));
				}
			});

			txt3c = (Button) rel.findViewById(R.id.txt3c);
			txt3c.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					// TODO Auto-generated method stub
					startActivity(new Intent(
							android.provider.Settings.ACTION_DISPLAY_SETTINGS));
				}
			});

		}

	}

	@Override
	  public void onStop() {
	    super.onStop();
	    EasyTracker.getInstance(this).activityStop(this);  // Add this method.
	  }


}