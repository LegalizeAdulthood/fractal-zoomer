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

package fractalzoomer.planes.fold;

import fractalzoomer.core.*;
import fractalzoomer.planes.Plane;

/**
 *
 * @author hrkalona2
 */
public class FoldDownPlane extends Plane {

    private Complex center;
    private BigComplex ddcenter;
    private BigNumComplex bncenter;

    private MpfrBigNumComplex mpfrbncenter;

    private MpirBigNumComplex mpirbncenter;

    private DDComplex ddccenter;

    public FoldDownPlane(double[] plane_transform_center) {

        super();
        center = new Complex(plane_transform_center[0], plane_transform_center[1]);
        if(TaskDraw.PERTURBATION_THEORY || TaskDraw.HIGH_PRECISION_CALCULATION) {
            ddcenter = new BigComplex(center);
            ddccenter = new DDComplex(center);
            bncenter = new BigNumComplex(center);

            if (TaskDraw.allocateMPFR()) {
                mpfrbncenter = new MpfrBigNumComplex(center);
            } else if (TaskDraw.allocateMPIR()) {
                mpirbncenter = new MpirBigNumComplex(center);
            }
        }

    }

    @Override
    public Complex transform(Complex pixel) {
        
        return pixel.fold_down(center);

    }

    @Override
    public BigComplex transform(BigComplex pixel) {

        return pixel.fold_down(ddcenter);

    }

    @Override
    public BigNumComplex transform(BigNumComplex pixel) {

        return pixel.fold_down(bncenter);

    }

    @Override
    public MpfrBigNumComplex transform(MpfrBigNumComplex pixel) {

        return pixel.fold_down(mpfrbncenter);

    }

    @Override
    public MpirBigNumComplex transform(MpirBigNumComplex pixel) {

        return pixel.fold_down(mpirbncenter);

    }

    @Override
    public DDComplex transform(DDComplex pixel) {

        return pixel.fold_down(ddccenter);

    }
}
