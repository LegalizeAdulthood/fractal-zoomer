package fractalzoomer.functions.magnet;

import fractalzoomer.core.*;
import fractalzoomer.core.location.Location;
import fractalzoomer.functions.Julia;
import fractalzoomer.main.Constants;
import fractalzoomer.main.MainWindow;
import fractalzoomer.main.app_settings.OrbitTrapSettings;
import fractalzoomer.main.app_settings.StatisticsSettings;
import fractalzoomer.out_coloring_algorithms.*;
import fractalzoomer.utils.NormComponents;

import java.util.ArrayList;

public abstract class MagnetPatakiType extends Julia {
    protected double exponent;
    protected static Complex Cp1;
    protected static MantExpComplex Cp1Deep;

    public MagnetPatakiType(double xCenter, double yCenter, double size, int max_iterations, int bailout_test_algorithm, double bailout, String bailout_test_user_formula, String bailout_test_user_formula2, int bailout_test_comparison, double n_norm, int out_coloring_algorithm, int user_out_coloring_algorithm, String outcoloring_formula, String[] user_outcoloring_conditions, String[] user_outcoloring_condition_formula, int in_coloring_algorithm, int user_in_coloring_algorithm, String incoloring_formula, String[] user_incoloring_conditions, String[] user_incoloring_condition_formula, boolean smoothing, boolean periodicity_checking, int plane_type, double[] rotation_vals, double[] rotation_center, boolean perturbation, double[] perturbation_vals, boolean variable_perturbation, int user_perturbation_algorithm, String[] user_perturbation_conditions, String[] user_perturbation_condition_formula, String perturbation_user_formula, boolean init_value, double[] initial_vals, boolean variable_init_value, int user_initial_value_algorithm, String[] user_initial_value_conditions, String[] user_initial_value_condition_formula, String initial_value_user_formula, String user_plane, int user_plane_algorithm, String[] user_plane_conditions, String[] user_plane_condition_formula, double[] plane_transform_center, double plane_transform_angle, double plane_transform_radius, double[] plane_transform_scales, double[] plane_transform_wavelength, int waveType, double plane_transform_angle2, int plane_transform_sides, double plane_transform_amount, ArrayList<Double> inflections_re, ArrayList<Double> inflections_im, double inflectionsPower, int escaping_smooth_algorithm, OrbitTrapSettings ots, StatisticsSettings sts) {

        super(xCenter, yCenter, size, max_iterations, bailout_test_algorithm, bailout, bailout_test_user_formula, bailout_test_user_formula2, bailout_test_comparison, n_norm, periodicity_checking, plane_type, rotation_vals, rotation_center, user_plane, user_plane_algorithm, user_plane_conditions, user_plane_condition_formula, plane_transform_center, plane_transform_angle, plane_transform_radius, plane_transform_scales, plane_transform_wavelength, waveType, plane_transform_angle2, plane_transform_sides, plane_transform_amount, inflections_re, inflections_im, inflectionsPower, ots);

    }

    public MagnetPatakiType(double xCenter, double yCenter, double size, int max_iterations, int bailout_test_algorithm, double bailout, String bailout_test_user_formula, String bailout_test_user_formula2, int bailout_test_comparison, double n_norm, int out_coloring_algorithm, int user_out_coloring_algorithm, String outcoloring_formula, String[] user_outcoloring_conditions, String[] user_outcoloring_condition_formula, int in_coloring_algorithm, int user_in_coloring_algorithm, String incoloring_formula, String[] user_incoloring_conditions, String[] user_incoloring_condition_formula, boolean smoothing, boolean periodicity_checking, int plane_type, boolean apply_plane_on_julia, boolean apply_plane_on_julia_seed, double[] rotation_vals, double[] rotation_center, String user_plane, int user_plane_algorithm, String[] user_plane_conditions, String[] user_plane_condition_formula, double[] plane_transform_center, double plane_transform_angle, double plane_transform_radius, double[] plane_transform_scales, double[] plane_transform_wavelength, int waveType, double plane_transform_angle2, int plane_transform_sides, double plane_transform_amount, ArrayList<Double> inflections_re, ArrayList<Double> inflections_im, double inflectionsPower, int escaping_smooth_algorithm, OrbitTrapSettings ots, StatisticsSettings sts, double xJuliaCenter, double yJuliaCenter) {

        super(xCenter, yCenter, size, max_iterations, bailout_test_algorithm, bailout, bailout_test_user_formula, bailout_test_user_formula2, bailout_test_comparison, n_norm, periodicity_checking, plane_type, apply_plane_on_julia, apply_plane_on_julia_seed, rotation_vals, rotation_center, user_plane, user_plane_algorithm, user_plane_conditions, user_plane_condition_formula, plane_transform_center, plane_transform_angle, plane_transform_radius, plane_transform_scales, plane_transform_wavelength, waveType, plane_transform_angle2, plane_transform_sides, plane_transform_amount, inflections_re, inflections_im, inflectionsPower, ots, xJuliaCenter, yJuliaCenter);

    }

