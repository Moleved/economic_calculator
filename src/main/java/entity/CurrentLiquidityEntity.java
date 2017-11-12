package entity;

public class CurrentLiquidityEntity {
    private int id;
    private double revolvingAssets;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getRevolvingAssets() {
        return revolvingAssets;
    }

    public void setRevolvingAssets(double revolvingAssets) {
        this.revolvingAssets = revolvingAssets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrentLiquidityEntity that = (CurrentLiquidityEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.revolvingAssets, revolvingAssets) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(revolvingAssets);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
