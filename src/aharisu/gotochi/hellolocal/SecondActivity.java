package aharisu.gotochi.hellolocal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import jag.kumamoto.apps.gotochi.PrefecturesActivityBase;
import jag.kumamoto.apps.gotochi.PrefecturesCode;

public class SecondActivity extends PrefecturesActivityBase {
	
	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		initializeComponents();
	}
	
	private void initializeComponents() {
		Context context = this;
		
		FrameLayout layout = new FrameLayout(context);
		this.setContentView(layout);
		
		FrameLayout.LayoutParams params;
		
		Button btn = new Button(context);
		params = new FrameLayout.LayoutParams(
				FrameLayout.LayoutParams.WRAP_CONTENT,
				FrameLayout.LayoutParams.WRAP_CONTENT);
		params.gravity = Gravity.CENTER;
		btn.setText("インテントを投げるよ!");
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override public void onClick(View v) {
				//このインテントはテストのために投げてるだけなので、
				//普通のアプリでは投げちゃダメ
				Intent gotochiIntent = new Intent();
				gotochiIntent.setAction("jag.kumamoto.apps.gotochi.LOCATION_CHANGE");
				gotochiIntent.putExtra("current_location", PrefecturesCode.Fukuoka);
				
				sendOrderedBroadcast(gotochiIntent, null);
			}
		});
		layout.addView(btn);
	}

}
