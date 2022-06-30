package com.assignment.info;

import java.util.Collections;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;

public class MySysInfo implements InfoContributor{

	
	   @Override
	    public void contribute(Info.Builder builder) {
	        builder.withDetail("Fakalya",
	                Collections.singletonMap("Name", "Sigma"));
	                
	    }
}
