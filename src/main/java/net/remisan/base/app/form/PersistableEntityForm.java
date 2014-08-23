package net.remisan.base.app.form;

import net.remisan.base.model.PersistableEntity;

public interface PersistableEntityForm<T extends PersistableEntity> extends Form<T> {
    
    Long getId();
}
