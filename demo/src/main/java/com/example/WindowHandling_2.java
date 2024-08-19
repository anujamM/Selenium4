package com.example;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling_2 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit

        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // WebElement iAmFeelingLuckyLink = driver.findElement((By.xpath("(//input[@class='RNmpXc'])[2]")));
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='RNmpXc'])[2]")));

        // WebElement advertising = driver.findElement((By.xpath("(//a[@class='pHiOh'])[1]")));
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='pHiOh'])[1]")));

        // WebElement business = driver.findElement((By.xpath("(//a[@class='pHiOh'])[2]")));
        // wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("(//a[@class='pHiOh'])[2]"))));

        // WebElement howSearchWorks = driver.findElement((By.xpath("(//a[@class='pHiOh'])[3]")));
        // wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("(//a[@class='pHiOh'])[2]"))));

        WebElement footerDiv = driver.findElement(By.className("KxwPGc AghGtd"));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.className("KxwPGc AghGtd"))));

        System.out.println(footerDiv.findElement(By.tagName("a")).getSize());


        // Actions actions = new Actions(driver);
        // actions.keyDown(Keys.COMMAND).click(iAmFeelingLuckyLink).keyUp(Keys.CONTROL).build().perform();



    
    }
}
