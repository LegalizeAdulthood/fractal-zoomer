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
package fractalzoomer.main;

import org.apfloat.Apint;

import java.awt.*;

/**
 *
 * @author hrkalona2
 */
public interface Constants {
    public static final int VERSION = 1090;
    public static final boolean beta = false;
    public static final int TOTAL_PALETTES = 45;
    public static final int TOTAL_INCOLORING_ALGORITHMS = 11;
    public static final int TOTAL_OUTCOLORING_ALGORITHMS = 25;
    public static final int TOTAL_BAILOUT_CONDITIONS = 13;
    public static final int TOTAL_CONVERGENT_BAILOUT_CONDITIONS = 6;
    public static final int TOTAL_PLANES = 66;
    public static final int TOTAL_FUNCTIONS = 514;
    public static final int TOTAL_FILTERS = 35;
    public static final int TOTAL_COLOR_TRANSFER_FILTERS = 8;
    public static final int TOTAL_COLOR_BLENDING = 30;
    public static final int TOTAL_POST_PROCESS_ALGORITHMS = 11;
    public static final int TOTAL_FUNCTION_FILTERS = 10;
    public static final int TOTAL_PLANE_INFLUENCES = 3;

    public static final int MAX_ITERATIONS_NUMBER = Integer.MAX_VALUE;

    public static final String SA_CALCULATION_STR = "SA Calculation:";

    public static final String NANOMB1_CALCULATION_STR = "Nanomb1 Calculation:";
    public static final String BLA_CALCULATION_STR = "BLA Calculation:";

    public static final String BLA_CALCULATION_STR2 = "BLA Calculation";
    public static final String REFERENCE_CALCULATION_STR = "Reference Calculation:";
    
    public static final String[] domainAlgNames = {"Black Grid, White Circles log2", "White Grid, Black Circles log2", "Black Grid", "White Grid", "Black Grid, Bright Contours log2", "White Grid, Dark Contours log2", "Norm, Black Grid, White Circles log2", "Norm, White Grid, Black Circles log2", "Norm, Black Grid", "Norm, White Grid", "Norm, Black Grid, Bright Contours log2", "Norm, White Grid, Dark Contours log2", "White Circles log2", "Black Circles log2", "Bright Contours log2", "Dark Contours log2", "Norm, White Circles log2", "Norm, Black Circles log2", "Norm, Bright Contours log2", "Norm, Dark Contours log2",
    "Black Grid, Contours log2, Iso-Argument lines", "Norm, Black Grid, Contours log2, Iso-Argument lines", "Black Grid, Iso-Argument Contours", "Norm, Black Grid, Iso-Argument Contours", "Iso-Argument Contours, Contours log2", "Norm, Iso-Argument Contours, Contours log2",
    "Grid Contours, Iso-Argument Lines", "Norm, Grid Contours, Iso-Argument Lines"};
    public static final String[] waveTypes = {"Sine", "Sawtooth", "Triangle", "Noise"};
    public static final String[] bumpTransferNames = {"1.5 / (x * factor + 1.5)", "1 / sqrt(x * factor + 1)", "1 / cbrt(x * factor + 1)", "2^(-x * factor)"};
    public static final String[] color_interp_str = {"Linear", "Cosine", "Acceleration", "Deceleration", "Exponential", "Catmull-Rom", "Catmull-Rom 2", "Sigmoid", "Quadratic", "Cubic", "Sqrt Values", "Sine", "Square Root", "3rd Degree Poly", "5th Degree Poly", "Exponential 2", "Cube Root", "Fourth Root", "Smooth Transition", "Quarter Sine"};
    public static final String[] bumpProcessingMethod = {"RGB Scaling", "Blending", "Blending Alternative", "Lab", "HSB", "HSL", "OKLab"};
    public static final String[] entropyMethod = {"Palette Coloring", "Gradient Coloring"};
    public static final String[] rainbowMethod = {"Palette Coloring", "Gradient Coloring"};

    public static final String[] differencesMethod = {"Traditional", "Forward 3x3", "Central 3x3", "Diagonal 2x2", "Least Squares 2x2", "Least Squares 3x3", "Laplacian 3x3"};
    public static final String[] domainColors = {"Argument", "Norm", "Re", "Im"};
    public static final String[] domainShading = {"Norm", "Re", "Im"};
    public static final String[] domainShadingColor = {"Saturation/Lightness", "White/Black Scaling"};
    public static final String[] domainContours = {"Norm", "Iso-Argument", "Norm, Iso-Argument", "Grid", "Grid, Norm", "Grid, Iso-Argument", "Grid, Norm, Iso-Argument", "Grid Lines", "Circles Lines", "Iso-Arg Lines", "Grid Lines, Circles Lines", "Circles Lines, Iso-Arg Lines"};
    public static final String[] argumentLinesDistance = {"2 * pi", "pi", "pi / 2", "pi / 4", "pi / 6", "pi / 8", "pi / 10", "pi / 12", "pi / 14", "pi / 16"};
    public static final String[] orbitTrapsNames = {"Point", "Point Square", "Point Rhombus", "Point N-Norm", "Cross", "Re", "Im", "Circle", "Square", "Rhombus", "N-Norm", "Circle/Cross", "Square/Cross", "Rhombus/Cross", "N-Norm/Cross", "Circle/Point", "Square/Point", "Rhombus/Point", "N-Norm/Point", "N-Norm/Point N-Norm", "Golden Ratio Spiral", "Golden Ratio Spiral/Point", "Golden Ratio Spiral/Point N-Norm", "Golden Ratio Spiral/Cross", "Golden Ratio Spiral/Circle", "Golden Ratio Spiral/Square", "Golden Ratio Spiral/Rhombus", "Golden Ratio Spiral/N-Norm", "Stalks", "Stalks/Point", "Stalks/Point N-Norm", "Stalks/Cross", "Stalks/Circle", "Stalks/Square", "Stalks/Rhombus", "Stalks/N-Norm", "Image Based", "Atom Domain Circle", "Atom Domain Square", "Atom Domain Rhombus", "Atom Domain N-Norm", "Teardrop", "Super-Formula", "Image (Transparent) Based"};
    public static final String[] orbitTrapLineTypes = {"Line", "Sin", "Cos", "Tan", "Sinh", "Cosh", "Tanh", "Asin", "Acos", "Atan", "Square", "Cube", "Sqrt", "Cbrt", "Exp", "Log", "Abs" };
    public static final String[] orbitTrapCheckTypes = {"Minimum Distance", "Trapped First", "Trapped Last"};
    public static final String[] contourColorAlgorithmNames = {"Non-smooth Transitions", "Smooth Transitions", "Boundaries", "Boundaries/Non-Smooth Colors (Deprecated)"};
    public static final String[] circleAndGridFadeNames = {"Square Root", "Cube Root", "Fourth Root", "Linear", "Saturate", "Cosine", "Square", "Sine", "Deceleration", "3rd Degree Poly", "5th Degree Poly", "Exponential", "Smooth Transition", "Quarter Sine"};
    public static final String[] colorMethod = {"Lab", "HSB", "HSL", "Blending", "RGB Scaling", "OKLab"};
    public static final String[] fractionalTransfer = {"x", "1 - (2*x - 1)^2", "(2*x - 1)^2 - 1", "1 - (2*x - 1)^4", "(2*x - 1)^4 - 1", "sin(x*pi)", "-sin(x*pi)", "Triangle", "- Triangle", "0.5 - 0.5*cos(2*x*pi)", "-0.5 + 0.5*cos(2*x*pi)", "Sqrt Triangle", "- Sqrt Triangle"};
    public static final String[] fractionalTransferMode = {"0 → 1 → 0", "0 → 1"};
    public static final String[] isoColorType = {"Selected", "Gradient", "Argument"};
    public static final String[] circleColorType = {"Selected", "Gradient", "!= 1"};
    public static final String[] gridColorType = {"Selected", "Gradient"};
    public static final String[] smoothingFractionalTransfer = {"x", "1 - x", "1 - (2*x - 1)^2", "(2*x - 1)^2", "1 - (2*x - 1)^4", "(2*x - 1)^4", "sin(x*pi)", "1 - sin(x*pi)", "Triangle", "1 - Triangle", "0.5 - 0.5*cos(2*x*pi)", "0.5 + 0.5*cos(2*x*pi)", "Sqrt Triangle", "1 - Sqrt Triangle"};
    public static final String[] lightTransfer = {"x * factor", "sqrt(x * factor)", "(x * factor)^2"};
    public static final String[] lightModes = {"Mode 1", "Mode 2", "Mode 3"};
    public static final String[] reflectionModes = {"Point", "Windows", "Windows 2", "Arch Windows", "Arch Windows 2", "Gothic Windows", "Round Windows", "Round Windows 2", "Round Windows 3", "Windows Door"};

    public static final String[] jitterShape = {"Uniform", "Gaussian"};

    public static final String[] FadeAlgs = {"Linear", "Square Root", "Cube Root", "Fourth Root", "Cosine", "Square", "Sine", "Deceleration", "3rd Degree Poly", "5th Degree Poly", "Exponential", "Smooth Transition", "Quarter Sine"};
    public static final String[] statisticalColoringName = {"Stripe Average(Sum)", "Curvature Average(Sum)", "Triangle Inequality Average(Sum)", "cos(density * arg(z)) / norm(z) Average(Sum)", "cos(density * (arg(z - p) + pi)) / (factor + 1 / norm(z - p)) Sum", "Atom Domain (bof60/bof61)", "Discrete Lagrangian Descriptors", "Twin Lamps", "Checkers"};
    public static final String[] domainProcessingTransferNames = {"x * factor", "1 / (x * factor)"};
    public static final String[] domainHeightNames = {"Norm", "Re", "Im", "Re + Im"};

