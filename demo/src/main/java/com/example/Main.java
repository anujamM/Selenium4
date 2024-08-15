package com.example;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }
}