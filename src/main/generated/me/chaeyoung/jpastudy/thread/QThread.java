package me.chaeyoung.jpastudy.thread;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QThread is a Querydsl query type for Thread
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QThread extends EntityPathBase<Thread> {

    private static final long serialVersionUID = 2074366307L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QThread thread = new QThread("thread");

    public final me.chaeyoung.jpastudy.common.QTimestamp _super = new me.chaeyoung.jpastudy.common.QTimestamp(this);

    public final me.chaeyoung.jpastudy.channel.QChannel channel;

    public final SetPath<me.chaeyoung.jpastudy.comment.Comment, me.chaeyoung.jpastudy.comment.QComment> comments = this.<me.chaeyoung.jpastudy.comment.Comment, me.chaeyoung.jpastudy.comment.QComment>createSet("comments", me.chaeyoung.jpastudy.comment.Comment.class, me.chaeyoung.jpastudy.comment.QComment.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final SetPath<me.chaeyoung.jpastudy.emotion.ThreadEmotion, me.chaeyoung.jpastudy.emotion.QThreadEmotion> emotions = this.<me.chaeyoung.jpastudy.emotion.ThreadEmotion, me.chaeyoung.jpastudy.emotion.QThreadEmotion>createSet("emotions", me.chaeyoung.jpastudy.emotion.ThreadEmotion.class, me.chaeyoung.jpastudy.emotion.QThreadEmotion.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final SetPath<me.chaeyoung.jpastudy.mention.ThreadMention, me.chaeyoung.jpastudy.mention.QThreadMention> mentions = this.<me.chaeyoung.jpastudy.mention.ThreadMention, me.chaeyoung.jpastudy.mention.QThreadMention>createSet("mentions", me.chaeyoung.jpastudy.mention.ThreadMention.class, me.chaeyoung.jpastudy.mention.QThreadMention.class, PathInits.DIRECT2);

    public final StringPath message = createString("message");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final me.chaeyoung.jpastudy.user.QUser user;

    public QThread(String variable) {
        this(Thread.class, forVariable(variable), INITS);
    }

    public QThread(Path<? extends Thread> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QThread(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QThread(PathMetadata metadata, PathInits inits) {
        this(Thread.class, metadata, inits);
    }

    public QThread(Class<? extends Thread> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.channel = inits.isInitialized("channel") ? new me.chaeyoung.jpastudy.channel.QChannel(forProperty("channel")) : null;
        this.user = inits.isInitialized("user") ? new me.chaeyoung.jpastudy.user.QUser(forProperty("user")) : null;
    }

}

