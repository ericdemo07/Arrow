package com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.google.common.base.Joiner;

@SpringBootApplication
public class ArrowApplication {
	private final static Logger LOGGER = LoggerFactory.getLogger(ArrowApplication.class);
	private final static String[] logoARROW= {
			"",
			" _______  ______    ______    _______          ",
			"|   _   ||    _ |  |    _ |  |  _ _  ||       |",
			"|  |_|  ||   | ||  |   | ||  | |   | ||       |",
			"|       ||   |_||_ |   |_||_ | |   | ||       |",
			"|       ||    __  ||    __  || |   | ||   _   |",
			"|   _   ||   |  | ||   |  | || |_ _| ||  | |  |",
			"|__| |__||___|  |_||___|  |_||_______||__| |__|",

			"== By __________ =="
			};
	public static void main(String[] args) {
		SpringApplication.run(ArrowApplication.class, args);
        LOGGER.info(Joiner.on("\r\n").join(logoARROW));

	}
}
