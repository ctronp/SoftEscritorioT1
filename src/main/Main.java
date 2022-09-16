package main;

import DTO.Club;
import DTO.Subscription;
import DTO.User;

public class Main {

    public static void main(String[] args) {

        User user1 = new User();

        user1.setName("Juan");
        user1.setEmail("JuanJose@gmail.cl");
        user1.setBirthDate("2000/09/11");
        user1.setRun(20537254, '7');
        user1.setPhoneNum(566688631);
        user1.setPassword("HolaComoVoceEsta123");
        user1.setUsername("user1username");

        Club club1 = new Club();
        club1.setColors("orange");
        club1.setCountry("Chile");
        club1.setFoundationYear(1990);
        club1.setMotto("Jugar Hasta Ganar");
        club1.setFounderName("Juan Lopez");
        club1.setName("Club Luiz Lopez");
        club1.setValueSub(21000);
        club1.setCode();

        Subscription sub = new Subscription(user1);
        sub.setTeams(club1);
        sub.setTeams(club1);

        sub.print();
        
        System.out.println("Login con contrasenna\n");
        System.out.println(user1.validateLogin("user1username", "HolaComoVoceEsta123"));
        
        System.out.println("Login fallido tras reinicio de contrasenna\n");
        user1.resetPassword();
        System.out.println(user1.validateLogin("user1username", "HolaComoVoceEsta123"));
        
    }
}
