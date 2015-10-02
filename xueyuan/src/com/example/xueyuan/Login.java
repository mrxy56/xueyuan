package com.example.xueyuan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.example.xueyuan.Register.RegisterThread;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity implements OnClickListener{
	  TextView content;
	  Button update_button;
	  static String text="";
	  public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.theme);
	        content= (TextView) findViewById(R.id.content);
	        update_button=(Button)findViewById(R.id.update_button);
	        update_button.setOnClickListener(this);
	  }
	  public void onClick(View v) {
		   switch (v.getId()) {
			    case R.id.update_button:
			    	Thread downloadThread = new Thread(new DownloadThread());
					downloadThread.start();
				break;
			    default:
			    break;
			}
	  }
	  
	  Handler handler = new Handler() {
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case 1:
					content.append(text);
					break;
				default:
					break;

				}
			}
		};
	class DownloadThread implements Runnable {

			@Override
			public void run() {
				Message message=new Message();
				text=catchPage("http://mrxy56.sinaapp.com");
				message.what=1;
				handler.sendMessage(message);
			}
		}
	
	  private String catchPage(String targetUrl){

		  URL url;
		  URLConnection con;
		  StringBuffer sb=null;
		  try {
		  //向targetUrl发送请求
		       url = new URL(targetUrl);
		       con=url.openConnection();
		       con.setConnectTimeout(30000);
		       con.setReadTimeout(30000);

		  //读取响应
		       BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		       sb=new StringBuffer();
		       String temp;
		        while((temp=reader.readLine())!=null){
		             sb.append(temp);
		        }
		  } catch (IOException e) {
		  // TODO Auto-generated catch block
		       e.printStackTrace();
		  }
	      return sb.toString();
     }
}
