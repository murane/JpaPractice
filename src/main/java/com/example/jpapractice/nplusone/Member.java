package com.example.jpapractice.nplusone;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    //@OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private Set<Item> items = new HashSet<>();

    public Member(String name) {
        this.name = name;
    }

    public void addOrder(Item item) {
        items.add(item);
        item.updateMember(this);
    }

    public Set<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "id: " + id + ",name: " + name;
    }
}
