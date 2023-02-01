import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

class Application extends JFrame implements ActionListener {
    static JTextArea textArea = new JTextArea(4,20);
    static JButton  buttonDM = new JButton("D/M");
    static JButton buttonCE = new JButton("CE");
    static JButton  buttonC = new JButton("C");
    static JButton  buttonPlus = new JButton("+");
    static JButton  buttonMinus = new JButton("-");
    static JButton  buttonDivide = new JButton("/");
    static JButton  buttonResult = new JButton("=");
    static JButton  buttonABC = new JButton("abc");
    static JButton  buttonDEF = new JButton("def");
    static JButton  buttonGHI = new JButton("ghi");
    static JButton  buttonJKL = new JButton("jkl");
    static JButton  buttonMNO = new JButton("mno");
    static JButton  buttonPQR = new JButton("pqr");
    static JButton  buttonSTUV = new JButton("stuv");
    static JButton  buttonWXYZ = new JButton("wxyz");
    static JFrame frame = new JFrame("Lab 5 Zadanie 2");
    static Object previousSource;
    static boolean plusFlag = false;
    static boolean minusFlag = false;
    static boolean divisionFlag = false;
    static boolean resultFlag = false;
    static boolean bigChar = true;
    static StringBuilder text = new StringBuilder("");
    static boolean firstClick = true;
    static long start;
    static int numberOfClicks =0;
    Application() {}
    public static void main(String[] args)
    {
        Application app = new Application();
        JPanel panel = new JPanel();
        ContentGenerator.generateContent(app,panel,textArea,buttonDM,buttonC,buttonCE,buttonPlus,buttonMinus,buttonDivide,buttonResult,
                buttonABC,buttonDEF,buttonGHI,buttonJKL,buttonMNO,buttonPQR,buttonSTUV,buttonWXYZ);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(350, 350);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(buttonCE)){
            text.delete(text.length()-1,text.length());
            if(text.indexOf("+") < 0){
                plusFlag = false;
            }
            if(text.indexOf("-") < 0){
                minusFlag = false;
            }
            if(text.indexOf("/") < 0){
                divisionFlag = false;
            }
        }
        if(e.getSource().equals(buttonC)) {
            resetText();
        }
        if(e.getSource().equals(buttonDM)) {
            bigChar = !bigChar;
        }
        if(e.getSource().equals(buttonABC)){
            addChar(new ArrayList<>(Arrays.asList('a', 'b', 'c')),e);
        }
        if(e.getSource().equals(buttonDEF)){
            addChar(new ArrayList<>(Arrays.asList('d', 'e', 'f')),e);
        }
        if(e.getSource().equals(buttonGHI)){
            addChar(new ArrayList<>(Arrays.asList('g', 'h', 'i')),e);
        }
        if(e.getSource().equals(buttonJKL)){
            addChar(new ArrayList<>(Arrays.asList('j', 'k', 'l')),e);
        }
        if(e.getSource().equals(buttonMNO)){
            addChar(new ArrayList<>(Arrays.asList('m', 'n', 'o')),e);
        }
        if(e.getSource().equals(buttonPQR)){
            addChar(new ArrayList<>(Arrays.asList('p', 'q', 'r')),e);
        }
        if(e.getSource().equals(buttonSTUV)){
            addChar(new ArrayList<>(Arrays.asList('s', 't', 'u','v')),e);
        }
        if(e.getSource().equals(buttonWXYZ)){
            addChar(new ArrayList<>(Arrays.asList('w', 'x', 'y','z')),e);
        }
        if(e.getSource().equals(buttonPlus)){
            if(plusFlag||minusFlag||divisionFlag){
                JOptionPane.showMessageDialog(frame,"Nie można podać dwa razy znaku operacji!");
                text = new StringBuilder("");
            }else{
                text.append("+");
                plusFlag = true;
            }
        }
        if(e.getSource().equals(buttonMinus)){
            if(plusFlag||minusFlag||divisionFlag){
                JOptionPane.showMessageDialog(frame,"Nie można podać dwa razy znaku operacji!");
                text = new StringBuilder("");
            }else{
                text.append("-");
                minusFlag = true;
            }
        }
        if(e.getSource().equals(buttonDivide)){
            if(plusFlag||minusFlag||divisionFlag){
                JOptionPane.showMessageDialog(frame,"Nie można podać dwa razy znaku operacji!");
                text = new StringBuilder("");
            }else{
                text.append("/");
                divisionFlag = true;
            }
        }
        if(e.getSource().equals(buttonResult)){
            text.append("=");
            if(plusFlag||minusFlag||divisionFlag){
                if(plusFlag){
                    String sub1 = text.substring(0,text.indexOf("+"));
                    String sub2 = text.substring(text.indexOf("+")+1,text.length()-1);
                    text.append(sub1).append(sub2);
                }
                if(minusFlag){
                    String sub1 = text.substring(0,text.indexOf("-"));
                    String sub2 = text.substring(text.indexOf("-")+1,text.length()-1);
                    String res = sub1.replaceAll(sub2,"");
                    text.append(res);
                }
                if(divisionFlag){
                    String longestString ="";
                    String sub1 = text.substring(0,text.indexOf("/"));
                    String sub2 = text.substring(text.indexOf("/")+1,text.length()-1);
                    for(int i = 0;i<sub1.length();i++){
                        for(int j = i+1;j<=sub1.length();j++){
                            if(sub2.contains(sub1.substring(i,j)) && sub1.substring(i,j).length() > longestString.length()){
                                longestString = sub1.substring(i,j);
                            }
                        }
                    }
                    text.append(longestString);
                }
                resultFlag = true;
            }else{
                JOptionPane.showMessageDialog(frame,"Nie podano znaku operacji!");
            }
        }
        textArea.setText(String.valueOf(text));
    }

    public ArrayList<Character> getChars(ArrayList<Character> chars){
        if(bigChar){
            ArrayList<Character> bigChars = new ArrayList<>();
            for(int i = 0;i < chars.size();i++){
                bigChars.add((char)(chars.get(i)-32));
            }
            return bigChars;
        }else{
            return chars;
        }
    }
    public void addChar(ArrayList<Character> listOfChars,ActionEvent e){
        if(resultFlag){
            resetText();
        }
        if(previousSource!=e.getSource()){
            firstClick = true;
            numberOfClicks = 0;

        }
        ArrayList<Character> list = getChars(listOfChars);
        if(firstClick){
            firstClick = false;
            text.append(list.get(0));
        }else{
            if((System.currentTimeMillis() - start)>1000){
                text.append(list.get(0));
                firstClick = true;
                numberOfClicks = 0;
            }else{
                text.setCharAt(text.length()-1,list.get(numberOfClicks %list.size()));
            }
        }
        start = System.currentTimeMillis();
        numberOfClicks++;
        previousSource = e.getSource();
    }
    private void resetText() {
        text = new StringBuilder("");
        plusFlag = false;
        minusFlag = false;
        divisionFlag = false;
        resultFlag = false;
    }
}