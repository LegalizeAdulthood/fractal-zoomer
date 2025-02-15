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
package fractalzoomer.functions.root_finding_methods;

import fractalzoomer.core.*;
import fractalzoomer.fractal_options.initial_value.DefaultInitialValue;
import fractalzoomer.fractal_options.iteration_statistics.*;
import fractalzoomer.functions.Fractal;
import fractalzoomer.in_coloring_algorithms.*;
import fractalzoomer.main.MainWindow;
import fractalzoomer.main.app_settings.OrbitTrapSettings;
import fractalzoomer.main.app_settings.StatisticsSettings;
import fractalzoomer.main.app_settings.TrueColorSettings;
import fractalzoomer.out_coloring_algorithms.*;
import fractalzoomer.true_coloring_algorithms.UserTrueColorAlgorithm;
import fractalzoomer.utils.ColorAlgorithm;

import java.util.ArrayList;

import static fractalzoomer.main.Constants.*;

/**
 *
 * @author hrkalona2
 */
public abstract class RootFindingMethods extends Fractal {

    protected double convergent_bailout;
    protected Object[] iterationData;

    public RootFindingMethods(double xCenter, double yCenter, double size, int max_iterations, int plane_type, double[] rotation_vals, double[] rotation_center, String user_plane, int user_plane_algorithm, String[] user_plane_conditions, String[] user_plane_condition_formula, double[] plane_transform_center, double plane_transform_angle, double plane_transform_radius, double[] plane_transform_scales, double[] plane_transform_wavelength, int waveType, double plane_transform_angle2, int plane_transform_sides, double plane_transform_amount, ArrayList<Double> inflections_re, ArrayList<Double> inflections_im, double inflectionsPower, OrbitTrapSettings ots) {

        super(xCenter, yCenter, size, max_iterations, 0, 0, "", "", 0, 0, false, plane_type, rotation_vals, rotation_center, user_plane, user_plane_algorithm, user_plane_conditions, user_plane_condition_formula, plane_transform_center, plane_transform_angle, plane_transform_radius, plane_transform_scales, plane_transform_wavelength, waveType, plane_transform_angle2, plane_transform_sides, plane_transform_amount, inflections_re, inflections_im, inflectionsPower, ots);

        setConvergentBailout(1E-10);
        isJulia = false;
        defaultInitVal = new DefaultInitialValue();

    }

    protected void setConvergentBailout(double val) {
        convergent_bailout = TaskDraw.USER_CONVERGENT_BAILOUT > 0 ? TaskDraw.USER_CONVERGENT_BAILOUT : val;
    }

    //orbit
    public RootFindingMethods(double xCenter, double yCenter, double size, int max_iterations, ArrayList<Complex> complex_orbit, int plane_type, double[] rotation_vals, double[] rotation_center, String user_plane, int user_plane_algorithm, String[] user_plane_conditions, String[] user_plane_condition_formula, double[] plane_transform_center, double plane_transform_angle, double plane_transform_radius, double[] plane_transform_scales, double[] plane_transform_wavelength, int waveType, double plane_transform_angle2, int plane_transform_sides, double plane_transform_amount, ArrayList<Double> inflections_re, ArrayList<Double> inflections_im, double inflectionsPower) {

        super(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, rotation_center, user_plane, user_plane_algorithm, user_plane_conditions, user_plane_condition_formula, plane_transform_center, plane_transform_angle, plane_transform_radius, plane_transform_scales, plane_transform_wavelength, waveType, plane_transform_angle2, plane_transform_sides, plane_transform_amount, inflections_re, inflections_im, inflectionsPower, false);
        defaultInitVal = new DefaultInitialValue();

    }

    @Override
    public Complex[] initialize(Complex pixel) {

        Complex[] complex = new Complex[1];
        if(TaskDraw.PERTURBATION_THEORY && supportsPerturbationTheory()) {
            if(!isOrbit && !isDomain) {
                complex[0] = pixel.plus(refPointSmall);
            }
            else {
                complex[0] = new Complex(pixel);
            }
        }
        else {
            complex[0] = new Complex(pixel);//z
        }

        zold = new Complex();
        zold2 = new Complex();
        start = new Complex(complex[0]);
        c0 = new Complex(complex[0]);

        return complex;

    }

