package is.farmhan.exeption;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorDefine {

    // Bad Request
    INVALID_ARGUMENT("4000", HttpStatus.BAD_REQUEST, "Bad Request: Invalid Arguments"),

    // Not Found
    USER_NOT_FOUND("4040", HttpStatus.NOT_FOUND, "Not Found: User Not Found "),

    // Forbidden

    // Server
    AI_SERVER_ERROR("5000", HttpStatus.INTERNAL_SERVER_ERROR, "Server Error: AI Server Error");
    private final String errorCode;
    private final HttpStatus httpStatus;
    private final String message;
}

