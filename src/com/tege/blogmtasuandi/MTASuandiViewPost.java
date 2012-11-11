package com.tege.blogmtasuandi;

import java.io.InputStream;
import java.net.URL;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Window;
import android.widget.TextView;

public class MTASuandiViewPost extends Activity{
	
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.detail_post);
        
        Bundle extras = getIntent().getExtras();
        
        String url="";
        String title="";
        String date="";
        String desc="";

      	 if (extras != null) {
      	     url = extras.getString("url");
      	     title = extras.getString("title");
      	     date = extras.getString("date");
      	     
      	     // and get whatever type user account id is
      	    
      	 }
      	if(desc.contains("img src")){
      		
      		
      	}
      	 
        HttpData data = HttpRequest.get(url);
       
      //  String parsed = data.content.split("<div class=\"entry\">")[1];
       // parsed = parsed.split("<div id=\"jp-post-flair\" class=\"sharedaddy sd-like-enabled sd-sharing-enabled\">")[0];
        
        String parsed = data.content.split("<div class=\"content clearfix\">")[1]; //parsing nomadentech.net/v2
        parsed = parsed.split("<p class=\"trackback\">")[0]; //parsing nomadentech.net/v2
        //System.out.println(parsed);
        
        TextView txtTitle = (TextView)findViewById(R.id.title);
        TextView txtdate = (TextView)findViewById(R.id.date);
        TextView txtkonten = (TextView)findViewById(R.id.content);
        //ImageView imageV = (ImageView)findViewById(R.id.image);
        
        txtTitle.setText(title);
        txtdate.setText(date);
//        txtkonten.setText(Html.fromHtml(parsed, new ImageGetter() {                 
//           // @Override
//            public Drawable getDrawable(String source) {
//             Drawable drawFromPath;
//             int path = this.getResources().getIdentifier(source, "drawable", "com.package..."); 
//             drawFromPath = (Drawable) myActivity.this.getResources().getDrawable(path);
//             drawFromPath.setBounds(0, 0, drawFromPath.getIntrinsicWidth(), drawFromPath.getIntrinsicHeight());
//             return drawFromPath;
//            }
//        }, null));
        
        txtkonten.setText(Html.fromHtml(parsed, new Html.ImageGetter() {

        	 public Drawable getDrawable(String source) {


        	 try{
        	 InputStream is = (InputStream) new URL(source).getContent();
        	 Drawable d = Drawable.createFromStream(is, "src name");
        	 d.setBounds(0,0,d.getIntrinsicWidth(),d.getIntrinsicHeight());
        	 return d;
        	 }catch (Exception e){
        	 return null;
        	 }

        	 }
        }, null));
        	 txtkonten.setMovementMethod(new ScrollingMovementMethod());
        
        
   	 }
	
	
	
//	public static Bitmap loadBitmap(String url) {
//	    Bitmap bitmap = null;
//	    InputStream in = null;
//	    BufferedOutputStream out = null;
//
//	    try {
//	        in = new BufferedInputStream(new URL(url).openStream(), IO_BUFFER_SIZE);
//
//	        final ByteArrayOutputStream dataStream = new ByteArrayOutputStream();
//	        out = new BufferedOutputStream(dataStream, IO_BUFFER_SIZE);
//	        copy(in, out);
//	        out.flush();
//
//	        final byte[] data = dataStream.toByteArray();
//	        BitmapFactory.Options options = new BitmapFactory.Options();
//	        //options.inSampleSize = 1;
//
//	        bitmap = BitmapFactory.decodeByteArray(data, 0, data.length,options);
//	    } catch (IOException e) {
//	        Log.e(TAG, "Could not load Bitmap from: " + url);
//	    } finally {
//	        closeStream(in);
//	        closeStream(out);
//	    }
//
//	    return bitmap;
//	}
	
}