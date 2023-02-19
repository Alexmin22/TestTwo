package org.example;

import dao.UserDAOImpl;
import model.User;
import service.UserServiceImpl;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();

        User user1 = new User(r.nextInt(1, 10000),
                "User "+r.nextInt(10000), r.nextInt(18, 99) );
        User user2 = new User(r.nextInt(1, 10000),
                "User "+r.nextInt(10000), r.nextInt(18, 99) );
        User user3 = new User(r.nextInt(1, 10000),
                "User "+r.nextInt(10000), r.nextInt(18, 99) );
        User user4 = new User(r.nextInt(1, 10000),
                "User "+r.nextInt(10000), r.nextInt(18, 99) );
        User user5 = new User(r.nextInt(1, 10000),
                "User "+r.nextInt(10000), r.nextInt(18, 99) );
        User user6 = new User(r.nextInt(1, 10000),
                "User "+r.nextInt(10000), r.nextInt(18, 99) );
        User user7 = new User(r.nextInt(1, 10000),
                "User "+r.nextInt(10000), r.nextInt(18, 99) );
        User user8 = new User(r.nextInt(1, 10000),
                "User "+r.nextInt(10000), r.nextInt(18, 99) );
        User user9 = new User(r.nextInt(1, 10000),
                "User "+r.nextInt(10000), r.nextInt(18, 99) );
        User user10 = new User(r.nextInt(1, 10000),
                "User "+r.nextInt(10000), r.nextInt(18, 99) );


        UserServiceImpl us = new UserServiceImpl(new UserDAOImpl());

        us.createTable();

        us.saveUser(user1);
//        us.saveUser(user2);
//        us.saveUser(user3);
        us.saveUser(user4);
        us.saveUser(user5);
//        us.saveUser(user6);
//        us.saveUser(user7);
//        us.saveUser(user8);
//        us.saveUser(user9);
//        us.saveUser(user10);
//
        //    us.getAllUsers();
//
        us.removeUserID(user4);
//
//        us.cleanUserTable();
 //          us.dropTable();
    }
}