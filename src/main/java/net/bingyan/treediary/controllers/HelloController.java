package net.bingyan.treediary.controllers;

import net.bingyan.treediary.entity.SnsEntity;
import net.bingyan.treediary.helper.FormatParameter;
import net.bingyan.treediary.service.ISnsService;
import net.bingyan.treediary.helper.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
public class HelloController {
    @Autowired
    private ISnsService snsService;

    @Autowired
    public ResponseService responseService;


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        System.out.println(snsService);
        SnsEntity s = snsService.findBySnsId(1);
        model.put("sns", s);
        System.out.println(s);
        return "hello";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
        return "login";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String submit(ModelMap model) {
        return "redirect:/index";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        return "logout";
    }


    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseService toJson() {
        HashMap data = new HashMap();
        SnsEntity s = snsService.findBySnsId(1);
        data.put("user", s);
        responseService.setData(data);
        return responseService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseService index() {
        responseService.setCode(1);
        responseService.setStatus("success");
        return responseService;
    }

    /**
     * 接入第三方登录, 包括微博、QQ和微信，若创建成功则返回用户登录token
     * @return
     */
    @RequestMapping(value = "/snsLogin", method = RequestMethod.POST)
    @ResponseBody
    public ResponseService snsLogin(HttpServletRequest req) {
        String snsType = req.getParameter("sns_type");
        String nickname = req.getParameter("nickname");
        String headUrl = req.getParameter("head_url");
        String openId = req.getParameter("open_id");
        if (snsType == null) {
            responseService.setData(FormatParameter.returnMissMsg("sns_type"));
            return responseService;
        } else if (!FormatParameter.isNumber(snsType)) {
            responseService.setData(FormatParameter.returnTypeMsg("sns_type", "Integer"));
            return responseService;
        }
        if (nickname == null) {
            responseService.setData(FormatParameter.returnMissMsg("nickname"));
            return responseService;
        }
        if (headUrl == null) {
            responseService.setData(FormatParameter.returnMissMsg("head_url"));
            return responseService;
        }
        if (openId == null) {
            responseService.setData(FormatParameter.returnMissMsg("open_id"));
            return responseService;
        }
        SnsEntity se = snsService.loginUser(new SnsEntity(snsType, nickname, headUrl, openId));
        SnsEntity loginUser = snsService.loginUser(se);
        if(loginUser == null){
            responseService.setData("登录失败");
            return responseService;
        }
        String token = FormatParameter.encrypt(String.valueOf(loginUser.getId()));
        HashMap response = new HashMap();
        response.put("user", loginUser);
        response.put("token", token);
        responseService.setData(response);
        return responseService;
    }

    @RequestMapping(value = "/status/text", method = RequestMethod.POST)
    @ResponseBody
    public ResponseService publishTestStatus(@RequestParam(value = "content", required = false) String content,
                                             @RequestParam(value = "status_type", required = false) String statusType,
                                             @RequestParam(value = "token", required = false) String token) {
        System.out.println(content);
        if (token == null){
            responseService.setData(FormatParameter.returnMissMsg("token"));
            return responseService;
        }
        if (statusType == null){
            responseService.setData(FormatParameter.returnMissMsg("token"));
            return responseService;
        }
        if (content == null){
            responseService.setData(FormatParameter.returnMissMsg("content"));
            return responseService;
        }
        return responseService;
    }
}