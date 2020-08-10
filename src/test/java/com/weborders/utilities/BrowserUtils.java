package com.weborders.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.*;
import java.util.Date;

public class BrowserUtils {


    public static void takeScreenshot() {
        /*
        Serhat Alturk:the_horns::skin-tone-2:  9:03 PM
          I do not know if its fixed, The reason screenshot utility does not work is because Windows do not accept some special characters like ":" in file names. So hopefully this code snippet will help you.
        1-I have created a String out of the given date by using toString method.
        2-I have replaced ":" with "." using ReplaceAll method.
        3-I have used the String variable at path instead of the date instance
         */
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
        byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);

        Date date = new Date();
        String date_to_string = date.toString().replaceAll(":", ".");
        String path = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + date_to_string + "_image.png";

        try (FileOutputStream fileOutputStream = new FileOutputStream(path)) {
            fileOutputStream.write(screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

    /*
    Vasyl'in Kodlari:

    public static void takeScreenshot(){
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
        byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        Date date = new Date();
        String path = System.getProperty("user.dir") + File.separator + "screenshots"+ File.separator + date+"_image.png";
        try(FileOutputStream fileOutputStream = new FileOutputStream(path)){
            fileOutputStream.write(screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
     */