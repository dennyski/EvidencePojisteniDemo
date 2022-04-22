package cz.denny.itccave;

import java.io.IOException;

public class ConsoleMenu {
    public static void menuMain() {
        printMenuTop();
        printMenuMain();
        printMenuTime();
        printMenuPrompt();
    }
    public static void menuSearch() {
        printMenuTop();
        printMenuSearch();
        printMenuTime();
        printMenuPrompt();
    }
    public static void menuExit() {
        printMenuTop();
        printMenuExit();
        printMenuTime();
    }
    public static void menuInfo() {
        String cmInfo = """

                ┌══════════════════════════════════════┐
                │ A simple application that allows     │
                │ users to manage insurance records.   │
                ├══════════════════════════════════════┤
                │ There really was a point I thought   │
                │ this is an over-ambitious project    │
                │ for the fact I have been learning    │
                │ Java development since the New Year  │
                │                                      │
                │          Dedicated to Zoe            │
                ├══════════════════════════════════════┤
                │  I N S U R A N C E    R E C O R D S  │
                │           by Denny © 2022            │
                └══════════════════════════════════════┘""";
        System.out.print(cmInfo);
    }
    public static void menuHelp() {
        String cmInfo = """

                ┌══════════════════════════════════════┐
                │                                      │
                │ Press 1 or letter A to create a new  │
                │ record. Pressing 2 or letter L will  │
                │ list all the records. 3 or S filters │
                │ through database by name & surname,  │
                │ by surname only and by Day of Birth  │
                │ in day.month.year format.            │
                │                                      │
                ├══════════════════════════════════════┤
                │  I N S U R A N C E    R E C O R D S  │
                │           by Denny © 2022            │
                └══════════════════════════════════════┘""";
        System.out.print(cmInfo);
    }
    public static void menuConfig() {
        String cmConfig = """

                ┌══════════════════════════════════════┐
                │                                      │
                │        Unimplemented  feature        │
                │                                      │
                └══════════════════════════════════════┘""";
        System.out.print(cmConfig);
    }
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                //command prompt
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                //linux terminal
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static void printMenuTop(){
        String s = """

                ┌══════════════════════════════════════┐
                │  I N S U R A N C E    R E C O R D S  │
                ├══════════════════════════════════════┤""";
        System.out.print(s);
    }
    private static void printMenuMain() {
        // StringBuilder approach
        StringBuilder sb = new StringBuilder();
        sb.append("\n│                                      │");
        sb.append("\n│ ").append("(A)dd new Insurance Policy").append("        1  │");
        sb.append("\n│ ").append("(L)ist All Insurance Policies").append("     2  │");
        sb.append("\n│ ").append("(S)earch for Insurance Policy").append("     3  │");  // by surname, polNo, phoneNo, dob
        sb.append("\n│ ").append("(E)xit Application").append("                4  │");
        sb.append("\n│ ").append("(H)elp (C)onfiguration (I)nfo").append("        │");
        sb.append("\n│                                      │");
        String cmMain = sb.toString();
        System.out.print(cmMain);
    }
    private static void printMenuSearch() {
        // Inline String
        String s=   "\n│                                      │" +
                    "\n│ " + "Filter by " + "(N)ame + Surname" + "        1  │" +
                    "\n│ " + "          " + "(S)urname" + "               2  │" +
                    "\n│ " + "          " + "(D)ay of Birth" + "          3  │" +
                    "\n│ " + "Return to (M)ain Menu" + "             4  │" +
                    "\n│                                      │";
        System.out.print(s);
    }
    private static void printMenuTime() {
        String s = "\n└═ by Δεννυ ΜΜΞΞΙΙ ─ " + DateTimeUtils.FORMAT_DATE_TIME.format(DateTimeUtils.getDateTime()) + " ═┘";
        System.out.print(s);
    }
    private static void printMenuPrompt() {
        //remember dos filenames 8+3?... Gosh I'm old
        String s = "\nA:\\INSURANC\\DEMO\\> ";
        System.out.print(s);
    }
    private static void printMenuExit() {
        String s = """

                │                                      │
                │   Thanks for using the application   │
                │     Your interest is appreciated     │
                │           by Denny © 2022            │
                │                                      │""";
        System.out.print(s);
    }

    @Override
    public String toString() {
        // text block
        return """
                ┌══════════════════════════════════════┐
                │  I N S U R A N C E\tR E C O R D S  │
                │\t\t\tby Denny © 2022\t\t\t   │
                └══════════════════════════════════════┘""";
    }
}

