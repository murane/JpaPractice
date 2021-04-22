package com.example.jpapractice.nplusone;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
    @Query("select m from Member m join fetch m.items")
    Set<Member> findAllByJoinFetch();

    @EntityGraph(attributePaths = "items")
    @Query("select m from Member m")
    List<Member> findAllByEntityGraph();
}
