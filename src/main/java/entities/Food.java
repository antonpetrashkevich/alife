package entities;

/**
 * Created by IntelliJ IDEA.
 * User: Anton
 * Date: 27.02.12
 * Time: 21:48
 */
public class Food extends Field {
    protected Integer foodAmount;

    public Food() {
        setPassable(true);
        setImgKey("food");
    }

    public Integer getFoodAmount() {
        return foodAmount;
    }

    public void setFoodAmount(Integer foodAmount) {
        this.foodAmount = foodAmount;
    }
}
