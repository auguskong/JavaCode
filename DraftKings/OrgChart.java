import java.util.*;
import java.io.*;

class OrgChart {
    HashMap<Integer, Employee> map;
    ArrayList<Employee> roots;

    public OrgChart() {
        map = new HashMap<>();
        roots = new ArrayList<>();
    }

    class Employee {
        private int id;
        private int managerId;
        private String name;
        private ArrayList<Employee> workers;
        public Employee(int employeeId, int managerId, String name) {
            this.name = name;
            this.id = employeeId;
            this.managerId = managerId;
            workers = new ArrayList<>();
        }
    }

    public void addEmployee(int employeeId, int managerId, String name) {
        Employee e = new Employee(employeeId, managerId, name);
        map.put(employeeId, e);
        if (managerId == -1) {
            roots.add(e);
        } else {
            Employee manager = map.get(managerId);
            manager.workers.add(e);
        }
    }

    public void removeEmployee(int employeeId) {
        if (!map.containsKey(employeeId)) {
            return;
        }
        Employee e = map.get(employeeId);
        if (roots.contains(e)) {
            roots.remove(e);
            for (Employee report : e.workers) {
                roots.add(report);
            }
        }
        map.remove(e);
    }

    public void printChart() {
        for (Employee r : roots) {
            printHelper(r, 0);
        }
    }

    private void printHelper(Employee e, int level) {
        for (int i = 0; i < level * 2; i++) {
            System.out.print(" ");
        }
        System.out.printf(e.name + " [" + "%d" + "]", e.id);
        System.out.println("");
        for (Employee report : e.workers) {
            printHelper(report, level + 1);
        }
    }

    public int count(int employeeId) {
        int nums = 0;
        Employee root = map.get(employeeId);
        Queue<Employee> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Employee curr = q.poll();
            for (Employee report : curr.workers) {
                q.add(report);
                nums++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("test.txt"));
            String line = br.readLine();
            int numOfLines = Integer.parseInt(line);
            // System.out.println("lines: " + numOfLines);
            OrgChart org = new OrgChart();
            for (int i = 0; i < numOfLines; i++) {
                line = br.readLine();
                String[] strs = line.split(",");
                switch(strs[0]) {
                    case "add":
                        org.addEmployee(Integer.parseInt(strs[1]), Integer.parseInt(strs[3]), strs[2]);
                        break;
                    case "remove":
                        org.removeEmployee(Integer.parseInt(strs[1]));
                        break;
                    case "print":
                        org.printChart();
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("exception");
        }



        // org.addEmployee(10, -1, "Bob");
        // org.addEmployee(7, 10, "Peter");
        // org.addEmployee(14, 7, "A");
        // org.addEmployee(5, -1, "B");
        // System.out.println("num: " + org.count(10));
        // org.printChart();
        // org.removeEmployee(10);
        // System.out.println(" ==== ");
        // org.printChart();
    }


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        ConsoleProcessor processor = new ConsoleProcessor();
        processor.processAllLines();
    }
}

class ConsoleProcessor {

    public OrgChart orgChart = new OrgChart();

    public void processAllLines() {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        Integer numLines = 0;

        try {
           numLines = Integer.valueOf(line.trim());
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < numLines; i++) {
            processLine(in.nextLine());
        }

        in.close();
    }

    protected void processLine(String line) {
        String[] parsedCommand = line.split(",");

        // ignore empty lines
        if (parsedCommand.length == 0) {
            return;
        }

        switch (parsedCommand[0]) {
            case "add":
                orgChart.add(parsedCommand[1], parsedCommand[2], parsedCommand[3]);
                break;
            case "print":
                orgChart.print();
                break;
            case "remove":
                orgChart.remove(parsedCommand[1]);
                break;
            case "move":
                orgChart.move(parsedCommand[1], parsedCommand[2]);
                break;
            case "count":
                System.out.println(orgChart.count(parsedCommand[1]));
                break;
        }
    }
}

class OrgChart {
    HashMap<String, Employee> map;
    ArrayList<Employee> roots;
    public OrgChart() {
        map = new HashMap<>();
        roots = new ArrayList<>();
    }
    class Employee {
        private String id;
        private String managerId;
        private String name;
        private ArrayList<Employee> reports;
        public Employee(String employeeId,  String name, String managerId) {
            this.name = name;
            this.id = employeeId;
            this.managerId = managerId;
            reports = new ArrayList<>();
        }
    }
    public void add(String id, String name, String managerId)
    {
        Employee e = new Employee(id, name, managerId);
        if (map.containsKey(id)) {
            return;
        }
        map.put(id, e);
        if (managerId.equals("-1") || !map.containsKey(managerId)) {
            roots.add(e);
        } else {
            Employee manager = map.get(managerId);
            manager.reports.add(e);
        }
    }

    public void print()
    {
        for (Employee r : roots) {
            printHelper(r, 0);
        }
    }

    private void printHelper(Employee e, int level) {
        for (int i = 0; i < level * 2; i++) {
            System.out.print(" ");
        }
        System.out.printf(e.name + " [" + "%s" + "]", e.id);
        System.out.println("");
        for (Employee report : e.reports) {
            printHelper(report, level + 1);
        }
    }

    public void remove(String employeeId)
    {
        if (!map.containsKey(employeeId)) {
            return;
        }
        Employee e = map.get(employeeId);
        if (e.managerId.equals("-1")) {
            roots.remove(e);
            for (Employee report : e.reports) {
                roots.add(report);
            }
        } else {
            Employee higherManager = map.get(e.managerId);
            higherManager.reports.remove(e);
            for (Employee report : e.reports) {
                higherManager.reports.add(report);
            }
        }
        map.remove(employeeId);
    }

    public void move(String employeeId, String newManagerId)
    {
        if (!map.containsKey(employeeId) || !map.containsKey(newManagerId)) {
            return;
        }
        Employee e = map.get(employeeId);
        Employee newManager = map.get(newManagerId);
        newManager.reports.add(e);
        if (!e.managerId.equals("-1")) {
            Employee oldManager = map.get(e.managerId);
            oldManager.reports.remove(e);
        } else {
            roots.remove(e);
        }
    }

    public int count(String employeeId)
    {
        int nums = 0;
        Employee root = map.get(employeeId);
        Queue<Employee> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Employee curr = q.poll();
            for (Employee report : curr.reports) {
                q.add(report);
                nums++;
            }
        }
        return nums;
    }
}


}