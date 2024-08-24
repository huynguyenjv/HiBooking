package web.hibooking.backend.service;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import web.hibooking.backend.dto.request.UserCreationRequest;
import web.hibooking.backend.dto.response.UserProfileResponse;
import web.hibooking.backend.dto.response.UserResponse;
import web.hibooking.backend.entities.User;
import web.hibooking.backend.enums.Role;
import web.hibooking.backend.exception.AppException;
import web.hibooking.backend.exception.ErrorCode;
import web.hibooking.backend.mapper.UserMapper;
import web.hibooking.backend.repository.*;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;
    RoleRepository roleRepository;
    AddressRepository addressRepository;
    ContactRepository contactRepository;
    UserProfileRepository userProfileRepository;

    public UserResponse createUser(UserCreationRequest request){
        if (userRepository.existsByEmail(request.getEmail()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User user = userMapper.toUser(request);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));


        user.setRoles(roleRepository.findRoleByName(Role.USER.name()));

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public UserResponse getUserById(String id){
        UserResponse userResponse = userRepository.findById(id).
                map(userMapper::toUserResponse).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        userResponse.setAddressResponse(addressRepository.findAddressByUserId(id).map(userMapper::toAddressResponse).orElse(null));

        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND)));
    }

    public List<UserResponse> getAllUsers(){
        return userMapper.toUsers(userRepository.findAll());
    }



}
