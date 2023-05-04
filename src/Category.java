public enum Category {
    FOOD("food"),
    ELECTRONICS("electronics"),
    CLOTH("cloth"),
    HOUSEHOLD("household"),
    SPORT("sport");

 final String categoryName;

    Category(String categoryName) {

        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return  categoryName;
    }
}
