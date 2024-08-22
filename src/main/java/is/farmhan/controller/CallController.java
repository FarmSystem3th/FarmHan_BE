package is.farmhan.controller;

import is.farmhan.dto.response.CallStartResponseDto;
import is.farmhan.dto.response.ResponseDto;
import is.farmhan.service.CallService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CallController {

    private final CallService callService;

    @PostMapping("/start")
    public ResponseDto<CallStartResponseDto> callStart(@RequestParam Long userId){
        return new ResponseDto<>(callService.startCall(userId));
    }

}
