package com.fastandflavorous.projetsep;

import com.fastandflavorous.projetsep.facade.costs.CostsFacade;
import com.fastandflavorous.projetsep.facade.login.AbstractUserFacade;
import com.fastandflavorous.projetsep.facade.login.EmployeeCell;
import com.fastandflavorous.projetsep.facade.stocks.AbstractStockFacade;
import com.fastandflavorous.projetsep.facade.stocks.StockCell;
import com.fastandflavorous.projetsep.model.stocks.Stock;
import com.fastandflavorous.projetsep.model.users.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class EmployeeController {

    @FXML
    AnchorPane listPane;
    @FXML
    ListView empListView;
    @FXML
    TextField emp_name, emp_email, emp_salary;
    @FXML
    CheckBox emp_isDir, emp_isHire;

    private static Employee currentEmployee;

    private static AbstractUserFacade facade;

    /**
     * Default constructor
     */
    public EmployeeController() {
        facade = AbstractUserFacade.getFacade();
    }

    public void returnToDirectorEmployees() throws IOException {
        FastAndFlavorousApplication.switchToDirectorEmployees();
    }

    public void returnToDirectorHome() throws IOException{
        FastAndFlavorousApplication.switchToDirectorHome();
    }

    public static void switchToDirectorEditEmployee(Employee e) {
        currentEmployee = e;
        try {
            FastAndFlavorousApplication.switchToDirectorEditEmployee();
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }

    public void switchToDirectorAddEmployee() {
        try {
            FastAndFlavorousApplication.switchToDirectorAddEmployee();
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }

    public void getAllEmployees(){
        Stage stage = (Stage) this.listPane.getScene().getWindow();
        ObservableList<Employee> list = FXCollections.observableArrayList();
        list.addAll(getEmployees());
        empListView.setItems(list);
        empListView.setCellFactory(new Callback<ListView<Employee>, ListCell<Employee>>() {
            @Override
            public ListCell<Employee> call(ListView<Employee> param) {
                return new EmployeeCell();
            }
        });
        stage.show();
    }

    public List<Employee> getEmployees(){
        return facade.getEmployees();
    }

    public void editEmployee() throws IOException {
        String salary = emp_salary.getText() == "" ? "0f" : emp_salary.getText();
        Boolean isDirector = emp_isDir.isSelected();
        Boolean isHired = emp_isHire.isSelected();
        float sal = Float.parseFloat(salary);
        currentEmployee.setSalary(sal);
        currentEmployee.setIsDir(isDirector);
        currentEmployee.setHired(isHired);
        facade.editEmployee(currentEmployee);
        currentEmployee = null;
        returnToDirectorEmployees();
    }

    public void addEmployee() throws IOException {
        String salary = emp_salary.getText() == "" ? "0f" : emp_salary.getText();
        String name = emp_name.getText();
        String password = "password";
        String email = emp_email.getText();
        Boolean isDirector = emp_isDir.isSelected();
        float sal = Float.parseFloat(salary);
        facade.addEmployee(name, email, password, sal, isDirector, true);
        returnToDirectorEmployees();
    }
}
