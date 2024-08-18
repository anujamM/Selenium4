package com.example;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit

        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        WebElement el = driver.findElement((By.xpath("(//input[@class='RNmpXc'])[2]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='RNmpXc'])[2]")));

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.COMMAND).click(el).keyUp(Keys.CONTROL).build().perform();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> itr = windows.iterator();

        String parent = itr.next();
        String child = itr.next();

        driver.switchTo().window(child);
        System.out.println(driver.findElement(By.className("hero-tag-carousel__collage")).isDisplayed());
        driver.switchTo().window(parent);
        System.out.println(driver.findElement(By.className("lnXdpd")).isDisplayed());
        driver.quit();
        driver.switchTo().frame(el);
    }
}
