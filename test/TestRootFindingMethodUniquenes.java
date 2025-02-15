package test;
import fractalzoomer.core.Complex;
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

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

public class TestRootFindingMethodUniquenes {
    private static final double epsilon = 1e-4;

    public static Complex getFz(Complex z) {
        //return z.cube().sub(1);
        return z.fourth().sub(1);
        //return z.cube().sub_mutable(z.times(2)).plus_mutable(2);
        //return z.eighth().plus_mutable(z.fourth().times_mutable(15)).sub_mutable(16);
    }

    public static Complex getDFz(Complex z) {
        //return  z.square().times(3);
        return z.cube().times(4);
       //return z.square().times_mutable(3).sub_mutable(2);
        //return z.seventh().times_mutable(8).plus_mutable(z.cube().times_mutable(60));
    }

    public static Complex getDDFz(Complex z) {
        //return z.times(6);
        return z.square().times(12);
        //return z.times(6);
        //return z.sixth().times_mutable(56).plus_mutable(z.square().times_mutable(180));
    }

    public static Complex getDDDFz(Complex z) {
        //return new Complex(6, 0);
        return z.times(24);
        //return new Complex(6, 0);
        //return z.fifth().times_mutable(336).plus_mutable(z.times(360));
    }

    public static Complex getNextIterationForMethod(Complex z, int method, Complex zold, Complex zold2)
    {

        Complex fz = getFz(z);
        Complex dfz = getDFz(z);
        Complex ddfz = getDDFz(z);
        Complex dddfz = getDDDFz(z);

        switch (method) {
            case 0: //Newton
                return NewtonRootFindingMethod.newtonMethod(z, fz, dfz, new Complex(1, 0));
            case 1: //Halley
                return HalleyRootFindingMethod.halleyMethod(z, fz, dfz, ddfz, new Complex(1, 0));
            case 2: //Householder
                return HouseholderRootFindingMethod.householderMethod(z, fz, dfz, ddfz, new Complex(1, 0));
            case 3: //Schroder
                return SchroderRootFindingMethod.schroderMethod(z, fz, dfz, ddfz, new Complex(1, 0));
            case 4: //Parhalley
                return ParhalleyRootFindingMethod.parhalleyMethod(z, fz, dfz, ddfz, new Complex(1, 0));
            case 5: // Laguerrre
                return LaguerreRootFindingMethod.laguerreMethod(z, fz, dfz, ddfz, new Complex(4, 0), new Complex(1, 0));
            case 6: //Newton-hines
                return NewtonHinesRootFindingMethod.newtonHinesMethod(z, fz, dfz, new Complex(-0.5, 0), new Complex(1, 0));
            case 7: //Secant
                Complex fz1 = getFz(zold);
                return SecantRootFindingMethod.secantMethod(z, fz, zold,fz1, new Complex(1, 0));
            case 8: //Whittaker
                return WhittakerRootFindingMethod.whittakerMethod(z, fz, dfz, ddfz, new Complex(1, 0));
            case 9: //Whittaker-Dbl
                return WhittakerDoubleConvexRootFindingMethod.whittakerDoubleConvexMethod(z, fz, dfz, ddfz, new Complex(1, 0));
            case 10: //Jaratt
                Complex df_combined = JarattRootFindingMethod.getDerivativeArgument(z, fz, dfz);
                df_combined = getDFz(df_combined);
                return JarattRootFindingMethod.jarattMethod(z, fz, dfz, df_combined, new Complex(1, 0));
            case 11: //Jaratt2
                df_combined = Jaratt2RootFindingMethod.getDerivativeArgument(z, fz, dfz);
                df_combined = getDFz(df_combined);
                return Jaratt2RootFindingMethod.jaratt2Method(z, fz, dfz, df_combined, new Complex(1, 0));
            case 12: // Super-halley
                return SuperHalleyRootFindingMethod.superHalleyMethod(z, fz, dfz, ddfz, new Complex(1, 0));
            case 13: //Weerakoon-F
                df_combined = WeerakoonFernandoRootFindingMethod.getDerivativeArgument(z, fz, dfz);
                df_combined = getDFz(df_combined);
                return WeerakoonFernandoRootFindingMethod.weerakoonFernandoMethod(z, fz, dfz, df_combined, new Complex(1, 0));
            case 14: //Midpoint
                df_combined = MidpointRootFindingMethod.getDerivativeArgument(z, fz, dfz);
                df_combined = getDFz(df_combined);
                return MidpointRootFindingMethod.midpointMethod(z, fz, df_combined, new Complex(1, 0));
            case 15: //Stirling
                df_combined = StirlingRootFindingMethod.getDerivativeArgument(z, fz);
                df_combined = getDFz(df_combined);
                return StirlingRootFindingMethod.stirlingMethod(z, fz, df_combined, new Complex(1, 0));
            case 16: //ThirdOrderNewton
                Complex ffz = ThirdOrderNewtonRootFindingMethod.getFunctionArgument(z, fz, dfz);
                ffz = getFz(ffz);
                return ThirdOrderNewtonRootFindingMethod.thirdOrderNewtonMethod(z, fz, dfz, ffz, new Complex(1, 0));
            case 17: //TraubOstrowski
                ffz = TraubOstrowskiRootFindingMethod.getFunctionArgument(z, fz, dfz);
                ffz = getFz(ffz);
                return TraubOstrowskiRootFindingMethod.traubOstrowskiMethod(z, fz, dfz, ffz, new Complex(1, 0));
            case 18: //Steffensen
                ffz = SteffensenRootFindingMethod.getFunctionArgument(z, fz);
                ffz = getFz(ffz);
                return SteffensenRootFindingMethod.steffensenMethod(z, fz, ffz, new Complex(1, 0));
            case 19: //Muller
                return MullerRootFindingMethod.mullerMethod(z, zold, zold2, fz, getFz(zold), getFz(zold2), new Complex(1, 0));
                //return MullerRootFindingMethod.mullerMethod(z, new Complex(), new Complex(1e-10, 0), fz, new Complex().fourth().sub(1), new Complex(1e-10, 0).fourth().sub(1), new Complex(1, 0));
            case 20: //Abbasbandy
                return AbbasbandyRootFindingMethod.abbasbandyMethod(z, fz, dfz, ddfz, dddfz, new Complex(1, 0));
            case 21: //Householder3
                return Householder3RootFindingMethod.householder3Method(z, fz, dfz, ddfz, dddfz, new Complex(1, 0));
            case 22: //CHN
                df_combined = ContraHarmonicNewtonRootFindingMethod.getDerivativeArgument(z, fz, dfz);
                df_combined = getDFz(df_combined);
                return ContraHarmonicNewtonRootFindingMethod.chnMethod(z, fz, dfz, df_combined, new Complex(1, 0));
            case 23: //Chun-Ham
                ffz = ChunHamRootFindingMethod.getFunctionArgument(z, fz, dfz);
                ffz = getFz(ffz);
                return ChunHamRootFindingMethod.chunHamMethod(z, fz, dfz, ffz, new Complex(1, 0));
            case 24: //Chun-Kim
                df_combined = ChunKimRootFindingMethod.getDerivativeArgument(z, fz, dfz);
                df_combined = getDFz(df_combined);
                return ChunKimRootFindingMethod.chunKimMethod(z, fz, dfz, df_combined, new Complex(1, 0));
            case 25: //Abbasbandy 2
                return Abbasbandy2RootFindingMethod.abbasbandy2Method(z, fz, dfz, ddfz, new Complex(1, 0));
            case 26: //Abbasbandy 3
                return Abbasbandy3RootFindingMethod.abbasbandy3Method(z, fz, dfz, ddfz, dddfz, new Complex(1, 0));
            case 27: //Changbum-Chun 1
                ffz = ChangBumChun1RootFindingMethod.getFunctionArgument(z, fz, dfz);
                ffz = getFz(ffz);
                return ChangBumChun1RootFindingMethod.changbumChun1Method(z, fz, dfz, ffz, new Complex(1, 0));
            case 28: //Euler-Chebyshev
                return EulerChebyshevRootFindingMethod.eulerChebyshevMethod(z, fz, dfz, ddfz, new Complex(1, 0));
            case 29: //Homeier1
                df_combined = Homeier1RootFindingMethod.getDerivativeArgument(z, fz, dfz);
                df_combined = getDFz(df_combined);
                return Homeier1RootFindingMethod.homeier1Method(z, fz, df_combined, new Complex(1, 0));
            case 30: // ChangBumChun2
                ffz = ChangBumChun2RootFindingMethod.getFunctionArgument(z, fz, dfz);
                ffz = getFz(ffz);
                return ChangBumChun2RootFindingMethod.changbumChun2Method(z, fz, dfz, ffz, new Complex(1, 0));
            case 31: //HSN
                Complex y = HarmonicSimpsonNewtonRootFindingMethod.getDerivativeArgument(z, fz, dfz);
                df_combined = getDFz(y);

                Complex df_combined2 = z.plus(y).times_mutable(0.5);
                df_combined2 = getDFz(df_combined2);
                return HarmonicSimpsonNewtonRootFindingMethod.hsnMethod(z, fz, dfz, df_combined, df_combined2, new Complex(1, 0));
            case 32: //EzzatiSaleki2
                ffz = EzzatiSaleki2RootFindingMethod.getFunctionArgument(z, fz, dfz);
                ffz = getFz(ffz);
                return EzzatiSaleki2RootFindingMethod.ezzatiSaleki2Method(z, fz, dfz, ffz, new Complex(1, 0));
            case 33: //Homeier2
                df_combined = Homeier2RootFindingMethod.getDerivativeArgument(z, fz, dfz);
                df_combined = getDFz(df_combined);
                return Homeier2RootFindingMethod.homeier2Method(z, fz, dfz, df_combined, new Complex(1, 0));
            case 34: //KimChun
                df_combined = KimChunRootFindingMethod.getDerivativeArgument(z, fz, dfz);
                df_combined = getDFz(df_combined);
                return KimChunRootFindingMethod.kimChunMethod(z, fz, dfz, df_combined, new Complex(1, 0));
            case 35: //King3
                ffz = King3RootFindingMethod.getFunctionArgument(z, fz, dfz);
                ffz = getFz(ffz);
                return King3RootFindingMethod.king3Method(z, fz, dfz, ffz, new Complex(1, 0));
            case 36: //KouLiWang1
                ffz = KouLiWang1RootFindingMethod.getFunctionArgument(z, fz, dfz);
                ffz = getFz(ffz);
                return KouLiWang1RootFindingMethod.kouLiWang1Method(z, fz, dfz, ffz, new Complex(1, 0));
            case 37: //Maheshweri
                ffz = MaheshweriRootFindingMethod.getFunctionArgument(z, fz, dfz);
                ffz = getFz(ffz);
                return MaheshweriRootFindingMethod.maheshweriMethod(z, fz, dfz, ffz, new Complex(1, 0));
            case 38: //Nedzhibov
                y = NedzhibovRootFindingMethod.getDerivativeArgument(z, fz, dfz);
                df_combined = getDFz(y);
                df_combined2 = z.plus(y).times_mutable(0.5);
                df_combined2 = getDFz(df_combined2);
                return NedzhibovRootFindingMethod.nedzhibovMethod(z, fz, dfz, df_combined, df_combined2, new Complex(1, 0));
            case 39: //Popovski1
                return Popovski1RootFindingMethod.popovski1Method(z, fz, dfz, ddfz, new Complex(1, 0));
            case 40: //Rafis-Rafiullah
                Complex ddf_combined = RafisRafiullahRootFindingMethod.getSecondDerivativeArgument(z, fz, dfz);
                ddf_combined = getDDFz(ddf_combined);
                return RafisRafiullahRootFindingMethod.rafisRafiullahMethod(z, fz, dfz, ddfz, ddf_combined, new Complex(1, 0));
            case 41: // Rafiullah1
                df_combined = Rafiullah1RootFindingMethod.getDerivativeArgument(z, fz, dfz);
                df_combined = getDFz(df_combined);
                return Rafiullah1RootFindingMethod.rafiullah1Method(z, fz, dfz, df_combined, new Complex(1, 0));
            case 42: //Simpson-Newton
                y = SimpsonNewtonRootFindingMethod.getDerivativeArgument(z, fz, dfz);
                df_combined = getDFz(y);
                df_combined2 = z.plus(y).times_mutable(0.5);
                df_combined2 = getDFz(df_combined2);
                return SimpsonNewtonRootFindingMethod.simpsonNewtonMethod(z, fz, dfz, df_combined, df_combined2, new Complex(1, 0));

            case 43: //ChangBumChun3
                y = ChangBumChun3RootFindingMethod.getFunctionAndDerivativeArgument(z, fz, dfz);
                df_combined = getDFz(y);
                ffz = getFz(y);
                return ChangBumChun3RootFindingMethod.changbumChun3Method(z, fz, dfz, ffz, df_combined, new Complex(1, 0));
            case 44: //EzzatiSaleki1
                y = EzzatiSaleki1RootFindingMethod.getFunctionAndDerivativeArgument(z, fz, dfz);
                df_combined = getDFz(y);
                ffz = getFz(y);
                return EzzatiSaleki1RootFindingMethod.ezzatiSaleki1Method(z, fz, dfz, ffz, df_combined, new Complex(1, 0));
            case 45: //Feng
                y = FengRootFindingMethod.getFunctionAndDerivativeArgument(z, fz, dfz);
                df_combined = getDFz(y);
                ffz = getFz(y);
                return FengRootFindingMethod.fengMethod(z, fz, dfz, ffz, df_combined, new Complex(1, 0));
            case 46: //King1
                y = King1RootFindingMethod.getFunctionAndDerivativeArgument(z, fz, dfz);
                df_combined = getDFz(y);
                ffz = getFz(y);
                return King1RootFindingMethod.king1Method(z, fz, dfz, ffz, df_combined, new Complex(1, 0));
            case 47: //Noor-Gupta
                y = NoorGuptaRootFindingMethod.getFunctionAndDerivativeArgument(z, fz, dfz);
                df_combined = getDFz(y);
                ffz = getFz(y);
                return NoorGuptaRootFindingMethod.noorGuptaMethod(z, fz, dfz, ffz, df_combined, new Complex(1, 0));


        }


        return null;
    }

