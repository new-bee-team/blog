package group7.code.service.impl;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import group7.code.service.ICodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

/**
 * @author: KongKongBaby
 * @create: 2020-06-02 22:43
 * @description: https://www.cnblogs.com/kangshuolei/p/12092126.html
 **/

@Service
@Slf4j
public class CodeServiceImpl implements ICodeService {

    @Resource
    private DefaultKaptcha defaultKaptcha;

    @Override
    public void getImgCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        byte[] captchaChallengeAsJpeg;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            // 生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            request.getSession().setAttribute("rightCode", createText);
            // 使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            log.error(e.getCause() + ":\t" + e.getCause().getMessage());
            return;
        }

        // 定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

    @Override
    public Boolean checkCode(String code, HttpServletRequest request) {
        // code非空判断
        if (StringUtils.isEmpty(code))
            return false;
        // 正确值判断
        String rightCode = (String) request.getSession().getAttribute("rightCode");
        return code.equals(rightCode);
    }
}
