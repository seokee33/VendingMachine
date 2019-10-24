package com.kms.vendingmachine;

import java.util.*;

public class Customer {
	private int money;
	private List<iDrinking> have = new ArrayList<iDrinking>();

	public Customer(int money) {
		this.money = money;
	}

	// 돈넣기
	public int insertMoney() {
		Scanner scan = new Scanner(System.in);
		System.out.println("얼마를 넣을까?");
		int money = scan.nextInt();
		this.money -= money;
		return money;
	}

	// 음료 가지기
	public void haveDrrink(iDrinking drink) {
		have.add(drink);
		
	}
	// 잔돈받기
	public void receiveChange(int money) {
		this.money += money;
	}
	//가지고 있는 음료 출력
	public void printHaveDrrink() {
		for (int i = 0; i < have.size(); i++) {
			System.out.printf("%s를 구입했다.\n", have.get(i).getDrinkName());
		}
	}
}
