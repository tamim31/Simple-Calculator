
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyDigitButton extends Button implements ActionListener  
{  
MyCalculator cl;  
  
//////////////////////////////////////////  
MyDigitButton(int x,int y, int width,int height,String cap, MyCalculator clc)  
{  
super(cap);  
setBounds(x,y,width,height);  
this.cl=clc;  
this.cl.add(this);  
addActionListener(this);  
}  
////////////////////////////////////////////////  
static boolean isInString(String s, char ch)  
{  
for(int i=0; i<s.length();i++) if(s.charAt(i)==ch) return true;  
return false;  
}  



/////////////////////////////////////////////////  
@Override
public void actionPerformed(ActionEvent ev)  
{  
 
/*String displayText = cl.displayLabel.getText();

        // Handle empty display or if the last character is already a sign
        if (displayText.isEmpty() || displayText.endsWith("+") || displayText.endsWith("-")) {
            return;
        }

        // Check if the last operation was an equals sign
        if (displayText.endsWith("=")) {
            // Clear the display and start a new calculation
            cl.displayLabel.setText("");
        }

        // Toggle the sign
        if (displayText.startsWith("-")) {
            cl.displayLabel.setText(displayText.substring(1));
        } else {
            cl.displayLabel.setText( "-" +displayText);
        }
    
        */
       
 
        
  
String tempText=((MyDigitButton)ev.getSource()).getLabel(); 
if(tempText.equals("."))  
{  
 if(cl.setClear)   
    {cl.displayLabel.setText("0.");cl.setClear=false;}  
 else if(!isInString(cl.displayLabel.getText(),'.'))  
    cl.displayLabel.setText(cl.displayLabel.getText()+".");  
 return;  
}  
int index=0;  
try{  
        index=Integer.parseInt(tempText);  
    }catch(NumberFormatException e){return;}  
  
if (index==0 && cl.displayLabel.getText().equals("0")) return;  
  
if(cl.setClear)  
            {cl.displayLabel.setText(""+index);cl.setClear=false;}  
else  
    cl.displayLabel.setText(cl.displayLabel.getText()+index);  
}//actionPerformed  
}//class defination  
  
  







    
