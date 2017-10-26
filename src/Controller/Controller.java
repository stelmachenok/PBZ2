package Controller;

import View.MainFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.sql.*;

/**
 * Created by y50-70 on 20.10.2017.
 */
public class Controller {
    private MainFrame mainFrame;

    private String url = "jdbc:mysql://localhost:3306/productsdb";
    private String login = "root";
    private String password = "Falcon";

    public Controller(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void showAllProviders() {
        JTable table = mainFrame.getTable();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Код");
        tableModel.addColumn("Название");
        tableModel.addColumn("Адрес");
        tableModel.addColumn("Телефон");
        table.setModel(tableModel);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = this.url;
            String login = this.login;
            String password = this.password;
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM provider");
                while (rs.next()) {
                    String row[] = new String[4];
                    row[0] = String.valueOf(rs.getInt(1));
                    row[1] = rs.getString(2);
                    row[2] = rs.getString(3);
                    row[3] = rs.getString(4);
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.addRow(row);
                    table.setModel(model);
                }
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showAllProducts() {
        JTable table = mainFrame.getTable();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Название");
        tableModel.addColumn("Список ингридиентов");
        tableModel.addColumn("Рецепт:код");
        tableModel.addColumn("Группа:код");
        table.setModel(tableModel);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = this.url;
            String login = this.login;
            String password = this.password;
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM product");
                while (rs.next()) {
                    String row[] = new String[4];
                    row[0] = rs.getString(1);
                    row[1] = rs.getString(2);
                    row[2] = String.valueOf(rs.getInt(3));
                    row[3] = String.valueOf(rs.getInt(4));
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.addRow(row);
                    table.setModel(model);
                }
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showAllMinimalcalories() {
        JTable table = mainFrame.getTable();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Название");
        tableModel.addColumn("Список ингридиентов");
        tableModel.addColumn("Рецепт:код");
        tableModel.addColumn("Группа:код");
        tableModel.addColumn("ккал/грамм");
        table.setModel(tableModel);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = this.url;
            String login = this.login;
            String password = this.password;
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT *\n" +
                        "FROM\n" +
                        "  (SELECT\n" +
                        "     pr.*,\n" +
                        "     i.KcalPerGrams\n" +
                        "   FROM Product pr, Recipe r, RecipeDescription rd, Ingredient i\n" +
                        "   WHERE pr.RecipeCode = r.Code AND r.RecipeDescriptionCode = rd.Code AND rd.IngredientCode = i.Code) t,\n" +
                        "  (SELECT MIN(i.KcalPerGrams) min\n" +
                        "   FROM Ingredient i) t1\n" +
                        "HAVING t.KcalPerGrams = t1.min;");
                while (rs.next()) {
                    String row[] = new String[5];
                    row[0] = rs.getString(1);
                    row[1] = rs.getString(2);
                    row[2] = String.valueOf(rs.getInt(3));
                    row[3] = String.valueOf(rs.getInt(4));
                    row[4] = String.valueOf(rs.getInt(5));
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.addRow(row);
                    table.setModel(model);
                }
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showAllProductsWithRecipe() {
        JTable table = mainFrame.getTable();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Название блюда");
        tableModel.addColumn("Название рецепта");
        table.setModel(tableModel);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = this.url;
            String login = this.login;
            String password = this.password;
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT\n" +
                        "  pr.Name,\n" +
                        "  r.Name\n" +
                        "FROM Product pr, recipe r\n" +
                        "WHERE pr.RecipeCode = r.Code;");
                while (rs.next()) {
                    String row[] = new String[2];
                    row[0] = rs.getString(1);
                    row[1] = rs.getString(2);
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.addRow(row);
                    table.setModel(model);
                }
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showPriceList(){
        JTable table = mainFrame.getTable();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Дата");
        tableModel.addColumn("Код поставщика");
        tableModel.addColumn("Название поставщика");
        tableModel.addColumn("Адрес поставщика");
        tableModel.addColumn("Телефон");
        tableModel.addColumn("Цена");
        table.setModel(tableModel);
    }

    public void updatePriceList() {
        JTable table = mainFrame.getTable();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Дата");
        tableModel.addColumn("Код поставщика");
        tableModel.addColumn("Название поставщика");
        tableModel.addColumn("Адрес поставщика");
        tableModel.addColumn("Телефон");
        tableModel.addColumn("Цена");
        table.setModel(tableModel);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = this.url;
            String login = this.login;
            String password = this.password;
            Connection con = DriverManager.getConnection(url, login, password);
            try {
//                Statement stmt = con.createStatement();
                PreparedStatement statement = con.prepareStatement("SELECT\n" +
                        "  i.WaybillDate,\n" +
                        "  pr.Code,\n" +
                        "  pr.Name,\n" +
                        "  pr.Address,\n" +
                        "  pr.Telephone,\n" +
                        "  w.Amount\n" +
                        "FROM Provider pr, Ingredient i, Waybill w\n" +
                        "WHERE i.WaybillDate = ? AND i.WaybillDate = w.Date AND i.ProviderCode = pr.Code AND pr.Name = ?;");
                statement.setDate(1, Date.valueOf(mainFrame.getDate().getText()));
                statement.setString(2, mainFrame.getProvider().getText());
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    String row[] = new String[6];
                    row[0] = String.valueOf(rs.getDate(1));
                    row[1] = String.valueOf(rs.getInt(2));
                    row[2] = rs.getString(3);
                    row[3] = rs.getString(4);
                    row[4] = rs.getString(5);
                    row[5] = String.valueOf(rs.getInt(6));
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.addRow(row);
                    table.setModel(model);
                }
                rs.close();
                statement.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        table.updateUI();
    }

    public void showAllRecipe() {
        JTable table = mainFrame.getTable();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Код");
        tableModel.addColumn("Название");
        tableModel.addColumn("Описание рецепта:код");
        tableModel.addColumn("Автор:код");
        table.setModel(tableModel);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = this.url;
            String login = this.login;
            String password = this.password;
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM recipe");
                while (rs.next()) {
                    String row[] = new String[4];
                    row[0] = String.valueOf(rs.getInt(1));
                    row[1] = rs.getString(2);
                    row[2] = String.valueOf(rs.getInt(3));
                    row[3] = String.valueOf(rs.getInt(4));
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.addRow(row);
                    table.setModel(model);
                }
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addProduct(String nameString, String ingredientString, String recipeString, String groupString) {
        JTable table = mainFrame.getTable();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Название");
        tableModel.addColumn("Список ингридиентов");
        tableModel.addColumn("Рецепт:код");
        tableModel.addColumn("Группа:код");
        table.setModel(tableModel);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = this.url;
            String login = this.login;
            String password = this.password;
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                String update = "INSERT INTO product VALUES (\'" + nameString + "\',\'" + ingredientString + "\'," + recipeString + "," + groupString + ");";
                stmt.executeUpdate(update);
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        showAllProducts();
    }

    public void updateProduct(String searchNameString, String nameString, String ingredientString, String recipeString, String groupString) {
        JTable table = mainFrame.getTable();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Название");
        tableModel.addColumn("Список ингридиентов");
        tableModel.addColumn("Рецепт:код");
        tableModel.addColumn("Группа:код");
        table.setModel(tableModel);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = this.url;
            String login = this.login;
            String password = this.password;
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                String update = "UPDATE product SET Name = \'" + nameString + "\', IngredientList = \'" + ingredientString + "\', RecipeCode = " + recipeString + ", ProductGroupCode = " + groupString + " WHERE  Name = \'" + searchNameString + "\';";
                stmt.executeUpdate(update);
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        showAllProducts();
    }

    public void deleteProduct(String searchNameString) {
        JTable table = mainFrame.getTable();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Название");
        tableModel.addColumn("Список ингридиентов");
        tableModel.addColumn("Рецепт:код");
        tableModel.addColumn("Группа:код");
        table.setModel(tableModel);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = this.url;
            String login = this.login;
            String password = this.password;
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                String update = "DELETE FROM Product WHERE Name = \'" + searchNameString + "\';";
                stmt.executeUpdate(update);
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        showAllProducts();
    }

    public void addRecipe(String codeString, String nameString, String recipeString, String authorString) {
        JTable table = mainFrame.getTable();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Код");
        tableModel.addColumn("Название");
        tableModel.addColumn("Описание рецепта:код");
        tableModel.addColumn("Автор:код");
        table.setModel(tableModel);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = this.url;
            String login = this.login;
            String password = this.password;
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                String update = "INSERT INTO recipe  VALUES (" + codeString + ",\'" + nameString + "\'," + recipeString + "," + authorString + ");";
                stmt.executeUpdate(update);
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        showAllRecipe();
    }

    public void updateRecipe(String searchCodeString, String codeString, String nameString, String recipeString, String authorString) {
        JTable table = mainFrame.getTable();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Код");
        tableModel.addColumn("Название");
        tableModel.addColumn("Описание рецепта:код");
        tableModel.addColumn("Автор:код");
        table.setModel(tableModel);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = this.url;
            String login = this.login;
            String password = this.password;
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                PreparedStatement statement = con.prepareStatement("UPDATE recipe SET Code = ?, Name =  ?, RecipeDescriptionCode = ?, AuthorCode = ? WHERE Code = ?");
                statement.setInt(1, Integer.valueOf(codeString));
                statement.setString(2, nameString);
                statement.setInt(3, Integer.valueOf(recipeString));
                statement.setInt(4, Integer.valueOf(authorString));
                statement.setInt(5, Integer.valueOf(searchCodeString));
                statement.executeUpdate();
                statement.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        showAllRecipe();
    }

    public void deleteRecipe(String deleteCodeString) {
        JTable table = mainFrame.getTable();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Код");
        tableModel.addColumn("Название");
        tableModel.addColumn("Описание рецепта:код");
        tableModel.addColumn("Автор:код");
        table.setModel(tableModel);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = this.url;
            String login = this.login;
            String password = this.password;
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                PreparedStatement statement = con.prepareStatement("DELETE FROM Recipe WHERE Code = ?;");
                statement.setInt(1, Integer.valueOf(deleteCodeString));
                statement.executeUpdate();
                statement.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        showAllRecipe();
    }

    public void addProvider(String codeString, String nameString, String addressString, String telephoneString) {
        JTable table = mainFrame.getTable();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Код поставщика");
        tableModel.addColumn("Название");
        tableModel.addColumn("Адрес");
        tableModel.addColumn("Телефон");
        table.setModel(tableModel);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = this.url;
            String login = this.login;
            String password = this.password;
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                PreparedStatement stmt = con.prepareStatement("INSERT INTO Provider VALUES (?,?,?,?);");
                stmt.setInt(1, Integer.valueOf(codeString));
                stmt.setString(2, nameString);
                stmt.setString(3, addressString);
                stmt.setString(4, telephoneString);
                stmt.executeUpdate();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        showAllProviders();
    }

    public void updateProvider(String searchCodeString, String codeString, String nameString, String addressString, String telephoneString) {
        JTable table = mainFrame.getTable();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Код поставщика");
        tableModel.addColumn("Название");
        tableModel.addColumn("Адрес");
        tableModel.addColumn("Телефон");
        table.setModel(tableModel);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = this.url;
            String login = this.login;
            String password = this.password;
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                PreparedStatement stmt = con.prepareStatement("UPDATE Provider SET Code = ?, Name = ?, Address = ?, Telephone = ? WHERE Code = ?");
                stmt.setInt(1, Integer.valueOf(codeString));
                stmt.setString(2, nameString);
                stmt.setString(3, addressString);
                stmt.setString(4, telephoneString);
                stmt.setInt(5, Integer.valueOf(searchCodeString));
                stmt.executeUpdate();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        showAllProviders();
    }

    public void deleteProvider(String deleteCodeString) {
        JTable table = mainFrame.getTable();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Код поставщика");
        tableModel.addColumn("Название");
        tableModel.addColumn("Адрес");
        tableModel.addColumn("Телефон");
        table.setModel(tableModel);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = this.url;
            String login = this.login;
            String password = this.password;
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                PreparedStatement stmt = con.prepareStatement("DELETE FROM Provider WHERE Code = ?");
                stmt.setInt(1, Integer.valueOf(deleteCodeString));
                stmt.executeUpdate();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        showAllProviders();
    }
}
