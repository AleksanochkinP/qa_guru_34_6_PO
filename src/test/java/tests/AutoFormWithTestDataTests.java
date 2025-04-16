package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.*;

public class AutoFormWithTestDataTests extends TestBase {
   TestData testData = new TestData();


    @Test
    public void fillFormTest() {

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue(firstname);
        $("#lastName").setValue(lastname);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").setValue(gender);
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").setValue(month);
        $(".react-datepicker__year-select").setValue(year);
        $(".react-datepicker__month").setValue(day);
        $("#uploadPicture").setValue(uploadPicture);
        $("#hobbiesWrapper").setValue(hobbies);
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#state").setValue(state);
        $("#city").click();
        $("#city").setValue(city);
        $("#submit").click();
        $(".table-responsive").shouldHave(text("Pavel Aleksanochkin"));
        $(".table-responsive").shouldHave(text("Aleksanochkin@gmail.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("7912312312"));
        $(".table-responsive").shouldHave(text("03 April,1996"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("Исх. № ФС-3.25 от 22.01.pdf"));
        $(".table-responsive").shouldHave(text("Moscow Never Sleeps"));
        $(".table-responsive").shouldHave(text("NCR Noida"));
    }
}