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
package fractalzoomer.functions.general;

import fractalzoomer.core.*;
import fractalzoomer.core.location.Location;
import fractalzoomer.fractal_options.initial_value.DefaultInitialValue;
import fractalzoomer.fractal_options.initial_value.InitialValue;
import fractalzoomer.fractal_options.initial_value.VariableConditionalInitialValue;
import fractalzoomer.fractal_options.initial_value.VariableInitialValue;
import fractalzoomer.fractal_options.perturbation.DefaultPerturbation;
import fractalzoomer.functions.ExtendedConvergentType;
import fractalzoomer.functions.root_finding_methods.abbasbandy.AbbasbandyRootFindingMethod;
import fractalzoomer.functions.root_finding_methods.abbasbandy2.Abbasbandy2RootFindingMethod;
import fractalzoomer.functions.root_finding_methods.abbasbandy3.Abbasbandy3RootFindingMethod;
import fractalzoomer.functions.root_finding_methods.changbum_chun1.ChangBumChun1RootFindingMethod;
import fractalzoomer.functions.root_finding_methods.changbum_chun2.ChangBumChun2RootFindingMethod;
import fractalzoomer.functions.root_finding_methods.changbum_chun3.ChangBumChun3RootFindingMethod;
import fractalzoomer.functions.root_finding_methods.chun_ham.ChunHamRootFindingMethod;
import fractalzoomer.functions.root_finding_methods.chun_kim.ChunKimRootFindingMethod;
import fractalzoomer.functions.root_finding_methods.contra_harmonic_newton.ContraHarmonicNewtonRootFindingMethod;
import fractalzoomer.functions.root_finding_methods.euler_chebyshev.EulerChebyshevRootFindingMethod;
import fractalzoomer.functions.root_finding_methods.ezzati_saleki1.EzzatiSaleki1RootFindingMethod;
import fractalzoomer.functions.root_finding_methods.ezzati_saleki2.EzzatiSaleki2RootFindingMethod;
import fractalzoomer.functions.root_finding_methods.feng.FengRootFindingMethod;
import fractalzoomer.functions.root_finding_methods.halley.HalleyRootFindingMethod;
import fractalzoomer.functions.root_finding_methods.harmonic_simpson_newton.HarmonicSimpsonNewtonRootFindingMethod;
import fractalzoomer.functions.root_finding_methods.homeier1.Homeier1RootFindingMethod;
import fractalzoomer.functions.root_finding_methods.homeier2.Homeier2RootFindingMethod;
import fractalzoomer.functions.root_finding_methods.householder.HouseholderRootFindingMethod;
import fractalzoomer.functions.root_finding_methods.householder3.Householder3RootFindingMethod;
import fractalzoomer.functions.root_finding_methods.jaratt.JarattRootFindingMethod;
import fractalzoomer.functions.root_finding_methods.jaratt2.Jaratt2RootFindingMethod;
import fractalzoomer.functions.root_finding_methods.kim_chun.KimChunRootFindingMethod;
import fractalzoomer.functions.root_finding_methods.king1.King1RootFindingMethod;
import fractalzoomer.functions.root_finding_methods.king3.King3RootFindingMethod;
import fractalzoomer.functions.root_finding_methods.kou_li_wang1.KouLiWang1RootFindingMethod;
import fractalzoomer.functions.root_finding_methods.laguerre.LaguerreRootFindingMethod;
import fractalzoomer.functions.root_finding_methods.maheshweri.MaheshweriRootFindingMethod;
import fractalzoomer.functions.root_finding_methods.midpoint.MidpointRootFindingMethod;
import fractalzoomer.functions.root_finding_methods.muller.MullerRootFindingMethod;
import fractalzoomer.functions.root_finding_methods.nedzhibov.NedzhibovRootFindingMethod;
import fractalzoomer.functions.root_finding_methods.newton.NewtonRootFindingMethod;
import fractalzoomer.functions.root_finding_methods.newton_hines.NewtonHinesRootFindingMethod;
import fractalzoomer.functions.root_finding_methods.noor_gupta.NoorGuptaRootFindingMethod;
import fractalzoomer.functions.root_finding_methods.parhalley.ParhalleyRootFindingMethod;
import fractalzoomer.functions.root_finding_methods.popovski1.Popovski1RootFindingMethod;
import fractalzoomer.functions.root_finding_methods.rafis_rafiullah.RafisRafiullahRootFindingMethod;
import fractalzoomer.functions.root_finding_methods.rafiullah1.Rafiullah1RootFindingMethod;
import fractalzoomer.functions.root_finding_methods.schroder.SchroderRootFindingMethod;
import fractalzoomer.functions.root_finding_methods.secant.SecantRootFindingMethod;
import fractalzoomer.functions.root_finding_methods.simpson_newton.SimpsonNewtonRootFindingMethod;
import fractalzoomer.functions.root_finding_methods.steffensen.SteffensenRootFindingMethod;
import fractalzoomer.functions.root_finding_methods.stirling.StirlingRootFindingMethod;
import fractalzoomer.functions.root_finding_methods.super_halley.SuperHalleyRootFindingMethod;
import fractalzoomer.functions.root_finding_methods.third_order_newton.ThirdOrderNewtonRootFindingMethod;
import fractalzoomer.functions.root_finding_methods.traub_ostrowski.TraubOstrowskiRootFindingMethod;
import fractalzoomer.functions.root_finding_methods.weerakoon_fernando.WeerakoonFernandoRootFindingMethod;
import fractalzoomer.functions.root_finding_methods.whittaker.WhittakerRootFindingMethod;
import fractalzoomer.functions.root_finding_methods.whittaker_double_convex.WhittakerDoubleConvexRootFindingMethod;
import fractalzoomer.main.Constants;
import fractalzoomer.main.MainWindow;
import fractalzoomer.main.app_settings.OrbitTrapSettings;
import fractalzoomer.main.app_settings.Settings;
import fractalzoomer.main.app_settings.StatisticsSettings;
import org.apfloat.Apfloat;

import javax.swing.*;
import java.util.ArrayList;
import java.util.function.Function;

import static fractalzoomer.main.Constants.*;

/**
 *
 * @author hrkalona2
 */
public class Nova extends ExtendedConvergentType {

    private Complex z_exponent;
    private Complex relaxation;
    private int nova_method;
    private Complex newtonHinesK;
    private boolean supportsPerturbation;

    public Nova() {
        super();
    }

    public Nova(double xCenter, double yCenter, double size, int max_iterations, int bailout_test_algorithm, double bailout, String bailout_test_user_formula, String bailout_test_user_formula2, int bailout_test_comparison, double n_norm, int out_coloring_algorithm, int user_out_coloring_algorithm, String outcoloring_formula, String[] user_outcoloring_conditions, String[] user_outcoloring_condition_formula, int in_coloring_algorithm, int user_in_coloring_algorithm, String incoloring_formula, String[] user_incoloring_conditions, String[] user_incoloring_condition_formula, boolean smoothing, int plane_type, double[] rotation_vals, double[] rotation_center, boolean perturbation, double[] perturbation_vals, boolean variable_perturbation, int user_perturbation_algorithm, String[] user_perturbation_conditions, String[] user_perturbation_condition_formula, String perturbation_user_formula, boolean init_value, double[] initial_vals, boolean variable_init_value, int user_initial_value_algorithm, String[] user_initial_value_conditions, String[] user_initial_value_condition_formula, String initial_value_user_formula, double[] z_exponent, double[] relaxation, int nova_method, String user_plane, int user_plane_algorithm, String[] user_plane_conditions, String[] user_plane_condition_formula, double[] plane_transform_center, double plane_transform_angle, double plane_transform_radius, double[] plane_transform_scales, double[] plane_transform_wavelength, int waveType, double plane_transform_angle2, int plane_transform_sides, double plane_transform_amount, ArrayList<Double> inflections_re, ArrayList<Double> inflections_im, double inflectionsPower, int converging_smooth_algorithm, OrbitTrapSettings ots, StatisticsSettings sts, double[] newton_hines_k, boolean defaultNovaInitialValue) {

        super(xCenter, yCenter, size, max_iterations, bailout_test_algorithm, bailout, bailout_test_user_formula, bailout_test_user_formula2, bailout_test_comparison, n_norm, false, plane_type, rotation_vals, rotation_center, user_plane, user_plane_algorithm, user_plane_conditions, user_plane_condition_formula, plane_transform_center, plane_transform_angle, plane_transform_radius, plane_transform_scales, plane_transform_wavelength, waveType, plane_transform_angle2, plane_transform_sides, plane_transform_amount, inflections_re, inflections_im, inflectionsPower, ots);
        
        if(nova_method == MainWindow.NOVA_TRAUB_OSTROWSKI) {
            setConvergentBailout(1E-8);
        }

        this.nova_method = nova_method;

        this.z_exponent = new Complex(z_exponent[0], z_exponent[1]);

        this.relaxation = new Complex(relaxation[0], relaxation[1]);

        supportsPerturbation = false;
        if(nova_method == MainWindow.NOVA_NEWTON && z_exponent[0] == 3 &&  z_exponent[1] == 0 && relaxation[0] == 1 && relaxation[1] == 0 && defaultNovaInitialValue) {
            supportsPerturbation = true;
        }

        newtonHinesK = new Complex(newton_hines_k[0], newton_hines_k[1]);

        defaultInitVal = new InitialValue(1, 0);

        setPertubationOption(perturbation, perturbation_vals, variable_perturbation, user_perturbation_algorithm, perturbation_user_formula, user_perturbation_conditions, user_perturbation_condition_formula, plane_transform_center);

        if (init_value) {
            if (variable_init_value) {
                if (user_initial_value_algorithm == 0) {
                    init_val = new VariableInitialValue(initial_value_user_formula, xCenter, yCenter, size, max_iterations, plane_transform_center, globalVars);
                } else {
                    init_val = new VariableConditionalInitialValue(user_initial_value_conditions, user_initial_value_condition_formula, xCenter, yCenter, size, max_iterations, plane_transform_center, globalVars);
                }
            } else {
                init_val = new InitialValue(initial_vals[0], initial_vals[1]);
            }
        } else {
            if(defaultNovaInitialValue) {
                init_val = defaultInitVal;
            }
            else {
                init_val = new DefaultInitialValue();
            }
        }

        OutColoringAlgorithmFactory(out_coloring_algorithm, smoothing, converging_smooth_algorithm, user_out_coloring_algorithm, outcoloring_formula, user_outcoloring_conditions, user_outcoloring_condition_formula, plane_transform_center);

        //override some algorithms
        /*switch (out_coloring_algorithm) {
            case MainWindow.COLOR_DECOMPOSITION:
                out_color_algorithm = new ColorDecomposition();
                break;
            case MainWindow.ESCAPE_TIME_COLOR_DECOMPOSITION:
                out_color_algorithm = new EscapeTimeColorDecomposition();
                break;
        }*/

        InColoringAlgorithmFactory(in_coloring_algorithm, user_in_coloring_algorithm, incoloring_formula, user_incoloring_conditions, user_incoloring_condition_formula, plane_transform_center);

        if (sts.statistic) {
            StatisticFactory(sts, plane_transform_center);
        }
    }

