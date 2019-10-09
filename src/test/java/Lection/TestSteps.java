package Lection;

import io.qameta.allure.Step;

public class TestSteps {
    @Step
    public void login(User user) {
        fillLogin(user.getLogin());
        fillPassword(user.getPassword());
    }

    @Step
    private void fillLogin(String login) {
        System.out.println("fill login");
    }

    @Step
    private void fillPassword (String password) {
        System.out.println("fill password");
    }
}
