package com.wytzig.lw.nl.advent;

import com.wytzig.lw.nl.advent.twentytwentyone.AdministratorTwentyTwentyOne;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdventApplicationTests {

    final AdventApplication underTest = new AdventApplication();
    AdministratorTwentyTwentyOne administratorTwentyTwentyOne = new AdministratorTwentyTwentyOne();

    @Test
    void contextLoads() {
    }

//    @BeforeAll
//    void setup() {
//        underTest.run();
//        administrator.init();
//    }

//    @Test
//    void dayTest() {
//        assertTrue(administrator.day_1());
//    }

}
