package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            //저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
//            member.changeTeam(team);   //편의 메서드 changeTeam 생성
            em.persist(member);

            team.addMember(member); //team을 기준으로한 편의 메서드
//            JPA가 읽어드릴 수 있게 선언(순수 객체 상태를 고려해서)
            // 양쪽에 값 추가
//            team.getMembers().add(member);

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());
            List<Member> members = findMember.getTeam().getMembers();

            System.out.println("=========");
            System.out.println("members = " + findMember);
            System.out.println("=========");

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
