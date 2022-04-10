package ru.antipant.pages;

import com.codeborne.selenide.SelenideElement;
import ru.antipant.pages.components.Calendar;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    private final Calendar calendar = new Calendar();

    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userGenderClick = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            userHobbies = $("#hobbiesWrapper"),
            upLoadPicture = $("#uploadPicture"),
            userAddress = $("#currentAddress"),
            setState = $("#react-select-3-input"),
            setCity = $("#react-select-4-input"),
            submitClick = $("#submit"),
            resultsTable = $(".table-responsive");

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationFormPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    public RegistrationFormPage setGender(String userGender) {
        userGenderClick.$(byText(userGender)).click();
        return this;
    }

    public RegistrationFormPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        dateInput.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage setSubjects(String subjects) {
        subjectsInput.setValue(subjects).pressEnter();
        return this;
    }

    public RegistrationFormPage setUserHobbies(String hobbies) {
        userHobbies.$(byText(hobbies)).click();
        return this;
    }

    public RegistrationFormPage upLoadPicture(String namePicture) {
        upLoadPicture.uploadFromClasspath("img/" + namePicture);
        return this;
    }

    public RegistrationFormPage setAddress(String address) {
        userAddress.setValue(address);
        return this;
    }

    public RegistrationFormPage setState(String state) {
        setState.setValue(state).pressEnter();
        return this;
    }

    public RegistrationFormPage setCity(String city) {
        setCity.setValue(city).pressEnter();
        return this;
    }

    public RegistrationFormPage submitClick() {
        submitClick.click();
        return this;
    }

    public RegistrationFormPage checkCompletedForm(String fieldName, String value) {
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
        return this;
    }

}
