package net.bingyan.treediary.helper;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ilovey on 5/17/15.
 */
public class FormatParameter {
    private static String key = "aes1357treediary";
    private static String DEFAULT_CODING = "UTF-8";

    /**
     * 判断一个字符串是否为整型
     *
     * @param str
     * @return
     */
    public static Boolean isNumber(String str) {
        if (str != null && !"".equals(str.trim())) {
            Pattern pattern = Pattern.compile("[0-9]*");
            Matcher isNum = pattern.matcher(str);
            Long number = 0l;
            if (isNum.matches()) {
                number = Long.parseLong(str);
            } else {
                return false;
            }
            if (number > 2147483647) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    /**
     * 判断是否为空
     *
     * @param str
     * @return
     */
    public static Boolean isNull(String str) {
        if (str == null) {
            return false;
        }
        return true;
    }

    public static String StringFormatter(String str) {
        if (str == null) {
            return null;
        }
        return str;
    }

    /**
     * 接口返回信息
     *
     * @param value
     * @return
     */
    public static String returnMissMsg(String value) {
        return String.format("Missing Required Parameter [%s] In the QueryString", value);
    }

    public static String returnTypeMsg(String parameter, String typeName) {
        return String.format("[%s] should be %s", parameter, typeName);
    }

    /**
     * 使用AES加密方式加密字符串
     *
     * @param encodingStr
     * @return
     */
    public static String aesEncrypt(String encodingStr) {
        try {
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(encodingStr.getBytes());
            return parseByte2HexStr(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 使用AES解密字符串
     *
     * @param decodingStr
     * @return
     */
    public static String aesDecrypt(String decodingStr) {
        try {
            byte[] debyte = parseHexStr2Byte(decodingStr);
            Key aesKey = new SecretKeySpec(key.getBytes(DEFAULT_CODING), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            byte[] decrypted = cipher.doFinal(debyte);
            return new String(decrypted, DEFAULT_CODING);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 使用base64编码字符串
     *
     * @param encodingStr
     * @return
     */
    public static String base64Encrypt(String encodingStr) {
        BASE64Encoder enc = new BASE64Encoder();
        try {
            String rez = enc.encode(encodingStr.getBytes(DEFAULT_CODING));
            System.out.println("Base64加密后的字符串为:" + rez);
            return rez;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 使用Base64解密字符串
     *
     * @param decodingStr
     * @return
     */
    public static String base64Decrypt(String decodingStr) {
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            String destr = new String(decoder.decodeBuffer(decodingStr), DEFAULT_CODING);
            System.out.println("Base64解密后的字符串为: " + destr);
            return destr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将二进制转换成16进制
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    /**
     * 使用Base64加密之后的字符串
     * @param encodingStr
     * @return
     */
    public static String encrypt(String encodingStr){
        String enstr = aesEncrypt(encodingStr);
        return base64Encrypt(enstr);
    }

    /**
     * 解密字符串
     * @param decodingStr
     * @return
     */
    public static String decrypt(String decodingStr){
        String base64dec = base64Decrypt(decodingStr);
        String destr = aesDecrypt(base64dec);
        return destr;
    }


}
