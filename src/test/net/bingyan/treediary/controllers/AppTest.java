package net.bingyan.treediary.controllers;

import net.bingyan.treediary.entity.SnsEntity;
import net.bingyan.treediary.helper.FormatParameter;
import net.bingyan.treediary.service.ISnsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;

/**
 * Created by ilovey on 5/28/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:mvc-dispatcher-servlet.xml")
public class AppTest {
    private @Autowired ISnsService snsServe;
    public static final String DEFAULT_ENCODING="UTF-8";

    @Test
    public void HelloTest(){
        SnsEntity se = new SnsEntity();
        se.setCreateTime(new Timestamp(System.currentTimeMillis()));
        se.setSnsType("1");
        se.setHeadUrl("www.hustonline.net");
        se.setNickname("zhangwenqiang");
        se.setOpenId("helloopenid");
        System.out.println(snsServe.loginUser(se));
        System.out.println("hello world1");
    }

    @Test
    public void CryptionTest(){
        String text = "1";
        BASE64Encoder enc=new BASE64Encoder();
        String rez = "";
        try {
            rez = enc.encode(text.getBytes(DEFAULT_ENCODING));
            System.out.println("Base64加密后的字符串为:" + rez);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        BASE64Decoder dec = new BASE64Decoder();
        try {
            String dez = new String(dec.decodeBuffer(rez), DEFAULT_ENCODING);
            System.out.println("Base64解密后的字符串为:" + dez);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void aesCryptTest(){
        String text = "1";
        String en = FormatParameter.encrypt(text);
        System.out.println("AES加密后的字符串为:" + en);
        String de = FormatParameter.decrypt(en);
        System.out.println("AES解密后的字符串为:"+ de);
    }

}
