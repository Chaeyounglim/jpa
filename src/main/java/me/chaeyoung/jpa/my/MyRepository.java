package me.chaeyoung.jpa.my;

public interface MyRepository<T> {

  void delete(T entity);

}
