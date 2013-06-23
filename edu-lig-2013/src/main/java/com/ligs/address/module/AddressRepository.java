package com.ligs.address.module;

import java.util.List;

import com.ligs.domain.Address;

public interface AddressRepository {
	
	public Address findById(String id);
	
	public List<Address> findByName(String name);

	public List<Address> findAll();

	public void removeAll();

	public void update(Address address);

	public void save(Address address);
	
	public void removeById(String id);

}
