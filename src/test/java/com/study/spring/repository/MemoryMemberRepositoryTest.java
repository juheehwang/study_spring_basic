package com.study.spring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.study.spring.domain.Member;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemoryMemberRepositoryTest {

   MemoryMemberRepository repository = new MemoryMemberRepository();

   @AfterEach
   public void afterEach(){
    repository.clearStore();
   }

   @Test
  public void save(){
     Member member = new Member();
     member.setName("daeng");

     repository.save(member);

     var result = repository.findById(member.getId()).get();
     assertThat(member).isEqualTo(result);
   }

   @Test
  public void findByName(){
     Member member1 = new Member();
     member1.setName("Deang!!");
     repository.save(member1);

     Member member2 = new Member();
     member2.setName("Deang222!!");
     repository.save(member2);

     var result1 = repository.findByName("Deang!!").get();

     assertThat(result1).isEqualTo(member1);
   }

   @Test
  public void findAll(){
     Member member1 = new Member();
     member1.setName("Deang!!");
     repository.save(member1);

     Member member2 = new Member();
     member2.setName("Deang222!!");
     repository.save(member2);

     var result = repository.findAll();

     assertThat(result.size()).isEqualTo(2);
   }
}
