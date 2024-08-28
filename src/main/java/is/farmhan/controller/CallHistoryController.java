package is.farmhan.controller;

import is.farmhan.dto.request.CallHistoryRequestDto;
import is.farmhan.dto.response.ResponseDto;
import is.farmhan.service.CallHistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CallHistoryController {

    private final CallHistoryService callHistoryService;

    @GetMapping("/mypage/call-list/{userId}")
    public ResponseDto<Map<String, Object>> callHistoryList(@PathVariable Long userId){
        return new ResponseDto<>(callHistoryService.callHistoryList(userId));
    }
}
