package uk.gov.moj.anonymisation.generator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class PastDateGenerator extends Generator<String> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public String convert(final String fieldValue) {
        LocalDate localDate = createRandomDate(LocalDate.now().getYear()-100, LocalDate.now().getYear());
        return localDate.format(FORMATTER);

    }

    private  int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public  LocalDate createRandomDate(int startYear, int endYear) {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
    }
}
