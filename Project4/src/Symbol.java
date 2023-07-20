/**
 * Symbol class represents a single animal symbol used of an animal
 * @author Brandon N. Wroblewski
 */
public class Symbol {

    /** private instance field that represents a name */
    private String name;

    /** private instance field that represents the number of points */
    private int points;

    /** private instance field boolean which represents whether a symbol was clicked */
    private boolean hasBeenClickedOn;

    /**
     * A constructor of the class that accepts a name and number of points to assign
     * to the instance fields
     * @param name represents a name
     * @param points represents the number of points
     * @throws IllegalArgumentException if name is null or if points is less than 1
     */
    public Symbol(String name, int points) {
        //throws IllegalArgumentExceptions if 
        if (name == null) {
            throw new IllegalArgumentException("Null name");
        }
        if (points < 1) {
            throw new IllegalArgumentException("Invalid points");
        }
        //assigns parameter values to the instance fields of current objects
        this.name = name;
        this.points = points;
        //assigns hasBeenClickedOn instance to be false
        this.hasBeenClickedOn = false;
    }

    /**
     * returns the name instance
     * @return name instance
     */
    public String getName() {
        return name;
    }

    /**
     * returns the points instance
     * @return points instance
     */
    public int getPoints() {
        return points;
    }

    /**
     * returns instance field of whether a object was clicked
     * @return instance value (true if clicked, false otherwise)
     */
    public boolean hasBeenClickedOn() {
        return hasBeenClickedOn;
    }

    /**
     * setter method for instance field which knows whether an instance was clicked
     * sets value of instance field to the value that was passed as the parameter
     * @param hasBeenClickedOn represents if a object was clicked on
     */
    public void setHasBeenClickedOn(boolean hasBeenClickedOn) {
        //assignx hasBeenClickedOn instance field to equal parameter value
        this.hasBeenClickedOn = hasBeenClickedOn;
    }

    /**
     * This method returns whether this Symbol and o are equal. If o is not
     * a Symbol the method returns false, the symbols are considered equal if
     * they have the same name, points, and same status of true/false for 
     * hasBeenClicked
     * @param o represents another object for comparison
     * @return true if Symbol and object o are equal, false otherwise
     */
    public boolean equals(Object o) {
        //if current object(this) is exactly same as object it is being compared
        //to then it returns true
        if (this == o) {
            return true;
        }
        //if object being compared to is not in same instance of class Symbol
        //then it returns false
        if (!(o instanceof Symbol)) {
            return false;
        }
        //cast the object o to type Symbol and assigns it a new variable other
        //this allows the method to compare the current object to the o Object
        Symbol other = (Symbol) o;
        //returns true if name and points of object being compared are equal to
        //current instance, else returns false
        return this.name.equals(other.name) && this.points == other.points;
    }

    /**
     * method returns a formatted string
     * @return name followed by space followed by points followed by space followed
     * by true/false depending on whether symbol was clicked
     */
    public String toString() {
        return name + " " + points + " " + hasBeenClickedOn;
    }
}
















