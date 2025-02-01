package com.br.movies.service;

import com.br.movies.dto.request.MovieRequestDTO;
import com.br.movies.dto.response.MovieResponseDTO;
import com.br.movies.entity.Movie;
import com.br.movies.exception.MovieNotFoundException;
import com.br.movies.repository.MoviesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MoviesService {

    private static final Logger logger = LoggerFactory.getLogger(MoviesService.class);

    private final MoviesRepository repository;

    public MoviesService(MoviesRepository repository) {
        this.repository = repository;
    }

    public MovieResponseDTO saveMovie(MovieRequestDTO request) {
        Movie movie = new Movie(
                request.getTitle(),
                request.getDirector(),
                request.getReleaseYear(),
                request.getGenre(),
                request.getDuration()
        );
        System.out.println("antes: "+movie);
        Movie savedMovie = repository.save(movie);
        System.out.println("depois: "+savedMovie);
        return new MovieResponseDTO(savedMovie.getId(),
                savedMovie.getTitle(),
                savedMovie.getDirector(),
                savedMovie.getReleaseYear(),
                savedMovie.getGenre(),
                savedMovie.getDuration()
        );
    }

    public List<MovieResponseDTO> getAllMovies() {

        logger.info("Iniciando o método de busca de movies");

        List<Movie> movies = repository.findAll();

        logger.info("Finalizando a busca de todas as movies");

        return movies.stream().map(
                movie -> new MovieResponseDTO(movie.getId(),
                        movie.getTitle(),
                        movie.getDirector(),
                        movie.getReleaseYear(),
                        movie.getGenre(),
                        movie.getDuration()
                )
        ).collect(Collectors.toList());
    }

    public MovieResponseDTO getMovieById(Long id) {

        logger.info("Iniciando a busca por uma movie com ID: {}", id);

        Movie movie = repository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found with ID: " + id));

        logger.info("Finalizando a busca por uma movie com ID: {}", movie.getId());

        return new MovieResponseDTO(movie.getId(),
                movie.getTitle(),
                movie.getDirector(),
                movie.getReleaseYear(),
                movie.getGenre(),
                movie.getDuration()
        );
    }

    public MovieResponseDTO setMovie(Long id, MovieRequestDTO request) {
        Movie movie = repository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found with ID: " + id));
        movie.setTitle(request.getTitle());
        movie.setDirector(request.getDirector());
        movie.setReleaseYear(request.getReleaseYear());
        movie.setGenre(request.getGenre());
        movie.setDuration(request.getDuration());

        Movie updatedMovie = repository.save(movie);
        return new MovieResponseDTO(movie.getId(),
                updatedMovie.getTitle(),
                updatedMovie.getDirector(),
                updatedMovie.getReleaseYear(),
                updatedMovie.getGenre(),
                updatedMovie.getDuration()
        );
    }

    public void removeMovie(Long id) {
        Movie movie = repository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found with ID: " + id));
        repository.delete(movie);
    }

}