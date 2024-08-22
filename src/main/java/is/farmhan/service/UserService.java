package is.farmhan.service;

import is.farmhan.domain.User;
import is.farmhan.dto.request.LoginRequestDto;
import is.farmhan.dto.request.SignUpRequestDto;
import is.farmhan.dto.response.LoginResponseDto;
import is.farmhan.dto.response.MypageResponseDto;
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

    public LoginResponseDto login(LoginRequestDto loginRequestDto){

        User user = userRepository.findByUserLoginId(loginRequestDto.getLoginId())
                .orElseThrow(() -> new ApiException(ErrorDefine.USER_NOT_FOUND));

        if(user.getUserPassword().equals(loginRequestDto.getUserPassword())){

            return LoginResponseDto.of(user);

        } else throw new ApiException(ErrorDefine.USER_NOT_FOUND);

    }
    public Boolean signup(SignUpRequestDto signUpRequestDto){

        userRepository.save(signUpRequestDto.toEntity(signUpRequestDto));
        return true;
    }

    public MypageResponseDto myPage(Long userId){

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ApiException(ErrorDefine.USER_NOT_FOUND));

        return MypageResponseDto.of(user);
    }

}
