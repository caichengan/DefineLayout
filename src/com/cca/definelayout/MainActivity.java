package com.cca.definelayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	private CustomerLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        layout=(CustomerLayout) findViewById(R.id.customer_layout);
    }
    public void clickSwitcher(View view){
    	layout.switchLayout();
    }
}
