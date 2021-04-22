package com.example.jpapractice;

import com.example.jpapractice.nplusone.Item;
import com.example.jpapractice.nplusone.Member;
import com.example.jpapractice.nplusone.MemberRepository;
import com.example.jpapractice.nplusone.ItemRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class NplusoneTest {
    @Autowired
    MemberRepository memberRepository;
    @Test
    void N_쿼리테스트(){
        List<Member> members = memberRepository.findAll();
    }
    @Test
    void N1_쿼리테스트(){
        List<Member> members = memberRepository.findAll();
        for(Member member: members){
            System.out.println(member.toString());
            System.out.println(member.getItems().size());
        }
    }
    @Test
    void FetchJoin_쿼리테스트(){
        Set<Member> members = memberRepository.findAllByJoinFetch();
        for(var member: members){
            System.out.println(member.getItems().size());
        }
    }
    @Test
    void EntityGraph_쿼리테스트(){
        List<Member> members = memberRepository.findAllByEntityGraph();
        for(var member: members){
            System.out.println(member.getItems().size());
        }
    }
}
