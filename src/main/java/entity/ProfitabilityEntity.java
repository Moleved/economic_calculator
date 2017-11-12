package entity;

public class ProfitabilityEntity {
    private int id;
    private Double profitFromAllActivities;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getProfitFromAllActivities() {
        return profitFromAllActivities;
    }

    public void setProfitFromAllActivities(Double profitFromAllActivities) {
        this.profitFromAllActivities = profitFromAllActivities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProfitabilityEntity that = (ProfitabilityEntity) o;

        if (id != that.id) return false;
        if (profitFromAllActivities != null ? !profitFromAllActivities.equals(that.profitFromAllActivities) : that.profitFromAllActivities != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (profitFromAllActivities != null ? profitFromAllActivities.hashCode() : 0);
        return result;
    }
}
