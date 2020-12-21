package top.jiangyixin.gaea.core.exception;

/**
 * Gaea Exception
 *
 * @author jiangyixin
 * @version 1.0
 * @date 2020/12/21
 */
public class GaeaException extends RuntimeException {

    public GaeaException(String message) {
        super(message);
    }

    public GaeaException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public GaeaException(Throwable throwable) {
        super(throwable);
    }
}
