package me.chaeyoung.jpa.my;

import jakarta.persistence.EntityManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class MyRepositoryImpl implements MyRepository {

  @Autowired
  EntityManager entityManager;
/*
  @Override
  public void delete(User user) {
    System.out.println("delete force");
    entityManager.remove(user);
  }*/

  @Override
  public List<String> findNameAll() {
    return entityManager.createQuery("SELECT u.username FROM User AS u", String.class)
        .getResultList();
  }
}