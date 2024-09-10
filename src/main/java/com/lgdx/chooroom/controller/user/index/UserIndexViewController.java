package com.lgdx.chooroom.controller.user.index;

import com.lgdx.chooroom.domain.user.CustomerAccount;
import com.lgdx.chooroom.domain.user.CustomerFeedback;
import com.lgdx.chooroom.domain.user.CustomerRequestHealth;
import com.lgdx.chooroom.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserIndexViewController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String userIndex() {
        return "user/index";
    }

    @PostMapping("/join")
    public String registerUser(@ModelAttribute CustomerAccount customerAccount,
                               @ModelAttribute CustomerRequestHealth customerRequestHealth,
                               @ModelAttribute CustomerFeedback customerFeedback,
                               @ModelAttribute Long reservationNumber) {
        // 서비스 계층으로 회원가입 요청
        userService.registerUser(customerAccount, customerRequestHealth, customerFeedback, reservationNumber);
        return "redirect:/joinSuccess";  // 회원가입 성공 페이지로 리다이렉트
    }


}
