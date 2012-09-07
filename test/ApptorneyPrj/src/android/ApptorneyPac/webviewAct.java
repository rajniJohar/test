package android.ApptorneyPac;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class webviewAct extends Activity {
	ProgressBar progress;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	    setContentView(R.layout.web);
	    progress=(ProgressBar)findViewById(R.id.progressBar1);
	    Intent intent1=this.getIntent();
	    String str1=intent1.getStringExtra("str");
	    WebView webview=(WebView)findViewById(R.id.webview);
	    webview.getSettings().setJavaScriptEnabled(true);
	    webview.loadUrl(str1);
	    webview.setWebViewClient(new HelloWebViewClient());
	    // TODO Auto-generated method stub
	}
	public class HelloWebViewClient extends WebViewClient{

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			// TODO Auto-generated method stub
			view.loadUrl(url);
			return true;
		}
		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			// TODO Auto-generated method stub
			super.onPageStarted(view, url, favicon);
			
		}
		@Override
		public void onPageFinished(WebView view, String url) {
			// TODO Auto-generated method stub
			super.onPageFinished(view, url);
			//progress.clearAnimation();
			progress.setVisibility(View.INVISIBLE);
		}
	}
}
