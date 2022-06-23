package distudy.devboard.repository;

import distudy.devboard.Entity.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository {

    Long save(Member member);

    Member findMember(Long id);

    List<Member> findAll();
}
