package me.chaeyoung.jpastudy.comment;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.chaeyoung.jpastudy.emotion.CommentEmotion;
import me.chaeyoung.jpastudy.mention.CommentMention;
import me.chaeyoung.jpastudy.thread.Thread;
import me.chaeyoung.jpastudy.user.User;

import java.util.LinkedHashSet;
import java.util.Set;

// lombok
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

// jpa
@Entity
@Table
public class Comment {

    @Id
    @Getter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String message;

    @Builder
    public Comment(String message) {
        this.message = message;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "thread_id")
    Thread thread;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<CommentMention> mentions = new LinkedHashSet<>();

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<CommentEmotion> emotions = new LinkedHashSet<>();


    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addEmotion(User user, String body) {
        var emotion = CommentEmotion.builder().user(user).body(body).comment(this).build();
        this.emotions.add(emotion);
    }

}
