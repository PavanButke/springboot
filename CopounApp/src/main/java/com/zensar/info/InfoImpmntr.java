package com.zensar.info;

import java.util.Collections;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;

public class InfoImpmntr implements InfoContributor{

	
	   @Override
	    public void contribute(Info.Builder builder) {
	        builder.withDetail("Information",
	                Collections.singletonMap("Key", "Lock"));
	                
	    }
}