    public static final String[] domainNormalization = {"No", "Poles/Zeros"};
    public static final String[] inertiaGravityPullFunction = {"Exponential", "Linear", "Oddball"};
    public static final String[] reductionMethod = {"sum", "min", "max", "assign", "sub", "multiply"};
    public static final String[] trueColorModes = {"Xaos true color 1", "Xaos true color 2", "Xaos true color 3", "Xaos true color 4", "Xaos true color 5", "Xaos true color 6", "Xaos true color 7", "Xaos true color 8", "Xaos true color 9", "Xaos true color 10"};
    public static final String[] trueColorSpaces = {"RGB", "XYZ", "HSB", "HSL", "RYB", "Lab", "LCH_ab", "Palette", "Gradient", "Direct", "HWB", "HSL_uv", "LCH_uv", "LCH_oklab"};
    public static final String[] derivativeMethod = {"Provided", "Numerical Forward", "Numerical Central", "Numerical Backward"};
    public static final String[] gridAlgorithms = {"sin", "mod"};
    public static final String[] combineAlgorithms = {"Multiply", "Average"};
    public static final String[] trapHeightAlgorithms = {"Linear", "Cosine", "Square Root", "Exponential", "Cube Root", "Fourth Root", "Square", "Sine", "Deceleration", "3rd Degree Poly", "5th Degree Poly", "Smooth Transition", "Quarter Sine"};
    public static final String[] novaMethods = {"Newton Method", "Halley Method", "Schroder Method", "Householder Method", "Secant Method", "Steffensen Method", "Muller Method", "Parhalley Method", "Laguerre Method", "Newton-Hines Method", "Whittaker Method", "Whittaker Double Convex Method", "Super Halley Method",  "Midpoint Method", "Traub-Ostrowski Method", "Stirling Method", "Jaratt Method", "Jaratt 2 Method", "Weerakoon-Fernando Method", "Third Order Newton Method", "Abbasbandy Method", "Householder3 Method", "Contra Harmonic Newton", "Chun-Ham", "Chun-Kim", "Euler-Chebyshev Method", "Ezzati-Saleki 2 Method", "Homeier Method", "Abbasbandy 2 Method", "Abbasbandy 3 Method", "Popovski Method", "Changbum-Chun Method", "Changbum-Chun 2 Method", "King 3 Method", "Homeier 2 Method", "Kou-Li-Wang Method", "Kim-Chun Method", "Maheshweri Method", "Rafiullah Method", "Rafis-Rafiuallah Method", "Changbum-Chun 3 Method", "Ezzati-Saleki Method", "Feng Method", "King Method"
    , "Noor-Gupta Method", "Harmonic-Simpson-Newton Method", "Nedzhibov Method", "Simpson-Newton Method"};
    public static final String[] rootInitializationMethod = {"(a^i) * z", "z's circle", "z * cos(a * i)", "z * e^(a * i)"};
    public static final String[] equicontinuityColorMethods = {"HSL", "HSB", "LCH_ab", "Arg-Palette", "Palette"};
    public static final String[] equicontinuityArgs = {"Final Z value", "Start Z value", "Pixel Value", "C Value"};
    public static final String[] normalMapColoringMethods = {"Original Color", "Rainbow Palette", "Distance Estimator", "Distance Estimator Variation"};
    public static final String[] rootShadingFunction = {"Linear", "Square Root", "Cube Root", "Cosine", "Exponential", "Constant", "Square", "Sine", "Deceleration", "3rd Degree Poly", "5th Degree Poly", "Fourth Root", "Smooth Transition", "Quarter Sine"};
    public static final String[] twinLampsFunction = {"Linear", "Sqrt"};
    public static final String[] langNormTypes = {"Norm Squared", "Norm", "Rhombus-Norm", "Square-Norm", "N-Norm"};
    public static final String[] atomNormTypes = {"Norm", "Rhombus-Norm", "Square-Norm", "N-Norm"};
    public static final String[] histogramMapping = {"Histogram", "Linear", "Square Root", "Cube Root", "Fourth Root", "Logarithmic", "Rank Order"};

