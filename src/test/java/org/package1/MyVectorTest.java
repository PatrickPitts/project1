package org.package1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyVectorTest {

    private MyVector V1, V2, V;
    private double[] D1, D2, D;

    @BeforeEach
    void init(){
        D = new double[3];
        V = null;
        D1 = new double[]{1., 2., 3.};
        D2 = new double[]{4., 5., 6.};
        V1 = new MyVector(D1);
        V2 = new MyVector(D2);
    }

    @Test
    void testSize() {
        assertEquals(V1.size(), 3);
    }

    @Test
    void testGet() {
        for(int i = 0; i < 3; i++){
            assertEquals(V2.get(i), D2[i]);
        }
    }

    @Test
    void testPlus() {
        V = V1.plus(V2);
        double[] D = new double[3];
        for(int i = 0; i < 3; i++){
            D[i] = D1[i] + D2[i];
        }
        assertEquals(V, new MyVector(D));
        assertNotEquals(V, V1);
        assertNotEquals(V, V2);
        assertThrows(IndexOutOfBoundsException.class, () -> V1.plus(new MyVector(new double[0])));
    }

    @Test
    void testMinus() {
        V = V1.minus(V2);
        double[] D = new double[3];
        for(int i = 0; i < 3; i++){
            D[i] = D1[i] - D2[i];
        }
        assertEquals(V, new MyVector(D));
        assertNotEquals(V, V1);
        assertNotEquals(V, V2);
        assertThrows(IndexOutOfBoundsException.class, () -> V1.minus(new MyVector(new double[0])));

    }

    @Test
    void testScaledBy() {

        assertNotEquals(V1.scaledBy(2.0), new MyVector(D1));
        for(int i = 0; i < 3; i++){
            D1[i] *= 2.;
        }
        assertEquals(V1.scaledBy(2.0), new MyVector(D1));
    }

    @Test
    void testDot() {
        double dot = 0.0;
        for(int i = 0; i < 3; i++){
            dot += D1[i] * D2[i];
        }
        assertEquals(dot, V1.dot(V2));
    }

    @Test
    void testAbs() {
        double A = 0.0;
        for(int i = 0; i < D1.length; i++){
            A += D1[i] * D1[i];
        }
        assertEquals(Math.sqrt(A), V1.abs());
    }

    @Test
    void testEquals() {
        assertEquals(V1, new MyVector(D1));
        assertEquals(V1, new MyVector(V1));
    }
}