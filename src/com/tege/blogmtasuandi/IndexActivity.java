package com.tege.blogmtasuandi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;


public class IndexActivity extends Activity {

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //setContentView(R.layout.main);
    
    
    	WindowManager winMan = (WindowManager) getBaseContext().getSystemService(Context.WINDOW_SERVICE);
        
        if (winMan != null)
        {
            int orientation = winMan.getDefaultDisplay().getOrientation();
            
            if (orientation == 0) {
                // Portrait
                setContentView(R.layout.main);
            }
            else if (orientation == 1) {
                // Landscape
                setContentView(R.layout.main_landscape);
            }            
        }
    
    
}

public void KompasNews(View view){
	
	 Intent i = new Intent(this, MTASuandiActivity.class);
	 i.putExtra("url", "http://nomadentech.net/v2/category/kompas/feed");
	 this.startActivity(i);
	 

}

public void DetikNews(View view){
	
	 Intent i = new Intent(this, MTASuandiActivity.class);
	 i.putExtra("url", "http://nomadentech.net/v2/category/detik/feed");
	 this.startActivity(i);
	 

}

public void VivaNews(View view){
	
	 Intent i = new Intent(this, MTASuandiActivity.class);
	 i.putExtra("url", "http://nomadentech.net/v2/category/vivanews/feed");
	 this.startActivity(i);
	 

}

public void AntaraNews(View view){
	
	 Intent i = new Intent(this, MTASuandiActivity.class);
	 i.putExtra("url", "http://nomadentech.net/v2/category/antaranews/feed");
	 this.startActivity(i);
	 

}

}