package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue());
        }
        return resultMap;

    }
    public double averageTemperature(Map<String,Double> avgMap) {
        double tempToAvg = 0;

                for (Map.Entry<String, Double> temp : avgMap.entrySet()) {
                    tempToAvg = tempToAvg + temp.getValue();
                }

        return tempToAvg/avgMap.size();
    }

    public double medianTemperature(Map<String,Double> medMap) {
        double medianTemp;
        List<Double> medList = new ArrayList<>();

        for (Map.Entry<String, Double> temp : medMap.entrySet()) {
            medList.add(temp.getValue());
        }

        Double[] medArray = new Double [medList.size()];
        medArray = medList.toArray(medArray);
        Arrays.sort(medArray);

        if (medArray.length % 2 ==0) {
            double avgToMed;
            avgToMed = medArray[medArray.length / 2] + medArray[(medArray.length / 2) - 1];
            medianTemp = avgToMed / 2;
        } else {
            medianTemp = medArray[medArray.length / 2];
            }

        return medianTemp;
    }
}
