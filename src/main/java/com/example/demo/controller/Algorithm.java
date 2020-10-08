package com.example.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Algorithm {

    private Date fistNewMoon=new Date();


    public Map<String, String> calculate(Integer month, Integer year){

        SimpleDateFormat fullParse = new SimpleDateFormat("dd MM yyyy");
        String dateFistMoon= "01 "+month+" "+year;
        Integer aureo=(year+1)%19;
        Integer epacta=((aureo-1)*11)%30;
        List<String> moon= Arrays.asList("new moon","waxing crescent","first quarter",
                "waxing gibbous","full moon","waning gibbous","third quarter","waning crescent");
        Map<String,String> resMoonPhase= new LinkedHashMap<>();


        try {
                Date dates = fullParse.parse(dateFistMoon);
                GregorianCalendar cal = new GregorianCalendar();
                cal.setTime(dates);
                Integer daysMonth=cal.getActualMaximum(Calendar.DAY_OF_MONTH);

                if(epacta!=0)   cal.add(Calendar.DATE, -epacta);

                String endMoon=daysMonth+" "+month+" "+year;
                Date endDay = fullParse.parse(endMoon);
                GregorianCalendar calendar = new GregorianCalendar();
                calendar.setTime(endDay);
                Date actualDay=cal.getTime();

                int index=0;
                while( actualDay.compareTo(endDay)<0){
                    if(index>7) index=0;


                    if(cal.get(Calendar.YEAR)==year){
                        resMoonPhase.put(moon.get(index),actualDay.toString());
                        System.out.println(actualDay+"--Luna  --"+moon.get(index));
                    }

                    cal.add(Calendar.SECOND,+318600);
                    actualDay=cal.getTime();
                    index++;

                }


        } catch (ParseException e) {
            e.printStackTrace();
        }

        return resMoonPhase;
    }
}
