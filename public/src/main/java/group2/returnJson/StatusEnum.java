package group2.returnJson;

import lombok.Getter;
import lombok.ToString;

/**
 * @author: KongKongBaby
 * @Date: 2020.03.03 14:43
 * @Description: 自定义状态码
 */

@ToString
@Getter
public enum StatusEnum {
    // 请求正常处理并返回
    SUCCESS(200, "请求已正常处理"),

    // 客户端发送的请求有错误
    BAD_REQUEST(400, "请求参数错误"),
    UNAUTHORIZED(401, "权限不足"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "未找到资源"),
    BAD_METHOD(405, "不允许使用方法"),
    TIMEOUT(408, "请求超时"),
    CODEERROR(409, "验证码错误"),
//    USERNAMEREPEAT(410, "用户名重复"),


    // 服务器端有错误
    INTERNAL_SERVER_ERROR(500, "服务器异常"),
    BAD_GATEWAY(502, "网关异常"),
    UNAVAILABLE(503, "服务不可用"),
    GATEWAY_TIMEOUT(504, "网关超时"),

    // 数据库
    DATABASE_ERROR(600, "数据库异常"),
    MYBATIS_ERROR(601, "MyBatis异常"),
    EXISTED_RECORD(610, "已存在该数据"),
    NO_OPTION(611, "没有查到相关记录");

    private final Integer code;
    private final String message;

    StatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
