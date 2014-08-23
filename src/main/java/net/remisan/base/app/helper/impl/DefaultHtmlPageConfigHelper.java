package net.remisan.base.app.helper.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import net.remisan.base.app.config.PageConfig;

@Component
public class DefaultHtmlPageConfigHelper extends AbstractHtmlPageConfigHelper {

    @Override
    protected PageConfig getContextPageConfig(
        HttpServletRequest request,
        HttpServletResponse response
    ) {
        return new PageConfig();
    }
}
