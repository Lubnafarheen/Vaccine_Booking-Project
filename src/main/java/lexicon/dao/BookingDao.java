package lexicon.dao;

import lexicon.model.Booking;
import lexicon.model.Patient;

import java.time.LocalDate;
import java.util.List;

public interface BookingDao {

    void generateBookingTable(LocalDate localDate, int numberOfDays);

    List<Booking> findByDateBetween(LocalDate start, LocalDate end);

    List<Booking> findByDate(LocalDate date);

    boolean reserve(String bookingId, Patient patient);

    boolean cancel(String bookingId, Patient patient);

    List<Booking> findBookingByPersonalNumber(String personalNumber);
}
