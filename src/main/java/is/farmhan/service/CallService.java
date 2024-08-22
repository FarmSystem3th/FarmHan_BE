package is.farmhan.service;

import is.farmhan.domain.Call;
import is.farmhan.domain.User;
import is.farmhan.dto.response.CallStartResponseDto;
import is.farmhan.exeption.ApiException;
import is.farmhan.exeption.ErrorDefine;
import is.farmhan.repository.CallRepository;
import is.farmhan.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class CallService {

    private final UserRepository userRepository;
    private final CallRepository callRepository;

    public CallStartResponseDto startCall(Long userId){

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ApiException(ErrorDefine.USER_NOT_FOUND));

        Call call = Call.builder()
                .createAt(LocalDateTime.now())
                .user(user)
                .build();

        callRepository.save(call);

        return CallStartResponseDto.of(call);
    }
}
