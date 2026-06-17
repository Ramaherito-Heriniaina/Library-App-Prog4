package library.app.com.service;


import library.app.com.repository.model.Member;
import library.app.com.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public List<Member> getAllMembers() {
        return repository.findAll();
    }

    public void deleteMember(Long id) { repository.deleteById(id); }
}