package domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;
/**
 * @author Alexander Eriksson nbt12aen
 */
public enum Resolution {

	DAY {
		@Override
		public String getDateString(LocalDate key) {
			return key.format(DateTimeFormatter.ISO_DATE);
		}

	},
	YEAR {
		@Override
		public String getDateString(LocalDate key) {
			return key.format(DateTimeFormatter.ofPattern("yyyy"));

		}

	},
	MONTH {
		@Override
		public String getDateString(LocalDate key) {
			return key.format(DateTimeFormatter.ofPattern("yyyy-MM"));

		}

	},
	QUARTER {
		@Override
		public String getDateString(LocalDate key) {
			return ("" + key.getYear() + "-Q" + (key.getMonthValue() + 2) / 3);
		}

	},
	WEEK {
		@Override
		public String getDateString(LocalDate key) {
			WeekFields weekFields = WeekFields.of(Locale.getDefault());
			int weekNumber = key.get(weekFields.weekOfWeekBasedYear());
			return (key.getYear() + "-W" + weekNumber);
		}
	};

	

	public abstract String getDateString(LocalDate key);
}
