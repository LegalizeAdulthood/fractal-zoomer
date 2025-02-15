/*
 * Fractal Zoomer, Copyright (C) 2020 hrkalona2
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package fractalzoomer.out_coloring_algorithms;

import fractalzoomer.core.Complex;

public class SmoothBiomorphsKleinian extends OutColorAlgorithm {
    private double u;
    private double bailout;

    public SmoothBiomorphsKleinian(double u, double bailout) {

        super();
        this.u = u * 0.5;
        this.bailout = bailout;
        OutUsingIncrement = true;

    }

    @Override
    public double getResult(Object[] object) {

        double temp = (Integer)object[0] + 1 + Math.log(((Complex)object[1]).sub_i(u).norm());

        double temp4 = ((Complex)object[1]).getRe();
        double temp5 = ((Complex)object[1]).getIm();

        return temp4 > -bailout && temp4 < bailout || temp5 > -bailout && temp5 < bailout ? temp : -(temp + INCREMENT);

    }
}
