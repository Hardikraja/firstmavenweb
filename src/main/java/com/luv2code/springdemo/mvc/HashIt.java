package com.luv2code.springdemo.mvc;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

public class HashIt {
    public static String hashThePassword(String password) throws Exception{
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        byte[] bytes = md.digest(password.getBytes());
        return new BASE64Encoder().encode(bytes);
    }
}
