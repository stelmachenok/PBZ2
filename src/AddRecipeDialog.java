import javax.swing.*;
import java.awt.*;

/**
 * Created by y50-70 on 25.10.2017.
 */
public class AddRecipeDialog {
    Controller controller;

    public AddRecipeDialog(Controller controller) {
        this.controller = controller;
        JDialog dialog = new JDialog();
        dialog.setVisible(true);
        dialog.setSize(300, 300);
        JPanel panel = new JPanel(new FlowLayout());
        dialog.add(panel);

        JLabel labelName = new JLabel("Код рецепта");
        JTextField code = new JTextField(20);
        JLabel labelIngredients = new JLabel("Название");
        JTextField name = new JTextField(20);
        JLabel labelRecipe = new JLabel("Описание рецепта:код");
        JTextField recipeDescr = new JTextField(20);
        JLabel labelGroup = new JLabel("Автор:код");
        JTextField author = new JTextField(20);

        JButton button = new JButton("Добавить");
        button.addActionListener(e -> {
            String codeString = code.getText();
            String nameString = name.getText();
            String recipeString = recipeDescr.getText();
            String authorString = author.getText();

            controller.addRecipe(codeString, nameString, recipeString, authorString);
        });
        panel.add(labelName);
        panel.add(code);
        panel.add(labelIngredients);
        panel.add(name);
        panel.add(labelRecipe);
        panel.add(recipeDescr);
        panel.add(labelGroup);
        panel.add(author);
        panel.add(button);
    }
}
