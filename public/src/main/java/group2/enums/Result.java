package group2.enums;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
public class Result<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    private Result(Status status, T data) {
        this.code = status.getCode();
        this.message = status.getMessage();
        this.data = data;
    }

    //成功(状态码)
    public static Result<Void> success() {
        return new Result<>(Status.SUCCESS, null);
    }

    //成功(状态码+数据)
    public static <T> Result<T> success(T data) {
        return new Result<>(Status.SUCCESS, data);
    }

    //自定义(状态码+数据)
    public static <T> Result<T> execute(Status status, T data) {
        if (status == null) {
            return new Result<>(Status.SUCCESS, null);
        }
        return new Result<>(status, data);
    }

    //异常(状态码)
    public static <T> Result<T> fail() {
        return new Result<T>(Status.INTERNAL_SERVER_ERROR, null);
    }

    //异常(自定义状态码)
    public static <T> Result<T> fail(Status status) {
        return new Result<T>(status, null);
    }

    //异常(自定义状态码+数据)
    public static <T> Result<T> fail(Status status, T data) {
        if (status == null) {
            return new Result<>(Status.INTERNAL_SERVER_ERROR, null);
        }
        return new Result<>(status, data);
    }
}