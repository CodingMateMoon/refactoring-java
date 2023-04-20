package moon.codingmate._11_primitive_obsession._32_replace_conditional_with_polymorphism.switches;

public class FullTimeEmployee extends Employee{
    @Override
    public int vacationHours() {
        return 120;
    }

    @Override
    public boolean canAccessTo(String project) {
        return true;
    }
}
