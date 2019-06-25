package net.mahdirazavi.app.githubanalyzer.exception;

import java.util.Date;

/**
 * <h1>ErrorDetails</h1>
 * The Error model as output to end-user
 * <p>
 *
 * @author Mahdi Razavi
 * @version 1.0
 * @since 6/14/2019
 */
public class ErrorDetails {

    private Date timestamp;
    private String message;
    private String details;

    /**
     * Instantiates a new Error details.
     *
     * @param timestamp the timestamp
     * @param message   the message
     * @param details   the details
     */
    public ErrorDetails(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    /**
     * Gets timestamp.
     *
     * @return the timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets details.
     *
     * @return the details
     */
    public String getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "ErrorDetails{" +
                "timestamp=" + timestamp +
                ", message='" + message + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}