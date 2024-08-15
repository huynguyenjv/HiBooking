package web.hibooking.backend.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.hibooking.backend.dto.request.UserCreationRequest;
import web.hibooking.backend.dto.response.ApiResponse;
import web.hibooking.backend.dto.response.UserResponse;
import web.hibooking.backend.entities.User;
import web.hibooking.backend.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.createUser(request))
                .code(1000)
                .message("User created successfully")
                .build();
    }

}
