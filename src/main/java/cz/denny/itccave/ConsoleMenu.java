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
                │\t\t\t\t\t\t\t\t\t   │
                │\t\t\tDedicated to Zoe\t       │
                ├══════════════════════════════════════┤
                │  I N S U R A N C E\tR E C O R D S  │
                │\t\t\tby Denny © 2022\t\t\t   │
                └══════════════════════════════════════┘""";
        System.out.print(cmInfo);
    }
    public static void menuHelp() {
        String cmInfo = """

                ┌══════════════════════════════════════┐
                │\t\t\t\t\t\t\t\t\t   │
                │ Press 1 or letter A to create a new  │
                │ record. Pressing 2 or letter L will  │
                │ list all the records. 3 or S filters │
                │ through database by name & surname,  │
                │ by surname only and by Day of Birth  │
                │ in day.month.year format.            │
                │\t\t\t\t\t\t\t\t\t   │
                ├══════════════════════════════════════┤
                │  I N S U R A N C E\tR E C O R D S  │
                │\t\t\tby Denny © 2022\t\t\t   │
                └══════════════════════════════════════┘""";
        System.out.print(cmInfo);
    }
    public static void menuConfig() {
        String cmConfig = """

                ┌══════════════════════════════════════┐
                │\t\t\t\t\t\t\t\t\t   │
                │\t\tUnimplemented  feature\t\t   │
                │\t\t\t\t\t\t\t\t\t   │
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
                │  I N S U R A N C E\tR E C O R D S  │
                ├══════════════════════════════════════┤""";
        System.out.print(s);
    }
    private static void printMenuMain() {
        // StringBuilder approach
        StringBuilder sb = new StringBuilder();
        sb.append("\n│\t\t\t\t\t\t\t\t\t   │");
        sb.append("\n│ ").append("(A)dd new Insurance Policy").append("\t\t1  │");
        sb.append("\n│ ").append("(L)ist All Insurance Policies").append("\t\t2  │");
        sb.append("\n│ ").append("(S)earch for Insurance Policy").append("\t\t3  │");  // by surname, polNo, phoneNo, dob
        sb.append("\n│ ").append("(E)xit Application").append("\t\t\t\t4  │");
        sb.append("\n│ ").append("(H)elp (C)onfiguration (I)nfo").append("\t\t   │");
        sb.append("\n│\t\t\t\t\t\t\t\t\t   │");
        String cmMain = sb.toString();
        System.out.print(cmMain);
    }
    private static void printMenuSearch() {
        // Inline String
        String s=   "\n│\t\t\t\t\t\t\t\t\t   │" +
                    "\n│ " + "Filter by\t" + "(N)ame + Surname" + "\t\t1  │" +
                    "\n│ " + "\t\t\t" + "(S)urname" + "\t\t\t\t2  │" +
                    "\n│ " + "\t\t\t" + "(D)ay of Birth" + "\t\t\t3  │" +
                    "\n│ " + "Return to (M)ain Menu" + "\t\t\t\t4  │" +
                    "\n│\t\t\t\t\t\t\t\t\t   │";
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

                │\t\t\t\t\t\t\t\t\t   │
                │\tThanks for using the application   │
                │\t Your interest is appreciated\t   │
                │\t\t\tby Denny © 2022\t\t\t   │
                │\t\t\t\t\t\t\t\t\t   │""";
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

