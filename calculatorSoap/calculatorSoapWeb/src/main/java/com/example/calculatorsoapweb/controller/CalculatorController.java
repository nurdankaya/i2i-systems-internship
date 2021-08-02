package com.example.calculatorsoapweb.controller;

import com.example.calculatorsoapweb.model.CalculateModel;
import com.example.calculatorsoapweb.service.CalculateService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CalculatorController {
    private static final Logger logger =  LogManager.getLogger(CalculatorController.class);

    @Autowired
    CalculateService calculateService;

    CalculateModel calculateModel = new CalculateModel();

    @GetMapping("/")
    @ResponseBody
    public ModelAndView getCalculator() {
        logger.debug("calculator opened");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("CalculateModel",calculateModel);
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @RequestMapping(value="/", params="add", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("CalculateModel")  CalculateModel calculateModel){
        logger.info("calculator added");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("result",calculateService.add(calculateModel));
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @RequestMapping(value="/", params="subtract", method = RequestMethod.POST)
    public ModelAndView subtract(@ModelAttribute("CalculateModel")  CalculateModel calculateModel){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("result",calculateService.subtract(calculateModel));
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @RequestMapping(value="/", params="multiply", method = RequestMethod.POST)
    public ModelAndView multiply(@ModelAttribute("CalculateModel")  CalculateModel calculateModel){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("result",calculateService.multiply(calculateModel));
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @RequestMapping(value="/", params="divide", method = RequestMethod.POST)
    public ModelAndView divide(@ModelAttribute("CalculateModel")  CalculateModel calculateModel){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("result",calculateService.divide(calculateModel));
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/result")
    @ResponseBody
    public ModelAndView resultCalculator() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("CalculateModel",calculateModel);
        modelAndView.setViewName("result");
        return modelAndView;
    }

}
