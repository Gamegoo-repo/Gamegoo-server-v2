package com.gamegoo.gamegoo_v2.friend.service;

import com.gamegoo.gamegoo_v2.friend.domain.Friend;
import com.gamegoo.gamegoo_v2.friend.domain.FriendRequest;
import com.gamegoo.gamegoo_v2.friend.dto.FriendRequestResponse;
import com.gamegoo.gamegoo_v2.friend.dto.StarFriendResponse;
import com.gamegoo.gamegoo_v2.member.domain.Member;
import com.gamegoo.gamegoo_v2.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FriendFacadeService {

    private final FriendService friendService;
    private final MemberService memberService;

    /**
     * 친구 요청 전송 Facade 메소드
     *
     * @param member
     * @param targetMemberId
     * @return
     */
    @Transactional
    public FriendRequestResponse sendFriendRequest(Member member, Long targetMemberId) {
        Member targetMember = memberService.findMember(targetMemberId);
        FriendRequest friendRequest = friendService.sendFriendRequest(member, targetMember);

        return FriendRequestResponse.of(friendRequest.getToMember().getId(), "친구 요청 전송 성공");
    }

    /**
     * 친구 요청 수락 Facade 메소드
     *
     * @param member
     * @param targetMemberId
     * @return
     */
    @Transactional
    public FriendRequestResponse acceptFriendRequest(Member member, Long targetMemberId) {
        Member targetMember = memberService.findMember(targetMemberId);
        FriendRequest friendRequest = friendService.acceptFriendRequest(member, targetMember);

        return FriendRequestResponse.of(friendRequest.getFromMember().getId(), "친구 요청 수락 성공");
    }

    /**
     * 친구 즐겨찾기 설정/해제 Facade 메소드
     *
     * @param member
     * @param friendMemberId
     * @return
     */
    @Transactional
    public StarFriendResponse reverseFriendLiked(Member member, Long friendMemberId) {
        Member friendMember = memberService.findMember(friendMemberId);
        Friend friend = friendService.reverseFriendLiked(member, friendMember);

        return StarFriendResponse.of(friend);
    }

}
