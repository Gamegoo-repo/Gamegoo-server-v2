package com.gamegoo.gamegoo_v2.friend.dto;

import com.gamegoo.gamegoo_v2.friend.domain.Friend;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FriendInfoResponse {

    Long memberId;
    String name;
    int profileImg;
    boolean isLiked;
    boolean isBlind;

    public static FriendInfoResponse of(Friend friend) {
        String name = friend.getToMember().isBlind() ? "(탈퇴한 사용자)" : friend.getToMember().getGameName();
        return FriendInfoResponse.builder()
                .memberId(friend.getToMember().getId())
                .profileImg(friend.getToMember().getProfileImage())
                .name(name)
                .isLiked(friend.isLiked())
                .isBlind(friend.getToMember().isBlind())
                .build();
    }

}
