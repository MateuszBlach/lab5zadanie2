import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/*
Klasa utworzona do wygenerowania interfejsu graficznego.
 */
public class ContentGenerator {
    public static void generateContent(Application app,JPanel panel, JTextArea textArea, JButton buttonDM, JButton buttonC,
                                       JButton buttonCE, JButton buttonPlus, JButton buttonMinus, JButton buttonDivide,
                                       JButton buttonResult, JButton buttonABC, JButton buttonDEF, JButton buttonGHI,
                                       JButton buttonJKL, JButton buttonMNO, JButton buttonPQR, JButton buttonSTUV, JButton buttonWXYZ) {
        //utworzenie layoutu
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        //ustawienie odstępów między obiektami w layoucie
        gbc.insets = new Insets(5,5,5,5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(textArea,gbc);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(buttonDM,gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(buttonCE,gbc);
        gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(buttonC,gbc);
        gbc.gridx = 3;
        gbc.gridy = 1;
        panel.add(buttonPlus,gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(buttonABC,gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(buttonDEF,gbc);
        gbc.gridx = 2;
        gbc.gridy = 2;
        panel.add(buttonGHI,gbc);
        gbc.gridx = 3;
        gbc.gridy = 2;
        panel.add(buttonMinus,gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(buttonJKL,gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(buttonMNO,gbc);
        gbc.gridx = 2;
        gbc.gridy = 3;
        panel.add(buttonPQR,gbc);
        gbc.gridx = 3;
        gbc.gridy = 3;
        panel.add(buttonDivide,gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(buttonSTUV,gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(buttonWXYZ,gbc);
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(buttonResult,gbc);

        buttonABC.addActionListener(app);
        buttonDEF.addActionListener(app);
        buttonDEF.addActionListener(app);
        buttonGHI.addActionListener(app);
        buttonJKL.addActionListener(app);
        buttonMNO.addActionListener(app);
        buttonPQR.addActionListener(app);
        buttonSTUV.addActionListener(app);
        buttonWXYZ.addActionListener(app);
        buttonC.addActionListener(app);
        buttonCE.addActionListener(app);
        buttonDM.addActionListener(app);
        buttonPlus.addActionListener(app);
        buttonMinus.addActionListener(app);
        buttonDivide.addActionListener(app);
        buttonResult.addActionListener(app);
    }
}