    @Override
    public GenericComplex[] initialize(GenericComplex pixel) {

        GenericComplex[] complex = new GenericComplex[1];

        int lib = TaskDraw.getHighPrecisionLibrary(dsize, this);

        if(lib == ARBITRARY_MPFR) {

            workSpaceData.z.set(pixel);
            complex[0] = workSpaceData.z;//z

            workSpaceData.zold.reset();
            gzold = workSpaceData.zold;

            workSpaceData.zold2.reset();
            gzold2 = workSpaceData.zold2;

            workSpaceData.start.set(complex[0]);
            gstart = workSpaceData.start;

            workSpaceData.c0.set(complex[0]);
            gc0 = workSpaceData.c0;
        }
        else if(lib == ARBITRARY_MPIR) {

            workSpaceData.zp.set(pixel);
            complex[0] = workSpaceData.zp;//z

            workSpaceData.zoldp.reset();
            gzold = workSpaceData.zoldp;

            workSpaceData.zold2p.reset();
            gzold2 = workSpaceData.zold2p;

            workSpaceData.startp.set(complex[0]);
            gstart = workSpaceData.startp;

            workSpaceData.c0p.set(complex[0]);
            gc0 = workSpaceData.c0p;
        }
        else if (lib == ARBITRARY_BUILT_IN) {
            complex[0] = pixel;//z

            gzold = new BigNumComplex();
            gzold2 = new BigNumComplex();
            gstart = complex[0];
            gc0 = complex[0];
        }
        else if(lib == ARBITRARY_DOUBLEDOUBLE) {
            complex[0] = pixel;//z

            gzold = new DDComplex();
            gzold2 = new DDComplex();
            gstart = complex[0];
            gc0 = complex[0];
        }
        else if(lib == ARBITRARY_BIGINT) {
            complex[0] = pixel;//z

            gzold = new BigIntNumComplex();
            gzold2 = new BigIntNumComplex();
            gstart = complex[0];
            gc0 = complex[0];
        }
        else {
            complex[0] = pixel;//z

            gzold = new BigComplex();
            gzold2 = new BigComplex();
            gstart = complex[0];
            gc0 = complex[0];
        }

        return complex;

    }

    @Override
    public double iterateFractalArbitraryPrecision(GenericComplex[] complex, GenericComplex pixel) {

        iterations = 0;

        complex = precalculateArbitraryData(complex);

        Complex start = gstart.toComplex();
        Complex c0 = gc0.toComplex();
        Complex pixelC = pixel.toComplex();

        for (; iterations < max_iterations; iterations++) {

            if (trap != null) {
                trap.check(complex[0].toComplex(), iterations);
            }

            if (iterations > 0 && convergent_bailout_algorithm.Converged(complex[0], gzold, gzold2, iterations, pixel, gstart, gc0, pixel)) {
                escaped = true;

                Complex z = complex[0].toComplex();
                Complex zold = gzold.toComplex();
                Complex zold2 = gzold2.toComplex();

                Object[] object = {iterations, z, convergent_bailout_algorithm.getDistance(), zold, zold2, pixelC, start, c0, pixelC};
                iterationData = object;
                double out = out_color_algorithm.getResult(object);

                out = getFinalValueOut(out, z);

                if (outTrueColorAlgorithm != null) {
                    setTrueColorOut(z, zold, zold2, iterations, pixelC, start, c0, pixelC);
                }

                return getAndAccumulateHP(out);
            }

            gzold2.set(gzold);
            gzold.set(complex[0]);

            function(complex);

            if (statistic != null) {
                statistic.insert(complex[0].toComplex(), gzold.toComplex(), gzold2.toComplex(), iterations, pixelC, start, c0);
            }
        }

        Complex z = complex[0].toComplex();
        Complex zold = gzold.toComplex();
        Complex zold2 = gzold2.toComplex();

        Object[] object = {z, zold, zold2, pixelC, start, c0, pixelC};
        iterationData = object;
        double in = in_color_algorithm.getResult(object);

        in = getFinalValueIn(in, z);

        if (inTrueColorAlgorithm != null) {
            setTrueColorIn(z, zold, zold2, iterations, pixelC, start, c0, pixelC);
        }

        return getAndAccumulateHP(in);

    }

