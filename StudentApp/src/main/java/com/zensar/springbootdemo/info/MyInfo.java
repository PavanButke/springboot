package com.zensar.springbootdemo.info;

import java.util.Collections;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class MyInfo implements InfoContributor {

	    @Override
	    public void contribute(Info.Builder builder) {
	        builder.withDetail("Information",
	                Collections.singletonMap("Name", "Pavan"));
	                
	    }

	}

