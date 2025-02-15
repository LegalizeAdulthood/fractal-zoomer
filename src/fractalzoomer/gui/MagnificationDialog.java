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

import fractalzoomer.core.MyApfloat;
import fractalzoomer.functions.Fractal;
import fractalzoomer.main.Constants;
import fractalzoomer.main.MainWindow;
import fractalzoomer.main.app_settings.Settings;
import org.apfloat.Apfloat;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static fractalzoomer.gui.CenterSizeDialog.TEMPLATE_TFIELD;

/**
 *
 * @author hrkalona2
 */
public class MagnificationDialog extends JDialog {

    private MainWindow ptra;
    private JOptionPane optionPane;

    public MagnificationDialog(MainWindow ptr, Settings s, JTextArea field_size) {

        super(ptr);
        
        ptra = ptr;

        setTitle("Magnification");
        setModal(true);
        setIconImage(MainWindow.getIcon("mandel2.png").getImage());

        Apfloat tempSize;
        try {

            if(MyApfloat.setAutomaticPrecision) {
                long precision = MyApfloat.getAutomaticPrecision(new String[]{field_size.getText()}, new boolean[] {true}, s.fns.function);

                if (MyApfloat.shouldSetPrecision(precision, MyApfloat.alwaysCheckForDecrease, s.fns.function)) {
                    Fractal.clearReferences(true, true);
                    MyApfloat.setPrecision(precision, s);
                }
            }

            tempSize = new MyApfloat(field_size.getText());
        } catch (Exception ex) {
            tempSize = s.size;
        }

        Apfloat magnificationVal = MyApfloat.fp.divide(Constants.DEFAULT_MAGNIFICATION, tempSize);


        JTextArea magnification = new JTextArea(6, 50);
        magnification.setFont(TEMPLATE_TFIELD.getFont());
        magnification.setLineWrap(true);

        JScrollPane magnScroll = new JScrollPane (magnification,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        CenterSizeDialog.disableKeys(magnification.getInputMap());
        CenterSizeDialog.disableKeys(magnScroll.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT));

        magnification.setText("" + magnificationVal);

        SwingUtilities.invokeLater(() -> magnScroll.getVerticalScrollBar().setValue(0));

        Object[] message = {
            " ",
            "Set the magnification.",
            "Magnification:",
                magnScroll,
            " ",
            };

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

                            if(MyApfloat.setAutomaticPrecision) {
                                long precision = MyApfloat.getAutomaticPrecision(new String[]{magnification.getText()}, new boolean[] {true}, s.fns.function);

                                if (MyApfloat.shouldSetPrecision(precision, MyApfloat.alwaysCheckForDecrease, s.fns.function)) {
                                    Fractal.clearReferences(true, true);
                                    MyApfloat.setPrecision(precision, s);
                                }
                            }

                            Apfloat tempMagn = new MyApfloat(magnification.getText());

                            field_size.setText("" + MyApfloat.fp.divide(Constants.DEFAULT_MAGNIFICATION, tempMagn));
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(ptra, "Illegal Argument: " + ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        dispose();
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
