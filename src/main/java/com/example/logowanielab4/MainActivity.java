package com.example.logowanielab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText uname,pswd;
    Button login;
    DataBaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname=(EditText)findViewById(R.id.uname);
        pswd=(EditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=uname.getText().toString();
                String password=pswd.getText().toString();
                int id= checkUser(new User(name,password));

                if(id==-1)
                {
                    Toast.makeText(MainActivity.this,"User Does Not Exist",Toast.LENGTH_SHORT).show();
                }
                else
                {
                   Toast.makeText(MainActivity.this,"User Exist "+name,Toast.LENGTH_SHORT).show();
                   //Intent intent = new Intent(MainActivity.this, AdminAC.class);
                    //intent.putExtra("username",name);
                    //startActivity(intent);
                 //   Intent intent = new Intent(getApplicationContext(),AdminAC.class);
                  // intent.putExtra("message_key", name);
                    //startActivity(intent);
                }
            }
        });
        db=new DataBaseHelper(MainActivity.this);
//inserting dummy users
        db.addUser(new User("test", "123"));
        db.addUser(new User("test2", "456"));
        db.addUser(new User("admin", "admin"));
    }
    public int checkUser(User user)
    {
        return db.checkUser(user);
    }
   // @Override
   /* public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// Handle action bar item clicks here. The action bar will
// automatically handle clicks on the Home/Up button, so long
// as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
//noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}