package fractalzoomer.functions.formulas.m_like_generalization;

import fractalzoomer.core.*;
import fractalzoomer.fractal_options.initial_value.InitialValue;
import fractalzoomer.fractal_options.initial_value.VariableConditionalInitialValue;
import fractalzoomer.fractal_options.initial_value.VariableInitialValue;
import fractalzoomer.fractal_options.perturbation.DefaultPerturbation;
import fractalzoomer.functions.Julia;
import fractalzoomer.main.app_settings.OrbitTrapSettings;
import fractalzoomer.main.app_settings.StatisticsSettings;
import fractalzoomer.utils.NormComponents;

import java.util.ArrayList;

public class BuffaloMandelbrot extends Julia {
    public BuffaloMandelbrot(double xCenter, double yCenter, double size, int max_iterations, int bailout_test_algorithm, double bailout, String bailout_test_user_formula, String bailout_test_user_formula2, int bailout_test_comparison, double n_norm, int out_coloring_algorithm, int user_out_coloring_algorithm, String outcoloring_formula, String[] user_outcoloring_conditions, String[] user_outcoloring_condition_formula, int in_coloring_algorithm, int user_in_coloring_algorithm, String incoloring_formula, String[] user_incoloring_conditions, String[] user_incoloring_condition_formula, boolean smoothing, boolean periodicity_checking, int plane_type, double[] rotation_vals, double[] rotation_center, boolean perturbation, double[] perturbation_vals, boolean variable_perturbation, int user_perturbation_algorithm, String[] user_perturbation_conditions, String[] user_perturbation_condition_formula, String perturbation_user_formula, boolean init_value, double[] initial_vals, boolean variable_init_value, int user_initial_value_algorithm, String[] user_initial_value_conditions, String[] user_initial_value_condition_formula, String initial_value_user_formula, String user_plane, int user_plane_algorithm, String[] user_plane_conditions, String[] user_plane_condition_formula, double[] plane_transform_center, double plane_transform_angle, double plane_transform_radius, double[] plane_transform_scales, double[] plane_transform_wavelength, int waveType, double plane_transform_angle2, int plane_transform_sides, double plane_transform_amount, ArrayList<Double> inflections_re, ArrayList<Double> inflections_im, double inflectionsPower, int escaping_smooth_algorithm, OrbitTrapSettings ots, StatisticsSettings sts) {

        super(xCenter, yCenter, size, max_iterations, bailout_test_algorithm, bailout, bailout_test_user_formula, bailout_test_user_formula2, bailout_test_comparison, n_norm, periodicity_checking, plane_type, rotation_vals, rotation_center, user_plane, user_plane_algorithm, user_plane_conditions, user_plane_condition_formula, plane_transform_center, plane_transform_angle, plane_transform_radius, plane_transform_scales, plane_transform_wavelength, waveType, plane_transform_angle2, plane_transform_sides, plane_transform_amount, inflections_re, inflections_im, inflectionsPower, ots);

        setPertubationOption(perturbation, perturbation_vals, variable_perturbation, user_perturbation_algorithm, perturbation_user_formula, user_perturbation_conditions, user_perturbation_condition_formula, plane_transform_center);

        if(init_value) {
            if(variable_init_value) {
                if(user_initial_value_algorithm == 0) {
                    init_val = new VariableInitialValue(initial_value_user_formula, xCenter, yCenter, size, max_iterations, plane_transform_center, globalVars);
                }
                else {
                    init_val = new VariableConditionalInitialValue(user_initial_value_conditions, user_initial_value_condition_formula, xCenter, yCenter, size, max_iterations, plane_transform_center, globalVars);
                }
            }
            else {
                init_val = new InitialValue(initial_vals[0], initial_vals[1]);
            }
        }
        else {
            init_val = new InitialValue(0, 0);
        }

        OutColoringAlgorithmFactory(out_coloring_algorithm, smoothing, escaping_smooth_algorithm, user_out_coloring_algorithm, outcoloring_formula, user_outcoloring_conditions, user_outcoloring_condition_formula, plane_transform_center);

        InColoringAlgorithmFactory(in_coloring_algorithm, user_in_coloring_algorithm, incoloring_formula, user_incoloring_conditions, user_incoloring_condition_formula, plane_transform_center);

        if(sts.statistic) {
            StatisticFactory(sts, plane_transform_center);
        }
    }