    public static final String[] generatedPalettes = {"Multiwave: default", "Multiwave: g_spdz2", "Multiwave: g_spdz2_custom", "IQ: A + B * cos(2 * pi * (C * t + D) + G)"};
    /**
     * ** FUNCTION ***
     */
    public static final int MANDELBROT = 0;
    public static final int MANDELBROTCUBED = 1;
    public static final int MANDELBROTFOURTH = 2;
    public static final int MANDELBROTFIFTH = 3;
    public static final int MANDELBROTSIXTH = 4;
    public static final int MANDELBROTSEVENTH = 5;
    public static final int MANDELBROTEIGHTH = 6;
    public static final int MANDELBROTNINTH = 7;
    public static final int MANDELBROTTENTH = 8;
    public static final int MANDELBROTNTH = 9;
    public static final int LAMBDA = 10;
    public static final int MAGNET1 = 11;
    public static final int MAGNET2 = 12;
    public static final int NEWTON3 = 13;
    public static final int NEWTON4 = 14;
    public static final int NEWTONGENERALIZED3 = 15;
    public static final int NEWTONGENERALIZED8 = 16;
    public static final int NEWTONSIN = 17;
    public static final int NEWTONCOS = 18;
    public static final int NEWTONPOLY = 19;
    public static final int BARNSLEY1 = 20;
    public static final int BARNSLEY2 = 21;
    public static final int BARNSLEY3 = 22;
    public static final int MANDELBAR = 23;
    public static final int SPIDER = 24;
    public static final int PHOENIX = 25;
    public static final int SIERPINSKI_GASKET = 26;
    public static final int HALLEY3 = 27;
    public static final int HALLEY4 = 28;
    public static final int HALLEYGENERALIZED3 = 29;
    public static final int HALLEYGENERALIZED8 = 30;
    public static final int HALLEYSIN = 31;
    public static final int HALLEYCOS = 32;
    public static final int HALLEYPOLY = 33;
    public static final int SCHRODER3 = 34;
    public static final int SCHRODER4 = 35;
    public static final int SCHRODERGENERALIZED3 = 36;
    public static final int SCHRODERGENERALIZED8 = 37;
    public static final int SCHRODERSIN = 38;
    public static final int SCHRODERCOS = 39;
    public static final int SCHRODERPOLY = 40;
    public static final int HOUSEHOLDER3 = 41;
    public static final int HOUSEHOLDER4 = 42;
    public static final int HOUSEHOLDERGENERALIZED3 = 43;
    public static final int HOUSEHOLDERGENERALIZED8 = 44;
    public static final int HOUSEHOLDERSIN = 45;
    public static final int HOUSEHOLDERCOS = 46;
    public static final int HOUSEHOLDERPOLY = 47;
    public static final int SECANT3 = 48;
    public static final int SECANT4 = 49;
    public static final int SECANTGENERALIZED3 = 50;
    public static final int SECANTGENERALIZED8 = 51;
    public static final int SECANTCOS = 52;
    public static final int SECANTPOLY = 53;
    public static final int STEFFENSEN3 = 54;
    public static final int STEFFENSEN4 = 55;
    public static final int STEFFENSENGENERALIZED3 = 56;
    public static final int MANDELPOLY = 57;
    public static final int MANOWAR = 58;
    public static final int FROTHY_BASIN = 59;
    public static final int MANDELBROTWTH = 60;
    public static final int SZEGEDI_BUTTERFLY1 = 61;
    public static final int SZEGEDI_BUTTERFLY2 = 62;
    public static final int NOVA = 63;
    public static final int EXP = 64;
    public static final int LOG = 65;
    public static final int SIN = 66;
    public static final int COS = 67;
    public static final int TAN = 68;
    public static final int COT = 69;
    public static final int SINH = 70;
    public static final int COSH = 71;
    public static final int TANH = 72;
    public static final int COTH = 73;
    public static final int FORMULA1 = 74;
    public static final int FORMULA2 = 75;
    public static final int FORMULA3 = 76;
    public static final int FORMULA4 = 77;
    public static final int FORMULA5 = 78;
    public static final int FORMULA6 = 79;
    public static final int FORMULA7 = 80;
    public static final int FORMULA8 = 81;
    public static final int FORMULA9 = 82;
    public static final int FORMULA10 = 83;
    public static final int FORMULA11 = 84;
    public static final int FORMULA12 = 85;
    public static final int FORMULA13 = 86;
    public static final int FORMULA14 = 87;
    public static final int FORMULA15 = 88;
    public static final int FORMULA16 = 89;
    public static final int FORMULA17 = 90;
    public static final int FORMULA18 = 91;
    public static final int FORMULA19 = 92;
    public static final int FORMULA20 = 93;
    public static final int FORMULA21 = 94;
    public static final int FORMULA22 = 95;
    public static final int FORMULA23 = 96;
    public static final int FORMULA24 = 97;
    public static final int FORMULA25 = 98;
    public static final int FORMULA26 = 99;
    public static final int FORMULA27 = 100;
    public static final int FORMULA28 = 101;
    public static final int FORMULA29 = 102;
    public static final int FORMULA30 = 103;
    public static final int FORMULA31 = 104;
    public static final int FORMULA32 = 105;
    public static final int FORMULA33 = 106;
    public static final int FORMULA34 = 107;
    public static final int FORMULA35 = 108;
    public static final int FORMULA36 = 109;
    public static final int FORMULA37 = 110;
    public static final int FORMULA38 = 111;
    public static final int FORMULA39 = 112;
    public static final int USER_FORMULA = 113;
    public static final int USER_FORMULA_ITERATION_BASED = 114;
    public static final int USER_FORMULA_CONDITIONAL = 115;
    public static final int FORMULA40 = 116;
    public static final int FORMULA41 = 117;
    public static final int FORMULA42 = 118;
    public static final int FORMULA43 = 119;
    public static final int FORMULA44 = 120;
    public static final int FORMULA45 = 121;
    public static final int FORMULA46 = 122;
    public static final int NEWTONFORMULA = 123;
    public static final int HALLEYFORMULA = 124;
    public static final int SCHRODERFORMULA = 125;
    public static final int HOUSEHOLDERFORMULA = 126;
    public static final int SECANTFORMULA = 127;
    public static final int STEFFENSENFORMULA = 128;
    public static final int STEFFENSENPOLY = 129;
    public static final int COUPLED_MANDELBROT = 130;
    public static final int COUPLED_MANDELBROT_BURNING_SHIP = 131;
    public static final int USER_FORMULA_COUPLED = 132;
    public static final int MULLER3 = 133;
    public static final int MULLER4 = 134;
    public static final int MULLERGENERALIZED3 = 135;
    public static final int MULLERGENERALIZED8 = 136;
    public static final int MULLERSIN = 137;
    public static final int MULLERCOS = 138;
    public static final int MULLERPOLY = 139;
    public static final int MULLERFORMULA = 140;
    public static final int PARHALLEY3 = 141;
    public static final int PARHALLEY4 = 142;
    public static final int PARHALLEYGENERALIZED3 = 143;
    public static final int PARHALLEYGENERALIZED8 = 144;
    public static final int PARHALLEYSIN = 145;
    public static final int PARHALLEYCOS = 146;
    public static final int PARHALLEYPOLY = 147;
    public static final int PARHALLEYFORMULA = 148;
    public static final int LAGUERRE3 = 149;
    public static final int LAGUERRE4 = 150;
    public static final int LAGUERREGENERALIZED3 = 151;
    public static final int LAGUERREGENERALIZED8 = 152;
    public static final int LAGUERRESIN = 153;
    public static final int LAGUERRECOS = 154;
    public static final int LAGUERREPOLY = 155;
    public static final int LAGUERREFORMULA = 156;
    public static final int KLEINIAN = 157;
    public static final int LAMBDA2 = 158;
    public static final int LAMBDA3 = 159;
    public static final int GENERIC_CaZbdZe = 160;
    public static final int DURAND_KERNER3 = 161;
    public static final int DURAND_KERNER4 = 162;
    public static final int DURAND_KERNERGENERALIZED3 = 163;
    public static final int DURAND_KERNERGENERALIZED8 = 164;
    public static final int DURAND_KERNERPOLY = 165;
    public static final int MAGNETIC_PENDULUM = 166;
    public static final int LYAPUNOV = 167;
    public static final int BAIRSTOW3 = 168;
    public static final int BAIRSTOW4 = 169;
    public static final int BAIRSTOWGENERALIZED3 = 170;
    public static final int BAIRSTOWGENERALIZED8 = 171;
    public static final int BAIRSTOWPOLY = 172;
    public static final int USER_FORMULA_NOVA = 173;
    public static final int GENERIC_CpAZpBC = 174;
    public static final int INERTIA_GRAVITY = 175;
    public static final int LAMBDA_FN_FN = 176;
    public static final int MANDEL_NEWTON = 177;
    public static final int LAMBERT_W_VARIATION = 178;
    public static final int NEWTON_HINES3 = 179;
    public static final int NEWTON_HINES4 = 180;
    public static final int NEWTON_HINESGENERALIZED3 = 181;
    public static final int NEWTON_HINESGENERALIZED8 = 182;
    public static final int NEWTON_HINESSIN = 183;
    public static final int NEWTON_HINESCOS = 184;
    public static final int NEWTON_HINESPOLY = 185;
    public static final int NEWTON_HINESFORMULA = 186;
    public static final int WHITTAKER3 = 187;
    public static final int WHITTAKER4 = 188;
    public static final int WHITTAKERGENERALIZED3 = 189;
    public static final int WHITTAKERGENERALIZED8 = 190;
    public static final int WHITTAKERSIN = 191;
    public static final int WHITTAKERCOS = 192;
    public static final int WHITTAKERPOLY = 193;
    public static final int WHITTAKERFORMULA = 194;
    public static final int WHITTAKERDOUBLECONVEX3 = 195;
    public static final int WHITTAKERDOUBLECONVEX4 = 196;
    public static final int WHITTAKERDOUBLECONVEXGENERALIZED3 = 197;
    public static final int WHITTAKERDOUBLECONVEXGENERALIZED8 = 198;
    public static final int WHITTAKERDOUBLECONVEXSIN = 199;
    public static final int WHITTAKERDOUBLECONVEXCOS = 200;
    public static final int WHITTAKERDOUBLECONVEXPOLY = 201;
    public static final int WHITTAKERDOUBLECONVEXFORMULA = 202;
    public static final int SUPERHALLEY3 = 203;
    public static final int SUPERHALLEY4 = 204;
    public static final int SUPERHALLEYGENERALIZED3 = 205;
    public static final int SUPERHALLEYGENERALIZED8 = 206;
    public static final int SUPERHALLEYSIN = 207;
    public static final int SUPERHALLEYCOS = 208;
    public static final int SUPERHALLEYPOLY = 209;
    public static final int SUPERHALLEYFORMULA = 210;
    public static final int TRAUB_OSTROWSKI3 = 211;
    public static final int TRAUB_OSTROWSKI4 = 212;
    public static final int TRAUB_OSTROWSKIGENERALIZED3 = 213;
    public static final int TRAUB_OSTROWSKIGENERALIZED8 = 214;
    public static final int TRAUB_OSTROWSKISIN = 215;
    public static final int TRAUB_OSTROWSKICOS = 216;
    public static final int TRAUB_OSTROWSKIPOLY = 217;
    public static final int TRAUB_OSTROWSKIFORMULA = 218;
    public static final int STIRLING3 = 219;
    public static final int STIRLING4 = 220;
    public static final int STIRLINGGENERALIZED3 = 221;
    public static final int STIRLINGGENERALIZED8 = 222;
    public static final int STIRLINGSIN = 223;
    public static final int STIRLINGCOS = 224;
    public static final int STIRLINGPOLY = 225;
    public static final int STIRLINGFORMULA = 226;
    public static final int MIDPOINT3 = 227;
    public static final int MIDPOINT4 = 228;
    public static final int MIDPOINTGENERALIZED3 = 229;
    public static final int MIDPOINTGENERALIZED8 = 230;
    public static final int MIDPOINTSIN = 231;
    public static final int MIDPOINTCOS = 232;
    public static final int MIDPOINTPOLY = 233;
    public static final int MIDPOINTFORMULA = 234;
    public static final int ABERTH_EHRLICH3 = 235;
    public static final int ABERTH_EHRLICH4 = 236;
    public static final int ABERTH_EHRLICHGENERALIZED3 = 237;
    public static final int ABERTH_EHRLICHGENERALIZED8 = 238;
    public static final int ABERTH_EHRLICHPOLY = 239;
    public static final int JARATT3 = 240;
    public static final int JARATT4 = 241;
    public static final int JARATTGENERALIZED3 = 242;
    public static final int JARATTGENERALIZED8 = 243;
    public static final int JARATTSIN = 244;
    public static final int JARATTCOS = 245;
    public static final int JARATTPOLY = 246;
    public static final int JARATTFORMULA = 247;
    public static final int JARATT23 = 248;
    public static final int JARATT24 = 249;
    public static final int JARATT2GENERALIZED3 = 250;
    public static final int JARATT2GENERALIZED8 = 251;
    public static final int JARATT2SIN = 252;
    public static final int JARATT2COS = 253;
    public static final int JARATT2POLY = 254;
    public static final int JARATT2FORMULA = 255;
    public static final int THIRDORDERNEWTON3 = 256;
    public static final int THIRDORDERNEWTON4 = 257;
    public static final int THIRDORDERNEWTONGENERALIZED3 = 258;
    public static final int THIRDORDERNEWTONGENERALIZED8 = 259;
    public static final int THIRDORDERNEWTONSIN = 260;
    public static final int THIRDORDERNEWTONCOS = 261;
    public static final int THIRDORDERNEWTONPOLY = 262;
    public static final int THIRDORDERNEWTONFORMULA = 263;
    public static final int WEERAKOON_FERNANDO3 = 264;
    public static final int WEERAKOON_FERNANDO4 = 265;
    public static final int WEERAKOON_FERNANDOGENERALIZED3 = 266;
    public static final int WEERAKOON_FERNANDOGENERALIZED8 = 267;
    public static final int WEERAKOON_FERNANDOSIN = 268;
    public static final int WEERAKOON_FERNANDOCOS = 269;
    public static final int WEERAKOON_FERNANDOPOLY = 270;
    public static final int WEERAKOON_FERNANDOFORMULA = 271;

