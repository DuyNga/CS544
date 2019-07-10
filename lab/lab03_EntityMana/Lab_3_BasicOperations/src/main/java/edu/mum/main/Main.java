package edu.mum.main;


import java.awt.print.Book;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import edu.mum.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.domain.User;
import edu.mum.service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    private static EntityManagerFactory emf;

    public static void main(String[] args) throws ParseException {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("context/applicationContext.xml");

        UserService userService = (UserService) ctx.getBean("userServiceImpl");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");

        // Create new instance of User and set values in it
        User user = new User("John", "Doe",
                "email@email.com", 5, true,
                1, sdf.parse("1999/03/02 11:30:32"));
        // save the User
        userService.save(user);

        user = userService.findByEmail("email@email.com");
        System.out.println("************** User **************");
        System.out.println(String.format("User Name: %s %s",
                user.getFirstName(), user.getLastName()));
    }

}