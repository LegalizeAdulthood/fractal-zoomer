/*
 * Copyright (C) 2020 hrkalona2
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
package fractalzoomer.gui;

import fractalzoomer.core.TaskDraw;
import fractalzoomer.main.Constants;
import fractalzoomer.main.MainWindow;
import fractalzoomer.main.app_settings.Settings;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author hrkalona2
 */
public class NumericalDistanceEstimatorDialog extends JDialog {

    private MainWindow ptra;
    private JOptionPane optionPane;

    public NumericalDistanceEstimatorDialog(MainWindow ptr, Settings s, boolean greedy_algorithm, boolean julia_map) {
        
        super(ptr);

        ptra = ptr;

        setTitle("Numerical Distance Estimator");
        setModal(true);
        setIconImage(MainWindow.getIcon("mandel2.png").getImage());

        JTextField numerical_palette_factor_field = new JTextField();
        numerical_palette_factor_field.setText("" + s.pps.ndes.distanceFactor);

        final JCheckBox enable_num = new JCheckBox("Numerical Distance Estimator");
        enable_num.setSelected(s.pps.ndes.useNumericalDem);
        enable_num.setFocusable(false);

        final JCheckBox cap_to_palette_length = new JCheckBox("Cap to Palette Length");
        cap_to_palette_length.setSelected(s.pps.ndes.cap_to_palette_length);
        cap_to_palette_length.setFocusable(false);


        JTextField offset_field = new JTextField();
        offset_field.setText("" + s.pps.ndes.distanceOffset);

        JSlider color_blend_opt = new JSlider(JSlider.HORIZONTAL, 0, 100, (int) (s.pps.ndes.numerical_blending * 100));
        color_blend_opt.setMajorTickSpacing(25);
        color_blend_opt.setMinorTickSpacing(1);
        color_blend_opt.setToolTipText("Sets the color blending percentage.");
        color_blend_opt.setFocusable(false);
        color_blend_opt.setPaintLabels(true);

        JTextField noise_factor_field = new JTextField();
        noise_factor_field.setText("" + s.pps.ndes.n_noise_reducing_factor);

        final JComboBox<String> differences_method_opt = new JComboBox<>(Constants.differencesMethod);
        differences_method_opt.setSelectedIndex(s.pps.ndes.differencesMethod);
        differences_method_opt.setFocusable(false);
        differences_method_opt.setToolTipText("Sets the differences method.");

//        final JCheckBox useJitter = new JCheckBox("Use Jitter");
//        useJitter.setSelected(s.pps.ndes.useJitter);
//        useJitter.setFocusable(false);


        Object[] message = {
            " ",
            enable_num,
            " ",
                "Set the differences method.",
                "Differences Method:", differences_method_opt,
                " "
                ,
            "Set the transfer factor.",
            "Transfer Factor:", numerical_palette_factor_field,
                cap_to_palette_length,
            " ",
            "Set the coloring offset.",
            "Coloring Offset:", offset_field,
            " ",
//                useJitter,
//                " ",
            "Set the color blending percentage.",
            "Color Blending:", color_blend_opt,
            " ",
            "Set the image noise reduction factor.",
            "Noise Reduction Factor:",
            noise_factor_field,
            " "};

        optionPane = new JOptionPane(message, JOptionPane.QUESTION_MESSAGE, JOptionPane.OK_CANCEL_OPTION, null, null, null);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                optionPane.setValue(JOptionPane.CLOSED_OPTION);
            }
        });

        optionPane.addPropertyChangeListener(
                e -> {
                    String prop = e.getPropertyName();

                    if (isVisible() && (e.getSource() == optionPane) && (prop.equals(JOptionPane.VALUE_PROPERTY))) {

                        Object value = optionPane.getValue();

                        if (value == JOptionPane.UNINITIALIZED_VALUE) {
                            //ignore reset
                            return;
                        }

                        //Reset the JOptionPane's value.
                        //If you don't do this, then if the user
                        //presses the same button next time, no
                        //property change event will be fired.
                        optionPane.setValue(JOptionPane.UNINITIALIZED_VALUE);

                        if ((Integer) value == JOptionPane.CANCEL_OPTION || (Integer) value == JOptionPane.NO_OPTION || (Integer) value == JOptionPane.CLOSED_OPTION) {
                            dispose();
                            return;
                        }

                        try {
                            double temp = Double.parseDouble(numerical_palette_factor_field.getText());
                            double temp2 = Double.parseDouble(noise_factor_field.getText());
                            int temp3 = Integer.parseInt(offset_field.getText());

                            if (temp < 0) {
                                JOptionPane.showMessageDialog(ptra, "The transfer factor must be greater than -1.", "Error!", JOptionPane.ERROR_MESSAGE);
                                return;
                            }

                            if (temp2 <= 0) {
                                JOptionPane.showMessageDialog(ptra, "The noise reduction factor must be greater than 0.", "Error!", JOptionPane.ERROR_MESSAGE);
                                return;
                            }

                            if (temp3 < 0) {
                                JOptionPane.showMessageDialog(ptra, "The coloring offset must be greater than -1.", "Error!", JOptionPane.ERROR_MESSAGE);
                                return;
                            }

                            s.pps.ndes.useNumericalDem = enable_num.isSelected();
                            s.pps.ndes.distanceFactor = temp;
                            s.pps.ndes.n_noise_reducing_factor = temp2;
                            s.pps.ndes.distanceOffset = temp3;
                            s.pps.ndes.numerical_blending = color_blend_opt.getValue() / 100.0;
                            s.pps.ndes.differencesMethod = differences_method_opt.getSelectedIndex();
                            s.pps.ndes.cap_to_palette_length = cap_to_palette_length.isSelected();
                           // s.pps.ndes.useJitter = useJitter.isSelected();
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(ptra, "Illegal Argument: " + ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        dispose();

                        if (greedy_algorithm && !TaskDraw.GREEDY_ALGORITHM_CHECK_ITER_DATA && enable_num.isSelected() && !julia_map && !s.d3s.d3) {
                            JOptionPane.showMessageDialog(ptra, Constants.greedyWarning, "Warning!", JOptionPane.WARNING_MESSAGE);
                        }

                        ptra.setPostProcessingPost();
                    }
                });

        //Make this dialog display it.
        setContentPane(optionPane);

        pack();

        setResizable(false);
        setLocation((int) (ptra.getLocation().getX() + ptra.getSize().getWidth() / 2) - (getWidth() / 2), (int) (ptra.getLocation().getY() + ptra.getSize().getHeight() / 2) - (getHeight() / 2));
        setVisible(true);

    }

}
