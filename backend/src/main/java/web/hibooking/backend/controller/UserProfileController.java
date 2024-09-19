package web.hibooking.backend.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import web.hibooking.backend.dto.request.UserProfileCreationRequest;
import web.hibooking.backend.dto.response.ApiResponse;
import web.hibooking.backend.dto.response.UserProfileResponse;
import web.hibooking.backend.service.UserProfileService;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
public class UserProfileController {

    UserProfileService userProfileService;

    @PostMapping("/create")
    public ApiResponse<UserProfileResponse> create(@RequestBody UserProfileCreationRequest request){
        return ApiResponse.<UserProfileResponse>builder()
                .result(userProfileService.createByUserId(request))
                .code(1000)
                .message("Create user profile successfully")
                .build();
    }

    @PutMapping("/update")
    public ApiResponse<UserProfileResponse> update(@RequestBody UserProfileCreationRequest request){
        return ApiResponse.<UserProfileResponse>builder()
                .result(userProfileService.updateByUserId(request))
                .code(1000)
                .message("Update user profile successfully")
                .build();
    }

    @GetMapping("/{idUser}")
    public ApiResponse<UserProfileResponse> getProfileByUser(@PathVariable String idUser){
        return ApiResponse.<UserProfileResponse>builder()
                .result(userProfileService.getProfileByUser(idUser))
                .code(1000)
                .message("Get user profile successfully")
                .build();
    }
}
