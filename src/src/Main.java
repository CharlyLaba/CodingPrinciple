package src;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    private static Scanner readFileScanner;
    private static Scanner userScanner = new Scanner(System.in);
    private static BinaryTree tree;
    private static LinkedList<String> linkedList;
    private static PrintWriter writeToFile;

    public static void readFile() throws FileNotFoundException {
        File fileToSort = new File("C:\\Users\\Marlene\\Workspace\\CodingPrinciples\\src\\src\\unsorteddict.txt");
        readFileScanner = new Scanner(fileToSort);
    }

    public static void createLinkedDictionaryInputer() throws FileNotFoundException, UnsupportedEncodingException {
        String fileContents = "";
        linkedList = new LinkedList<>();
        tree = new BinaryTree();

        while(readFileScanner.hasNextLine()) {
            fileContents = readFileScanner.nextLine();
            if (linkedList.size() == 0) {
                linkedList.add(0, fileContents);
            } else {
                for (int i = 0; i < linkedList.size(); i++) {
                    tree.insertData(fileContents);
                }
            }
        }
    }

    public static void putInOrder() throws FileNotFoundException, UnsupportedEncodingException {
        writeToFile = new PrintWriter("C:\\Users\\Marlene\\Workspace\\CodingPrinciples\\src\\src\\sorteddict.txt", "UTF-8");
        tree.inorderTraversal(writeToFile); //Calls method and writes to a file
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
        BufferedReader fileOriginal = new BufferedReader(new FileReader("C:\\Users\\Marlene\\Workspace\\CodingPrinciples\\src\\src\\sorteddict.txt"));
        BufferedReader fileToCompare = new BufferedReader(new FileReader("C:\\Users\\Marlene\\Workspace\\CodingPrinciples\\src\\src\\sorteddictTest.txt"));
        String lineOriginal = fileOriginal.readLine();
        String lineToCompare = fileToCompare.readLine();
        boolean areEqual = true;
        int lineNum = 1;
        while (lineOriginal != null || lineToCompare != null)
        {
            if(lineOriginal == null || lineToCompare == null)
            {
                areEqual = false;
                break;
            }
            else if(! lineOriginal.equalsIgnoreCase(lineToCompare))
            {
                areEqual = false;
                break;
            }
            lineOriginal = fileOriginal.readLine();
            lineToCompare = fileToCompare.readLine();
            lineNum++;
        }
        if(areEqual)
        {
            System.out.println("Two files have same content.");
        }
        else
        {
            System.out.println("Two files have different content. They differ at line "+lineNum);
            System.out.println("File1 has "+lineOriginal+" and File2 has "+lineToCompare+" at line "+lineNum);
        }
        fileOriginal.close();
        fileToCompare.close();
    }

    public static void main(String ... args) throws IOException {

        readFile();
        createLinkedDictionaryInputer();
        putInOrder();

        System.out.println("Please enter a string: ");
        String userInputRecord = userScanner.next();
        System.out.println(userInput(userInputRecord));
    }
}