    public BuffaloMandelbrot(double xCenter, double yCenter, double size, int max_iterations, int bailout_test_algorithm, double bailout, String bailout_test_user_formula, String bailout_test_user_formula2, int bailout_test_comparison, double n_norm, int out_coloring_algorithm, int user_out_coloring_algorithm, String outcoloring_formula, String[] user_outcoloring_conditions, String[] user_outcoloring_condition_formula, int in_coloring_algorithm, int user_in_coloring_algorithm, String incoloring_formula, String[] user_incoloring_conditions, String[] user_incoloring_condition_formula, boolean smoothing, boolean periodicity_checking, int plane_type, boolean apply_plane_on_julia, boolean apply_plane_on_julia_seed, double[] rotation_vals, double[] rotation_center, String user_plane, int user_plane_algorithm, String[] user_plane_conditions, String[] user_plane_condition_formula, double[] plane_transform_center, double plane_transform_angle, double plane_transform_radius, double[] plane_transform_scales, double[] plane_transform_wavelength, int waveType, double plane_transform_angle2, int plane_transform_sides, double plane_transform_amount, ArrayList<Double> inflections_re, ArrayList<Double> inflections_im, double inflectionsPower, int escaping_smooth_algorithm, OrbitTrapSettings ots, StatisticsSettings sts, double xJuliaCenter, double yJuliaCenter) {

        super(xCenter, yCenter, size, max_iterations, bailout_test_algorithm, bailout, bailout_test_user_formula, bailout_test_user_formula2, bailout_test_comparison, n_norm, periodicity_checking, plane_type, apply_plane_on_julia, apply_plane_on_julia_seed, rotation_vals, rotation_center, user_plane, user_plane_algorithm, user_plane_conditions, user_plane_condition_formula, plane_transform_center, plane_transform_angle, plane_transform_radius, plane_transform_scales, plane_transform_wavelength, waveType, plane_transform_angle2, plane_transform_sides, plane_transform_amount, inflections_re, inflections_im, inflectionsPower, ots, xJuliaCenter, yJuliaCenter);

        OutColoringAlgorithmFactory(out_coloring_algorithm, smoothing, escaping_smooth_algorithm, user_out_coloring_algorithm, outcoloring_formula, user_outcoloring_conditions, user_outcoloring_condition_formula, plane_transform_center);

        InColoringAlgorithmFactory(in_coloring_algorithm, user_in_coloring_algorithm, incoloring_formula, user_incoloring_conditions, user_incoloring_condition_formula, plane_transform_center);

        if(sts.statistic) {
            StatisticFactory(sts, plane_transform_center);
        }

        pertur_val = new DefaultPerturbation();
        init_val = new InitialValue(0, 0);
    }

