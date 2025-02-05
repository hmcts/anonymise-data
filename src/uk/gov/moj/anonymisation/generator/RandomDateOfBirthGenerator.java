package uk.gov.moj.anonymisation.generator;

import static java.time.temporal.ChronoField.EPOCH_DAY;
import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDateOfBirthGenerator extends Generator<String> {
    private final static int minAge = 20;
    private final static int maxAge = 100;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    @Override
    public String convert(final String fieldValue) {
        final LocalDate dateUpperLimit = LocalDate.now().minusYears(minAge);
        final LocalDate dateLowerLimit = LocalDate.now().minusYears(maxAge);
        return dateLowerLimit.plusDays(ThreadLocalRandom.current().longs(0,
                DAYS.between(dateLowerLimit, dateUpperLimit)).findFirst().orElse(dateUpperLimit.getLong(EPOCH_DAY)) + 1).format(FORMATTER);
    }
}
