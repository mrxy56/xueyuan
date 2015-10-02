package com.example.xueyuan;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class Main extends Activity implements OnClickListener{
	private TextView confirm_password_error;
	private Button register_button,login_button;
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login);
        InitView();
    }
    
    private void InitView() {
		confirm_password_error = (TextView) findViewById(R.id.confirm_password_error);
		register_button = (Button) findViewById(R.id.register_button);
		login_button = (Button) findViewById(R.id.login_button);
		register_button.setOnClickListener(this);
		login_button.setOnClickListener(this);
	}
    
    @Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.register_button:
			 Intent intent = new Intent(); 
	         intent.setClass(Main.this, Register.class);
	         Main.this.startActivity(intent);
             break;
		case R.id.login_button:
			 Intent intent2 = new Intent(); 
	         intent2.setClass(Main.this,Login.class);
	         Main.this.startActivity(intent2);
            break;
		default:
			break;
		}
	}


}