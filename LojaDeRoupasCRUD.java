import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;

public class LojaDeRoupasCRUD {

  // HashMap para armazenar os dados das roupas
  private static HashMap<String, Roupa> roupas = new HashMap<>();

  public static void main(String[] args) {
    // Criação da interface gráfica com Swing
    JFrame frame = new JFrame("Loja de Roupas - CRUD");
    frame.setSize(400, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(null);

    // Labels e campos de entrada
    JLabel lblId = new JLabel("ID da Roupa:");
    lblId.setBounds(20, 20, 100, 25);
    frame.add(lblId);

    JTextField txtId = new JTextField();
    txtId.setBounds(130, 20, 200, 25);
    frame.add(txtId);

    JLabel lblNome = new JLabel("Nome da Roupa:");
    lblNome.setBounds(20, 60, 100, 25);
    frame.add(lblNome);

    JTextField txtNome = new JTextField();
    txtNome.setBounds(130, 60, 200, 25);
    frame.add(txtNome);

    JLabel lblPreco = new JLabel("Preço da Roupa:");
    lblPreco.setBounds(20, 100, 100, 25);
    frame.add(lblPreco);

    JTextField txtPreco = new JTextField();
    txtPreco.setBounds(130, 100, 200, 25);
    frame.add(txtPreco);

    JLabel lblEstoque = new JLabel("Estoque da Roupa:");
    lblEstoque.setBounds(20, 140, 120, 25);
    frame.add(lblEstoque);

    JTextField txtEstoque = new JTextField();
    txtEstoque.setBounds(130, 140, 200, 25);
    frame.add(txtEstoque);

    // Botões de CRUD
    JButton btnCriar = new JButton("Criar Roupa");
    btnCriar.setBounds(20, 180, 120, 25);
    frame.add(btnCriar);

    JButton btnLer = new JButton("Ler Roupa");
    btnLer.setBounds(150, 180, 120, 25);
    frame.add(btnLer);

    JButton btnAtualizar = new JButton("Atualizar Roupa");
    btnAtualizar.setBounds(20, 220, 120, 25);
    frame.add(btnAtualizar);

    JButton btnDeletar = new JButton("Deletar Roupa");
    btnDeletar.setBounds(150, 220, 120, 25);
    frame.add(btnDeletar);

    // Ação para criar uma nova roupa ou produto
    btnCriar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String id = txtId.getText();
        String nome = txtNome.getText();
        String preco = txtPreco.getText();
        String estoque = txtEstoque.getText();

        if (roupas.containsKey(id)) {
          JOptionPane.showMessageDialog(frame, "ID já existente!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
          roupas.put(id, new Roupa(nome, preco, estoque));
          JOptionPane.showMessageDialog(frame, "Roupa adicionada com sucesso!", "Sucesso",
              JOptionPane.INFORMATION_MESSAGE);
        }
      }
    });

    // Ação para ler uma roupa
    btnLer.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String id = txtId.getText();
        if (roupas.containsKey(id)) {
          Roupa roupa = roupas.get(id);
          JOptionPane.showMessageDialog(frame,
              "Nome: " + roupa.getNome() + "\nPreço: " + roupa.getPreco() + "\nEstoque: " + roupa.getEstoque(),
              "Informações da Roupa", JOptionPane.INFORMATION_MESSAGE);
        } else {
          JOptionPane.showMessageDialog(frame, "Roupa não encontrada!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    // Ação para atualizar uma roupa
    btnAtualizar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String id = txtId.getText();
        if (roupas.containsKey(id)) {
          Roupa roupa = roupas.get(id);
          roupa.setNome(txtNome.getText());
          roupa.setPreco(txtPreco.getText());
          roupa.setEstoque(txtEstoque.getText());
          JOptionPane.showMessageDialog(frame, "Roupa atualizada com sucesso!", "Sucesso",
              JOptionPane.INFORMATION_MESSAGE);
        } else {
          JOptionPane.showMessageDialog(frame, "Roupa não encontrada!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    // Ação para deletar uma roupa
    btnDeletar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String id = txtId.getText();
        if (roupas.containsKey(id)) {
          roupas.remove(id);
          JOptionPane.showMessageDialog(frame, "Roupa deletada com sucesso!", "Sucesso",
              JOptionPane.INFORMATION_MESSAGE);
        } else {
          JOptionPane.showMessageDialog(frame, "Roupa não encontrada!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    frame.setVisible(true);
  }
}

// Classe Roupa para representar os dados do produto
class Roupa {
  private String nome;
  private String preco;
  private String estoque;

  public Roupa(String nome, String preco, String estoque) {
    this.nome = nome;
    this.preco = preco;
    this.estoque = estoque;
  }

  // Getters e setters
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getPreco() {
    return preco;
  }

  public void setPreco(String preco) {
    this.preco = preco;
  }

  public String getEstoque() {
    return estoque;
  }

  public void setEstoque(String estoque) {
    this.estoque = estoque;
  }
}
