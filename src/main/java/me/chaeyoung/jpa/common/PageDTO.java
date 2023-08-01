package me.chaeyoung.jpa.common;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


@RequiredArgsConstructor
@AllArgsConstructor
public class PageDTO {

  private final Integer currentPage;

  private final Integer size;
  private String sortBy;

  public Pageable toPageable() {
    return PageRequest.of(currentPage - 1, size, Sort.by(sortBy).descending());
    // 한 페이지에 (size)개씩
  }

}
