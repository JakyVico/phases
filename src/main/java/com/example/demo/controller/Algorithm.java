package com.example.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Algorithm {



    public Map<String, String> calculate(Integer month, Integer year, Integer flag){

        SimpleDateFormat fullParse = new SimpleDateFormat("dd MM yyyy");
        String dateFistMoon= "01 "+month+" "+year;
        Integer aureo=(year+1)%19;
        Integer epacta=((aureo-1)*11)%30;
        List<String> moon= Arrays.asList("new moon","waxing crescent","first quarter",
                "waxing gibbous","full moon","waning gibbous","third quarter","waning crescent");
        List<Date> listMoon=new ArrayList<>();
        Map<String,String> resMoonPhase = new LinkedHashMap<>();



        try {
                Date dates = fullParse.parse(dateFistMoon);
                GregorianCalendar cal = new GregorianCalendar();
                cal.setTime(dates);
                Integer daysMonth=cal.getActualMaximum(Calendar.DAY_OF_MONTH);


                if(epacta!=0)   cal.add(Calendar.DATE, -epacta);


                String endMoon;
                Date endDay ;
                if(flag==9){
                    endMoon=daysMonth+" "+month+" "+year;
                     endDay = fullParse.parse(endMoon);
                    }
                else{
                    endMoon= 31+" "+12+" "+year;
                    endDay = fullParse.parse(endMoon);
                }

                GregorianCalendar calendar = new GregorianCalendar();
                calendar.setTime(endDay);
                Date actualDay=cal.getTime();


                int index=0;

                for(int i=0; actualDay.compareTo(endDay)<0;i++){
                    if(index>7){ index=0;}




                    if(cal.get(Calendar.YEAR)==year){

                        if(flag!=9 ){
                            if(index==flag){
                                listMoon.add(actualDay);
                                System.out.println(moon.get(index)+"----"+actualDay);
                            }

                        }else {
                            System.out.println(moon.get(index)+"----"+actualDay);
                            resMoonPhase.put(moon.get(index),actualDay.toString());
                            System.out.println(resMoonPhase);
                            System.out.println(resMoonPhase.size());
                            System.out.println(" ");
                        }


                    }

                    cal.add(Calendar.SECOND,+318600);
                    actualDay=cal.getTime();
                    index++;

                }

                if(flag!=9 ){
                    resMoonPhase.put(moon.get(flag), String.valueOf(listMoon));
                }

        return resMoonPhase;

        } catch (ParseException e) {
            e.printStackTrace();
            return resMoonPhase;
        }

    }
}
