import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaPulsar extends JFrame{
    private JLabel Pulsa;
    private JButton aceptarButton;
    private JPanel Puls;

    public PaginaPulsar(String Pulsa){
        setContentPane(Puls);
        setSize(300,200);
        setVisible(true);
        this.Pulsa.setText(Pulsa);

        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

}
