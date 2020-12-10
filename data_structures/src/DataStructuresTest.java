// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
//Driver class to test the data structures.
public class DataStructuresTest {

    public static void main(String[] args){
        // Test the SSL class.
        System.out.println("SLL Tests!");
        UnsortedSinglyLinkedList<String> testSSL = new UnsortedSinglyLinkedList<String>();

        testSSL.walkInsert("hello!");
        testSSL.walkInsert("world!");
        testSSL.insertFront("Kevin!");
        testSSL.walkInsert("this works?");
        System.out.println("SLL toString():\n" + testSSL);
        System.out.println("SLL size:" + testSSL.getSize());
        System.out.println("Location of 'world!': " + testSSL.findValue("world!"));

        // Test the linked queue class.
        System.out.println("\nLinked Queue Tests!");
        LinkedQueue<String> testQueue = new LinkedQueue<String>();

        testQueue.enqueue("Hello!");
        testQueue.enqueue("world!");
        System.out.println("Current queue:\n" + testQueue);
        System.out.println("Adding element 'Kevin!' to the queue.");
        testQueue.enqueue("Kevin!");
        System.out.println("Dequeuing front element: " + testQueue.dequeue());
        System.out.println("Current queue: " + testQueue);
        System.out.println("Queue size: " + testQueue.getSize());

        // Test the array queue class.
        System.out.println("\nArray Queue Tests!");
        ArrayQueue<String> testArrayQueue = new ArrayQueue<String>();

        testArrayQueue.enqueue("Hello!");
        testArrayQueue.enqueue("world!");
        System.out.println("Current queue:\n" + testArrayQueue);
        System.out.println("Adding element 'Kevin!' to the queue.");
        testArrayQueue.enqueue("Kevin!");
        System.out.println("Dequeuing front element: " + testArrayQueue.dequeue());
        System.out.println("Current queue: " + testArrayQueue);
        System.out.println("Queue size: " + testArrayQueue.getSize());

        // Test the linked stack class.
        System.out.println("\nLinked Stack Tests!");
        LinkedStack<String> testStack = new LinkedStack<String>();

        testStack.push("world!");
        testStack.push("hello");
        testStack.push("kevin");
        System.out.println("Current stack:\n" + testStack);
        System.out.println("Popping element: " + testStack.pop());
        System.out.println("Current stack:\n" + testStack);
        System.out.println("Stack top element: '" + testStack.top() + "'. Stack size: " + testStack.getSize());

        // Test the array stack class.
        System.out.println("\nArray Stack Tests!");
        ArrayStack<String> testArrayStack = new ArrayStack<String>();

        testArrayStack.push("world!");
        testArrayStack.push("hello");
        testArrayStack.push("kevin");
        System.out.println("Current stack:\n" + testArrayStack);
        System.out.println("Popping element: " + testArrayStack.pop());
        System.out.println("Current stack:\n" + testArrayStack);
        System.out.println("Stack top element: '" + testArrayStack.top() + "'. Stack size: " + testArrayStack.getSize());

        // Test the DLL class.
        System.out.println("\nDLL Tests!");
        UnsortedDoublyLinkedList<String> testDLL = new UnsortedDoublyLinkedList<String>();

        testDLL.walkInsert("hello!");
        testDLL.insertFront("Kevin!");
        testDLL.insertBack("world!");
        testDLL.walkInsert("this works?");

        System.out.println("DLL toString():\n" + testDLL);
        System.out.println("DLL size:" + testDLL.getSize());
        System.out.println("Location of 'world!' from front: " + testDLL.findFromFront("world!"));
        System.out.println("Location of 'world!' from back: " + testDLL.findFromBack("world!"));

        // Test the ArrayList class.
        System.out.println("\nArrayList Tests!");
        UnsortedArrayList<String> testList = new UnsortedArrayList<String>(1);

        testList.insertFront("Hello!");
        testList.insertBack("world!");
        testList.insert("Kevin", 2);
        System.out.println("ArrayList toString():\n" + testList);
        System.out.println("ArrayList capacity: " + testList.getCapacity());
        System.out.println("ArrayList size: " + testList.getLength());

        // Test the BST class.
        System.out.println("\nBST Tests!");
        BinarySearchTree<String> testBST = new BinarySearchTree<String>();

        testBST.insert("a", 10);
        testBST.insert("b", 20);
        testBST.insert("c", 30);
        testBST.insert("d", 40);
        testBST.insert("e", 50);
        testBST.insert("f", 25);
        System.out.println("Before deletion:\n" + testBST);
        testBST.delete(50);
        System.out.println("After deletion:\n" + testBST);

        // Test the AVL class.
        System.out.println("\nAVL Tree Tests!");
        AVLTree<String> testAVL = new AVLTree<String>();

        testAVL.insert("a", 10);
        testAVL.insert("b", 20);
        testAVL.insert("c", 30);
        testAVL.insert("d", 40);
        testAVL.insert("e", 50);
        testAVL.insert("f", 25);
        System.out.println("Balanced tree before deletions:\n" + testAVL);
        testAVL.delete(40);
        testAVL.delete(50);
        System.out.println("Balanced tree after deletions:\n" + testAVL);

        // Test the unordered map class.
        System.out.println("\nUnordered Map Tests!");
        UnorderedMap<Integer, String> testUnorderedMap = new UnorderedMap<Integer, String>();

        testUnorderedMap.put(0, "a");
        testUnorderedMap.put(1, "b");
        testUnorderedMap.put(2, "c");
        testUnorderedMap.put(3, "d");
        System.out.println("The map before removal:\n" + testUnorderedMap);
        System.out.println("Removing: " + testUnorderedMap.remove(1));
        System.out.println("Removing: " + testUnorderedMap.remove(2));
        System.out.println("The map after removal:\n" + testUnorderedMap);

        // Test the hash map class.
        System.out.println("\nHash Map Tests!");
    }
}
