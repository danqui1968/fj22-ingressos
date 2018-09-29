package br.com.caelum.ingresso.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImagemCapa {

	@JsonProperty("Poster")
	String url;
	
	public String GetUrl(){
		return url;
	}
	
	public void setUrl(String url) {
		this.url=url;
	}
}
