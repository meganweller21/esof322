/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esof322.a1;

/**
 *
 * @author Megan Weller, Ashley Bertrand, Sheila Tupker
 */
public class Driver {
    public static void main(String[] args) {
        Vector3D v1 = new Vector3D(1, 2, 3);
        Vector3D v2 = new Vector3D(4, 5, 6);
        System.out.println((v1.add(v2)).toString());
        System.out.println(v1.dot(v2));
    }
}