    @Override
    protected double iterateFractalWithoutPeriodicity(Complex[] complex, Complex pixel) {
        iterations = 0;

        for (; iterations < max_iterations; iterations++) {

            updateValues(complex);

            if (trap != null) {
                trap.check(complex[0], iterations);
            }

            if (iterations > 0 && convergent_bailout_algorithm.converged(complex[0], zold, zold2, iterations, pixel, start, c0, pixel)) {
                escaped = true;

                Object[] object = {iterations, complex[0], convergent_bailout_algorithm.getDistance(), zold, zold2, pixel, start, c0, pixel};
                iterationData = object;
                double out = out_color_algorithm.getResult(object);

                out = getFinalValueOut(out, complex[0]);

                if (outTrueColorAlgorithm != null) {
                    setTrueColorOut(complex[0], zold, zold2, iterations, pixel, start, c0, pixel);
                }

                return out;
            }
            zold2.assign(zold);
            zold.assign(complex[0]);

            complex[0] = preFilter.getValue(complex[0], iterations, pixel, start, c0, pixel);
            function(complex);
            complex[0] = postFilter.getValue(complex[0], iterations, pixel, start, c0, pixel);

            if (statistic != null) {
                statistic.insert(complex[0], zold, zold2, iterations, pixel, start, c0);
            }

        }

        Object[] object = {complex[0], zold, zold2, pixel, start, c0, pixel};
        iterationData = object;
        double in = in_color_algorithm.getResult(object);

        in = getFinalValueIn(in, complex[0]);

        if (inTrueColorAlgorithm != null) {
            setTrueColorIn(complex[0], zold, zold2, iterations, pixel, start, c0, pixel);
        }

        return in;

    }

    @Override
    protected void iterateFractalOrbit(Complex[] complex, Complex pixel) {
        iterations = 0;

        Complex temp = null;

        for (; iterations < max_iterations; iterations++) {
            updateValues(complex);

            zold2.assign(zold);
            zold.assign(complex[0]);

            complex[0] = preFilter.getValue(complex[0], iterations, pixel, start, c0, pixel);
            function(complex);
            complex[0] = postFilter.getValue(complex[0], iterations, pixel, start, c0, pixel);

            temp = rotation.rotateInverse(complex[0]);

            if (Double.isNaN(temp.getRe()) || Double.isNaN(temp.getIm()) || Double.isInfinite(temp.getRe()) || Double.isInfinite(temp.getIm())) {
                break;
            }

            complex_orbit.add(temp);
        }

    }

    protected Complex iterateFractalDomain(Complex[] complex, Complex pixel) {

        iterations = 0;

        for (; iterations < max_iterations; iterations++) {

            updateValues(complex);

            zold2.assign(zold);
            zold.assign(complex[0]);

            complex[0] = preFilter.getValue(complex[0], iterations, pixel, start, c0, pixel);
            function(complex);
            complex[0] = postFilter.getValue(complex[0], iterations, pixel, start, c0, pixel);

        }

        return complex[0];

    }

    @Override
    public double calculateJulia(GenericComplex pixel) {
        return 0;
    }

    @Override
    public void calculateJuliaOrbit() {
    }

    @Override
    public Complex calculateJuliaDomain(Complex pixel) {

        return null;

    }

    @Override
    public double getConvergentBailout() {

        return Math.sqrt(convergent_bailout);

    }

