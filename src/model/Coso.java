package model;

import java.util.Random;

public class Coso {

	public static void main(String[] args) {
		Random r = new Random(25);
		
		for (int i = 0; i < 10; i++) {
			System.out.println(r.nextInt(3));
		}
		System.out.println("----------");
		r = new Random(25);
		for (int i = 0; i < 10; i++) {
			System.out.println(r.nextInt(3));
		}
	}

}
