import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Interface extends javax.swing.JFrame {

    DataHelper dataH = new DataHelper();
    ArrayList<Setor> setores = new ArrayList<>();
    ArrayList<Pedido> pedidos = new ArrayList<>();
    ArrayList<Requisicao> requisicoes = new ArrayList<>();
    DefaultTableModel modeloSetor = new DefaultTableModel();
    DefaultTableModel modeloItem = new DefaultTableModel();
    DefaultTableModel modeloRequisicao = new DefaultTableModel();
    DefaultTableModel modeloPedidos = new DefaultTableModel();

    Prioridade baixa = Prioridade.BAIXA;
    Prioridade normal = Prioridade.NORMAL;
    Prioridade alta = Prioridade.ALTA;
    
    Status aguardando = Status.AGUARDANDO;
    Status finalizado = Status.FINALIZADO;
    Status cancelado = Status.CANCELADO;
    
    private String senha;

    public Interface() {
        this.senha = "12345";
        initComponents();
        modelarTabelas();
        preencherTabelaSetor();
        preencherTabelaItem();
        preencherComboBoxPrioridadeReq();
        btnDelSetor.setEnabled(false);
        btnDeletarItem.setEnabled(false);
        btnAlterarItem.setEnabled(false);
        btnSolicitarReq.setEnabled(false);
        btnRemoverReq.setEnabled(false);
        btnFinalizarPedidos.setEnabled(false);
        btnCancelarPedidos.setEnabled(false);

    }

    private void modelarTabelas() {
        modeloSetor.addColumn("SETOR");
        modeloSetor.addColumn("CÓDIGO");
        modeloSetor.addColumn("ORÇAMENTO");
        tblSetor.setModel(modeloSetor);

        modeloItem.addColumn("ITEM");
        modeloItem.addColumn("VALOR");
        modeloItem.addColumn("SETOR");
        tblItem.setModel(modeloItem);

        modeloRequisicao.addColumn("SETOR");
        modeloRequisicao.addColumn("ITEM");
        modeloRequisicao.addColumn("QUANTIDADE");
        tblRequisicao.setModel(modeloRequisicao);

        modeloPedidos.addColumn("NUMERO");
        modeloPedidos.addColumn("RESPONSAVEL");
        modeloPedidos.addColumn("PRIORIDADE");
        modeloPedidos.addColumn("VALOR TOTAL");
        modeloPedidos.addColumn("DATA");
        modeloPedidos.addColumn("STATUS");
        tblPedidos.setModel(modeloPedidos);

    }

    private void preencherTabelaSetor() {
        modeloSetor.setNumRows(0);
        for (Setor s : setores) {
            modeloSetor.addRow(new Object[]{s.getNome(), s.getCodIdentificacao(), s.getOrcamento()});
        }
    }

    private void preencherTabelaItem() {
        modeloItem.setNumRows(0);
        modeloSetor.setNumRows(0);
        for (Setor s : setores) {
            for (Produto p : s.getProdutos()) {
                modeloItem.addRow(new Object[]{p.getNome(), p.getValor(), s.getNome()});
            }
        }
    }

    private void preencherTabelaRequisicao() {
        modeloRequisicao.setNumRows(0);
        for (Requisicao r : requisicoes) {
            modeloRequisicao.addRow(new Object[]{r.getNomeSetor(),
                                                 r.getProduto().getNome(),
                                                 r.getQuantidade()});
        }
    }

    private void preencherTabelaPedidos() {
        modeloPedidos.setNumRows(0);
        for (Pedido p : pedidos) {
            modeloPedidos.addRow(new Object[]{p.getNumero(),
                                              p.getResponsavel(),
                                              p.getPrioridade(),
                                              p.getValorTotal(),
                                              dataH.getData(),
                                              p.getStatus()});
        }
    }

    private void preencherComboBoxSetor() {
        cbSetorItem.removeAllItems();
        cbSetorRequisicao.removeAllItems();
        for (Setor s : setores) {
            cbSetorRequisicao.addItem(s.getNome());
            cbSetorItem.addItem(s.getNome());
        }
    }

    private void preencherComboBoxItemRequisao() {;
        if (cbSetorItem.getSelectedItem() != null) {
            cbItemReq.removeAllItems();
            int pos_setor = procurarIndiceSetor(cbSetorRequisicao.getSelectedItem().toString());
            for (Produto produto : setores.get(pos_setor).getProdutos()) {
                cbItemReq.addItem(produto);
            }
        }
    }

    private Integer procurarIndiceSetor(String nome) {

        for (int i = 0; i < setores.size(); i++) {
            if (setores.get(i).getNome().equals(nome)) {
                return i;
            }
        }
        return null;
    }

    private void preencherComboBoxPrioridadeReq() {
        cbPrioridadePedido.removeAllItems();
        cbPrioridadePedido.addItem(baixa.name());
        cbPrioridadePedido.addItem(normal.name());
        cbPrioridadePedido.addItem(alta.name());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        PanelSetor = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtNomeSetor = new javax.swing.JTextField();
        txtCodSetor = new javax.swing.JTextField();
        btnCadSetor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSetor = new javax.swing.JTable();
        btnDelSetor = new javax.swing.JButton();
        txtOrcamentoSetor = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        PanelItem = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        txtNomeItem = new javax.swing.JTextField();
        txtValorItem = new javax.swing.JTextField();
        btnCadastrarItem = new javax.swing.JButton();
        btnDeletarItem = new javax.swing.JButton();
        btnAlterarItem = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblItem = new javax.swing.JTable();
        cbSetorItem = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        PanelRequisicao = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnSolicitarReq = new javax.swing.JButton();
        cbPrioridadePedido = new javax.swing.JComboBox<>();
        btnAdicionarReq = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblRequisicao = new javax.swing.JTable();
        btnRemoverReq = new javax.swing.JButton();
        txtQtdReq = new javax.swing.JTextField();
        txtResponsavelReq = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cbSetorRequisicao = new javax.swing.JComboBox<>();
        cbItemReq = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        PanelPedidos = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        btnFinalizarPedidos = new javax.swing.JButton();
        btnCancelarPedidos = new javax.swing.JButton();
        passwordPedidos = new javax.swing.JPasswordField();

        jButton1.setText("jButton1");

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        jLabel5.setText("jLabel5");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jLabel7.setText("jLabel7");

        jLabel9.setText("jLabel9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pedidos");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.gray);
        setLocation(new java.awt.Point(500, 300));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 400));

        jTabbedPane1.setBackground(new java.awt.Color(102, 255, 255));
        jTabbedPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });
        jTabbedPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusLost(evt);
            }
        });

        PanelSetor.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setText("Setor");

        txtNomeSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeSetorActionPerformed(evt);
            }
        });

        txtCodSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodSetorActionPerformed(evt);
            }
        });

        btnCadSetor.setText("Cadastrar");
        btnCadSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadSetorActionPerformed(evt);
            }
        });

        jScrollPane1.setName(""); // NOI18N

        tblSetor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblSetor);

        btnDelSetor.setText("Deletar");
        btnDelSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelSetorActionPerformed(evt);
            }
        });

        txtOrcamentoSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrcamentoSetorActionPerformed(evt);
            }
        });

        jLabel10.setText("Nome:");

        jLabel11.setText("Cód.");

        jLabel12.setText("Orçamento:");

        javax.swing.GroupLayout PanelSetorLayout = new javax.swing.GroupLayout(PanelSetor);
        PanelSetor.setLayout(PanelSetorLayout);
        PanelSetorLayout.setHorizontalGroup(
            PanelSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(PanelSetorLayout.createSequentialGroup()
                .addGroup(PanelSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelSetorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(65, 65, 65)
                        .addGroup(PanelSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelSetorLayout.createSequentialGroup()
                                .addComponent(btnCadSetor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDelSetor))
                            .addComponent(txtOrcamentoSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomeSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(PanelSetorLayout.createSequentialGroup()
                        .addGap(337, 337, 337)
                        .addComponent(jLabel1)
                        .addGap(0, 404, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelSetorLayout.setVerticalGroup(
            PanelSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSetorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelSetorLayout.createSequentialGroup()
                        .addGroup(PanelSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomeSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(PanelSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOrcamentoSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(PanelSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDelSetor)
                            .addComponent(btnCadSetor))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelSetorLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addGap(90, 90, 90))))
        );

        jTabbedPane1.addTab("Setores", PanelSetor);

        PanelItem.setBackground(new java.awt.Color(204, 255, 255));

        jLabel6.setText("Item");

        txtNomeItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeItemActionPerformed(evt);
            }
        });

        txtValorItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorItemActionPerformed(evt);
            }
        });

        btnCadastrarItem.setText("Cadastrar");
        btnCadastrarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarItemActionPerformed(evt);
            }
        });

        btnDeletarItem.setText("Deletar");
        btnDeletarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarItemActionPerformed(evt);
            }
        });

        btnAlterarItem.setText("Alterar");
        btnAlterarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarItemActionPerformed(evt);
            }
        });

        tblItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tblItem);

        jLabel16.setText("Nome:");

        jLabel17.setText("Valor:");

        jLabel18.setText("Setor:");

        javax.swing.GroupLayout PanelItemLayout = new javax.swing.GroupLayout(PanelItem);
        PanelItem.setLayout(PanelItemLayout);
        PanelItemLayout.setHorizontalGroup(
            PanelItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelItemLayout.createSequentialGroup()
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3))
            .addGroup(PanelItemLayout.createSequentialGroup()
                .addGap(341, 341, 341)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(PanelItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelItemLayout.createSequentialGroup()
                        .addComponent(btnCadastrarItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAlterarItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeletarItem))
                    .addComponent(txtValorItem)
                    .addComponent(cbSetorItem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNomeItem))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelItemLayout.setVerticalGroup(
            PanelItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelItemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelItemLayout.createSequentialGroup()
                        .addGroup(PanelItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomeItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtValorItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbSetorItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(PanelItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAlterarItem)
                            .addComponent(btnDeletarItem)
                            .addComponent(btnCadastrarItem)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );

        jTabbedPane1.addTab("Item", PanelItem);

        PanelRequisicao.setBackground(new java.awt.Color(204, 255, 255));

        jLabel4.setText("Requisição de Pedido");

        btnSolicitarReq.setText("Solicitar");
        btnSolicitarReq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarReqActionPerformed(evt);
            }
        });

        btnAdicionarReq.setText("Adicionar");
        btnAdicionarReq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarReqActionPerformed(evt);
            }
        });

        tblRequisicao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tblRequisicao);

        btnRemoverReq.setText("Remover");
        btnRemoverReq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverReqActionPerformed(evt);
            }
        });

        txtQtdReq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtdReqActionPerformed(evt);
            }
        });

        jLabel13.setText("Item:");

        jLabel14.setText("Qtd.");

        cbSetorRequisicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSetorRequisicaoActionPerformed(evt);
            }
        });

        jLabel21.setText("Setor:");

        jLabel15.setText("Prioridade:");

        jLabel19.setText("Responsável:");

        javax.swing.GroupLayout PanelRequisicaoLayout = new javax.swing.GroupLayout(PanelRequisicao);
        PanelRequisicao.setLayout(PanelRequisicaoLayout);
        PanelRequisicaoLayout.setHorizontalGroup(
            PanelRequisicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(PanelRequisicaoLayout.createSequentialGroup()
                .addGroup(PanelRequisicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRequisicaoLayout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(jLabel4))
                    .addGroup(PanelRequisicaoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelRequisicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelRequisicaoLayout.createSequentialGroup()
                                .addGroup(PanelRequisicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel21))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(PanelRequisicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbItemReq, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbSetorRequisicao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelRequisicaoLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(52, 52, 52)
                                .addGroup(PanelRequisicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelRequisicaoLayout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(btnAdicionarReq)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnRemoverReq))
                                    .addComponent(txtQtdReq, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(29, 29, 29)
                        .addGroup(PanelRequisicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(PanelRequisicaoLayout.createSequentialGroup()
                                .addGroup(PanelRequisicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel15))
                                .addGap(31, 31, 31)
                                .addGroup(PanelRequisicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelRequisicaoLayout.createSequentialGroup()
                                        .addComponent(txtResponsavelReq, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSolicitarReq))
                                    .addComponent(cbPrioridadePedido, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        PanelRequisicaoLayout.setVerticalGroup(
            PanelRequisicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRequisicaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelRequisicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRequisicaoLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(PanelRequisicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbPrioridadePedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(9, 9, 9))
                    .addGroup(PanelRequisicaoLayout.createSequentialGroup()
                        .addGroup(PanelRequisicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbSetorRequisicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelRequisicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(cbItemReq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelRequisicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtQtdReq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelRequisicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdicionarReq)
                            .addComponent(btnRemoverReq))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(PanelRequisicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRequisicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtResponsavelReq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSolicitarReq))
                    .addComponent(jLabel19))
                .addGap(17, 17, 17))
        );

        jTabbedPane1.addTab("Requisição", PanelRequisicao);

        PanelPedidos.setBackground(new java.awt.Color(204, 255, 255));

        tblPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(tblPedidos);

        jLabel8.setText("Pedidos");

        jLabel20.setText("Senha Acesso:");

        btnFinalizarPedidos.setText("Finalizar");
        btnFinalizarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarPedidosActionPerformed(evt);
            }
        });

        btnCancelarPedidos.setText("Cancelar");
        btnCancelarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPedidosActionPerformed(evt);
            }
        });

        passwordPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordPedidosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelPedidosLayout = new javax.swing.GroupLayout(PanelPedidos);
        PanelPedidos.setLayout(PanelPedidosLayout);
        PanelPedidosLayout.setHorizontalGroup(
            PanelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(PanelPedidosLayout.createSequentialGroup()
                .addGroup(PanelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPedidosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE))
                    .addGroup(PanelPedidosLayout.createSequentialGroup()
                        .addGroup(PanelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelPedidosLayout.createSequentialGroup()
                                .addGap(332, 332, 332)
                                .addComponent(jLabel8))
                            .addGroup(PanelPedidosLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105)
                                .addComponent(btnFinalizarPedidos)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelarPedidos)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelPedidosLayout.setVerticalGroup(
            PanelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPedidosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(PanelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(btnFinalizarPedidos)
                    .addComponent(btnCancelarPedidos)
                    .addComponent(passwordPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pedidos", PanelPedidos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadSetorActionPerformed
        try{
            if (txtNomeSetor.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo NOME está vazio!", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else if (txtCodSetor.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo COD está vazio!", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else if (txtOrcamentoSetor.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo ORÇAMENTO está vazio!", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else {
                Setor setor = new Setor();
                setor.setNome(txtNomeSetor.getText());
                setor.setCodIdentificacao(Integer.parseInt(txtCodSetor.getText()));
                setor.setOrcamento(Double.parseDouble(txtOrcamentoSetor.getText()));

                int erro = 0;
                for (Setor s : setores) {
                    if (setor.getNome().equals(s.getNome()) || setor.getCodIdentificacao() == s.getCodIdentificacao()) {
                        erro++;
                    }
                }

                if (erro > 0) {
                    JOptionPane.showMessageDialog(null, "Um setor com esses dados já está cadastrado", "Atenção", JOptionPane.WARNING_MESSAGE);
                } else {
                    setores.add(setor);
                    preencherTabelaSetor();
                    btnDelSetor.setEnabled(true);
                }

                txtNomeSetor.setText("");
                txtCodSetor.setText("");
                txtOrcamentoSetor.setText("");
            }
        }
        catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Tipo de dado inválido!\nCód. espera um número inteiro.\n"
                    + "Orçamento espera um número", "Atenção", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCadSetorActionPerformed

    private void btnDelSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelSetorActionPerformed
        try {
        int linha = tblSetor.getSelectedRow();

        setores.remove(linha);
        JOptionPane.showMessageDialog(null, "Setor deletado!", "Atenção", JOptionPane.WARNING_MESSAGE);
        preencherTabelaSetor();

        if (tblSetor.getRowCount() == 0) {
            btnDelSetor.setEnabled(false);
        }
        } catch ( IndexOutOfBoundsException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum setor selecionado!", "Atenção", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDelSetorActionPerformed

    private void btnCadastrarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarItemActionPerformed
        try {
            int pos_setor = procurarIndiceSetor(cbSetorItem.getSelectedItem().toString());
            if (txtNomeItem.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo NOME está vazio!", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else if (txtValorItem.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo VALOR está vazio!", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else if (cbSetorItem.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Selecione um setor!", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else {
                Produto produto = new Produto();
                produto.setNome(txtNomeItem.getText());
                produto.setValor(Double.parseDouble(txtValorItem.getText()));

                int erro = 0;
                for (Setor s : setores) {
                    for (Produto p : setores.get(pos_setor).getProdutos()) {
                        if (produto.getNome().equals(p.getNome())) {
                            erro++;
                        }
                    }
                }

                if (erro > 0) {
                    JOptionPane.showMessageDialog(null, "Um item com esses dados já está cadastrado", "Atenção", JOptionPane.WARNING_MESSAGE);
                } else {
                    setores.get(pos_setor).getProdutos().add(produto);
                    preencherTabelaItem();
                    btnDeletarItem.setEnabled(true);
                    btnAlterarItem.setEnabled(true);
                }

                txtNomeItem.setText("");
                txtValorItem.setText("");
            }
        }
        catch(NullPointerException ex){
            JOptionPane.showMessageDialog(null, "Nenhum setor criado!", "Atenção", JOptionPane.ERROR_MESSAGE);
        }
        catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Campo VALOR espera um número", "Atenção", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCadastrarItemActionPerformed

    private void btnAlterarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarItemActionPerformed
        try {
        Produto produto = new Produto();
        int linha = tblItem.getSelectedRow();
        String nomeSetor = tblItem.getValueAt(linha, 2).toString();
        String nomeProduto = tblItem.getValueAt(linha, 0).toString();

        produto.setNome(JOptionPane.showInputDialog("Item"));
        produto.setValor(Double.parseDouble(JOptionPane.showInputDialog("Valor")));

        Integer indice = -1;
        for (int i = 0; i < setores.size(); i++) {
            if (setores.get(i).getNome().equals(nomeSetor)) {
                indice = i;
            }
        }

        setores.get(indice).alterarItem(produto, nomeProduto);
        preencherTabelaItem();
        } catch(IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum item selecionado!", "Atenção", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnAlterarItemActionPerformed

    private void btnDeletarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarItemActionPerformed
        try {
        int linha = tblItem.getSelectedRow();
        String nomeSetor = tblItem.getValueAt(linha, 2).toString();
        String nomeItem = tblItem.getValueAt(linha, 0).toString();

        Integer indice = -1;
        for (int i = 0; i < setores.size(); i++) {
            if (setores.get(i).getNome().equals(nomeSetor)) {
                indice = i;
            }
        }

        setores.get(indice).removerItem(nomeItem);

        preencherTabelaItem();
        if (tblItem.getRowCount() == 0) {
            btnDeletarItem.setEnabled(false);
            btnAlterarItem.setEnabled(false);
        }
        } catch (IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum item selecionado!", "Atenção", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeletarItemActionPerformed

    private void btnAdicionarReqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarReqActionPerformed
        try{
            if (txtQtdReq.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo QUANTIDADE está vazio!", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else if (cbItemReq.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Campo ITEM está vazio!", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else if (cbPrioridadePedido.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Selecione uma PRIORIDADE!", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else {
                Requisicao requisicao = new Requisicao();
                requisicao.setNomeSetor(cbSetorRequisicao.getSelectedItem().toString());
                requisicao.setQuantidade(Double.parseDouble(txtQtdReq.getText()));
                requisicao.setProduto((Produto) cbItemReq.getSelectedItem());
                requisicoes.add(requisicao);
                preencherTabelaRequisicao();
                btnSolicitarReq.setEnabled(true);
                btnRemoverReq.setEnabled(true);
            }
            txtQtdReq.setText("");
        }
        catch(NullPointerException ex){
            JOptionPane.showMessageDialog(null, "Campos vazios", "Atenção", JOptionPane.ERROR_MESSAGE);
        }
        catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Campo QTD. espera um número", "Atenção", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAdicionarReqActionPerformed

    private void btnSolicitarReqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarReqActionPerformed

        if (txtResponsavelReq.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo RESPONSAVEL está vazio!", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else if (tblRequisicao.getRowCount() == 0) {
            JOptionPane.showConfirmDialog(null, "Nenhum produto cadastrado", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            Pedido pedido = new Pedido();
            pedido.setNumero(pedido);
            pedido.setResponsavel(txtResponsavelReq.getText());
            pedido.setPrioridade(cbPrioridadePedido.getSelectedItem().toString());
            pedido.setStatus(aguardando);
            pedido.setRequisicoes(requisicoes);
            pedido.setValorTotal(pedido);
            pedidos.add(pedido);
            preencherTabelaPedidos();

            btnFinalizarPedidos.setEnabled(true);
            btnCancelarPedidos.setEnabled(true);

            btnRemoverReq.setEnabled(false);
            btnSolicitarReq.setEnabled(false);

        }

        modeloRequisicao.setNumRows(0);
        requisicoes.clear();
        txtQtdReq.setText("");
        txtResponsavelReq.setText("");

    }//GEN-LAST:event_btnSolicitarReqActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        preencherTabelaSetor();
        preencherComboBoxSetor();
        preencherComboBoxPrioridadeReq();
        preencherComboBoxItemRequisao();
        modeloRequisicao.setNumRows(0);
        requisicoes.clear();
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void cbSetorRequisicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSetorRequisicaoActionPerformed
        preencherComboBoxItemRequisao();
    }//GEN-LAST:event_cbSetorRequisicaoActionPerformed

    private void btnRemoverReqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverReqActionPerformed
        try {
        int linha = tblRequisicao.getSelectedRow();

        requisicoes.remove(linha);
        preencherTabelaRequisicao();

        if (tblRequisicao.getRowCount() == 0) {
            btnRemoverReq.setEnabled(false);
            btnSolicitarReq.setEnabled(false);
        }
        } catch(IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum item selecionado!", "Atenção", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRemoverReqActionPerformed

    private void btnFinalizarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarPedidosActionPerformed
        int pedido_selecionado = tblPedidos.getSelectedRow();
        try {
            if (pedidos.get(pedido_selecionado).getStatus().equals(aguardando) && new String(passwordPedidos.getPassword()).equals(senha)) {
                pedidos.get(pedido_selecionado).setStatus(finalizado);
            }
            else if (new String(passwordPedidos.getPassword()) != senha) {
                JOptionPane.showMessageDialog(null, "Senha incorreta!", "Falha de acesso", JOptionPane.ERROR_MESSAGE);
            }
            else if (pedidos.get(pedido_selecionado).getStatus() != aguardando && new String(passwordPedidos.getPassword()).equals(senha)){
                JOptionPane.showMessageDialog(null, "Esse pedido já possui um status atribuido", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
            preencherTabelaPedidos();
            passwordPedidos.setText("");
        } catch (IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum pedido selecionado!", "Atenção", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnFinalizarPedidosActionPerformed

    private void btnCancelarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPedidosActionPerformed
        int pedido_selecionado = tblPedidos.getSelectedRow();
        try {
            if (pedidos.get(pedido_selecionado).getStatus().equals(aguardando) && new String(passwordPedidos.getPassword()).equals(senha)) {
                pedidos.get(pedido_selecionado).setStatus(cancelado);
            } else if (new String(passwordPedidos.getPassword()) != senha) {
                JOptionPane.showMessageDialog(null, "Senha incorreta!", "Falha de acesso", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Esse pedido já possui um status atribuido", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
            preencherTabelaPedidos();
            passwordPedidos.setText("");
        } catch (IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum pedido selecionado!");
        }
    }//GEN-LAST:event_btnCancelarPedidosActionPerformed

    private void txtNomeSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeSetorActionPerformed
        txtNomeSetor.requestFocus();
        txtNomeSetor.transferFocus();
    }//GEN-LAST:event_txtNomeSetorActionPerformed

    private void txtCodSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodSetorActionPerformed
        txtCodSetor.transferFocus();
    }//GEN-LAST:event_txtCodSetorActionPerformed

    private void txtOrcamentoSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrcamentoSetorActionPerformed
        txtOrcamentoSetor.transferFocus();
    }//GEN-LAST:event_txtOrcamentoSetorActionPerformed

    private void txtNomeItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeItemActionPerformed
        txtNomeItem.requestFocus();
        txtNomeItem.transferFocus();
    }//GEN-LAST:event_txtNomeItemActionPerformed

    private void txtValorItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorItemActionPerformed
        txtValorItem.transferFocus();
    }//GEN-LAST:event_txtValorItemActionPerformed

    private void txtQtdReqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtdReqActionPerformed
        txtQtdReq.requestFocus();
    }//GEN-LAST:event_txtQtdReqActionPerformed

    private void passwordPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordPedidosActionPerformed
        passwordPedidos.requestFocus();
    }//GEN-LAST:event_passwordPedidosActionPerformed

    private void jTabbedPane1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusLost
        btnRemoverReq.setEnabled(false);
        btnSolicitarReq.setEnabled(false);
    }//GEN-LAST:event_jTabbedPane1FocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelItem;
    private javax.swing.JPanel PanelPedidos;
    private javax.swing.JPanel PanelRequisicao;
    private javax.swing.JPanel PanelSetor;
    private javax.swing.JButton btnAdicionarReq;
    private javax.swing.JButton btnAlterarItem;
    private javax.swing.JButton btnCadSetor;
    private javax.swing.JButton btnCadastrarItem;
    private javax.swing.JButton btnCancelarPedidos;
    private javax.swing.JButton btnDelSetor;
    private javax.swing.JButton btnDeletarItem;
    private javax.swing.JButton btnFinalizarPedidos;
    private javax.swing.JButton btnRemoverReq;
    private javax.swing.JButton btnSolicitarReq;
    private javax.swing.JComboBox<Produto> cbItemReq;
    private javax.swing.JComboBox<String> cbPrioridadePedido;
    private javax.swing.JComboBox<String> cbSetorItem;
    private javax.swing.JComboBox<String> cbSetorRequisicao;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPasswordField passwordPedidos;
    private javax.swing.JTable tblItem;
    private javax.swing.JTable tblPedidos;
    private javax.swing.JTable tblRequisicao;
    private javax.swing.JTable tblSetor;
    private javax.swing.JTextField txtCodSetor;
    private javax.swing.JTextField txtNomeItem;
    private javax.swing.JTextField txtNomeSetor;
    private javax.swing.JTextField txtOrcamentoSetor;
    private javax.swing.JTextField txtQtdReq;
    private javax.swing.JTextField txtResponsavelReq;
    private javax.swing.JTextField txtValorItem;
    // End of variables declaration//GEN-END:variables
}
