package distudy.devboard.controller;

import distudy.devboard.Entity.Member;
import distudy.devboard.dto.MemberDto;
import distudy.devboard.dto.MemberFindDto;
import distudy.devboard.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LoginController {

    private MemberRepository memberRepository;

    @Autowired
    public LoginController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @PostMapping("/")
    public String login(MemberDto memberDto){
        List<Member> memberList = memberRepository.findAll();

        for (Member member : memberList) {
            if (member.getEmail().equals( memberDto.getEmail())){
                if(member.getPassword().equals( member.getPassword())){
                    return "redirect:/personalpage/" + member.getId();
                }
            }
        }

        return "login_fail.html";
    }

    @GetMapping("/join")
    public String join(){
        return "join";
    }

    @PostMapping("/join")
    public String save(Member member){
        System.out.println("member = " + member.toString());
        memberRepository.save(member);
        return "redirect:/";
    }

    @GetMapping("/find-password")
    public String findPassword(){
        return "find-password";
    }

    @PostMapping("/find-password")
    public String checkAnswerFindPassword(MemberFindDto memberFindDto, Model model){
        List<Member> memberList = memberRepository.findAll();
        System.out.println("memberFindDto = " + memberFindDto.toString());

        for (Member member : memberList) {
            if(member.getEmail().equals(memberFindDto.getEmail())){
                if(member.getFindPasswordAnswer().equals(memberFindDto.getFindPasswordAnswer())){
                    model.addAttribute("password",member.getPassword());
                    return "show-password";
                }
            }
        }

        return "find-password-fail";
    }
}
