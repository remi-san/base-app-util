package net.remisan.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.remisan.base.app.config.PageConfig;
import net.remisan.base.app.helper.HtmlPageConfigHelper;
import net.remisan.base.html.config.HtmlPageConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

public class BaseController {
    
    @Autowired
    protected HtmlPageConfigHelper pageConfigHelper;

    /**
     * 
     * @param viewName
     * @param request
     * @param response
     * @return
     */
    protected ModelAndView getModelAndView(
        String viewName,
        HttpServletRequest request,
        HttpServletResponse response
    ) {
        HtmlPageConfiguration pageConfig = this.pageConfigHelper.getPageConfiguration(request, response);
        
        return this.getModelAndView(viewName, pageConfig, request, response);
    }
    
    /**
     * 
     * @param viewName
     * @param pageConfig
     * @param request
     * @param response
     * @return
     */
    protected ModelAndView getModelAndView(
        String viewName,
        PageConfig pageConfig,
        HttpServletRequest request,
        HttpServletResponse response
    ) {
        HtmlPageConfiguration htmlPageConfig =
            this.pageConfigHelper.getPageConfiguration(pageConfig, request, response);
        
        return this.getModelAndView(viewName, htmlPageConfig, request, response);
    }
    
    /**
     * 
     * @param viewName
     * @param pageConfig
     * @param request
     * @param response
     * @return
     */
    protected ModelAndView getModelAndView(
        String viewName,
        HtmlPageConfiguration pageConfig,
        HttpServletRequest request,
        HttpServletResponse response
    ) {
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("pageConfiguration", pageConfig);
        
        return mav;
    }
}