    //orbit
    public BuffaloMandelbrot(double xCenter, double yCenter, double size, int max_iterations, ArrayList<Complex> complex_orbit, int plane_type, double[] rotation_vals, double[] rotation_center, boolean perturbation, double[] perturbation_vals, boolean variable_perturbation, int user_perturbation_algorithm, String[] user_perturbation_conditions, String[] user_perturbation_condition_formula, String perturbation_user_formula, boolean init_value, double[] initial_vals, boolean variable_init_value, int user_initial_value_algorithm, String[] user_initial_value_conditions, String[] user_initial_value_condition_formula, String initial_value_user_formula, String user_plane, int user_plane_algorithm, String[] user_plane_conditions, String[] user_plane_condition_formula, double[] plane_transform_center, double plane_transform_angle, double plane_transform_radius, double[] plane_transform_scales, double[] plane_transform_wavelength, int waveType, double plane_transform_angle2, int plane_transform_sides, double plane_transform_amount, ArrayList<Double> inflections_re, ArrayList<Double> inflections_im, double inflectionsPower) {

        super(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, rotation_center, user_plane, user_plane_algorithm, user_plane_conditions, user_plane_condition_formula, plane_transform_center, plane_transform_angle, plane_transform_radius, plane_transform_scales, plane_transform_wavelength, waveType, plane_transform_angle2, plane_transform_sides, plane_transform_amount, inflections_re, inflections_im, inflectionsPower);

        setPertubationOption(perturbation, perturbation_vals, variable_perturbation, user_perturbation_algorithm, perturbation_user_formula, user_perturbation_conditions, user_perturbation_condition_formula, plane_transform_center);

        if(init_value) {
            if(variable_init_value) {
                if(user_initial_value_algorithm == 0) {
                    init_val = new VariableInitialValue(initial_value_user_formula, xCenter, yCenter, size, max_iterations, plane_transform_center, globalVars);
                }
                else {
                    init_val = new VariableConditionalInitialValue(user_initial_value_conditions, user_initial_value_condition_formula, xCenter, yCenter, size, max_iterations, plane_transform_center, globalVars);
                }
            }
            else {
                init_val = new InitialValue(initial_vals[0], initial_vals[1]);
            }
        }
        else {
            init_val = new InitialValue(0, 0);
        }

    }

    public BuffaloMandelbrot(double xCenter, double yCenter, double size, int max_iterations, ArrayList<Complex> complex_orbit, int plane_type, boolean apply_plane_on_julia, boolean apply_plane_on_julia_seed, double[] rotation_vals, double[] rotation_center, String user_plane, int user_plane_algorithm, String[] user_plane_conditions, String[] user_plane_condition_formula, double[] plane_transform_center, double plane_transform_angle, double plane_transform_radius, double[] plane_transform_scales, double[] plane_transform_wavelength, int waveType, double plane_transform_angle2, int plane_transform_sides, double plane_transform_amount, ArrayList<Double> inflections_re, ArrayList<Double> inflections_im, double inflectionsPower, double xJuliaCenter, double yJuliaCenter) {

        super(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, apply_plane_on_julia, apply_plane_on_julia_seed, rotation_vals, rotation_center, user_plane, user_plane_algorithm, user_plane_conditions, user_plane_condition_formula, plane_transform_center, plane_transform_angle, plane_transform_radius, plane_transform_scales, plane_transform_wavelength, waveType, plane_transform_angle2, plane_transform_sides, plane_transform_amount, inflections_re, inflections_im, inflectionsPower, xJuliaCenter, yJuliaCenter);
        pertur_val = new DefaultPerturbation();
        init_val = new InitialValue(0, 0);
    }

    @Override
    public void function(Complex[] complex) {

        complex[0].square_mutable().abs_mutable().plus_mutable(complex[1]);

    }

    @Override
    public boolean supportsPerturbationTheory() {
        if(isJuliaMap) {
            return false;
        }
        return !isJulia || !juliter;
    }

    @Override
    public String getRefType() {
        return super.getRefType() + (isJulia ? "-Julia-" + bigSeed.toStringPretty() : "");
    }

    @Override
    public Complex perturbationFunction(Complex DeltaSubN, Complex DeltaSub0, int RefIteration) {

        Complex X = getArrayValue(reference, RefIteration);
        double Xr = X.getRe();
        double Xi = X.getIm();

        double xr = DeltaSubN.getRe();
        double xi = DeltaSubN.getIm();

        double Xr2 = Xr * Xr;
        double Xi2 = Xi * Xi;

        double Xxi = Xi + xi;

        double xrn = Complex.DiffAbs(Xr2 - Xi2, (2 * Xr + xr) * xr - (2 * Xi + xi) * xi);
        double xin = 2 * Complex.DiffAbs(Xr * Xi, Xr * xi + xr * Xxi);

        return new Complex(xrn, xin).plus_mutable(DeltaSub0);

    }

