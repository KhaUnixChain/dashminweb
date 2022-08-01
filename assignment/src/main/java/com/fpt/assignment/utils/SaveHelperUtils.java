package com.fpt.assignment.utils;

import com.fpt.assignment.model.Customer;
import com.fpt.assignment.model.Employee;

public class SaveHelperUtils {
    public static Employee employee = null;
    public static Customer customer = null;

    public static void clear() {
      employee = null;
      customer = null;
    }
}
