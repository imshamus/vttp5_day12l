package sg.edu.nus.iss.vttp5a_day12l.model;

// for additional info only.. can use lombok from maven repo, add the dependency and see documentation to use to generate getters setters etc
public class Country {

    private String code;
    private String name;
    private Integer population;
    
    public Country(String code, String name, Integer population) {
        
        this.code = code;
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    
    
}
