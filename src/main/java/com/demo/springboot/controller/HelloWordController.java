/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: HelloWordController
 * Author:   houjing
 * Date:     2019/5/9 01:07
 * Description: hello world
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 * 〈hello world〉
 *
 * @author houjing
 * @create 2019/5/9
 * @since 1.0.0
 */
@RestController
public class HelloWordController {

    @RequestMapping("/hello")
    public String printHello() {
        return "Hello World";
    }

}