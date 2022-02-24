import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Reservas extends JFrame {

    private JTextField Nombre;
    private JTextField Apellidos;
    private JTextField Direccion;
    private JTextField Telefono;
    private JTextField email;
    private JTextField DNI;
    private JTextField TarjetaCredito;
    private JCheckBox estándarCheckBox;
    private JCheckBox balcónCheckBox;
    private JCheckBox suiteCheckBox;
    private JComboBox comboBox1;
    private JButton cancelarButton;
    private JButton limpiarButton;
    private JButton confirmarButton;
    private JButton calcularButton;
    private JTextField precioTotal;
    private JLabel textHabDisp;
    private JPanel Reservar;
    private JTextField Estandar;
    private JTextField Balcon;
    private JTextField Suite;

    String[] TipoEstancia = {"","Sin desayuno", "Con desayuno", "Media Pensión", "Pensión Completa"};

    public Reservas() {
        setContentPane(Reservar);
        setTitle("Reservas");
        setSize(900, 600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        comboBox1.addItem(TipoEstancia[0]);
        comboBox1.addItem(TipoEstancia[1]);
        comboBox1.addItem(TipoEstancia[2]);
        comboBox1.addItem(TipoEstancia[3]);
        comboBox1.addItem(TipoEstancia[4]);
        Estandar.setText("0");
        Balcon.setText("0");
        Suite.setText("0");

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                HotelLogin miHotel = new HotelLogin();
            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Nombre.setText("");
                Apellidos.setText("");
                Direccion.setText("");
                Telefono.setText("");
                email.setText("");
                DNI.setText("");
                TarjetaCredito.setText("");
                precioTotal.setText("");
                Estandar.setText("0");
                Balcon.setText("0");
                Suite.setText("0");
                estándarCheckBox.setSelected(false);
                balcónCheckBox.setSelected(false);
                suiteCheckBox.setSelected(false);
                comboBox1.setSelectedItem(TipoEstancia[0]);
            }
        });

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int precio=0;
                if(estándarCheckBox.isSelected()){
                    int numEntero1 = Integer.parseInt(Estandar.getText());
                    for(int i=0;i<numEntero1;i++){
                        precio+=20;
                    }
                }
                if(balcónCheckBox.isSelected()){
                    int numEntero2 = Integer.parseInt(Balcon.getText());
                    for(int i=0;i<numEntero2;i++){
                        precio+=25;
                    }
                }
                if(suiteCheckBox.isSelected()){
                    int numEntero3 = Integer.parseInt(Suite.getText());
                    for(int i=0;i<numEntero3;i++){
                        precio+=40;
                    }
                }

                if(comboBox1.getSelectedItem()=="Sin desayuno"){
                    precio+=5;
                }

                if(comboBox1.getSelectedItem()=="Con desayuno"){
                    precio+=35;
                }

                if(comboBox1.getSelectedItem()=="Media Pensión"){
                    precio+=47;
                }

                if(comboBox1.getSelectedItem()=="Pensión Completa"){
                    precio+=65;
                }
                String p=String.valueOf(precio);
                precioTotal.setText(p);
            }
        });

        estándarCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(estándarCheckBox.isSelected()){
                String s = "Has seleccionado estándar";
                PaginaPulsar estandar = new PaginaPulsar(s);
            }
            }
        });

        balcónCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(balcónCheckBox.isSelected()){
                    String s = "Has seleccionado balcón";
                    PaginaPulsar balcon = new PaginaPulsar(s);
                }
            }
        });

        suiteCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(suiteCheckBox.isSelected()){
                    String s = "Has seleccionado Suite";
                    PaginaPulsar Suite = new PaginaPulsar(s);
                }
            }
        });

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBox1.getSelectedItem()=="Sin desayuno"){
                    String s = "Has seleccionado Sin desayuno";
                    PaginaPulsar sin = new PaginaPulsar(s);
                }

                if(comboBox1.getSelectedItem()=="Con desayuno"){
                    String s = "Has seleccionado Con desayuno";
                    PaginaPulsar sin = new PaginaPulsar(s);
                }

                if(comboBox1.getSelectedItem()=="Media Pensión"){
                    String s = "Has seleccionado Media Pensión";
                    PaginaPulsar sin = new PaginaPulsar(s);
                }

                if(comboBox1.getSelectedItem()=="Pensión Completa"){
                    String s = "Has seleccionado Pensión Completa";
                    PaginaPulsar sin = new PaginaPulsar(s);
                }
            }
        });

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = "Reserva Confirmada";
                PaginaPulsar Confirmar = new PaginaPulsar(s);
            }
        });
    }
}
