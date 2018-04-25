package edu.ntut.user.myhw3;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by Admin on 2018/3/25.
 */

public class MarriageSuggestionTest {
    @Test
    public void getSuggestion(){
        MarriageSuggestion objms = new MarriageSuggestion();
        /*
        male:
        iAgeRange < 30          => 1
        30 <= iAgeRange <= 40   => 2
        iAgeRange > 40          => 3
        female:
        iAgeRange < 28          => 1
        28 <= iAgeRange <= 35   => 2
        iAgeRange > 35          => 3
        */
        String result = objms.getSuggestion("male",1,3);
        Assert.assertEquals(result,"趕快結婚");

        result = objms.getSuggestion("male",1,5);
        Assert.assertEquals(result,"趕快結婚");

        result = objms.getSuggestion("male",1,11);
        Assert.assertEquals(result,"還不急");

        result = objms.getSuggestion("male",2,3);
        Assert.assertEquals(result,"趕快結婚");

        result = objms.getSuggestion("male",2,5);
        Assert.assertEquals(result,"開始找對象");

        result = objms.getSuggestion("male",2,11);
        Assert.assertEquals(result,"還不急");

        result = objms.getSuggestion("male",3,4);
        Assert.assertEquals(result,"開始找對象");

        result = objms.getSuggestion("male",3,5);
        Assert.assertEquals(result,"開始找對象");

        result = objms.getSuggestion("male",3,11);
        Assert.assertEquals(result,"開始找對象");
        /*--------------------------------------------------------------------------------*/
        result = objms.getSuggestion("female",1,3);
        Assert.assertEquals(result,"趕快結婚");

        result = objms.getSuggestion("female",1,5);
        Assert.assertEquals(result,"趕快結婚");

        result = objms.getSuggestion("female",1,11);
        Assert.assertEquals(result,"還不急");

        result = objms.getSuggestion("female",2,3);
        Assert.assertEquals(result,"趕快結婚");

        result = objms.getSuggestion("female",2,5);
        Assert.assertEquals(result,"開始找對象");

        result = objms.getSuggestion("female",2,11);
        Assert.assertEquals(result,"還不急");

        result = objms.getSuggestion("female",3,3);
        Assert.assertEquals(result,"開始找對象");

        result = objms.getSuggestion("female",3,5);
        Assert.assertEquals(result,"趕快結婚");

        result = objms.getSuggestion("female",3,11);
        Assert.assertEquals(result,"開始找對象");
    }
}