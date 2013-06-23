package com.ligs.address.module;

import java.util.List;

import com.ligs.domain.Address;

public class AddressServiceImpl implements AddressService {

	private AddressRepository repository;

	public void setRepository(AddressRepository repository) {
		this.repository = repository;
	}

	@Override
	public void save(Address address) {
		repository.save(address);
	}

	@Override
	public void update(Address address) {
		repository.update(address);
	}

	@Override
	public void removeAll() {
		repository.removeAll();
	}

	@Override
	public void removeById(String id) {
		repository.removeById(id);
	}

	@Override
	public List<Address> findAll() {
		return repository.findAll();
	}

	@Override
	public Address findById(String id) {
		return repository.findById(id);
	}

	@Override
	public List<Address> findByName(String name) {
		return repository.findByName(name);
	}

}