    public static final int HOUSEHOLDER33 = 272;
    public static final int HOUSEHOLDER34 = 273;
    public static final int HOUSEHOLDER3GENERALIZED3 = 274;
    public static final int HOUSEHOLDER3GENERALIZED8 = 275;
    public static final int HOUSEHOLDER3SIN = 276;
    public static final int HOUSEHOLDER3COS = 277;
    public static final int HOUSEHOLDER3POLY = 278;
    public static final int HOUSEHOLDER3FORMULA = 279;

    public static final int ABBASBANDY3 = 280;
    public static final int ABBASBANDY4 = 281;
    public static final int ABBASBANDYGENERALIZED3 = 282;
    public static final int ABBASBANDYGENERALIZED8 = 283;
    public static final int ABBASBANDYSIN = 284;
    public static final int ABBASBANDYCOS = 285;
    public static final int ABBASBANDYPOLY = 286;
    public static final int ABBASBANDYFORMULA = 287;

    public static final int MAGNET13 = 288;
    public static final int MAGNET14 = 289;
    public static final int MAGNET23 = 290;
    public static final int MAGNET24 = 291;

    public static final int NEWTON_THIRD_DEGREE_PARAMETER_SPACE = 292;

    public static final int CONTRA_HARMONIC_NEWTON3 = 293;
    public static final int CONTRA_HARMONIC_NEWTON4 = 294;
    public static final int CONTRA_HARMONIC_NEWTONGENERALIZED3 = 295;
    public static final int CONTRA_HARMONIC_NEWTONGENERALIZED8 = 296;
    public static final int CONTRA_HARMONIC_NEWTONSIN = 297;
    public static final int CONTRA_HARMONIC_NEWTONCOS = 298;
    public static final int CONTRA_HARMONIC_NEWTONPOLY = 299;
    public static final int CONTRA_HARMONIC_NEWTONFORMULA = 300;

    public static final int CHUN_HAM3 = 301;
    public static final int CHUN_HAM4 = 302;
    public static final int CHUN_HAMGENERALIZED3 = 303;
    public static final int CHUN_HAMGENERALIZED8 = 304;
    public static final int CHUN_HAMSIN = 305;
    public static final int CHUN_HAMCOS = 306;
    public static final int CHUN_HAMPOLY = 307;
    public static final int CHUN_HAMFORMULA = 308;

    public static final int CHUN_KIM3 = 309;
    public static final int CHUN_KIM4 = 310;
    public static final int CHUN_KIMGENERALIZED3 = 311;
    public static final int CHUN_KIMGENERALIZED8 = 312;
    public static final int CHUN_KIMSIN = 313;
    public static final int CHUN_KIMCOS = 314;
    public static final int CHUN_KIMPOLY = 315;
    public static final int CHUN_KIMFORMULA = 316;

    public static final int EULER_CHEBYSHEV3 = 317;
    public static final int EULER_CHEBYSHEV4 = 318;
    public static final int EULER_CHEBYSHEVGENERALIZED3 = 319;
    public static final int EULER_CHEBYSHEVGENERALIZED8 = 320;
    public static final int EULER_CHEBYSHEVSIN = 321;
    public static final int EULER_CHEBYSHEVCOS = 322;
    public static final int EULER_CHEBYSHEVPOLY = 323;
    public static final int EULER_CHEBYSHEVFORMULA = 324;

    public static final int EZZATI_SALEKI23 = 325;
    public static final int EZZATI_SALEKI24 = 326;
    public static final int EZZATI_SALEKI2GENERALIZED3 = 327;
    public static final int EZZATI_SALEKI2GENERALIZED8 = 328;
    public static final int EZZATI_SALEKI2SIN = 329;
    public static final int EZZATI_SALEKI2COS = 330;
    public static final int EZZATI_SALEKI2POLY = 331;
    public static final int EZZATI_SALEKI2FORMULA = 332;

    public static final int HOMEIER13 = 333;
    public static final int HOMEIER14 = 334;
    public static final int HOMEIER1GENERALIZED3 = 335;
    public static final int HOMEIER1GENERALIZED8 = 336;
    public static final int HOMEIER1SIN = 337;
    public static final int HOMEIER1COS = 338;
    public static final int HOMEIER1POLY = 339;
    public static final int HOMEIER1FORMULA = 340;

    public static final int ABBASBANDY23 = 341;
    public static final int ABBASBANDY24 = 342;
    public static final int ABBASBANDY2GENERALIZED3 = 343;
    public static final int ABBASBANDY2GENERALIZED8 = 344;
    public static final int ABBASBANDY2SIN = 345;
    public static final int ABBASBANDY2COS = 346;
    public static final int ABBASBANDY2POLY = 347;
    public static final int ABBASBANDY2FORMULA = 348;

    public static final int ABBASBANDY33 = 349;
    public static final int ABBASBANDY34 = 350;
    public static final int ABBASBANDY3GENERALIZED3 = 351;
    public static final int ABBASBANDY3GENERALIZED8 = 352;
    public static final int ABBASBANDY3SIN = 353;
    public static final int ABBASBANDY3COS = 354;
    public static final int ABBASBANDY3POLY = 355;
    public static final int ABBASBANDY3FORMULA = 356;

    public static final int POPOVSKI13 = 357;
    public static final int POPOVSKI14 = 358;
    public static final int POPOVSKI1GENERALIZED3 = 359;
    public static final int POPOVSKI1GENERALIZED8 = 360;
    public static final int POPOVSKI1SIN = 361;
    public static final int POPOVSKI1COS = 362;
    public static final int POPOVSKI1POLY = 363;
    public static final int POPOVSKI1FORMULA = 364;

    public static final int CHANGBUM_CHUN13 = 365;
    public static final int CHANGBUM_CHUN14 = 366;
    public static final int CHANGBUM_CHUN1GENERALIZED3 = 367;
    public static final int CHANGBUM_CHUN1GENERALIZED8 = 368;
    public static final int CHANGBUM_CHUN1SIN = 369;
    public static final int CHANGBUM_CHUN1COS = 370;
    public static final int CHANGBUM_CHUN1POLY = 371;
    public static final int CHANGBUM_CHUN1FORMULA = 372;

    public static final int CHANGBUM_CHUN23 = 373;
    public static final int CHANGBUM_CHUN24 = 374;
    public static final int CHANGBUM_CHUN2GENERALIZED3 = 375;
    public static final int CHANGBUM_CHUN2GENERALIZED8 = 376;
    public static final int CHANGBUM_CHUN2SIN = 377;
    public static final int CHANGBUM_CHUN2COS = 378;
    public static final int CHANGBUM_CHUN2POLY = 379;
    public static final int CHANGBUM_CHUN2FORMULA = 380;

    public static final int KING33 = 381;
    public static final int KING34 = 382;
    public static final int KING3GENERALIZED3 = 383;
    public static final int KING3GENERALIZED8 = 384;
    public static final int KING3SIN = 385;
    public static final int KING3COS = 386;
    public static final int KING3POLY = 387;
    public static final int KING3FORMULA = 388;

    public static final int HOMEIER23 = 389;
    public static final int HOMEIER24 = 390;
    public static final int HOMEIER2GENERALIZED3 = 391;
    public static final int HOMEIER2GENERALIZED8 = 392;
    public static final int HOMEIER2SIN = 393;
    public static final int HOMEIER2COS = 394;
    public static final int HOMEIER2POLY = 395;
    public static final int HOMEIER2FORMULA = 396;

    public static final int KOU_LI_WANG13 = 397;
    public static final int KOU_LI_WANG14 = 398;
    public static final int KOU_LI_WANG1GENERALIZED3 = 399;
    public static final int KOU_LI_WANG1GENERALIZED8 = 400;
    public static final int KOU_LI_WANG1SIN = 401;
    public static final int KOU_LI_WANG1COS = 402;
    public static final int KOU_LI_WANG1POLY = 403;
    public static final int KOU_LI_WANG1FORMULA = 404;

    public static final int KIM_CHUN3 = 405;
    public static final int KIM_CHUN4 = 406;
    public static final int KIM_CHUNGENERALIZED3 = 407;
    public static final int KIM_CHUNGENERALIZED8 = 408;
    public static final int KIM_CHUNSIN = 409;
    public static final int KIM_CHUNCOS = 410;
    public static final int KIM_CHUNPOLY = 411;
    public static final int KIM_CHUNFORMULA = 412;

    public static final int MAHESHWERI3 = 413;
    public static final int MAHESHWERI4 = 414;
    public static final int MAHESHWERIGENERALIZED3 = 415;
    public static final int MAHESHWERIGENERALIZED8 = 416;
    public static final int MAHESHWERISIN = 417;
    public static final int MAHESHWERICOS = 418;
    public static final int MAHESHWERIPOLY = 419;
    public static final int MAHESHWERIFORMULA = 420;

    public static final int RAFIS_RAFIULLAH3 = 421;
    public static final int RAFIS_RAFIULLAH4 = 422;
    public static final int RAFIS_RAFIULLAHGENERALIZED3 = 423;
    public static final int RAFIS_RAFIULLAHGENERALIZED8 = 424;
    public static final int RAFIS_RAFIULLAHSIN = 425;
    public static final int RAFIS_RAFIULLAHCOS = 426;
    public static final int RAFIS_RAFIULLAHPOLY = 427;
    public static final int RAFIS_RAFIULLAHFORMULA = 428;

