package fractalzoomer.core.location.normal;

import fractalzoomer.core.*;
import fractalzoomer.core.location.Location;
import fractalzoomer.fractal_options.Rotation;
import fractalzoomer.functions.Fractal;
import fractalzoomer.main.app_settings.JitterSettings;
import org.apfloat.Apfloat;

public class PolarLocationNormalApfloatArbitrary extends Location {

    protected Apfloat ddxcenter;
    protected Apfloat ddycenter;

    private Apfloat[] ddantialiasing_x;
    protected Rotation rotation;
    private Apfloat ddmuly;
    protected Apfloat ddmulx;
    private Apfloat ddstart;
    protected Apfloat ddcenter;
    protected int image_size;

    private Apfloat[] ddantialiasing_y_sin;
    private Apfloat[] ddantialiasing_y_cos;


    //Dont copy those

    private Apfloat temp_ddsf;
    private Apfloat temp_ddcf;
    private Apfloat temp_ddr;
    private static int expIterations = 8;

    private Apfloat ddemulx;
    private Apfloat ddInvemulx;

    protected Apfloat point5;

    private JitterSettings js;

    //private Apfloat ddcosmuly;
    //private Apfloat ddsinmuly;

    private boolean requiresVariablePixelSize;

    public PolarLocationNormalApfloatArbitrary(Apfloat xCenter, Apfloat yCenter, Apfloat size, double height_ratio, int image_size_in, double circle_period, Apfloat[] rotation_center, Apfloat[] rotation_vals, Fractal fractal, JitterSettings js) {

        super();

        this.fractal = fractal;
        this.image_size = offset.getImageSize(image_size_in);

        requiresVariablePixelSize = fractal.requiresVariablePixelSize();

        ddxcenter = xCenter;
        ddycenter = yCenter;

        ddcenter = MyApfloat.fp.log(size);

        Apfloat ddimage_size = new MyApfloat(image_size);

        ddmuly = MyApfloat.fp.divide(MyApfloat.fp.multiply(MyApfloat.fp.multiply(new MyApfloat(circle_period), MyApfloat.TWO), MyApfloat.getPi()), ddimage_size);

        ddmulx = MyApfloat.fp.multiply(ddmuly, new MyApfloat(height_ratio));

        point5 = new MyApfloat(0.5);
        ddstart = MyApfloat.fp.subtract(ddcenter, MyApfloat.fp.multiply(MyApfloat.fp.multiply(ddmulx, ddimage_size), point5));

        rotation = new Rotation(new BigComplex(rotation_vals[0], rotation_vals[1]), new BigComplex(rotation_center[0], rotation_center[1]));

        ddemulx = expFunction(ddmulx);
        ddInvemulx = MyApfloat.reciprocal(ddemulx);

        //ddcosmuly = MyApfloat.fastCos(ddmuly);
        //ddsinmuly = MyApfloat.fastSin(ddmuly);
        this.js = js;

    }

    public PolarLocationNormalApfloatArbitrary(PolarLocationNormalApfloatArbitrary other) {

        super(other);

        fractal = other.fractal;

        ddxcenter = other.ddxcenter;
        ddycenter = other.ddycenter;

        ddemulx = other.ddemulx;
        ddInvemulx = other.ddInvemulx;

        ddmulx = other.ddmulx;
        ddmuly = other.ddmuly;
        ddstart = other.ddstart;
        ddcenter = other.ddcenter;
        image_size = other.image_size;

        rotation = other.rotation;

        ddantialiasing_y_cos = other.ddantialiasing_y_cos;
        ddantialiasing_y_sin = other.ddantialiasing_y_sin;
        ddantialiasing_x = other.ddantialiasing_x;

        point5 = other.point5;
        js = other.js;

        requiresVariablePixelSize = other.requiresVariablePixelSize;

        //ddcosmuly = other.ddcosmuly;
        //ddsinmuly = other.ddsinmuly;
    }

