package me.chaeyoung.jpastudy.mention;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCommentMention is a Querydsl query type for CommentMention
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCommentMention extends EntityPathBase<CommentMention> {

    private static final long serialVersionUID = 1981137914L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCommentMention commentMention = new QCommentMention("commentMention");

    public final me.chaeyoung.jpastudy.common.QTimestamp _super = new me.chaeyoung.jpastudy.common.QTimestamp(this);

    public final me.chaeyoung.jpastudy.comment.QComment comment;

    public final QCommentMentionId commentMentionId;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final me.chaeyoung.jpastudy.user.QUser user;

    public QCommentMention(String variable) {
        this(CommentMention.class, forVariable(variable), INITS);
    }

    public QCommentMention(Path<? extends CommentMention> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCommentMention(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCommentMention(PathMetadata metadata, PathInits inits) {
        this(CommentMention.class, metadata, inits);
    }

    public QCommentMention(Class<? extends CommentMention> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.comment = inits.isInitialized("comment") ? new me.chaeyoung.jpastudy.comment.QComment(forProperty("comment"), inits.get("comment")) : null;
        this.commentMentionId = inits.isInitialized("commentMentionId") ? new QCommentMentionId(forProperty("commentMentionId")) : null;
        this.user = inits.isInitialized("user") ? new me.chaeyoung.jpastudy.user.QUser(forProperty("user")) : null;
    }

}

