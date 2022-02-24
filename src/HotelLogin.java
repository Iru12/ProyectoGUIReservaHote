import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelLogin extends JFrame{
    private JTextField Usuario;
    private JTextField Contrasena;
    private JButton limpiarButton;
    private JButton entrarButton;
    private JPanel Login;
    private JLabel textoContrasena;

    public HotelLogin(){
        setContentPane(Login);
        setTitle("Hotel Montealegre");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario.setText("");
                Contrasena.setText("");
                textoContrasena.setText("");
            }
        });

        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = "Paco";
                String contrasena = "1234";
                if(Usuario.getText().equals(usuario) && Contrasena.getText().equals(contrasena)){
                    textoContrasena.setText("");
                    dispose();
                    Reservas reserva = new Reservas();
                }
                else{
                    textoContrasena.setText("⚠ Usuario o contraseña incorrectos.");
                }
            }
        });
    }

    public static void main(String[] args) {
        HotelLogin miHotel = new HotelLogin();
    }
}
