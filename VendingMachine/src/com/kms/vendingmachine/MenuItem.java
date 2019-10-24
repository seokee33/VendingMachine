package com.kms.vendingmachine;

public class MenuItem {
	private int itemNumber;
	private String name;
	private int price;

	public MenuItem(int itemNumber, String name, int price) {
		this.name = name;
		this.price = price;
		this.itemNumber = itemNumber;
	}
	public String getName() {
		return name;
	}
	public int getItemNumber() {
		return itemNumber;
	}
	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return String.format("%d, 제품명 : %s, 가격 : %d", itemNumber, name, price);
	}

}
