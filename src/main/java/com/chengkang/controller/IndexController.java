package com.chengkang.controller;

import com.alibaba.fastjson.JSON;
import com.chengkang.services.DevK8sApiService;
import io.fabric8.kubernetes.api.model.NamespaceList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("index")
public class IndexController {

    @GetMapping("")
    public String index(){
        return "hello world123.";
    }

    @GetMapping("/listnamespaces")
    public String name(){
        DevK8sApiService.init();
        NamespaceList list = DevK8sApiService.listNamespace();
        System.out.println(list.getItems().size());
        return JSON.toJSONString(list);
    }
}