    public static final int RAFIULLAH13 = 429;
    public static final int RAFIULLAH14 = 430;
    public static final int RAFIULLAH1GENERALIZED3 = 431;
    public static final int RAFIULLAH1GENERALIZED8 = 432;
    public static final int RAFIULLAH1SIN = 433;
    public static final int RAFIULLAH1COS = 434;
    public static final int RAFIULLAH1POLY = 435;
    public static final int RAFIULLAH1FORMULA = 436;

    public static final int CHANGBUM_CHUN33 = 437;
    public static final int CHANGBUM_CHUN34 = 438;
    public static final int CHANGBUM_CHUN3GENERALIZED3 = 439;
    public static final int CHANGBUM_CHUN3GENERALIZED8 = 440;
    public static final int CHANGBUM_CHUN3SIN = 441;
    public static final int CHANGBUM_CHUN3COS = 442;
    public static final int CHANGBUM_CHUN3POLY = 443;
    public static final int CHANGBUM_CHUN3FORMULA = 444;

    public static final int EZZATI_SALEKI13 = 445;
    public static final int EZZATI_SALEKI14 = 446;
    public static final int EZZATI_SALEKI1GENERALIZED3 = 447;
    public static final int EZZATI_SALEKI1GENERALIZED8 = 448;
    public static final int EZZATI_SALEKI1SIN = 449;
    public static final int EZZATI_SALEKI1COS = 450;
    public static final int EZZATI_SALEKI1POLY = 451;
    public static final int EZZATI_SALEKI1FORMULA = 452;

    public static final int FENG3 = 453;
    public static final int FENG4 = 454;
    public static final int FENGGENERALIZED3 = 455;
    public static final int FENGGENERALIZED8 = 456;
    public static final int FENGSIN = 457;
    public static final int FENGCOS = 458;
    public static final int FENGPOLY = 459;
    public static final int FENGFORMULA = 460;

    public static final int KING13 = 461;
    public static final int KING14 = 462;
    public static final int KING1GENERALIZED3 = 463;
    public static final int KING1GENERALIZED8 = 464;
    public static final int KING1SIN = 465;
    public static final int KING1COS = 466;
    public static final int KING1POLY = 467;
    public static final int KING1FORMULA = 468;

    public static final int NOOR_GUPTA3 = 469;
    public static final int NOOR_GUPTA4 = 470;
    public static final int NOOR_GUPTAGENERALIZED3 = 471;
    public static final int NOOR_GUPTAGENERALIZED8 = 472;
    public static final int NOOR_GUPTASIN = 473;
    public static final int NOOR_GUPTACOS = 474;
    public static final int NOOR_GUPTAPOLY = 475;
    public static final int NOOR_GUPTAFORMULA = 476;

    public static final int HARMONIC_SIMPSON_NEWTON3 = 477;
    public static final int HARMONIC_SIMPSON_NEWTON4 = 478;
    public static final int HARMONIC_SIMPSON_NEWTONGENERALIZED3 = 479;
    public static final int HARMONIC_SIMPSON_NEWTONGENERALIZED8 = 480;
    public static final int HARMONIC_SIMPSON_NEWTONSIN = 481;
    public static final int HARMONIC_SIMPSON_NEWTONCOS = 482;
    public static final int HARMONIC_SIMPSON_NEWTONPOLY = 483;
    public static final int HARMONIC_SIMPSON_NEWTONFORMULA = 484;

    public static final int NEDZHIBOV3 = 485;
    public static final int NEDZHIBOV4 = 486;
    public static final int NEDZHIBOVGENERALIZED3 = 487;
    public static final int NEDZHIBOVGENERALIZED8 = 488;
    public static final int NEDZHIBOVSIN = 489;
    public static final int NEDZHIBOVCOS = 490;
    public static final int NEDZHIBOVPOLY = 491;
    public static final int NEDZHIBOVFORMULA = 492;

    public static final int SIMPSON_NEWTON3 = 493;
    public static final int SIMPSON_NEWTON4 = 494;
    public static final int SIMPSON_NEWTONGENERALIZED3 = 495;
    public static final int SIMPSON_NEWTONGENERALIZED8 = 496;
    public static final int SIMPSON_NEWTONSIN = 497;
    public static final int SIMPSON_NEWTONCOS = 498;
    public static final int SIMPSON_NEWTONPOLY = 499;
    public static final int SIMPSON_NEWTONFORMULA = 500;

    public static final int MAGNET_PATAKI2 = 501;
    public static final int MAGNET_PATAKI3 = 502;
    public static final int MAGNET_PATAKI4 = 503;
    public static final int MAGNET_PATAKI5 = 504;
    public static final int MAGNET_PATAKIK = 505;
    public static final int FORMULA47 = 506;
    public static final int PERPENDICULAR_MANDELBROT = 507;
    public static final int BUFFALO_MANDELBROT = 508;

    public static final int CELTIC_MANDELBROT = 509;

    public static final int PERPENDICULAR_BURNING_SHIP = 510;

    public static final int PERPENDICULAR_CELTIC_MANDELBROT = 511;

    public static final int PERPENDICULAR_BUFFALO_MANDELBROT = 512;
    public static final int FORMULA48 = 513;
    /**
     * ***************
     */

    /**
     * ** NOVA VARIANT ***
     */
    public static final int NOVA_NEWTON = 0;
    public static final int NOVA_HALLEY = 1;
    public static final int NOVA_SCHRODER = 2;
    public static final int NOVA_HOUSEHOLDER = 3;
    public static final int NOVA_SECANT = 4;
    public static final int NOVA_STEFFENSEN = 5;
    public static final int NOVA_MULLER = 6;
    public static final int NOVA_PARHALLEY = 7;
    public static final int NOVA_LAGUERRE = 8;
    public static final int NOVA_NEWTON_HINES = 9;
    public static final int NOVA_WHITTAKER = 10;
    public static final int NOVA_WHITTAKER_DOUBLE_CONVEX = 11;
    public static final int NOVA_SUPER_HALLEY = 12;
    public static final int NOVA_MIDPOINT = 13;
    public static final int NOVA_TRAUB_OSTROWSKI = 14;
    public static final int NOVA_STIRLING = 15;
    public static final int NOVA_JARATT = 16;
    public static final int NOVA_JARATT2 = 17;
    public static final int NOVA_WEERAKOON_FERNANDO = 18;
    public static final int NOVA_THIRD_ORDER_NEWTON = 19;
    public static final int NOVA_ABBASBANDY = 20;
    public static final int NOVA_HOUSEHOLDER3 = 21;
    public static final int NOVA_CONTRA_HARMONIC_NEWTON = 22;
    public static final int NOVA_CHUN_HAM = 23;
    public static final int NOVA_CHUN_KIM = 24;

    public static final int NOVA_EULER_CHEBYSHEV = 25;

    public static final int NOVA_EZZATI_SALEKI2 = 26;

    public static final int NOVA_HOMEIER1 = 27;

    public static final int NOVA_ABBASBANDY2 = 28;

    public static final int NOVA_ABBASBANDY3 = 29;

    public static final int NOVA_POPOVSKI1 = 30;

    public static final int NOVA_CHANGBUM_CHUN1 = 31;

    public static final int NOVA_CHANGBUM_CHUN2 = 32;

    public static final int NOVA_KING3 = 33;

    public static final int NOVA_HOMEIER2 = 34;

    public static final int NOVA_KOU_LI_WANG1 = 35;

    public static final int NOVA_KIM_CHUN = 36;

    public static final int NOVA_MAHESHWERI = 37;

    public static final int NOVA_RAFIULLAH1 = 38;
    public static final int NOVA_RAFIS_RAFIULLAH = 39;

    public static final int NOVA_CHANGBUM_CHUN3 = 40;

    public static final int NOVA_EZZATI_SALEKI1 = 41;
    public static final int NOVA_FENG = 42;

    public static final int NOVA_KING1 = 43;
    public static final int NOVA_NOOR_GUPTA = 44;
    public static final int NOVA_HARMONIC_SIMPSON_NEWTON = 45;

    public static final int NOVA_NEDZHIBOV = 46;
    public static final int NOVA_SIMPSON_NEWTON = 47;


    /**
     * *******************
     */
    
    /**
     * ** FRACTAL TYPE ***
     */
    public static final int ESCAPING = 0;
    public static final int CONVERGING = 1;
    public static final int ESCAPING_AND_CONVERGING = 2;
    /**
     * *******************
     */
    
    public static final int REDUCTION_SUM = 0;
    public static final int REDUCTION_MIN = 1;
    public static final int REDUCTION_MAX = 2;
    public static final int REDUCTION_ASSIGN = 3;
    public static final int REDUCTION_SUB = 4;
    public static final int REDUCTION_MULT = 5;

