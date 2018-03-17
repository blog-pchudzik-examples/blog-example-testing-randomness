package com.pchudzik.blog.example.random;

import java.util.Random;

/*
 __     __               _           _ _
 \ \   / /              | |         | | |
  \ \_/ /__  _   _   ___| |__   __ _| | |
   \   / _ \| | | | / __| '_ \ / _` | | |
    | | (_) | |_| | \__ \ | | | (_| | | |
    |_|\___/ \__,_| |___/_| |_|\__,_|_|_|
             | |
  _ __   ___ | |_   _ __   __ _ ___ ___
 | '_ \ / _ \| __| | '_ \ / _` / __/ __|
 | | | | (_) | |_  | |_) | (_| \__ \__ \
 |_| |_|\___/ \__| | .__/ \__,_|___/___/
                   | |
                   |_|
 */
public class Mage {
	static final int ATTACK_FACTOR = 5;
	private int baseAttack;

	public Mage(int baseAttack) {
		this.baseAttack = baseAttack;
	}

	public int attack(Random random) {
		final int attackFactor = random.nextInt((ATTACK_FACTOR + 1));
		final int extraAttackPoints = attackFactor == 0 ? 0 : baseAttack / attackFactor;
		return baseAttack + extraAttackPoints;
	}
}
