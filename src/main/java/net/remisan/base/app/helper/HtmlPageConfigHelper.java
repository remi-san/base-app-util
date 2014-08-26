package net.remisan.base.app.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.remisan.base.app.config.PageConfig;
import net.remisan.base.html.config.HtmlPageConfiguration;

/**
 * The HtmlPageConfigHelper interface is aimed at providing the appropriate
 * {@link HtmlPageConfiguration} object based on the given parameters.
 * 
 * @author Remi San<remi.san@gmail.com>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface HtmlPageConfigHelper {

    /**
     * That method returns a page configuration based on the HTTP
     * request and response
     * 
     * @param request  The HTTP Request
     * @param response The HTTP Response
     * 
     * @return the page configuration
     */
    HtmlPageConfiguration getPageConfiguration(
        HttpServletRequest request,
        HttpServletResponse response
    );
    
    /**
     * That method returns a page configuration based on the page
     * configuration and the HTTP request and response
     * 
     * @param pageConfig The web page configuration
     * @param request    The HTTP Request
     * @param response   The HTTP Response
     * 
     * @return the page configuration
     */
    HtmlPageConfiguration getPageConfiguration(
        PageConfig pageConfig,
        HttpServletRequest request,
        HttpServletResponse response
    );
}