    /**
     * ** OUT COLORING MODE ***
     */
    public static final int ESCAPE_TIME = 0;
    public static final int BINARY_DECOMPOSITION = 1;
    public static final int BINARY_DECOMPOSITION2 = 2;
    public static final int ITERATIONS_PLUS_RE = 3;
    public static final int ITERATIONS_PLUS_IM = 4;
    public static final int ITERATIONS_PLUS_RE_DIVIDE_IM = 5;
    public static final int ITERATIONS_PLUS_RE_PLUS_IM_PLUS_RE_DIVIDE_IM = 6;
    public static final int BIOMORPH = 7;
    public static final int COLOR_DECOMPOSITION = 8;
    public static final int ESCAPE_TIME_COLOR_DECOMPOSITION = 9;
    public static final int ESCAPE_TIME_GAUSSIAN_INTEGER = 10;
    public static final int ESCAPE_TIME_GAUSSIAN_INTEGER2 = 11;
    public static final int ESCAPE_TIME_GAUSSIAN_INTEGER3 = 12;
    public static final int ESCAPE_TIME_GAUSSIAN_INTEGER4 = 13;
    public static final int ESCAPE_TIME_GAUSSIAN_INTEGER5 = 14;
    public static final int ESCAPE_TIME_ALGORITHM = 15;
    public static final int ESCAPE_TIME_ALGORITHM2 = 16;
    public static final int DISTANCE_ESTIMATOR = 17;
    public static final int ESCAPE_TIME_ESCAPE_RADIUS = 18;
    public static final int ESCAPE_TIME_GRID = 19;
    public static final int ATOM_DOMAIN = 20;
    public static final int BANDED = 21;
    public static final int USER_OUTCOLORING_ALGORITHM = 22;
    public static final int ESCAPE_TIME_FIELD_LINES = 23;
    public static final int ESCAPE_TIME_FIELD_LINES2 = 24;
    /**
     * ***************************
     */

    /**
     * ** IN COLORING MODE ***
     */
    public static final int MAX_ITERATIONS = 0;
    public static final int Z_MAG = 1;
    public static final int DECOMPOSITION_LIKE = 2;
    public static final int RE_DIVIDE_IM = 3;
    public static final int COS_MAG = 4;
    public static final int MAG_TIMES_COS_RE_SQUARED = 5;
    public static final int SIN_RE_SQUARED_MINUS_IM_SQUARED = 6;
    public static final int ATAN_RE_TIMES_IM_TIMES_ABS_RE_TIMES_ABS_IM = 7;
    public static final int SQUARES = 8;
    public static final int SQUARES2 = 9;
    public static final int USER_INCOLORING_ALGORITHM = 10;
    /**
     * *************************
     */

    /**
     * ** PLANES ***
     */
    public static final int MU_PLANE = 0;
    public static final int MU_SQUARED_PLANE = 1;
    public static final int MU_SQUARED_IMAGINARY_PLANE = 2;
    public static final int INVERSED_MU_PLANE = 3;
    public static final int INVERSED_MU2_PLANE = 4;
    public static final int INVERSED_MU3_PLANE = 5;
    public static final int INVERSED_MU4_PLANE = 6;
    public static final int LAMBDA_PLANE = 7;
    public static final int INVERSED_LAMBDA_PLANE = 8;
    public static final int INVERSED_LAMBDA2_PLANE = 9;
    public static final int EXP_PLANE = 10;
    public static final int LOG_PLANE = 11;
    public static final int SIN_PLANE = 12;
    public static final int COS_PLANE = 13;
    public static final int TAN_PLANE = 14;
    public static final int COT_PLANE = 15;
    public static final int SINH_PLANE = 16;
    public static final int COSH_PLANE = 17;
    public static final int TANH_PLANE = 18;
    public static final int COTH_PLANE = 19;
    public static final int SQRT_PLANE = 20;
    public static final int ABS_PLANE = 21;
    public static final int FOLDUP_PLANE = 22;
    public static final int FOLDRIGHT_PLANE = 23;
    public static final int FOLDIN_PLANE = 24;
    public static final int FOLDOUT_PLANE = 25;
    public static final int ASIN_PLANE = 26;
    public static final int ACOS_PLANE = 27;
    public static final int ATAN_PLANE = 28;
    public static final int ACOT_PLANE = 29;
    public static final int ASINH_PLANE = 30;
    public static final int ACOSH_PLANE = 31;
    public static final int ATANH_PLANE = 32;
    public static final int ACOTH_PLANE = 33;
    public static final int SEC_PLANE = 34;
    public static final int CSC_PLANE = 35;
    public static final int SECH_PLANE = 36;
    public static final int CSCH_PLANE = 37;
    public static final int ASEC_PLANE = 38;
    public static final int ACSC_PLANE = 39;
    public static final int ASECH_PLANE = 40;
    public static final int ACSCH_PLANE = 41;
    public static final int NEWTON3_PLANE = 42;
    public static final int NEWTON4_PLANE = 43;
    public static final int NEWTONGENERALIZED3_PLANE = 44;
    public static final int NEWTONGENERALIZED8_PLANE = 45;
    public static final int USER_PLANE = 46;
    public static final int GAMMA_PLANE = 47;
    public static final int FACT_PLANE = 48;
    public static final int BIPOLAR_PLANE = 49;
    public static final int INVERSED_BIPOLAR_PLANE = 50;
    public static final int TWIRL_PLANE = 51;
    public static final int SHEAR_PLANE = 52;
    public static final int KALEIDOSCOPE_PLANE = 53;
    public static final int PINCH_PLANE = 54;
    public static final int FOLDDOWN_PLANE = 55;
    public static final int FOLDLEFT_PLANE = 56;
    public static final int CIRCLEINVERSION_PLANE = 57;
    public static final int VARIATION_MU_PLANE = 58;
    public static final int ERF_PLANE = 59;
    public static final int RZETA_PLANE = 60;
    public static final int INFLECTION_PLANE = 61;
    public static final int RIPPLES_PLANE = 62;
    public static final int SKEW_PLANE = 63;
    public static final int INFLECTIONS_PLANE = 64;
    public static final int MU_FOURTH_PLANE = 65;
    /**
     * **************
     */

    /**
     * ** BAILOUT TESTS ***
     */
    public static final int BAILOUT_CONDITION_CIRCLE = 0;
    public static final int BAILOUT_CONDITION_SQUARE = 1;
    public static final int BAILOUT_CONDITION_RHOMBUS = 2;
    public static final int BAILOUT_CONDITION_NNORM = 3;
    public static final int BAILOUT_CONDITION_REAL_STRIP = 4;
    public static final int BAILOUT_CONDITION_HALFPLANE = 5;
    public static final int BAILOUT_CONDITION_USER = 6;
    public static final int BAILOUT_CONDITION_FIELD_LINES = 7;
    public static final int BAILOUT_CONDITION_CROSS = 8;
    public static final int BAILOUT_CONDITION_IM_STRIP = 9;
    public static final int BAILOUT_CONDITION_RE_IM_SQUARED = 10;
    public static final int BAILOUT_CONDITION_NO_BAILOUT = 11;
    public static final int BAILOUT_CONDITION_CUSTOM = 12;
    /**
     * ********************
     */

    /**
     * ** CONVERGENT BAILOUT TESTS ***
     */
    public static final int CONVERGENT_BAILOUT_CONDITION_CIRCLE = 0;
    public static final int CONVERGENT_BAILOUT_CONDITION_SQUARE = 1;
    public static final int CONVERGENT_BAILOUT_CONDITION_RHOMBUS = 2;
    public static final int CONVERGENT_BAILOUT_CONDITION_NNORM = 3;
    public static final int CONVERGENT_BAILOUT_CONDITION_USER = 4;
    public static final int CONVERGENT_BAILOUT_CONDITION_NO_BAILOUT = 5;
    /**
     * ********************
     */

    /**
     * ** IMAGE FILTERS ***
     */
    public static final int ANTIALIASING = 0;
    public static final int EDGE_DETECTION = 1;
    public static final int EMBOSS = 2;
    public static final int SHARPNESS = 3;
    public static final int INVERT_COLORS = 4;
    public static final int BLURRING = 5;
    public static final int COLOR_CHANNEL_MASKING = 6;
    public static final int FADE_OUT = 7;
    public static final int COLOR_CHANNEL_SWAPPING = 8;
    public static final int CONTRAST_BRIGHTNESS = 9;
    public static final int GRAYSCALE = 10;
    public static final int COLOR_TEMPERATURE = 11;
    public static final int COLOR_CHANNEL_SWIZZLING = 12;
    public static final int HISTOGRAM_EQUALIZATION = 13;
    public static final int POSTERIZE = 14;
    public static final int SOLARIZE = 15;
    public static final int COLOR_CHANNEL_ADJUSTING = 16;
    public static final int COLOR_CHANNEL_HSB_ADJUSTING = 17;
    public static final int DITHER = 18;
    public static final int GAIN = 19;
    public static final int GAMMA = 20;
    public static final int EXPOSURE = 21;
    public static final int CRYSTALLIZE = 22;
    public static final int POINTILLIZE = 23;
    public static final int OIL = 24;
    public static final int MARBLE = 25;
    public static final int WEAVE = 26;
    public static final int SPARKLE = 27;
    public static final int GLOW = 28;
    public static final int COLOR_CHANNEL_SCALING = 29;
    public static final int NOISE = 30;
    public static final int COLOR_CHANNEL_MIXING = 31;
    public static final int LIGHT_EFFECTS = 32;
    public static final int EDGE_DETECTION2 = 33;
    public static final int MIRROR = 34;
    /**
     * *****************
     */

