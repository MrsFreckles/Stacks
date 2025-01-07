public class Main {
    public static void main(String[] args) {
        printKeller();
        System.out.println(palindromPruefen("Keller"));
        System.out.println(palindromPruefen("Anna"));
        System.out.println(palindromPruefen("bei liese sei lieb"));
    }

    public static void printKeller() {
        Stack stack = new Stack();
        String word = "Keller";
        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i) + "");
        }
        word = "";
        while (!stack.isEmpty()) {
            word = word + stack.top();
            stack.pop();
        }
        System.out.println(word);
    }

    public static boolean palindromPruefen(String wort){
        Stack k = new Stack();

        for (int i = 0; i < wort.length(); i++) {
            k.push(wort.charAt(i) + "");
        }


        String newWort = "";
        while(!k.isEmpty()){
            newWort = newWort + k.top();
            k.pop();
        }
        return newWort.replace(" ", "").equalsIgnoreCase(wort.replace(" ", ""));
    }
}