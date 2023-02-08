package DesignUndergroundSystem;

import java.util.HashMap;

class DesignUndergroundSystem {
    
    // this is used to store the information of passengers those who are still on the train
    HashMap<Integer,Passenger> passengers;
    // this is used to store the data for those routes
    // where the first key is the startStation and the second key is the endStation
    HashMap<String, HashMap<String, Route>> routes;
    
    public DesignUndergroundSystem() {
        passengers = new HashMap<>();
        routes = new HashMap<>();
    }
    
    // new passenger on the train, if he is already on the train and trasferring, 
    // we would override its previous data by the natural of hashMap
    public void checkIn(int id, String stationName, int t) {
        passengers.put(id, new Passenger(t, stationName));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Passenger passenger = passengers.get(id);
        
        // if first trip for this route
        routes.putIfAbsent(passenger.startStation, new HashMap<String, Route>());
        routes.get(passenger.startStation).putIfAbsent(stationName, new Route());
        // adding this trip's data
        routes.get(passenger.startStation).get(stationName).update(t - passenger.time);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        return routes.get(startStation).get(endStation).getAverageTime();
    }
}

class Passenger {
    int time;
    String startStation;
    
    public Passenger(int time, String startStation) {
        this.time = time;
        this.startStation = startStation;
    }
}

class Route {
    int costTimeSum;
    int count;
    
    public Route() {
        costTimeSum = 0;
        count = 0;
    }
    
    public void update(int costTime) {
        costTimeSum += costTime;
        count++;
    }
    
    public double getAverageTime() {
        return (double)costTimeSum / (double)count;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */