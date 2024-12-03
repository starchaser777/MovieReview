package kr.ac.kopo.moviereview.repository;

import kr.ac.kopo.moviereview.entity.Movie;
import kr.ac.kopo.moviereview.entity.MovieImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieImageRepository extends JpaRepository<MovieImage, Long> {
}
