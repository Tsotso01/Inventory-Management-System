package Src;
import Src.data.DatabaseSetup;
import Src.ui.Menu;
public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Inventory Management System...");
    
        DatabaseSetup.initializeDatabase();
        Menu menu=new Menu();
        menu.displayMenu();
    }
}