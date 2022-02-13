import java.util.InputMismatchException;
import java.util.Scanner;

public class Main_Stack {
    public static void main(String[] args) {
        Stack st=null;
        int st_ch=1;
        Scanner sc = new Scanner(System.in);
        while(st_ch!=0){
            System.out.println("-----Welcome to the main menu----");
            System.out.println("1. Stack By Array");
            System.out.println("2. Stack By Singly Linked List");
            System.out.println("3. Stack By Doubly Linked List");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");
            try {
                st_ch = sc.nextInt();
                if(!(st_ch>= 0 && st_ch<=3)){
                    throw new InvalidRangeException("Value must in Integer range [0,3].\n");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Value must in Integer range [0,3].\n");
                sc.next();
                continue;
            }
            catch (MyMenuException e){
                System.out.println(e.getMessage());
            }
            if (st_ch==0) {
                System.out.println("Exiting the menu...");
                break;
            }
            if(st_ch==1){
                while(true) {
                    System.out.print("Enter the size of your array: ");
                    try {
                        int size = sc.nextInt();
                        st = new StackByArray(size);
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Value must be Integer range [1:n]");
                        sc.next();
                        continue;
                    }
                }
            }
            else if(st_ch==2){
                st=new StackBySinglyLinkedList();
            }
            else if(st_ch==3){
                st=new StackByDoublyLinkedList();
            }
            int choice=1;
            while(choice!=0){
                System.out.println("\n---Select the option you want to perform---");
                System.out.println("1. Push an element.");
                System.out.println("2. Print the size of list.");
                System.out.println("3. Pop from the stack.");
                System.out.println("4. Print the stack.");
                if(st_ch==1 || st_ch==3){
                    System.out.println("5. Print the stack from bottom to top.");
                }
                System.out.println("0. Exit");
                System.out.print("\nEnter your choice: ");
                try {
                    choice = sc.nextInt();
                    if(st_ch==2){
                        if(!(choice>= 0 && choice<=4))
                        throw new InvalidRangeException("Value must in Integer range [0,4].\n");
                    }
                    else {
                        if(!(choice>= 0 && choice<=5))
                            throw new InvalidRangeException("Value must in Integer range [0,5].\n");
                    }
                }
                catch (InputMismatchException e){
                    if(st_ch==2){
                        if(!(choice>= 0 && choice<=4))
                            System.out.println("Value must in Integer range [0,4].\n");
                    }
                    else {
                        if(!(choice>= 0 && choice<=5))
                            System.out.println("Value must in Integer range [0,5].\n");
                    }
                    sc.next();
                    continue;
                }
                catch (MyMenuException e){
                    System.out.println(e.getMessage());
                    continue;
                }
                switch (choice){
                    case 1 -> {
                        while (true) {
                            try {
                                System.out.print("Enter the element you want to insert: ");
                                st.push(sc.nextInt());
                                System.out.println("Value Inserted.");
                                break;
                            }
                            catch (InputMismatchException e){
                                System.out.println("Value must be Integer range [1:n]");
                                sc.next();
                                continue;
                            }
                            catch (MyStackException e){
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                    case 2 -> {
                        System.out.println("Size: "+st.getSize());
                    }
                    case 3-> {
                        try {
                            int pop=st.pop();
                            System.out.println("Popped element: "+pop);
                        }
                        catch (MyStackException e){
                            System.out.println(e.getMessage());
                        }
                    }
                    case 4->{
                        try {
                            st.display();
                        }
                        catch (MyStackException e){
                            System.out.println(e.getMessage());
                        }
                    }
                    case 5 -> {
                        try {
                            st.displayRev();
                        }
                        catch (MyStackException e){
                            System.out.println(e.getMessage());
                        }
                    }
                    case 0 -> System.out.println("Returning to the Main Menu...\n\n");
                }
            }
        }
        sc.close();
    }
}
