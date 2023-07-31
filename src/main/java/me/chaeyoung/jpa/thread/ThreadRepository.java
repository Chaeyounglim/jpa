package me.chaeyoung.jpa.thread;

import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryDefinition(domainClass = Thread.class, idClass = Long.class)

public interface ThreadRepository extends JpaRepository<Thread, Long> {

}