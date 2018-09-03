package com.imokhonko;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        List<Employee> employeesList = new ArrayList<>();

        File document = new File("document.xml");
        Document doc = getXmlElement(document);

        getEmployes(doc, employeesList);

        String companyName = companyName(doc);
        System.out.println("Company name: " + companyName);

        String companyLocation = companyLocation(doc);
        System.out.println("Location: " + companyLocation);

        System.out.println("Employees: ");
        for (Employee employee : employeesList) {
            System.out.println(employee);
        }

    }

    private static Document getXmlElement(File f) throws ParserConfigurationException, IOException, SAXException {
        return DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .parse(f);
    }

    private static List<String> getEmployeeSkills(Node skillsNode) {
        List<String> skills = new ArrayList<>();
        NodeList employeeInfoSkills = skillsNode.getChildNodes();
        for (int i = 0; i < employeeInfoSkills.getLength(); i++) {
            Node skill = employeeInfoSkills.item(i);
            if(skill.getNodeType() == Node.ELEMENT_NODE) {
                String skillName = skill.getTextContent().trim();
                skills.add(skillName);
            }
        }
        return skills;
    }

    private static String companyName(Document doc) {
        String name = doc.getElementsByTagName("name").item(0).getTextContent();
        return name;
    }

    private static String companyLocation(Document doc) {
        String companyLocation = doc.getElementsByTagName("location").item(0).getTextContent();
        return companyLocation;
    }

    private static void getEmployes(Document doc, List<Employee> employeesList) {
        // get all employees nodes
        NodeList allEmployees = doc.getElementsByTagName("employees");

        // going through them
        for (int i = 0; i < allEmployees.getLength(); i++) {

            // get current employees node
            Node employeeByDepartment = allEmployees.item(i);

            // getting the department attribute
            String department = employeeByDepartment.getAttributes().getNamedItem("department").getTextContent();

            // if this employees node isn't empty then check employees
            if(employeeByDepartment.hasChildNodes()) {

                // get the child nodes of employee item
                NodeList employees = employeeByDepartment.getChildNodes();

                for (int j = 0; j < employees.getLength(); j++) {
                    Node employee = employees.item(j);

                    if(employee.getNodeType() == Node.ELEMENT_NODE) {

                        Employee employeeInstance = new Employee();
                        employeeInstance.setDepartment(department);

                        // getting the id of employee node
                        int employeeId = Integer.valueOf(employee.getAttributes().getNamedItem("id").getTextContent());
                        // set id for the Employee
                        employeeInstance.setId(employeeId);

                        // getting information about employee
                        NodeList employeeInfoList = employee.getChildNodes();
                        for (int k = 0; k < employeeInfoList.getLength(); k++) {
                            Node info = employeeInfoList.item(k);
                            if(info.getNodeType() == Node.ELEMENT_NODE) {

                                // checking what this node is
                                switch (info.getNodeName()) {
                                    case "name" : {
                                        String name = info.getTextContent().trim();
                                        employeeInstance.setName(name);
                                        break;
                                    }
                                    case "salary" : {
                                        int salary = Integer.valueOf(info.getTextContent().trim());
                                        String currency = info.getAttributes().getNamedItem("currency").getTextContent().trim();
                                        employeeInstance.setSalary(salary);
                                        employeeInstance.setCurrency(currency);
                                        break;
                                    }
                                    case "position" : {
                                        String position = info.getTextContent().trim();
                                        employeeInstance.setPosition(position);
                                        break;
                                    }
                                    case "skills" : {
                                        List<String> skills = getEmployeeSkills(info);
                                        employeeInstance.setSkills(skills);
                                        break;
                                    }
                                }

                            }
                        }

                        employeesList.add(employeeInstance);
                    }
                }

            }

        }
    }

}