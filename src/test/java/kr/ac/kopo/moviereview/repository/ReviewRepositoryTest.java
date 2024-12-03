package kr.ac.kopo.moviereview.repository;

import jakarta.transaction.Transactional;
import kr.ac.kopo.moviereview.entity.Member;
import kr.ac.kopo.moviereview.entity.Movie;
import kr.ac.kopo.moviereview.entity.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
public class ReviewRepositoryTest {
    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void insertReview() {
        IntStream.rangeClosed(1, 200).forEach(i -> {
            // 임의의 영화번호
            Long mno = (long)(Math.random() * 100) + 1;
            // 임의의 회원번호
            Long mid = (long)(Math.random() * 100) + 1;

            Member member = Member.builder()
                    .mid(mid)
                    .build();

            Movie movie = Movie.builder()
                    .mno(mno)
                    .build();

            int grade = (int)(Math.random() * 5) + 1;

            Review review = Review.builder()
                    .member(member)
                    .movie(movie)
                    .grade(grade)
                    .text("영화 리뷰 텍스트 " + i)
                    .build();

            reviewRepository.save(review);
        });
    }

    @Test
    public void testGetMovieReviews() {
        Movie movie = Movie.builder()
                .mno(91L)
                .build();

        List<Review> result = reviewRepository.findByMovie(movie);

        result.forEach(review -> {
            System.out.println(review.getReviewnum() + "\t");
            System.out.println(review.getGrade() + "\t");
            System.out.println(review.getText() + "\t");
            System.out.println(review.getMember().getEmail() + "\t");
            System.out.println("----------------------------------------");
        });
    }
}