    //orbit
    public MagnetPatakiType(double xCenter, double yCenter, double size, int max_iterations, ArrayList<Complex> complex_orbit, int plane_type, double[] rotation_vals, double[] rotation_center, boolean perturbation, double[] perturbation_vals, boolean variable_perturbation, int user_perturbation_algorithm, String[] user_perturbation_conditions, String[] user_perturbation_condition_formula, String perturbation_user_formula, boolean init_value, double[] initial_vals, boolean variable_init_value, int user_initial_value_algorithm, String[] user_initial_value_conditions, String[] user_initial_value_condition_formula, String initial_value_user_formula, String user_plane, int user_plane_algorithm, String[] user_plane_conditions, String[] user_plane_condition_formula, double[] plane_transform_center, double plane_transform_angle, double plane_transform_radius, double[] plane_transform_scales, double[] plane_transform_wavelength, int waveType, double plane_transform_angle2, int plane_transform_sides, double plane_transform_amount, ArrayList<Double> inflections_re, ArrayList<Double> inflections_im, double inflectionsPower) {

        super(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, rotation_center, user_plane, user_plane_algorithm, user_plane_conditions, user_plane_condition_formula, plane_transform_center, plane_transform_angle, plane_transform_radius, plane_transform_scales, plane_transform_wavelength, waveType, plane_transform_angle2, plane_transform_sides, plane_transform_amount, inflections_re, inflections_im, inflectionsPower);

    }

    public MagnetPatakiType(double xCenter, double yCenter, double size, int max_iterations, ArrayList<Complex> complex_orbit, int plane_type, boolean apply_plane_on_julia, boolean apply_plane_on_julia_seed, double[] rotation_vals, double[] rotation_center, String user_plane, int user_plane_algorithm, String[] user_plane_conditions, String[] user_plane_condition_formula, double[] plane_transform_center, double plane_transform_angle, double plane_transform_radius, double[] plane_transform_scales, double[] plane_transform_wavelength, int waveType, double plane_transform_angle2, int plane_transform_sides, double plane_transform_amount, ArrayList<Double> inflections_re, ArrayList<Double> inflections_im, double inflectionsPower, double xJuliaCenter, double yJuliaCenter) {

        super(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, apply_plane_on_julia, apply_plane_on_julia_seed, rotation_vals, rotation_center, user_plane, user_plane_algorithm, user_plane_conditions, user_plane_condition_formula, plane_transform_center, plane_transform_angle, plane_transform_radius, plane_transform_scales, plane_transform_wavelength, waveType, plane_transform_angle2, plane_transform_sides, plane_transform_amount, inflections_re, inflections_im, inflectionsPower, xJuliaCenter, yJuliaCenter);

    }

