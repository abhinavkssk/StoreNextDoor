package com.example.storenexdoor;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class Likes extends Activity {
	
	EditText edtLikes;
	Button btnAdd;

	LoginDataBaseAdapter loginDataBaseAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.likes);
		loginDataBaseAdapter=new LoginDataBaseAdapter(this);
		loginDataBaseAdapter=loginDataBaseAdapter.open();
		edtLikes=(EditText)findViewById(R.id.editLikes);
		
		btnAdd=(Button)findViewById(R.id.Addlike);

        ListView listView1 = (ListView) findViewById(R.id.listView1);
        SharedPreferences sharedpref = getSharedPreferences("Mydata", Context.MODE_PRIVATE);
        final String destination_string = sharedpref.getString("123","");

        List<String> items = Arrays.asList(loginDataBaseAdapter.getLikes(destination_string).split("\\s*,\\s*"));       
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, items);
        
        listView1.setAdapter(adapter);
    
	     btnAdd.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String Search=edtLikes.getText().toString();
				
				// check if any of the fields are vaccant
				if(Search.equals(""))
				{
						Toast.makeText(getApplicationContext(), "Edit Field Vaccant", Toast.LENGTH_LONG).show();
						return;
				}
				else
				{
				    // Save the Data in Database
				    loginDataBaseAdapter.updateLikes(destination_string,Search);
				}

				/// Create Intent for SignUpActivity  and Start The Activity
				Intent intentLocation=new Intent(getApplicationContext(),Likes.class);
				startActivity(intentLocation);
				}
			});


    
    
    
    
    
    }
}