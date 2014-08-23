package net.remisan.base.app.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.remisan.base.app.config.PageConfig;
import net.remisan.base.html.config.HtmlPageConfiguration;

public interface HtmlPageConfigHelper {

    /**
     * 
     * @param request
     * @param response
     * @return
     */
    HtmlPageConfiguration getPageConfiguration(
        HttpServletRequest request,
        HttpServletResponse response
    );
    
    /**
     * 
     * @param pageConfig
     * @param request
     * @param response
     * @return
     */
    HtmlPageConfiguration getPageConfiguration(
        PageConfig pageConfig,
        HttpServletRequest request,
        HttpServletResponse response
    );

}