package kr.ac.kopo.moviereview.repository;

import kr.ac.kopo.moviereview.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
