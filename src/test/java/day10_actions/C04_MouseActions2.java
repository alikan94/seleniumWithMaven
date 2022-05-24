package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_MouseActions2 extends TestBase {
    /*
        Yeni bir class olusturalim: MouseActions2
        1- https://demoqa.com/droppable adresine gidelim
        2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
     */


    @Test
    public void test01(){
        //      1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //      2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);
        WebElement tasinacakElement = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement birakilacakElement = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        actions.dragAndDrop(tasinacakElement,birakilacakElement).perform();
        //      3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

        String expectedYazi = "Dropped!";
        String actualYazi = driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();
        Assert.assertEquals(expectedYazi,actualYazi);
    }
}
