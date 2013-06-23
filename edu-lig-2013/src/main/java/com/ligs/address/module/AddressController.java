package com.ligs.address.module;


import java.util.List;

import com.ligs.domain.Address;

public class AddressController {

	private AddressService service;

	public void setService(AddressService service) {
		this.service = service;
	}

	public void add(Address address) {
		service.save(address);
	}

	public void update(Address address) {
		service.update(address);
	}

	public void removeAll() {
		service.removeAll();
	}

	public void remove(String id) {
		service.removeById(id);
	}

	public List<Address> list() {
		return service.findAll();
	}

	public Address get(String id) {
		return service.findById(id);
	}

	public List<Address> search(String name) {
		return service.findByName(name);
	}
	
}
