package com.tsm.accesscom.v1.dao;

import com.maxoptra.api.v1.model.request.Orders;

public interface BaseDAO {
	
    public void saveOrders(Orders orders);
    
    public String getLastOrderID();
}
