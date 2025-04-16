package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultTableCheck;
import utils.FakeData;



public class AutoFormWithFakerTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    FakeData fakeData = new FakeData();
    ResultTableCheck resultCheck = new ResultTableCheck();


    @Test
    void registrationPageFullTest() {
        registrationPage.openPage()
                .closeBanner()
                .setFirstName(fakeData.getRandomFirstName())
                .setLastName(fakeData.getRandomLastName())
                .setEmail(fakeData.getRandomEmail())
                .setGender(fakeData.getRandomGender())
                .setUserNumber(fakeData.getRandomPhoneNumber())
                .setDateOfBirth(fakeData.getRandomDayOfBirth(), fakeData.getRandomMonthOfBirth(), fakeData.getRandomYearOfBirth())
                .setSubjectInput(fakeData.getRandomSubject())
                .setHobbies(fakeData.getRandomHobbies())
                .selectUploadPicture(fakeData.getRandomPicture())
                .setAddress(fakeData.getRandomAddress())
                .setState(fakeData.getRandomState())
                .setCity(fakeData.getRandomCity())
                .clickSubmit()
                .checkResult("Student Name", fakeData.name + " " + fakeData.lastName)
                .checkResult("Student Email", fakeData.email)
                .checkResult("Gender", fakeData.gender)
                .checkResult("Mobile", fakeData.phoneNumber)
                .checkResult("Date of Birth", fakeData.dayOfBirth + " " + fakeData.monthOfBirth + "," + fakeData.yearOfBirth)
                .checkResult("Subjects", fakeData.subject)
                .checkResult("Hobbies", fakeData.hobbies)
                .checkResult("Picture", fakeData.picture)
                .checkResult("Address", fakeData.address)
                .checkResult("State and City", fakeData.state + " " + fakeData.city);
    }

    @Test
    void registrationPageMinimalTest() {
        registrationPage.openPage()
                .setFirstName(fakeData.getRandomFirstName())
                .setLastName(fakeData.getRandomLastName())
                .setGender(fakeData.getRandomGender())
                .setUserNumber(fakeData.getRandomPhoneNumber())
                .clickSubmit()
        .checkResult("Student Name", fakeData.name + " " + fakeData.lastName)
                .checkResult("Gender", fakeData.gender)
                .checkResult("Mobile", fakeData.phoneNumber);


    }

    @Test
    void negativeTest() {
        registrationPage.openPage()
                .setFirstName("")
                .clickSubmit()
                .checkFirstNameColorInput();


    }


}