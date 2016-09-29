package org.roy.lessons.springboot.vo;

/**
 * Created by lilei on 16/9/29.
 */
public class ApiResult<T> {
    private int status;
    private T object;
    private String message;


    public ApiResult(int status, T object, String message) {
        this.status = status;
        this.object = object;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ApiResult getSuccessResponse() {
        return new ApiResult(0, null, "操作成功");
    }

    @Override
    public String toString() {
        return "ApiResult{" +
                "status=" + status +
                ", object=" + object +
                ", message='" + message + '\'' +
                '}';
    }
}
