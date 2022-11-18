package lexicon.model;

import java.time.LocalDate;

public class Patient {

    private String personalNumber;
    private String name;
    private String email;
    private LocalDate birthDate;
    private AppUser appUser;

    public Patient(String personalNumber, String name, String email, AppUser appUser) {
        setPersonalNumber(personalNumber);
        setName(name);
        setEmail(email);
        setAppUser(appUser);
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        if (personalNumber == null)throw new IllegalArgumentException("Personal number cannot be null");
        this.personalNumber = personalNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null)throw new IllegalArgumentException("name cannot be null");
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        if (birthDate == null)throw new IllegalArgumentException("BirthDate cannot be null");
        this.birthDate = birthDate;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        if (appUser == null)throw new IllegalArgumentException("AppUser cannot be null");
        this.appUser = appUser;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "personalNumber='" + personalNumber + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
