package android.ApptorneyPac;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class loadingAct extends Activity {
	Timer timer=new Timer();
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.load);
	    timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				startActivity(new Intent(loadingAct.this,ApptorneyAct.class));
			}
		}, 1000);
}}
