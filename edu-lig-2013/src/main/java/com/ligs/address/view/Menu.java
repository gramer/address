package com.ligs.address.view;

public enum Menu {
	LIST(1, "전체조회"), SEARCH(2, "검색"), ADD(3, "입력"), MODIFY(4, "수정"), DELETE(5, "삭제"), END(99, "끝내기");

	private final int seq;
	private final String name;

	private Menu(int seq, String name) {
		this.seq = seq;
		this.name = name;
	}

	public int getSeq() {
		return seq;
	}

	public String getName() {
		return name;
	}

	public static Menu from(int seq) {
		for (Menu menu : values()) {
			if (seq == menu.getSeq()) {
				return menu;
			}
		}

		throw new IllegalArgumentException("존재하지 않는 메뉴입니다. : " + seq);
	}

}
