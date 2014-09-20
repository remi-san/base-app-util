package net.remisan.base.app.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

public class HibernateAwareObjectMapper extends ObjectMapper {

    private static final long serialVersionUID = 1254941045450711491L;

    public HibernateAwareObjectMapper() {
        registerModule(new Hibernate4Module());
    }
}