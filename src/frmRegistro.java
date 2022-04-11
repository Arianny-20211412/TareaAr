import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmRegistro extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JTextField txtUsuario;
	
	private JPasswordField txtPassword;
	private JPasswordField txtConfPassword;
	private JButton btnRegistrase;
	private JButton btnSalir;
	private JLabel lblNombreReq;
	private JLabel lblApellidoReq;
	private JLabel lblTelReq;
	private JLabel lblEmailRec;
	private JLabel lblUsuarioReq;
	private JLabel lblPasswordReq;
	private JLabel lblConfirmarPas;
	private Estudiante miEstudiante;
	private Conexion MiConexion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmRegistro frame = new frmRegistro();
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
	public frmRegistro() {
		Inicializar();
		setLocationRelativeTo(null);
	}
	public frmRegistro(Conexion oCon) {
		this.MiConexion = oCon;
		Inicializar();
		setLocationRelativeTo(null);
	}
	public frmRegistro(Conexion oCon,Estudiante oEstudiante) {
		this.MiConexion = oCon;
		this.miEstudiante = oEstudiante;
		Inicializar();
		this.CargarEstudiante();
		btnRegistrase.setText("Actualizar");
		setLocationRelativeTo(null);
	}
	

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
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

	public JPasswordField getTxtConfPassword() {
		return txtConfPassword;
	}

	public void setTxtConfPassword(JPasswordField txtConfPassword) {
		this.txtConfPassword = txtConfPassword;
	}

	public JButton getBtnRegistrase() {
		return btnRegistrase;
	}

	public void setBtnRegistrase(JButton btnRegistrase) {
		this.btnRegistrase = btnRegistrase;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

	public JLabel getLblNombreReq() {
		return lblNombreReq;
	}

	public void setLblNombreReq(JLabel lblNombreReq) {
		this.lblNombreReq = lblNombreReq;
	}

	public JLabel getLblApellidoReq() {
		return lblApellidoReq;
	}

	public void setLblApellidoReq(JLabel lblApellidoReq) {
		this.lblApellidoReq = lblApellidoReq;
	}

	public JLabel getLblTelReq() {
		return lblTelReq;
	}

	public void setLblTelReq(JLabel lblTelReq) {
		this.lblTelReq = lblTelReq;
	}

	public JLabel getLblEmailRec() {
		return lblEmailRec;
	}

	public void setLblEmailRec(JLabel lblEmailRec) {
		this.lblEmailRec = lblEmailRec;
	}

	public JLabel getLblUsuarioReq() {
		return lblUsuarioReq;
	}

	public void setLblUsuarioReq(JLabel lblUsuarioReq) {
		this.lblUsuarioReq = lblUsuarioReq;
	}

	public JLabel getLblPasswordReq() {
		return lblPasswordReq;
	}

	public void setLblPasswordReq(JLabel lblPasswordReq) {
		this.lblPasswordReq = lblPasswordReq;
	}

	public JLabel getLblConfirmarPas() {
		return lblConfirmarPas;
	}

	public void setLblConfirmarPas(JLabel lblConfirmarPas) {
		this.lblConfirmarPas = lblConfirmarPas;
	}
	private boolean ValidaCampos() {
		boolean Validado = false;
		
		
	    if (this.getTxtNombre().getText().isEmpty()) {
	    	
			lblNombreReq.setText("Este Campo es Obligatorio.");
			lblNombreReq.setVisible(true);
			return Validado = false;
			
		} else {
			lblNombreReq.setVisible(false);
			Validado = true;
		}
       if (this.getTxtApellido().getText().isEmpty()) {
	    	
			lblApellidoReq.setText("Este Campo es Obligatorio.");
			lblApellidoReq.setVisible(true);
			return Validado = false;
		} else {
			lblApellidoReq.setVisible(false);
			Validado = true;
		}
       if (this.getTxtTelefono().getText().isEmpty()) {
	    	
			lblTelReq.setText("Este Campo es Obligatorio.");
			lblTelReq.setVisible(true);
			return Validado = false;
		} else {
			lblTelReq.setVisible(false);
			Validado = true;
		}
       if (this.getTxtEmail().getText().isEmpty()) {
	    	
			lblEmailRec.setText("Este Campo es Obligatorio.");
			lblEmailRec.setVisible(true);
			return Validado = false;
		} else if(!this.getTxtEmail().getText().contains("@") || !this.getTxtEmail().getText().contains(".")) {
			
			lblEmailRec.setText("Correo no Valido, Favor Revisar");
			lblEmailRec.setVisible(true);
			return Validado = false;
			
		}
       else {
			lblEmailRec.setVisible(false);
			Validado = true;
		}
       
       if (this.getTxtUsuario().getText().isEmpty()) {
	    	
			lblUsuarioReq.setText("Este Campo es Obligatorio.");
			lblUsuarioReq.setVisible(true);
			return Validado = false;
		} else {
			lblUsuarioReq.setVisible(false);
			Validado = true;
		}
       if (this.getTxtPassword().getText().isEmpty()) {
	    	
			lblPasswordReq.setText("Este Campo es Obligatorio.");
			lblPasswordReq.setVisible(true);
			return Validado = false;
		} else {
			lblPasswordReq.setVisible(false);
			Validado = true;
		}
		
		
		
		return Validado;
	}
	
	protected void Inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombre.setBounds(58, 67, 84, 27);
		panel.add(lblNombre);
		
		JLabel lblNombre_1 = new JLabel("Apellido");
		lblNombre_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombre_1.setBounds(58, 122, 84, 27);
		panel.add(lblNombre_1);
		
		JLabel lblNombre_2 = new JLabel("Telefono");
		lblNombre_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombre_2.setBounds(58, 159, 84, 27);
		panel.add(lblNombre_2);
		
		JLabel lblNombre_3 = new JLabel("Email");
		lblNombre_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombre_3.setBounds(58, 196, 84, 27);
		panel.add(lblNombre_3);
		
		JLabel lblNombre_4 = new JLabel("Usuario");
		lblNombre_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombre_4.setBounds(314, 236, 84, 27);
		panel.add(lblNombre_4);
		
		JLabel lblNombre_5 = new JLabel("Password");
		lblNombre_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombre_5.setBounds(314, 321, 84, 27);
		panel.add(lblNombre_5);
		
		JLabel lblNombre_6 = new JLabel("Confirmar Password");
		lblNombre_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombre_6.setBounds(273, 387, 184, 27);
		panel.add(lblNombre_6);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(136, 68, 312, 29);
		panel.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(136, 123, 312, 29);
		panel.add(txtApellido);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(136, 162, 183, 25);
		panel.add(txtTelefono);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(136, 197, 454, 29);
		panel.add(txtEmail);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(193, 264, 326, 29);
		panel.add(txtUsuario);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(193, 347, 326, 27);
		panel.add(txtPassword);
		
		txtConfPassword = new JPasswordField();
		txtConfPassword.setBounds(193, 407, 326, 27);
		panel.add(txtConfPassword);
		
		lblNombreReq = new JLabel("");
		lblNombreReq.setForeground(Color.RED);
		lblNombreReq.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNombreReq.setBounds(136, 99, 184, 13);
		panel.add(lblNombreReq);
		
		 lblApellidoReq = new JLabel("");
		lblApellidoReq.setForeground(Color.RED);
		lblApellidoReq.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblApellidoReq.setBounds(136, 147, 184, 13);
		panel.add(lblApellidoReq);
		
		lblTelReq = new JLabel("");
		lblTelReq.setForeground(Color.RED);
		lblTelReq.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTelReq.setBounds(136, 185, 184, 13);
		panel.add(lblTelReq);
		
		lblEmailRec = new JLabel("");
		lblEmailRec.setForeground(Color.RED);
		lblEmailRec.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEmailRec.setBounds(135, 228, 184, 13);
		panel.add(lblEmailRec);
		
		lblUsuarioReq = new JLabel("");
		lblUsuarioReq.setForeground(Color.RED);
		lblUsuarioReq.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblUsuarioReq.setBounds(259, 292, 184, 13);
		panel.add(lblUsuarioReq);
		
		lblPasswordReq = new JLabel("");
		lblPasswordReq.setForeground(Color.RED);
		lblPasswordReq.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblPasswordReq.setBounds(273, 372, 184, 13);
		panel.add(lblPasswordReq);
		
		lblConfirmarPas = new JLabel();
		lblConfirmarPas.setForeground(Color.RED);
		lblConfirmarPas.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblConfirmarPas.setBounds(180, 437, 356, 15);
		panel.add(lblConfirmarPas);
		
		btnRegistrase = new JButton("Registrase");
		btnRegistrase.addActionListener(this);
		btnRegistrase.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRegistrase.setBounds(95, 457, 190, 54);
		panel.add(btnRegistrase);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSalir.setBounds(400, 462, 190, 54);
		panel.add(btnSalir);
	}
	//VALIDAR PASSWORD
		public boolean ConfirmaPassword(String cPassword1, String cPassword2) {
			boolean Confirmado = false;
			if (!cPassword1.isEmpty() && !cPassword2.isEmpty()) {
				
				if (cPassword2.equals(cPassword1)) {
					lblConfirmarPas.setVisible(false);
					Confirmado = true;
				} else {
					//JOptionPane.showMessageDialog(null,"El Password No coincide, Favor Confirmar!!");
					
					//txtConfPassword.requestFocus();
					lblConfirmarPas.setText("El Password No coincide, Favor Confirmar!!");
					lblConfirmarPas.setVisible(true);
					
					Confirmado = false;
					

				}
				
			} 
			
			return Confirmado;
		}

		
		//PARA ACTUALIZAR LOS ESTUDIANTES
		private int Actualizar(int nID,String cNombre,String cApellido,String cTelefono,String cEmail,String cUsuario,String cPassword) {
			int nResultado = 0;
			nResultado = MiConexion.SetInformacion("update `programacion1`.`estudiantes` set `nombre` = '" + cNombre + "',`apellido` = '" + cApellido +
					"',`telefono` = '" +cTelefono+"',`email` = '"+ cEmail + "', `UserName` = '" + cUsuario + "',`Password` = '" + cPassword + "' where IdEstudiante = " + nID );
			
			return nResultado;
		}
		//PARA REGISTRAR LOS ESTUDIANTES
		private int Registrar(String cNombre,String cApellido,String cTelefono,String cEmail,String cUsuario,String cPassword) {
			
			int nResultado = 0;
			if (this.ValidaCampos()) {
				 if (this.ConfirmaPassword(txtPassword.getText(),txtConfPassword.getText())) {
						
						nResultado = MiConexion.SetInformacion("Insert Into `programacion1`.`estudiantes`(`nombre`,`apellido`,`telefono`,`email`,`UserName`,`Password`)"
								+ " values ('" + cNombre + "','" + cApellido + "','" + cTelefono + "','" + cEmail + "','" + cUsuario + "','" + cPassword + "')");
					
				}
			}
			
			
			
			
			return nResultado;
		}
		
		protected void CargarEstudiante() {
			this.getTxtNombre().setText(miEstudiante.getNombre());
			this.getTxtApellido().setText(miEstudiante.getApellido());
			this.getTxtTelefono().setText(miEstudiante.getTelefono());
			this.getTxtEmail().setText(miEstudiante.getEmail());
			this.getTxtUsuario().setText(miEstudiante.getUserName());
			this.getTxtPassword().setText(miEstudiante.getPassword());
		}
		
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			handle_btnSalir_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrase) {
			handle_btnRegistrase_actionPerformed(e);
		}
	}
	protected void handle_btnRegistrase_actionPerformed(ActionEvent e) {
		String cModo = btnRegistrase.getText();
		switch (cModo) {
		case "Registrase":
			int nResultado =	this.Registrar(this.getTxtNombre().getText(), this.getTxtApellido().getText(),this.getTxtTelefono().getText(), this.getTxtEmail().getText(),
					this.getTxtUsuario().getText(), this.getTxtPassword().getText());
			
		  if(nResultado > 0) {
			  
			  JOptionPane.showMessageDialog(null,"Registro Exitoso!!!");
			  frmEstudiantesRegistrados oFrmRegistrados = new frmEstudiantesRegistrados(MiConexion);
			  oFrmRegistrados.setVisible(true);
			  this.setVisible(false);
			  //this.Limpiar();
			  
		  }			
			break;
			
		case "Actualizar":
			int nActualizado = this.Actualizar(miEstudiante.getIdEstudiante(), this.getTxtNombre().getText(), this.getTxtApellido().getText(),this.getTxtTelefono().getText(), this.getTxtEmail().getText(),
					this.getTxtUsuario().getText(), this.getTxtPassword().getText());
			if(nActualizado > 0) {
				  
				  JOptionPane.showMessageDialog(null,"Estudiante Actualizado Correctamente!!!");
				  frmEstudiantesRegistrados oFrmRegistrados = new frmEstudiantesRegistrados(MiConexion);
				  oFrmRegistrados.setVisible(true);
				  this.setVisible(false);
				  //this.Limpiar();
				  
			  }			
			
			break;
		
		}
	}
	protected void handle_btnSalir_actionPerformed(ActionEvent e) {
		frmEstudiantesRegistrados oFrmRegistrados = new frmEstudiantesRegistrados(MiConexion);
		  oFrmRegistrados.setVisible(true);
		  this.setVisible(false);
	}
}