    @Override
    public Complex perturbationFunction(Complex DeltaSubN, ReferenceData data, int RefIteration) {

        Complex X = getArrayValue(data.Reference, RefIteration);
        double Xr = X.getRe();
        double Xi = X.getIm();

        double xr = DeltaSubN.getRe();
        double xi = DeltaSubN.getIm();

        double Xr2 = Xr * Xr;
        double Xi2 = Xi * Xi;

        double Xxi = Xi + xi;

        double xrn = Complex.DiffAbs(Xr2 - Xi2, (2 * Xr + xr) * xr - (2 * Xi + xi) * xi);
        double xin = 2 * Complex.DiffAbs(Xr * Xi, Xr * xi + xr * Xxi);

        return new Complex(xrn, xin);

    }

    @Override
    public MantExpComplex perturbationFunction(MantExpComplex DeltaSubN, ReferenceDeepData data, int RefIteration) {
        MantExpComplex X = getArrayDeepValue(data.Reference, RefIteration);
        MantExp Xr = X.getRe();
        MantExp Xi = X.getIm();

        MantExp xr = DeltaSubN.getRe();
        MantExp xi = DeltaSubN.getIm();

        MantExp Xr2 = Xr.square();
        MantExp Xi2 = Xi.square();

        MantExp Xxi = Xi.add(xi);

        MantExp xrn = MantExpComplex.DiffAbs(Xr2.subtract(Xi2), Xr.multiply2().add_mutable(xr).multiply_mutable(xr).subtract_mutable(Xi.multiply2().add_mutable(xi).multiply_mutable(xi)));//Complex.DiffAbs(Xr2 - Xi2, (2 * Xr + xr) * xr - (2 * Xi + xi) * xi);
        MantExp xin = MantExpComplex.DiffAbs(Xr.multiply(Xi), Xr.multiply(xi).add_mutable(xr.multiply(Xxi))).multiply2_mutable();//2 * Complex.DiffAbs(Xr * Xi, Xr * xi + xr * Xxi);

        return MantExpComplex.create(xrn, xin);
    }

    @Override
    public MantExpComplex perturbationFunction(MantExpComplex DeltaSubN, MantExpComplex DeltaSub0, int RefIteration) {

        MantExpComplex X = getArrayDeepValue(referenceDeep, RefIteration);
        MantExp Xr = X.getRe();
        MantExp Xi = X.getIm();

        MantExp xr = DeltaSubN.getRe();
        MantExp xi = DeltaSubN.getIm();

        MantExp Xr2 = Xr.square();
        MantExp Xi2 = Xi.square();

        MantExp Xxi = Xi.add(xi);

        MantExp xrn = MantExpComplex.DiffAbs(Xr2.subtract(Xi2), Xr.multiply2().add_mutable(xr).multiply_mutable(xr).subtract_mutable(Xi.multiply2().add_mutable(xi).multiply_mutable(xi)));//Complex.DiffAbs(Xr2 - Xi2, (2 * Xr + xr) * xr - (2 * Xi + xi) * xi);
        MantExp xin = MantExpComplex.DiffAbs(Xr.multiply(Xi), Xr.multiply(xi).add_mutable(xr.multiply(Xxi))).multiply2_mutable();//2 * Complex.DiffAbs(Xr * Xi, Xr * xi + xr * Xxi);

        return MantExpComplex.create(xrn, xin).plus_mutable(DeltaSub0);
    }

