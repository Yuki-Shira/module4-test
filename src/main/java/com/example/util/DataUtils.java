package com.example.util;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

// violation: missing class-level Javadoc
// violation: utility class with only static methods should have a private constructor
public class DataUtils {

    // violation: missing Javadoc
    // violation: method name is snake_case
    public static String format_date(Date d) {  // violation: non-descriptive param name
        // violation: magic string pattern
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(d);
    }

    // violation: missing Javadoc
    // violation: method name is snake_case
    // violation: raw List type
    public static double calculate_score(List items, int max) {
        double total = 0;
        // violation: raw type iteration
        for (Object item : items) {
            if (item != null) {
                // violation: unsafe cast with no explanation
                total += (Integer) item;
            }
        }
        // violation: magic number (100.0)
        return (total / max) * 100.0;
    }

    // violation: missing Javadoc
    // violation: method name is snake_case
    // violation: too many parameters (5 params)
    public static String build_report(String title, String author, String date, List items, boolean include_summary) {
        // violation: String concatenation instead of StringBuilder
        String report = "";
        report = report + "Title: " + title + "\n";
        report = report + "Author: " + author + "\n";
        report = report + "Date: " + date + "\n";

        // violation: raw type
        for (Object item : items) {
            report = report + "- " + item.toString() + "\n";
        }

        if (include_summary) {  // violation: snake_case variable
            // violation: magic number
            report = report + "Total items: " + items.size() + "\n";
            if (items.size() > 100) {  // violation: magic number
                report = report + "WARNING: Large report\n";
            }
        }

        System.out.println("Report generated: " + title);  // violation: System.out.println
        return report;
    }

    // violation: missing Javadoc
    public static boolean validate(String s) {   // violation: non-descriptive param name
        if (s == null) return false;
        if (s.length() == 0) return false;  // violation: should use isEmpty()
        // violation: magic number
        if (s.length() > 255) return false;
        return true;
    }
}
