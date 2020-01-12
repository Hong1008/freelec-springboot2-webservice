package com.jojoldu.book.springboot.web.dto;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class HelloReponseDtoTest {

    @Test
    public void lombokTest(){
        String name = "test";
        int amount = 1000;

        HelloReponseDto dto = new HelloReponseDto(name,amount);
        Assertions.assertThat(dto.getName()).isEqualTo(name);
        Assertions.assertThat(dto.getAmount()).isEqualTo(amount);
    }
}