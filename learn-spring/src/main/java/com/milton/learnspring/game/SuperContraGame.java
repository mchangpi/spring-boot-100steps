package com.milton.learnspring.game;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Primary;

@Component
@Primary
public class SuperContraGame implements GamingConsole{
	
	public void up() {
		System.out.println("SuperContraGame up");
	}

	public void down() {
		System.out.println("down");
	}
	
	public void left() {
		System.out.println("left");
	}
	
	public void right() {
		System.out.println("right");
	}
	
}
