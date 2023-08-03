package me.chaeyoung.jpastudy.mention;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QThreadMention is a Querydsl query type for ThreadMention
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QThreadMention extends EntityPathBase<ThreadMention> {

    private static final long serialVersionUID = -551114447L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QThreadMention threadMention = new QThreadMention("threadMention");

    public final me.chaeyoung.jpastudy.common.QTimestamp _super = new me.chaeyoung.jpastudy.common.QTimestamp(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final me.chaeyoung.jpastudy.thread.QThread thread;

    public final QThreadMentionId threadMentionId;

    public final me.chaeyoung.jpastudy.user.QUser user;

    public QThreadMention(String variable) {
        this(ThreadMention.class, forVariable(variable), INITS);
    }

    public QThreadMention(Path<? extends ThreadMention> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QThreadMention(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QThreadMention(PathMetadata metadata, PathInits inits) {
        this(ThreadMention.class, metadata, inits);
    }

    public QThreadMention(Class<? extends ThreadMention> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.thread = inits.isInitialized("thread") ? new me.chaeyoung.jpastudy.thread.QThread(forProperty("thread"), inits.get("thread")) : null;
        this.threadMentionId = inits.isInitialized("threadMentionId") ? new QThreadMentionId(forProperty("threadMentionId")) : null;
        this.user = inits.isInitialized("user") ? new me.chaeyoung.jpastudy.user.QUser(forProperty("user")) : null;
    }

}

