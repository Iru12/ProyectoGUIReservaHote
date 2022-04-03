import PaqC08.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

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
    private JTextField FechaE;
    private JTextField FechaS;
    private JButton Anular;
    private JTextArea MapaHotel;
    private static Hotel h = new Hotel();
    private Cliente c = new Cliente();
    private FileOutputStream fos = new FileOutputStream("Hotel.dat");
    private ObjectOutputStream salida = new ObjectOutputStream(fos);


    String[] TipoEstancia = {"","Sin desayuno", "Con desayuno", "Media Pensión", "Pensión Completa"};

    public Reservas() throws IOException, ClassNotFoundException {
        salida.writeObject(h);
        FileInputStream fis = new FileInputStream("Hotel.dat");
        ObjectInputStream entrada = new ObjectInputStream(fis);
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
        h = (Hotel) entrada.readObject();
        MapaHotel.setText(h.mapHab());

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
                FechaE.setText("");
                FechaS.setText("");
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
                int numEntero4 = Integer.parseInt(DNI.getText());
                int numEntero5 = Integer.parseInt(Telefono.getText());
                int numEntero6 = Integer.parseInt(TarjetaCredito.getText());
                int numEntero7 = Integer.parseInt(FechaE.getText());
                int numEntero8 = Integer.parseInt(FechaS.getText());
                c.setNombre(Nombre.getText());
                c.setApellido(Apellidos.getText());
                c.setDNI(numEntero4);
                c.setTelefono(numEntero5);
                c.setNumTarjeta(numEntero6);
                c.setFechaE(numEntero7);
                c.setFechaS(numEntero8);
                int numEntero1,numEntero2,numEntero3;
                if(estándarCheckBox.isSelected()){
                     numEntero1 = Integer.parseInt(Estandar.getText());
                } else numEntero1 = 0;
                if(balcónCheckBox.isSelected()) {
                     numEntero2 = Integer.parseInt(Balcon.getText());
                } else numEntero2 = 0;
                if(suiteCheckBox.isSelected()) {
                     numEntero3 = Integer.parseInt(Suite.getText());
                } else numEntero3 = 0;
                String s = "";
                if(h.resHab(c,numEntero1,numEntero2,numEntero3)) {
                    s = "Reserva Confirmada";
                } else s = "No se ha podido realizar todas las reservas";
                try {
                    salida.writeObject(h);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                MapaHotel.setText(h.mapHab());
                PaginaPulsar Confirmar = new PaginaPulsar(s);
            }
        });
        Anular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numEntero4 = Integer.parseInt(DNI.getText());
                int numEntero5 = Integer.parseInt(Telefono.getText());
                int numEntero6 = Integer.parseInt(TarjetaCredito.getText());
                int numEntero7 = Integer.parseInt(FechaE.getText());
                int numEntero8 = Integer.parseInt(FechaS.getText());
                Cliente c2 = new Cliente(Nombre.getText(),Apellidos.getText(),numEntero4,numEntero5,numEntero6,numEntero7,numEntero8);
                int numEntero1,numEntero2,numEntero3;
                if(estándarCheckBox.isSelected()){
                    numEntero1 = Integer.parseInt(Estandar.getText());
                } else numEntero1 = 0;
                if(balcónCheckBox.isSelected()) {
                    numEntero2 = Integer.parseInt(Balcon.getText());
                } else numEntero2 = 0;
                if(suiteCheckBox.isSelected()) {
                    numEntero3 = Integer.parseInt(Suite.getText());
                } else numEntero3 = 0;
                String s = "";
                if(c.equals(c2)) {
                    if (h.anularRes(c, numEntero1, numEntero2, numEntero3)) {
                        s = "Reserva Anulada";
                    } else s = "No se ha podido realizar todas las anulaciones";
                    try {
                        salida.writeObject(h);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    MapaHotel.setText(h.mapHab());
                    PaginaPulsar Confirmar = new PaginaPulsar(s);
                }
                else {
                    s = "Los datos del cliente no estan registrados en el hotel";
                    PaginaPulsar Confirmar = new PaginaPulsar(s);
                }

            }
        });
    }
}
