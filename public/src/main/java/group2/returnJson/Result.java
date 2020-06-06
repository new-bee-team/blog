package group2.returnJson;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
public class Result<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    private Result(StatusEnum statusEnum, T data) {
        this.code = statusEnum.getCode();
        this.message = statusEnum.getMessage();
        this.data = data;
    }

    //成功(状态码)
    public static Result<Void> success() {
        return new Result<Void>(StatusEnum.SUCCESS, null);
    }

    //成功(状态码+数据)
    public static <T> Result<T> success(T data) {
        return new Result<T>(StatusEnum.SUCCESS, data);
    }

    //自定义(状态码+数据)
    public static <T> Result<T> execute(StatusEnum statusEnum, T data) {
        if (statusEnum == null) {
            return new Result<T>(StatusEnum.SUCCESS, null);
        }
        return new Result<T>(statusEnum, data);
    }

    //异常(状态码)
    public static <T> Result<T> fail() {
        return new Result<T>(StatusEnum.INTERNAL_SERVER_ERROR, null);
    }

    //异常(自定义状态码)
    public static <T> Result<T> fail(StatusEnum statusEnum) {
        return new Result<T>(statusEnum, null);
    }

    //异常(自定义状态码+数据)
    public static <T> Result<T> fail(StatusEnum statusEnum, T data) {
        if (statusEnum == null) {
            return new Result<T>(StatusEnum.INTERNAL_SERVER_ERROR, null);
        }
        return new Result<T>(statusEnum, data);
    }
}