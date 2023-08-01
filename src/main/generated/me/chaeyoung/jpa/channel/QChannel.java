package me.chaeyoung.jpa.channel;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QChannel is a Querydsl query type for Channel
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QChannel extends EntityPathBase<Channel> {

    private static final long serialVersionUID = 1437121808L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QChannel channel = new QChannel("channel");

    public final me.chaeyoung.jpa.common.QTimeStamp _super;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt;

    // inherited
    public final me.chaeyoung.jpa.user.QUser createdBy;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt;

    // inherited
    public final me.chaeyoung.jpa.user.QUser modifiedBy;

    public final StringPath name = createString("name");

    public final SetPath<me.chaeyoung.jpa.thread.Thread, me.chaeyoung.jpa.thread.QThread> threads = this.<me.chaeyoung.jpa.thread.Thread, me.chaeyoung.jpa.thread.QThread>createSet("threads", me.chaeyoung.jpa.thread.Thread.class, me.chaeyoung.jpa.thread.QThread.class, PathInits.DIRECT2);

    public final EnumPath<Channel.Type> type = createEnum("type", Channel.Type.class);

    public final SetPath<me.chaeyoung.jpa.userChannel.UserChannel, me.chaeyoung.jpa.userChannel.QUserChannel> userChannels = this.<me.chaeyoung.jpa.userChannel.UserChannel, me.chaeyoung.jpa.userChannel.QUserChannel>createSet("userChannels", me.chaeyoung.jpa.userChannel.UserChannel.class, me.chaeyoung.jpa.userChannel.QUserChannel.class, PathInits.DIRECT2);

    public QChannel(String variable) {
        this(Channel.class, forVariable(variable), INITS);
    }

    public QChannel(Path<? extends Channel> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QChannel(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QChannel(PathMetadata metadata, PathInits inits) {
        this(Channel.class, metadata, inits);
    }

    public QChannel(Class<? extends Channel> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new me.chaeyoung.jpa.common.QTimeStamp(type, metadata, inits);
        this.createdAt = _super.createdAt;
        this.createdBy = _super.createdBy;
        this.modifiedAt = _super.modifiedAt;
        this.modifiedBy = _super.modifiedBy;
    }

}