    public PolarLocationNormalApfloatArbitrary(Apfloat xCenter, Apfloat yCenter, Apfloat size, double height_ratio, int image_size, double circle_period) {
        super();
        ddxcenter = xCenter;
        ddycenter = yCenter;
        this.image_size = image_size;
        ddcenter = MyApfloat.fp.log(size);
        Apfloat ddimage_size = new MyApfloat(image_size);
        ddmuly = MyApfloat.fp.divide(MyApfloat.fp.multiply(MyApfloat.fp.multiply(new MyApfloat(circle_period), MyApfloat.TWO), MyApfloat.getPi()), ddimage_size);
        ddmulx = MyApfloat.fp.multiply(ddmuly, new MyApfloat(height_ratio));
        ddstart = MyApfloat.fp.subtract(ddcenter, MyApfloat.fp.multiply(MyApfloat.fp.multiply(ddmulx, ddimage_size), new MyApfloat(0.5)));
    }

    public void setVariablePixelSize(Apfloat expValue) {
        fractal.setVariablePixelSize(getMantExp(MyApfloat.fp.multiply(expValue, ddmulx)));
    }

    @Override
    public GenericComplex getComplex(int x, int y) {
        return getComplexBase(offset.getX(x), offset.getY(y));
    }

    protected BigComplex getComplexBase(int x, int y) {

        if(js.enableJitter) {
            double[] res = GetPixelOffset(y, x, js.jitterSeed, js.jitterShape, js.jitterScale);
            temp_ddr = expFunction(MyApfloat.fp.add(MyApfloat.fp.multiply(ddmulx, new MyApfloat(x + res[1])), ddstart));
            Apfloat f = MyApfloat.fp.multiply(ddmuly, new MyApfloat(y + res[0]));
            temp_ddsf = MyApfloat.fastSin(f);
            temp_ddcf = MyApfloat.fastCos(f);
        }
        else {
            if (x == indexX + 1) {
                temp_ddr = MyApfloat.fp.multiply(temp_ddr, ddemulx);
            } else if (x == indexX - 1) {
                temp_ddr = MyApfloat.fp.multiply(temp_ddr, ddInvemulx);
            } else if (x != indexX) {
                temp_ddr = expFunction(MyApfloat.fp.add(MyApfloat.fp.multiply(ddmulx, new MyApfloat(x)), ddstart));
            }

            Apfloat f = MyApfloat.fp.multiply(ddmuly, new MyApfloat(y));
            temp_ddsf = MyApfloat.fastSin(f);
            temp_ddcf = MyApfloat.fastCos(f);
        }

        //Given that we use fastSin and fastCos which are essentially just doubles, these extra multiplications will take longer
//            if(y == indexY + 1) {
//                Apfloat tempSin = MyApfloat.fp.add(MyApfloat.fp.multiply(temp_ddsf, ddcosmuly), MyApfloat.fp.multiply(temp_ddcf, ddsinmuly));
//                Apfloat tempCos = MyApfloat.fp.subtract(MyApfloat.fp.multiply(temp_ddcf, ddcosmuly), MyApfloat.fp.multiply(temp_ddsf, ddsinmuly));
//
//                temp_ddsf = tempSin;
//                temp_ddcf = tempCos;
//            }
//            else if(y == indexY - 1) {
//                Apfloat tempSin = MyApfloat.fp.subtract(MyApfloat.fp.multiply(temp_ddsf, ddcosmuly), MyApfloat.fp.multiply(temp_ddcf, ddsinmuly));
//                Apfloat tempCos = MyApfloat.fp.add(MyApfloat.fp.multiply(temp_ddcf, ddcosmuly), MyApfloat.fp.multiply(temp_ddsf, ddsinmuly));
//
//                temp_ddsf = tempSin;
//                temp_ddcf = tempCos;
//            }
//            else if (y != indexY) {
//                Apfloat f = MyApfloat.fp.multiply(ddmuly, new MyApfloat(y));
//                temp_ddsf = MyApfloat.fastSin(f);
//                temp_ddcf = MyApfloat.fastCos(f);
//            }

        indexX = x;
        indexY = y;

        if(requiresVariablePixelSize) {
            setVariablePixelSize(temp_ddr);
        }

        BigComplex temp = new BigComplex(MyApfloat.fp.add(ddxcenter, MyApfloat.fp.multiply(temp_ddr, temp_ddcf)), MyApfloat.fp.add(ddycenter, MyApfloat.fp.multiply(temp_ddr, temp_ddsf)));

        temp = rotation.rotate(temp);

        temp = fractal.getPlaneTransformedPixel(temp);

        return temp;
    }

