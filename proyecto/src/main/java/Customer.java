
/*
## Refactorización 1
Simplificar el método statement de la clase Customer mediante la extracción de un método público llamado amountFor 
que contenga la lógica que distingue entre Movie.REGULAR, Movie.NEW_RELEASE y Movie.CHILDRENS, para aplicar diferentes 
tarifas de alquiler. Se pretendo con ello tener un método statement más sencillo y fácil de mantener. Además deberá 
devolver un double.
*/

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer (String name) {
        _name = name;
    }

    public void addRental (Rental arg) {
        _rentals.addElement(arg);
    }
    
    //Metodo Statement 
    public String statement () {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();

            
            // determinar cantidades para cada línea
            Rental r=new Rental();
            r.setGetCharge(thisAmount, each);
           
            
            // añadir puntos de alquiler frecuente
            Movie m=new Movie();
            getFrequentRenterPoints(frequentRenterPoints, each, result, totalAmount, thisAmount);
        }
        // añadir líneas de pie de página
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }
    
    
    public double amount(double thisAmount ,Rental each){
         switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2)
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    break;
            }
         return thisAmount;
    }
    
    public String getName() {
        return _name;
    }
}