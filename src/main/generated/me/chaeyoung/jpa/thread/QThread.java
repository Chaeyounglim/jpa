package me.chaeyoung.jpa.thread;

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

    private static final long serialVersionUID = 2094204582L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QThread thread = new QThread("thread");

    public final me.chaeyoung.jpa.common.QTimeStamp _super = new me.chaeyoung.jpa.common.QTimeStamp(this);

    public final me.chaeyoung.jpa.channel.QChannel channel;

    public final SetPath<me.chaeyoung.jpa.comment.Comment, me.chaeyoung.jpa.comment.QComment> comments = this.<me.chaeyoung.jpa.comment.Comment, me.chaeyoung.jpa.comment.QComment>createSet("comments", me.chaeyoung.jpa.comment.Comment.class, me.chaeyoung.jpa.comment.QComment.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final SetPath<me.chaeyoung.jpa.emotion.ThreadEmotion, me.chaeyoung.jpa.emotion.QThreadEmotion> emotions = this.<me.chaeyoung.jpa.emotion.ThreadEmotion, me.chaeyoung.jpa.emotion.QThreadEmotion>createSet("emotions", me.chaeyoung.jpa.emotion.ThreadEmotion.class, me.chaeyoung.jpa.emotion.QThreadEmotion.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final SetPath<me.chaeyoung.jpa.mention.ThreadMention, me.chaeyoung.jpa.mention.QThreadMention> mentions = this.<me.chaeyoung.jpa.mention.ThreadMention, me.chaeyoung.jpa.mention.QThreadMention>createSet("mentions", me.chaeyoung.jpa.mention.ThreadMention.class, me.chaeyoung.jpa.mention.QThreadMention.class, PathInits.DIRECT2);

    public final StringPath message = createString("message");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

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
        this.channel = inits.isInitialized("channel") ? new me.chaeyoung.jpa.channel.QChannel(forProperty("channel")) : null;
    }

}

