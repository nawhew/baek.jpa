package com.inflearn.baek.jpa.commons;

import com.inflearn.baek.jpa.account.Account;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Component
@Transactional
@Slf4j
public class JpaRunner implements ApplicationRunner {

    @Autowired
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Account account = new Account();
        account.setUsername("we");
        account.setPassword("jpa");

        entityManager.persist(account);
        log.info("persist ok : " + entityManager.find(Account.class, account.getId()));


        Account account2 = new Account();
        account2.setUsername("we2");
        account2.setPassword("jpa2");

        Session session = entityManager.unwrap(Session.class);
        session.save(account2);
        log.info("persist ok : " + session.find(Account.class, 2L));
    }
}
