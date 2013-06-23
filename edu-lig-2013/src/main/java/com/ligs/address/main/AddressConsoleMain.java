package com.ligs.address.main;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import com.ligs.address.module.AddressController;
import com.ligs.address.module.AddressRepository;
import com.ligs.address.module.AddressRepositoryImpl;
import com.ligs.address.module.AddressServiceImpl;
import com.ligs.address.view.AddressConsoleView;

public class AddressConsoleMain {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		System.setOut(new PrintStream(System.out, true, "UTF-8"));
		
		AddressRepository repository = new AddressRepositoryImpl();
		AddressServiceImpl service = new AddressServiceImpl();

		service.setRepository(repository);
		
		AddressController controller = new AddressController();
		controller.setService(service);
		
		AddressConsoleView view = new AddressConsoleView();
		view.setController(controller);
		view.process();
	}

}
