import emloyee_filter.EmployeeFilter;
import emloyee_filter.EmployeeObject;
import json_employee_add.AddEmployeeObject;
import json_employee_add.EmployeeAdding;
import json_employee_cards.Card;
import json_employee_cards.JsonEmployeeCards;
import json_file_bject.*;

import com.google.gson.*;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class JsonEmployeeFilter
{
      public static void main(String [] args) {

          Gson gson = new Gson();
          String jsonResultEmployee = gson.toJson(getEmployeeFilter("Files/ID.json", "Files/Employee.json"));
//          getEmployeeFilter("Files/ID.json", "Files/Employee.json");
//          System.out.println(jsonResultEmployee);

//          getEmployeeFilter("Files/ID.json", "Files/Employee.json");
//          getEmployeeCards("Files/ID.json", "FilesEmployee.json", "Files/Cards.json");

//          System.out.println(getAddEmployeeJson("Files/CardsNullToken.json", "Files/AddEmps.json"));

          System.out.println(getValidEmployeeForAdding( "Files/AddEmployee.json",
                  "Files/Employee.json", "Files/CardsNullToken.json"));
      }

    private static String getValidEmployeeForAdding(String fileAddEmployee,
                                                    String fileEmployee, String fileCardsNullToken) {

        Gson gson = new Gson();
        String textFromAddEmployee = readAllTextFromFile(fileAddEmployee);
        String fileGetEmployees = readAllTextFromFile(fileEmployee);
        JsonFileObject jsonFileObject = gson.fromJson(fileGetEmployees, JsonFileObject.class);
        EmployeeAdding addEmployees = gson.fromJson(textFromAddEmployee, EmployeeAdding.class);

        List<String> resultList = jsonFileObject.getEmployee().stream()
                .filter(f -> Objects.equals(f.getDepartmentName(), "ПРИНЯТЫЕ"))
                .map(Employee::getName)
                .collect(Collectors.toList());

        List<AddEmployeeObject> addEmployeeObjectFilter = addEmployees.getAddEmployees().getAddEmployee()
                .stream()
                .filter(oldCards -> resultList.stream()
                        .noneMatch(n -> n.equals(oldCards.getEmpName())))
                .collect(Collectors.toList())
                ;
        if (addEmployeeObjectFilter.size() > 0) {
//            System.out.println(addEmployeeObjectFilter);
            return getAddEmployeeJson(fileCardsNullToken, fileAddEmployee);
        }
        else {
            return "{ \"Message\": \"Данные сотрудники уже есть в папке \"ПРИНЯТЫЕ\"!\" }";
        }
    }

    private static String getAddEmployeeJson(String fileCardsNullToken, String fileAddEmployee) {

        Gson gson = new Gson();
        var fileCardsNull = readAllTextFromFile(fileCardsNullToken);
        var fileAddEmp = readAllTextFromFile(fileAddEmployee);
        JsonEmployeeCards jsonEmployeeCardsNull = gson.fromJson(fileCardsNull, JsonEmployeeCards.class);
        EmployeeAdding addEmployeeObject = gson.fromJson(fileAddEmp, EmployeeAdding.class);

        List<AddEmployeeObject> addEmployeeObjectList = addEmployeeObject
                .getAddEmployees().getAddEmployee().stream().toList();

        List<Long> jsonEmployeeTokenList = jsonEmployeeCardsNull.getCard().stream()
                .map(Card::getToken)
                .limit(addEmployeeObjectList.size())
                .collect(Collectors.toList());

        List<String> jsonEmployeeCodeList = jsonEmployeeCardsNull.getCard().stream()
                .map(Card::getCode)
                .limit(addEmployeeObjectList.size())
                .collect(Collectors.toList());

        addEmployeeObjectList
              .forEach(f -> new AddEmployeeObject(
                      f.setCode(f.getCode() + jsonEmployeeCodeList
                              .get(addEmployeeObjectList.indexOf(f))
                      ), f.setUserToken(f.getUserToken() +
                      jsonEmployeeTokenList.get(addEmployeeObjectList.indexOf(f)))
              ));
        List<AddEmployeeObject> addEmployeeObjectResult = new ArrayList<>(addEmployeeObject.getAddEmployees().getAddEmployee());
        return gson.toJson(addEmployeeObjectResult);
    }

    private static List<Card> getEmployeeCards(String fileFilter, String filteredFile, String fileCard) {
        Gson gson = new Gson();
        var fileText = readAllTextFromFile(fileCard);
        List<Employee> employeeFiltered = getEmployeeFilter(fileFilter, filteredFile);
        JsonEmployeeCards jsonEmployeeCards = gson.fromJson(fileText, JsonEmployeeCards.class);

        List<Long> getToken = employeeFiltered.stream().map(Employee::getToken).toList();

        List<Card> cardList = jsonEmployeeCards.getCard().stream()
                .filter(t -> getToken.stream()
                .anyMatch(ut -> ut.equals(t.getUserToken()))).collect(Collectors.toList());
        String jsonResult = gson.toJson(cardList);
//        System.out.println(jsonResult);
        return cardList;
    }

    private static List<Employee> getEmployeeFilter(String fileFilter, String filteredFile) {
        Gson gson = new Gson();
        var fileFilterText = readAllTextFromFile(fileFilter);
        var fileText = readAllTextFromFile(filteredFile);
        EmployeeFilter employeeFilter = gson.fromJson(fileFilterText, EmployeeFilter.class);
        JsonFileObject jsonFileObject = gson.fromJson(fileText, JsonFileObject.class);

        List<String> ids = employeeFilter.getEmployees().getEmployee().stream().map(EmployeeObject::getEmp).toList();

        List<Employee> resultList = jsonFileObject.getEmployee().stream()
                .filter(obj -> ids.stream()
                .anyMatch(i -> i.equals(obj.getAdditionalFields().stream().findFirst().get().getValue())))
                .collect(Collectors.toList());

        String jsonResult = gson.toJson(resultList);
//        writeJsonToFile(resultList, writeFile);
//        System.out.println(jsonResult);
        return resultList;
    }

//    private static void writeJsonToFile(List<Employee> resultList, String fileName) throws IOException {
//        Gson gson = new Gson();
//        try (Writer writer = new FileWriter(fileName)) {
//            gson.toJson(resultList, writer);
//        }
//    }

    private static String readAllTextFromFile(String filePath)
    {
        String content = "";
        try
        {
            content = new String ( Files.readAllBytes( Paths.get(filePath) ) );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return content;
    }
}