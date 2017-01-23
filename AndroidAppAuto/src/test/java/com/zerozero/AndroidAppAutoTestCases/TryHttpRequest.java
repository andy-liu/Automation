package com.zerozero.AndroidAppAutoTestCases;

import static org.junit.Assert.*;

import org.junit.Test;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

 
import java.io.IOException;
import java.net.URLDecoder;


public class TryHttpRequest {

	@Test
	public void TryHttpGet() throws IOException {
        //发送get请求
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			String url = "https://gethover.com/";
	        HttpGet request = new HttpGet(url);
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
	
	@Test
	public void TryHttpPost() throws IOException {
        //发送post请求
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			String url = "https://www.baidu.com/";
			HttpPost request = new HttpPost(url);
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
