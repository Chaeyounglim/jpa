package me.chaeyoung.jpa.emotion;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEmotion is a Querydsl query type for Emotion
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QEmotion extends EntityPathBase<Emotion> {

    private static final long serialVersionUID = -367711296L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEmotion emotion = new QEmotion("emotion");

    public final StringPath body = createString("body");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final me.chaeyoung.jpa.user.QUser user;

    public QEmotion(String variable) {
        this(Emotion.class, forVariable(variable), INITS);
    }

    public QEmotion(Path<? extends Emotion> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEmotion(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEmotion(PathMetadata metadata, PathInits inits) {
        this(Emotion.class, metadata, inits);
    }

    public QEmotion(Class<? extends Emotion> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new me.chaeyoung.jpa.user.QUser(forProperty("user")) : null;
    }

}

