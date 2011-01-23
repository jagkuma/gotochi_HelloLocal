package aharisu.gotochi.hellolocal;

import jag.kumamoto.apps.gotochi.PrefecturesActivityBase;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class HelloLocalActivity extends PrefecturesActivityBase {
	
	int mCount = 0;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
		Toast.makeText(this, 
				"ご当地アプリは" + (isGotochiApp() ? "有効" : "無効") + "です。",
				Toast.LENGTH_SHORT).show();
		
        
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
		btn.setText("次へ");
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override public void onClick(View v) {
				startActivity(new Intent(HelloLocalActivity.this, SecondActivity.class));
			}
		});
		layout.addView(btn);
    }
    
    @Override protected boolean onLocationChange(Context context, Intent intent) {
    	++mCount;
    	
    	if(mCount == 1) {
	    	Toast.makeText(this, "一度目のインテントでは終了させない" , Toast.LENGTH_SHORT).show();
	    	return true;
    	} else {
	    	Toast.makeText(this, "二度目のインテントなので終了する" , Toast.LENGTH_SHORT).show();
    		return false;
    	}
    }
    
}