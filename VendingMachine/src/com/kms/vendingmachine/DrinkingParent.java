package com.kms.vendingmachine;

public class DrinkingParent implements iDrinking {
	private MenuItem mi;

	public DrinkingParent(MenuItem mi) {
		this.mi = mi;
	}

	@Override
	public String getDrinkName() {
		return mi.getName();
	}
}
