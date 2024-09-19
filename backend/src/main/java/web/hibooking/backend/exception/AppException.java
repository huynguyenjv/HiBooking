package web.hibooking.backend.exception;

import lombok.Getter;
import web.hibooking.backend.enums.ErrorCode;

@Getter
public class AppException extends RuntimeException {

    private ErrorCode errorCode;

    public AppException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
