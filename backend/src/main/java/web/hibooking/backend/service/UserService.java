package web.hibooking.backend.service;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import web.hibooking.backend.dto.request.UserCreationRequest;
import web.hibooking.backend.dto.response.UserResponse;
import web.hibooking.backend.entities.User;
import web.hibooking.backend.exception.AppException;
import web.hibooking.backend.exception.ErrorCode;
import web.hibooking.backend.mapper.UserMapper;
import web.hibooking.backend.repository.UserRepository;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class UserService {

    UserRepository userRepository;
    UserMapper userMapper;

    public UserResponse createUser(UserCreationRequest request){
        System.out.println(request.toString());
        User user = userMapper.toUser(request);

//        if(userMapper == null)
//            System.out.println("userMapper is null");
//
//        if(userRepository.existsById(user.getEmail())){
//            throw new AppException(ErrorCode.USER_EXISTED);
//        }

        return userMapper.toUserResponse(userRepository.save(user));
    }


}
