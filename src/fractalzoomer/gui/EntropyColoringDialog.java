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
public class EntropyColoringDialog extends JDialog {

    private MainWindow ptra;
    private JOptionPane optionPane;

    public EntropyColoringDialog(MainWindow ptr, Settings s, boolean greedy_algorithm, boolean julia_map) {

        super(ptr);
        
        ptra = ptr;

        setTitle("Entropy Coloring");
        setModal(true);
        setIconImage(MainWindow.getIcon("mandel2.png").getImage());

        JTextField entropy_factor_field = new JTextField();
        entropy_factor_field.setText("" + s.pps.ens.entropy_palette_factor);

        final JCheckBox enable_entropy_coloring = new JCheckBox("Entropy Coloring");
        enable_entropy_coloring.setSelected(s.pps.ens.entropy_coloring);
        enable_entropy_coloring.setFocusable(false);

        JTextField entropy_offset_field = new JTextField();
        entropy_offset_field.setText("" + s.pps.ens.entropy_offset);

        JSlider color_blend_opt = new JSlider(JSlider.HORIZONTAL, 0, 100, (int) (s.pps.ens.en_blending * 100));
        color_blend_opt.setMajorTickSpacing(25);
        color_blend_opt.setMinorTickSpacing(1);
        color_blend_opt.setToolTipText("Sets the color blending percentage.");
        color_blend_opt.setFocusable(false);
        color_blend_opt.setPaintLabels(true);

        JTextField noise_factor_field = new JTextField();
        noise_factor_field.setText("" + s.pps.ens.en_noise_reducing_factor);

        final JComboBox<String> entropy_coloring_method_opt = new JComboBox<>(Constants.entropyMethod);
        entropy_coloring_method_opt.setSelectedIndex(s.pps.ens.entropy_algorithm);
        entropy_coloring_method_opt.setFocusable(false);
        entropy_coloring_method_opt.setToolTipText("Sets the color transfer method.");

        if (s.pps.ens.entropy_algorithm != 0) {
            entropy_offset_field.setEnabled(false);
        }

        entropy_coloring_method_opt.addActionListener(e -> {
            entropy_offset_field.setEnabled(entropy_coloring_method_opt.getSelectedIndex() == 0);
        });

        Object[] message = {
            " ",
            enable_entropy_coloring,
            " ",
            "Set the entropy coloring factor.",
            "Entropy Coloring factor:", entropy_factor_field,
            " ",
            "Set the coloring offset.",
            "Coloring Offset:", entropy_offset_field,
            " ",
            "Set the color transfer method.",
            "Color Transfer Method:", entropy_coloring_method_opt,
            " ",
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
                            double temp = Double.parseDouble(entropy_factor_field.getText());
                            double temp2 = Double.parseDouble(noise_factor_field.getText());
                            int temp3 = Integer.parseInt(entropy_offset_field.getText());

                            if (temp < 0) {
                                JOptionPane.showMessageDialog(ptra, "The entropy coloring factor must be greater than -1.", "Error!", JOptionPane.ERROR_MESSAGE);
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

                            s.pps.ens.entropy_coloring = enable_entropy_coloring.isSelected();
                            s.pps.ens.entropy_palette_factor = temp;
                            s.pps.ens.en_noise_reducing_factor = temp2;
                            s.pps.ens.entropy_offset = temp3;
                            s.pps.ens.en_blending = color_blend_opt.getValue() / 100.0;
                            s.pps.ens.entropy_algorithm = entropy_coloring_method_opt.getSelectedIndex();
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(ptra, "Illegal Argument: " + ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        dispose();

                        if (greedy_algorithm && !TaskDraw.GREEDY_ALGORITHM_CHECK_ITER_DATA && enable_entropy_coloring.isSelected() && !julia_map && !s.d3s.d3) {
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
