package ru.antipant.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import ru.antipant.pages.RegistrationFormPage;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;
import static ru.antipant.utils.FakerUtils.*;

public class RegistrationFormTests {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    String firstName = getFakerName(),
            lastName = getFakerSurName(),
            userEmail = getFakerEmail(),
            userGender = "Other",
            userNumber = "1231231230",
            day = "30",
            month = "July",
            year = "2008",
            subjects = "Math",
            hobbies = "Sports",
            namePicture = "Pushkin.jpg",
            address = getFakerAddress(),
            state = "NCR",
            city = "Delhi";
    String expectedFullName = format("%s %s", firstName, lastName),
            expectedDate = format("%s %s,%s", day, month,year),
            expectedStateAndCity = format("%s %s", state, city);

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("1231231230");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/Pushkin.jpg");
        //$("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
        $("#currentAddress").setValue("Some street 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName + " " + lastName), text(userEmail), text("Other"));
        $(".table-responsive").shouldHave(text(expectedFullName), text(userEmail), text("Other"));
    }

    @Test
    public void registrationFormTest() {

        registrationFormPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setBirthDate(day, month, year)
                .setSubjects(subjects)
                .setUserHobbies(hobbies)
                .upLoadPicture(namePicture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submitClick()
                .checkCompletedForm("Student Name", expectedFullName)
                .checkCompletedForm("Student Email", userEmail)
                .checkCompletedForm("Gender", userGender)
                .checkCompletedForm("Mobile", userNumber)
                .checkCompletedForm("Date of Birth", expectedDate)
                .checkCompletedForm("Subjects", subjects)
                .checkCompletedForm("Hobbies", hobbies)
                .checkCompletedForm("Picture", namePicture)
                .checkCompletedForm("Address", address)
                .checkCompletedForm("State and City", expectedStateAndCity);
    }

}
