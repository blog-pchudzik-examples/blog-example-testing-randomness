package com.pchudzik.blog.example.random;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class MageAttackTest {
	private final int minAttackFactor = 0;
	private final int maxAttackFactor = Mage.ATTACK_FACTOR;

	@Test
	public void should_have_at_least_base_attack_strength() {
		//given
		final int baseAttack = 100;

		//when
		final int attackPoints = new Mage(baseAttack).attack(fixedRandom(minAttackFactor));

		//then
		assertEquals(baseAttack, attackPoints);
	}

	@Test
	public void should_have_up_to_20_percent_more_attack_strength() {
		//given
		final int baseAttack = 100;

		//when
		final int attackPoints = new Mage(baseAttack).attack(fixedRandom(maxAttackFactor));

		//then
		assertEquals(baseAttack + 20, attackPoints);
	}

	private Random fixedRandom(int number) {
		return new Random() {
			@Override
			public int nextInt(int bound) {
				return number;
			}
		};
	}
}
