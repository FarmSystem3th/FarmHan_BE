package is.farmhan.service;

import is.farmhan.domain.DisabledType;
import is.farmhan.domain.User;
import is.farmhan.dto.request.DisabledTypeList;
import is.farmhan.dto.request.LoginRequestDto;
import is.farmhan.dto.request.SignUpRequestDto;
import is.farmhan.dto.response.LoginResponseDto;
import is.farmhan.dto.response.MypageResponseDto;
import is.farmhan.exeption.ApiException;
import is.farmhan.exeption.ErrorDefine;
import is.farmhan.repository.DisabledTypeRepository;
import is.farmhan.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final DisabledTypeRepository disabledTypeRepository;


    public LoginResponseDto login(LoginRequestDto loginRequestDto){

        User user = userRepository.findByUserLoginId(loginRequestDto.getLoginId())
                .orElseThrow(() -> new ApiException(ErrorDefine.USER_NOT_FOUND));

        if(user.getUserPassword().equals(loginRequestDto.getUserPassword())){

            return LoginResponseDto.of(user);

        } else throw new ApiException(ErrorDefine.USER_NOT_FOUND);

    }
    public Boolean signup(SignUpRequestDto signUpRequestDto){


        User user = userRepository.save(signUpRequestDto.toEntity(signUpRequestDto));

        List<DisabledType> disabledTypes = signUpRequestDto.getDisabledTypes().stream()
                .map(dto -> dto.toEntity(user))
                .collect(Collectors.toList());

        disabledTypeRepository.saveAll(disabledTypes);

        return true;
    }

    public MypageResponseDto myPage(Long userId){

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ApiException(ErrorDefine.USER_NOT_FOUND));

        return MypageResponseDto.of(user);
    }

}
