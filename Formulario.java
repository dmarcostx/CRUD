import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Formulario extends JFrame implements ActionListener
{
	private JLabel lblId, lblNome, lblCargaHoraria, lblQtdeAulas, lblNotaCorte, lblSequencia, lblSoftware, lblSituacao;
	private JTextField txtId, txtNome, txtCargaHoraria, txtQtdeAulas, txtNotaCorte, txtSequencia, txtSoftware, txtSituacao;
	private JButton btnInsere, btnFecha, btnAtualiza, btnLimpa;
	private JPanel pnlOeste, pnlLeste, pnlSul;
	private JFrame tabela;
	private Connection conn;
	
	//Novo
	public Formulario(JFrame tabela, Connection conn)
	{
		super ("Cadastro de Curso");
		this.tabela = tabela;
		this.conn = conn;
		
		lblId = new JLabel("Codigo");
		lblNome = new JLabel("Curso");
		lblCargaHoraria = new JLabel("Carga Horaria");
		lblQtdeAulas = new JLabel("Quantidade de Aulas");
		lblNotaCorte = new JLabel("Nota de Corte");
		lblSequencia = new JLabel("Sequencia");
		lblSoftware = new JLabel("Software");
		lblSituacao = new JLabel("Situacao");
		
		txtId = new JTextField(10);
		txtNome = new JTextField(10);
		txtCargaHoraria = new JTextField(10);
		txtQtdeAulas = new JTextField(10);
		txtNotaCorte = new JTextField(10);
		txtSequencia = new JTextField(10);
		txtSoftware = new JTextField(10);
		txtSituacao = new JTextField(10);
		
		btnInsere = new JButton("Inserir");
		btnLimpa = new JButton("Limpar");
		btnFecha = new JButton("Fechar");
		
		pnlOeste = new JPanel();
		pnlOeste.setLayout(new GridLayout(8,1));
		pnlOeste.add(lblId);
		pnlOeste.add(lblNome);
		pnlOeste.add(lblCargaHoraria);
		pnlOeste.add(lblQtdeAulas);
		pnlOeste.add(lblNotaCorte);
		pnlOeste.add(lblSequencia);
		pnlOeste.add(lblSoftware);
		pnlOeste.add(lblSituacao);
		
		pnlLeste = new JPanel();
		pnlLeste.setLayout(new GridLayout(8,1));
		pnlLeste.add(txtId);
		pnlLeste.add(txtNome);
		pnlLeste.add(txtCargaHoraria);
		pnlLeste.add(txtQtdeAulas);
		pnlLeste.add(txtNotaCorte);
		pnlLeste.add(txtSequencia);
		pnlLeste.add(txtSoftware);
		pnlLeste.add(txtSituacao);
				
		pnlSul = new JPanel();
		pnlSul.setLayout(new FlowLayout());
		pnlSul.add(btnInsere);
		pnlSul.add(btnLimpa);
		pnlSul.add(btnFecha);
		
		Container caixa = getContentPane();
		caixa.setLayout(new BorderLayout());
		
		caixa.add(pnlOeste, BorderLayout.WEST);
		caixa.add(pnlLeste, BorderLayout.EAST);
		caixa.add(pnlSul, BorderLayout.SOUTH);
		
		btnInsere.addActionListener(this);
		btnLimpa.addActionListener(this);
		btnFecha.addActionListener(this);
		
		setSize(300, 200);
		setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		txtId.setEditable(false);
	}
	
	//Modificar
	public Formulario(JFrame tabela, Curso curso, Connection conn)
	{
		super ("Alteracao de Curso");
		this.tabela = tabela;
		this.conn = conn;
		
		lblId = new JLabel("Codigo");
		lblNome = new JLabel("Curso");
		lblCargaHoraria = new JLabel("Carga Horaria");
		lblQtdeAulas = new JLabel("Quantidade de Aulas");
		lblNotaCorte = new JLabel("Nota de Corte");
		lblSequencia = new JLabel("Sequencia");
		lblSoftware = new JLabel("Software");
		lblSituacao = new JLabel("Situacao");
		
		txtId = new JTextField(""+curso.getId(),10);
		txtNome = new JTextField(curso.getNome(),10);
		txtCargaHoraria = new JTextField(""+curso.getCargaHoraria(),10);
		txtQtdeAulas = new JTextField(""+curso.getQtdeAulas(),10);
		txtNotaCorte = new JTextField(""+curso.getNotaCorte(),10);
		txtSequencia = new JTextField(""+curso.getSequencia(),10);
		txtSoftware = new JTextField(curso.getSoftware(),10);
		txtSituacao = new JTextField(curso.getSituacao(),10);
		
		btnAtualiza = new JButton("Salvar");
		btnFecha = new JButton("Fechar");
		
		pnlOeste = new JPanel();
		pnlOeste.setLayout(new GridLayout(8,1));
		pnlOeste.add(lblId);
		pnlOeste.add(lblNome);
		pnlOeste.add(lblCargaHoraria);
		pnlOeste.add(lblQtdeAulas);
		pnlOeste.add(lblNotaCorte);
		pnlOeste.add(lblSequencia);
		pnlOeste.add(lblSoftware);
		pnlOeste.add(lblSituacao);
		
		pnlLeste = new JPanel();
		pnlLeste.setLayout(new GridLayout(8,1));
		pnlLeste.add(txtId);
		pnlLeste.add(txtNome);
		pnlLeste.add(txtCargaHoraria);
		pnlLeste.add(txtQtdeAulas);
		pnlLeste.add(txtNotaCorte);
		pnlLeste.add(txtSequencia);
		pnlLeste.add(txtSoftware);
		pnlLeste.add(txtSituacao);
				
		pnlSul = new JPanel();
		pnlSul.setLayout(new FlowLayout());
		pnlSul.add(btnAtualiza);
		pnlSul.add(btnFecha);
		
		Container caixa = getContentPane();
		caixa.setLayout(new BorderLayout());
		
		caixa.add(pnlOeste, BorderLayout.WEST);
		caixa.add(pnlLeste, BorderLayout.EAST);
		caixa.add(pnlSul, BorderLayout.SOUTH);
		
		btnAtualiza.addActionListener(this);
		btnFecha.addActionListener(this);
		
		setSize(300, 200);
		setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		txtId.setEditable(false);
	}
	
	private void fecha()
	{
        tabela.setVisible(true);
        dispose();
	}
	
	private void limpa()
	{
		txtId.setText("");
		txtNome.setText("");
		txtCargaHoraria.setText("");
		txtQtdeAulas.setText("");
		txtNotaCorte.setText("");
		txtSequencia.setText("");
		txtSoftware.setText("");
		txtSituacao.setText("");		
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btnLimpa)
			limpa();
		else if(e.getSource() == btnInsere)
		{
			Curso teste = new Curso(txtNome.getText());
			//Buscando um Curso com mesmo nome
			teste.carregarNome(conn);
            //Caso nao exista seus atributos serao null
			if(teste.getSoftware()==null)
			{
				String sNome = txtNome.getText();
				String sCargaHoraria = txtCargaHoraria.getText();
				String sQtdeAulas = txtQtdeAulas.getText();
				String sNotaCorte = txtNotaCorte.getText();
				String sSequencia = txtSequencia.getText();
				String sSoftware = txtSoftware.getText();
				String sSituacao = txtSituacao.getText();
						
				if(sNome.length()>0 && sCargaHoraria.length()>0 && sQtdeAulas.length()>0 && sNotaCorte.length()>0 && sSequencia.length()>0 && sSoftware.length()>0 && sSituacao.length()>0)
				{
					try
					{
						Curso curso = new Curso(sNome, Integer.parseInt(sCargaHoraria), Short.parseShort(sQtdeAulas), Short.parseShort(sNotaCorte), Short.parseShort(sSequencia), sSoftware, sSituacao);
						curso.incluir(conn);
						JOptionPane.showMessageDialog(this, "Dados inseridos com sucesso");
						limpa();
					}
					catch(Exception exception)
					{
						JOptionPane.showMessageDialog(null, "Preenchimento incorreto", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
				else
					JOptionPane.showMessageDialog(this, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			else
				JOptionPane.showMessageDialog(this, "Curso ja cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		else if(e.getSource() == btnFecha)
		{
			if(txtNome.getText().length()>0 || txtCargaHoraria.getText().length()>0 || txtQtdeAulas.getText().length()>0 || txtNotaCorte.getText().length()>0 || txtSequencia.getText().length()>0 || txtSoftware.getText().length()>0 || txtSituacao.getText().length()>0)
			{
				if(JOptionPane.showConfirmDialog(null, "Realmente deseja fechar?", "Seus dados nao serao salvos", JOptionPane.YES_NO_OPTION)==0)
					fecha();
			}
			else
				fecha();
		}
		else if(e.getSource() == btnAtualiza)
		{
			String sId = txtId.getText();
			String sNome = txtNome.getText();
			String sCargaHoraria = txtCargaHoraria.getText();
			String sQtdeAulas = txtQtdeAulas.getText();
			String sNotaCorte = txtNotaCorte.getText();
			String sSequencia = txtSequencia.getText();
			String sSoftware = txtSoftware.getText();
			String sSituacao = txtSituacao.getText();
			
			if(sId.length()>0 && sNome.length()>0 && sCargaHoraria.length()>0 && sQtdeAulas.length()>0 && sNotaCorte.length()>0 && sSequencia.length()>0 && sSoftware.length()>0 && sSituacao.length()>0)
			{
				Curso curso = new Curso(Integer.parseInt(sId), sNome, Integer.parseInt(sCargaHoraria), Short.parseShort(sQtdeAulas), Short.parseShort(sNotaCorte), Short.parseShort(sSequencia), sSoftware, sSituacao);
				curso.atualizar(conn);
				JOptionPane.showMessageDialog(this, "Dados atualizados com sucesso");
				fecha();
			}
			else
				JOptionPane.showMessageDialog(this, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
