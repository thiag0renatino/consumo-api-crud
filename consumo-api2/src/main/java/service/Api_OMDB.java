package service;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

import model.vo.Filme;

public class Api_OMDB {

	public Filme getFilme(String title) throws IOException, InterruptedException {
		
		Filme filme = null;
		
		HttpGet request = new HttpGet("https://www.omdbapi.com/?t="+ title + "&apikey=53dac864&");
		
		try(CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
				CloseableHttpResponse response = httpClient.execute(request)){
			
			HttpEntity entity = response.getEntity();
			
			if (entity != null) {
				
				String result = EntityUtils.toString(entity);
				
				Gson gson = new Gson();
				
				filme = gson.fromJson(result, Filme.class);
			}
			
		}
		return filme;
			
		
		

	}
	
}
