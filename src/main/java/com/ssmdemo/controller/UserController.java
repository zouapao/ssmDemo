package com.ssmdemo.controller;

import javax.servlet.http.HttpServletRequest;

import com.ssmdemo.model.Items;
import com.ssmdemo.model.User;
import com.ssmdemo.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;
    @RequestMapping("/showUser.do")
    public void selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        long userId = Long.parseLong(request.getParameter("id"));
        User user = this.userService.selectUser(userId);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(user));
        response.getWriter().close();
    }

    @RequestMapping("/test")
    public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("和啊哈");
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping("/showUserByname.do")
    public void selectUserbyname(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        List<User> users = this.userService.selectUserbByname(username);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(users.get(0)));
        response.getWriter().close();
    }

    @RequestMapping("/fruit.do")
    public ModelAndView searchFruit() {
        List<Items> list = new ArrayList<>();
        list.add(new Items(1, "华为", 2399f, "/lop/pim", new Date(), "质量好"));
        list.add(new Items(2, "apple", 2399f, "/lop/pim", new Date(), "质量好"));
        list.add(new Items(3, "小米", 2399f, "/lop/pim", new Date(), "质量好"));
        list.add(new Items(4, "oppo", 2399f, "/lop/pim", new Date(), "质量好"));


        ModelAndView mav = new ModelAndView();
        mav.addObject("itemList", list);
        mav.setViewName("itemList");
        return mav;
    }


}