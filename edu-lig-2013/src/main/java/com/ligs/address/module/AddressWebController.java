package com.ligs.address.module;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ligs.domain.Address;

@Controller
@RequestMapping("/addresses")
public class AddressWebController {

	@Inject
	private AddressService service;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public void add(@RequestBody Address address) {
		service.save(address);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public void update(Address address) {
		service.update(address);
	}

	@RequestMapping(value = "{id}",  method = RequestMethod.DELETE)
	@ResponseBody	
	public void remove(@PathVariable String id) {
		service.removeById(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody	
	public List<Address> list(@RequestParam(required = false) String name) {
		if (name != null) {
			return service.findByName(name);
		}
		return service.findAll();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody	
	public Address get(@PathVariable String id) {
		return service.findById(id);
	}
	
}
