package com.example.controller;

import com.example.utils.VerifyCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * <p>
 *  验证码专用
 * </p>
 *
 * @author sunwz
 * @version 1.0
 * @since 2023/7/7 11:33
 */
@Controller
public class VerifyController {

    @GetMapping("/createVerify")
    public void createVerify(HttpServletResponse response, HttpSession session) throws IOException {
        VerifyCode vc = new VerifyCode();
        vc.drawImage(response.getOutputStream());
        //设置浏览器不缓存
        response.setHeader("Pragma","no-cache");
        response.setHeader("Cache-Control","no-cache");

        String code = vc.getCode();
        session.setAttribute("verify",code);

        System.out.println("生成的验证码为 = " + code);
    }

    @RequestMapping("/checkVerify")
    @ResponseBody
    public boolean checkVerify(@RequestParam String verify,HttpSession session){
        System.out.println("verify = " + verify);
        String o = (String)session.getAttribute("verify");
        System.out.println("o = " + o);
        if(verify.equalsIgnoreCase(o))
            return true;
        else
            return false;
    }

}
