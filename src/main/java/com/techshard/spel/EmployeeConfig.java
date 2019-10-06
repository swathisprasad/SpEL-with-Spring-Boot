package com.techshard.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Configuration
@PropertySource (name="employeeProperties", value="employee.properties")
@ConfigurationProperties
public class EmployeeConfig{


    @Value ("#{'${employee.names}'.split(',')}")
    private List<String> employeeNames;

    @Value ("#{'${employee.names}'.split(',')[0]}")
    private String firstEmployeeName;

    @Value ("${employee.type}")
    private List<String> employeeType;

    @Value ("#{${employee.age}}")
    private Map<String, Integer> employeeAge;

    @Value ("#{${employee.age}.two}")
    private String employeeAgeTwo;

    @Value ("#{${employee.age}['five'] ?: 30}")
    private Integer ageWithDefaultValue;

    @Value ("#{systemProperties['java.home']}")
    private String javaHome;

    @Value ("#{systemProperties['user.dir']}")
    private String userDir;


    @PostConstruct
    public void afterInitialize(){
        System.out.println(employeeNames);
        System.out.println(firstEmployeeName);
        System.out.println(employeeType);
        System.out.println(employeeAge);
        System.out.println(employeeAgeTwo);
        System.out.println(ageWithDefaultValue);
        System.out.println(javaHome);
        System.out.println(userDir);
    }
}
