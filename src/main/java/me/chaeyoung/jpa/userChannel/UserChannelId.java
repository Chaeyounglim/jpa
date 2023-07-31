package me.chaeyoung.jpa.userChannel;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class UserChannelId implements Serializable {
    // Serializable 는 id로 설정하기 위해 반드시 필요함.
    @Column(name="user_id")
    private Long userId; // UserChannel 의 user 필드명과 동일 해야 함.
    @Column(name="channel_id")
    private Long channelId; // UserChannel 의 channel 필드명과 동일 해야 함.

    @Override
    public boolean equals(Object e){
        if (this == e) return true;
        if (e == null || getClass() != e.getClass()) return false;
        UserChannelId userChannelId = (UserChannelId) e;
        return Objects.equals(getUserId(), userChannelId.getUserId()) && Objects.equals(getChannelId()
                , userChannelId.getChannelId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getChannelId());
    }


}
