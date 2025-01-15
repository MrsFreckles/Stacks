public class Main {
    public static void main(String[] args) {
        printKeller();
        System.out.println(palindromPruefen("Keller"));
        System.out.println(palindromPruefen("Anna"));
        System.out.println(palindromPruefen("bei liese sei lieb"));
        System.out.println(matheStacken("(1+1)"));
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

    public static int matheStacken(String input){
        Stack<String> operation = new Stack();
        Stack<Integer> num = new Stack();

        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) != '(') {
                i++;
            }
            while (input.charAt(i) != '+' && input.charAt(i) != '-' && input.charAt(i) != '*' && input.charAt(i) != '/' && input.charAt(i) != ')' && input.charAt(i) != '(') {
                String temp = input.charAt(i) + "";
                System.out.println(input.charAt(i) + "");
                num.push(Integer.parseInt(temp));
                i++;
            }
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/') {
                System.out.println(input.charAt(i) + "");
                operation.push(input.charAt(i) + "");
            }
            if (input.charAt(i) == ')') {
                int a = num.top();
                num.pop();
                int b = num.top();
                num.pop();
                if (!operation.isEmpty()) {
                    if (operation.top().equals("+")) {
                        num.push(b + a);
                        operation.pop();
                    } else {
                        System.out.println("operationstack is empty");
                    }
                }
            }
        }
        if(num.isEmpty()){
            System.out.println("numstack is empty");
        } else {
            System.out.println(num.top().toString());
        }
        return num.top();
    }
}