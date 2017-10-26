package View.UpdateDialogs;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * Created by y50-70 on 25.10.2017.
 */
public class UpdateRecipeDialog {
    Controller controller;

    public UpdateRecipeDialog(Controller controller) {
        this.controller = controller;
        JDialog dialog = new JDialog();
        dialog.setVisible(true);
        dialog.setSize(300, 350);
        JPanel panel = new JPanel(new FlowLayout());
        dialog.add(panel);


        JLabel labelSearchCode = new JLabel("Поиск: Код рецепта");
        JTextField searchCode = new JTextField(20);
        JLabel labelCode = new JLabel("Код рецепта");
        JTextField code = new JTextField(20);
        JLabel labelName= new JLabel("Название");
        JTextField name = new JTextField(20);
        JLabel labelRecipeDescr = new JLabel("Описание рецепта:код");
        JTextField recipeDescr = new JTextField(20);
        JLabel labelAuthor = new JLabel("Автор:код");
        JTextField author = new JTextField(20);

        JButton button = new JButton("Обновить");
        button.addActionListener(e -> {
            String searchCodeString = searchCode.getText();
            String codeString = code.getText();
            String nameString = name.getText();
            String recipeString = recipeDescr.getText();
            String authorString = author.getText();
            controller.updateRecipe(searchCodeString, codeString, nameString, recipeString, authorString);
        });

        panel.add(labelSearchCode);
        panel.add(searchCode);
        panel.add(labelCode);
        panel.add(code);
        panel.add(labelName);
        panel.add(name);
        panel.add(labelRecipeDescr);
        panel.add(recipeDescr);
        panel.add(labelAuthor);
        panel.add(author);
        panel.add(button);
    }
}
