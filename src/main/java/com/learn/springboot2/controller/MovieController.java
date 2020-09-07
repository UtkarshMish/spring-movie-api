package com.learn.springboot2.controller;

import com.learn.springboot2.domain.Movie;
import com.learn.springboot2.service.MovieService;
import com.learn.springboot2.utils.CommonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("movies")
@Slf4j
@RequiredArgsConstructor
public class MovieController {
private final CommonUtils datetime;
private final MovieService movieService;

@GetMapping()
public ResponseEntity<Collection<Movie>> getMovies() {
	log.info("Request Made on Date: {}", datetime.localDateToDatabaseDate(LocalDateTime.now()));


	return ResponseEntity.ok(movieService.listAll());
}

@GetMapping(path = "/{id}")
public ResponseEntity<Movie> findById(@PathVariable int id) {
	return ResponseEntity.ok(movieService.findById(id));
}

@GetMapping("/find")
public ResponseEntity<List<Movie>> findByName(@RequestParam(value = "name") String name) {
	return ResponseEntity.ok(movieService.findByName(name));
}

@PostMapping
public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
	return ResponseEntity.ok(movieService.save(movie));
}

@DeleteMapping("/{id}")
public ResponseEntity<Map<String, Boolean>> deleteMovie(@PathVariable int id) {
	return ResponseEntity.ok(Map.of("isRemoved", movieService.remove(id)));
}

@PutMapping
public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie) {
	return ResponseEntity.ok(movieService.update(movie));
}
}