    public static void main(String[] args) {

        Complex[] vals = new Complex[100000];
        Random rand = new Random(123);

        int[] methods = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47};

        for(int i = 0; i < vals.length; i++) {
            double signRe = rand.nextDouble() >= 0.5 ? -1 : 1;
            double signIm = rand.nextDouble() >= 0.5 ? -1 : 1;
            vals[i] = new Complex(rand.nextDouble() * signRe * 3, rand.nextDouble() * signIm * 3);
        }

        Complex[][] resultsPerMethod = new Complex[methods.length][vals.length];
        for(int j = 0; j < methods.length; j++) {
            for (int i = 0; i < vals.length; i++) {
                resultsPerMethod[j][i] = getNextIterationForMethod(new Complex(vals[i]), j, new Complex(1e-10, 0), new Complex());
            }
        }

        int[][] methodSimilarities = new int[methods.length][methods.length];
        for (int i = 0; i < vals.length; i++) {
            for(int j = 0; j < methods.length; j++) {
                for(int k = j + 1; k < methods.length; k++) {

                    if(resultsPerMethod[j][i].isNaN() || resultsPerMethod[j][i].isInfinite())
                    {
                        //System.out.println("Skipping: " + resultsPerMethod[j][i]);
                        continue;
                    }

                    if(resultsPerMethod[k][i].isNaN() || resultsPerMethod[k][i].isInfinite())
                    {
                        //System.out.println("Skipping: " + resultsPerMethod[k][i]);
                        continue;
                    }

                    if(resultsPerMethod[j][i].distance(resultsPerMethod[k][i]) < epsilon) {
                        //System.out.println("Found similarity for method " + j + " and method " + k + " for value " + resultsPerMethod[j][i]);
                        methodSimilarities[j][k] = methodSimilarities[k][j] = methodSimilarities[k][j] + 1;
                    }
                }
            }
        }