    public Nova(double xCenter, double yCenter, double size, int max_iterations, int bailout_test_algorithm, double bailout, String bailout_test_user_formula, String bailout_test_user_formula2, int bailout_test_comparison, double n_norm, int out_coloring_algorithm, int user_out_coloring_algorithm, String outcoloring_formula, String[] user_outcoloring_conditions, String[] user_outcoloring_condition_formula, int in_coloring_algorithm, int user_in_coloring_algorithm, String incoloring_formula, String[] user_incoloring_conditions, String[] user_incoloring_condition_formula, boolean smoothing, int plane_type, boolean apply_plane_on_julia, boolean apply_plane_on_julia_seed, double[] rotation_vals, double[] rotation_center, double[] z_exponent, double[] relaxation, int nova_method, String user_plane, int user_plane_algorithm, String[] user_plane_conditions, String[] user_plane_condition_formula, double[] plane_transform_center, double plane_transform_angle, double plane_transform_radius, double[] plane_transform_scales, double[] plane_transform_wavelength, int waveType, double plane_transform_angle2, int plane_transform_sides, double plane_transform_amount, ArrayList<Double> inflections_re, ArrayList<Double> inflections_im, double inflectionsPower, int converging_smooth_algorithm, OrbitTrapSettings ots, StatisticsSettings sts, double[] newton_hines_k, boolean defaultNovaInitialValue, double xJuliaCenter, double yJuliaCenter) {

        super(xCenter, yCenter, size, max_iterations, bailout_test_algorithm, bailout, bailout_test_user_formula, bailout_test_user_formula2, bailout_test_comparison, n_norm, false, plane_type, apply_plane_on_julia, apply_plane_on_julia_seed, rotation_vals, rotation_center, user_plane, user_plane_algorithm, user_plane_conditions, user_plane_condition_formula, plane_transform_center, plane_transform_angle, plane_transform_radius, plane_transform_scales, plane_transform_wavelength, waveType, plane_transform_angle2, plane_transform_sides, plane_transform_amount, inflections_re, inflections_im, inflectionsPower, ots, xJuliaCenter, yJuliaCenter);

        //Todo: Check which other methods need this
        if(nova_method == MainWindow.NOVA_TRAUB_OSTROWSKI) {
            setConvergentBailout(1E-8);
        }

        this.nova_method = nova_method;

        this.z_exponent = new Complex(z_exponent[0], z_exponent[1]);

        this.relaxation = new Complex(relaxation[0], relaxation[1]);

        defaultInitVal = new InitialValue(1, 0);

        supportsPerturbation = false;
        if(nova_method == MainWindow.NOVA_NEWTON && z_exponent[0] == 3 &&  z_exponent[1] == 0 && relaxation[0] == 1 && relaxation[1] == 0 && defaultNovaInitialValue) {
            supportsPerturbation = true;
        }

        newtonHinesK = new Complex(newton_hines_k[0], newton_hines_k[1]);

        switch (out_coloring_algorithm) {

            case MainWindow.BINARY_DECOMPOSITION:
            case MainWindow.BINARY_DECOMPOSITION2:
            case MainWindow.BANDED:
                if (nova_method == MainWindow.NOVA_HALLEY || nova_method == MainWindow.NOVA_HOUSEHOLDER || nova_method == MainWindow.NOVA_WHITTAKER || nova_method == MainWindow.NOVA_WHITTAKER_DOUBLE_CONVEX || nova_method == MainWindow.NOVA_SUPER_HALLEY) {
                    setConvergentBailout(1E-4);
                } else if (nova_method == MainWindow.NOVA_NEWTON || nova_method == MainWindow.NOVA_STEFFENSEN) {
                    setConvergentBailout(1E-9);
                } else if (nova_method == MainWindow.NOVA_SCHRODER) {
                    setConvergentBailout(1E-6);
                }
                break;
            case MainWindow.USER_OUTCOLORING_ALGORITHM:
                setConvergentBailout(1E-7);
                break;

        }

        OutColoringAlgorithmFactory(out_coloring_algorithm, smoothing, converging_smooth_algorithm, user_out_coloring_algorithm, outcoloring_formula, user_outcoloring_conditions, user_outcoloring_condition_formula, plane_transform_center);

        InColoringAlgorithmFactory(in_coloring_algorithm, user_in_coloring_algorithm, incoloring_formula, user_incoloring_conditions, user_incoloring_condition_formula, plane_transform_center);

        if (sts.statistic) {
            StatisticFactory(sts, plane_transform_center);
        }

        pertur_val = new DefaultPerturbation();

        if(defaultNovaInitialValue) {
            init_val = defaultInitVal;
        }
        else {
            init_val = new DefaultInitialValue();
        }
    }

    //orbit
    public Nova(double xCenter, double yCenter, double size, int max_iterations, ArrayList<Complex> complex_orbit, int plane_type, double[] rotation_vals, double[] rotation_center, boolean perturbation, double[] perturbation_vals, boolean variable_perturbation, int user_perturbation_algorithm, String[] user_perturbation_conditions, String[] user_perturbation_condition_formula, String perturbation_user_formula, boolean init_value, double[] initial_vals, boolean variable_init_value, int user_initial_value_algorithm, String[] user_initial_value_conditions, String[] user_initial_value_condition_formula, String initial_value_user_formula, double[] z_exponent, double[] relaxation, int nova_method, String user_plane, int user_plane_algorithm, String[] user_plane_conditions, String[] user_plane_condition_formula, double[] plane_transform_center, double plane_transform_angle, double plane_transform_radius, double[] plane_transform_scales, double[] plane_transform_wavelength, int waveType, double plane_transform_angle2, int plane_transform_sides, double plane_transform_amount, ArrayList<Double> inflections_re, ArrayList<Double> inflections_im, double inflectionsPower, double[] newton_hines_k, boolean defaultNovaInitialValue) {

        super(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, rotation_center, user_plane, user_plane_algorithm, user_plane_conditions, user_plane_condition_formula, plane_transform_center, plane_transform_angle, plane_transform_radius, plane_transform_scales, plane_transform_wavelength, waveType, plane_transform_angle2, plane_transform_sides, plane_transform_amount, inflections_re, inflections_im, inflectionsPower);

        this.nova_method = nova_method;

        this.z_exponent = new Complex(z_exponent[0], z_exponent[1]);

        this.relaxation = new Complex(relaxation[0], relaxation[1]);

        newtonHinesK = new Complex(newton_hines_k[0], newton_hines_k[1]);

        defaultInitVal = new InitialValue(1, 0);

        supportsPerturbation = false;
        if(nova_method == MainWindow.NOVA_NEWTON && z_exponent[0] == 3 &&  z_exponent[1] == 0 && relaxation[0] == 1 && relaxation[1] == 0 && defaultNovaInitialValue) {
            supportsPerturbation = true;
        }

        setPertubationOption(perturbation, perturbation_vals, variable_perturbation, user_perturbation_algorithm, perturbation_user_formula, user_perturbation_conditions, user_perturbation_condition_formula, plane_transform_center);

        if (init_value) {
            if (variable_init_value) {
                if (user_initial_value_algorithm == 0) {
                    init_val = new VariableInitialValue(initial_value_user_formula, xCenter, yCenter, size, max_iterations, plane_transform_center, globalVars);
                } else {
                    init_val = new VariableConditionalInitialValue(user_initial_value_conditions, user_initial_value_condition_formula, xCenter, yCenter, size, max_iterations, plane_transform_center, globalVars);
                }
            } else {
                init_val = new InitialValue(initial_vals[0], initial_vals[1]);
            }
        } else {
            if(defaultNovaInitialValue) {
                init_val = defaultInitVal;
            }
            else {
                init_val = new DefaultInitialValue();
            }
        }

    }

    public Nova(double xCenter, double yCenter, double size, int max_iterations, ArrayList<Complex> complex_orbit, int plane_type, boolean apply_plane_on_julia, boolean apply_plane_on_julia_seed, double[] rotation_vals, double[] rotation_center, double[] z_exponent, double[] relaxation, int nova_method, String user_plane, int user_plane_algorithm, String[] user_plane_conditions, String[] user_plane_condition_formula, double[] plane_transform_center, double plane_transform_angle, double plane_transform_radius, double[] plane_transform_scales, double[] plane_transform_wavelength, int waveType, double plane_transform_angle2, int plane_transform_sides, double plane_transform_amount, ArrayList<Double> inflections_re, ArrayList<Double> inflections_im, double inflectionsPower, double[] newton_hines_k, boolean defaultNovaInitialValue, double xJuliaCenter, double yJuliaCenter) {

        super(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, apply_plane_on_julia, apply_plane_on_julia_seed, rotation_vals, rotation_center, user_plane, user_plane_algorithm, user_plane_conditions, user_plane_condition_formula, plane_transform_center, plane_transform_angle, plane_transform_radius, plane_transform_scales, plane_transform_wavelength, waveType, plane_transform_angle2, plane_transform_sides, plane_transform_amount, inflections_re, inflections_im, inflectionsPower, xJuliaCenter, yJuliaCenter);

        this.nova_method = nova_method;

        this.z_exponent = new Complex(z_exponent[0], z_exponent[1]);

        this.relaxation = new Complex(relaxation[0], relaxation[1]);

        defaultInitVal = new InitialValue(1, 0);

        supportsPerturbation = false;
        if(nova_method == MainWindow.NOVA_NEWTON && z_exponent[0] == 3 &&  z_exponent[1] == 0 && relaxation[0] == 1 && relaxation[1] == 0 && defaultNovaInitialValue) {
            supportsPerturbation = true;
        }

        newtonHinesK = new Complex(newton_hines_k[0], newton_hines_k[1]);

        pertur_val = new DefaultPerturbation();
        if(defaultNovaInitialValue) {
            init_val = defaultInitVal;
        }
        else {
            init_val = new DefaultInitialValue();
        }

    }

