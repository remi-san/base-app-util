package net.remisan.base.controller;

import net.remisan.base.app.model.RestList;
import net.remisan.base.model.PersistableEntity;
import net.remisan.base.service.Service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class RestController<T extends PersistableEntity, S extends T> {

    @Autowired
    protected Service<T> service;
    
    @RequestMapping(method = RequestMethod.GET)
    public RestList<T> list(Pageable pageable) {
        return new RestList<T>(this.service.getAll(null, pageable));
    }
    
    @RequestMapping(value = "/{id:[0-9]+}", method = RequestMethod.GET)
    public T show(@PathVariable(value = "id") Long id) {
        return this.service.getById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public T create(
        @RequestBody S object
    ) throws BindException {
        return this.service.save(object);
    }
    
    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    @ResponseBody
    public Errors validate(
        @RequestBody S object
    ) throws BindException {
        return this.service.validate(object);
    }
    
    @RequestMapping(value = "/{id:[0-9]+}", method = RequestMethod.PUT)
    @ResponseBody
    public T update(
        @PathVariable(value = "id") Long id,
        @RequestBody S updateObject
    ) throws BindException {
        T existing = this.service.getById(id);
        
        BeanUtils.copyProperties(existing, updateObject);
        T updated = this.service.save(existing);
 
        return updated;
    }
    
    @RequestMapping(value = "/{id:[0-9]+}", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean delete(@PathVariable(value = "id") Long id) {
        this.service.delete(id);
        
        return true;
    }
}
