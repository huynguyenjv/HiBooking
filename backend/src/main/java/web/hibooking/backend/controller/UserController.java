package web.hibooking.backend.controller;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import web.hibooking.backend.dto.request.UserCreationRequest;
import web.hibooking.backend.dto.response.ApiResponse;
import web.hibooking.backend.dto.response.UserResponse;
import web.hibooking.backend.service.AuthenticationService;
import web.hibooking.backend.service.UserService;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    UserService userService;
    AuthenticationService authenticationService;

    @PostMapping("/create")
    public ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.createUser(request))
                .code(1000)
                .message("User created successfully")
                .build();
    }

    @GetMapping("")
    public List<ApiResponse<UserResponse>> getUsers(){
        return userService.getUsers().stream()
                .map(userResponse -> ApiResponse.<UserResponse>builder()
                        .result(userResponse)
                        .code(1000)
                        .message("User retrieved successfully")
                        .build())
                .toList();
    }

    @GetMapping("/{id}")
    public ApiResponse<UserResponse> getUserById(@RequestHeader("Authorization") String token, @PathVariable String id) {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("Email : {}", authentication.getName());
        authentication.getAuthorities()
                .forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority()));

        return ApiResponse.<UserResponse>builder()
                .result(userService.getUserById(id))
                .code(1000)
                .message("User retrieved successfully")
                .build();
    }

    @GetMapping("/myinfo")
    public ApiResponse<UserResponse> getMyInfo(){
        return ApiResponse.<UserResponse>builder()
                .result(userService.getMyInfo())
                .code(1000)
                .message("User retrieved successfully")
                .build();
    }


}
