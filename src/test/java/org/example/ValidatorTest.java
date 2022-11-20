package org.example;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    Validator validator;
    String name;
    String nameError;
    String surname;

    String surnameError;
    String patronymic;
    String patronymicError;

    @BeforeEach
    void setUp() {
        validator=new Validator();
        name = "Taras";
        surname = "Ivanov";
        patronymic = "Vadimovich";
        nameError="Igvj6";
        surnameError="kjh8";
        patronymicError="hh5";
    }

    @Test
    void valid() {
        Assert.assertTrue(validator.valid(name, surname,patronymic));
    }

    @Test
    void validErrorInputData() {
        Assert.assertFalse(validator.valid(nameError, surname,patronymic));
    }


    @Test
    void validNSP() {
        Assert.assertTrue(validator.validNSP(name + " " + surname + " " + patronymic));
    }

    @Test
    void validNSPOnliName() {
        Assert.assertTrue(validator.validNSP(name));
    }

    @Test
    void validNSPOnliNameAndSurname() {
        Assert.assertTrue(validator.validNSP(name));
    }

    @Test
    void validNSPError() {
        Assert.assertFalse(validator.validNSP(nameError + " " + surname + " " + patronymic));
    }
}