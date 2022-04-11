import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



//import Formularios.frmEstudiantesRegistrados;

//import Controller.LoginController;
//import Controller.RegistroController;
//import Modelo.Conexion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

public class frmLogin extends JFrame implements ActionListener, FocusListener {
	
	private JButton btnRegistrase;
	private JButton btnEntrar;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	private JLabel lblMensaje;
	private JLabel lblMensaje2;
	public static  Conexion oCon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					oCon = new Conexion();
					Conexion.getConection();
					frmLogin frame = new frmLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmLogin() {
		Inicializar();
		setLocationRelativeTo(null);
	}
	
	public JButton getBtnRegistrase() {
		return btnRegistrase;
	}

	public void setBtnRegistrase(JButton btnRegistrase) {
		this.btnRegistrase = btnRegistrase;
	}

	public JButton getBtnEntrar() {
		return btnEntrar;
	}

	public void setBtnEntrar(JButton btnEntrar) {
		this.btnEntrar = btnEntrar;
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public JPasswordField getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(JPasswordField txtPassword) {
		this.txtPassword = txtPassword;
	}

	public JLabel getLblMensaje() {
		return lblMensaje;
	}

	public void setLblMensaje(JLabel lblMensaje) {
		this.lblMensaje = lblMensaje;
	}

	public JLabel getLblMensaje2() {
		return lblMensaje2;
	}

	public void setLblMensaje2(JLabel lblMensaje2) {
		this.lblMensaje2 = lblMensaje2;
	}

	private void Inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(107, 112, 84, 27);
		panel.add(lblNewLabel);
		
		txtUsuario = new JTextField();
		txtUsuario.addFocusListener(this);
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(188, 115, 366, 29);
		panel.add(txtUsuario);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(87, 165, 104, 27);
		panel.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(188, 169, 366, 27);
		panel.add(txtPassword);
		
		btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(this);
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnEntrar.setBounds(265, 218, 190, 54);
		panel.add(btnEntrar);
		
		btnRegistrase = new JButton("Registrase");
		btnRegistrase.addActionListener(this);
		btnRegistrase.setOpaque(false);
		btnRegistrase.setForeground(Color.BLUE);
		btnRegistrase.setFont(new Font("Maiandra GD", Font.BOLD | Font.ITALIC, 16));
		btnRegistrase.setContentAreaFilled(false);
		btnRegistrase.setBorderPainted(false);
		btnRegistrase.setBackground(new Color(135, 206, 235));
		btnRegistrase.setBounds(265, 337, 190, 54);
		panel.add(btnRegistrase);
		
		lblMensaje = new JLabel("New label");
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblMensaje.setForeground(Color.RED);
		lblMensaje.setBounds(187, 149, 367, 13);
		lblMensaje.setVisible(false);
		panel.add(lblMensaje);
		
		lblMensaje2 = new JLabel("New label");
		lblMensaje2.setForeground(Color.RED);
		lblMensaje2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblMensaje2.setBounds(188, 202, 367, 13);
		lblMensaje2.setVisible(false);
		panel.add(lblMensaje2);
		
		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setBounds(305, 48, 124, 51);
		panel.add(lblNewLabel_2);
	}

private void ValidarUsuario(String cUsuario) {
		
		boolean datos = false;
		String cMiUsuario = "";
		if (!cUsuario.isEmpty()) {
			cMiUsuario = oCon.ConsultarUsuario("Select password from estudiantes where UserName = '" + cUsuario + "'");
			
			if (!cMiUsuario.isEmpty()) {
				
				lblMensaje.setVisible(false);
			}
			else
			{
				getLblMensaje().setText("Este Usuario no Existe, Favor Revisar.");
				lblMensaje.setVisible(true);
				
			}
		}
		
	}
	private void ValidarCredenciales(String cUsuario,String cPassword) {
		boolean datos = false;
		
		if ((!cUsuario.isEmpty()) && (!cPassword.isEmpty())) {
			datos = oCon.Consultar("Select password from estudiantes where UserName = '" + cUsuario + "' and password = '" + cPassword + "'" );
			if (datos) {
				/*
				frmEstudiantesRegistrados ofrmRegistrado = new frmEstudiantesRegistrados(oCon);
				ofrmRegistrado.setVisible(true);
				this.setVisible(false);
				*/
				frmEstudiantesRegistrados ofrmRegistrados = new frmEstudiantesRegistrados(oCon);
				ofrmRegistrados.setVisible(true);
				this.setVisible(false);
			}
			else {
				
				
				JOptionPane.showMessageDialog(null,"El Password es Incorrecto, Favor Revisar!!!");
				
			    
			}
		}else if (cUsuario.isEmpty()) {
			getLblMensaje().setText("Debe Introducir un Usuario, Si No tiene uno, Favor Registrarse.");
			lblMensaje.setVisible(true);
		}else if(cPassword.isEmpty()) {
			lblMensaje.setVisible(false);
			getLblMensaje2().setText("Debe Digitar su Password, Si no se ha Registrado, Favor Hacerlo.");
			lblMensaje2.setVisible(true);
		}else {
			lblMensaje2.setVisible(false);
		}
		
		
		
	}
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrase) {
			handle_btnRegistrase_actionPerformed(e);
		}
		if (e.getSource() == btnEntrar) {
			handle_btnEntrar_actionPerformed(e);
		}
	}
	protected void handle_btnEntrar_actionPerformed(ActionEvent e) {
		this.ValidarCredenciales(this.getTxtUsuario().getText(),getTxtPassword().getText());
	}
	public void focusGained(FocusEvent e) {
	}
	public void focusLost(FocusEvent e) {
		if (e.getSource() == txtUsuario) {
			handle_txtUsuario_focusLost(e);
		}
	}
	protected void handle_txtUsuario_focusLost(FocusEvent e) {
		this.ValidarUsuario(this.getTxtUsuario().getText());
	}
	protected void handle_btnRegistrase_actionPerformed(ActionEvent e) {
		frmRegistro ofrmRegistrar = new frmRegistro(this.oCon);
		ofrmRegistrar.setVisible(true);
		this.setVisible(false);
	}
}
