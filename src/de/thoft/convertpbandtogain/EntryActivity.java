package de.thoft.convertpbandtogain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EntryActivity extends Activity {

	private Button mPbandToKButton;
	private Button mKToPbandButton;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        
        mPbandToKButton = (Button)findViewById(R.id.pbandToK_button);
        mKToPbandButton = (Button)findViewById(R.id.kToPband_button);
        
        mPbandToKButton.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v){
        		Intent i = new Intent(EntryActivity.this, CalculateActivity.class);
        		i.putExtra(CalculateActivity.BUTTON_CHOOSED, 1);
        		startActivity(i);
        	}
        });
        
        mKToPbandButton.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v){
        		Intent i = new Intent(EntryActivity.this, CalculateActivity.class);
        		i.putExtra(CalculateActivity.BUTTON_CHOOSED, 2);
        		startActivity(i);
        	}
        });
    }
 }