    private Complex[] combinedDFZ(Complex z, Complex fz, Complex dfz) {
        Complex temp = null, combined_dfz, combined_dfz2 = null;

        if(nova_method == MainWindow.NOVA_MIDPOINT) {
            temp = MidpointRootFindingMethod.getDerivativeArgument(z, fz, dfz);
        }
        else if (nova_method == MainWindow.NOVA_STIRLING){
            temp = StirlingRootFindingMethod.getDerivativeArgument(z, fz);
        }
        else if (nova_method == MainWindow.NOVA_JARATT){
            temp = JarattRootFindingMethod.getDerivativeArgument(z, fz, dfz);
        }
        else if (nova_method == MainWindow.NOVA_JARATT2){
            temp = Jaratt2RootFindingMethod.getDerivativeArgument(z, fz, dfz);
        }
        else if(nova_method == MainWindow.NOVA_WEERAKOON_FERNANDO) {
            temp = WeerakoonFernandoRootFindingMethod.getDerivativeArgument(z, fz, dfz);
        }
        else if(nova_method == MainWindow.NOVA_CONTRA_HARMONIC_NEWTON) {
            temp = ContraHarmonicNewtonRootFindingMethod.getDerivativeArgument(z, fz, dfz);
        }
        else if(nova_method == MainWindow.NOVA_CHUN_KIM) {
            temp = ChunKimRootFindingMethod.getDerivativeArgument(z, fz, dfz);
        }
        else if(nova_method == MainWindow.NOVA_HOMEIER1) {
            temp = Homeier1RootFindingMethod.getDerivativeArgument(z, fz, dfz);
        }
        else if(nova_method == MainWindow.NOVA_HOMEIER2) {
            temp = Homeier2RootFindingMethod.getDerivativeArgument(z, fz, dfz);
        }
        else if(nova_method == MainWindow.NOVA_KIM_CHUN) {
            temp = KimChunRootFindingMethod.getDerivativeArgument(z, fz, dfz);
        }
        else if(nova_method == MainWindow.NOVA_RAFIULLAH1) {
            temp = Rafiullah1RootFindingMethod.getDerivativeArgument(z, fz, dfz);
        }
        else if(nova_method == MainWindow.NOVA_CHANGBUM_CHUN3) {
            temp = ChangBumChun3RootFindingMethod.getFunctionAndDerivativeArgument(z, fz, dfz);
        }
        else if(nova_method == MainWindow.NOVA_EZZATI_SALEKI1) {
            temp = EzzatiSaleki1RootFindingMethod.getFunctionAndDerivativeArgument(z, fz, dfz);
        }
        else if(nova_method == MainWindow.NOVA_FENG) {
            temp = FengRootFindingMethod.getFunctionAndDerivativeArgument(z, fz, dfz);
        }
        else if(nova_method == MainWindow.NOVA_KING1) {
            temp = King1RootFindingMethod.getFunctionAndDerivativeArgument(z, fz, dfz);
        }
        else if(nova_method == MainWindow.NOVA_NOOR_GUPTA) {
            temp = NoorGuptaRootFindingMethod.getFunctionAndDerivativeArgument(z, fz, dfz);
        }
        else if(nova_method == NOVA_HARMONIC_SIMPSON_NEWTON) {
            temp = HarmonicSimpsonNewtonRootFindingMethod.getDerivativeArgument(z, fz, dfz);
        }
        else if(nova_method == NOVA_NEDZHIBOV) {
            temp = NedzhibovRootFindingMethod.getDerivativeArgument(z, fz, dfz);
        }
        else if(nova_method == NOVA_SIMPSON_NEWTON) {
            temp = SimpsonNewtonRootFindingMethod.getDerivativeArgument(z, fz, dfz);
        }

        if (z_exponent.getIm() == 0) {
            if (z_exponent.getRe() == 2) {
                combined_dfz = temp.times2();
            } else if (z_exponent.getRe() == 3) {
                combined_dfz = temp.square().times_mutable(3);
            } else if (z_exponent.getRe() == 4) {
                combined_dfz = temp.cube().times4_mutable();
            } else if (z_exponent.getRe() == 5) {
                combined_dfz = temp.fourth().times_mutable(5);
            } else if (z_exponent.getRe() == 6) {
                combined_dfz = temp.fifth().times_mutable(6);
            } else if (z_exponent.getRe() == 7) {
                combined_dfz = temp.sixth().times_mutable(7);
            } else if (z_exponent.getRe() == 8) {
                combined_dfz = temp.seventh().times_mutable(8);
            } else if (z_exponent.getRe() == 9) {
                combined_dfz = temp.eighth().times_mutable(9);
            } else if (z_exponent.getRe() == 10) {
                combined_dfz = temp.ninth().times_mutable(10);
            } else {
                combined_dfz = temp.pow(z_exponent.getRe() - 1).times_mutable(z_exponent.getRe());
            }
        } else {
            combined_dfz = temp.pow(z_exponent.sub(1)).times_mutable(z_exponent);
        }

        if(nova_method == NOVA_HARMONIC_SIMPSON_NEWTON || nova_method == NOVA_NEDZHIBOV || nova_method == NOVA_SIMPSON_NEWTON) {
            Complex temp2 = z.plus(temp).times_mutable(0.5);

            if (z_exponent.getIm() == 0) {
                if (z_exponent.getRe() == 2) {
                    combined_dfz2 = temp2.times2_mutable();
                } else if (z_exponent.getRe() == 3) {
                    combined_dfz2 = temp2.square_mutable().times_mutable(3);
                } else if (z_exponent.getRe() == 4) {
                    combined_dfz2 = temp2.cube_mutable().times4_mutable();
                } else if (z_exponent.getRe() == 5) {
                    combined_dfz2 = temp2.fourth_mutable().times_mutable(5);
                } else if (z_exponent.getRe() == 6) {
                    combined_dfz2 = temp2.fifth_mutable().times_mutable(6);
                } else if (z_exponent.getRe() == 7) {
                    combined_dfz2 = temp2.sixth_mutable().times_mutable(7);
                } else if (z_exponent.getRe() == 8) {
                    combined_dfz2 = temp2.seventh_mutable().times_mutable(8);
                } else if (z_exponent.getRe() == 9) {
                    combined_dfz2 = temp2.eighth_mutable().times_mutable(9);
                } else if (z_exponent.getRe() == 10) {
                    combined_dfz2 = temp2.ninth_mutable().times_mutable(10);
                } else {
                    combined_dfz2 = temp2.pow_mutable(z_exponent.getRe() - 1).times_mutable(z_exponent.getRe());
                }
            } else {
                combined_dfz2 = temp2.pow(z_exponent.sub(1)).times_mutable(z_exponent);
            }
        }

        return new Complex[] {combined_dfz, combined_dfz2};
    }

    private Complex combinedFFZ(Complex z, Complex fz, Complex dfz) {

        Complex temp = null, ffz;

        if(nova_method == MainWindow.NOVA_STEFFENSEN) {
            temp = SteffensenRootFindingMethod.getFunctionArgument(z, fz);
        }
        else if(nova_method == MainWindow.NOVA_TRAUB_OSTROWSKI) {
            temp = TraubOstrowskiRootFindingMethod.getFunctionArgument(z, fz, dfz);
        }
        else if(nova_method == MainWindow.NOVA_THIRD_ORDER_NEWTON) {
            temp = ThirdOrderNewtonRootFindingMethod.getFunctionArgument(z, fz, dfz);
        }
        else if(nova_method == MainWindow.NOVA_CHUN_HAM) {
            temp = ChunHamRootFindingMethod.getFunctionArgument(z, fz, dfz);
        }
        else if(nova_method == MainWindow.NOVA_EZZATI_SALEKI2) {
            temp = EzzatiSaleki2RootFindingMethod.getFunctionArgument(z, fz, dfz);
        }
        else if(nova_method == MainWindow.NOVA_CHANGBUM_CHUN1) {
            temp = ChangBumChun1RootFindingMethod.getFunctionArgument(z, fz, dfz);
        }
        else if(nova_method == MainWindow.NOVA_CHANGBUM_CHUN2) {
            temp = ChangBumChun2RootFindingMethod.getFunctionArgument(z, fz, dfz);
        }
        else if(nova_method == MainWindow.NOVA_KING3) {
            temp = King3RootFindingMethod.getFunctionArgument(z, fz, dfz);
        }
        else if(nova_method == MainWindow.NOVA_KOU_LI_WANG1) {
            temp = KouLiWang1RootFindingMethod.getFunctionArgument(z, fz, dfz);
        }
        else if(nova_method == MainWindow.NOVA_MAHESHWERI) {
            temp = MaheshweriRootFindingMethod.getFunctionArgument(z, fz, dfz);
        }
        else if(nova_method == MainWindow.NOVA_CHANGBUM_CHUN3) {
            temp = ChangBumChun3RootFindingMethod.getFunctionAndDerivativeArgument(z, fz, dfz);
        }
        else if(nova_method == MainWindow.NOVA_EZZATI_SALEKI1) {
            temp = EzzatiSaleki1RootFindingMethod.getFunctionAndDerivativeArgument(z, fz, dfz);
        }
        else if(nova_method == MainWindow.NOVA_FENG) {
            temp = FengRootFindingMethod.getFunctionAndDerivativeArgument(z, fz, dfz);
        }
        else if(nova_method == MainWindow.NOVA_KING1) {
            temp = King1RootFindingMethod.getFunctionAndDerivativeArgument(z, fz, dfz);
        }
        else if(nova_method == MainWindow.NOVA_NOOR_GUPTA) {
            temp = NoorGuptaRootFindingMethod.getFunctionAndDerivativeArgument(z, fz, dfz);
        }

        if (z_exponent.getIm() == 0) {
            if (z_exponent.getRe() == 2) {
                ffz = temp.square_mutable().sub_mutable(1);
            } else if (z_exponent.getRe() == 3) {
                ffz = temp.cube_mutable().sub_mutable(1);
            } else if (z_exponent.getRe() == 4) {
                ffz = temp.fourth_mutable().sub_mutable(1);
            } else if (z_exponent.getRe() == 5) {
                ffz = temp.fifth_mutable().sub_mutable(1);
            } else if (z_exponent.getRe() == 6) {
                ffz = temp.sixth_mutable().sub_mutable(1);
            } else if (z_exponent.getRe() == 7) {
                ffz = temp.seventh_mutable().sub_mutable(1);
            } else if (z_exponent.getRe() == 8) {
                ffz = temp.eighth_mutable().sub_mutable(1);
            } else if (z_exponent.getRe() == 9) {
                ffz = temp.ninth_mutable().sub_mutable(1);
            } else if (z_exponent.getRe() == 10) {
                ffz = temp.tenth_mutable().sub_mutable(1);
            } else {
                ffz = temp.pow_mutable(z_exponent.getRe()).sub_mutable(1);
            }
        } else {
            ffz = temp.pow(z_exponent).sub_mutable(1);
        }

        return ffz;
    }

