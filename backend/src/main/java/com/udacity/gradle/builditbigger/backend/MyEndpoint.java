package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.sealstudios.javalib.myClass;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name sets it in cloud and says Hi back with the returned name */


    @ApiMethod(name = "setJoke")
    public MyBean setJoke(){
        MyBean response = new MyBean();
        myClass myclass = new myClass();
        response.setData(myclass.getRandomJoke());
        return response;
    }

}
