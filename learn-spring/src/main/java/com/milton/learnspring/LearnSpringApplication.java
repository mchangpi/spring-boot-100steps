package com.milton.learnspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.milton.learnspring.game.GameRunner;
import com.milton.learnspring.game.MarioGame;
import com.milton.learnspring.sample.enterprise.flow.web.MyController;

@SpringBootApplication
public class LearnSpringApplication {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = 
        SpringApplication.run(LearnSpringApplication.class, args);
    
    GameRunner runner = context.getBean(GameRunner.class);
    MyController controller = context.getBean(MyController.class);
    
    System.out.println("controller: " + controller.displaySum());

    runner.runGame();
  }

}
