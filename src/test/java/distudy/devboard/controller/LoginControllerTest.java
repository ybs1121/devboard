package distudy.devboard.controller;

import distudy.devboard.Entity.Member;
import distudy.devboard.repository.MemberRepository;
import distudy.devboard.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
class LoginControllerTest {
//    @Autowired MemberRepository memberRepository;

    MemberRepository memberRepository = new MemoryMemberRepository();
    @Test
    void save(){
        //given
        Member member = new Member();
        member.setEmail("asd@asd.com");
        member.setName("nameA");
        member.setPassword("password");
        member.setFindPasswordAnswer("school");

        //when

        Long id = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findMember(id);

        assertThat(findMember).isEqualTo(member);


    }

    @Test
    void test_sample(){
        Map<Long,Member> test = new HashMap<>();
        Member member = new Member();
        member.setEmail("asd");
        member.setName("asd");
        member.setPassword("11");
        member.setFindPasswordAnswer("1111");

        test.put(1L,member);

        Member a = test.get(1L);

        Long t = 1L;
        member.setId(++t);
        System.out.println("member = " + member.toString());

    }

}