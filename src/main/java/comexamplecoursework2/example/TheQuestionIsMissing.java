package comexamplecoursework2.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (code = HttpStatus.BAD_REQUEST)
public class TheQuestionIsMissing extends RuntimeException{
    public TheQuestionIsMissing() {
    }

    public TheQuestionIsMissing(String message) {
        super(message);
    }

    public TheQuestionIsMissing(String message, Throwable cause) {
        super(message, cause);
    }

    public TheQuestionIsMissing(Throwable cause) {
        super(cause);
    }

    public TheQuestionIsMissing(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
