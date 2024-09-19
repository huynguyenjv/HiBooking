package web.hibooking.backend.exception;

import lombok.Getter;
import web.hibooking.backend.enums.ErrorCode;

@Getter
public class ExpiredException extends RuntimeException {
    private ErrorCode errorCode;

    public ExpiredException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
