package me.chaeyoung.jpa.emotion;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QThreadEmotion is a Querydsl query type for ThreadEmotion
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QThreadEmotion extends EntityPathBase<ThreadEmotion> {

    private static final long serialVersionUID = 254662294L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QThreadEmotion threadEmotion = new QThreadEmotion("threadEmotion");

    public final QEmotion _super;

    //inherited
    public final StringPath body;

    //inherited
    public final NumberPath<Long> id;

    public final me.chaeyoung.jpa.thread.QThread thread;

    // inherited
    public final me.chaeyoung.jpa.user.QUser user;

    public QThreadEmotion(String variable) {
        this(ThreadEmotion.class, forVariable(variable), INITS);
    }

    public QThreadEmotion(Path<? extends ThreadEmotion> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QThreadEmotion(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QThreadEmotion(PathMetadata metadata, PathInits inits) {
        this(ThreadEmotion.class, metadata, inits);
    }

    public QThreadEmotion(Class<? extends ThreadEmotion> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QEmotion(type, metadata, inits);
        this.body = _super.body;
        this.id = _super.id;
        this.thread = inits.isInitialized("thread") ? new me.chaeyoung.jpa.thread.QThread(forProperty("thread"), inits.get("thread")) : null;
        this.user = _super.user;
    }

}

