package com.ligs.address.main;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ligs.address.module.AddressController;
import com.ligs.address.view.AddressConsoleView;

public class AddressConsoleMainWithSpring {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		System.setOut(new PrintStream(System.out, true, "UTF8"));		
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AddressController controller = (AddressController) context.getBean("addressController");
		
		AddressConsoleView view = new AddressConsoleView();
		view.setController(controller);
		view.process();
	}

}