    /**
     * ** FUNCTION FILTERS ***
     */
    public static final int NO_FUNCTION_FILTER = 0;
    public static final int ABS_FUNCTION_FILTER = 1;
    public static final int SQUARE_FUNCTION_FILTER = 2;
    public static final int SQRT_FUNCTION_FILTER = 3;
    public static final int RECIPROCAL_FUNCTION_FILTER = 4;
    public static final int SIN_FUNCTION_FILTER = 5;
    public static final int COS_FUNCTION_FILTER = 6;
    public static final int EXP_FUNCTION_FILTER = 7;
    public static final int LOG_FUNCTION_FILTER = 8;
    public static final int USER_FUNCTION_FILTER = 9;
    /**
     * *******************
     */

    /**
     * ** PLANE INFLUENCE ***
     */
    public static final int NO_PLANE_INFLUENCE = 0;
    public static final int USER_PLANE_INFLUENCE = 1;
    public static final int SLIDING_C_PLANE_INFLUENCE = 2;
    /**
     * *******************
     */

    /**
     * ** COLOR SPACE ***
     */
    public static final int COLOR_SPACE_RGB = 0;
    public static final int COLOR_SPACE_HSB = 1;
    public static final int COLOR_SPACE_EXP = 2;
    public static final int COLOR_SPACE_SQUARE = 3;
    public static final int COLOR_SPACE_SQRT = 4;
    public static final int COLOR_SPACE_RYB = 5;
    public static final int COLOR_SPACE_LAB = 6;
    public static final int COLOR_SPACE_XYZ = 7;
    public static final int COLOR_SPACE_LCH_ab = 8;
    public static final int COLOR_SPACE_BEZIER_RGB = 9;
    public static final int COLOR_SPACE_HSL = 10;

    public static final int COLOR_SPACE_LUV = 11;

    public static final int COLOR_SPACE_LCH_uv = 12;

    public static final int COLOR_SPACE_OKLAB = 13;

    public static final int COLOR_SPACE_LCH_oklab = 14;

    public static final int COLOR_SPACE_JZAZBZ = 15;

    public static final int COLOR_SPACE_LCH_JzAzBz = 16;

    public static final int COLOR_SPACE_HSL_uv = 17;

    public static final int COLOR_SPACE_HPL_uv = 18;

    public static final int COLOR_SPACE_HWB = 19;

    public static final int COLOR_SPACE_LINEAR_RGB = 20;
    /**
     * *******************
     */

    /**
     * ** COLOR INTERPOLATION ***
     */
    public static final int INTERPOLATION_LINEAR = 0;
    public static final int INTERPOLATION_COSINE = 1;
    public static final int INTERPOLATION_ACCELERATION = 2;
    public static final int INTERPOLATION_DECELERATION = 3;
    public static final int INTERPOLATION_EXPONENTIAL = 4;
    public static final int INTERPOLATION_CATMULLROM = 5;
    public static final int INTERPOLATION_CATMULLROM2 = 6;
    public static final int INTERPOLATION_SIGMOID = 7;
    public static final int INTERPOLATION_QUADRATIC = 8;
    public static final int INTERPOLATION_CUBIC = 9;
    public static final int INTERPOLATION_SQRT_VALUES = 10;

    public static final int INTERPOLATION_SINE = 11;

    public static final int INTERPOLATION_SQRT = 12;

    public static final int INTERPOLATION_THIRD_POLY = 13;

    public static final int INTERPOLATION_FIFTH_POLY = 14;

    public static final int INTERPOLATION_EXPONENTIAL_2 = 15;

    public static final int INTERPOLATION_CUBE_ROOT = 16;

    public static final int INTERPOLATION_FOURTH_ROOT = 17;

    public static final int INTERPOLATION_SMOOTH_TRANSITION_STEP = 18;

    public static final int INTERPOLATION_QUARTER_SIN = 19;
    /**
     * **************************
     */

    /**
     * ** MOVE DIRECTIONS ***
     */
    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;
    /**
     * **********************
     */

    /**
     * ** PALETTE PROCESSING ***
     */
    public static final int PROCESSING_NONE = 0;
    public static final int PROCESSING_HISTOGRAM_BRIGHTNESS = 1;
    public static final int PROCESSING_BRIGHTNESS1 = 2;
    public static final int PROCESSING_BRIGHTNESS2 = 3;
    public static final int PROCESSING_HUE1 = 4;
    public static final int PROCESSING_HUE2 = 5;
    public static final int PROCESSING_SATURATION1 = 6;
    public static final int PROCESSING_SATURATION2 = 7;
    public static final int PROCESSING_RED1 = 8;
    public static final int PROCESSING_RED2 = 9;
    public static final int PROCESSING_GREEN1 = 10;
    public static final int PROCESSING_GREEN2 = 11;
    public static final int PROCESSING_BLUE1 = 12;
    public static final int PROCESSING_BLUE2 = 13;
    public static final int PROCESSING_RGB1 = 14;
    public static final int PROCESSING_RGB2 = 15;
    public static final int PROCESSING_HSB1 = 16;
    public static final int PROCESSING_HSB2 = 17;
    public static final int PROCESSING_RYB1 = 18;
    public static final int PROCESSING_RYB2 = 19;
    public static final int PROCESSING_HISTOGRAM_LIGHTNESS_LAB = 20;
    public static final int PROCESSING_BRIGHTNESS3 = 21;
    public static final int PROCESSING_HUE3 = 22;
    public static final int PROCESSING_SATURATION3 = 23;
    public static final int PROCESSING_RED3 = 24;
    public static final int PROCESSING_GREEN3 = 25;
    public static final int PROCESSING_BLUE3 = 26;
    public static final int PROCESSING_RGB3 = 27;
    public static final int PROCESSING_HSB3 = 28;
    public static final int PROCESSING_RYB3 = 29;
    /**
     * *************************
     */

    /**
     * *********GREEDY ALGORITHMS********
     */
    public static final int BOUNDARY_TRACING = 0;
    public static final int BOUNDARY_TRACING2 = 1;
    public static final int DIVIDE_AND_CONQUER = 2;
    public static final int DIVIDE_AND_CONQUER2 = 3;
    public static final int SOLID_GUESSING = 4;
    public static final int SUCCESSIVE_REFINEMENT = 5;
    public static final int CIRCULAR_SUCCESSIVE_REFINEMENT = 6;
    /**
     * ***********************************
     */
    
    /**
     * *********COLOR TRANSFER FILTERS********
     */
    public static final int DEFAULT = 0;
    public static final int SQUARE_ROOT = 1;
    public static final int CUBE_ROOT = 2;
    public static final int FOURTH_ROOT = 3;
    public static final int LOGARITHM = 4;
    public static final int LOG_LOG = 5;
    public static final int ATAN = 6;
    public static final int LINEAR = 7;
    /**
     * **************************************
     */
    
    /**
     * *********COLOR BLENDING********
     */
    public static final int NORMAL_BLENDING = 0;
    public static final int MULTIPLY_BLENDING = 1;
    public static final int DIVIDE_BLENDING = 2;
    public static final int ADDITION_BLENDING = 3;
    public static final int SUBTRACTION_BLENDING = 4;
    public static final int DIFFERENCE_BLENDING = 5;
    public static final int VALUE_BLENDING = 6;
    public static final int SOFT_LIGHT_BLENDING = 7;
    public static final int SCREEN_BLENDING = 8;
    public static final int DODGE_BLENDING = 9;
    public static final int BURN_BLENDING = 10;
    public static final int DARKEN_ONLY_BLENDING = 11;
    public static final int LIGHTEN_ONLY_BLENDING = 12;
    public static final int HARD_LIGHT_BLENDING = 13;
    public static final int GRAIN_EXTRACT_BLENDING = 14;
    public static final int GRAIN_MERGE_BLENDING = 15;
    public static final int SATURATION_BLENDING = 16;
    public static final int COLOR_BLENDING = 17;
    public static final int HUE_BLENDING = 18;
    public static final int EXCLUSION_BLENDING = 19;
    public static final int PIN_LIGHT_BLENDING = 20;
    public static final int LINEAR_LIGHT_BLENDING = 21;
    public static final int VIVID_LIGHT_BLENDING = 22;
    public static final int OVERLAY_BLENDING = 23;
    public static final int LCH_CHROMA_BLENDING = 24;
    public static final int LCH_COLOR_BLENDING = 25;
    public static final int LCH_HUE_BLENDING = 26;
    public static final int LCH_LIGHTNESS_BLENDING = 27;
    public static final int LUMINANCE_BLENDING = 28;
    public static final int LINEAR_BURN_BLENDING = 29;
    
    /**
     * **************************************
     */
    
    /**
     * *********EQUALITY CHECK********
     */
    public static final int GREATER = 0;
    public static final int GREATER_EQUAL = 1;
    public static final int LOWER = 2;
    public static final int LOWER_EQUAL = 3;
    public static final int EQUAL = 4;
    public static final int NOT_EQUAL = 5;
     /**
     * **************************************
     */
    
    /**
     * ****CUSTOM DOMAIN ORDER******
     */
    public static final int GRID = 0;
    public static final int CIRCLES = 1;
    public static final int ISO_LINES = 2;
    /**
     * **************************************
     */
    
