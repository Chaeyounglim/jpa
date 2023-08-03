package me.chaeyoung.jpastudy.user;

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

    private static final long serialVersionUID = 1722795395L;

    public static final QUser user = new QUser("user");

    public final SetPath<me.chaeyoung.jpastudy.mention.CommentMention, me.chaeyoung.jpastudy.mention.QCommentMention> commentMentions = this.<me.chaeyoung.jpastudy.mention.CommentMention, me.chaeyoung.jpastudy.mention.QCommentMention>createSet("commentMentions", me.chaeyoung.jpastudy.mention.CommentMention.class, me.chaeyoung.jpastudy.mention.QCommentMention.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath password = createString("password");

    public final SetPath<me.chaeyoung.jpastudy.mention.ThreadMention, me.chaeyoung.jpastudy.mention.QThreadMention> threadMentions = this.<me.chaeyoung.jpastudy.mention.ThreadMention, me.chaeyoung.jpastudy.mention.QThreadMention>createSet("threadMentions", me.chaeyoung.jpastudy.mention.ThreadMention.class, me.chaeyoung.jpastudy.mention.QThreadMention.class, PathInits.DIRECT2);

    public final SetPath<me.chaeyoung.jpastudy.userChannel.UserChannel, me.chaeyoung.jpastudy.userChannel.QUserChannel> userChannels = this.<me.chaeyoung.jpastudy.userChannel.UserChannel, me.chaeyoung.jpastudy.userChannel.QUserChannel>createSet("userChannels", me.chaeyoung.jpastudy.userChannel.UserChannel.class, me.chaeyoung.jpastudy.userChannel.QUserChannel.class, PathInits.DIRECT2);

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

