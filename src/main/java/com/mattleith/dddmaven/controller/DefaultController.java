package com.mattleith.dddmaven.controller;

import com.mattleith.dddmaven.model.Load;
import com.mattleith.dddmaven.service.LoadCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DefaultController {
    private LoadCalculationService loadCalculationService;

    @Autowired
    public DefaultController(LoadCalculationService loadCalculationService) {
        this.loadCalculationService = loadCalculationService;
    }

    @RequestMapping(value = "getLoadData", method = RequestMethod.GET)
    @ResponseBody
    public String getHighestAverageShippingCostLoad() {
        return loadCalculationService.getHighestAverageShippingCostLoad().toString();
    }
}
