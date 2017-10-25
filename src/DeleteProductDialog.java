import javax.swing.*;
import java.awt.*;

/**
 * Created by y50-70 on 25.10.2017.
 */
public class DeleteProductDialog {
    Controller controller;

    public DeleteProductDialog(Controller controller) {
        this.controller = controller;
        JDialog dialog = new JDialog();
        dialog.setVisible(true);
        dialog.setSize(300, 150);
        JPanel panel = new JPanel(new FlowLayout());
        dialog.add(panel);

        JLabel labelSearchName = new JLabel("Удаление: Название");
        JTextField deleteName = new JTextField(20);
//        JLabel labelName = new JLabel("Название");
//        JTextField name = new JTextField(20);
//        JLabel labelIngredients = new JLabel("Ингридиент");
//        JTextField ingredient = new JTextField(20);
//        JLabel labelRecipe = new JLabel("Рецепт:код");
//        JTextField recipe = new JTextField(20);
//        JLabel labelGroup = new JLabel("Группа:код");
//        JTextField group = new JTextField(20);

        JButton button = new JButton("Удалить");
        button.addActionListener(e -> {
            String searchNameString = deleteName.getText();
//            String nameString = name.getText();
//            String ingredientString = ingredient.getText();
//            String recipeString = recipe.getText();
//            String groupString = group.getText();

            controller.deleteProduct(searchNameString);
        });

        panel.add(labelSearchName);
        panel.add(deleteName);
//        panel.add(labelName);
//        panel.add(name);
//        panel.add(labelIngredients);
//        panel.add(ingredient);
//        panel.add(labelRecipe);
//        panel.add(recipe);
//        panel.add(labelGroup);
//        panel.add(group);
        panel.add(button);
    }
}
