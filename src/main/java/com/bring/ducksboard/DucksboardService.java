package com.bring.ducksboard;

import com.bring.ducksboard.request.*;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Arrays.asList;

public class DucksboardService {

    private final DucksboardDao dao;
    private final String suffix;

    public DucksboardService(DucksboardDao dao) {
        this(dao, "");
    }

    public DucksboardService(DucksboardDao dao, String suffix) {
        this.dao = dao;
        this.suffix = suffix;
    }

    public void pushValue(DucksboardId id, int integer) {
        pushValue(id, new BigDecimal(integer));
    }

    public void pushValue(DucksboardId id, BigDecimal decimal) {
        dao.push(id, new Value(decimal));
    }

    public void pushDelta(DucksboardId id, BigDecimal decimal) {
        dao.push(id, new Delta(decimal));
    }

    public void pushValueWithTimestamp(DucksboardId id, BigDecimal decimal, DateTime time) {
        dao.push(id, new ValueWithTimestamp(decimal, time));
    }
    
    public void pushObject(DucksboardId id, DucksboardRequest object) {
        dao.push(id, object);
    }

    public void pushListOfObjects(DucksboardId id, DucksboardObject... objects) {
        pushListOfObjects(id, asList(objects));
    }
    
    public void pushListOfObjects(DucksboardId id, List<? extends DucksboardObject> objects) {
        dao.push(id, new ListOfValues(objects));
    }
    
    public DucksboardId createId(String id) {
        return new DucksboardId(id, suffix);
    }
}
