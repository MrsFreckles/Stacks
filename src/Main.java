public class Main {
    public static void main(String[] args) {
        printKeller();
        System.out.println(palindromPruefen("Keller"));
        System.out.println(palindromPruefen("Anna"));
        System.out.println(palindromPruefen("bei liese sei lieb"));
        System.out.println(matheStacken("(1+1)"));
        String expression = "3 + 2 * (2 + 3)";
        System.out.println(matheStacken(expression));
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

    /*public static int matheStacken(String input){
        Stack<String> operation = new Stack();
        Stack<Integer> num = new Stack();
        int i = -1;

        while(input.length() > i) {
            i++;
            if(input.charAt(i) != '('){
                if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/'){
                    operation.push(input.charAt(i) + "");
                }
                if(input.charAt(i) != '(' && input.charAt(i) != ')' && input.charAt(i) != '*' && input.charAt(i) != '/' && input.charAt(i) != '+' && input.charAt(i) != '-'){
                    while(input.charAt(i) != '(' && input.charAt(i) != ')' && input.charAt(i) != '*' && input.charAt(i) != '/' && input.charAt(i) != '+' && input.charAt(i) != '-'){
                        int value = Integer.parseInt(input.charAt(i) + "");
                        num.push(value);
                        i++;
                    }
                }
                if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/'){
                    int a = num.top();
                    num.pop();
                    int b = num.top();
                    num.pop();
                    if(input.charAt(i) == '+'){
                        num.push(a + b);
                        operation.pop();
                    } else if(input.charAt(i) == '-'){
                        num.push(a - b);
                        operation.pop();
                    } else if(input.charAt(i) == '*'){
                        num.push(a * b);
                        operation.pop();
                    } else if(input.charAt(i) == '/'){
                        num.push(a / b);
                        operation.pop();
                    }
                }
            }
        }
        System.out.println(num.top().toString());
        return num.top();
    }*/


    public static int matheStacken(String input) {
            Stack<String> operation = new Stack<>();
            Stack<Integer> num = new Stack<>();
            int i = 0;

            while (i < input.length()) {
                char ch = input.charAt(i);

                // Skip spaces
                if (ch == ' ') {
                    i++;
                    continue;
                }

                // Handle numbers (including multi-digit numbers)
                if (Character.isDigit(ch)) {
                    StringBuilder numStr = new StringBuilder();
                    while (i < input.length() && Character.isDigit(input.charAt(i))) {
                        numStr.append(input.charAt(i));
                        i++;
                    }
                    num.push(Integer.parseInt(numStr.toString()));
                    continue; // Skip the index increment because we already processed the number
                }

                // Handle opening parenthesis
                if (ch == '(') {
                    operation.push("(");
                }
                // Handle closing parenthesis
                else if (ch == ')') {
                    while (!operation.isEmpty() && !operation.top().equals("(")) {
                        applyOperator(operation, num);
                    }
                    operation.pop(); // Remove the '('
                }
                // Handle operators (+, -, *, /)
                else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                    while (!operation.isEmpty() && precedence(operation.top()) >= precedence(String.valueOf(ch))) {
                        applyOperator(operation, num);
                    }
                    operation.push(String.valueOf(ch));
                }

                i++;
            }

            // Apply remaining operations in the stack
            while (!operation.isEmpty()) {
                applyOperator(operation, num);
            }

            return num.pop(); // The final result is the last number
        }

        // Helper method to apply an operator
        private static void applyOperator(Stack<String> operation, Stack<Integer> num) {
            String operator = operation.pop();
            int b = num.pop();
            int a = num.pop();

            switch (operator) {
                case "+":
                    num.push(a + b);
                    break;
                case "-":
                    num.push(a - b);
                    break;
                case "*":
                    num.push(a * b);
                    break;
                case "/":
                    num.push(a / b);
                    break;
            }
        }

        // Helper method to determine operator precedence
        private static int precedence(String operator) {
            if (operator.equals("+") || operator.equals("-")) {
                return 1;
            } else if (operator.equals("*") || operator.equals("/")) {
                return 2;
            }return 0;
    }
}