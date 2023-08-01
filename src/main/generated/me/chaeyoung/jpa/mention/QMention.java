package me.chaeyoung.jpa.mention;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMention is a Querydsl query type for Mention
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMention extends EntityPathBase<Mention> {

    private static final long serialVersionUID = 1425811422L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMention mention = new QMention("mention");

    public final me.chaeyoung.jpa.common.QTimeStamp _super;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt;

    // inherited
    public final me.chaeyoung.jpa.user.QUser createdBy;

    public final QMentionId mentionId;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt;

    // inherited
    public final me.chaeyoung.jpa.user.QUser modifiedBy;

    public final me.chaeyoung.jpa.thread.QThread thread;

    public final me.chaeyoung.jpa.user.QUser user;

    public QMention(String variable) {
        this(Mention.class, forVariable(variable), INITS);
    }

    public QMention(Path<? extends Mention> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMention(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMention(PathMetadata metadata, PathInits inits) {
        this(Mention.class, metadata, inits);
    }

    public QMention(Class<? extends Mention> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new me.chaeyoung.jpa.common.QTimeStamp(type, metadata, inits);
        this.createdAt = _super.createdAt;
        this.createdBy = _super.createdBy;
        this.mentionId = inits.isInitialized("mentionId") ? new QMentionId(forProperty("mentionId")) : null;
        this.modifiedAt = _super.modifiedAt;
        this.modifiedBy = _super.modifiedBy;
        this.thread = inits.isInitialized("thread") ? new me.chaeyoung.jpa.thread.QThread(forProperty("thread"), inits.get("thread")) : null;
        this.user = inits.isInitialized("user") ? new me.chaeyoung.jpa.user.QUser(forProperty("user")) : null;
    }

}

