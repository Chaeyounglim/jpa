package me.chaeyoung.jpastudy.common;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class PageDTO {

  private final Integer currentPage;
  private final Integer size;
  private String sortBy;

  public Pageable toPageable() {
    if (Objects.isNull(sortBy)) {
      return PageRequest.of(currentPage - 1, size);
    }
    return PageRequest.of(currentPage - 1, size, Sort.by(sortBy).descending());
  }

}
