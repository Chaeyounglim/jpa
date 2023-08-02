package me.chaeyoung.jpa.thread;

import static me.chaeyoung.jpa.thread.QThread.thread;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

@RequiredArgsConstructor
public class ThreadRepositoryQueryImpl implements ThreadRepositoryQuery {

  private final JPAQueryFactory jpaQueryFactory;


  @Override
  public Page<Thread> search(ThreadSearchCond cond, Pageable pageable) {
    var query = query(thread, cond)
        .offset(pageable.getOffset())
        .limit(pageable.getPageSize());

    // 실제로 받아올 스레드는 query()를 fetch()만 하면 됨.
    var threads = query.fetch();
    long totalSize = countQuery(cond).fetch().get(0);

    threads.stream()
        .map(Thread::getComments)
        .forEach(comments -> comments
            .forEach(comment -> Hibernate.initialize(comment.getEmotions())));

    // PageableExecutionUtils.getPage() 메서드를 통해서 threads 를 페이징 객체로 감싸서 반환
    return PageableExecutionUtils.getPage(threads, pageable, () -> totalSize);
  }

  private <T> JPAQuery<T> query(Expression<T> expr, ThreadSearchCond cond) {
    // jpaQueryFactory.select() 메서드와 형태 동일하게 구성함.
    return jpaQueryFactory.select(expr)
        .from(thread)
        .leftJoin(thread.channel).fetchJoin()
        .leftJoin(thread.emotions).fetchJoin()
        .leftJoin(thread.comments).fetchJoin()
        // fetchJoin() 으로 해야 LAZY 로 설정된 애를 조회해 옴.
        .where(
            // getChannelId 과 getMentionedUserId 가 null 이면 에러 발생
            this.channelIdEq(cond.getChannelId()),
            this.mentionedUserIdEq(cond.getMentionedUserId())
        );
  }

  private JPAQuery<Long> countQuery(ThreadSearchCond cond) {
    // jpaQueryFactory.select() 메서드와 형태 동일하게 구성함.
    // Wildcard.count 는 count 쿼리를 날린다는 의미
    return jpaQueryFactory.select(Wildcard.count)
        .from(thread)
        .where(
            this.channelIdEq(cond.getChannelId()),
            this.mentionedUserIdEq(cond.getMentionedUserId())
        );
  }

  // query() 메서드에 getChannelId 과 getMentionedUserId 가 null 이면 에러 발생
  // 하므로 이를 체크해주는 메서드임
  // eq() 메서드는 반환값이 BooleanExpression 임.
  private BooleanExpression channelIdEq(Long channelId) {
    // channelId가 null 이 아니라면 전자 실행 후 반환 , null 이면 null 을 반환
    return Objects.nonNull(channelId) ? thread.channel.id.eq(channelId) : null;
  }

  private BooleanExpression mentionedUserIdEq(Long mentionedUserId) {
    return Objects.nonNull(mentionedUserId) ? thread.mentions.any().user.id.eq(mentionedUserId)
        : null;
  }
}
