import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class Tabela extends JFrame implements ActionListener
{
    private Container caixa;
    private Connection conn;
    private String[] colunas;
    private String[][] tabelaCursos;
    private JButton btnNovo, btnModifica, btnLista, btnBusca, btnExclui, btnFecha;
    private JPanel pnlBotoes;
    private JTable table;
    private JScrollPane scroll;

    public Tabela(Connection conn)
    {
        super("Cursos");
        this.conn = conn;
        
        table = null;
        btnNovo = new JButton("Novo");
        btnModifica = new JButton("Modificar");
        btnBusca = new JButton("Buscar");
        btnLista = new JButton("Listar todos");
        btnExclui = new JButton("Excluir");
        btnFecha = new JButton("Sair");
        pnlBotoes = new JPanel();
        pnlBotoes.setLayout(new FlowLayout());
        pnlBotoes.add(btnNovo);
        pnlBotoes.add(btnModifica);
        pnlBotoes.add(btnBusca);
        pnlBotoes.add(btnLista);
        pnlBotoes.add(btnExclui);
        pnlBotoes.add(btnFecha);
        btnModifica.setEnabled(false);
        btnExclui.setEnabled(false);
        colunas = new String[8];
        colunas[0] = "Id";
        colunas[1] = "Nome";
        colunas[2] = "Carga Horaria";
        colunas[3] = "Quantidade de Aulas";
        colunas[4] = "Nota de Corte";
        colunas[5] = "Sequencia";
        colunas[6] = "Software";
        colunas[7] = "Situacao";
        
        caixa = getContentPane();
        caixa.setLayout(new BorderLayout());
        caixa.add(pnlBotoes, BorderLayout.PAGE_START);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        super.setSize(800,200);
        
        btnNovo.addActionListener(this);
        btnModifica.addActionListener(this);
        btnBusca.addActionListener(this);
        btnLista.addActionListener(this);
        btnExclui.addActionListener(this);
        btnFecha.addActionListener(this);
        
		setLocationRelativeTo(null);
    }
    
    private class Modelo extends AbstractTableModel
    {
        Modelo()
        {}
        @Override
        public String getColumnName​(int column)
        {
            return colunas[column];
        }
        @Override
        public int getColumnCount()
        {
            return colunas.length;
        }
        @Override
        public int getRowCount()
        {
            return tabelaCursos.length;
        }
        @Override
        public Object getValueAt(int row, int col)
        {
            return tabelaCursos[row][col];
        }
        @Override
        public boolean isCellEditable(int row, int col)
        {
            return false;
        }
    }
    
    //Listar todos
    private void listar()
    {
        caixa.removeAll();
        tabelaCursos = new Curso().tabelaCursos(conn);
        table = new JTable(tabelaCursos, colunas);
        table.setModel(new Modelo());
        scroll = new JScrollPane(table);
                
        caixa.setLayout(new BorderLayout());
        caixa.add(pnlBotoes, BorderLayout.PAGE_START);
        caixa.add(scroll, BorderLayout.CENTER);
        btnModifica.setEnabled(true);
        btnExclui.setEnabled(true);
        setVisible(true);
    }
    
    //Buscar
    private boolean listar(String nome)
    {
        //Cancelar
    	if(nome==null)
    		return false;
        //Nome em branco apaga a tabela
    	else if(nome.isBlank())
    	{
        	caixa.removeAll();
            caixa.setLayout(new BorderLayout());
            caixa.add(pnlBotoes, BorderLayout.PAGE_START);
            btnModifica.setEnabled(false);
            btnExclui.setEnabled(false);
            setVisible(false);
            setVisible(true);
    		return false;
    	}
    	//Busca no Banco de Dados
    	else
        {
            tabelaCursos = new Curso(nome).tabelaLike(conn);
            if(tabelaCursos.length<=0)
            {
            	JOptionPane.showMessageDialog(null, "Nao foi encontrado nenhum curso com esse nome", "Erro", JOptionPane.ERROR_MESSAGE);
            	return true;
            }
            else
            {
            	caixa.removeAll();
	            table = new JTable(tabelaCursos, colunas);
                table.setModel(new Modelo());
	            scroll = new JScrollPane(table);
	            
	            caixa.setLayout(new BorderLayout());
	            caixa.add(pnlBotoes, BorderLayout.PAGE_START);
	            caixa.add(scroll, BorderLayout.CENTER);
                btnModifica.setEnabled(true);
	            btnExclui.setEnabled(true);
	            setVisible(true);
	            return false;
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            if(e.getSource() == btnNovo)
            {
                setVisible(false);
                new Formulario(this, conn);
            }
            else if(e.getSource() == btnModifica)
            {
                int selection = table.getSelectedRow();
                if(selection>=0)
                {
                    setVisible(false);
                    new Formulario(this, new Curso(Integer.parseInt(tabelaCursos[selection][0])).carregarId(conn),conn);
                }
            }
            else if(e.getSource() == btnBusca)
            {
                while(listar(JOptionPane.showInputDialog(null, "Nome do Curso:", "Buscar", JOptionPane.QUESTION_MESSAGE)));
                
            }
            else if(e.getSource() == btnLista)
                listar();
            else if(e.getSource() == btnExclui)
            {
                int[] selection = table.getSelectedRows();
                for(int i = 0; i < selection.length; i++)
                    new Curso(Integer.parseInt(tabelaCursos[selection[i]][0])).excluir(conn);
                listar();
            }
            else if(e.getSource() == btnFecha)
            	if(JOptionPane.showConfirmDialog(null, "Realmente deseja sair?", "Sair?", JOptionPane.YES_NO_OPTION)==0)
            	{
                    new ConexaoBD().desconectar(conn);
					System.exit(0);
                }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
