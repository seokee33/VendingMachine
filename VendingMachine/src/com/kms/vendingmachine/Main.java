package com.kms.vendingmachine;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Machine machine = new Machine();
		Customer customer = new Customer(10000);

		while (true) {
			machine.showMenu();
			int num;
			if (machine.getMoney() >= 800) {
				System.out.printf("현재 자판기에 있는 돈 : %d\n", machine.getMoney());
				System.out.println("돈을 더 넣으시겠습니까?(Yes : 1, No :2)");
				while(true) {
				num = scan.nextInt();
				if(num == 1) {
					machine.availableProducts(customer.insertMoney());
					break;
				}else if(num == 2) {
					machine.availableProducts(machine.getMoney());
					break;
				}else {
					System.out.println("잘못입력하셨습니다!");
					continue;
				}
				}
			} else {
				machine.availableProducts(customer.insertMoney());
			}
			MenuItem mi = machine.buyDrink();
			iDrinking drinking = machine.WhatDrink(mi);
			customer.haveDrrink(drinking);
			customer.printHaveDrrink();
			System.out.println();

			System.out.printf("현재 자판기에 있는 돈 : %d\n", machine.getMoney());
			machine.availableProducts(machine.getMoney());
			int iNum;
			while (true) {
				System.out.print("더 구입하시겠습니까?(Yes : 1, No :2)");
				iNum = scan.nextInt();
				if (iNum == 1) {
					break;
				} else if (iNum == 2) {
					break;
				} else {
					System.out.println("다시입력해주세요");
					continue;
				}
			}
			if (iNum == 2) {
				customer.receiveChange(machine.change());
				break;
			} else if (iNum == 1) {
				continue;
			}

		}

	}
}
