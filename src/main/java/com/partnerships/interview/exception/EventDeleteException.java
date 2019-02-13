package com.partnerships.interview.exception;

/**
 * EventException
 *
 * @author christian.valencia
 * @since 12/02/2019
 */
public class EventDeleteException extends RuntimeException {
    /**
     *
     */
    public EventDeleteException() {
        super();
    }

    /**
     * @param s
     */
    public EventDeleteException(String s) {
        super(s);
    }

    /**
     * @param s
     * @param throwable
     */
    public EventDeleteException(String s, Throwable throwable) {
        super(s, throwable);
    }

    /**
     * @param throwable
     */
    public EventDeleteException(Throwable throwable) {
        super(throwable);
    }
}
