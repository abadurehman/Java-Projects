/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iupac;
import java.awt.*;
/**
 *
 * @author leijurv
 */
public class CovalentBond extends Bond {
    int numBonds;
    public CovalentBond(int num) {
        numBonds = num;
    }
    @Override
    public int[] getValenceChange() {
        return new int[] {numBonds, numBonds};
    }
    @Override
    public int[] getValenceUsage() {
        return new int[] {numBonds, numBonds};
    }
    @Override
    public void draw(Graphics g, double startX, double startY, double endX, double endY, Molecule start, Molecule finish) {
        double lineDist = 4;
        double dx = endX - startX;
        double dy = endY - startY;
        double ang = Math.atan2(dy, dx);
        double xx = Math.cos(Math.PI / 2 + ang) * lineDist;
        double yy = Math.sin(Math.PI / 2 + ang) * lineDist;
        double sX = startX - xx * (numBonds - 1) / 2;
        double sY = startY - yy * (numBonds - 1) / 2;
        for (int i = 0; i < numBonds; i++) {
            double Y = sY + yy * i;
            double X = sX + xx * i;
            g.drawLine((int) X, (int) Y, (int) (X + dx), (int) (Y + dy));
        }
        //g.drawString(numBonds + "", (endX + startX) / 2, (endY + startY) / 2);
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof CovalentBond) {
            return ((CovalentBond) o).numBonds == numBonds;
        }
        return false;
    }
}
