package com.ligs.address.view;

import java.util.List;

import com.ligs.address.module.AddressController;
import com.ligs.domain.Address;

public class AddressConsoleView {

	private AddressConsoleInput addressInput = new AddressConsoleInput();
	private static final String DECO = "*";

	private AddressController controller;

	public void setController(AddressController controller) {
		this.controller = controller;
	}

	public void display(Address address) {
		System.out.print(buildAddressInfo(address));
	}

	private String buildAddressInfo(Address address) {
		StringBuilder builder = new StringBuilder();
		builder.append("id:");
		builder.append(address.getId());
		builder.append("\t");
		builder.append("이름:");
		builder.append(address.getName());
		builder.append("\t");
		builder.append("전화번호:");
		builder.append(address.getCellPhoneNumber());
		builder.append("\t");
		builder.append("이메일:");		
		builder.append(address.getEmail());
		builder.append("\t");		
		builder.append("생일:");
		builder.append(address.getBirthdayString());		
		return builder.toString();
	}

	public void display(List<Address> addresses) {
		System.out.println("목록 보기");

		final int SIZE = addresses.size();
		for (int i = 0; i < SIZE; i++) {
			System.out.println((i + 1 + "." + buildAddressInfo(addresses.get(i))));
		}

		System.out.println();
	}

	public void displayMenu() {
		System.out.println();
		System.out.println(getSeperateBar());
		for (Menu menu : Menu.values()) {
			System.out.format(DECO + "  %2d. %s", menu.getSeq(), menu.getName());
			System.out.println();
		}
		System.out.println(getSeperateBar());
	}

	private String getSeperateBar() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < 30; i++) {
			result.append(DECO);
		}

		return result.toString();
	}

	public void process() {
		boolean quit = false;
		while (quit == false) {
			try {
				displayTitle();
				displayMenu();
				Menu selectedMenu = addressInput.getMenu();
				switch (selectedMenu) {
				case LIST:
					list();
					break;
				case SEARCH:
					search();
					break;
				case ADD:
					add();
					break;
				case MODIFY:
					modify();
					break;
				case DELETE:
					delete();
					break;
				case END:
					quit = true;
					break;
				default:
					break;
				}
			} catch (RuntimeException e) {
				System.out.println("예상 치 못한 예외가 발생했습니다.");
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("예상 치 못한 예외가 발생했습니다.");
				e.printStackTrace();
			}
		}

		System.out.println("프로그램 종료!");
	}

	private void displayTitle() {
		System.out.println(getSeperateBar());
		System.out.print(DECO + "  주소록");
	}

	public void list() {
		display(controller.list());
	}

	public void add() {
		Address address = addressInput.getAddress("new", null);
		controller.add(address);
		System.out.println("저장되었습니다.");
	}

	public void modify() {
		String id = addressInput.getId();
		Address address = controller.get(id);
		address = addressInput.getAddress("modify", address);
		controller.update(address);
		System.out.println("수정되었습니다.");
	}

	public void search() {
		String searchKeyword = addressInput.getString("이름검색");
		List<Address> result = controller.search(searchKeyword);
		display(result);
	}

	public void delete() {
		String id = addressInput.getId();
		controller.remove(id);
		System.out.println("삭제되었습니다.");
	}

}
