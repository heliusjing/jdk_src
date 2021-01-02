package com.heliius.adapter;

/**
 * @Author chengfei.jin
 */
public class Demo {
    public static void main(String[] args) {
        RoundHole hole = new RoundHole(5);
        RoundPeg rPeg = new RoundPeg(5);
        if (hole.fits(rPeg)) {
            System.out.println("Round peg r5 round hole r5");
        }
        SquarePeg smallSqpeg = new SquarePeg(2);
        SquarePeg largeSqPeg = new SquarePeg(20);
        SquarePegAdapter smallSqpegAdapter = new SquarePegAdapter(smallSqpeg);
        SquarePegAdapter largeSqpegAdapter = new SquarePegAdapter(largeSqPeg);
        if (hole.fits(smallSqpegAdapter)) {
            System.out.println("Square peg w2 fitw round hole r5");
        }

        if (!hole.fits(largeSqpegAdapter)) {
            System.out.println("Square peg w20 does not fit into round hole r5");
        }

    }
}