    @Override
    protected void OutColoringAlgorithmFactory(int out_coloring_algorithm, boolean smoothing, int converging_smooth_algorithm, int user_out_coloring_algorithm, String outcoloring_formula, String[] user_outcoloring_conditions, String[] user_outcoloring_condition_formula, double[] plane_transform_center) {

        switch (out_coloring_algorithm) {

            case MainWindow.ESCAPE_TIME:
                if (!smoothing) {
                    out_color_algorithm = new EscapeTime();
                } else {
                    out_color_algorithm = new SmoothEscapeTimeRootFindingMethod(Math.log(convergent_bailout), converging_smooth_algorithm);
                }
                break;
            case MainWindow.BINARY_DECOMPOSITION:
                if (!smoothing) {
                    out_color_algorithm = new BinaryDecomposition();
                } else {
                    out_color_algorithm = new SmoothBinaryDecompositionRootFindingMethod(Math.log(convergent_bailout), converging_smooth_algorithm);
                }
                break;
            case MainWindow.BINARY_DECOMPOSITION2:
                if (!smoothing) {
                    out_color_algorithm = new BinaryDecomposition2();
                } else {
                    out_color_algorithm = new SmoothBinaryDecomposition2RootFindingMethod(Math.log(convergent_bailout), converging_smooth_algorithm);
                }
                break;
            case MainWindow.COLOR_DECOMPOSITION:
                if (!smoothing) {
                    out_color_algorithm = new ColorDecompositionRootFindingMethod();
                } else {
                    out_color_algorithm = new SmoothColorDecompositionRootFindingMethod(Math.log(convergent_bailout), converging_smooth_algorithm);
                }
                break;
            case MainWindow.ESCAPE_TIME_COLOR_DECOMPOSITION:
                if (!smoothing) {
                    out_color_algorithm = new EscapeTimeColorDecompositionRootFindingMethod();
                } else {
                    out_color_algorithm = new SmoothEscapeTimeColorDecompositionRootFindingMethod(Math.log(convergent_bailout), converging_smooth_algorithm);
                }
                break;
            case MainWindow.ESCAPE_TIME_ALGORITHM:
                out_color_algorithm = new EscapeTimeAlgorithm1(3);
                break;
            case MainWindow.USER_OUTCOLORING_ALGORITHM:
                if (user_out_coloring_algorithm == 0) {
                    out_color_algorithm = new UserOutColorAlgorithmRootFindingMethod(outcoloring_formula, convergent_bailout, max_iterations, xCenter, yCenter, size, plane_transform_center, globalVars);
                } else {
                    out_color_algorithm = new UserConditionalOutColorAlgorithmRootFindingMethod(user_outcoloring_conditions, user_outcoloring_condition_formula, convergent_bailout, max_iterations, xCenter, yCenter, size, plane_transform_center, globalVars);
                }
                break;

        }
    }

    @Override
    protected void InColoringAlgorithmFactory(int in_coloring_algorithm, int user_in_coloring_algorithm, String incoloring_formula, String[] user_incoloring_conditions, String[] user_incoloring_condition_formula, double[] plane_transform_center) {

        switch (in_coloring_algorithm) {

            case MainWindow.MAX_ITERATIONS:
                in_color_algorithm = new MaximumIterations();
                break;
            case MainWindow.Z_MAG:
                in_color_algorithm = new ZMag(max_iterations);
                break;
            case MainWindow.DECOMPOSITION_LIKE:
                in_color_algorithm = new DecompositionLike(max_iterations);
                break;
            case MainWindow.RE_DIVIDE_IM:
                in_color_algorithm = new ReDivideIm(max_iterations);
                break;
            case MainWindow.COS_MAG:
                in_color_algorithm = new CosMag(max_iterations);
                break;
            case MainWindow.MAG_TIMES_COS_RE_SQUARED:
                in_color_algorithm = new MagTimesCosReSquared(max_iterations);
                break;
            case MainWindow.SIN_RE_SQUARED_MINUS_IM_SQUARED:
                in_color_algorithm = new SinReSquaredMinusImSquared(max_iterations);
                break;
            case MainWindow.ATAN_RE_TIMES_IM_TIMES_ABS_RE_TIMES_ABS_IM:
                in_color_algorithm = new AtanReTimesImTimesAbsReTimesAbsIm(max_iterations);
                break;
            case MainWindow.SQUARES:
                in_color_algorithm = new Squares(max_iterations);
                break;
            case MainWindow.SQUARES2:
                in_color_algorithm = new Squares2(max_iterations);
                break;
            case MainWindow.USER_INCOLORING_ALGORITHM:
                if (user_in_coloring_algorithm == 0) {
                    in_color_algorithm = new UserInColorAlgorithm(incoloring_formula, max_iterations, xCenter, yCenter, size, plane_transform_center, convergent_bailout, globalVars);
                } else {
                    in_color_algorithm = new UserConditionalInColorAlgorithm(user_incoloring_conditions, user_incoloring_condition_formula, max_iterations, xCenter, yCenter, size, plane_transform_center, convergent_bailout, globalVars);
                }
                break;

        }

    }

    @Override
    public double getFractal3DHeight(double value) {

        if (escaped) {
            double res = out_color_algorithm.getResult3D(iterationData, value);

            res = getFinalValueOut(res, (Complex) iterationData[1]);

            return ColorAlgorithm.transformResultToHeight(res, max_iterations);
        }

        return ColorAlgorithm.transformResultToHeight(value, max_iterations);

    }

    @Override
    public double getJulia3DHeight(double value) {

        return 0;

    }