    @Override
    protected void OutColoringAlgorithmFactory(int out_coloring_algorithm, boolean smoothing, int escaping_smooth_algorithm, int user_out_coloring_algorithm, String outcoloring_formula, String[] user_outcoloring_conditions, String[] user_outcoloring_condition_formula, double[] plane_transform_center) {

        double log_power = getLogPower();
        switch (out_coloring_algorithm) {

            case MainWindow.ESCAPE_TIME:
                if (!smoothing) {
                    out_color_algorithm = new EscapeTime();
                } else {
                    out_color_algorithm = new SmoothEscapeTime(log_bailout_squared, escaping_smooth_algorithm, log_power);
                }
                break;
            case MainWindow.BINARY_DECOMPOSITION:
                if (!smoothing) {
                    out_color_algorithm = new BinaryDecomposition();
                } else {
                    out_color_algorithm = new SmoothBinaryDecomposition(log_bailout_squared, escaping_smooth_algorithm, log_power);
                }
                break;
            case MainWindow.BINARY_DECOMPOSITION2:
                if (!smoothing) {
                    out_color_algorithm = new BinaryDecomposition2();
                } else {
                    out_color_algorithm = new SmoothBinaryDecomposition2(log_bailout_squared, escaping_smooth_algorithm, log_power);
                }
                break;
            case MainWindow.BIOMORPH:
                if (!smoothing) {
                    out_color_algorithm = new Biomorphs(bailout);
                } else {
                    out_color_algorithm = new SmoothBiomorphs(log_bailout_squared, bailout, escaping_smooth_algorithm, log_power);
                }
                break;
            case MainWindow.ESCAPE_TIME_GRID:
                if (!smoothing) {
                    out_color_algorithm = new EscapeTimeGrid(log_bailout_squared);
                } else {
                    out_color_algorithm = new SmoothEscapeTimeGrid(log_bailout_squared, escaping_smooth_algorithm, log_power);
                }
                break;
            case MainWindow.ESCAPE_TIME_FIELD_LINES:
                if (!smoothing) {
                    out_color_algorithm = new EscapeTimeFieldLines(log_bailout_squared);
                } else {
                    out_color_algorithm = new SmoothEscapeTimeFieldLines(log_bailout_squared, escaping_smooth_algorithm, log_power);
                }
                break;
            case MainWindow.ESCAPE_TIME_FIELD_LINES2:
                if (!smoothing) {
                    out_color_algorithm = new EscapeTimeFieldLines2(log_bailout_squared);
                } else {
                    out_color_algorithm = new SmoothEscapeTimeFieldLines2(log_bailout_squared, escaping_smooth_algorithm, log_power);
                }
                break;

        }

        if(out_color_algorithm == null) {
            super.OutColoringAlgorithmFactory(out_coloring_algorithm, smoothing, escaping_smooth_algorithm, user_out_coloring_algorithm, outcoloring_formula, user_outcoloring_conditions, user_outcoloring_condition_formula, plane_transform_center);
        }

    }

    protected double getLogPower() {
        return Math.log(Math.sqrt(exponent));
    }

    @Override
    public GenericComplex[] initializeReferencePrecalculationData(GenericComplex c, Location loc, int bigNumLib, boolean lowPrecReferenceOrbitNeeded, boolean deepZoom) {

        GenericComplex cp1;

        if(bigNumLib != Constants.BIGNUM_APFLOAT) {
            cp1 = c.plus(1);
        }
        else {
            cp1 = c.plus(MyApfloat.ONE);
        }

        if(deepZoom) {
            Cp1Deep = loc.getMantExpComplex(cp1);

            if(lowPrecReferenceOrbitNeeded) {
                Cp1 = Cp1Deep.toComplex();
            }
        }
        else {
            if(lowPrecReferenceOrbitNeeded) {
                Cp1 = cp1.toComplex();
            }
        }

        return null;
    }

    @Override
    protected int[] getNeededPrecalculatedTermsIndexes() {
        return new int[] {0, 1};
    }

    @Override
    protected GenericComplex referenceFunction(GenericComplex z, GenericComplex c, NormComponents normData, GenericComplex[] initialPrecal, GenericComplex[] precalc) {

        return precalc[0].plus(c).divide_mutable(precalc[1]);

    }

    @Override
    public double getDoubleLimit() {
        if(isJulia) {
            return 1.0e-4;
        }
        return 5.0e-9;
    }

    @Override
    public double getDoubleDoubleLimit() {
        if(TaskDraw.HIGH_PRECISION_CALCULATION) {
            return 5.0e-25;
        }

        return 1.0e-18;
    }

    @Override
    public double getPower() {
        return exponent;
    }
}