        for(int i = 0; i < methodSimilarities.length; i++) {
            for(int j = i + 1; j < methodSimilarities.length; j++) {
                double percentage = (double)methodSimilarities[i][j] / vals.length * 100;
                if(percentage > 2) {
                    System.out.println("Similarity of " + String.format("%3d", i) + " with " + String.format("%3d", j) +": " + String.format("%6.2f", percentage) + "%");
                }
            }
        }

        double size = 6;
        double height_ratio = 1;
        int image_size = 600;

        double size_2_x = size * 0.5;
        double size_2_y = (size * height_ratio) * 0.5;
        double temp_size_image_size_x = size / image_size;
        double temp_size_image_size_y = (size * height_ratio) / image_size;
        double xCenter = 0;
        double yCenter = 0;

        double temp_xcenter_size = xCenter - size_2_x;
        double temp_ycenter_size = yCenter + size_2_y;

        int[] default_palette = {-16774636, -16510682, -16246472, -15982517, -15718307, -15454353, -15190398, -14860652, -14596442, -14332487, -14068277, -13804323, -13474576, -13673506, -13806644, -14005318, -14138456, -14337130, -14470267, -14668941, -14802079, -15000753, -15133891, -15332565, -15465702, -14350567, -13169639, -12054248, -10873320, -9758185, -8642793, -7461866, -6280938, -5165803, -3984875, -2869484, -1688556, -2869485, -3984622, -5099759, -6214896, -7330033, -8445170, -9560563, -10675700, -11790837, -12905974, -14021111, -15136247, -14018808, -12901369, -11783674, -10666234, -9548795, -8431356, -7313661, -6196221, -5078526, -3961087, -2843648, -1660416, -2842880, -3959807, -5142270, -6259197, -7441660, -8558332, -9740795, -10857722, -12040185, -13157112, -14339575, -15456246, -15586039, -15715832, -15780089, -15909882, -16039675, -16103931, -16233724, -16363517, -16427774, -16557567, -16687360, -16751616, -16753664, -16755455, -16691966, -16693757, -16630268, -16632060, -16634107, -16570362, -16572409, -16508664, -16510711, -16446966, -15331573, -14216179, -13100785, -11985392, -10869998, -9754604, -8639467, -7523817, -6408423, -5293030, -4177636, -2996706, -3653601, -4310495, -4967389, -5624284, -6281178, -6937816, -7594711, -8251605, -8908499, -9565394, -10287824, -10878926, -10418377, -9892035, -9431485, -8905143, -8444593, -7918507, -7457702, -6931360, -6470810, -5944468, -5483918, -4957576, -5942159, -6926742, -7911324, -8895907, -9880490, -10864816, -11849399, -12833982, -13818564, -14803147, -15787730, -16772056, -16639947, -16442302, -16310192, -16112547, -15980438, -15848073, -15650427, -15452782, -15320672, -15123027, -14990918, -14793016, -14990919, -15123286, -15321189, -15453556, -15651459, -15783826, -15981729, -16114096, -16311999, -16444366, -16642525};

