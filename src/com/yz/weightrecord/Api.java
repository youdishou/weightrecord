package com.yz.weightrecord;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

public class Api {
	private static final String TAG = "Api";
	
	private final static String ADD_URL = "http://weightrecord.duapp.com/api/add?weight=%s&light_weight=%s";
	
	public static void add(String weight,String lightWeight){
		HttpClient client = new DefaultHttpClient();
		String url = String.format(ADD_URL, weight,lightWeight);
		Log.i(TAG, "url" + url);
		HttpGet get = new HttpGet(url);
		HttpResponse response = null;
		try {
			response = client.execute(get);
			response.getEntity().consumeContent();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
