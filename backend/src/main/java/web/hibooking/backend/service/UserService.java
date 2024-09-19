package web.hibooking.backend.service;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import web.hibooking.backend.dto.request.UserCreationRequest;
import web.hibooking.backend.dto.response.UserResponse;
import web.hibooking.backend.entities.User;
import web.hibooking.backend.enums.RoleEnum;
import web.hibooking.backend.exception.AppException;
import web.hibooking.backend.enums.ErrorCode;
import web.hibooking.backend.mapper.UserMapper;
import web.hibooking.backend.repository.*;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    
    UserMapper userMapper;
    UserRepository userRepository;
    RoleRepository roleRepository;
    PasswordEncoder passwordEncoder;
    AddressRepository addressRepository;
    ContactRepository contactRepository;
    UserProfileRepository userProfileRepository;

    public UserResponse createUser(UserCreationRequest request){
        if (userRepository.existsByEmail(request.getEmail()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));


        user.setRoles(roleRepository.findRoleByName(RoleEnum.USER.name()));

        return userMapper.toUserResponse(userRepository.save(user));
    }

    @PreAuthorize("hasRole('ADMIN')")
    public List<UserResponse> getUsers(){

        List<UserResponse> users = userRepository.findAll().stream().map(userMapper::toUserResponse).toList();

        for (UserResponse user : users) {
           updateInfo(user, userRepository.findById(user.getId()).get());
        }

        return users;
    }

    @PreAuthorize("hasRole('ADMIN')")
    public UserResponse getUserById(String id){

        log.info("In method getUser");
        UserResponse userResponse = userRepository.findById(id).
                map(userMapper::toUserResponse).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        updateInfo(userResponse, userRepository.findById(id).get());
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND)));
    }

    @PostAuthorize("returnObject.email == authentication.name")
    public UserResponse getMyInfo(){
        var context = SecurityContextHolder.getContext();
        var authentication = context.getAuthentication();

        String name = authentication.getName();

        User user = userRepository.findUserByEmail(name)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        UserResponse userResponse = userMapper.toUserResponse(user);

        return updateInfo(userResponse, user);
    }

    private UserResponse updateInfo(UserResponse userResponse, User user){
        userResponse.setAddressResponse(addressRepository.findAddressByUserId(user.getId()).map(userMapper::toAddressResponse).orElse(null));
        userResponse.setContactResponse(contactRepository.findContactByUserId(user.getId()).map(userMapper::toContactResponse).orElse(null));
        userResponse.setUserProfileResponse(userProfileRepository.findUserProfileByUserId(user.getId()).map(userMapper::toUserProfileResponse).orElse(null));
        userResponse.setRoles(userMapper.mapRolesToRoleNames(user.getRoles()));

        return userResponse;
    }



}
