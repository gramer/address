package com.ligs.address.module;

import java.util.List;

import com.ligs.domain.Address;

public interface AddressService {

	public void save(Address address);

	public void update(Address address);

	public void removeAll();

	public void removeById(String id);

	public List<Address> findAll();

	public Address findById(String id);
	
	public List<Address> findByName(String name);

}
