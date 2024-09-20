package is.farmhan.controller;

import is.farmhan.dto.request.CallRequestDto;
import is.farmhan.dto.response.CallResponseDto;
import is.farmhan.dto.response.CallStartResponseDto;
import is.farmhan.dto.response.ResponseDto;
import is.farmhan.service.CallService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CallController {

    private final CallService callService;

    @PostMapping("/call/start/{userId}")
    public ResponseDto<CallStartResponseDto> callStart(@PathVariable Long userId){
        return new ResponseDto<>(callService.startCall(userId));
    }

    @PostMapping("/call")
    public ResponseDto<CallResponseDto> call(@RequestBody CallRequestDto callRequestDto){
        return new ResponseDto<>(callService.call(callRequestDto));
    }
    @PostMapping("/call-v2")
    public ResponseDto<CallResponseDto> callV2(@RequestBody CallRequestDto callRequestDto){
        return new ResponseDto<>(callService.callV2(callRequestDto));
    }
    @PostMapping("/call-v3")
    public ResponseDto<CallResponseDto> callV3(@RequestBody CallRequestDto callRequestDto){
        return new ResponseDto<>(callService.callV3(callRequestDto));
    }


}
