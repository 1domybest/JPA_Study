package jpabook.jpashoop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
class MemberRepositoryTest {
    @Autowired MemberRepository memberRepository;

      @Test
      @Transactional
      @Rollback(false)
      public void testMember() throws Exception {
          //given
          Member member = new Member();
          member.setUserName("memberA");

          //when
          Long savedId = memberRepository.save(member);
          Member findMember = memberRepository.find(savedId);

          //then
          Assertions.assertEquals(findMember.getId(), member.getId());
          Assertions.assertEquals(findMember.getUserName(), member.getUserName());
          Assertions.assertEquals(findMember, member);

          System.out.println("같니?" + (findMember == member)); // 같음
      }
}