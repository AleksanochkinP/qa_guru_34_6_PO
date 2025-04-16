
package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakeData {
    Faker faker = new Faker(new Locale("en"));
    public String name;
    public String lastName;
    public String email;
    public String gender;
    public String phoneNumber;
    public String dayOfBirth;
    public String monthOfBirth;
    public String yearOfBirth;
    public String subject;
    public String hobbies;
    public String picture;
    public String address;
    public String state;
    public String city;


    public String getRandomFirstName() {
        String fakeFirstName = faker.name().firstName();
        name = fakeFirstName;
        return fakeFirstName;
    }

    public String getRandomLastName() {
        String fakeLastName = faker.name().lastName();
        lastName = fakeLastName;
        return fakeLastName;
    }

    public String getRandomEmail() {
        String fakeEmail = faker.internet().emailAddress();
        email = fakeEmail;
        return fakeEmail;
    }

    public String getRandomGender() {
        String fakeGender = faker.options().option("Male", "Female", "Other");
        gender = fakeGender;
        return fakeGender;
    }

    public String getRandomPhoneNumber() {
        String fakePhoneNumber = faker.phoneNumber().subscriberNumber(10);
        phoneNumber = fakePhoneNumber;
        return fakePhoneNumber;
    }

    public String getRandomDayOfBirth() {
        String fakeDayOfBirth = String.format("%02d", faker.number().numberBetween(1, 28));
        dayOfBirth = fakeDayOfBirth;
        return fakeDayOfBirth;
    }

    public String getRandomMonthOfBirth() {
        String fakeMonthOfBirth = faker.options().option("January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December");
        monthOfBirth = fakeMonthOfBirth;
        return fakeMonthOfBirth;
    }

    public String getRandomYearOfBirth() {
        String fakeYearOfBirth = String.format("%02d", faker.number().numberBetween(1970, 2024));
        yearOfBirth = fakeYearOfBirth;
        return fakeYearOfBirth;
    }

    public String getRandomSubject() {
        String fakeSubject = faker.options().option("Physics", "Computer Science", "Chemistry", "Economics");
        subject = fakeSubject;
        return fakeSubject;
    }

    public String getRandomHobbies() {
        String fakeHobbies = faker.options().option("Sports", "Reading", "Music");
        hobbies = fakeHobbies;
        return fakeHobbies;
    }

    public String getRandomPicture() {
        String randomPicture = faker.options().option( "Исх. № ФС-3.25 от 22.01.pdf");
        picture = randomPicture;
        return randomPicture;
    }

    public String getRandomAddress() {
        String fakeAddress = faker.address().fullAddress();
        address = fakeAddress;
        return fakeAddress;
    }

    public String getRandomState() {
        String randomState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
        state = randomState;
        return randomState;
    }

    public String getRandomCity(){
        return city = (switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        });


    }

}
