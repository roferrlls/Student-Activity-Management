import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import org.jdesktop.swingx.JXDatePicker;

public class DatePickerExample extends JPanel {

    public static void main(String[] args) {
java.util.Date dateChooser = null;
		//        JFrame frame = new JFrame("JXPicker Example");
//        JPanel panel = new JPanel();
//
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setBounds(400, 400, 250, 100);
//
//        JXDatePicker picker = new JXDatePicker();
//        picker.setDate(Calendar.getInstance().getTime());
//        picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
//
//        panel.add(picker);
//        frame.getContentPane().add(panel);
//
//        frame.setVisible(true);
		
		int d = dateChooser.getDate();
    	//Date date = dateChooser.getDate();
    	//DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(d);
    }
}