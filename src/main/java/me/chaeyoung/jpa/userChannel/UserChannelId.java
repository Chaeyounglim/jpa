package me.chaeyoung.jpa.userChannel;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserChannelId implements Serializable {
    // Serializable 는 id로 설정하기 위해 반드시 필요함.
    private Long user; // UserChannel 의 user 필드명과 동일 해야 함.
    private Long channel; // UserChannel 의 channel 필드명과 동일 해야 함.

    @Override
    public boolean equals(Object e){
        if (this == e) return true;
        if (e == null || getClass() != e.getClass()) return false;
        UserChannelId userChannelId = (UserChannelId) e;
        return Objects.equals(getUser(), userChannelId.getUser()) && Objects.equals(getChannel()
                , userChannelId.getChannel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getChannel());
    }
}
