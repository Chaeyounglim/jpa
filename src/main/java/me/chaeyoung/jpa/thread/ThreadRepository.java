package me.chaeyoung.jpa.thread;

import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = Thread.class, idClass = Long.class)

public interface ThreadRepository {

}