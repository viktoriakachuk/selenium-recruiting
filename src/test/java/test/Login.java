package test;

import entity.User;
import parser.DomParser;
import web.page.LoginPage;

public abstract class Login {

    public void login(String role){
        DomParser parser = new DomParser();
        User user = parser.parseUser(role);
        LoginPage lp = new LoginPage();
        lp.enterLoginPage();
        lp.fillinLoginField(user.getLogin());
        lp.fillinPasswordField(user.getPassword());
        lp.clickEnterButton();
    }

}
