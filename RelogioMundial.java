import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RelogioMundial extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel painelPrincipal;
    private JLabel horarioLondres;
    private JLabel horarioNovaYork;
    private JLabel horarioTokyo;
    private JLabel horarioSydney;
    
    public RelogioMundial() {
        super("Relógio Mundial");
        painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new GridLayout(4, 1));
        painelPrincipal.setBackground(Color.WHITE);
        
        horarioLondres = new JLabel("", SwingConstants.CENTER);
        horarioNovaYork = new JLabel("", SwingConstants.CENTER);
        horarioTokyo = new JLabel("", SwingConstants.CENTER);
        horarioSydney = new JLabel("", SwingConstants.CENTER);
        
        Font fonteRelogio = new Font("Arial", Font.BOLD, 32);
        horarioLondres.setFont(fonteRelogio);
        horarioNovaYork.setFont(fonteRelogio);
        horarioTokyo.setFont(fonteRelogio);
        horarioSydney.setFont(fonteRelogio);
        
        painelPrincipal.add(horarioLondres);
        painelPrincipal.add(horarioNovaYork);
        painelPrincipal.add(horarioTokyo);
        painelPrincipal.add(horarioSydney);
        
        atualizarHorarios();
        
        getContentPane().add(painelPrincipal);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private void atualizarHorarios() {
        while(true) {
            Date agora = new Date();
            
            SimpleDateFormat formatadorLondres = new SimpleDateFormat("HH:mm");
            formatadorLondres.setTimeZone(TimeZone.getTimeZone("Europe/London"));
            horarioLondres.setText("Londres: " + formatadorLondres.format(agora));
            
            SimpleDateFormat formatadorNovaYork = new SimpleDateFormat("HH:mm");
            formatadorNovaYork.setTimeZone(TimeZone.getTimeZone("America/New_York"));
            horarioNovaYork.setText("Nova York: " + formatadorNovaYork.format(agora));
            
            SimpleDateFormat formatadorTokyo = new SimpleDateFormat("HH:mm");
            formatadorTokyo.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
            horarioTokyo.setText("Tóquio: " + formatadorTokyo.format(agora));
            
            SimpleDateFormat formatadorSydney = new SimpleDateFormat("HH:mm");
            formatadorSydney.setTimeZone(TimeZone.getTimeZone("Australia/Sydney"));
            horarioSydney.setText("Sydney: " + formatadorSydney.format(agora));
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        new RelogioMundial();
    }
}