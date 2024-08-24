package web.hibooking.backend.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import web.hibooking.backend.dto.request.TestCreationRequest;
import web.hibooking.backend.dto.response.TestResponse;
import web.hibooking.backend.entities.Test;
import web.hibooking.backend.mapper.TestMapper;
import web.hibooking.backend.repository.TestRepository;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TestService {

    TestRepository testRepository;
    TestMapper testMapper;

    public TestResponse createTest(TestCreationRequest request){

        Test user = testMapper.toTest(request);

        return testMapper.toTestResponse(testRepository.save(user));
    }
}
