package com.pchudzik.blog.example.random;

import java.time.Clock;
import java.time.LocalDateTime;

class DiscountService {
	private final Clock clock;

	DiscountService(Clock clock) {
		this.clock = clock;
	}

	public boolean isActive(Discount discount) {
		final LocalDateTime now = LocalDateTime.now(clock);
		return discount.startDate.isAfter(now) && discount.endDate.isBefore(now);
	}

	static class Discount {
		private final LocalDateTime startDate;
		private final LocalDateTime endDate;

		Discount(LocalDateTime startDate, LocalDateTime endDate) {
			this.startDate = startDate;
			this.endDate = endDate;
		}
	}
}
