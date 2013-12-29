package com.ligs.address.module;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ligs.domain.Address;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class AddressJDBCTemplateRepositoryImplTest {
	
	@Autowired private AddressJDBCTemplateRepositoryImpl repository;

	@Test
	public void test() {
		assertNotNull(repository);
	}
	
	@Test
	public void save() {
		Address address = new Address();
		address.setName("김경준");
		address.setBirthday(new Date());
		address.setCellPhoneNumber("010-3526-2188");
		address.setEmail("gramer2188@gmail.com");
		repository.save(address);
		
		assertThat(repository.findAll().size(), is(1));
	}

}
