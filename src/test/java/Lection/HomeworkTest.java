package Lection;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class HomeworkTest {
    TestSteps testSteps = new TestSteps();

    @Test
    @DisplayName("test Vasya login")
    public void TestOne () {
        testSteps.login(new User("Vasya", "qwerty"));
    }
}
