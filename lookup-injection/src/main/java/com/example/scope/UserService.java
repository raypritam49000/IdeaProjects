package com.example.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class UserService {

//    @Autowired
//    private WeatherService weatherService;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    private ObjectFactory<WeatherService> weatherServiceObjectFactory;

    public String getCurrentTempFromWeatherAPI() {
       // return weatherService.getTodaysTemp();
        //return applicationContext.getBean(WeatherService.class).getTodaysTemp();
       // return weatherServiceObjectFactory.getObject().getTodaysTemp();
        return getWeatherServiceBean().getTodaysTemp();
    }

    @Lookup
    public WeatherService getWeatherServiceBean(){
        return null;
    }



}
