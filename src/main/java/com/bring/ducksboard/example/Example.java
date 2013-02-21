package com.bring.ducksboard.example;

import com.bring.ducksboard.DucksboardDao;
import com.bring.ducksboard.DucksboardId;
import com.bring.ducksboard.DucksboardService;
import org.apache.http.impl.client.DefaultHttpClient;

public class Example {

    public static void main(String[] args) {
        DucksboardDao dao = new DucksboardDao(new DefaultHttpClient(), "api-key");
        DucksboardService service = new DucksboardService(dao);
        DucksboardId id = service.createId("ducksboard_endpoint");

        service.pushValue(id, 1);
    }
}