    /**
     * *********STATISTICS********
     */
    public static final int STRIPE_AVERAGE = 0;
    public static final int CURVATURE_AVERAGE = 1;
    public static final int TRIANGLE_INEQUALITY_AVERAGE = 2;
    public static final int COS_ARG_DIVIDE_NORM_AVERAGE = 3;
    public static final int COS_ARG_DIVIDE_INVERSE_NORM = 4;
    public static final int ATOM_DOMAIN_BOF60_BOF61 = 5;
    public static final int DISCRETE_LAGRANGIAN_DESCRIPTORS = 6;
    public static final int TWIN_LAMPS = 7;

    public static final int CHECKERS = 8;
    
    /**
     * **************************************
     */
    
    /**
     * *********ORBIT TRAPS********
     */
    public static final int POINT_TRAP = 0;
    public static final int POINT_SQUARE_TRAP = 1;
    public static final int POINT_RHOMBUS_TRAP = 2;
    public static final int POINT_N_NORM_TRAP = 3;
    public static final int CROSS_TRAP = 4;
    public static final int RE_TRAP = 5;
    public static final int IM_TRAP = 6;
    public static final int CIRCLE_TRAP = 7;
    public static final int SQUARE_TRAP = 8;
    public static final int RHOMBUS_TRAP = 9;
    public static final int N_NORM_TRAP = 10;
    public static final int CIRCLE_CROSS_TRAP = 11;
    public static final int SQUARE_CROSS_TRAP = 12;
    public static final int RHOMBUS_CROSS_TRAP = 13;
    public static final int N_NORM_CROSS_TRAP = 14;
    public static final int CIRCLE_POINT_TRAP = 15;
    public static final int SQUARE_POINT_TRAP = 16;
    public static final int RHOMBUS_POINT_TRAP = 17;
    public static final int N_NORM_POINT_TRAP = 18;
    public static final int N_NORM_POINT_N_NORM_TRAP = 19;
    public static final int GOLDEN_RATIO_SPIRAL_TRAP = 20;
    public static final int GOLDEN_RATIO_SPIRAL_POINT_TRAP = 21;
    public static final int GOLDEN_RATIO_SPIRAL_POINT_N_NORM_TRAP = 22;   
    public static final int GOLDEN_RATIO_SPIRAL_CROSS_TRAP = 23;
    public static final int GOLDEN_RATIO_SPIRAL_CIRCLE_TRAP = 24;
    public static final int GOLDEN_RATIO_SPIRAL_SQUARE_TRAP = 25;
    public static final int GOLDEN_RATIO_SPIRAL_RHOMBUS_TRAP = 26;
    public static final int GOLDEN_RATIO_SPIRAL_N_NORM_TRAP = 27;
    public static final int STALKS_TRAP = 28;
    public static final int STALKS_POINT_TRAP = 29;
    public static final int STALKS_POINT_N_NORM_TRAP = 30;
    public static final int STALKS_CROSS_TRAP = 31;
    public static final int STALKS_CIRCLE_TRAP = 32;
    public static final int STALKS_SQUARE_TRAP = 33;
    public static final int STALKS_RHOMBUS_TRAP = 34;
    public static final int STALKS_N_NORM_TRAP = 35;
    public static final int IMAGE_TRAP = 36;
    public static final int ATOM_DOMAIN_TRAP = 37;
    public static final int SQUARE_ATOM_DOMAIN_TRAP = 38;
    public static final int RHOMBUS_ATOM_DOMAIN_TRAP = 39;
    public static final int NNORM_ATOM_DOMAIN_TRAP = 40;
    public static final int TEAR_DROP_ORBIT_TRAP = 41;
    public static final int SUPER_FORMULA_ORBIT_TRAP = 42;

    public static final int IMAGE_TRANSPARENT_TRAP = 43;






    public static final int TRAP_COLOR_PER_TRAP = 0;
    public static final int TRAP_COLOR_RANDOM = 1;
    public static final int TRAP_COLOR_ARG_HUE_HSB = 2;
    public static final int TRAP_COLOR_ARG_HUE_LCH_ab = 3;
    public static final int TRAP_COLOR_RANDOM_HSB = 4;
    public static final int TRAP_COLOR_RANDOM_PALETTE = 5;
    public static final int TRAP_COLOR_ARG_PALETTE = 6;
    public static final int TRAP_COLOR_ITER_HSB = 7;
    public static final int TRAP_COLOR_ITER_LCH_ab = 8;
    public static final int TRAP_COLOR_ARG_HUE_LCH_uv = 9;
    public static final int TRAP_COLOR_ITER_LCH_uv = 10;


    public static final int TRAP_CHECK_TYPE_TRAPPED_MIN_DISTANCE = 0;
    public static final int TRAP_CHECK_TYPE_TRAPPED_FIRST = 1;
    public static final int TRAP_CHECK_TYPE_TRAPPED_LAST = 2;
    
    
     /**
     * **************************************
     */
    
    /**
     * ****POST PROCESSING******
     */
    public static final int FAKE_DISTANCE_ESTIMATION = 0;
    public static final int ENTROPY_COLORING = 1;
    public static final int OFFSET_COLORING = 2;
    public static final int RAINBOW_PALETTE = 3;
    public static final int GREYSCALE_COLORING = 4;
    public static final int CONTOUR_COLORING = 5;
    public static final int BUMP_MAPPING = 6;
    public static final int LIGHT = 7;
    public static final int SLOPES = 8;
    public static final int NUMERICAL_DISTANCE_ESTIMATOR = 9;

    public static final int HISTOGRAM_COLORING = 10;
    
    public static String[] processingAlgorithNames = {"Fake Distance Estimation", "Entropy Coloring", "Offset Coloring", "Rainbow Palette", "Greyscale Coloring", "Contour Coloring", "Bump Mapping", "Light", "Slopes", "Numerical Distance Estimator", "Histogram Coloring"};
    /**
     * **************************************
     */
    
    
    public static final int PULL_EXP = 0;
    public static final int PULL_LINEAR = 1;
    public static final int PULL_ODDBALL = 2;
    

    public static final int CUSTOM_PALETTE_ID = 18;
    public static final int DIRECT_PALETTE_ID = 19;
    
    public static final int GRADIENT_LENGTH = 512;
    
    public static final Color bg_color = Color.white;
    public static final Color progress_color = new Color(190, 81, 69);//new Color(255, 185, 15);
    public static final Color progress_filters_color = new Color(24, 161, 110);

    public static final Color progress_d3_color = new Color(76, 139, 245);
    public static final Color progress_ref_color = new Color(90, 90, 90);
    public static final Color progress_sa_color = new Color(30, 90, 255);

    public static final Color progress_nanomb1_color = new Color(255, 170, 51);
    public static final Color progress_bla_color = new Color(24, 201, 85);

    public static final Apint DEFAULT_MAGNIFICATION = new Apint(4);

    public static final int EMPTY_ALPHA = 0xFD;
    public static final int QUICKDRAW_CALCULATED_ALPHA = 0xFE;
    public static final int NORMAL_ALPHA = 0xFF;

    public static final int SKIPPED_PIXELS_SPECIAL_COLOR = 0x00ffffff;

    public static final int EMPTY_ALPHA_OFFSETED = EMPTY_ALPHA << 24;
    public static final int EMPTY_COLOR = EMPTY_ALPHA_OFFSETED | 0xFFFFFF;
    public static final int QUICKDRAW_CALCULATED_ALPHA_OFFSETED = QUICKDRAW_CALCULATED_ALPHA << 24;
    public static final int NORMAL_ALPHA_OFFSETED = NORMAL_ALPHA << 24;

    public static final int BIGNUM_DOUBLE = 0;
    public static final int BIGNUM_DOUBLEDOUBLE = 1;
    public static final int BIGNUM_BUILT_IN = 2;
    public static final int BIGNUM_MPFR = 3;
    public static final int BIGNUM_AUTOMATIC = 4;
    public static final int BIGNUM_MPIR = 5;
    public static final int BIGNUM_AUTOMATIC_ONLY_BIGNUM = 6;
    public static final int BIGNUM_BIGINT = 7;
    public static final int BIGNUM_APFLOAT = 8;

    public static final int ARBITRARY_DOUBLEDOUBLE = 0;
    public static final int ARBITRARY_BUILT_IN = 1;
    public static final int ARBITRARY_MPFR = 2;
    public static final int ARBITRARY_APFLOAT = 3;
    public static final int ARBITRARY_AUTOMATIC = 4;

    public static final int ARBITRARY_MPIR = 5;
    public static final int ARBITRARY_BIGINT = 6;

    public static final String greedyWarning = "Greedy Drawing Algorithm is enabled, which creates glitches in the image.\nYou should disable it for a better result, or check the \"Use Iteration Data\" option.";

    public static final String FZL4j = "# Launch4j runtime config\n" +
            "# This file must be named as the executable. If the executable is AAA.exe, then this file must be named AAA.l4j.ini\n" +
            "# Configure the JVM Heap size.\n" +
            "-Xmx2200m\n" +
            "-XX:+UseG1GC";

    public static final String IEL4j = "# Launch4j runtime config\n" +
            "# This file must be named as the executable. If the executable is AAA.exe, then this file must be named AAA.l4j.ini\n" +
            "# Configure the JVM Heap size.\n" +
            "-Xmx4000m\n" +
            "-XX:+UseG1GC";

    public static final long MAX_PROGRESS_VALUE = Integer.MAX_VALUE;

    public static final int MIN_QUICK_DRAW_TILES = 2;
    public static final int MAX_QUICK_DRAW_TILES = 20;

}
