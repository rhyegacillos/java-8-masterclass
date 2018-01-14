package section10.innerClass;

import java.util.Scanner;

public class ButtonDemoApp {

    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");

    public static void main(String[] args) {
        class ClickListener implements Button.OnClickListener{
            @Override
            public void onClick(String title) {
                System.out.println(title + " was click");
            }
            public ClickListener() {
                System.out.println("Ive been attached");
            }
        }
        btnPrint.setOnClickListener(new ClickListener());
        listen();
    }

    public static void listen() {
        boolean quit = false;
        while (!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    btnPrint.onClick();

            }
        }
    }
}
