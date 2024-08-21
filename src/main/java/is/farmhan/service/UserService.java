package is.farmhan.service;

import is.farmhan.domain.User;
import is.farmhan.dto.request.LoginRequestDto;
import is.farmhan.dto.request.SignUpRequestDto;
import is.farmhan.exeption.ApiException;
import is.farmhan.exeption.ErrorDefine;
import is.farmhan.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Boolean login(LoginRequestDto loginRequestDto){

        User user = userRepository.findByloginId(loginRequestDto.getLoginId())
                .orElseThrow(() -> new ApiException(ErrorDefine.USER_NOT_FOUND));

        if(user.getUserPassword().equals(loginRequestDto.getUserPassword())){
            return true;

        } else throw new ApiException(ErrorDefine.USER_NOT_FOUND);

    }
    public Boolean signup(SignUpRequestDto signUpRequestDto){

        userRepository.save(signUpRequestDto.toEntity(signUpRequestDto));
        return true;
    }
}
