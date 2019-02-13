package com.partnerships.interview.exception;

/**
 * EventException
 *
 * @author christian.valencia
 * @since 12/02/2019
 */
public class EventException extends RuntimeException {
    /**
     *
     */
    public EventException() {
        super();
    }

    /**
     * @param s
     */
    public EventException(String s) {
        super(s);
    }

    /**
     * @param s
     * @param throwable
     */
    public EventException(String s, Throwable throwable) {
        super(s, throwable);
    }

    /**
     * @param throwable
     */
    public EventException(Throwable throwable) {
        super(throwable);
    }
}
