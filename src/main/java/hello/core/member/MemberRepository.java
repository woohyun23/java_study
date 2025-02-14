package hello.core.member;

public interface MemberRepository {

    void save(Member memberId);

    Member findById(Long memberId);
}
