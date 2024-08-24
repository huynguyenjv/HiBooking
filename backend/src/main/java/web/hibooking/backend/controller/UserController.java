package web.hibooking.backend.controller;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.hibooking.backend.dto.request.UserCreationRequest;
import web.hibooking.backend.dto.response.ApiResponse;
import web.hibooking.backend.dto.response.UserResponse;
import web.hibooking.backend.entities.User;
import web.hibooking.backend.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.createUser(request))
                .code(1000)
                .message("User created successfully")
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<UserResponse> getUserById(@PathVariable String id) {
        System.out.println("Hehe");
        return ApiResponse.<UserResponse>builder()
                .result(userService.getUserById(id))
                .code(1000)
                .message("User retrieved successfully")
                .build();
    }

}
