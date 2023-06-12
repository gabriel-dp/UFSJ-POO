/*
 *  Pratical Work 2 - Object-Oriented-Programming
 *  Students - [ Gabriel de Paula Meira ]
 *  Professor - Matheus Viana
 */

import controller.Data;
import vision.AppFrame;

public class Program {
    public static void main(String[] args) {
        new AppFrame(Data.createData());
    }
}
