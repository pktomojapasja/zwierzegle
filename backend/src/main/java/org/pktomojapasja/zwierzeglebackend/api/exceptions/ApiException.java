package org.pktomojapasja.zwierzeglebackend.api.exceptions;
import org.springframework.http.HttpStatus;
import java.time.ZonedDateTime;
public class ApiException {

    private final String message;
    private final HttpStatus httpStatus;

    public String getMessage() {
        return message;
    }


    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }

    private final ZonedDateTime timeStamp;

    public ApiException(String message, HttpStatus httpStatus, ZonedDateTime timeStamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timeStamp = timeStamp;
    }
}
