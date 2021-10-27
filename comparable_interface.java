public class Country implements Comparable<Country> {

    private final String name;
    private final int population;

    public Country(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }
    
    public int getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return this.name + ", population: " + this.population;
    }
    
    @Override
    public int compareTo(Country toinen) {
		if (this.getPopulation() < toinen.getPopulation()) {
			return -1;
		} else if (this.getPopulation() == getPopulation()) {
			return 0;
		} else {
			return 1;
		}
	}
}
