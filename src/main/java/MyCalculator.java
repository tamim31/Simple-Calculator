


import java.awt.*;  
import java.awt.event.*;  
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
public class MyCalculator extends Frame  
{  
  
public boolean setClear=true;  
double number, memValue;  
char op;  

String digitButtonText[] = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0" ,  "." }; 
String operatorButtonText[] = {"/", "sqrt", "*", "%", "-","x²", "x!","+", "log", "=" };  
  
String specialButtonText[] = {"DEL", "C", "CE" };  
  
MyDigitButton digitButton[]=new MyDigitButton[digitButtonText.length];  
MyOperatorButton operatorButton[]=new MyOperatorButton[operatorButtonText.length];  
MySpecialButton specialButton[]=new MySpecialButton[specialButtonText.length];  
  
Label displayLabel=new Label("0",Label.RIGHT);  
Label memLabel=new Label(" ",Label.RIGHT);  
  
final int FRAME_WIDTH=325,FRAME_HEIGHT=325;  
final int HEIGHT=30, WIDTH=30, H_SPACE=10,V_SPACE=10;  
final int TOPX=30, TOPY=50;  
///////////////////////////  
MyCalculator(String frameText)//constructor  
{  
super(frameText);  
  
int tempX=TOPX, y=TOPY;  
displayLabel.setBounds(tempX,y,240,HEIGHT);  
displayLabel.setBackground(Color.BLUE);  
displayLabel.setForeground(Color.WHITE);  
add(displayLabel);  
  
memLabel.setBounds(TOPX,  TOPY+HEIGHT+ V_SPACE,WIDTH, HEIGHT);  
add(memLabel);  
  

tempX=TOPX+1*(WIDTH+H_SPACE); y=TOPY+1*(HEIGHT+V_SPACE);  
for(int i=0;i<specialButton.length;i++)  
{  
specialButton[i]=new MySpecialButton(tempX,y,WIDTH*2,HEIGHT,specialButtonText[i], this);  
specialButton[i].setForeground(Color.RED);  
tempX=tempX+2*WIDTH+H_SPACE;  
}  
  
//set Co-ordinates for Digit Buttons  
int digitX=TOPX+WIDTH+H_SPACE;  
int digitY=TOPY+2*(HEIGHT+V_SPACE);  
tempX=digitX;  y=digitY;  
for(int i=0;i<digitButton.length;i++)  
{  
digitButton[i]=new MyDigitButton(tempX,y,WIDTH,HEIGHT,digitButtonText[i], this);  
digitButton[i].setForeground(Color.BLUE);  
tempX+=WIDTH+H_SPACE;  
if((i+1)%3==0){tempX=digitX; y+=HEIGHT+V_SPACE;}  
}  
  
//set Co-ordinates for Operator Buttons  
int opsX=digitX+2*(WIDTH+H_SPACE)+H_SPACE;  
int opsY=digitY;  
tempX=opsX;  y=opsY;  
for(int i=0;i<operatorButton.length;i++)  
{  
tempX+=WIDTH+H_SPACE;  
operatorButton[i]=new MyOperatorButton(tempX,y,WIDTH,HEIGHT,operatorButtonText[i], this);  
operatorButton[i].setForeground(Color.RED);  
if((i+1)%2==0){tempX=opsX; y+=HEIGHT+V_SPACE;}  
}  
  
addWindowListener(new WindowAdapter()  
{  
public void windowClosing(WindowEvent ev)  
{System.exit(0);}  
});  
  
setLayout(null);  
setSize(FRAME_WIDTH,FRAME_HEIGHT);  
setVisible(true);  
}  
//////////////////////////////////  
static String getFormattedText(double temp)  
{  
String resText=""+temp;  
if(resText.lastIndexOf(".0")>0)  
    resText=resText.substring(0,resText.length()-2);  
return resText;  
} 
/**
 * //for parenthesis
void evaluateExpression() {
      
        String expression = displayLabel.getText();

        if (!expression.isEmpty()) {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");

            try {
                // Evaluate the expression
                Object result = engine.eval(expression);
                
                // Display the result
                displayLabel.setText(result.toString());
            } catch (ScriptException e) {
                // Handle the exception if the expression is invalid
                displayLabel.setText("Error");
            }
        }
    *///
////////////////////////////////////////  
public static void main(String []args)  
{  
    MyCalculator myCalculator = new MyCalculator("Tamim's Calculator");  
}  

    
    
}  