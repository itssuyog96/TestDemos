package demo1;

import java.util.Date;

public class UDate {
	private int date = 1, month = 1, year = 2018;
	private static final String sep = "-";
	private static final String[] MONTH_NAMES = { "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY",
			"AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER" };
	public static final int SHORT_DATE = 1;
	public static final int LONG_DATE = 5;
	public static final int NORMAL_DATE = 3;

	private static int dateStyle = NORMAL_DATE;

	public static void setDateStyle(int style) {
		dateStyle = style;
	}

	public UDate(int date, int month, int year) throws InvalidDateException {

		if (year >= 1970 && year <= 2018) {
			this.year = year;

			if (month >= 1 && month <= 12) {
				this.month = month;
				int maxDate = ((month == 2)
						? ((year % 100 == 0 && year % 400 == 0) || (year % 100 != 0 && year % 4 == 0) ? 29 : 28)
						: (month <= 7 && month >= 1 ? (month % 2 == 0 ? 30 : 31)
								: (month >= 8 && month <= 12 ? (month % 2 == 0 ? 31 : 30) : 999)));
				if (maxDate != 999 && date >= 1 && date <= maxDate) {
					this.date = date;
				} else {
					throw new InvalidDateException("Date should be an integer and in the range 1-" + maxDate
							+ " for the month " + MONTH_NAMES[month - 1]);
				}
			} else {
				throw new InvalidDateException("Month should be an integer in range 1-12");
			}
		} else {
			throw new InvalidDateException("Year should be an integer in range 1970-" + (new Date().getYear() + 1900));
		}
	}

	public void print() {

		System.out.println("Date: " + date + sep + month + sep + year);
	}

	public String toString() {
		switch (UDate.dateStyle) {
		case NORMAL_DATE:
			return date + ", " + MONTH_NAMES[month - 1].substring(0, 3) + " " + year;
		case LONG_DATE:
			return year + ", " + MONTH_NAMES[month - 1] + " " + date;
		case SHORT_DATE:
			return date + sep + month + sep + year;
		default:
			return date + ", " + MONTH_NAMES[month - 1].substring(0, 3) + " " + year;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + date;
		result = prime * result + month;
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UDate other = (UDate) obj;
		if (date != other.date)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

}
