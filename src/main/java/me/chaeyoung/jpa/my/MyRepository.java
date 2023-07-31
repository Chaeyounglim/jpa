package me.chaeyoung.jpa.my;

import java.util.List;

public interface MyRepository {

//  void delete(T entity);

  List<String> findNameAll();

}
