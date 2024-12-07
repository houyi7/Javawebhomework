package top.lihaoyu.store.controller.exception;


public class FileTypeNotMatchException extends FileUploadException {

    public FileTypeNotMatchException() {
        super();
    }

    public FileTypeNotMatchException(String message) {
        super(message);
    }

    public FileTypeNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileTypeNotMatchException(Throwable cause) {
        super(cause);
    }

    protected FileTypeNotMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
