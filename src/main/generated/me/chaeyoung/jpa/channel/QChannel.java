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

    public static final QChannel channel = new QChannel("channel");

    public final me.chaeyoung.jpa.common.QTimeStamp _super = new me.chaeyoung.jpa.common.QTimeStamp(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath name = createString("name");

    public final SetPath<me.chaeyoung.jpa.thread.Thread, me.chaeyoung.jpa.thread.QThread> threads = this.<me.chaeyoung.jpa.thread.Thread, me.chaeyoung.jpa.thread.QThread>createSet("threads", me.chaeyoung.jpa.thread.Thread.class, me.chaeyoung.jpa.thread.QThread.class, PathInits.DIRECT2);

    public final EnumPath<Channel.Type> type = createEnum("type", Channel.Type.class);

    public final SetPath<me.chaeyoung.jpa.userChannel.UserChannel, me.chaeyoung.jpa.userChannel.QUserChannel> userChannels = this.<me.chaeyoung.jpa.userChannel.UserChannel, me.chaeyoung.jpa.userChannel.QUserChannel>createSet("userChannels", me.chaeyoung.jpa.userChannel.UserChannel.class, me.chaeyoung.jpa.userChannel.QUserChannel.class, PathInits.DIRECT2);

    public QChannel(String variable) {
        super(Channel.class, forVariable(variable));
    }

    public QChannel(Path<? extends Channel> path) {
        super(path.getType(), path.getMetadata());
    }

    public QChannel(PathMetadata metadata) {
        super(Channel.class, metadata);
    }

}

