package com.company;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    private static Scanner scan;
    private static Scanner user = new Scanner(System.in);
    private static BinaryTree tree;
    private static LinkedList<String> linkedList;
    private static PrintWriter writer;

    public static void readFile() throws FileNotFoundException {
        File file = new File("C:\\Users\\Marlene\\Workspace\\PairWork\\BinaryTreePull\\unsorteddict.txt");
        scan = new Scanner(file);
    }

    public static void linkedDictionaryCreatorInputer() throws FileNotFoundException, UnsupportedEncodingException {
        //Creation of linked list and line variable
        String fileContents = "";
        linkedList = new LinkedList<>();
        tree = new BinaryTree();

        while(scan.hasNextLine()) {
            fileContents = scan.nextLine();
            if (linkedList.size() == 0) {
                linkedList.add(0, fileContents);
            } else {
                for (int i = 0; i < linkedList.size(); i++) {
                    tree.insert(fileContents);
                }
            }
        }
    }
    public static void inOrder() throws FileNotFoundException, UnsupportedEncodingException {
        writer = new PrintWriter("C:\\Users\\Marlene\\Workspace\\PairWork\\BinaryTreePull\\sorteddict.txt", "UTF-8");
        tree.inorderTraversal(writer); //Calls method and writes to a file
    }

    public static String userInput(String args) throws IOException {
        if(args.equals("-1")){
            test();
        }
        else if(args.equals(tree.containsString(args))){
            System.out.println(args);
        }
        return args;
    }

    public static void test() throws IOException {
        BufferedReader reader1 = new BufferedReader(new FileReader("C:\\Users\\Marlene\\Workspace\\PairWork\\BinaryTreePull\\sorteddict.txt"));
        BufferedReader reader2 = new BufferedReader(new FileReader("C:\\Users\\Marlene\\Workspace\\PairWork\\BinaryTreePull\\sorteddictTest.txt"));
        String line1 = reader1.readLine();
        String line2 = reader2.readLine();
        boolean areEqual = true;
        int lineNum = 1;
        while (line1 != null || line2 != null)
        {
            if(line1 == null || line2 == null)
            {
                areEqual = false;
                break;
            }
            else if(! line1.equalsIgnoreCase(line2))
            {
                areEqual = false;
                break;
            }
            line1 = reader1.readLine();
            line2 = reader2.readLine();
            lineNum++;
        }
        if(areEqual)
        {
            System.out.println("Two files have same content.");
        }
        else
        {
            System.out.println("Two files have different content. They differ at line "+lineNum);
            System.out.println("File1 has "+line1+" and File2 has "+line2+" at line "+lineNum);
        }
        reader1.close();
        reader2.close();
    }

    public static void main(String ... args) throws IOException {

        readFile();

        linkedDictionaryCreatorInputer();

        inOrder();

        System.out.println("Please enter a string: ");
        String x = user.next();
        String y = userInput(x);
        System.out.println(y);
     }
}
