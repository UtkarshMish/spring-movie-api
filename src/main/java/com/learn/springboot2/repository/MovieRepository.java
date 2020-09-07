package com.learn.springboot2.repository;

import com.learn.springboot2.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
List<Movie> findByName(String name);
}
