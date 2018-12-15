import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Curso {
	private int id;
	private String nome;
	private int cargaHoraria;
	private short qtdeAulas;
	private short notaCorte;
	private short sequencia;
	private String software;
	private String situacao;

	public Curso()
	{
	}
	public Curso(int id)
	{
		this.id = id;
	}
	public Curso(String nome)
	{
		this.nome = nome;
	}
	public Curso(String nome, int cargaHoraria, short qtdeAulas, short notaCorte, short sequencia, String software, String situacao)
	{
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.qtdeAulas = qtdeAulas;
		this.notaCorte = notaCorte;
		this.sequencia = sequencia;
		this.software = software;
		this.situacao = situacao;
	}
	public Curso(int id, String nome, int cargaHoraria, short qtdeAulas, short notaCorte, short sequencia, String software, String situacao)
	{
		this.id = id;
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.qtdeAulas = qtdeAulas;
		this.notaCorte = notaCorte;
		this.sequencia = sequencia;
		this.software = software;
		this.situacao = situacao;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getNome()
	{
		return nome;
	}
	public void setNome(String nome)
	{
		this.nome=nome;
	}
	public int getCargaHoraria()
	{
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria)
	{
		this.cargaHoraria = cargaHoraria;
	}
	public short getQtdeAulas()
	{
		return qtdeAulas;
	}
	public void setQtdeAulas(short qtdeAulas)
	{
		this.qtdeAulas = qtdeAulas;
	}
	public short getNotaCorte()
	{
		return notaCorte;
	}
	public void setNotaCorte(short notaCorte)
	{
		this.notaCorte = notaCorte;
	}
	public short getSequencia()
	{
		return sequencia;
	}
	public void setSequencia(short sequencia)
	{
		this.sequencia = sequencia;
	}
	public String getSoftware()
	{
		return software;
	}
	public void setSoftware(String software)
	{
		this.software=software;
	}
	public String getSituacao()
	{
		return situacao;
	}
	public void setSituacao(String situacao)
	{
		this.situacao=situacao;
	}	
	
	public void incluir(Connection conn)
	{
		String sqlInsert = "INSERT INTO curso(id, nome, cargaHoraria, qtdeAulas, notaCorte, sequencia, software, situacao) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)";
		try(PreparedStatement stm=conn.prepareStatement(sqlInsert);)
		{
			stm.setString(1, getNome());
			stm.setInt(2, getCargaHoraria());
			stm.setShort(3, getQtdeAulas());
			stm.setShort(4, getNotaCorte());
			stm.setShort(5, getSequencia());
			stm.setString(6, getSoftware());
			stm.setString(7, getSituacao());
			stm.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			try
			{
				conn.rollback();
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();
			}
		}
	}
	
	public void excluir(Connection conn)
	{
		String sqlDelete = "DELETE FROM curso WHERE id = ?";
		try(PreparedStatement stm = conn.prepareStatement(sqlDelete);)
		{
			stm.setInt(1, getId());
			stm.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			try
			{
				conn.rollback();
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();
			}
		}
	}
	
	public void atualizar(Connection conn)
	{
		String sqlUpdate = "UPDATE curso SET nome = ? WHERE id = ?";
		try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);)
		{
			stm.setString(1, getNome());
			stm.setInt(2,getId());
			stm.execute();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			try
			{
				conn.rollback();
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		}
		sqlUpdate = "UPDATE curso SET cargaHoraria = ? WHERE id = ?";
		try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);)
		{
			stm.setString(1, ""+getCargaHoraria());
			stm.setInt(2,getId());
			stm.execute();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			try
			{
				conn.rollback();
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		}
		sqlUpdate = "UPDATE curso SET qtdeAulas = ? WHERE id = ?";
		try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);)
		{
			stm.setString(1, ""+qtdeAulas);
			stm.setInt(2,getId());
			stm.execute();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			try
			{
				conn.rollback();
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		}
		sqlUpdate = "UPDATE curso SET notaCorte = ? WHERE id = ?";
		try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);)
		{
			stm.setString(1, ""+notaCorte);
			stm.setInt(2,getId());
			stm.execute();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			try
			{
				conn.rollback();
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		}
		sqlUpdate = "UPDATE curso SET sequencia = ? WHERE id = ?";
		try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);)
		{
			stm.setString(1, ""+sequencia);
			stm.setInt(2,getId());
			stm.execute();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			try
			{
				conn.rollback();
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		}
		sqlUpdate = "UPDATE curso SET software = ? WHERE id = ?";
		try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);)
		{
			stm.setString(1, software);
			stm.setInt(2,getId());
			stm.execute();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			try
			{
				conn.rollback();
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		}
		sqlUpdate = "UPDATE curso SET situacao = ? WHERE id = ?";
		try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);)
		{
			stm.setString(1, situacao);
			stm.setInt(2,getId());
			stm.execute();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			try
			{
				conn.rollback();
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		}
	}

	public Curso carregarId(Connection conn)
	{
		String sqlSelect = "SELECT * FROM curso WHERE curso.id = ?";
		try(PreparedStatement stm = conn.prepareStatement(sqlSelect);)
		{
			stm.setInt(1, id);
			try(ResultSet rs = stm.executeQuery();)
			{
				if(rs.next())
				{
					this.setNome(rs.getString(2));
					this.setCargaHoraria(rs.getInt(3));
					this.setQtdeAulas(rs.getShort(4));
					this.setNotaCorte(rs.getShort(5));
					this.setSequencia(rs.getShort(6));
					this.setSoftware(rs.getString(7));
					this.setSituacao(rs.getString(8));
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		return this;
	}

	public void carregarNome(Connection conn)
	{
		String sqlSelect = "SELECT * FROM curso WHERE curso.nome = ?";
		try(PreparedStatement stm = conn.prepareStatement(sqlSelect);)
		{
			stm.setString(1, nome);
			try(ResultSet rs = stm.executeQuery();)
			{
				if(rs.next())
				{
					this.setId(rs.getInt(1));
					this.setCargaHoraria(rs.getInt(3));
					this.setQtdeAulas(rs.getShort(4));
					this.setNotaCorte(rs.getShort(5));
					this.setSequencia(rs.getShort(6));
					this.setSoftware(rs.getString(7));
					this.setSituacao(rs.getString(8));
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
	}

	public String[][] tabelaCursos(Connection conn)
	{
		String sqlSelect = "SELECT * FROM curso";
		String[][] table = new String[0][8];
		int i=0;
		try(PreparedStatement stm = conn.prepareStatement(sqlSelect);
			ResultSet rs = stm.executeQuery();)
		{
			while(rs.next())
			{
                String[][] tmp = new String[++i][8];
                for(int l=0; l<i-1; l++)
                    for(int c=0; c<8; c++)
                        tmp[l][c] = table[l][c];
				tmp[i-1][0] = ""+rs.getInt("id");
				tmp[i-1][1] = rs.getString("nome");
				tmp[i-1][2] = ""+rs.getInt("cargaHoraria");
				tmp[i-1][3] = ""+rs.getShort("qtdeAulas");
				tmp[i-1][4] = ""+rs.getShort("notaCorte");
				tmp[i-1][5] = ""+rs.getShort("sequencia");
				tmp[i-1][6] = rs.getString("software");
				tmp[i-1][7] = rs.getString("situacao");
				table=tmp;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return table;
	}

	public String[][] tabelaLike(Connection conn)
	{
		String[][] table = new String[0][8];
		int i=0;
		try
		{
            String sqlSelect = "SELECT * FROM curso WHERE nome LIKE '%";
            sqlSelect += nome + "%'";
            PreparedStatement stm = conn.prepareStatement(sqlSelect);
            ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
                String[][] tmp = new String[++i][8];
                for(int l=0; l<i-1; l++)
                    for(int c=0; c<8; c++)
                        tmp[l][c] = table[l][c];
				tmp[i-1][0] = ""+rs.getInt("id");
				tmp[i-1][1] = rs.getString("nome");
				tmp[i-1][2] = ""+rs.getInt("cargaHoraria");
				tmp[i-1][3] = ""+rs.getShort("qtdeAulas");
				tmp[i-1][4] = ""+rs.getShort("notaCorte");
				tmp[i-1][5] = ""+rs.getShort("sequencia");
				tmp[i-1][6] = rs.getString("software");
				tmp[i-1][7] = rs.getString("situacao");
				table=tmp;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return table;
	}
}
