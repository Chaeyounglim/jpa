package me.chaeyoung.jpastudy.userChannel;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserChannelId is a Querydsl query type for UserChannelId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QUserChannelId extends BeanPath<UserChannelId> {

    private static final long serialVersionUID = 172451954L;

    public static final QUserChannelId userChannelId = new QUserChannelId("userChannelId");

    public final NumberPath<Long> channelId = createNumber("channelId", Long.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QUserChannelId(String variable) {
        super(UserChannelId.class, forVariable(variable));
    }

    public QUserChannelId(Path<? extends UserChannelId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserChannelId(PathMetadata metadata) {
        super(UserChannelId.class, metadata);
    }

}

