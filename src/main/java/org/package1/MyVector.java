package org.package1;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyVector {


    private final List<Double> V;

    /**
     * An initialization constructor that sets the data values for this vector.
     *
     * @param initValues the values of this vector
     */
    public MyVector(double[] initValues){
        V = new ArrayList<>();
        for(double n : initValues){
            V.add(n);
        }
    }

    /**
     * A copy constructor that initializes this MyVector to have the exact same values as the parameter MyVector
     * @param C the MyVector object to be copied
     */
    public MyVector(MyVector C){
        V = new ArrayList<>();
        for(int i = 0; i < C.size(); i++){
            V.add(C.get(i));
        }
    }

    /**
     * A method that executes the vector sum of this MyVector and the parameter MyVector.
     *
     * @param that the MyVector whose values will used in the vector sum with this MyVector.
     * @throws IndexOutOfBoundsException if this MyVector and the parameter MyVector have a different number of values stored
     * @return a new MyVector object whose values represent the result of the vector sum of this MyVector and the
     *         parameter MyVector.
     */
    public MyVector plus(MyVector that){
        if(this.size() != that.size()){
            throw new IndexOutOfBoundsException(String.format("Mismatched Vector length: this MyVector of length %s is not the" +
                    "same as the parameter MyVector of length %s", this.size(), that.size()));
        }
        double[] retArray = new double[this.size()];
        for(int i = 0; i <this.size(); i++){
            retArray[i] = this.get(i) + that.get(i);
        }
        return new MyVector(retArray);
    }


    /**
     * A method that executes the vector "subtraction" of the parameter MyVector from this MyVector.
     *
     * It is important to note that the order of operations is important in this method.
     *      V1.minus(V2) =/= V2.minus(V1)
     *
     * In pure mathematics, we interpret vector subtraction as addition with a negative vector; that is, we multiply the
     * second vector by -1 (multiply each value of that vector by -1), then perform vector addition between these two
     * vectors. Within the scope of this data structure, this distinction is not particularly relevant, and so we will
     * simply subtract the values of the parameter MyVector from the values of this MyVector.
     *
     * @param that the MyVector object whose values will be used in the vector "subtraction" with this MyVector
     * @throws IndexOutOfBoundsException if this MyVector and the parameter MyVector have a different number of values stored
     * @return a new MyVector object whose values represent the result of the vector "subtraction" of this MyVector
     *         and the paramter MyVector.
     */
    public MyVector minus(MyVector that){
        if(this.size() != that.size()){
            throw new IndexOutOfBoundsException(String.format("Mismatched Vector length: this vector of length %s is not the" +
                    "same as the parameter vector of length %s", this.size(), that.size()));
        }
        double[] retArray = new double[this.size()];
        for(int i = 0; i < this.size(); i++){
            retArray[i] = this.get(i) - that.get(i);
        }
        return new MyVector(retArray);
    }


    /**
     * A method that scales this MyVector larger or smaller, multiplying each value stored by the parameter value.
     *
     * @param S The scale factor by which each value in this MyVector changed
     * @return a new MyVector object that represents the scaled version of this MyVector
     */
    public MyVector scaledBy(double S){
        double[] retArray = new double[this.size()];
        for(int i = 0; i < this.size(); i++){
            retArray[i] = this.get(i) * S;
        }
        return new MyVector(retArray);
    }


    /**
     * A method that performs the dot product operation between this MyVector and the parameter MyVector.
     *
     * @param that the MyVector used as the second term in the dot product operation
     * @throws IndexOutOfBoundsException if this MyVector and the parameter MyVector have a different number of values stored
     * @return the value of the dot product operation between this MyVector and the parameter MyVector.
     */
    public Double dot(MyVector that){
        if(this.size() != that.size()){
            throw new IndexOutOfBoundsException(String.format("Mismatched Vector length: this vector of length %s is not the" +
                    "same as the parameter vector of length %s", this.size(), that.size()));
        }
        double ret = 0.0;
        for(int i = 0; i < this.size(); i++){
            ret += this.get(i) * that.get(i);
        }
        return ret;
    }

    /**
     * A method that calculates the magnitude, or absolute value, of this MyVector
     * @return the absolute value of this MyVector value
     */
    public Double abs(){
        return Math.sqrt(this.dot(this));
    }

    /**
     * A method that returns the number of values stored in this MyVector
     * @return the number of values in this MyVector
     */
    public int size(){
        return V.size();
    }


    /**
     * A method that returns a particular value stored in this MyVector
     *
     * @param n the index of the desired value stored in this MyVector
     * @throws IndexOutOfBoundsException if the index n is out of bounds of the indices of the stored values
     * @return the 0-indexed nth value stored in this MyVector
     */
    public Double get(int n){
        return V.get(n);
    }

    @Override
    public String toString(){
        return String.valueOf(V);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyVector)) return false;
        MyVector myVector = (MyVector) o;
        return Objects.equals(V, myVector.V);
    }

    @Override
    public int hashCode() {
        return Objects.hash(V);
    }
}
