package com.niit.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.model.Shipping;
import com.niit.music.dao.ShippingDao;
import com.niit.services.ShippingService;
@Service
public class ShippingServiceImpl implements ShippingService{
@Autowired
ShippingDao sd;
	@Override
	public void add(Shipping ship) {
		// TODO Auto-generated method stub
		sd.add(ship);
	}

	@Override
	public void edit(Shipping ship) {
		// TODO Auto-generated method stub
		sd.edit(ship);
	}

}
