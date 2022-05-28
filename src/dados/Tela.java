package dados;

import java.awt.Color;
import java.awt.EventQueue;
import informações.Senha;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

public class Tela extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField1;
	private JPasswordField passwordField2;
    private static JScrollPane scrollPane;
    private Senha senhaSempre;
    private JTextField textField_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
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
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Senha s1 = new Senha();		
		
		JLabel lbUsuario = new JLabel("Usu\u00E1rio:");
		lbUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				trataFocoUsuario();
			}
		});
		textField.setColumns(10);
		
		JLabel lbsenha = new JLabel("Senha:");
		lbsenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		passwordField1 = new JPasswordField();
		
		JLabel lbSenha2 = new JLabel("Confirme a senha:");
		lbSenha2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				senhaSempre = trataEventoBotaoInserir(s1);
				
			}
		});
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtualizarCadastro(senhaSempre);
			}
		});
		
		passwordField2 = new JPasswordField();
		
		JLabel lbPesquisa = new JLabel("Filtrar:");
		lbPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trataPesquisa(senhaSempre);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Excluir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluircadastro(senhaSempre);
			}
		});
		

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lbPesquisa)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnNewButton)
									.addGap(35))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnCadastrar)
									.addGap(71)
									.addComponent(btnAlterar)
									.addPreferredGap(ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
									.addComponent(btnNewButton_1)
									.addGap(44))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lbSenha2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(passwordField2, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lbsenha)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(passwordField1, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lbUsuario)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbUsuario)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbsenha)
						.addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbSenha2))
					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbPesquisa)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar)
						.addComponent(btnAlterar)
						.addComponent(btnNewButton_1))
					.addGap(141))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
	public Senha trataEventoBotaoInserir(Senha s) {
		s.setUsuario(textField.getText());
		s.setSenha(new String(passwordField1.getPassword()));
		s.setConfirma_senha(new String(passwordField2.getPassword()));
		if(s.getSenha().equals(s.getConfirma_senha())) {
		    JOptionPane.showMessageDialog(this,"Senha cadastrada com sucesso." + s.getUsuario());
		  } else {
			  JOptionPane.showMessageDialog(this,"Senhas não conferem.");
		  
		  }
		textField.setText("");
		passwordField1.setText("");
		passwordField2.setText("");
		
		return s;
	}
	
	public void trataPesquisa(Senha s) {
		System.out.println(s.getUsuario());
		if(textField_1.getText().equals(s.getUsuario())) {
		   textField.setText(s.getUsuario());
		   passwordField1.setText(s.getSenha());		   
		   passwordField2.setText(s.getConfirma_senha());
		} else {
			 JOptionPane.showMessageDialog(this,"Usuario não encontrado");
		}
		
		
		
	}
	
	public void AtualizarCadastro(Senha s) {		
		s.setUsuario(textField.getText());
		s.setSenha(new String(passwordField1.getPassword()));
		s.setConfirma_senha(new String(passwordField2.getPassword()));
		textField.setText("");
		passwordField1.setText("");
		passwordField2.setText("");		
		
	}
	
	public void excluircadastro(Senha s) {
		senhaSempre = null;
		textField.setText("");
		passwordField1.setText("");
		passwordField2.setText("");
		
	}
	
	public void trataFocoUsuario() {
	  String usuario = textField.getText(); 
	  if(usuario.length() < 3 || Character.isUpperCase(usuario.charAt(0))!= true);
	  JOptionPane.showMessageDialog(this,"O usuario deve ter mais que 3 caracteres e começar com letra maiuscula.");	  
	}

	}

