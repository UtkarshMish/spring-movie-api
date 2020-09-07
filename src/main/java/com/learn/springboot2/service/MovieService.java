package com.learn.springboot2.service;

import com.learn.springboot2.domain.Movie;
import com.learn.springboot2.exceptions.ResourceNotFoundException;
import com.learn.springboot2.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
@AllArgsConstructor
public class MovieService {
private final MovieRepository movies;

public Collection<Movie> listAll() {
	return movies.findAll();
}

public Movie save(Movie movie) {
	movies.save(movie);
	return movie;
}

public Movie findById(int id) {
	return movies.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie with id:" + id + " not Found"));

}

public List<Movie> findByName(String name) {
	return movies.findByName(name);
}

public boolean remove(int id) {
	var found = movies.existsById(id);
	if (found) movies.deleteById(id);
	return found;

}

public Movie update(Movie movie) {
	remove(movie.getId());
	movies.save(movie);
	return movie;
}
}
