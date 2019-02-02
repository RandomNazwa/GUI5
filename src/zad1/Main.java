/**
 *
 *  @author Trembowska Katarzyna S18233
 *
 */

package zad1;


import java.awt.BorderLayout;
import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;


class CelsiusToFarenheitList extends AbstractListModel {

    @Override
    public Object getElementAt(int item) {
        int celsius = item-70;
        double farenheit = celsius*1.8+32;
        return celsius+" stopni C = "+Math.round(farenheit*10.0)/10.0+" stopni F";   //wynik w farenheitah zaokrąglony do części dzesiętnej
    }

    @Override
    public int getSize() {
        return 131;         //od -70 do 60
    }

}

public class Main extends JFrame {

    public static void main(String ... args) {

        JFrame frame = new JFrame("Konwersja temperatury w st. Celsjusza na st. Farenheita");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 200);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        JList list = new JList(new CelsiusToFarenheitList());
        JScrollPane scrollPane = new JScrollPane(list);
        frame.add(scrollPane);
        frame.setVisible(true);
    }
}