    private Complex combinedDDFZ(Complex z, Complex fz, Complex dfz) {

        Complex temp = null, combined_ddfz;

        if(nova_method == MainWindow.NOVA_RAFIS_RAFIULLAH) {
            temp = RafisRafiullahRootFindingMethod.getSecondDerivativeArgument(z, fz, dfz);
        }

        if (z_exponent.getIm() == 0) {
            if (z_exponent.getRe() == 2) {
                combined_ddfz = new Complex(2, 0);
            } else if (z_exponent.getRe() == 3) {
                combined_ddfz = temp.times_mutable(6);
            } else if (z_exponent.getRe() == 4) {
                combined_ddfz = temp.square_mutable().times_mutable(12);
            } else if (z_exponent.getRe() == 5) {
                combined_ddfz = temp.cube_mutable().times_mutable(20);
            } else if (z_exponent.getRe() == 6) {
                combined_ddfz = temp.fourth_mutable().times_mutable(30);
            } else if (z_exponent.getRe() == 7) {
                combined_ddfz = temp.fifth_mutable().times_mutable(42);
            } else if (z_exponent.getRe() == 8) {
                combined_ddfz = temp.sixth_mutable().times_mutable(56);
            } else if (z_exponent.getRe() == 9) {
                combined_ddfz = temp.seventh_mutable().times_mutable(72);
            } else if (z_exponent.getRe() == 10) {
                combined_ddfz = temp.eighth_mutable().times_mutable(90);
            } else {
                combined_ddfz = temp.pow_mutable(z_exponent.getRe() - 2).times_mutable(z_exponent.getRe()).times_mutable(z_exponent.getRe() - 1);
            }
        } else {
            combined_ddfz = temp.pow(z_exponent.sub(2)).times_mutable(z_exponent).times_mutable(z_exponent.sub(1));
        }

        return combined_ddfz;
    }

