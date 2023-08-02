package me.chaeyoung.jpa.comment;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QComment is a Querydsl query type for Comment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QComment extends EntityPathBase<Comment> {

    private static final long serialVersionUID = -1300986936L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QComment comment = new QComment("comment");

    public final SetPath<me.chaeyoung.jpa.emotion.CommentEmotion, me.chaeyoung.jpa.emotion.QCommentEmotion> emotions = this.<me.chaeyoung.jpa.emotion.CommentEmotion, me.chaeyoung.jpa.emotion.QCommentEmotion>createSet("emotions", me.chaeyoung.jpa.emotion.CommentEmotion.class, me.chaeyoung.jpa.emotion.QCommentEmotion.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final SetPath<me.chaeyoung.jpa.mention.CommentMention, me.chaeyoung.jpa.mention.QCommentMention> mentions = this.<me.chaeyoung.jpa.mention.CommentMention, me.chaeyoung.jpa.mention.QCommentMention>createSet("mentions", me.chaeyoung.jpa.mention.CommentMention.class, me.chaeyoung.jpa.mention.QCommentMention.class, PathInits.DIRECT2);

    public final StringPath message = createString("message");

    public final me.chaeyoung.jpa.thread.QThread thread;

    public QComment(String variable) {
        this(Comment.class, forVariable(variable), INITS);
    }

    public QComment(Path<? extends Comment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QComment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QComment(PathMetadata metadata, PathInits inits) {
        this(Comment.class, metadata, inits);
    }

    public QComment(Class<? extends Comment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.thread = inits.isInitialized("thread") ? new me.chaeyoung.jpa.thread.QThread(forProperty("thread"), inits.get("thread")) : null;
    }

}

