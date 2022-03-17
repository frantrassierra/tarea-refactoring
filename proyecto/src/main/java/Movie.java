
public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private int _priceCode;

    public Movie(String title, int priceCode) {
        _title = title;
        _priceCode = priceCode;
    }

    public Movie() {
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int arg) {
        _priceCode = arg;
    }

    public String getTitle() {
        return _title;
    }

    public int getFrequentRenterPoints(int frequentRenterPoints, Rental each, String result, double totalAmount, double thisAmount) {
        frequentRenterPoints++;
        // agregue una bonificación para un nuevo lanzamiento de alquiler de dos días
        if  ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1){
            frequentRenterPoints++;
            // mostrar cifras para este alquiler
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
            return frequentRenterPoints;
        } else {
            return 1;
        }
    }
}