    @Override
    public int type() {

        return MainWindow.CONVERGING;

    }

    @Override
    protected void StatisticFactory(StatisticsSettings sts, double[] plane_transform_center) {

        statisticIncludeEscaped = sts.statisticIncludeEscaped;
        statisticIncludeNotEscaped = sts.statisticIncludeNotEscaped;

        if (sts.statisticGroup == 1) {
            statistic = new UserStatisticColoringRootFindingMethod(sts.statistic_intensity, sts.user_statistic_formula, xCenter, yCenter, max_iterations, size, convergent_bailout, plane_transform_center, globalVars, sts.useAverage, sts.user_statistic_init_value, sts.reductionFunction, sts.useIterations, sts.useSmoothing, sts.lastXItems);
            return;
        }
        else if(sts.statisticGroup == 2) {
            statistic = new Equicontinuity(sts.statistic_intensity, sts.useSmoothing, sts.useAverage, 0, true, Math.log(convergent_bailout), sts.equicontinuityDenominatorFactor, sts.equicontinuityInvertFactor, sts.equicontinuityDelta);
            return;
        }
        else if(sts.statisticGroup == 4) {
            statistic = new RootColoring(Math.log(convergent_bailout), sts.rootIterationsScaling, max_iterations, sts.rootColors, sts.rootSmooting, this, sts.unmmapedRootColor.getRGB());
            return;
        }

        switch (sts.statistic_type) {

            case MainWindow.COS_ARG_DIVIDE_INVERSE_NORM:
                statistic = new CosArgDivideInverseNorm(sts.statistic_intensity, sts.cosArgInvStripeDensity, sts.StripeDenominatorFactor, sts.useSmoothing, Math.log(convergent_bailout), 0, sts.lastXItems);
                break;
            case MainWindow.ATOM_DOMAIN_BOF60_BOF61:
                statistic = new AtomDomain(sts.showAtomDomains, sts.statistic_intensity, sts.atomNormType, sts.atomNNorm, sts.lastXItems);
                break;
            case MainWindow.DISCRETE_LAGRANGIAN_DESCRIPTORS:
                statistic = new DiscreteLagrangianDescriptors(sts.statistic_intensity, sts.lagrangianPower, 0, sts.useSmoothing, sts.useAverage, true, Math.log(convergent_bailout), sts.langNormType, sts.langNNorm, sts.lastXItems);
                break;
        }
    }

    @Override
    public void setTrueColorAlgorithm(TrueColorSettings tcs) {

        if (tcs.trueColorOut) {

            if (tcs.trueColorOutMode == 0) {
                super.setTrueColorAlgorithm(tcs);
            } else {
                outTrueColorAlgorithm = new UserTrueColorAlgorithm(tcs.outTcComponent1, tcs.outTcComponent2, tcs.outTcComponent3, tcs.outTcColorSpace, convergent_bailout, max_iterations, xCenter, yCenter, size, point, globalVars);
            }
        }

        if (tcs.trueColorIn) {
            if (tcs.trueColorInMode == 0) {
                super.setTrueColorAlgorithm(tcs);
            } else {
                inTrueColorAlgorithm = new UserTrueColorAlgorithm(tcs.inTcComponent1, tcs.inTcComponent2, tcs.inTcComponent3, tcs.inTcColorSpace, convergent_bailout, max_iterations, xCenter, yCenter, size, point, globalVars);
            }
        }

    }

    @Override
    public Complex[] initializePerturbation(Complex dpixel) {

        Complex[] complex = new Complex[1];

        complex[0] = new Complex(dpixel);

        return complex;

    }

    @Override
    public MantExpComplex[] initializePerturbation(MantExpComplex dpixel) {

        MantExpComplex[] complex = new MantExpComplex[1];

        complex[0] = MantExpComplex.copy(dpixel);

        return complex;

    }