    @Override
    public void precalculateY(int y) {

        y = offset.getY(y);

        if(!js.enableJitter) {
            Apfloat f = MyApfloat.fp.multiply(ddmuly, new MyApfloat(y));
            temp_ddsf = MyApfloat.fastSin(f);
            temp_ddcf = MyApfloat.fastCos(f);
        }
        indexY = y;

    }

    @Override
    public void precalculateX(int x) {

        x = offset.getX(x);

        if(!js.enableJitter) {
            if (x == indexX + 1) {
                temp_ddr = MyApfloat.fp.multiply(temp_ddr, ddemulx);
            } else if (x == indexX - 1) {
                temp_ddr = MyApfloat.fp.multiply(temp_ddr, ddInvemulx);
            } else if (x != indexX) {
                temp_ddr = expFunction(MyApfloat.fp.add(MyApfloat.fp.multiply(ddmulx, new MyApfloat(x)), ddstart));
            }
        }

        if(requiresVariablePixelSize) {
            setVariablePixelSize(temp_ddr);
        }

        indexX = x;

    }

    @Override
    public GenericComplex getComplexWithX(int x) {
        return getComplexWithXBase(offset.getX(x));
    }

    protected BigComplex getComplexWithXBase(int x) {

        if(js.enableJitter) {
            return getComplexBase(x, indexY);
        }

        if(x == indexX + 1) {
            temp_ddr = MyApfloat.fp.multiply(temp_ddr, ddemulx);
        }
        else if(x == indexX - 1) {
            temp_ddr = MyApfloat.fp.multiply(temp_ddr, ddInvemulx);
        }
        else if (x != indexX) {
            temp_ddr = expFunction(MyApfloat.fp.add(MyApfloat.fp.multiply(ddmulx, new MyApfloat(x)), ddstart));
        }

        indexX = x;

        if(requiresVariablePixelSize) {
            setVariablePixelSize(temp_ddr);
        }

        BigComplex temp = new BigComplex(MyApfloat.fp.add(ddxcenter, MyApfloat.fp.multiply(temp_ddr, temp_ddcf)), MyApfloat.fp.add(ddycenter, MyApfloat.fp.multiply(temp_ddr, temp_ddsf)));
        temp = rotation.rotate(temp);
        temp = fractal.getPlaneTransformedPixel(temp);
        return temp;
    }

    @Override
    public GenericComplex getComplexWithY(int y) {
        return getComplexWithYBase(offset.getY(y));
    }

    protected BigComplex getComplexWithYBase(int y) {
        if(js.enableJitter) {
            return getComplexBase(indexX, y);
        }

        Apfloat f = MyApfloat.fp.multiply(ddmuly, new MyApfloat(y));
        temp_ddsf = MyApfloat.fastSin(f);
        temp_ddcf = MyApfloat.fastCos(f);

        indexY = y;
        BigComplex temp = new BigComplex(MyApfloat.fp.add(ddxcenter, MyApfloat.fp.multiply(temp_ddr, temp_ddcf)), MyApfloat.fp.add(ddycenter, MyApfloat.fp.multiply(temp_ddr, temp_ddsf)));
        temp = rotation.rotate(temp);
        temp = fractal.getPlaneTransformedPixel(temp);
        return temp;
    }

    @Override
    public void createAntialiasingSteps(boolean adaptive, boolean jitter, int numberOfExtraSamples) {
        super.createAntialiasingSteps(adaptive, jitter, numberOfExtraSamples);
        Apfloat[][] steps = createAntialiasingPolarStepsApfloat(ddmulx, ddmuly, adaptive, jitter, numberOfExtraSamples);
        ddantialiasing_x = steps[0];
        ddantialiasing_y_sin = steps[1];
        ddantialiasing_y_cos = steps[2];
    }

