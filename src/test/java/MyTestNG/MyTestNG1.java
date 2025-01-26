package MyTestNG;

import org.testng.annotations.Test;


public class MyTestNG1{
    @Test(groups = {"TestNG"})
    public void test01(){

        System.out.println("mt test1");


    }

    @Test
    public void test02(){

        System.out.println("mt test2");
    }
}