    @Override
    public double iterateFractalWithPerturbation(Complex[] complex, Complex dpixel) {

        double_iterations = 0;
        rebases = 0;

        iterations = 0;

        int RefIteration = iterations;

        Complex[] deltas = initializePerturbation(dpixel);
        Complex DeltaSubN = deltas[0]; // Delta z

        Complex zWithoutInitVal = new Complex();

        Complex pixel = dpixel.plus(refPointSmall);

        Complex refZ;

        ReferenceData data = referenceData;
        int MaxRefIteration = data.MaxRefIteration;

        for (; iterations < max_iterations; iterations++) {

            //No update values

            if (trap != null) {
                trap.check(complex[0], iterations);
            }

            if (iterations > 0 && convergent_bailout_algorithm.converged(complex[0], zold, zold2, iterations, pixel, start, c0, pixel)) {
                escaped = true;

                Object[] object = {iterations, complex[0], convergent_bailout_algorithm.getDistance(), zold, zold2, pixel, start, c0, pixel};
                iterationData = object;

                double res = out_color_algorithm.getResult(object);

                res = getFinalValueOut(res, complex[0]);

                if (outTrueColorAlgorithm != null) {
                    setTrueColorOut(complex[0], zold, zold2, iterations, pixel, start, c0, pixel);
                }

                return getAndAccumulateStatsNotDeep(res);
            }

            DeltaSubN = perturbationFunction(DeltaSubN, data, RefIteration);

            RefIteration++;
            double_iterations++;

            zold2.assign(zold);
            zold.assign(complex[0]);

            //No Plane influence work
            //No Pre filters work
            if(max_iterations > 1){
                refZ = getArrayValue(data.Reference, RefIteration);
                zWithoutInitVal = getArrayValue(data.ReferenceSubCp, RefIteration, refZ).plus_mutable(DeltaSubN);
                complex[0] = refZ.plus_mutable(DeltaSubN);
            }
            //No Post filters work

            if (statistic != null) {
                statistic.insert(complex[0], zold, zold2, iterations, pixel, start, c0);
            }

            if (zWithoutInitVal.norm_squared() < DeltaSubN.norm_squared() || RefIteration >= MaxRefIteration) {
                DeltaSubN = zWithoutInitVal;
                RefIteration = 0;

                data = secondReferenceData;
                MaxRefIteration = data.MaxRefIteration;

                rebases++;
            }

        }

        Object[] object = {complex[0], zold, zold2, pixel, start, c0, pixel};
        iterationData = object;

        double in = in_color_algorithm.getResult(object);

        in = getFinalValueIn(in, complex[0]);

        if (inTrueColorAlgorithm != null) {
            setTrueColorIn(complex[0], zold, zold2, iterations, pixel, start, c0, pixel);
        }

        return getAndAccumulateStatsNotDeep(in);

    }

