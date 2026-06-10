package library.app.com.repository;

import library.app.com.repository.model.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberRepository {

    private final List<Member> members = new ArrayList<>();

    public List<Member> findAll() {
        return members;
    }

    public Member save(Member member) {
        members.add(member);
        return member;
    }
}