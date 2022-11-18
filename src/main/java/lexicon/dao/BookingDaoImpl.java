package lexicon.dao;

import lexicon.model.Booking;
import lexicon.model.Patient;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class BookingDaoImpl implements BookingDao {

    private final List<Booking> bookingList;

    public BookingDaoImpl() {
        bookingList = new ArrayList<>();
    }

    @Override
    public void generateBookingTable(LocalDate localDate, int numberOfDays) {
        LocalTime startTime = LocalTime.parse("08:00");
        for (int i = 0; i < numberOfDays; i++) {
            for (int j = 0; j < 10; j++) {
                Booking booking = new Booking(LocalDateTime.of(localDate.plusDays(i), startTime.plusHours(j)), 0, "CV4");
                bookingList.add(booking);
            }
        }
    }

    @Override
    public List<Booking> findByDateBetween(LocalDate start, LocalDate end) {
        List<Booking> newBookingList = new ArrayList<>();
        for (Booking booking : bookingList) {
            LocalDate bookingDate = booking.getDateTime().toLocalDate();
            if ((bookingDate.isAfter(start) || bookingDate.isEqual(start)) && (bookingDate.isBefore(end) || bookingDate.isEqual(end))) {
                newBookingList.add(booking);
            }
        }
        return newBookingList;
    }

    @Override
    public List<Booking> findByDate(LocalDate date) {
        List<Booking> newBookingList = new ArrayList<>();
        for (Booking booking : bookingList) {
            LocalDate bookingDate = booking.getDateTime().toLocalDate();
            if (bookingDate.isEqual(date)) {
                newBookingList.add(booking);
            }
        }

        return newBookingList;
    }

    @Override
    public boolean reserve(String bookingId, Patient patient) {
        for (Booking booking : bookingList) {
            if (booking.isVacant() && booking.getId().equalsIgnoreCase(bookingId)) {
                booking.setPatient(patient);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean cancel(String bookingId, Patient patient) {
        for (Booking booking : bookingList) {
            if (booking.getId().equalsIgnoreCase(bookingId)) {
                booking.setPatient(null);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Booking> findBookingByPersonalNumber(String personalNumber) {
        List<Booking> newBookingList = new ArrayList<>();
        for (Booking booking : bookingList) {
            if (booking.getPatient() != null && booking.getPatient().getPersonalNumber().equalsIgnoreCase(personalNumber)) {
                newBookingList.add(booking);
            }
        }
        return newBookingList;

    }
}
