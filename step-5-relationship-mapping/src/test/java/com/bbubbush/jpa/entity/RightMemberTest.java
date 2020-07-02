package com.bbubbush.jpa.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.junit.Assert.assertTrue;

public class RightMemberTest {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("bbubbush");

    /**
     * Name: setUp
     * Date: 2020/07/02
     * Info:
     *  [기초 데이터 저장]
     */
    @Before
    public void setUp() {
        setDefaultData();
    }

    /**
     * Name: save
     * Date: 2020/06/21
     * Info:
     *  [OOP 객체 모델링 - 저장]
     */
    @Test
    public void save() {
        // given
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        // when
        tx.begin();
        try {
            RightTeam team = new RightTeam();
            team.setName("Team GgobukGgobuk");
            em.persist(team);

            RightMember member = new RightMember();
            member.setName("sinsa");
            member.setTeam(team);
            em.persist(member);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }

        // then - 형식적인 결과 확인
        assertTrue(true);
    }

    private void setDefaultData(){
        // given
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        // when
        tx.begin();
        try {
            RightTeam teamA = new RightTeam();
            teamA.setName("Team Pika");
            em.persist(teamA);

            RightMember memberA = new RightMember();
            memberA.setName("bbubbush");
            memberA.setTeam(teamA);
            em.persist(memberA);

            RightTeam teamB = new RightTeam();
            teamB.setName("Team CC");
            em.persist(teamB);

            RightMember memberB = new RightMember();
            memberB.setName("junu");
            memberB.setTeam(teamB);
            em.persist(memberB);

            RightTeam teamC = new RightTeam();
            teamC.setName("Team PaiPai");
            em.persist(teamC);

            RightMember memberC = new RightMember();
            memberC.setName("imesung");
            memberC.setTeam(teamC);
            em.persist(memberC);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }

    @After
    public void destroy() {
        emf.close();
    }
}