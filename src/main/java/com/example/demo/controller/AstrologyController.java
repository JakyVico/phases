package com.example.demo.controller;



import jdk.internal.org.objectweb.asm.tree.InnerClassNode;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController

@RequestMapping("/Astrology")
public class AstrologyController {

    @RequestMapping("/phases")
    public ResponseEntity<?> lunarPhase(@RequestParam(name = "month")Integer month, @RequestParam(name="year")Integer year){

        try{
            Algorithm resMoonPhase= new Algorithm();
            Map<String,Map> stucture= new HashMap<>();
            stucture.put("moonPhases",resMoonPhase.calculate(month,year));
            return ResponseEntity.status(HttpStatus.OK).body(stucture);

        }catch (Exception e){
            e.printStackTrace();
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }

    }


    @RequestMapping("/specialMoon")
    public ResponseEntity<?> specialMoon(@RequestParam(name="year")Integer year){

        try{
            Algorithm resMoonPhase= new Algorithm();
            Map<String,Map> stucture= new HashMap<>();
            return ResponseEntity.status(HttpStatus.OK).body(stucture);

        }catch (Exception e){
            e.printStackTrace();
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }

    }
}

