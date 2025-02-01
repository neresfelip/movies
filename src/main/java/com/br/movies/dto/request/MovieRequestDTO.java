package com.br.movies.dto.request;

public class MovieRequestDTO {
    private String title;
    private String director;
    private Integer releaseYear;
    private String genre;
    private Integer duration;

    public MovieRequestDTO(String title, String director, Integer releaseYear, String genre, Integer duration) {
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}


