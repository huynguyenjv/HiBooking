package web.hibooking.backend.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import web.hibooking.backend.dto.request.UserProfileCreationRequest;
import web.hibooking.backend.dto.response.UserProfileResponse;
import web.hibooking.backend.entities.User;
import web.hibooking.backend.entities.UserProfile;
import web.hibooking.backend.exception.AppException;
import web.hibooking.backend.enums.ErrorCode;
import web.hibooking.backend.mapper.UserProfileMapper;
import web.hibooking.backend.repository.UserProfileRepository;
import web.hibooking.backend.repository.UserRepository;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserProfileService {

    UserProfileRepository userProfileRepository;
    UserRepository userRepository;
    UserProfileMapper userProfileMapper;

    public UserProfileResponse createByUserId(UserProfileCreationRequest request) {

        if(userProfileRepository.findUserProfileByUserId(request.getUserId()).isPresent())
            throw new AppException(ErrorCode.USER_PROFILE_EXISTED);

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        UserProfile userProfile = userProfileMapper.toUserProfile(request);
        userProfile.setUser(user);

        return userProfileMapper.toUserProfileResponse(userProfileRepository.save(userProfile));
    }

    public UserProfileResponse updateByUserId(UserProfileCreationRequest request) {

        UserProfile userProfile = userProfileRepository.findUserProfileByUserId(request.getUserId())
                .orElseThrow(() -> new AppException(ErrorCode.USER_PROFILE_NOT_FOUND));

        userProfile.setFirstName(request.getFirstName());
        userProfile.setLastName(request.getLastName());
        userProfile.setGender(request.getGender());

        return userProfileMapper.toUserProfileResponse(userProfileRepository.save(userProfile));
    }

    public UserProfileResponse getProfileByUser(String idUser){

        UserProfile userProfile = userProfileRepository.findUserProfileByUserId(idUser)
                .orElseThrow(() -> new AppException(ErrorCode.USER_PROFILE_NOT_FOUND));

        return userProfileMapper.toUserProfileResponse(userProfile);

    }
}
