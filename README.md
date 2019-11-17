> For previous elements please refer to the README.md file in the LinkedDict repository: https://github.com/lantzmarlene/LinkedDict/blob/master/README.md
> For elements pertaining to the test refer to the README.md file in the BinaryTreeTest repository: https://github.com/lantzmarlene/BinaryTreeTest/blob/testing/README.md

## 4.0) Coding Principles

### 4.1) Principle #1 -- Meaningful Names

As stated in the slides provided by the professor "Good names takes time but saves on the long run". To do this part of the assignment, we went through the code and analysed each variable. If we could not explain the variable and what it did, we renamed it to a more explicit name so that it is easily understandable. We made it so that when reading a line of code it is almost similar to reading a sentence. 

Here is an example of some variables we changed:

    //Before:
    System.out.println("Please enter a string: ");
        String x = user.next();
        String y = userInput(x);
        System.out.println(y);
    ============================================================
    //After:
    System.out.println("Please enter a string: ");
        String userInputRecord = userScanner.next();
        System.out.println(userInput(userInputRecord));

You can see that before the Strings were labelled x and y. Without prior context no one would know what these variables do, however we changed them to show what they did. The variable x represented the storing of the record that the user inputs, moreover we got rid of the String y by condensing it into a simple print statement by calling the function and passing our record as an argument. 

### 4.2) Principle #2 -- Keep Functions Small

The smaller the function, the more readable it is. Throughout our programme we ensured that our functions would not contain mor ethan 3 arguments. Upon looking through our code, all of our functions pass less than 3 arguments. For this part we did not change any of the functions or parameters passed.

### 4.3) Principle #3 -- Avoid Redundant Commenting

Here we did get rid of some redundant commeting, for example we kept writing the commend in functions with a root Node "hidden root node" with the intent to remind ourselves that we need to go through another method to reach that Node. We got rid of only one unnecessary commend. We felt the other comments we had were not redundant and actually added to further explain our code in the event of confusion. 

### 4.4) Principle #4 -- Single Responsibility Principle

The Single Responsibility Principle stipulates that a class or method should be modified for ONE reason, this means that the entity should focus itself on one particular goal. A way we solved this principle is with the technique provided by Professor Chelu which is to gather together the things that change for the same reason and separate those that change for different reasons. Below is the list of the various entities with a short description.
 
| Entities | Functionality |
|:--------:|:-------------:|
| main() | Executes all the Main Class |
| readFile() | Finds the text file to be converted and reads from it |
| createLinkedDictionaryInputer() | Creation of LinkedList and BinaryTree for storage of Dictionary items from text file |
| putInOrder() | Puts the Dictionary in order after storing |
| userInput() | Reads user input and outputs whether the word is in the dictionary and in what position |
| test() | Opens test files and compares them against each other |

### 4.5) Principle #5 -- Don't Repeat Yourself

We ensured to avoid any repetition throughout the code by encapsulating everything within methods. As you can see in our main method, nothing is repeated or called twice as everything that is needed to be called again is done within those methods. 

    public static void main(String ... args) throws IOException {

        readFile();
        createlinkedDictionaryInputer();
        putInOrder();

        System.out.println("Please enter a string: ");
        String userInputRecord = userScanner.next();
        System.out.println(userInput(userInputRecord));
     }
    }

Another example that is within one of these methods is the while loop within the createLinkedDictionaryInputer() method. Here each instance of a the BinaryTree tree and LinkedList linkedList have methods that are called once moreover the for loops and if statements each allow repetition to keep adding data if need be. 

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
        
### 4.6) Principle #6 -- Keep Your Code Simple

Again to keep te code as simple as possible we avoided very complex and verbose statements. Moreover we attempted to segment complex parts especially methods so that no more than three arguments are entered into each (we generally tried to keep them at most one, however at times two arguments were needed).  

### 4.7) Principle #7 -- You Ain't Gonna Need It

Upon reviewing our code, we noticed there were some unnecessary methods that we hardcoded but never actually used in the actual implementation within our main method. For that reason we took them out entirely. 

The main unuseful code that comes to mind is the binarytree size method. We actually used the size of the linked list created that is then converted into a binary tree. 

The two methods taken out because we ain't be needing it:

    public int size(){
        return size(root);
    }

    //gets the size of the Binary Tree
    public int size(Node node)
    {
        if (node == null)
            return 0;
        else
            return(size(node.left) + 1 + size(node.right));
    }
    
  
