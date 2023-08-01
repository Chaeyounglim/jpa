package me.chaeyoung.jpa.userChannel;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserChannel is a Querydsl query type for UserChannel
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserChannel extends EntityPathBase<UserChannel> {

    private static final long serialVersionUID = -769720710L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserChannel userChannel = new QUserChannel("userChannel");

    public final me.chaeyoung.jpa.channel.QChannel channel;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final me.chaeyoung.jpa.user.QUser user;

    public QUserChannel(String variable) {
        this(UserChannel.class, forVariable(variable), INITS);
    }

    public QUserChannel(Path<? extends UserChannel> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserChannel(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserChannel(PathMetadata metadata, PathInits inits) {
        this(UserChannel.class, metadata, inits);
    }

    public QUserChannel(Class<? extends UserChannel> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.channel = inits.isInitialized("channel") ? new me.chaeyoung.jpa.channel.QChannel(forProperty("channel")) : null;
        this.user = inits.isInitialized("user") ? new me.chaeyoung.jpa.user.QUser(forProperty("user")) : null;
    }

}

