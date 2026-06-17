package library.app.com.endpoint;


import library.app.com.repository.model.Member;
import library.app.com.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberEndpoint {

    private final MemberService service;

    public MemberEndpoint(MemberService service) {
        this.service = service;
    }

    @GetMapping
    public List<Member> getAllMembers() {
        return service.getAllMembers();
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        service.deleteMember(id);
    }
}