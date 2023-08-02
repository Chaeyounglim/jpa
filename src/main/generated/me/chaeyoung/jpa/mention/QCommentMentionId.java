package me.chaeyoung.jpa.mention;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCommentMentionId is a Querydsl query type for CommentMentionId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QCommentMentionId extends BeanPath<CommentMentionId> {

    private static final long serialVersionUID = -80664174L;

    public static final QCommentMentionId commentMentionId = new QCommentMentionId("commentMentionId");

    public final NumberPath<Long> commentId = createNumber("commentId", Long.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QCommentMentionId(String variable) {
        super(CommentMentionId.class, forVariable(variable));
    }

    public QCommentMentionId(Path<? extends CommentMentionId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCommentMentionId(PathMetadata metadata) {
        super(CommentMentionId.class, metadata);
    }

}

