package fractalzoomer.core.location.delta;

import fractalzoomer.core.GenericComplex;
import fractalzoomer.core.MantExp;
import fractalzoomer.core.MpirBigNumComplex;
import fractalzoomer.core.location.normal.CartesianLocationNormalMpirBigNumArbitrary;
import fractalzoomer.core.mpir.MpirBigNum;
import fractalzoomer.functions.Fractal;
import fractalzoomer.main.app_settings.JitterSettings;
import org.apfloat.Apfloat;

public abstract class CartesianLocationDeltaGenericMpirBigNum extends CartesianLocationNormalMpirBigNumArbitrary {
    protected CartesianLocationDeltaGenericMpirBigNum(Apfloat xCenter, Apfloat yCenter, Apfloat size, double height_ratio, int image_size, Apfloat[] rotation_center, Apfloat[] rotation_vals, Fractal fractal, JitterSettings js) {

        super(xCenter, yCenter, size, height_ratio, image_size, rotation_center, rotation_vals, fractal, js);

    }

    protected CartesianLocationDeltaGenericMpirBigNum(CartesianLocationDeltaGenericMpirBigNum other) {

        super(other);

        reference = other.reference;

    }

    protected MpirBigNumComplex getComplexInternal(int x, int y) {
        return getComplexBase(x, y).sub_mutable(reference);
    }

    protected MpirBigNumComplex getComplexWithXInternal(int x) {
        return getComplexWithXBase(x).sub_mutable(reference);
    }

    protected MpirBigNumComplex getComplexWithYInternal(int y) {
        return getComplexWithYBase(y).sub_mutable(reference);
    }

    protected MpirBigNumComplex getAntialiasingComplexInternal(int sample, int loc) {
        return getAntialiasingComplexBase(sample, loc).sub_mutable(reference);
    }

    @Override
    public GenericComplex getReferencePoint() {
        MpirBigNumComplex tempbn = new MpirBigNumComplex(ddxcenter, ddycenter);

        if(rotation.shouldRotate(ddxcenter, ddycenter)) {
            tempbn = rotation.rotate(tempbn);
        }

        tempbn = fractal.getPlaneTransformedPixel(tempbn);
        return tempbn;
    }

    @Override
    public MantExp getMaxSizeInImage() {
        if(height_ratio == 1) {
            MpirBigNum temp = ddsize.divide2();
            return temp.mult(MpirBigNum.SQRT_TWO, temp).getMantExp();
        }
        else {
            MpirBigNum temp = ddsize.divide2();
            MpirBigNum temp2 = temp.mult(heightRatio);
            temp.square(temp);
            temp.add(temp2.square(temp2), temp);
            return temp.sqrt(temp).getMantExp();
        }
    }

    @Override
    public MantExp getSize() {
        return ddsize.getMantExp();
    }

}
