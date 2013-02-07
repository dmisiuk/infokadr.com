package com.infokadr.controller;

import com.infokadr.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: dzmitry.misiuk
 * Date: 2/7/13
 * Time: 12:29 AM
 */
@Controller
public class VideoController {

    @Autowired
    private IService service;

    @RequestMapping(value = "/")
    public String getLastVideo(ModelMap model) {
        model.put("trailer", service.getLastTrailer());
        return "default";
    }
}
