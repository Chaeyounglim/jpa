package me.chaeyoung.jpastudy.mention;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMentionId is a Querydsl query type for MentionId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QMentionId extends BeanPath<MentionId> {

    private static final long serialVersionUID = 1377129942L;

    public static final QMentionId mentionId = new QMentionId("mentionId");

    public final NumberPath<Long> threadId = createNumber("threadId", Long.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QMentionId(String variable) {
        super(MentionId.class, forVariable(variable));
    }

    public QMentionId(Path<? extends MentionId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMentionId(PathMetadata metadata) {
        super(MentionId.class, metadata);
    }

}

