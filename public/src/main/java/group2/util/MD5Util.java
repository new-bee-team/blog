package group2.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.security.MessageDigest;

/**
 * @author: KongKongBaby
 * @create: 2020-06-04 15:00
 * @description: MD5加密类 一次加密 二次解密
 **/
@Slf4j
public class MD5Util {
    // MD5加码 生成32位md5码 (一次加密 二次解密)
    public static String string2MD5(String inStr) {
        if (StringUtils.isEmpty(inStr))
            return "";
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            log.error(e.getCause() + ":\t" + e.getCause().getMessage());
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            byteArray[i] = (byte) charArray[i];
        }
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }

    // 解密方法 (需要连续解两次)
    public static String convertMD5(String inStr) {
        if (StringUtils.isEmpty(inStr))
            return "";

        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;

    }
}