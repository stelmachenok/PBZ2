package View.DeleteDialogs;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * Created by y50-70 on 25.10.2017.
 */
public class DeleteRecipeDialog {
    Controller controller;

    public DeleteRecipeDialog(Controller controller) {
        this.controller = controller;
        JDialog dialog = new JDialog();
        dialog.setVisible(true);
        dialog.setSize(300, 150);
        JPanel panel = new JPanel(new FlowLayout());
        dialog.add(panel);

        JLabel labelName = new JLabel("Код рецепта");
        JTextField code = new JTextField(20);
        JButton button = new JButton("Удалить");
        button.addActionListener(e -> {
            String codeString = code.getText();
            controller.deleteRecipe(codeString);
        });
        panel.add(labelName);
        panel.add(code);
        panel.add(button);
    }
}