    @Override
    public void function(Complex[] complex) {

        Complex fz = null;
        Complex dfz = null;
        Complex ddfz = null;
        Complex dddfz = null;
        Complex ffz = null;
        Complex combined_dfz = null;
        Complex combined_ddfz = null;
        Complex combined_dfz2 = null;

        if (z_exponent.getIm() == 0) {
            if (z_exponent.getRe() == 2) {
                fz = complex[0].square().sub_mutable(1);
            } else if (z_exponent.getRe() == 3) {
                fz = complex[0].cube().sub_mutable(1);
            } else if (z_exponent.getRe() == 4) {
                fz = complex[0].fourth().sub_mutable(1);
            } else if (z_exponent.getRe() == 5) {
                fz = complex[0].fifth().sub_mutable(1);
            } else if (z_exponent.getRe() == 6) {
                fz = complex[0].sixth().sub_mutable(1);
            } else if (z_exponent.getRe() == 7) {
                fz = complex[0].seventh().sub_mutable(1);
            } else if (z_exponent.getRe() == 8) {
                fz = complex[0].eighth().sub_mutable(1);
            } else if (z_exponent.getRe() == 9) {
                fz = complex[0].ninth().sub_mutable(1);
            } else if (z_exponent.getRe() == 10) {
                fz = complex[0].tenth().sub_mutable(1);
            } else {
                fz = complex[0].pow(z_exponent.getRe()).sub_mutable(1);
            }
        } else {
            fz = complex[0].pow(z_exponent).sub_mutable(1);
        }

        if (!Settings.isOneFunctionsNovaFormula(nova_method) && nova_method != MainWindow.NOVA_STIRLING) {
            if (z_exponent.getIm() == 0) {
                if (z_exponent.getRe() == 2) {
                    dfz = complex[0].times2();
                } else if (z_exponent.getRe() == 3) {
                    dfz = complex[0].square().times_mutable(3);
                } else if (z_exponent.getRe() == 4) {
                    dfz = complex[0].cube().times4_mutable();
                } else if (z_exponent.getRe() == 5) {
                    dfz = complex[0].fourth().times_mutable(5);
                } else if (z_exponent.getRe() == 6) {
                    dfz = complex[0].fifth().times_mutable(6);
                } else if (z_exponent.getRe() == 7) {
                    dfz = complex[0].sixth().times_mutable(7);
                } else if (z_exponent.getRe() == 8) {
                    dfz = complex[0].seventh().times_mutable(8);
                } else if (z_exponent.getRe() == 9) {
                    dfz = complex[0].eighth().times_mutable(9);
                } else if (z_exponent.getRe() == 10) {
                    dfz = complex[0].ninth().times_mutable(10);
                } else {
                    dfz = complex[0].pow(z_exponent.getRe() - 1).times_mutable(z_exponent.getRe());
                }
            } else {
                dfz = complex[0].pow(z_exponent.sub(1)).times_mutable(z_exponent);
            }
        }

        if (Settings.isThreeFunctionsNovaFormula(nova_method) || Settings.isFourFunctionsNovaFormula(nova_method)) {
            if (z_exponent.getIm() == 0) {
                if (z_exponent.getRe() == 2) {
                    ddfz = new Complex(2, 0);
                } else if (z_exponent.getRe() == 3) {
                    ddfz = complex[0].times(6);
                } else if (z_exponent.getRe() == 4) {
                    ddfz = complex[0].square().times_mutable(12);
                } else if (z_exponent.getRe() == 5) {
                    ddfz = complex[0].cube().times_mutable(20);
                } else if (z_exponent.getRe() == 6) {
                    ddfz = complex[0].fourth().times_mutable(30);
                } else if (z_exponent.getRe() == 7) {
                    ddfz = complex[0].fifth().times_mutable(42);
                } else if (z_exponent.getRe() == 8) {
                    ddfz = complex[0].sixth().times_mutable(56);
                } else if (z_exponent.getRe() == 9) {
                    ddfz = complex[0].seventh().times_mutable(72);
                } else if (z_exponent.getRe() == 10) {
                    ddfz = complex[0].eighth().times_mutable(90);
                } else {
                    ddfz = complex[0].pow(z_exponent.getRe() - 2).times_mutable(z_exponent.getRe() * (z_exponent.getRe() - 1));
                }
            } else {
                ddfz = complex[0].pow(z_exponent.sub(2)).times_mutable(z_exponent.times(z_exponent.sub(1)));
            }
        }

        if (Settings.isFourFunctionsNovaFormula(nova_method)) {
            if (z_exponent.getIm() == 0) {
                if (z_exponent.getRe() == 2) {
                    dddfz = new Complex();
                } else if (z_exponent.getRe() == 3) {
                    dddfz = new Complex(6, 0);
                } else if (z_exponent.getRe() == 4) {
                    dddfz = complex[0].times(24);
                } else if (z_exponent.getRe() == 5) {
                    dddfz = complex[0].square().times_mutable(60);
                } else if (z_exponent.getRe() == 6) {
                    dddfz = complex[0].cube().times_mutable(120);
                } else if (z_exponent.getRe() == 7) {
                    dddfz = complex[0].fourth().times_mutable(210);
                } else if (z_exponent.getRe() == 8) {
                    dddfz = complex[0].fifth().times_mutable(336);
                } else if (z_exponent.getRe() == 9) {
                    dddfz = complex[0].sixth().times_mutable(504);
                } else if (z_exponent.getRe() == 10) {
                    dddfz = complex[0].seventh().times_mutable(720);
                } else {
                    dddfz = complex[0].pow(z_exponent.getRe() - 3).times_mutable(z_exponent.getRe() * (z_exponent.getRe() - 1) * (z_exponent.getRe() - 2));
                }
            } else {
                dddfz = complex[0].pow(z_exponent.sub(3)).times_mutable(z_exponent.times(z_exponent.sub(1)).times(z_exponent.sub(2)));
            }
        }

        if (Settings.hasNovaCombinedFFZ(nova_method)) {
            ffz = combinedFFZ(complex[0], fz, dfz);
        }

        if (Settings.hasNovaCombinedDFZ(nova_method)) {
            Complex[] res = combinedDFZ(complex[0], fz, dfz);
            combined_dfz = res[0];
            combined_dfz2 = res[1];
        }
        else if (Settings.hasNovaCombinedDDFZ(nova_method)) {
            combined_ddfz = combinedDDFZ(complex[0], fz, dfz);
        }

        switch (nova_method) {

            case MainWindow.NOVA_NEWTON:
                NewtonRootFindingMethod.newtonMethod(complex[0], fz, dfz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_HALLEY:
                HalleyRootFindingMethod.halleyMethod(complex[0], fz, dfz, ddfz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_SCHRODER:
                SchroderRootFindingMethod.schroderMethod(complex[0], fz, dfz, ddfz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_HOUSEHOLDER:
                HouseholderRootFindingMethod.householderMethod(complex[0], fz, dfz, ddfz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_SECANT:
                SecantRootFindingMethod.secantMethod(complex[0], fz, complex[2], complex[3], relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_STEFFENSEN:
                SteffensenRootFindingMethod.steffensenMethod(complex[0], fz, ffz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_MULLER:
                MullerRootFindingMethod.mullerMethod(complex[0], complex[4], complex[2], fz, complex[5], complex[3], relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_PARHALLEY:
                ParhalleyRootFindingMethod.parhalleyMethod(complex[0], fz, dfz, ddfz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_LAGUERRE:
                LaguerreRootFindingMethod.laguerreMethod(complex[0], fz, dfz, ddfz, z_exponent, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_NEWTON_HINES:
                NewtonHinesRootFindingMethod.newtonHinesMethod(complex[0], fz, dfz, newtonHinesK, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_WHITTAKER:
                WhittakerRootFindingMethod.whittakerMethod(complex[0], fz, dfz, ddfz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_WHITTAKER_DOUBLE_CONVEX:
                WhittakerDoubleConvexRootFindingMethod.whittakerDoubleConvexMethod(complex[0], fz, dfz, ddfz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_SUPER_HALLEY:
                SuperHalleyRootFindingMethod.superHalleyMethod(complex[0], fz, dfz, ddfz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_MIDPOINT:
                MidpointRootFindingMethod.midpointMethod(complex[0], fz, combined_dfz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_TRAUB_OSTROWSKI:
                TraubOstrowskiRootFindingMethod.traubOstrowskiMethod(complex[0], fz, dfz, ffz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_STIRLING:
                StirlingRootFindingMethod.stirlingMethod(complex[0], fz, combined_dfz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_JARATT:
                JarattRootFindingMethod.jarattMethod(complex[0], fz, dfz, combined_dfz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_JARATT2:
                Jaratt2RootFindingMethod.jaratt2Method(complex[0], fz, dfz, combined_dfz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_WEERAKOON_FERNANDO:
                WeerakoonFernandoRootFindingMethod.weerakoonFernandoMethod(complex[0], fz, dfz, combined_dfz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_THIRD_ORDER_NEWTON:
                ThirdOrderNewtonRootFindingMethod.thirdOrderNewtonMethod(complex[0], fz, dfz, ffz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_ABBASBANDY:
                AbbasbandyRootFindingMethod.abbasbandyMethod(complex[0], fz, dfz, ddfz, dddfz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_HOUSEHOLDER3:
                Householder3RootFindingMethod.householder3Method(complex[0], fz, dfz, ddfz, dddfz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_CONTRA_HARMONIC_NEWTON:
                ContraHarmonicNewtonRootFindingMethod.chnMethod(complex[0], fz, dfz, combined_dfz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_CHUN_HAM:
                ChunHamRootFindingMethod.chunHamMethod(complex[0], fz, dfz, ffz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_CHUN_KIM:
                ChunKimRootFindingMethod.chunKimMethod(complex[0], fz, dfz, combined_dfz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_EULER_CHEBYSHEV:
                EulerChebyshevRootFindingMethod.eulerChebyshevMethod(complex[0], fz, dfz, ddfz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_EZZATI_SALEKI2:
                EzzatiSaleki2RootFindingMethod.ezzatiSaleki2Method(complex[0], fz, dfz, ffz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_HOMEIER1:
                Homeier1RootFindingMethod.homeier1Method(complex[0], fz, combined_dfz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_ABBASBANDY2:
                Abbasbandy2RootFindingMethod.abbasbandy2Method(complex[0], fz, dfz, ddfz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_ABBASBANDY3:
                Abbasbandy3RootFindingMethod.abbasbandy3Method(complex[0], fz, dfz, ddfz, dddfz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_POPOVSKI1:
                Popovski1RootFindingMethod.popovski1Method(complex[0], fz, dfz, ddfz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_CHANGBUM_CHUN1:
                ChangBumChun1RootFindingMethod.changbumChun1Method(complex[0], fz, dfz, ffz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_CHANGBUM_CHUN2:
                ChangBumChun2RootFindingMethod.changbumChun2Method(complex[0], fz, dfz, ffz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_KING3:
                King3RootFindingMethod.king3Method(complex[0], fz, dfz, ffz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_HOMEIER2:
                Homeier2RootFindingMethod.homeier2Method(complex[0], fz, dfz, combined_dfz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_KIM_CHUN:
                KimChunRootFindingMethod.kimChunMethod(complex[0], fz, dfz, combined_dfz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_KOU_LI_WANG1:
                KouLiWang1RootFindingMethod.kouLiWang1Method(complex[0], fz, dfz, ffz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_MAHESHWERI:
                MaheshweriRootFindingMethod.maheshweriMethod(complex[0], fz, dfz, ffz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_RAFIULLAH1:
                Rafiullah1RootFindingMethod.rafiullah1Method(complex[0], fz, dfz, combined_dfz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_RAFIS_RAFIULLAH:
                RafisRafiullahRootFindingMethod.rafisRafiullahMethod(complex[0], fz, dfz, ddfz, combined_ddfz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_CHANGBUM_CHUN3:
                ChangBumChun3RootFindingMethod.changbumChun3Method(complex[0], fz, dfz, ffz, combined_dfz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_EZZATI_SALEKI1:
                EzzatiSaleki1RootFindingMethod.ezzatiSaleki1Method(complex[0], fz, dfz, ffz, combined_dfz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_FENG:
                FengRootFindingMethod.fengMethod(complex[0], fz, dfz, ffz, combined_dfz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_KING1:
                King1RootFindingMethod.king1Method(complex[0], fz, dfz, ffz, combined_dfz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_NOOR_GUPTA:
                NoorGuptaRootFindingMethod.noorGuptaMethod(complex[0], fz, dfz, ffz, combined_dfz, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_HARMONIC_SIMPSON_NEWTON:
                HarmonicSimpsonNewtonRootFindingMethod.hsnMethod(complex[0], fz, dfz, combined_dfz, combined_dfz2, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_NEDZHIBOV:
                NedzhibovRootFindingMethod.nedzhibovMethod(complex[0], fz, dfz, combined_dfz, combined_dfz2, relaxation).plus_mutable(complex[1]);
                break;
            case MainWindow.NOVA_SIMPSON_NEWTON:
                SimpsonNewtonRootFindingMethod.simpsonNewtonMethod(complex[0], fz, dfz, combined_dfz, combined_dfz2, relaxation).plus_mutable(complex[1]);
                break;

        }

    }

    @Override
    public Complex[] initialize(Complex pixel) {

        Complex[] complex = new Complex[6];

        if(TaskDraw.PERTURBATION_THEORY && supportsPerturbationTheory()) {
            if(!isOrbit && !isDomain) {
                Complex temp = pixel.plus(refPointSmall);
                complex[0] = new Complex(defaultInitVal.getValue(temp));
                complex[1] = new Complex(temp);
            }
            else {
                complex[0] = new Complex(defaultInitVal.getValue(pixel));
                complex[1] = new Complex(pixel);
            }

        }
        else {
            complex[0] = new Complex(pertur_val.getValue(init_val.getValue(pixel)));
            complex[1] = new Complex(pixel);//c
            complex[2] = new Complex();
            complex[3] = new Complex(-1, 0);
            complex[4] = new Complex(1e-10, 0);
            complex[5] = complex[4].pow(z_exponent).sub_mutable(1);
        }

        zold = new Complex();
        zold2 = new Complex();
        start = new Complex(complex[0]);
        c0 = new Complex(complex[1]);

        return complex;

    }

    @Override
    public Complex[] initializeSeed(Complex pixel) {

        Complex[] complex = new Complex[6];

        if(TaskDraw.PERTURBATION_THEORY && supportsPerturbationTheory()) {

            if(!isOrbit && !isDomain) {
                complex[0] = pixel.plus(refPointSmall);
                complex[1] = new Complex(seed);//c
            }
            else {
                complex[0] = new Complex(pertur_val.getValue(init_val.getValue(pixel)));//z
                complex[1] = new Complex(seed);//c
            }

        }
        else {
            complex[0] = new Complex(pertur_val.getValue(init_val.getValue(pixel)));//z
            complex[1] = new Complex(seed);//c
            complex[2] = new Complex();
            complex[3] = new Complex(-1, 0);
            complex[4] = new Complex(1e-10, 0);
            complex[5] = complex[4].pow(z_exponent).sub_mutable(1);
        }


        zold = new Complex();
        zold2 = new Complex();
        start = new Complex(complex[0]);
        c0 = new Complex(complex[1]);

        return complex;

    }

    @Override
    public void function(GenericComplex[] complex) {
        if(complex[0] instanceof BigComplex) {
            complex[0] = complex[0].sub(complex[0].cube().sub(MyApfloat.ONE).divide(complex[0].square().times(MyApfloat.THREE))).plus(complex[1]);
        }
        else {
            complex[0] = complex[0].sub_mutable(complex[0].cube().sub_mutable(1).divide_mutable(complex[0].square().times_mutable(3))).plus_mutable(complex[1]);
        }
    }

    @Override
    public boolean supportsPerturbationTheory() {

        if(isJuliaMap) {
            return false;
        }

        if(isJulia && juliter) {
            return false;
        }

        return supportsPerturbation;
    }

    @Override
    protected int[] getNeededPrecalculatedTermsIndexes() {
        return new int[] {0};
    }

    @Override
    protected Function[] getPrecalculatedTermsFunctions(Complex c) {
        Function<Complex, Complex> f1 = x -> x.fourth().sub_mutable(x);
        return new Function[] {f1};
    }

    @Override
    protected Function[] getPrecalculatedTermsFunctionsDeep(MantExpComplex c) {
        Function<MantExpComplex, MantExpComplex> f1 = x -> x.fourth().sub_mutable(x);
        return new Function[] {f1};
    }

    @Override
    public void calculateReferencePoint(GenericComplex inputPixel, Apfloat size, boolean deepZoom, int[] Iterations, int[] juliaIterations, Location externalLocation, JProgressBar progress) {

        LastCalculationSize = size;

        long time = System.currentTimeMillis();

        int max_ref_iterations = getReferenceMaxIterations();

        int iterations = Iterations[0];
        int initIterations = iterations;

        if(progress != null) {
            progress.setMaximum(max_ref_iterations - initIterations);
            progress.setValue(0);
            progress.setForeground(MainWindow.progress_ref_color);
            progress.setString(REFERENCE_CALCULATION_STR + " " + String.format("%3d", 0) + "%");
        }

        boolean lowPrecReferenceOrbitNeeded = !needsOnlyExtendedReferenceOrbit(deepZoom, false);
        DoubleReference.SHOULD_SAVE_MEMORY = false;
        boolean useCompressedRef = TaskDraw.COMPRESS_REFERENCE_IF_POSSIBLE && supportsReferenceCompression();
        int[] preCalcIndexes = getNeededPrecalculatedTermsIndexes();

        if(iterations == 0) {
            if(lowPrecReferenceOrbitNeeded) {
                referenceData.createAndSetShortcut(max_ref_iterations, true, preCalcIndexes, useCompressedRef);
            }
            else {
                referenceData.deallocate();
            }

            if (deepZoom) {
                referenceDeepData.createAndSetShortcut(max_ref_iterations, true, preCalcIndexes, useCompressedRef);
            }
        }
        else if (max_ref_iterations > getReferenceLength()){
            if(lowPrecReferenceOrbitNeeded) {
                referenceData.resize(max_ref_iterations);
            }
            else {
                referenceData.deallocate();
            }

            if (deepZoom) {
                referenceDeepData.resize(max_ref_iterations);
            }
        }

        if(isJulia) {
            //Due to zero, all around zero will not work
            inputPixel = sanitizeInputPixel(inputPixel);
        }

        int bigNumLib = TaskDraw.getBignumLibrary(size, this);

        GenericComplex z, c, zold, zold2, start, c0, initVal, pixel;
        if(bigNumLib == Constants.BIGNUM_MPFR) {

            initVal = new MpfrBigNumComplex(defaultInitVal.getValue(null));

            MpfrBigNumComplex bn = new MpfrBigNumComplex(inputPixel.toMpfrBigNumComplex());

            z = iterations == 0 ? (isJulia ? bn : new MpfrBigNumComplex((MpfrBigNumComplex)initVal)) : referenceData.lastZValue;
            c = isJulia ? getSeed(bigNumLib) : bn;
            zold = iterations == 0 ? new MpfrBigNumComplex() : referenceData.secondTolastZValue;
            zold2 = iterations == 0 ? new MpfrBigNumComplex() : referenceData.thirdTolastZValue;
            start = isJulia ? new MpfrBigNumComplex(bn) : new MpfrBigNumComplex((MpfrBigNumComplex)initVal);
            c0 = new MpfrBigNumComplex((MpfrBigNumComplex)c);
            pixel = new MpfrBigNumComplex(bn);
        }
        else if(bigNumLib == Constants.BIGNUM_MPIR) {

            initVal = new MpirBigNumComplex(defaultInitVal.getValue(null));

            MpirBigNumComplex bn = new MpirBigNumComplex(inputPixel.toMpirBigNumComplex());

            z = iterations == 0 ? (isJulia ? bn : new MpirBigNumComplex((MpirBigNumComplex)initVal)) : referenceData.lastZValue;
            c = isJulia ? getSeed(bigNumLib) : bn;
            zold = iterations == 0 ? new MpirBigNumComplex() : referenceData.secondTolastZValue;
            zold2 = iterations == 0 ? new MpirBigNumComplex() : referenceData.thirdTolastZValue;
            start = isJulia ? new MpirBigNumComplex(bn) : new MpirBigNumComplex((MpirBigNumComplex)initVal);
            c0 = new MpirBigNumComplex((MpirBigNumComplex)c);
            pixel = new MpirBigNumComplex(bn);
        }
        else if(bigNumLib == Constants.BIGNUM_BIGINT) {
            initVal = new BigIntNumComplex(defaultInitVal.getValue(null));

            BigIntNumComplex bin = inputPixel.toBigIntNumComplex();
            z = iterations == 0 ? (isJulia ? bin : initVal) : referenceData.lastZValue;
            c = isJulia ? getSeed(bigNumLib) : bin;
            zold = iterations == 0 ? new BigIntNumComplex() : referenceData.secondTolastZValue;
            zold2 = iterations == 0 ? new BigIntNumComplex() : referenceData.thirdTolastZValue;
            start = isJulia ? bin : initVal;
            c0 = c;
            pixel = bin;
        }
        else if(bigNumLib == Constants.BIGNUM_DOUBLEDOUBLE) {
            initVal = new DDComplex(defaultInitVal.getValue(null));

            DDComplex ddn = inputPixel.toDDComplex();
            z = iterations == 0 ? (isJulia ? ddn : initVal) : referenceData.lastZValue;
            c = isJulia ? getSeed(bigNumLib) : ddn;
            zold = iterations == 0 ? new DDComplex() : referenceData.secondTolastZValue;
            zold2 = iterations == 0 ? new DDComplex() : referenceData.thirdTolastZValue;
            start = isJulia ? ddn : initVal;
            c0 = c;
            pixel = ddn;
        }
        else if(bigNumLib == Constants.BIGNUM_DOUBLE) {
            initVal = defaultInitVal.getValue(null);

            Complex bn = inputPixel.toComplex();

            z = iterations == 0 ? (isJulia ? bn : new Complex((Complex)initVal)) : referenceData.lastZValue;
            c = isJulia ? getSeed(bigNumLib) : bn;
            zold = iterations == 0 ? new Complex() : referenceData.secondTolastZValue;
            zold2 = iterations == 0 ? new Complex() : referenceData.thirdTolastZValue;
            start = isJulia ? new Complex(bn) : new Complex((Complex)initVal);
            c0 = new Complex((Complex) c);
            pixel = new Complex(bn);
        }
        else {
            initVal = new BigComplex(defaultInitVal.getValue(null));

            z = iterations == 0 ? (isJulia ? inputPixel : initVal) : referenceData.lastZValue;
            c = isJulia ? getSeed(bigNumLib) : inputPixel;
            zold = iterations == 0 ? new BigComplex() : referenceData.secondTolastZValue;
            zold2 = iterations == 0 ? new BigComplex() : referenceData.thirdTolastZValue;
            start = isJulia ? inputPixel : initVal;
            c0 = c;
            pixel = inputPixel;
        }



        Location loc = new Location();

        refPoint = inputPixel;

        if(deepZoom) {
            refPointSmallDeep = loc.getMantExpComplex(refPoint);
            refPointSmall = refPointSmallDeep.toComplex();
            if(isJulia) {
                seedSmallDeep = loc.getMantExpComplex(c);
            }

            if(lowPrecReferenceOrbitNeeded && isJulia) {
                seedSmall = seedSmallDeep.toComplex();
            }
        }
        else {
            refPointSmall = refPoint.toComplex();
            if(lowPrecReferenceOrbitNeeded && isJulia) {
                seedSmall = c.toComplex();
            }
        }

        RefType = getRefType();

        convergent_bailout_algorithm.setReferenceMode(true);

        if(useCompressedRef) {
            if(deepZoom) {
                referenceCompressor[referenceDeep.id] = new ReferenceCompressor(this, iterations == 0 ? z.toMantExpComplex() : referenceData.compressorZm, c.toMantExpComplex(), start.toMantExpComplex());

                MantExpComplex cp = initVal.toMantExpComplex();
                Function<MantExpComplex, MantExpComplex> f = x -> x.sub(cp);
                functions[referenceDeepData.ReferenceSubCp.id] = f;
                subexpressionsCompressor[referenceDeepData.ReferenceSubCp.id] = new ReferenceCompressor(f, true);

                Function<MantExpComplex, MantExpComplex>[] fs = getPrecalculatedTermsFunctionsDeep(c.toMantExpComplex());
                for(int i = 0; i < preCalcIndexes.length; i++) {
                    int id = referenceDeepData.PrecalculatedTerms[preCalcIndexes[i]].id;
                    functions[id] = fs[i];
                    subexpressionsCompressor[id] = new ReferenceCompressor(fs[i], true);
                }
            }

            if(lowPrecReferenceOrbitNeeded) {
                referenceCompressor[reference.id] = new ReferenceCompressor(this, iterations == 0 ? z.toComplex() : referenceData.compressorZ, c.toComplex(), start.toComplex());

                Complex cp = initVal.toComplex();
                Function<Complex, Complex> f = x -> x.sub(cp);
                functions[referenceData.ReferenceSubCp.id] = f;
                subexpressionsCompressor[referenceData.ReferenceSubCp.id] = new ReferenceCompressor(f);

                Function<Complex, Complex>[] fs = getPrecalculatedTermsFunctions(c.toComplex());
                for(int i = 0; i < preCalcIndexes.length; i++) {
                    int id = referenceData.PrecalculatedTerms[preCalcIndexes[i]].id;
                    functions[id] = fs[i];
                    subexpressionsCompressor[id] = new ReferenceCompressor(fs[i]);
                }
            }
        }

        calculatedReferenceIterations = 0;

        MantExpComplex tempmcz = null;
        Complex cz = null;

        for (; iterations < max_iterations; iterations++, calculatedReferenceIterations++) {

            GenericComplex zsubcp;
            if(bigNumLib == Constants.BIGNUM_MPFR) {
                zsubcp = z.sub(initVal, workSpaceData.temp1, workSpaceData.temp2);
            }
            else if(bigNumLib == Constants.BIGNUM_MPIR) {
                zsubcp = z.sub(initVal, workSpaceData.temp1p, workSpaceData.temp2p);
            }
            else {
                zsubcp = z.sub(initVal);
            }

            GenericComplex zcubes1;

            if(bigNumLib != BIGNUM_APFLOAT) {
                zcubes1 = z.cube().sub_mutable(1);
            }
            else {
                zcubes1 = z.cube().sub(MyApfloat.ONE);
            }

            GenericComplex preCalc;
            preCalc = zcubes1.times(z); //Z^4-Z for catastrophic cancelation

            MantExpComplex czm = null;
            MantExpComplex precalm = null;
            MantExpComplex zsubcpm = null;

            if(deepZoom) {
                czm = loc.getMantExpComplex(z);
                if (czm.isInfinite() || czm.isNaN()) {
                    break;
                }
                tempmcz = setArrayDeepValue(referenceDeep, iterations, czm);
            }

            if(lowPrecReferenceOrbitNeeded) {
                cz = deepZoom ? czm.toComplex() : z.toComplex();
                if (cz.isInfinite() || cz.isNaN()) {
                    break;
                }

                cz = setArrayValue(reference, iterations, cz);
            }

            czm = tempmcz;

            if(deepZoom) {
                precalm = loc.getMantExpComplex(preCalc);
                zsubcpm = loc.getMantExpComplex(zsubcp);
                setArrayDeepValue(referenceDeepData.PrecalculatedTerms[0], iterations, precalm, czm);
                setArrayDeepValue(referenceDeepData.ReferenceSubCp, iterations, zsubcpm, czm);
            }

            if(lowPrecReferenceOrbitNeeded) {
                setArrayValue(referenceData.PrecalculatedTerms[0], iterations, deepZoom ? precalm.toComplex() : preCalc.toComplex(), cz);
                setArrayValue(referenceData.ReferenceSubCp, iterations, deepZoom ? zsubcpm.toComplex() : zsubcp.toComplex(), cz);
            }

            if (iterations > 0 && convergent_bailout_algorithm.Converged(z, zold, zold2, iterations, c, start, c0, pixel)) {
                break;
            }

            zold2.set(zold);
            zold.set(z);

            try {
                if(bigNumLib != BIGNUM_APFLOAT) {
                    z = z.sub_mutable(zcubes1.divide_mutable(z.square().times_mutable(3))).plus_mutable(c);
                }
                else {
                    z = z.sub(zcubes1.divide(z.square().times(MyApfloat.THREE))).plus(c);
                }
            }
            catch (Exception ex) {
                break;
            }

            if(progress != null && iterations % 1000 == 0) {
                progress.setValue(iterations - initIterations);
                progress.setString(REFERENCE_CALCULATION_STR + " " + String.format("%3d",(int) ((double) (iterations - initIterations) / progress.getMaximum() * 100)) + "%");
            }

        }

        convergent_bailout_algorithm.setReferenceMode(false);

        referenceData.lastZValue = z;
        referenceData.secondTolastZValue = zold;
        referenceData.thirdTolastZValue = zold2;

        referenceData.MaxRefIteration = iterations - 1;

        if(useCompressedRef) {
            if(deepZoom) {
                referenceCompressor[referenceDeep.id].compact(referenceDeep);
                referenceData.compressorZm = referenceCompressor[referenceDeep.id].getZDeep();
                subexpressionsCompressor[referenceDeepData.ReferenceSubCp.id].compact(referenceDeepData.ReferenceSubCp);

                for(int i = 0; i < preCalcIndexes.length; i++) {
                    subexpressionsCompressor[referenceDeepData.PrecalculatedTerms[preCalcIndexes[i]].id].compact(referenceDeepData.PrecalculatedTerms[preCalcIndexes[i]]);
                }
            }

            if(lowPrecReferenceOrbitNeeded) {
                referenceCompressor[reference.id].compact(reference);
                referenceData.compressorZ = referenceCompressor[reference.id].getZ();
                subexpressionsCompressor[referenceData.ReferenceSubCp.id].compact(referenceData.ReferenceSubCp);

                for(int i = 0; i < preCalcIndexes.length; i++) {
                    subexpressionsCompressor[referenceData.PrecalculatedTerms[preCalcIndexes[i]].id].compact(referenceData.PrecalculatedTerms[preCalcIndexes[i]]);
                }
            }
        }

        SAskippedIterations = 0;

        if(progress != null) {
            progress.setValue(progress.getMaximum());
            progress.setString(REFERENCE_CALCULATION_STR + " 100%");
        }
        ReferenceCalculationTime = System.currentTimeMillis() - time;

        if(isJulia) {
            calculateJuliaReferencePoint(inputPixel, size, deepZoom, juliaIterations, progress);
        }
    }

    @Override
    protected void calculateJuliaReferencePoint(GenericComplex inputPixel, Apfloat size, boolean deepZoom, int[] juliaIterations, JProgressBar progress) {

        int iterations = juliaIterations[0];
        if(iterations == 0 && ((!deepZoom && secondReferenceData.Reference != null) || (deepZoom && secondReferenceDeepData.Reference != null))) {
            return;
        }

        long time = System.currentTimeMillis();

        int max_ref_iterations = getReferenceMaxIterations();

        int initIterations = iterations;

        if(progress != null) {
            progress.setMaximum(max_ref_iterations - initIterations);
            progress.setValue(0);
            progress.setForeground(MainWindow.progress_ref_color);
            progress.setString(REFERENCE_CALCULATION_STR + " " + String.format("%3d", 0) + "%");
        }

        boolean lowPrecReferenceOrbitNeeded = !needsOnlyExtendedReferenceOrbit(deepZoom, false);
        DoubleReference.SHOULD_SAVE_MEMORY = false;
        boolean useCompressedRef = TaskDraw.COMPRESS_REFERENCE_IF_POSSIBLE && supportsReferenceCompression();
        int[] preCalcIndexes = getNeededPrecalculatedTermsIndexes();

        if (iterations == 0) {
            if(lowPrecReferenceOrbitNeeded) {
                secondReferenceData.create(max_ref_iterations,true, preCalcIndexes, useCompressedRef);
            }
            else {
                secondReferenceData.deallocate();
            }

            if (deepZoom) {
                secondReferenceDeepData.create(max_ref_iterations,true, preCalcIndexes, useCompressedRef);
            }
        } else if (max_ref_iterations > getSecondReferenceLength()) {
            if(lowPrecReferenceOrbitNeeded) {
                secondReferenceData.resize(max_ref_iterations);
            }
            else {
                secondReferenceData.deallocate();
            }

            if (deepZoom) {
                secondReferenceDeepData.resize(max_ref_iterations);
            }
        }

        Location loc = new Location();

        GenericComplex z, c, zold, zold2, start, c0, pixel, initVal;

        int bigNumLib = TaskDraw.getBignumLibrary(size, this);

        if(bigNumLib == Constants.BIGNUM_MPFR) {

            initVal = new MpfrBigNumComplex(defaultInitVal.getValue(null));

            MpfrBigNumComplex bn = new MpfrBigNumComplex(inputPixel.toMpfrBigNumComplex());

            z = iterations == 0 ? new MpfrBigNumComplex((MpfrBigNumComplex)initVal) : secondReferenceData.lastZValue;
            c = getSeed(bigNumLib);
            zold = iterations == 0 ? new MpfrBigNumComplex() : secondReferenceData.secondTolastZValue;
            zold2 = iterations == 0 ? new MpfrBigNumComplex() : secondReferenceData.thirdTolastZValue;
            start = new MpfrBigNumComplex((MpfrBigNumComplex)initVal);
            c0 = new MpfrBigNumComplex((MpfrBigNumComplex)c);
            pixel = new MpfrBigNumComplex(bn);
        }
        else if(bigNumLib == Constants.BIGNUM_MPIR) {

            initVal = new MpirBigNumComplex(defaultInitVal.getValue(null));

            MpirBigNumComplex bn = new MpirBigNumComplex(inputPixel.toMpirBigNumComplex());

            z = iterations == 0 ? new MpirBigNumComplex((MpirBigNumComplex)initVal) : secondReferenceData.lastZValue;
            c = getSeed(bigNumLib);
            zold = iterations == 0 ? new MpirBigNumComplex() : secondReferenceData.secondTolastZValue;
            zold2 = iterations == 0 ? new MpirBigNumComplex() : secondReferenceData.thirdTolastZValue;
            start = new MpirBigNumComplex((MpirBigNumComplex)initVal);
            c0 = new MpirBigNumComplex((MpirBigNumComplex)c);
            pixel = new MpirBigNumComplex(bn);
        }
        else if(bigNumLib == Constants.BIGNUM_DOUBLEDOUBLE) {
            initVal = new DDComplex(defaultInitVal.getValue(null));

            DDComplex ddn = inputPixel.toDDComplex();
            z = iterations == 0 ? initVal : secondReferenceData.lastZValue;
            c = getSeed(bigNumLib);
            zold = iterations == 0 ? new DDComplex() : secondReferenceData.secondTolastZValue;
            zold2 = iterations == 0 ? new DDComplex() : secondReferenceData.thirdTolastZValue;
            start = initVal;
            c0 = c;
            pixel = ddn;
        }
        else if(bigNumLib == Constants.BIGNUM_BIGINT) {
            initVal = new BigIntNumComplex(defaultInitVal.getValue(null));

            BigIntNumComplex bin = inputPixel.toBigIntNumComplex();
            z = iterations == 0 ? initVal : secondReferenceData.lastZValue;
            c = getSeed(bigNumLib);
            zold = iterations == 0 ? new BigIntNumComplex() : secondReferenceData.secondTolastZValue;
            zold2 = iterations == 0 ? new BigIntNumComplex() : secondReferenceData.thirdTolastZValue;
            start = initVal;
            c0 = c;
            pixel = bin;
        }
        else if(bigNumLib == Constants.BIGNUM_DOUBLE) {
            initVal = defaultInitVal.getValue(null);

            Complex bn = inputPixel.toComplex();

            z = iterations == 0 ? new Complex((Complex)initVal) : secondReferenceData.lastZValue;
            c = getSeed(bigNumLib);
            zold = iterations == 0 ? new Complex() : secondReferenceData.secondTolastZValue;
            zold2 = iterations == 0 ? new Complex() : secondReferenceData.thirdTolastZValue;
            start = new Complex((Complex)initVal);
            c0 = new Complex((Complex) c);
            pixel = new Complex(bn);
        }
        else {
            initVal = new BigComplex(defaultInitVal.getValue(null));

            z = iterations == 0 ? initVal : secondReferenceData.lastZValue;
            c = getSeed(bigNumLib);
            zold = iterations == 0 ? new BigComplex() : secondReferenceData.secondTolastZValue;
            zold2 = iterations == 0 ? new BigComplex() : secondReferenceData.thirdTolastZValue;
            start = initVal;
            c0 = c;
            pixel = inputPixel;
        }


        convergent_bailout_algorithm.setReferenceMode(true);

        if(useCompressedRef) {
            if(deepZoom) {
                referenceCompressor[secondReferenceDeepData.Reference.id] = new ReferenceCompressor(this, iterations == 0 ? z.toMantExpComplex() : secondReferenceData.compressorZm, c.toMantExpComplex(), start.toMantExpComplex());

                MantExpComplex cp = initVal.toMantExpComplex();
                Function<MantExpComplex, MantExpComplex> f = x -> x.sub(cp);
                functions[secondReferenceDeepData.ReferenceSubCp.id] = f;
                subexpressionsCompressor[secondReferenceDeepData.ReferenceSubCp.id] = new ReferenceCompressor(f, true);

                Function<MantExpComplex, MantExpComplex>[] fs = getPrecalculatedTermsFunctionsDeep(c.toMantExpComplex());
                for(int i = 0; i < preCalcIndexes.length; i++) {
                    int id = secondReferenceDeepData.PrecalculatedTerms[preCalcIndexes[i]].id;
                    functions[id] = fs[i];
                    subexpressionsCompressor[id] = new ReferenceCompressor(fs[i], true);
                }
            }
            if(lowPrecReferenceOrbitNeeded) {
                referenceCompressor[secondReferenceData.Reference.id] = new ReferenceCompressor(this, iterations == 0 ? z.toComplex() : secondReferenceData.compressorZ, c.toComplex(), start.toComplex());

                Complex cp = initVal.toComplex();
                Function<Complex, Complex> f = x -> x.sub(cp);
                functions[secondReferenceData.ReferenceSubCp.id] = f;
                subexpressionsCompressor[secondReferenceData.ReferenceSubCp.id] = new ReferenceCompressor(f);

                Function<Complex, Complex>[] fs = getPrecalculatedTermsFunctions(c.toComplex());
                for(int i = 0; i < preCalcIndexes.length; i++) {
                    int id = secondReferenceData.PrecalculatedTerms[preCalcIndexes[i]].id;
                    functions[id] = fs[i];
                    subexpressionsCompressor[id] = new ReferenceCompressor(fs[i]);
                }
            }
        }

        calculatedSecondReferenceIterations = 0;
        MantExpComplex tempczm = null;
        Complex cz = null;

        for (; iterations < max_ref_iterations; iterations++, calculatedSecondReferenceIterations++) {

            GenericComplex zsubcp;
            if(bigNumLib == Constants.BIGNUM_MPFR) {
                zsubcp = z.sub(initVal, workSpaceData.temp1, workSpaceData.temp2);
            }
            else if(bigNumLib == Constants.BIGNUM_MPIR) {
                zsubcp = z.sub(initVal, workSpaceData.temp1p, workSpaceData.temp2p);
            }
            else {
                zsubcp = z.sub(initVal);
            }

            GenericComplex zcubes1;

            if(bigNumLib != Constants.BIGNUM_APFLOAT) {
                zcubes1 = z.cube().sub_mutable(1);
            }
            else {
                zcubes1 = z.cube().sub(MyApfloat.ONE);
            }

            GenericComplex preCalc;
            preCalc = zcubes1.times(z); //Z^4-Z for catastrophic cancelation

            MantExpComplex czm = null;
            MantExpComplex precalm = null;
            MantExpComplex zsubcpm = null;

            if(deepZoom) {
                czm = loc.getMantExpComplex(z);
                if (czm.isInfinite() || czm.isNaN()) {
                    break;
                }
                tempczm = setArrayDeepValue(secondReferenceDeepData.Reference, iterations, czm);
            }

            if(lowPrecReferenceOrbitNeeded) {
                cz = deepZoom ? czm.toComplex() : z.toComplex();
                if (cz.isInfinite() || cz.isNaN()) {
                    break;
                }

                cz = setArrayValue(secondReferenceData.Reference, iterations, cz);
            }

            czm = tempczm;

            if(deepZoom) {
                precalm = loc.getMantExpComplex(preCalc);
                zsubcpm = loc.getMantExpComplex(zsubcp);
                setArrayDeepValue(secondReferenceDeepData.PrecalculatedTerms[0], iterations, precalm, czm);
                setArrayDeepValue(secondReferenceDeepData.ReferenceSubCp, iterations, zsubcpm, czm);
            }

            if(lowPrecReferenceOrbitNeeded) {
                setArrayValue(secondReferenceData.PrecalculatedTerms[0], iterations, deepZoom ? precalm.toComplex() : preCalc.toComplex(), cz);
                setArrayValue(secondReferenceData.ReferenceSubCp, iterations, deepZoom ? zsubcpm.toComplex() : zsubcp.toComplex(), cz);
            }

            if (iterations > 0 && convergent_bailout_algorithm.Converged(z, zold, zold2, iterations, c, start, c0, pixel)) {
                break;
            }

            zold2.set(zold);
            zold.set(z);

            try {
                if(bigNumLib != Constants.BIGNUM_APFLOAT) {
                    z = z.sub_mutable(zcubes1.divide_mutable(z.square().times_mutable(3))).plus_mutable(c);
                }
                else {
                    z = z.sub(zcubes1.divide(z.square().times(MyApfloat.THREE))).plus(c);
                }
            }
            catch (Exception ex) {
                break;
            }

            if(progress != null && iterations % 1000 == 0) {
                progress.setValue(iterations - initIterations);
                progress.setString(REFERENCE_CALCULATION_STR + " " + String.format("%3d",(int) ((double) (iterations - initIterations) / progress.getMaximum() * 100)) + "%");
            }

        }

        convergent_bailout_algorithm.setReferenceMode(false);

        secondReferenceData.lastZValue = z;
        secondReferenceData.secondTolastZValue = zold;
        secondReferenceData.thirdTolastZValue = zold2;

        secondReferenceData.MaxRefIteration = iterations - 1;

        if(useCompressedRef) {
            if(deepZoom) {
                referenceCompressor[secondReferenceDeepData.Reference.id].compact(secondReferenceDeepData.Reference);
                secondReferenceData.compressorZm = referenceCompressor[secondReferenceDeepData.Reference.id].getZDeep();

                subexpressionsCompressor[secondReferenceDeepData.ReferenceSubCp.id].compact(secondReferenceDeepData.ReferenceSubCp);

                for(int i = 0; i < preCalcIndexes.length; i++) {
                    subexpressionsCompressor[secondReferenceDeepData.PrecalculatedTerms[preCalcIndexes[i]].id].compact(secondReferenceDeepData.PrecalculatedTerms[preCalcIndexes[i]]);
                }
            }

            if(lowPrecReferenceOrbitNeeded) {
                referenceCompressor[secondReferenceData.Reference.id].compact(secondReferenceData.Reference);
                secondReferenceData.compressorZ = referenceCompressor[secondReferenceData.Reference.id].getZ();

                subexpressionsCompressor[secondReferenceData.ReferenceSubCp.id].compact(secondReferenceData.ReferenceSubCp);

                for(int i = 0; i < preCalcIndexes.length; i++) {
                    subexpressionsCompressor[secondReferenceData.PrecalculatedTerms[preCalcIndexes[i]].id].compact(secondReferenceData.PrecalculatedTerms[preCalcIndexes[i]]);
                }
            }
        }

        if(progress != null) {
            progress.setValue(progress.getMaximum());
            progress.setString(REFERENCE_CALCULATION_STR + " 100%");
        }

        SecondReferenceCalculationTime = System.currentTimeMillis() - time;
    }


    //(z * ((2*Z+z)*z*Z^2 + (Z^4 - Z) -0.5 *z)) / (1.5 * ((2*Z+z)*z*Z^2 + Z^4)) + c
    @Override
    public Complex perturbationFunction(Complex z, Complex c, int RefIteration) {

       /* Complex X = Reference[RefIteration];

        Complex twoX = X.times2();
        Complex Xp1 = X.plus(1);
        Complex XA = (twoX.plus(4)).times_mutable(X).plus_mutable(2);
        Complex XB = ((X.times4().plus_mutable(12)).times_mutable(X).plus_mutable(12)).times_mutable(X).plus_mutable(3);
        Complex XC = (((twoX.plus(8)).times_mutable(X).plus_mutable(12)).times_mutable(X).plus_mutable(6)).times_mutable(X);
        Complex XD = (Xp1.square()).times_mutable(3);


        //XA = (2*X+4)*X+2;
        //XB= ((4*X+12)*X+12)*X+3;
        //XC = (((2*X+8)*X+12)*X+6)*X;
        //XD = 3*((X+1)^2);
        //xn = c + (((XA*x + XB)*x + XC)*x) / (XD*(((X+1)+x)^2));

        return (((XA.times(DeltaSubN).plus_mutable(XB)).times_mutable(DeltaSubN).plus_mutable(XC)).times_mutable(DeltaSubN)).divide_mutable(XD.times((Xp1.plus(DeltaSubN)).square_mutable())).plus_mutable(DeltaSub0);
*/

        Complex Z = getArrayValue(reference, RefIteration);

        Complex temp = Z.times2().plus_mutable(z).times_mutable(z).times_mutable(Z.square());
        return temp.plus(getArrayValue(referenceData.PrecalculatedTerms[0], RefIteration , Z)).sub_mutable(z.times(0.5)).times_mutable(z).divide_mutable(temp.plus(Z.fourth()).times_mutable(1.5)).plus_mutable(c);
    }

    @Override
    public MantExpComplex perturbationFunction(MantExpComplex z, MantExpComplex c, int RefIteration) {

        MantExpComplex Z = getArrayDeepValue(referenceDeep, RefIteration);

        MantExpComplex temp = Z.times2().plus_mutable(z).times_mutable(z).times_mutable(Z.square());
        return temp.plus(getArrayDeepValue(referenceDeepData.PrecalculatedTerms[0], RefIteration, Z)).sub_mutable(z.divide2()).times_mutable(z).divide_mutable(temp.plus(Z.fourth()).times_mutable(MantExp.ONEPOINTFIVE)).plus_mutable(c);
    }

    @Override
    public Complex perturbationFunction(Complex z, int RefIteration) {

        Complex Z = getArrayValue(reference, RefIteration);

        Complex temp = Z.times2().plus_mutable(z).times_mutable(z).times_mutable(Z.square());
        return temp.plus(getArrayValue(referenceData.PrecalculatedTerms[0], RefIteration, Z)).sub_mutable(z.times(0.5)).times_mutable(z).divide_mutable(temp.plus(Z.fourth()).times_mutable(1.5));

    }

    @Override
    public MantExpComplex perturbationFunction(MantExpComplex z, int RefIteration) {

        MantExpComplex Z = getArrayDeepValue(referenceDeep, RefIteration);

        MantExpComplex temp = Z.times2().plus_mutable(z).times_mutable(z).times_mutable(Z.square());
        return temp.plus(getArrayDeepValue(referenceDeepData.PrecalculatedTerms[0], RefIteration, Z)).sub_mutable(z.divide2()).times_mutable(z).divide_mutable(temp.plus(Z.fourth()).times_mutable(MantExp.ONEPOINTFIVE));
    }

    @Override
    public Complex perturbationFunction(Complex z, ReferenceData data, int RefIteration) {

        Complex Z = getArrayValue(data.Reference, RefIteration);

        Complex temp = Z.times2().plus_mutable(z).times_mutable(z).times_mutable(Z.square());
        return temp.plus(getArrayValue(data.PrecalculatedTerms[0], RefIteration, Z)).sub_mutable(z.times(0.5)).times_mutable(z).divide_mutable(temp.plus(Z.fourth()).times_mutable(1.5));

    }

    @Override
    public MantExpComplex perturbationFunction(MantExpComplex z, ReferenceDeepData data, int RefIteration) {

        MantExpComplex Z = getArrayDeepValue(data.Reference, RefIteration);

        MantExpComplex temp = Z.times2().plus_mutable(z).times_mutable(z).times_mutable(Z.square());
        return temp.plus(getArrayDeepValue(data.PrecalculatedTerms[0], RefIteration, Z)).sub_mutable(z.divide2()).times_mutable(z).divide_mutable(temp.plus(Z.fourth()).times_mutable(MantExp.ONEPOINTFIVE));
    }

    @Override
    public String getRefType() {
        return super.getRefType() + "-" + z_exponent.toString() + "-" + relaxation.toString() + (isJulia ? "-Julia-" + bigSeed.toStringPretty() : "");
    }

    @Override
    public Complex evaluateFunction(Complex z, Complex c) {

        if(!isJulia) {
            return null;
        }

        Complex fz;
        if (z_exponent.getIm() == 0) {
            if (z_exponent.getRe() == 2) {
                fz = z.square().sub_mutable(1);
            } else if (z_exponent.getRe() == 3) {
                fz = z.cube().sub_mutable(1);
            } else if (z_exponent.getRe() == 4) {
                fz = z.fourth().sub_mutable(1);
            } else if (z_exponent.getRe() == 5) {
                fz = z.fifth().sub_mutable(1);
            } else if (z_exponent.getRe() == 6) {
                fz = z.sixth().sub_mutable(1);
            } else if (z_exponent.getRe() == 7) {
                fz = z.seventh().sub_mutable(1);
            } else if (z_exponent.getRe() == 8) {
                fz = z.eighth().sub_mutable(1);
            } else if (z_exponent.getRe() == 9) {
                fz = z.ninth().sub_mutable(1);
            } else if (z_exponent.getRe() == 10) {
                fz = z.tenth().sub_mutable(1);
            } else {
                fz = z.pow(z_exponent.getRe()).sub_mutable(1);
            }
        } else {
            fz = z.pow(z_exponent).sub_mutable(1);
        }

        return fz;
    }

    @Override
    public boolean supportsMpfrBignum() { return true;}

    @Override
    public boolean supportsMpirBignum() { return true;}

    @Override
    public boolean needsExtendedRange() {
        return TaskDraw.USE_FULL_FLOATEXP_FOR_ALL_ZOOM || (TaskDraw.USE_CUSTOM_FLOATEXP_REQUIREMENT && isJulia && size < 1.0e-14);
    }

    @Override
    public boolean supportsBigIntnum() {
        return true;
    }

    @Override
    public boolean supportsReferenceCompression() {
        return true;
    }

    @Override
    public Complex function(Complex z, Complex c) {
        return z.sub_mutable(z.cube().sub_mutable(1).divide_mutable(z.square().times_mutable(3))).plus_mutable(c);
    }

    @Override
    public MantExpComplex function(MantExpComplex z, MantExpComplex c) {
        return z.sub_mutable(z.cube().sub_mutable(MantExp.ONE).divide_mutable(z.square().times_mutable(MantExp.THREE))).plus_mutable(c);
    }

    @Override
    protected boolean needsRefSubCp() {
        return true;
    }

    @Override
    public double getPower() {
        if(z_exponent.getRe() != 0 && z_exponent.getIm() == 0) {
            return z_exponent.getRe();
        }
        return 0;
    }

}
