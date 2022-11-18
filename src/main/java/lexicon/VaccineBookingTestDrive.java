package lexicon;

import lexicon.dao.*;
import lexicon.model.AppUser;
import lexicon.model.Booking;
import lexicon.model.Patient;

import java.time.LocalDate;
import java.util.List;

public class VaccineBookingTestDrive {
    public static void main(String[] args) {
        AppUser user1 = new AppUser("Lubna", "password");
        AppUser user2 = new AppUser("Maira", "password");
        AppUser user3 = new AppUser("Mina", "password");

        AppUserDao storage = new AppUserDaoImpl();
        AppUser createdAppuser1 = storage.create(user1);
        AppUser createdAppuser2 = storage.create(user2);
        AppUser createdAppuser3 = storage.create(user3);

        Patient patientData1 = new Patient("11101", "Lubna", "test@gmail.com", createdAppuser1);
        Patient patientData2 = new Patient("11102", "Lubna", "test@gmail.com", createdAppuser2);
        Patient patientData3 = new Patient("11101", "Mina", "test@gmail.com", createdAppuser3);

        BookingDao bookingStorage = new BookingDaoImpl();
        bookingStorage.generateBookingTable(LocalDate.parse("2023-01-01"), 2);
        List<Booking> bookingList = bookingStorage.findByDateBetween(LocalDate.parse("2023-01-01"), LocalDate.parse("2023-01-02"));
        String bookingId1 = bookingList.get(1).getId();
        String bookingId2 = bookingList.get(2).getId();

        for (Booking booking : bookingList) {
            System.out.println(booking);
        }
        boolean isBookingDone = bookingStorage.reserve(bookingId1, patientData1);
        boolean isBookingDone1 = bookingStorage.reserve(bookingId2, patientData1);
        boolean isBookingcancelled = bookingStorage.cancel(bookingId1, patientData1);

        System.out.println(isBookingDone);
        for (Booking booking : bookingList) {
            System.out.println(booking);
        }

        System.out.println(bookingStorage.findBookingByPersonalNumber("11101"));

    }

}
