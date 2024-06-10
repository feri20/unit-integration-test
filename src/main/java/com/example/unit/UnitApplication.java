package com.example.unit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.NoSuchAlgorithmException;
import java.util.*;

@SpringBootApplication
public class UnitApplication {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        SpringApplication.run(UnitApplication.class, args);
        Logger logger = LoggerFactory.getLogger(UnitApplication.class);
        Product firstTestProduct =  new Product(1L,"first","123",2500L,3);
        Product secondTestProduct =  new Product(2L,"second","456",3500L,3);

        List<Product> products = List.of(firstTestProduct,secondTestProduct);
        products.stream().filter(product -> product.getPrice()>2000L).mapToLong(Product::getPrice).average();
        List<Product> result = products.stream().filter(product -> product.getPrice() == 3500).toList();
        logger.info("the result is : {}",result);

            int[] array = {5,8,1,1,10,2,2,9,4,6,6,6,3,15,47,20,14};
            Set<Integer> integerSet = new HashSet<>();
            for (int i=0;i<array.length;i++){
                integerSet.add(array[i]);
            }

            integerSet.forEach(element->{
                System.out.println(element + 5);
            });

            Vector<String> strings = new Vector<>();
            List<String> stringList = new ArrayList<>();

            int x = 15;
            for (int i=0;i<array.length;i++) {
                if (array[i] == x) {
                   System.out.println("found it");
                }

            }
            int[] sortedArray = {1,2,3,4,5,6,7,8,9};
            int y = 2;




        // 1 , 2 , 3 , 4 , 5 , 5 , 6, 7, 7 ,7, 8 , 9

        int[] numbers = {1 , 2 , 3 , 4 , 5 , 5 , 6, 7, 7 ,7, 8 , 9};

//        int topIndex = numbers.length-1;
//        for (int i = 0;i<topIndex;i++){
//            if (numbers[i]==numbers[i+1]){
//
//            }
//        }
//
//
//        }

//        JwtGenerator generator = new JwtGenerator();

//        Map<String, String> claims = new HashMap<>();

//        claims.put("action", "read");
//        claims.put("sub", "pawel.spychalski");
//        claims.put("email", "test@quadmeup.com");
//        claims.put("aud", "*");

//        String token = generator.generateJwt(claims);
//        System.out.println( token);

//        double amount = 1234.123;
//        NumberFormat chinaFormatter = NumberFormat.getCurrencyInstance(Locale.CHINA);

        // Create DecimalFormatSymbols to customize currency formatting
//        DecimalFormatSymbols symbols = ((java.text.DecimalFormat) chinaFormatter).getDecimalFormatSymbols();

        // Set space as the pattern separator
//        symbols.setPatternSeparator(' ');
//
        // Set the customized DecimalFormatSymbols to the NumberFormat instance
//        ((java.text.DecimalFormat) chinaFormatter).setDecimalFormatSymbols(symbols);

        // Format the payment amount
//        String china = chinaFormatter.format(amount);

        // Print the formatted payment
//        System.out.println("China: " + china);
    }


}
