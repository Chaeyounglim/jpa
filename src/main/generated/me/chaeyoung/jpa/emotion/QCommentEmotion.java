package me.chaeyoung.jpa.emotion;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCommentEmotion is a Querydsl query type for CommentEmotion
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCommentEmotion extends EntityPathBase<CommentEmotion> {

    private static final long serialVersionUID = 1134164471L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCommentEmotion commentEmotion = new QCommentEmotion("commentEmotion");

    public final QEmotion _super;

    //inherited
    public final StringPath body;

    public final me.chaeyoung.jpa.comment.QComment comment;

    //inherited
    public final NumberPath<Long> id;

    // inherited
    public final me.chaeyoung.jpa.user.QUser user;

    public QCommentEmotion(String variable) {
        this(CommentEmotion.class, forVariable(variable), INITS);
    }

    public QCommentEmotion(Path<? extends CommentEmotion> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCommentEmotion(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCommentEmotion(PathMetadata metadata, PathInits inits) {
        this(CommentEmotion.class, metadata, inits);
    }

    public QCommentEmotion(Class<? extends CommentEmotion> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QEmotion(type, metadata, inits);
        this.body = _super.body;
        this.comment = inits.isInitialized("comment") ? new me.chaeyoung.jpa.comment.QComment(forProperty("comment"), inits.get("comment")) : null;
        this.id = _super.id;
        this.user = _super.user;
    }

}

