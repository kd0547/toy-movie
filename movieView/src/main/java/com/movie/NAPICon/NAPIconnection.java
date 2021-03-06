package com.movie.NAPICon;

import com.movie.createOpenAPIConnect.OpenAPIConnector;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;



public class NAPIconnection implements OpenAPIConnector{

	private HttpURLConnection httpURLConnection= null;
	 /*
	  * 
	  * 
	  * 
	  * 
	 */
	public NAPIconnection(HttpURLConnection httpURLConnection){
		this.httpURLConnection = httpURLConnection;
	}
	 /*
	  * 
	  * 
	  * 
	  */
	@Override
	 public String OpenAPIRequest(String Method,String url) {
		 //HttpURLConnection httpURLConnection = connect(url);
		 
		 try {
				httpURLConnection.setRequestMethod(Method);
				int responseCode = httpURLConnection.getResponseCode();
				
				if(responseCode == 200) {
					return readInputStreamData(httpURLConnection.getInputStream());
				}	else if(responseCode == 400){
					return readInputStreamData(httpURLConnection.getErrorStream()) ;
				} else if(responseCode == 404) {
					return readInputStreamData(httpURLConnection.getErrorStream());
				} else {
					return readInputStreamData(httpURLConnection.getErrorStream());
				}
			} catch (ProtocolException e) {
				
				e.printStackTrace();
			} catch (IOException  e) {
				e.printStackTrace();
			} finally {
				httpURLConnection.disconnect();
			}
		 
		return null;
	 }
	 /*
	  * 
	  * 
	  * 
	  */
	@Override
	 public  String readInputStreamData(InputStream inputstream){
	        InputStreamReader streamReader = new InputStreamReader(inputstream);

	        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
	            StringBuilder responseBody = new StringBuilder();

	            String line;
	            while ((line = lineReader.readLine()) != null) {
	                responseBody.append(line);
	            }

	            return responseBody.toString();
	        } catch (IOException e) {
	            throw new RuntimeException("API ????????? ????????? ??????????????????.", e);
	        }
	    }
	 
	 /*
	  * 	?????? ?????? ??????
	  * 
	  *
	 public HttpURLConnection connect(String apiUrl) {
		 try {
			URL url = new URL(apiUrl);
			
			return (HttpURLConnection) url.openConnection();
			
		} catch (MalformedURLException e) {
			throw new RuntimeException("API ?????? ?????? :" + apiUrl,e);
		} catch (IOException e) {
			throw new RuntimeException("IO ?????? ?????? :" + apiUrl,e);
		} 
	 }
	*
	 * 
	 * 
	 */
	
	/*
	 * 
	 */
	 public void setHttpHeader(Map<String, String> requestHeader) {
		 
		 	if(requestHeader != null) {
		 		for (Map.Entry<String, String> header : requestHeader.entrySet()) {
					 httpURLConnection.setRequestProperty(header.getKey(), header.getValue());
					
				}
		 	}

	 }
	
	
	 
	 
	 
	 
	 
	 
}
