/**
 * 
 */
package com.maxoptra.api.v1.client;

import java.util.Collections;
import java.util.Set;

import javax.ws.rs.core.Application;

/**
 * @author faija
 *
 */
public class TSMClientApplication extends Application {

	//final static Logger logger = Logger.getLogger(TSMClientApplication.class);
	
    private Set<Object> singletons = Collections.emptySet();

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
    
    /**
     * This method is used to initialize the set of object for calling REST API.
     * @param singletons - Set<Object> 
     */
    public void setSingletons(final Set<Object> singletons) {
        this.singletons = singletons;
    }

	@Override
	public Set<Class<?>> getClasses() {
		// TODO Auto-generated method stub
		return null;
	}
}
