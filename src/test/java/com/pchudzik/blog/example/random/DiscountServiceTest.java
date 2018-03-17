package com.pchudzik.blog.example.random;

import com.pchudzik.blog.example.random.DiscountService.Discount;
import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.junit.Assert.assertFalse;

/**
 * Those tests are bad because they are not verify corner cases.
 */
public class DiscountServiceTest {
	private final long nowMilliseconds = 1521056135184L;
	private final Clock fixedClock = Clock.fixed(Instant.ofEpochMilli(nowMilliseconds), ZoneId.systemDefault());
	private final LocalDateTime now = LocalDateTime.now(fixedClock);

	private final DiscountService discountService = new DiscountService(fixedClock);

	@Test
	public void should_be_inactive_when_before_start_date() {
		final LocalDateTime tomorrow = now.plusDays(1);
		final LocalDateTime dayAfterTomorrow = tomorrow.plusDays(1);

		assertFalse(discountService.isActive(new Discount(tomorrow, dayAfterTomorrow)));
	}

	@Test
	public void should_be_inactive_when_after_end_date() {
		final LocalDateTime yesterday = now.minusDays(1);
		final LocalDateTime dayBeforeYesterday = yesterday.minusDays(1);

		assertFalse(discountService.isActive(new Discount(dayBeforeYesterday, yesterday)));
	}

	@Test
	public void should_be_active_when_after_start_and_before_end_date() {
		final LocalDateTime yesterday = now.minusDays(1);
		final LocalDateTime tomorrow = now.plusDays(1);

		assertFalse(discountService.isActive(new Discount(yesterday, now)));
	}
}
