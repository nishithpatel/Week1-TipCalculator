package com.yahoo.example.week1tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculatorActivity extends Activity {
	
	public EditText input;
	public TextView tipOutput;
	public TextView totalOutput;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
		input = (EditText) findViewById(R.id.input);
		tipOutput = (TextView) findViewById(R.id.tipOutput);
		totalOutput = (TextView) findViewById(R.id.totalOutput);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calculator, menu);
		return true;
	}
	
	public void calculateTip(View view) {
		// when any of the 3 tip options is selected
		String input_value = input.getText().toString();
		
		
		Double tip = 0.0;
		Double total = 0.0;
		String tip_str = "";
		String total_str = "";
		
		if(input_value == null || input_value.trim().equals(""))
        {
			Toast.makeText(this, "Please enter a valid amount", Toast.LENGTH_SHORT).show();
			tip_str = "$";
	        total_str = "Total: $";
        }
        else 
        {
        	Double amount = Double.valueOf(input_value);
        	
        	if(amount == 0)
        	{
        		Toast.makeText(this, "Please enter a non-zero amount", Toast.LENGTH_SHORT).show();
        		tip_str = "$";
		        total_str = "Total: $";
        	}
        	else
        	{
		        switch(view.getId()) 
		        {
			        case R.id.btnOption1:
			          // selected 10%
			        	tip = amount*0.1;
			          break;
			        case R.id.btnOption2:
			          // selected 15%
			        	tip = amount*0.15;
			          break;
			        case R.id.btnOption3:
			            // selected 20%
			        	tip = amount*0.2;
			            break;
		        }
		        
		        total = amount+tip;
		        
		        tip_str = "$" + String.valueOf(tip);
		        total_str = "Total: $" + String.valueOf(total);
		    }
        }

    	tipOutput.setText(tip_str);
		totalOutput.setText(total_str);

	}

}
