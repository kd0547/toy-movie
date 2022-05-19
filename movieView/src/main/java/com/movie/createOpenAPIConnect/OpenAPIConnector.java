package com.movie.createOpenAPIConnect;

import java.io.InputStream;
import java.util.Map;

public interface OpenAPIConnector {
	 public String OpenAPIRequest(String Method,String url);
	 public  String readInputStreamData(InputStream inputstream);
	 
	 
}
