package comexamplecoursework2.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)

public class RecurringQuestion extends RuntimeException {
    public RecurringQuestion() {
    }

    public RecurringQuestion(String message) {
        super(message);
    }

    public RecurringQuestion(String message, Throwable cause) {
        super(message, cause);
    }

    public RecurringQuestion(Throwable cause) {
        super(cause);
    }

    public RecurringQuestion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
