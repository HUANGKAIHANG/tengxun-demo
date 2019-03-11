package com.example.tengxundemo.controller;

import com.example.tengxundemo.Service.VService;
import com.example.tengxundemo.model.V;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class VController {

    @Autowired
    private VService vService;

    @RequestMapping("/")
    @Scope("session")
    public String index(Model model, HttpServletRequest request){
        System.out.println("进入index方法。。。");
        request.getSession().setAttribute("tail","by HUANG Kai hang");
//        model.addAttribute("tail","by HUANG Kai hang.");
        model.addAttribute("num",vService.getVList().size());
        return "v";
    }

    @PostMapping("/add")
    public String add(Model model, @RequestParam(name = "val") String val){
        System.out.println("进入add方法。。。");

        System.out.println("收到的参数是"+val);

        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(val);
        if (isNum.matches()){
            V v = V.builder().val(Long.parseLong(val)).build();
            vService.save(v);
            model.addAttribute("feedback","数据已储存");
        }else
            model.addAttribute("feedback","请输入正整数");


        List<V> list = vService.getVList();
        List<Long> ids = new ArrayList<>();
        List<Long> vals = new ArrayList<>();
        System.out.println("*************当前数据库数据");
        for (V temp : list) {
            ids.add(temp.getId());
            vals.add(temp.getVal());
            System.out.println(temp.toString());
        }
        System.out.println("*************");

        model.addAttribute("num",vService.getVList().size());
        model.addAttribute("ids",ids);
        model.addAttribute("vals",vals);
        return "v";
    }
}
