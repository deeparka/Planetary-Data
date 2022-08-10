import java.util.*;

public class Planet {
    private String name;
    private List<String> surfaceGasses;
    private int numberOfMoons;
    private boolean planetHasRings;

    public String getName() {
        return name;
    }
    public List<String> getSurfaceGasses() {
        return surfaceGasses;
    }
    public int getNumberOfMoons() {
        return numberOfMoons;
    }
    public boolean getPlanetHasRings() {
        return planetHasRings;
    }


    public void setName(String name) { 
        this.name = name;
    }
    public void setNumberOfMoons(int numberOfMoons) {
        this.numberOfMoons = numberOfMoons;
    }
    public void setPlanetHasRings(boolean planetHasRings) {
        this.planetHasRings = planetHasRings;
    }

    Planet(String name, int numberOfMoons, boolean planetHasRings) {
        this.name = name;
        this.numberOfMoons = numberOfMoons;
        this.planetHasRings = planetHasRings;
        this.surfaceGasses = new ArrayList<>();
    }

    public void addGasses(String gas) {
        this.surfaceGasses.add(gas);
    }

    public static int countOfMoonsHavingRings(List<Planet> planets) {
        int count = 0;
        for (Planet p : planets) {
            if (p.planetHasRings == true) {
                count += p.numberOfMoons;
            }
        }
        return count;
    }

    public static String gasFound(List<Planet> planets) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        Map<String, Integer> map = new HashMap<>();
        for (Planet p : planets) {
            for (String s: p.getSurfaceGasses()) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        for (String s : map.keySet()) {
            max = Math.max(max, map.get(s));
        }
        for (String s : map.keySet()) {
            if (map.get(s) == max) {
                return s;
            }
        }
        return "";
    }

    public static void main(String[] args) {

        List<Planet> planets = new ArrayList<>();

        Planet mercury = new Planet("Mercury", 0, false);

        Planet venus = new Planet("Venus", 0, false);
        venus.addGasses("Carbon Dioxide");
        venus.addGasses("Nitrogen");
        
        Planet earth = new Planet("Earth", 1, false);
        earth.addGasses("Nitrogen");
        earth.addGasses("Oxygen");
        
        Planet jupiter = new Planet("Jupiter", 79, true);
        jupiter.addGasses("Hydrogen");
        jupiter.addGasses("Helium");
        
        Planet saturn = new Planet("Saturn", 83, true);
        saturn.addGasses("Hydrogen");
        saturn.addGasses("Helium");
    
        Planet uranus = new Planet("Uranus", 27, true);
        uranus.addGasses("Hydrogen");
        uranus.addGasses("Helium");
        uranus.addGasses("Methane");

        planets.add(mercury);
        planets.add(venus);
        planets.add(earth);
        planets.add(jupiter);
        planets.add(saturn);
        planets.add(uranus);

        countOfMoonsHavingRings(planets);
        gasFound(planets);
    }
}