    @Override
    public GenericComplex getAntialiasingComplex(int sample, int loc) {
        return getAntialiasingComplexBase(sample, loc);
    }

    protected BigComplex getAntialiasingComplexBase(int sample, int loc) {
        Apfloat sf2, cf2, r2;

        if(aaJitter) {

            int r = (int)(hash(loc) % NUMBER_OF_AA_JITTER_KERNELS);
            Apfloat[] ddantialiasing_x = precalculatedJitterDataPolarApfloat[r][0];
            Apfloat[] ddantialiasing_y_sin = precalculatedJitterDataPolarApfloat[r][1];
            Apfloat[] ddantialiasing_y_cos = precalculatedJitterDataPolarApfloat[r][2];

            sf2 = MyApfloat.fp.add(MyApfloat.fp.multiply(temp_ddsf, ddantialiasing_y_cos[sample]), MyApfloat.fp.multiply(temp_ddcf, ddantialiasing_y_sin[sample]));
            cf2 = MyApfloat.fp.subtract(MyApfloat.fp.multiply(temp_ddcf, ddantialiasing_y_cos[sample]), MyApfloat.fp.multiply(temp_ddsf, ddantialiasing_y_sin[sample]));

            r2 = MyApfloat.fp.multiply(temp_ddr, ddantialiasing_x[sample]);
        }
        else {
            sf2 = MyApfloat.fp.add(MyApfloat.fp.multiply(temp_ddsf, ddantialiasing_y_cos[sample]), MyApfloat.fp.multiply(temp_ddcf, ddantialiasing_y_sin[sample]));
            cf2 = MyApfloat.fp.subtract(MyApfloat.fp.multiply(temp_ddcf, ddantialiasing_y_cos[sample]), MyApfloat.fp.multiply(temp_ddsf, ddantialiasing_y_sin[sample]));

            r2 = MyApfloat.fp.multiply(temp_ddr, ddantialiasing_x[sample]);
        }

        if(requiresVariablePixelSize) {
            setVariablePixelSize(r2);
        }

        BigComplex temp = new BigComplex(MyApfloat.fp.add(ddxcenter, MyApfloat.fp.multiply(r2, cf2)), MyApfloat.fp.add(ddycenter, MyApfloat.fp.multiply(r2, sf2)));

        temp = rotation.rotate(temp);
        temp = fractal.getPlaneTransformedPixel(temp);

        return temp;
    }

    @Override
    public boolean isPolar() {return true;}

    public BigPoint getPoint(int x, int y) {
        Apfloat f = MyApfloat.fp.multiply(ddmuly, new MyApfloat(y));
        Apfloat sf = MyApfloat.sin(f);
        Apfloat cf = MyApfloat.cos(f);
        Apfloat r = MyApfloat.exp(MyApfloat.fp.add(MyApfloat.fp.multiply(ddmulx, new MyApfloat(x)), ddstart));
        return new BigPoint(MyApfloat.fp.add(ddxcenter, MyApfloat.fp.multiply(r, cf)), MyApfloat.fp.add(ddycenter, MyApfloat.fp.multiply(r, sf)));
    }

    public Complex getComplexOrbit(int x, int y) {
        Apfloat f = MyApfloat.fp.multiply(ddmuly, new MyApfloat(y));
        Apfloat temp_ddsfO = MyApfloat.fastSin(f);
        Apfloat temp_ddcfO = MyApfloat.fastCos(f);
        Apfloat temp_ddrO = MyApfloat.exp(MyApfloat.fp.add(MyApfloat.fp.multiply(ddmulx, new MyApfloat(x)), ddstart));
        BigComplex temp = new BigComplex(MyApfloat.fp.add(ddxcenter, MyApfloat.fp.multiply(temp_ddrO, temp_ddcfO)), MyApfloat.fp.add(ddycenter, MyApfloat.fp.multiply(temp_ddrO, temp_ddsfO)));
        return temp.toComplex();
    }

    protected Apfloat expFunction(Apfloat val) {
        return MyApfloat.exp(val, expIterations);
    }
}
