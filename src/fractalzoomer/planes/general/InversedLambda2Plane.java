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

package fractalzoomer.planes.general;

import fractalzoomer.core.*;
import fractalzoomer.core.mpfr.MpfrBigNum;
import fractalzoomer.core.mpir.MpirBigNum;
import fractalzoomer.planes.Plane;

/**
 *
 * @author hrkalona2
 */
public class InversedLambda2Plane extends Plane {
    private MpfrBigNum tempRe;
    private MpfrBigNum tempIm;

    private MpirBigNum tempRep;
    private MpirBigNum tempImp;
    private MpirBigNum _025;
    
    public InversedLambda2Plane() {
        
        super();

        if(TaskDraw.PERTURBATION_THEORY || TaskDraw.HIGH_PRECISION_CALCULATION) {
            if (TaskDraw.allocateMPFR()) {
                tempRe = new MpfrBigNum();
                tempIm = new MpfrBigNum();
            } else if (TaskDraw.allocateMPIR()) {
                tempRep = new MpirBigNum();
                tempImp = new MpirBigNum();
                _025 = new MpirBigNum(0.25);
            }
        }
        
    }

    @Override
    public Complex transform(Complex pixel) {

        if(pixel.isZero()) {
            return pixel;
        }
        return pixel.square().reciprocal_mutable().r_sub_mutable(0.25);
        
    }

    @Override
    public BigComplex transform(BigComplex pixel) {

        if(pixel.isZero()) {
            return pixel;
        }

        return pixel.square().reciprocal().r_sub(new MyApfloat(0.25));

    }

    @Override
    public BigIntNumComplex transform(BigIntNumComplex pixel) {

        if(pixel.isZero()) {
            return pixel;
        }

        return pixel.square().reciprocal().r_sub(0.25);

    }

    @Override
    public MpfrBigNumComplex transform(MpfrBigNumComplex pixel) {

        if(pixel.isZero()) {
            return pixel;
        }
        return pixel.square_mutable(tempRe, tempIm).reciprocal_mutable(tempRe, tempIm).r_sub_mutable(0.25);

    }

    @Override
    public MpirBigNumComplex transform(MpirBigNumComplex pixel) {

        if(pixel.isZero()) {
            return pixel;
        }
        return pixel.square_mutable(tempRep, tempImp).reciprocal_mutable(tempRep, tempImp).r_sub_mutable(_025);

    }

    @Override
    public DDComplex transform(DDComplex pixel) {

        if(pixel.isZero()) {
            return pixel;
        }
        return pixel.square().reciprocal().r_sub(0.25);

    }
    
}
