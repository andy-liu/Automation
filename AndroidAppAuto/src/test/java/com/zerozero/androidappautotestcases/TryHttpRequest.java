package com.zerozero.androidappautotestcases;

import static org.junit.Assert.*;

import org.junit.Test;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

 
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;


public class TryHttpRequest {

	@Test
	public void TryHttpGet() throws IOException {
        //发送get请求
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			String url = "http://10e9djk.release.test.gethover.com/api/v1/android/upgrade";
	        HttpGet request = new HttpGet(url);
	        HttpResponse response = httpclient.execute(request);
//	        System.out.println(response);
	        if (response.getStatusLine().getStatusCode() == 200) {
                System.out.println(EntityUtils.toString(response.getEntity(),"utf-8"));
            } 
//	        int status = response.getStatusLine().getStatusCode();
//	        System.out.println(status);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			httpclient.close();
		}
	}
	
	@Test
	public void TryHttpPost() throws IOException {
        //发送post请求
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			String url = "http://10e9djk.release.test.gethover.com/api/v1/android/upgrade";
			HttpPost request = new HttpPost(url);
			List<NameValuePair> params=new ArrayList<NameValuePair>();

			params.add(new BasicNameValuePair("pwd","2544"));
			
//			request.setEntity(new UrlEncodedFormEntity(params,HTTP.ASCII));
			
	        HttpResponse response = httpclient.execute(request);
	        System.out.println(response);
	        
	        int status = response.getStatusLine().getStatusCode();
	        System.out.println(status);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			httpclient.close();
		}
	}

}
