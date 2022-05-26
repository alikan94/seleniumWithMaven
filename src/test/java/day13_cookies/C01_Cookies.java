package day13_cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_Cookies extends TestBase {

    /*
    1- Amazon anasayfaya gidin
    2- tum cookie’leri listeleyin
    3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
    4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
    5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
    6- eklediginiz cookie’nin sayfaya eklendigini test edin
    7- ismi skin olan cookie’yi silin ve silindigini test edin
    8- tum cookie’leri silin ve silindigini test edin
     */


    @Test
    public void test01() {

        //    1- Amazon anasayfaya gidin

        driver.get("https://www.amazon.com/");
        //    2- tum cookie’leri listeleyin
        Set<Cookie> amazonCookiesSet = driver.manage().getCookies();

        int sayac = 1;
        for (Cookie w : amazonCookiesSet
        ) {
            System.out.println(sayac + " : " + w);
            System.out.println("name : " + w.getName());
            System.out.println("value : " + w.getValue());
            System.out.println("domain : " + w.getDomain());
            System.out.println("path : " + w.getPath());
            System.out.println("samesite : " + w.getSameSite());
            System.out.println("expiry : " + w.getExpiry());
            sayac++;
        }

        //    3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookieSayisi = amazonCookiesSet.size();
        Assert.assertTrue(cookieSayisi > 5);
        //    4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin


        for (Cookie w: amazonCookiesSet
             ) {
            if (w.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD",w.getValue());
            }
        }

        //    5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);
        amazonCookiesSet=driver.manage().getCookies();

        sayac = 1;
        for (Cookie w : amazonCookiesSet
        ) {
            System.out.println(sayac + " : " + w);
            System.out.println("name : " + w.getName());
            System.out.println("value : " + w.getValue());
            System.out.println("domain : " + w.getDomain());
            System.out.println("path : " + w.getPath());
            System.out.println("samesite : " + w.getSameSite());
            System.out.println("expiry : " + w.getExpiry());
            sayac++;
        }
        //    6- eklediginiz cookie’nin sayfaya eklendigini test edin

        for (Cookie w: amazonCookiesSet
             ) {
            if (w.getName().equals("en sevdigim cookie")){
                Assert.assertTrue(amazonCookiesSet.contains(cookie));
            }
        }
        //    7- ismi skin olan cookie’yi silin ve silindigini test edin

        driver.manage().deleteCookieNamed("skin");
        Assert.assertFalse(amazonCookiesSet.contains("skin"));


        //    8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        amazonCookiesSet=driver.manage().getCookies();
        Assert.assertTrue(amazonCookiesSet.isEmpty());

    }
}
