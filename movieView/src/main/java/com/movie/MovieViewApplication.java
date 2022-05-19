package com.movie;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.movie.NAPICon.NAPIconnection;
import com.movie.createOpenAPIConnect.OpenAPIConnector;

@SpringBootApplication
public class MovieViewApplication {
	
	static Map<String, String> requestHeaders = new HashMap<>();

	public static void main(String[] args) {
		SpringApplication.run(MovieViewApplication.class, args);
		URL apiurl = null ;
		HttpURLConnection httpURLConnection;
		OpenAPIConnector napIconnection;
		/*
		  *  - 네이버 API에 데이터를 보내게 위해 요청 헤더에 
		  *  - X-Naver-Client-Id, X-Naver-Client-Secret 
		  *  - 두 값을 넣어 줘야 한다. 
		  */
		
		String url= "https://openapi.naver.com/v1/search/movie.json?query=%EC%A3%BC%EC%8B%9D&display=10&start=1&genre=1";
		String client_Id= "Up6cwmHUIvNzOKVfm_9s";
		String client_secret = "Z_GVKN_AKM";
		 
		setRequestHeader("X-Naver-Client-Id",client_Id);
		setRequestHeader("X-Naver-Client-Secret", client_secret);
		
		try {
			apiurl = new URL(url);
			
			httpURLConnection = (HttpURLConnection) apiurl.openConnection();
			
			napIconnection = new NAPIconnection(httpURLConnection);
			
		} catch (MalformedURLException e) {
			throw new RuntimeException("API 연결 실패 :" ,e);
		} catch (IOException e) {
			throw new RuntimeException("IO 연결 실패 :" ,e);
		} 
		
		
		

		
		//NAPIconnection napIconnection = new NAPIconnection();
		
		String test = napIconnection.OpenAPIRequest("GET",url);
		
		
		
		System.out.println(test);
		
		
	}
	
	
	 
	
	
	public static void setRequestHeader(String name,String value) {
		 requestHeaders.put(name, value);
	 }

}
