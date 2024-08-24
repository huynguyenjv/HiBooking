package web.hibooking.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.hibooking.backend.dto.request.TestCreationRequest;
import web.hibooking.backend.dto.response.ApiResponse;
import web.hibooking.backend.dto.response.TestResponse;
import web.hibooking.backend.service.TestService;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @PostMapping("/create")
    public ApiResponse<TestResponse> createTest(@RequestBody TestCreationRequest request) {
        ApiResponse<TestResponse> response = new ApiResponse<>();

        response.setResult(testService.createTest(request));

        return response;
    }
}
