package me.chaeyoung.jpastudy.channel;

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

    private static final long serialVersionUID = -447591283L;

    public static final QChannel channel = new QChannel("channel");

    public final me.chaeyoung.jpastudy.common.QTimestamp _super = new me.chaeyoung.jpastudy.common.QTimestamp(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath name = createString("name");

    public final SetPath<me.chaeyoung.jpastudy.thread.Thread, me.chaeyoung.jpastudy.thread.QThread> threads = this.<me.chaeyoung.jpastudy.thread.Thread, me.chaeyoung.jpastudy.thread.QThread>createSet("threads", me.chaeyoung.jpastudy.thread.Thread.class, me.chaeyoung.jpastudy.thread.QThread.class, PathInits.DIRECT2);

    public final EnumPath<Channel.Type> type = createEnum("type", Channel.Type.class);

    public final SetPath<me.chaeyoung.jpastudy.userChannel.UserChannel, me.chaeyoung.jpastudy.userChannel.QUserChannel> userChannels = this.<me.chaeyoung.jpastudy.userChannel.UserChannel, me.chaeyoung.jpastudy.userChannel.QUserChannel>createSet("userChannels", me.chaeyoung.jpastudy.userChannel.UserChannel.class, me.chaeyoung.jpastudy.userChannel.QUserChannel.class, PathInits.DIRECT2);

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

