package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.example.model.Movie;
import com.example.model.DefaultMessage;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Movie Test
        Movie movie = (Movie) context.getBean("movieBean");
        movie.displayMovieDetails();

        // DefaultMessage Test
        DefaultMessage defaultMessage = (DefaultMessage) context.getBean("defaultMessageBean");
        defaultMessage.displayMessage();
    }
}
