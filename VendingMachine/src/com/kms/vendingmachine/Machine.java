package com.kms.vendingmachine;

import java.util.*;

public class Machine {
	Scanner scan = new Scanner(System.in);
	List<MenuItem> menu = new ArrayList<MenuItem>();
	List<MenuItem> buyItem = new ArrayList<MenuItem>();
	private int money;

	// 제품 생성
	public Machine() {
		menu.add(new MenuItem(1, "코카콜라", 2000));
		menu.add(new MenuItem(2, "나랑드", 1000));
		menu.add(new MenuItem(3, "파워에이드", 2000));
		menu.add(new MenuItem(4, "환타", 1000));
		menu.add(new MenuItem(5, "밀키스", 1500));
		menu.add(new MenuItem(6, "레쓰비", 800));
		menu.add(new MenuItem(7, "삼다수", 1000));
	}

	public int getMoney() {
		return money;
	}

	// 메뉴 보이기
	public void showMenu() {
		System.out.println("======Menu======");
		for (int i = 0; i < menu.size(); i++) {
			MenuItem mi = menu.get(i);
			System.out.println(mi);
		}
		System.out.println("================");
	}

	// 돈 넣고 구입(구매할수있는 상품 보이기)
	public void availableProducts(int money) {
		buyItem.removeAll(menu);

		this.money = money;
		System.out.println("-----구입할수 있는 상품-----");
		for (MenuItem mi : menu) {
			if (mi.getPrice() <= money) {
				System.out.println(mi);
				buyItem.add(mi);
			}
		}
		System.out.println("----------------------");

	}

	

	// 제품 구매
	public MenuItem buyDrink() {
		while (true) {
			System.out.print("제품을 선택하세요 : ");
			int selectMenu = scan.nextInt();
			MenuItem mi = returnMenu(selectMenu);
			if (mi == null) {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			} else {
				this.money -= mi.getPrice();
				return mi;
			}
		}
	}
	
	// 제품값 주기
		public MenuItem returnMenu(int selectMenu) {
			for (MenuItem mi : buyItem) {
				if (mi.getItemNumber() == selectMenu) {
					return mi;
				}
			}
			return null;
		}

	// 잔돈 주기
	public int change() {
		int temp = this.money;
		this.money = 0;
		return temp;
	}

	// 제품객체
	public iDrinking WhatDrink(MenuItem mi) {
		iDrinking drinking = null;
		switch (mi.getName()) {
		case "코카콜라":
			drinking = new Coke(mi);
			break;
		case "환타":
			drinking = new Fanta(mi);
			break;
		case "파워에이드":
			drinking = new Powerade(mi);
			break;
		case "밀키스":
			drinking = new Milkis(mi);
			break;
		case "나랑드":
			drinking = new Narangd(mi);
			break;
		case "삼다수":
			drinking = new Samdasu(mi);
			break;
		case "레쓰비":
			drinking = new LetsBe(mi);
			break;
		}
		return drinking;
	}

}
