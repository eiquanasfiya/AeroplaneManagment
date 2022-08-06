package service;

import repository.LoginRepository;

public class AuthnticationService {
    public static String login(String username,String password){
        LoginRepository loginRepository = new LoginRepository();
        return loginRepository.login(username, password);

    }
}
