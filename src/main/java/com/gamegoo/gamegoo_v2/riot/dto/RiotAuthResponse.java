package com.gamegoo.gamegoo_v2.riot.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RiotAuthResponse {

    String puuid;
    String gameName;
    String tagLine;

}