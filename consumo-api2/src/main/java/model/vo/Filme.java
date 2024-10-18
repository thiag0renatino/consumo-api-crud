package model.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Filme {
	
	 private String Title;
	 private int Year;
	 private String Genre;
	 private String Runtime;
	 private String Metascore;
	 private String Country;
	 private String Type;
	 
	 public Filme() {
		 
	 }

	public Filme(String title, int year, String genre, String runtime, String metaScore, String country, String type) {
		this.Title = title;
		this.Year = year;
		this.Genre = genre;
		this.Runtime = runtime;
		this.Metascore = metaScore;
		this.Country = country;
		this.Type = type;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		this.Title = title;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		this.Year = year;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		this.Genre = genre;
	}

	public String getRuntime() {
		return Runtime;
	}

	public void setRuntime(String runtime) {
		this.Runtime = runtime;
	}

	public String getMetaScore() {
		return Metascore;
	}

	public void setMetaScore(String metaScore) {
		this.Metascore = metaScore;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		this.Country = country;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		this.Type = type;
	}

	@Override
	public String toString() {
		return "FILME: \n\n[Title = " + Title + ", \n\nYear = " + Year + ", \n\nGenre = " + Genre + ", \n\nRuntime = " + Runtime + ", \n\nMetaScore = "
				+ Metascore + ", \n\nCountry = " + Country + ", \n\nType = " + Type + "]";
	} 
	
	
	 
	   
	 
}
