package Util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 控制主体
 */
public class SecurityUtil {
    public static String md5(String s){
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte b[] = md.digest(s.getBytes());//用md5算法计算得到s这段数据的摘要

            BASE64Encoder base64 = new BASE64Encoder();
            return base64.encode(b);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public static String base64encode(String s){
        BASE64Encoder base64 = new BASE64Encoder();
        return base64.encode(s.getBytes());
    }
    public static String base64decode(String s){
        BASE64Decoder base64 = new BASE64Decoder();
        try {
            return new String(base64.decodeBuffer(s)) ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
