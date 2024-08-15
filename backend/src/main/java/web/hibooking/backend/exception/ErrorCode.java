package web.hibooking.backend.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error"),
    INVALID_KEY(1005, "Invalid key"),
    USER_EXISTED(1001, "User existed"),
    ;

    private int code;
    private String message;


}
