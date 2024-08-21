package is.farmhan.controller;

import is.farmhan.dto.request.LoginRequestDto;
import is.farmhan.dto.request.SignUpRequestDto;
import is.farmhan.dto.response.LoginResponseDto;
import is.farmhan.dto.response.ResponseDto;
import is.farmhan.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseDto<Boolean> userLogin(@RequestBody LoginRequestDto loginRequestDto){
        return new ResponseDto<>(userService.login(loginRequestDto));
    }

    @PostMapping("/signup")
    public ResponseDto<Boolean> userSignup(@RequestBody SignUpRequestDto signUpRequestDto){
        return new ResponseDto<>(userService.signup(signUpRequestDto));
    }


}
