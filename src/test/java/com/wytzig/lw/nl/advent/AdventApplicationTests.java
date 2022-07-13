package com.wytzig.lw.nl.advent;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
class AdventApplicationTests {

    final AdventApplication underTest = new AdventApplication();
    Administrator administrator = new Administrator();

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
