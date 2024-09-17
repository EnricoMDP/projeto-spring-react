package com.devsuperior.dsmovie.dto;

public class ScoreDTO {
	private Long movieId;
	private String email;
	private Double movie_score;
	
	public ScoreDTO() {
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getMovie_score() {
		return movie_score;
	}

	public void setMovie_score(Double movie_score) {
		this.movie_score = movie_score;
	};
	
	
}
