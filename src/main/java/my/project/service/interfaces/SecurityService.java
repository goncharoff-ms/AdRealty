package my.project.service.interfaces;


public interface SecurityService {

    String findLoggenedInLogin();

    void autoLogin(String login, String password);


}
