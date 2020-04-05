package horstmann4chapter.item;

import java.util.Objects;

public class DiscountedItem extends Item{
    private double discount;

    public DiscountedItem(String description, double price, double discount) {
        super(description, price);
        this.discount = discount;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null) return false;
        if (Item.class == otherObject.getClass()) {
            Item other = (Item) otherObject;
            return Objects.equals(description, other.description)
                    && price == other.price;
        }
        else if(getClass() != otherObject.getClass()) return false;
        DiscountedItem other = (DiscountedItem) otherObject;
        return Objects.equals(description, other.description)
                && price == other.price
                && discount == other.discount;
    }
}
