package test;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class AutoFormPageObjectTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    String firstName = "Pavel";
    String lastName = "Aleksanochkin";
    String userEmail = "Aleksanochkin@gmail.com";
    String gender = "Male";
    String userNumber = "7912312312";
    String month = "April";
    String year = "1996";
    String day = "03";
    String subject = "Computer";
    String hobbies = "Sports";
    String uploadImage = "Исх. № ФС-3.25 от 22.01.pdf";
    String currentAddress = "Moscow Never Sleeps";
    String state = "NCR";
    String city = "Noida"

    @Test
    void successRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDay(day, month, year)
                .setSubjects(subject)
                .setHobbies(hobbies)
                .setPicture(uploadImage)
                .setAddress(currentAddress)
                .setStateAndCity(state, city)
                .submitForm();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", "Исх. № ФС-3.25 от 22.01.pdf")
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void successRegistrationMinimalInputTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .submitForm();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber);
    }

    @Test
    void negativeRegistrationTest1() {
        registrationPage.openPage()
                .removeBanner()
                .submitForm();

        registrationPage.checkInvalidInput();
    }

    @Test
    void negativeRegistrationTest2() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .submitForm();

        registrationPage.checkInvalidInput();
    }

}