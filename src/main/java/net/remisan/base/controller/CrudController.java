package net.remisan.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import net.remisan.base.app.form.PersistableEntityForm;
import net.remisan.base.model.PersistableEntity;
import net.remisan.base.service.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class CrudController<T extends PersistableEntity, S extends PersistableEntityForm<T>>
    extends BaseController {

    @Autowired
    protected Service<T> service;
    
    @Autowired
    @Qualifier("formValidator")
    protected Validator validator;
    
    protected String alias;
    protected String viewBasePath = "";
    protected String requestBasePath = "";
    
    /**
     * DataBinder is only used for @ModelAttribute
     * 
     * @param binder WebDataBinder
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(this.validator);
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(
        Pageable pageable,
        HttpServletRequest request,
        HttpServletResponse response
    ) {
        Page<T> entities = this.service.getAll(null, pageable);
        
        ModelAndView mav = this.getModelAndView(this.viewBasePath + "list/" + this.alias, request, response);
        mav.addObject("alias", this.alias);
        mav.addObject("objects", entities);
        
        return mav;
    }
    
    @RequestMapping(value = "/show/{id:[0-9]+}", method = RequestMethod.GET)
    public ModelAndView show(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) {
        
        T entity = this.service.getById(id);
        
        ModelAndView mav = this.getModelAndView(this.viewBasePath + "show/" + this.alias, request, response);
        mav.addObject("alias", this.alias);
        mav.addObject("entity", entity);
        
        return mav;
    }
    
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView newObject(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws InstantiationException, IllegalAccessException {
        
        T entity = this.service.getNewInstance();
        
        ModelAndView mav = this.getModelAndView(this.viewBasePath + "edit/" + this.alias, request, response);
        mav.addObject("alias", this.alias);
        mav.addObject("entity", entity);
        
        return mav;
    }
    
    @RequestMapping(value = "/edit/{id:[0-9]+}", method = RequestMethod.GET)
    public ModelAndView edit(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) {
        
        T entity = this.service.getById(id);
        
        ModelAndView mav = this.getModelAndView(this.viewBasePath + "edit/" + this.alias, request, response);
        mav.addObject("alias", this.alias);
        mav.addObject("entity", entity);
        
        return mav;
    }
    
    @Transactional
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(
        @ModelAttribute(value = "entity") @Valid S form,
        BindingResult result,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws BindException {
        
        if (result.hasErrors()) {
            ModelAndView mav = this.getModelAndView(this.viewBasePath + "edit/" + this.alias, request, response);
            mav.addObject("alias", this.alias);
            mav.addObject("entity", form);
            return mav;
        }
        
        Long id = form.getId();
        T entity = this.service.getByIdEager(id);
        form.updateObject(entity);
        this.service.save(entity);
        
        return new ModelAndView("redirect:/" + this.requestBasePath + "/" + this.alias + "/show/" + id);
    }
    
    @RequestMapping(value = "/delete/{id:[0-9]+}", method = RequestMethod.GET)
    public ModelAndView delete(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) {
        
        this.service.delete(id);
        
        return new ModelAndView("redirect:/" + this.requestBasePath + "/" + this.alias + "/list");
    }
}
