package moon.codingmate._20_large_class._41_extract_superclass;

public abstract class Party {
    // pull up field
    protected String name;

    public Party(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // pull up method
    public double annualCost() {
        return this.monthlyCost() * 12;
    }

    abstract protected double monthlyCost() ;
}
