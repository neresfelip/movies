package com.br.movies.controller;

import com.br.movies.dto.request.MovieRequestDTO;
import com.br.movies.dto.response.MovieResponseDTO;
import com.br.movies.service.MoviesService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MoviesService service;

    public MovieController(MoviesService service) {
        this.service = service;
    }

    @Operation(summary = "Create a new Movie", description = "The book is on the table")
    @PostMapping
    public ResponseEntity<MovieResponseDTO> saveMovie(@RequestBody MovieRequestDTO request) {
        MovieResponseDTO response = service.saveMovie(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<MovieResponseDTO>> getAllMovies() {
        List<MovieResponseDTO> response = service.getAllMovies();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponseDTO> getMovieById(@PathVariable Long id) {
        MovieResponseDTO response = service.getMovieById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponseDTO> setMovie(@PathVariable Long id, @RequestBody MovieRequestDTO request) {
        MovieResponseDTO response = service.setMovie(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeMovie(@PathVariable Long id) {
        service.removeMovie(id);
        return ResponseEntity.ok("Movie with ID: "+id+" has been deleted with success.");
    }

}
