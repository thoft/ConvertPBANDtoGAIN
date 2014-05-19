package de.thoft.convertpbandtogain;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculateActivity extends Activity {
	public static final String BUTTON_CHOOSED = "de.thoft.convertpbandtogain.button_choosed";
	private int mChoosedButton;
	private TextView mInputTextTextView;
	private EditText mInputEditText;
	private TextView mResultTextTextView;
	private TextView mResultTextView;
	private EditText mMeasurementRangeLowEditText;
	private EditText mMeasurementRangeHighEditText;
	private EditText mOutputRangeLowEditText;
	private EditText mOutputRangeHighEditText;
	private Button mCalculateButton;
	private Calculate mCalculate;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculate);
		mChoosedButton = getIntent().getIntExtra(BUTTON_CHOOSED, 1);
		
		if(mChoosedButton == 1){
			mCalculate = new Calculate(100.0, 0.0, 100.0, 0.0, 100.0, 1);
		}
		else{
			mCalculate = new Calculate(1, 0.0, 100.0, 0.0, 100.0, 2);
		}
		
		
		
		mInputTextTextView = (TextView)findViewById(R.id.inputTextTextView);
		mInputEditText = (EditText)findViewById(R.id.inputEditText);
		mResultTextTextView = (TextView)findViewById(R.id.resultTextTextView);
		mResultTextView = (TextView)findViewById(R.id.resultTextView);
		mMeasurementRangeLowEditText = (EditText)findViewById(R.id.measurementRangeLowEditText); 
		mMeasurementRangeHighEditText = (EditText)findViewById(R.id.measurementRangeHighEditText);
		mOutputRangeLowEditText = (EditText)findViewById(R.id.outputRangeLowEditText);
		mOutputRangeHighEditText = (EditText)findViewById(R.id.outputRangeHighEditText);
		mCalculateButton = (Button)findViewById(R.id.calculate_button);
		
				
		mCalculateButton.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v){
        		String result;
        		
        		mCalculate.setMeasurementRangeLow(Double.parseDouble(mMeasurementRangeLowEditText.getText().toString()));
        		mCalculate.setMeasurementRangeHigh(Double.parseDouble(mMeasurementRangeHighEditText.getText().toString()));
        		mCalculate.setOutputRangeLow(Double.parseDouble(mOutputRangeLowEditText.getText().toString()));
        		mCalculate.setOutputRangeHigh(Double.parseDouble(mOutputRangeHighEditText.getText().toString()));
        		
        		if(mChoosedButton == 1){
        			mCalculate.setPband(Double.parseDouble(mInputEditText.getText().toString()));
        			result = String.valueOf(mCalculate.CalculateK());
        		}
        		else{
        			mCalculate.setK(Double.parseDouble(mInputEditText.getText().toString()));
        			result = String.valueOf(mCalculate.CalculatePband());
        		}
        		mResultTextView.setText(result);
        		
        	}
        });
		

		mMeasurementRangeLowEditText.setText(String.valueOf(mCalculate.getMeasurementRangeLow()));
		mMeasurementRangeHighEditText.setText(String.valueOf(mCalculate.getMeasurementRangeHigh()));
		mOutputRangeLowEditText.setText(String.valueOf(mCalculate.getOutputRangeLow()));
		mOutputRangeHighEditText.setText(String.valueOf(mCalculate.getOutputRangeHigh()));
		
		if(mChoosedButton == 1){
			mInputTextTextView.setText(R.string.pband);
			mResultTextTextView.setText(R.string.k);
			mInputEditText.setText(String.valueOf(mCalculate.getPband()));
		}
		else{
			mInputTextTextView.setText(R.string.k);
			mResultTextTextView.setText(R.string.pband);
			mInputEditText.setText(String.valueOf(mCalculate.getK()));
		}
			
	}
}