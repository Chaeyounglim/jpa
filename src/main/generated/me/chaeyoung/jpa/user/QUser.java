package me.chaeyoung.jpa.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 851022918L;

    public static final QUser user = new QUser("user");

    public final SetPath<me.chaeyoung.jpa.mention.CommentMention, me.chaeyoung.jpa.mention.QCommentMention> commentMentions = this.<me.chaeyoung.jpa.mention.CommentMention, me.chaeyoung.jpa.mention.QCommentMention>createSet("commentMentions", me.chaeyoung.jpa.mention.CommentMention.class, me.chaeyoung.jpa.mention.QCommentMention.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath password = createString("password");

    public final SetPath<me.chaeyoung.jpa.mention.ThreadMention, me.chaeyoung.jpa.mention.QThreadMention> threadMentions = this.<me.chaeyoung.jpa.mention.ThreadMention, me.chaeyoung.jpa.mention.QThreadMention>createSet("threadMentions", me.chaeyoung.jpa.mention.ThreadMention.class, me.chaeyoung.jpa.mention.QThreadMention.class, PathInits.DIRECT2);

    public final SetPath<me.chaeyoung.jpa.userChannel.UserChannel, me.chaeyoung.jpa.userChannel.QUserChannel> userChannels = this.<me.chaeyoung.jpa.userChannel.UserChannel, me.chaeyoung.jpa.userChannel.QUserChannel>createSet("userChannels", me.chaeyoung.jpa.userChannel.UserChannel.class, me.chaeyoung.jpa.userChannel.QUserChannel.class, PathInits.DIRECT2);

    public final StringPath username = createString("username");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

