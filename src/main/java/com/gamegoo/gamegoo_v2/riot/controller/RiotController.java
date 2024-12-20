package com.gamegoo.gamegoo_v2.riot.controller;

import com.gamegoo.gamegoo_v2.common.ApiResponse;
import com.gamegoo.gamegoo_v2.riot.dto.RiotVerifyExistUserRequest;
import com.gamegoo.gamegoo_v2.riot.service.RiotFacadeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Riot", description = "Riot 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/riot")
@Slf4j
@Validated
public class RiotController {

    private final RiotFacadeService riotFacadeService;

    @PostMapping("/verify")
    @Operation(summary = "실제 존재하는 Riot 계정인지 검증하는 API", description = "API for verifying account by riot API")
    public ApiResponse<String> VerifyRiot(@RequestBody @Valid RiotVerifyExistUserRequest request) {
        riotFacadeService.verifyRiotAccount(request);

        return ApiResponse.ok("해당 Riot 계정은 존재합니다.");
    }

}
