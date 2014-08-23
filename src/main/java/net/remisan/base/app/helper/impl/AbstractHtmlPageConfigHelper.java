package net.remisan.base.app.helper.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.remisan.base.app.config.AppConfig;
import net.remisan.base.app.config.PageConfig;
import net.remisan.base.app.helper.HtmlPageConfigHelper;
import net.remisan.base.html.config.HtmlPageConfiguration;

@Component
public abstract class AbstractHtmlPageConfigHelper implements HtmlPageConfigHelper {
    
    @Autowired
    private AppConfig appConfig;
    
    private String getTitle(PageConfig pageConfig) {
        return (
            this.appConfig.getTitlePrefix() + " "
            + pageConfig.getTitle() + " "
            + this.appConfig.getTitleSuffix()).trim();
    }
    
    private String getDescription(PageConfig pageConfig) {
        String description = pageConfig.getDescription();
        return description;
    }

    private String getKeywords(PageConfig pageConfig) {
        String keywords = pageConfig.getKeywords();
        return keywords;
    }

    private String getRobots(PageConfig pageConfig) {
        String robots = pageConfig.getRobots();
        if (robots == null) {
            robots = this.appConfig.getRobots();
        }
        return robots;
    }

    private String getAuthor(PageConfig pageConfig) {
        String author = pageConfig.getAuthor();
        if (author == null) {
            author = this.appConfig.getAuthor();
        }
        return author;
    }
    
    /**
     * 
     * @param request
     * @param response
     * @return
     */
    protected abstract PageConfig getContextPageConfig(
        HttpServletRequest request,
        HttpServletResponse response
    );
    
    /**
     * 
     * @param request
     * @param response
     * @return
     */
    private HtmlPageConfiguration getBasePageConfiguration(
        HttpServletRequest request,
        HttpServletResponse response
    ) {
        HtmlPageConfiguration pageConfiguration = new HtmlPageConfiguration();
        
        pageConfiguration.setBase(this.appConfig.getBase());
        pageConfiguration.setUrl(request.getRequestURL().toString());
        
        pageConfiguration.setLanguage(this.appConfig.getLanguage());
        pageConfiguration.setCharset(this.appConfig.getCharset());
                
        return pageConfiguration;
    }
    
    public HtmlPageConfiguration getPageConfiguration(
        HttpServletRequest request,
        HttpServletResponse response
    ) {
        PageConfig pageConfig = this.getContextPageConfig(request, response);
        
        return this.getPageConfiguration(
            pageConfig,
            request,
            response
        );
    }
    
    public HtmlPageConfiguration getPageConfiguration(
        PageConfig pageConfig,
        HttpServletRequest request,
        HttpServletResponse response
    ) {
        HtmlPageConfiguration pageConfiguration = this.getBasePageConfiguration(request, response);
        
        pageConfiguration.setTitle(this.getTitle(pageConfig));
        pageConfiguration.setDescription(this.getDescription(pageConfig));
        pageConfiguration.setKeywords(this.getKeywords(pageConfig));
        
        pageConfiguration.setRobotsConfiguration(this.getRobots(pageConfig));
        pageConfiguration.setAuthor(this.getAuthor(pageConfig));
        
        return pageConfiguration;
    }
}
