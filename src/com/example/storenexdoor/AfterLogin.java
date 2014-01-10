
package com.example.storenexdoor;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AfterLogin extends Activity 
{
	EditText edtSearch;
	Button btnLikes,btnFriends,btnLocation,btnSearch;
	LoginDataBaseAdapter loginDataBaseAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
	     super.onCreate(savedInstanceState);
	     setContentView(R.layout.afterlogin);
			loginDataBaseAdapter=new LoginDataBaseAdapter(this);
			loginDataBaseAdapter=loginDataBaseAdapter.open();
	     
	     // create a instance of SQLite Database
	     
	     // Get The Reference Of Buttons
	     btnLikes=(Button)findViewById(R.id.buttonLIKES);
	     btnFriends=(Button)findViewById(R.id.buttonFRIENDS);
	     btnLocation=(Button)findViewById(R.id.buttonLOCATION);
	     btnSearch=(Button)findViewById(R.id.buttonSearch);
		 edtSearch=(EditText)findViewById(R.id.editSearch);

	    // Set OnClick Listener on SignUp button 
	     btnLikes.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			/// Create Intent for SignUpActivity  and Start The Activity
			Intent intentLikes=new Intent(getApplicationContext(),Likes.class);
			startActivity(intentLikes);
			}
		});
	     btnFriends.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			/// Create Intent for SignUpActivity  and Start The Activity
			Intent intentFriends=new Intent(getApplicationContext(),Friends.class);
			startActivity(intentFriends);
			}
		});	     
	     btnLocation.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				/// Create Intent for SignUpActivity  and Start The Activity
				Intent intentLocation=new Intent(getApplicationContext(),AndroidGPSTrackingActivity.class);
				startActivity(intentLocation);
				}
			});
	     btnSearch.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String Search=edtSearch.getText().toString();
				
				// check if any of the fields are vaccant
				if(Search.equals(""))
				{
						Toast.makeText(getApplicationContext(), "Search Field Vaccant", Toast.LENGTH_LONG).show();
						return;
				}
				else
				{
				    // Save the Data in Database
					 SharedPreferences sharedpref = getSharedPreferences("Mydata", Context.MODE_PRIVATE);

					 SharedPreferences.Editor editor = sharedpref.edit();
				        editor.putString("12345",Search);
				        editor.commit();
				}

				/// Create Intent for SignUpActivity  and Start The Activity
				Intent intentLocation=new Intent(getApplicationContext(),Search.class);
				startActivity(intentLocation);
				}
			});

	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
		loginDataBaseAdapter.close();
	}

}
