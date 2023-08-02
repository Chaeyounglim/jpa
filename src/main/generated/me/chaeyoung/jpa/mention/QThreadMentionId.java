package me.chaeyoung.jpa.mention;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QThreadMentionId is a Querydsl query type for ThreadMentionId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QThreadMentionId extends BeanPath<ThreadMentionId> {

    private static final long serialVersionUID = 973891503L;

    public static final QThreadMentionId threadMentionId = new QThreadMentionId("threadMentionId");

    public final NumberPath<Long> threadId = createNumber("threadId", Long.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QThreadMentionId(String variable) {
        super(ThreadMentionId.class, forVariable(variable));
    }

    public QThreadMentionId(Path<? extends ThreadMentionId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QThreadMentionId(PathMetadata metadata) {
        super(ThreadMentionId.class, metadata);
    }

}