        for(int j = 0; j < methods.length; j++) {

            BufferedImage image = new BufferedImage(image_size, image_size, BufferedImage.TYPE_INT_ARGB);
            for(int y = 0; y < image_size; y++) {
                for (int x = 0, loc = y * image_size + x; x < image_size; x++, loc++) {
                    boolean escaped = false;
                    Complex zold = new Complex();
                    Complex c = new Complex(temp_xcenter_size + temp_size_image_size_x * x, temp_ycenter_size - temp_size_image_size_y * y);
                    Complex z_1 = new Complex(1e-10, 0);
                    Complex z_2 = new Complex();

                    int iteration = 0;
                    for(iteration = 0; iteration < 1000; iteration++) {

                        if(c.distance_squared(zold) < 1e-8 && iteration > 0) {
                            escaped = true;
                            break;
                        }
                        zold.assign(c);
                        c = getNextIterationForMethod(c, j, z_1, z_2);

                    }

                    if(escaped) {
                        image.setRGB(x, y, default_palette[iteration % default_palette.length]);
                    }
                    else {
                        image.setRGB(x, y, Color.black.getRGB());
                    }
                }
            }

            File outputfile = new File("rootfinding-images/method" + j + ".png");
            try {
                ImageIO.write(image, "png", outputfile);
            }
            catch (Exception ex) {}
        }
    }
}
