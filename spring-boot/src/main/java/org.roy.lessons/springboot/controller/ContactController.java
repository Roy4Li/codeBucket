package org.roy.lessons.springboot.controller;

import org.roy.lessons.springboot.vo.ApiResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lilei on 16/9/29.
 */
@Controller
@RequestMapping("/")
public class ContactController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public ApiResult getUser() {
        return ApiResult.getSuccessResponse();
    }
}