    @Override
    public double iterateFractalWithPerturbation(Complex[] complex, MantExpComplex dpixel) {


        float_exp_iterations = 0;
        double_iterations = 0;
        rebases = 0;

        iterations = 0;

        int totalSkippedIterations = 0;

        int RefIteration = iterations;

        MantExpComplex[] deltas = initializePerturbation(dpixel);
        MantExpComplex DeltaSubN = deltas[0]; // Delta z

        Complex pixel = dpixel.plus(refPointSmallDeep).toComplex();

        int minExp = -1000;
        int reducedExp = minExp / (int)getPower();

        DeltaSubN.Normalize();
        long exp = DeltaSubN.getMinExp();

        ReferenceDeepData deepData = referenceDeepData;
        ReferenceData data = referenceData;
        int MaxRefIteration = data.MaxRefIteration;

        MantExpComplex refZm;

        boolean useFullFloatExp = useFullFloatExp();
        boolean doBailCheck = useFullFloatExp || TaskDraw.CHECK_BAILOUT_DURING_DEEP_NOT_FULL_FLOATEXP_MODE;

        if(useFullFloatExp || (totalSkippedIterations == 0 && exp <= minExp) || (totalSkippedIterations != 0 && exp <= reducedExp)) {

            MantExpComplex zWithoutInitVal = MantExpComplex.create();
            MantExpComplex z = getArrayDeepValue(deepData.Reference, RefIteration).plus_mutable(DeltaSubN);

            MantExpComplex zoldDeep;

            for (; iterations < max_iterations; iterations++) {
                if (trap != null) {
                    trap.check(complex[0], iterations);
                }

                if (doBailCheck && iterations > 0 && convergent_bailout_algorithm.converged(complex[0], zold, zold2, iterations, pixel, start, c0, pixel)) {
                    escaped = true;

                    Object[] object = {iterations, complex[0], convergent_bailout_algorithm.getDistance(), zold, zold2, pixel, start, c0, pixel};
                    iterationData = object;

                    double res = out_color_algorithm.getResult(object);

                    res = getFinalValueOut(res, complex[0]);

                    if (outTrueColorAlgorithm != null) {
                        setTrueColorOut(complex[0], zold, zold2, iterations, pixel, start, c0, pixel);
                    }

                    return getAndAccumulateStatsNotScaled(res);
                }

                DeltaSubN = perturbationFunction(DeltaSubN, deepData, RefIteration);

                RefIteration++;
                float_exp_iterations++;

                zold2.assign(zold);
                zold.assign(complex[0]);
                zoldDeep = z;

                if (max_iterations > 1) {
                    refZm = getArrayDeepValue(deepData.Reference, RefIteration);
                    zWithoutInitVal = getArrayDeepValue(deepData.ReferenceSubCp, RefIteration, refZm).plus_mutable(DeltaSubN);
                    z = refZm.plus_mutable(DeltaSubN);
                    complex[0] = z.toComplex();
                }

                if (statistic != null) {
                    statistic.insert(complex[0], zold, zold2, iterations, pixel, start, c0, z , zoldDeep, null);
                }

                if (zWithoutInitVal.norm_squared().compareToBothPositive(DeltaSubN.norm_squared()) < 0 || RefIteration >= MaxRefIteration) {
                    DeltaSubN = zWithoutInitVal;
                    RefIteration = 0;

                    deepData = secondReferenceDeepData;
                    data = secondReferenceData;

                    MaxRefIteration = data.MaxRefIteration;

                    rebases++;
                }

                DeltaSubN.Normalize();

                if(!useFullFloatExp) {
                    if (DeltaSubN.getMinExp() > reducedExp) {
                        iterations++;
                        break;
                    }
                }
            }
        }

        if(!useFullFloatExp) {
            Complex CDeltaSubN = DeltaSubN.toComplex();
            Complex zWithoutInitVal = new Complex();
            Complex refZ;

            for (; iterations < max_iterations; iterations++) {

                //No update values

                if (trap != null) {
                    trap.check(complex[0], iterations);
                }

                if (iterations > 0 && convergent_bailout_algorithm.converged(complex[0], zold, zold2, iterations, pixel, start, c0, pixel)) {
                    escaped = true;

                    Object[] object = {iterations, complex[0], convergent_bailout_algorithm.getDistance(), zold, zold2, pixel, start, c0, pixel};
                    iterationData = object;

                    double res = out_color_algorithm.getResult(object);

                    res = getFinalValueOut(res, complex[0]);

                    if (outTrueColorAlgorithm != null) {
                        setTrueColorOut(complex[0], zold, zold2, iterations, pixel, start, c0, pixel);
                    }

                    return getAndAccumulateStatsNotScaled(res);
                }

                CDeltaSubN = perturbationFunction(CDeltaSubN, data, RefIteration);

                RefIteration++;
                double_iterations++;

                zold2.assign(zold);
                zold.assign(complex[0]);

                //No Plane influence work
                //No Pre filters work
                if (max_iterations > 1) {
                    refZ = getArrayValue(data.Reference, RefIteration);
                    zWithoutInitVal = getArrayValue(data.ReferenceSubCp, RefIteration, refZ).plus_mutable(CDeltaSubN);
                    complex[0] = refZ.plus_mutable(CDeltaSubN);
                }
                //No Post filters work

                if (statistic != null) {
                    statistic.insert(complex[0], zold, zold2, iterations, pixel, start, c0);
                }

                if (zWithoutInitVal.norm_squared() < CDeltaSubN.norm_squared() || RefIteration >= MaxRefIteration) {
                    CDeltaSubN = zWithoutInitVal;
                    RefIteration = 0;

                    data = secondReferenceData;
                    MaxRefIteration = data.MaxRefIteration;
                    rebases++;
                }

            }
        }

        Object[] object = {complex[0], zold, zold2, pixel, start, c0, pixel};
        iterationData = object;

        double in = in_color_algorithm.getResult(object);

        in = getFinalValueIn(in, complex[0]);

        if (inTrueColorAlgorithm != null) {
            setTrueColorIn(complex[0], zold, zold2, iterations, pixel, start, c0, pixel);
        }

        return getAndAccumulateStatsNotScaled(in);

    }

    public static Complex applyStep(Complex z, Complex step, Complex relaxation) {

        return z.sub(step.times(relaxation));

    }

    public abstract Complex evaluateFunction(Complex z, Complex c);

}
