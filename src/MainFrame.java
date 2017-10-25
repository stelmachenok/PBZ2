import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by y50-70 on 17.10.2017.
 */
public class MainFrame {
    private JFrame frame;
    private JPanel panel;
    private JTabbedPane tabbedPane;
    private Controller controller;


    private MainFrame() {
        createFrame();
        createController();
        createTabbedPane();
    }

    private void createController() {
        controller = new Controller(this);
    }

    private void createFrame() {
        frame = new JFrame("Предприятие");
        panel = new JPanel(new BorderLayout());
        frame.add(panel);
        frame.setSize(1920, 1030);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void createTabbedPane() {
        tabbedPane = new JTabbedPane();

        JPanel tabPanel;
        JPanel buttonPanel;
        JScrollPane scrollPane;
        JTable table;
        JButton buttonAdd;
        JButton buttonDelete;
        JButton buttonUpdate;
        String columnNames[];
        String columnData[][];

        columnNames = new String[]{"Название", "Список ингридиентов", "Рецепт:код", "Группа:код"};
        columnData = new String[][]{{"a", "a", "a", "a"}};
        table = new JTable(columnData, columnNames);
//        table.setTableHeader(new JTableHeader());
        scrollPane = new JScrollPane(table);
        tabPanel = new JPanel(new BorderLayout());
        tabPanel.add(scrollPane, BorderLayout.CENTER);

        buttonAdd = new JButton("Добавить");
        buttonAdd.addActionListener(e -> {
            new AddProductDialog(controller);
        });
        buttonDelete = new JButton("Удалить");
        buttonDelete.addActionListener(e -> {
            new DeleteProductDialog(controller);
        });
        buttonUpdate = new JButton("Обновить");
        buttonUpdate.addActionListener(e -> {
           new UpdateProductDialog(controller);
        });
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(buttonAdd);
        buttonPanel.add(buttonUpdate);
        buttonPanel.add(buttonDelete);
        tabPanel.add(buttonPanel,BorderLayout.SOUTH);
        tabbedPane.addTab("Продукты", tabPanel);



        columnNames = new String[]{"Код", "Название", "Описание рецепта:код", "Автор:код"};
        columnData = new String[][]{{"a", "a", "a", "a"}};
        table = new JTable(columnData, columnNames);
//        table.setTableHeader(new JTableHeader());
        scrollPane = new JScrollPane(table);
        tabPanel = new JPanel(new BorderLayout());
        tabPanel.add(scrollPane, BorderLayout.CENTER);


        buttonAdd = new JButton("Добавить");
        buttonAdd.addActionListener(e -> {
            new AddRecipeDialog(controller);
        });
        buttonDelete = new JButton("Удалить");
        buttonDelete.addActionListener(e -> {
//            new DeleteRecipeDialog(controller);
        });
        buttonUpdate = new JButton("Обновить");
        buttonUpdate.addActionListener(e -> {
//            new UpdateRecipeDialog(controller);
        });
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(buttonAdd);
        buttonPanel.add(buttonUpdate);
        buttonPanel.add(buttonDelete);
        tabPanel.add(buttonPanel,BorderLayout.SOUTH);


        tabbedPane.addTab("Рецепт", tabPanel);

        columnNames = new String[]{"Код", "Название", "Адрес", "Телефон"};
        columnData = new String[][]{{"a", "a", "a", "a"}};
        table = new JTable(columnData, columnNames);
//        table.setTableHeader(new JTableHeader());
        scrollPane = new JScrollPane(table);
        tabPanel = new JPanel(new BorderLayout());
        tabPanel.add(scrollPane, BorderLayout.CENTER);
        tabbedPane.addTab("Поставщик", tabPanel);

        columnNames = new String[]{"Название", "Список ингридиентов", "Рецепт:код", "Группа:код"};
        columnData = new String[][]{{"a", "a", "a", "a"}};
        table = new JTable(columnData, columnNames);
//        table.setTableHeader(new JTableHeader());
        scrollPane = new JScrollPane(table);
        tabPanel = new JPanel(new BorderLayout());
        tabPanel.add(scrollPane, BorderLayout.CENTER);
        tabbedPane.addTab("Малокалорийные блюда", tabPanel);

//        columnNames = new String[]{"Код", "Название"};
//        columnData = new String[][]{{"a", "a"}};
//        table = new JTable(columnData, columnNames);
////        table.setTableHeader(new JTableHeader());
//        scrollPane = new JScrollPane(table);
//        tabPanel = new JPanel(new BorderLayout());
//        tabPanel.add(scrollPane, BorderLayout.CENTER);
//        tabbedPane.addTab("Группа", tabPanel);

//        columnNames = new String[]{"Код", "Фамилия", "Имя", "Страна", "Год"};
//        columnData = new String[][]{{"a", "a", "a", "a", "a"}};
//        table = new JTable(columnData, columnNames);
////        table.setTableHeader(new JTableHeader());
//        scrollPane = new JScrollPane(table);
//        tabPanel = new JPanel(new BorderLayout());
//        tabPanel.add(scrollPane, BorderLayout.CENTER);
//        tabbedPane.addTab("Автор", tabPanel);


//        columnNames = new String[]{"Код", "Ингридиент:код", "Грамм на кг", "Способ приготовления:код"};
//        columnData = new String[][]{{"a", "a", "a", "a"}};
//        table = new JTable(columnData, columnNames);
////        table.setTableHeader(new JTableHeader());
//        scrollPane = new JScrollPane(table);
//        tabPanel = new JPanel(new BorderLayout());
//        tabPanel.add(scrollPane, BorderLayout.CENTER);
//        tabbedPane.addTab("Описание рецепта", tabPanel);


//        columnNames = new String[]{"Код", "Название"};
//        columnData = new String[][]{{"a", "a"}};
//        table = new JTable(columnData, columnNames);
////        table.setTableHeader(new JTableHeader());
//        scrollPane = new JScrollPane(table);
//        tabPanel = new JPanel(new BorderLayout());
//        tabPanel.add(scrollPane, BorderLayout.CENTER);
//        tabbedPane.addTab("Способ приготовления", tabPanel);


//        columnNames = new String[]{"Код", "Название", "Ккал/грамм", "Поставщик:код", "Накладная:Дата"};
//        columnData = new String[][]{{"a", "a", "a", "a", "a"}};
//        table = new JTable(columnData, columnNames);
////        table.setTableHeader(new JTableHeader());
//        scrollPane = new JScrollPane(table);
//        tabPanel = new JPanel(new BorderLayout());
//        tabPanel.add(scrollPane, BorderLayout.CENTER);
//        tabbedPane.addTab("Ингридиент", tabPanel);


//        columnNames = new String[]{"Дата", "Игридиент:код", "Сумма", "Грамм"};
//        columnData = new String[][]{{"a", "a", "a", "a"}};
//        table = new JTable(columnData, columnNames);
////        table.setTableHeader(new JTableHeader());
//        scrollPane = new JScrollPane(table);
//        tabPanel = new JPanel(new BorderLayout());
//        tabPanel.add(scrollPane, BorderLayout.CENTER);
//        tabbedPane.addTab("Накладная (на дату получения)", tabPanel);




        tabbedPane.addChangeListener(e -> {
            String tabName = tabbedPane.getTitleAt(tabbedPane.getSelectedIndex());
            switch (tabName){
                case "Продукты":{
                    controller.showAllProducts();
                    break;
                }
                case "Поставщик":{
                    controller.showAllProviders();
                    break;
                }
                case "Рецепт": {
                    controller.showAllRecipe();
                    break;
                }
                case "Малокалорийные блюда": {
                    controller.showAllMinimalcalories();
                    break;
                }
            }
        });

        panel.add(tabbedPane, BorderLayout.CENTER);
        controller.showAllProducts();
        panel.updateUI();
    }

    public JTable getTable() {
        JPanel panel = (JPanel) tabbedPane.getComponentAt(tabbedPane.getSelectedIndex());
        Component components[] = panel.getComponents();
        for (int i = 0; i < components.length; i++) {
            if (components[i] instanceof JScrollPane) {
                JScrollPane scrollPane = (JScrollPane) components[i];
                Component scrollPaneComponents[] = scrollPane.getComponents();
                for (int j = 0; j < scrollPaneComponents.length; j++) {
                    if (scrollPaneComponents[i] instanceof JViewport) {
                        Component viewPortComponents[] = ((JViewport) scrollPaneComponents[i]).getComponents();
                        for (int k = 0; k < viewPortComponents.length; k++) {
                            if (viewPortComponents[i] instanceof JTable)
                            return (JTable) viewPortComponents[0];
                        }
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
