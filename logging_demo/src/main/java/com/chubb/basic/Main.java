package com.chubb.basic;

import org.apache.log4j.Logger;

public class Main {
    static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        logger.debug("TMH");

        Author a = new Author("John", 30);
        Book b = new Book("Java Basics", a, 1);

        logger.info("Book:" + b);
    }
}
