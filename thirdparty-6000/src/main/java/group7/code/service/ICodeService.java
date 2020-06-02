package group7.code.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICodeService {

    //生产验证码字符串并保存到session中
    //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
    //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
    void getImgCode(HttpServletRequest request, HttpServletResponse response) throws Exception;

    Boolean checkCode(String code,HttpServletRequest request);
}
