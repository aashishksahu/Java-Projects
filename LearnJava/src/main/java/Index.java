/*
 * This is an entry point class
 * */

import static Networking.HTTPCLIENT.HttpClientDemo.HTTP_Demo;
import static DesignPatterns.DI.DepInjectDemo.DI_Demo;

public class Index {
    public static void main(String[] args) {

        try {
            // Uncomment the lines to start a demo

//            HTTP_Demo();
//            DI_Demo();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
