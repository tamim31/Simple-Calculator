
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.log10;

class MyOperatorButton extends Button implements ActionListener  
{  
MyCalculator cl;  
  
MyOperatorButton(int x,int y, int width,int height,String cap, MyCalculator clc)  
{  
super(cap);  
setBounds(x,y,width,height);  
this.cl=clc;  
this.cl.add(this);  
addActionListener(this);  
}  
///////////////////////  
@Override
public void actionPerformed(ActionEvent ev)  
{  
String opText=((MyOperatorButton)ev.getSource()).getLabel();  
  
cl.setClear=true;  
double temp=Double.parseDouble(cl.displayLabel.getText());  
  
//


if(opText.equals("x!")) {
    try {
        double tempd = factorial(temp);
        cl.displayLabel.setText(MyCalculator.getFormattedText(tempd));
    } catch (ArithmeticException excp) {
        cl.displayLabel.setText("Error: Factorial is undefined for negative numbers and zero.");
    }
    return;
}


//
  if(opText.equals("x²"))  
    {  
    try  
        {double tempd= temp * temp;  
        cl.displayLabel.setText(MyCalculator.getFormattedText(tempd));}  
    catch(ArithmeticException excp)  
                        {cl.displayLabel.setText("Divide by 0.");}  
    return;  
    }
if(opText.equals("sqrt"))  
    {  
    try  
        {double tempd=Math.sqrt(temp);  
        cl.displayLabel.setText(MyCalculator.getFormattedText(tempd));}  
            catch(ArithmeticException excp)  
                    {cl.displayLabel.setText("Divide by 0.");}  
    return;  
    }  

if (opText.equals("log")) {
    try {
        double tempd = log10(temp);
        cl.displayLabel.setText(MyCalculator.getFormattedText(tempd));
    } catch (ArithmeticException excp) {
        cl.displayLabel.setText("Error: Cannot calculate logarithm of non-positive numbers.");
    }
    return;
}


if(!opText.equals("="))  
    {  
    cl.number=temp;  
    cl.op=opText.charAt(0);  
    return;  
    }  switch(cl.op)  
{  
case '+':  
    temp+=cl.number;break;  
case '-':  
    temp=cl.number-temp;break;  
case '*':  
    temp*=cl.number;break;  
case '%':  
    try{temp=cl.number%temp;}  
    catch(ArithmeticException excp)  
        {cl.displayLabel.setText("Divide by 0."); return;}  
    break;  
case '/':  
    try{temp=cl.number/temp;}  
        catch(ArithmeticException excp)  
                {cl.displayLabel.setText("Divide by 0."); return;}  
    break;  
}//switch  
  
cl.displayLabel.setText(MyCalculator.getFormattedText(temp));  
//cl.number=temp;  
}//actionPerformed  

    private double factorial(double temp) {
         if (temp == 0) {
        return 1;
    } else {
        return temp * factorial(temp - 1);
    }
    }
}//clas