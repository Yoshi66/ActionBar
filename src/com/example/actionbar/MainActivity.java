package com.example.actionbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	 Animation anim;
	 WebView webview;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
       
        
        setContentView(R.layout.activity_main);
       anim = AnimationUtils.loadAnimation(getBaseContext(), android.R.anim.slide_out_right);
        
       webview = (WebView) findViewById(R.id.webview);
       webview.setWebViewClient(new ourWebViewClient(){

    	  
		@Override
		public void onPageFinished(WebView view, String url) {
			// TODO Auto-generated method stub
			super.onPageFinished(view, url);
			 if(webview.canGoBack()){
		    	   getActionBar().setDisplayHomeAsUpEnabled(true);
		       }else{
		    	   getActionBar().setDisplayHomeAsUpEnabled(false);
		       }
			
		}
    	   
       });
       webview.loadUrl("http://senseiportal.com");
        
      
        
        /*
		String userAgentString = webview.getSettings().getUserAgentString();
		webview.getSettings().setUserAgentString(
				userAgentString + " from-app v"
						+ packageInfo.versionName + " " + myDeviceModel);
		userAgentString = webview.getSettings().getUserAgentString();
		Log.v("CheckOpenApp", userAgentString);
        */
        
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case R.id.menu_1:
			Toast.makeText(this, "first", Toast.LENGTH_SHORT).show();
			break;
		case R.id.menu_2:
			Toast.makeText(this, "second", Toast.LENGTH_SHORT).show();
			break;
		case R.id.menu_3:
			Toast.makeText(this,"third",Toast.LENGTH_SHORT).show();
			break;
		case android.R.id.home:
			webview.goBack();
		}
		return super.onOptionsItemSelected(item);
	
	}
	
	private static long back_pressed;

	@Override
	public void onBackPressed()
	{
	        if (back_pressed + 2000 > System.currentTimeMillis()) super.onBackPressed();
	        else Toast.makeText(getBaseContext(), "Press once again to exit!", Toast.LENGTH_SHORT).show();
	        back_pressed = System.currentTimeMillis();
	}
    
}
