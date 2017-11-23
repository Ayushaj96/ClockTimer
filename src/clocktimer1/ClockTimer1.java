import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class ClockTimer1 extends JFrame implements Runnable {

    private JLabel label;
   
    private final int hours;
    private final int minutes;
    private final int seconds;


     public void run() {
            long c = (hours * 3600 + 60 * minutes + seconds);
            while (true) {
                if(c<0)
                {
                    break;
                }
                else
                {
                try {
                String d=onSecondsUpdate(c--);
                label.setText(d);  
                    Thread.sleep(1000);
                    if(c==0)
                    {
                        onTimerEnd();
                    }
                } catch (InterruptedException x) {
                }
                }
            }

        }
     public static String onSecondsUpdate(long seconds)
     {
     long s = seconds % 60;
    long m = (seconds / 60) % 60;
    long h = (seconds / (60 * 60)) % 24;
   
    return String.format("%d:%02d:%02d", h,m,s);
   
     }
     
      void onTimerEnd()
     {
         label.setText("Finish");
     }
    public ClockTimer1(int hours, int minutes, int seconds) {
        this.hours = hours;
      this.minutes = minutes;
      this.seconds = seconds;
        label = new JLabel();
        add(label);
        
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        setVisible(true);
    }

    
    public static void main(String[] args){
        ClockTimer1 frame = new ClockTimer1(1,0,5);
        Thread t=new Thread(frame);
        t.start();
    }
}
   