    @Override
    public Complex perturbationFunction(Complex DeltaSubN, int RefIteration) {

        Complex X = getArrayValue(reference, RefIteration);
        double Xr = X.getRe();
        double Xi = X.getIm();

        double xr = DeltaSubN.getRe();
        double xi = DeltaSubN.getIm();

        double Xr2 = Xr * Xr;
        double Xi2 = Xi * Xi;

        double Xxi = Xi + xi;

        double xrn = Complex.DiffAbs(Xr2 - Xi2, (2 * Xr + xr) * xr - (2 * Xi + xi) * xi);
        double xin = 2 * Complex.DiffAbs(Xr * Xi, Xr * xi + xr * Xxi);

        return new Complex(xrn, xin);

    }

    @Override
    public MantExpComplex perturbationFunction(MantExpComplex DeltaSubN, int RefIteration) {

        MantExpComplex X = getArrayDeepValue(referenceDeep, RefIteration);
        MantExp Xr = X.getRe();
        MantExp Xi = X.getIm();

        MantExp xr = DeltaSubN.getRe();
        MantExp xi = DeltaSubN.getIm();

        MantExp Xr2 = Xr.square();
        MantExp Xi2 = Xi.square();

        MantExp Xxi = Xi.add(xi);

        MantExp xrn = MantExpComplex.DiffAbs(Xr2.subtract(Xi2), Xr.multiply2().add_mutable(xr).multiply_mutable(xr).subtract_mutable(Xi.multiply2().add_mutable(xi).multiply_mutable(xi)));//Complex.DiffAbs(Xr2 - Xi2, (2 * Xr + xr) * xr - (2 * Xi + xi) * xi);
        MantExp xin = MantExpComplex.DiffAbs(Xr.multiply(Xi), Xr.multiply(xi).add_mutable(xr.multiply(Xxi))).multiply2_mutable();//2 * Complex.DiffAbs(Xr * Xi, Xr * xi + xr * Xxi);

        return MantExpComplex.create(xrn, xin);
    }

    @Override
    public void function(GenericComplex[] complex) {

        if(complex[0] instanceof MpfrBigNumComplex) {
            complex[0] = complex[0].square_mutable(workSpaceData.temp1, workSpaceData.temp2).abs_mutable().plus_mutable(complex[1]);
        }
        else if(complex[0] instanceof MpirBigNumComplex) {
            complex[0] = complex[0].square_mutable(workSpaceData.temp1p, workSpaceData.temp2p).abs_mutable().plus_mutable(complex[1]);
        }
        else {
            complex[0] = complex[0].square_mutable().abs_mutable().plus_mutable(complex[1]);
        }

    }

    @Override
    public boolean supportsBignum() { return true;}

    @Override
    public boolean supportsBigIntnum() {
        return true;
    }

    @Override
    public boolean supportsMpfrBignum() { return true;}

    @Override
    public boolean supportsMpirBignum() { return true;}

    @Override
    protected GenericComplex referenceFunction(GenericComplex z, GenericComplex c, NormComponents normData, GenericComplex[] initialPrecal, GenericComplex[] precalc) {

        if(normData != null) {
            z = z.squareFast_mutable(normData).abs_mutable().plus_mutable(c);
        }
        else {
            if (z instanceof MpfrBigNumComplex) {
                z = z.square_mutable(workSpaceData.temp1, workSpaceData.temp2).abs_mutable().plus_mutable(c);
            } else if (z instanceof MpirBigNumComplex) {
                z = z.square_mutable(workSpaceData.temp1p, workSpaceData.temp2p).abs_mutable().plus_mutable(c);
            } else {
                z = z.square_mutable().abs_mutable().plus_mutable(c);
            }
        }

        return z;

    }

    @Override
    public boolean supportsReferenceCompression() {
        return true;
    }

    @Override
    public Complex function(Complex z, Complex c) {
        return z.square_mutable().abs_mutable().plus_mutable(c);
    }

    @Override
    public MantExpComplex function(MantExpComplex z, MantExpComplex c) {
        return z.square_mutable().abs_mutable().plus_mutable(c);
    }

    @Override
    public double getPower() {
        return 2;
    }

}
