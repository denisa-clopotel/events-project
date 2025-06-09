package sda.serviceaggregatingevents.exceptions.user;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}
