package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        System.out.println("插入数据的id：\t" + payment.getId());
        System.out.println("插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入成功", result);
        } else {
            return new CommonResult(444, "插入失败", null);
        }
    }


    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") long id) {
        Payment payment = paymentService.getPaymentById(id);
        System.out.println("查询结果：" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功", payment);
        } else {
            return new CommonResult(444, "查询失败", null);
        }
    }

    @GetMapping("/hh")
    public String getMessage() {
        return "hehhehehh";
    }
}
