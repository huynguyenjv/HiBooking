package web.hibooking.backend.mapper;

import org.mapstruct.Mapper;
import web.hibooking.backend.dto.request.TestCreationRequest;
import web.hibooking.backend.dto.response.TestResponse;
import web.hibooking.backend.entities.Test;

@Mapper(componentModel = "spring")
public interface TestMapper {
    Test toTest(TestCreationRequest testCreationRequest);
    TestResponse toTestResponse(Test test);
}
