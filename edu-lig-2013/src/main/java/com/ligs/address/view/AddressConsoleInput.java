package com.ligs.address.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.ligs.domain.Address;

public class AddressConsoleInput {

	private static final String PREVIOUS_MENU = "p1";

	public Address getAddress(String command, Address address) {
		if (command.equals("new")) {
			return inputAdd();
		} else if (command.equals("modify")) {
			return inputModify(address);
		} else {
			System.out.println(command + "는 알 수 없는 명령어입니다.");
			return null;
		}
	}

	private Address inputAdd() {
		Address result = new Address();
		inputName(result, true);
		inputCellPhoneNumber(result, true);
		inputEmail(result, true);
		inputBirthday(result, true);

		return result;
	}

	private void inputEmail(Address result, boolean required) {
		String existedValue = result.getEmail();
		existedValue = (existedValue == null || existedValue.isEmpty()) ? "" : "(" + existedValue + ")";

		while (true) {
			try {
				String newEmail;
				if (required) {
					newEmail = getNotEmptyString("이메일" + existedValue);
				} else {
					newEmail = getString("이메일" + existedValue);
					if (newEmail == null || newEmail.isEmpty()) {
						break;
					}
				}
				result.setEmail(newEmail);
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	private void inputBirthday(Address result, boolean required) {
		String existedValue = result.getBirthdayString();
		existedValue = (existedValue == null || existedValue.isEmpty()) ? "" : "(" + existedValue + ")";

		while (true) {
			try {
				String newBirthday;
				if (required) {
					newBirthday = getNotEmptyString("생일" + existedValue);
				} else {
					newBirthday = getString("생일" + existedValue);
					if (newBirthday == null || newBirthday.isEmpty()) {
						break;
					}
				}
				result.setBirthdayByString(newBirthday);
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	

	private void inputCellPhoneNumber(Address result, boolean required) {
		String existedValue = result.getCellPhoneNumber();
		existedValue = (existedValue == null || existedValue.isEmpty()) ? "" : "(" + existedValue + ")";

		while (true) {
			try {
				String newCellPhoneNumber = null;
				if (required) {
					newCellPhoneNumber = getNotEmptyString("핸드폰번호" + existedValue);
				} else {
					newCellPhoneNumber = getString("핸드폰번호" + existedValue);
					if (newCellPhoneNumber == null || newCellPhoneNumber.isEmpty()) {
						break;
					}
				}

				result.setCellPhoneNumber(newCellPhoneNumber);
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private void inputName(Address result, boolean requried) {
		String existedValue = result.getName();
		existedValue = (existedValue == null || existedValue.isEmpty()) ? "" : "(" + existedValue + ")";

		while (true) {
			try {
				String name = null;
				if (requried) {
					name = getNotEmptyString("이름" + existedValue);
				} else {
					name = getString("이름" + existedValue);
					if (name == null || name.isEmpty()) {
						break;
					}
				}

				result.setName(name);
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private Address inputModify(Address address) {
		System.out.println(address.getName() + "를 수정합니다.");

		inputName(address, false);
		inputCellPhoneNumber(address, false);
		inputEmail(address, false);

		return address;
	}

	public Menu getMenu() {
		return Menu.from(getNotEmptyInt("메뉴"));
	}

	private int getNotEmptyInt(String title) {
		int number = 0;
		while (true) {
			number = getInt(title);
			if (number > 0) {
				return number;
			}
		}
	}

	private int getInt(String title) {
		String str = getString(title);
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return 0;
		}
	}

	public String getString(String title) {
		try {
			System.out.print(title + " > ");
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "MS949"));
//			return br.readLine();
			
			Scanner scanner = new Scanner(System.in, "MS949");
			return scanner.nextLine();
			
		} catch (Exception ex) {
			System.out.println("입력 중 에러");
			return null;
		}
	}

	public String getNotEmptyString(String title) {
		String str = "";
		while (true) {
			str = getString(title);
			if ("".equals(str)) {
				System.out.println(title + "은(는) 반드시 입력하셔야 합니다!!");
			} else if (str.equals(PREVIOUS_MENU)) {
				break;
			} else {
				break;
			}
		}
		return str;
	}

	public String getId() {
		return getNotEmptyString("아이디");
	}

}
