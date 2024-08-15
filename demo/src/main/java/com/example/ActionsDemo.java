package com.example;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsDemo {
    public static void main(String[] args) {
        WebDriver driver = WebDriverManager.chromedriver().create();

        driver.get("https://www.google.in");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        WebElement el = driver.findElement((By.id("APjFqb")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("APjFqb")));

        Actions act = new Actions(driver);
        System.out.println(el.isDisplayed());
        act.moveToElement(el).click().sendKeys("ANUJAM").doubleClick().build().perform();
        act.sendKeys(Keys.ENTER).build().perform();

        // WebElement el2 = driver.findElement(By.xpath("//*[local-name()='svg' and
        // @class='goxjub']"));

        WebElement el2 = driver.findElement(By.className("YmvwI"));
        Assert.

        // driver.quit();
    }
}
