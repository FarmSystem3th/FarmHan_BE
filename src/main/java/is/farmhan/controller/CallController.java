package is.farmhan.controller;

import is.farmhan.dto.request.CallRequestDto;
import is.farmhan.dto.response.CallResponseDto;
import is.farmhan.dto.response.CallStartResponseDto;
import is.farmhan.dto.response.ResponseDto;
import is.farmhan.service.CallService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CallController {

    private final CallService callService;

    @PostMapping("/call/start")
    public ResponseDto<CallStartResponseDto> callStart(@RequestParam Long userId){
        return new ResponseDto<>(callService.startCall(userId));
    }

    @PostMapping("/call")
    public ResponseDto<CallResponseDto> call(@RequestBody CallRequestDto callRequestDto){
        return new ResponseDto<>(callService.call(callRequestDto));
    }


}
