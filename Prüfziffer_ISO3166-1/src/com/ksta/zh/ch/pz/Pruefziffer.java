package com.ksta.zh.ch.pz;

public class Pruefziffer {
	static Integer sub = 1;
	static Integer total = 0;

	public static void main(String[] args) {

		for (char x : args[0].toCharArray()) {
			if (x != '.') {
				if (sub == 1) {
					total =  total + (sub * Character.getNumericValue(x));
					sub = 3;
				} else {
					total = total + (sub * Character.getNumericValue(x));
					sub = 1;
				}
			}

		}
		total = total % 10;
		total = 10 - total;
		System.out.println("Prüfziffer: " + total);

	}
}
