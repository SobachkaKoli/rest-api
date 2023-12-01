package com.example.demo;


import com.example.demo.dto.CarDto;
import com.example.demo.dto.UserDto;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/api")
public class TestController {

    CarDto carDto = CarDto.builder()
            .id(1L)
            .name("lanos")
            .build();


    private String[] stops = new String[]{"Перша", "Друга", "Третя", "Четверта", "П'ята", "Шоста","Сьома" ,"Восьма","Девята","Десята","Одинадцята","Дванадцята","Тринадцята","Чотирнадцята"};
    private int currentStopIndex = 0;

    @GetMapping("/user")
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok(stops[currentStopIndex]);
    }

    @Scheduled(fixedDelayString = "#{ T(java.util.concurrent.ThreadLocalRandom).current().nextInt(9000) + 6000 }")
    public void simulateBusMovement() {
        Random random = new Random();
        currentStopIndex = (currentStopIndex + 1) % stops.length;

        System.out.println("Транспорт прибув до зупинки: " + stops[currentStopIndex]);
    }

    @GetMapping("/car")
    public ResponseEntity<CarDto> getCar(){
        return ResponseEntity.ok(carDto);


    }



}
