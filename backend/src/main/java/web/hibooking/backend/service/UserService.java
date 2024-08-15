package web.hibooking.backend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.hibooking.backend.dto.request.UserCreationRequest;
import web.hibooking.backend.entities.User;
import web.hibooking.backend.exceptions.AppException;
import web.hibooking.backend.exceptions.ErrorCode;
import web.hibooking.backend.mapper.UserMapper;
import web.hibooking.backend.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    UserRepository userRepository;
    UserMapper userMapper;
    public User createUser(UserCreationRequest request){
        User user = userMapper.toUser(request);

        if(userRepository.existsById(user.getEmail())){
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        return userRepository.save(user);
    }
}
