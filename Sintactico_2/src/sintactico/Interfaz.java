package sintactico;

import java.awt.Color;
import java.io.IOException;
import java.io.StringReader;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import static sintactico.Token.DECIMAL;
import static sintactico.Token.DIV;
import static sintactico.Token.IGUAL;
import static sintactico.Token.LINEA;
import static sintactico.Token.NUMERO;
import static sintactico.Token.PORCENTAJE;
import static sintactico.Token.SQRT;


public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
    }
    
    private void analizarSemantico() throws Exception{
        String seman = (String) Entrada.getText();
        String[] Semantico = seman.split(" ");
        
        
       if (Semantico.length < 1) {
        txtAnalizarSeman.setText("Expresión incorrecta");
    } else {
        for (int i = 1; i < Semantico.length; i += 2) {
            String operador = Semantico[i];
            String operadorS = Semantico[0];

            if (!operador.equals("+") && !operador.equals("-") && !operador.equals("*") && !operador.equals("/") && !operadorS.equals("sqrt") && !operador.equals("%")) {
                txtAnalizarSeman.setText("Operador inválido");
                txtAnalizarSeman.setForeground(Color.red);
                //txtAnalizarSeman.setText("Operador: " + operador);
                return; // Terminar el método si hay un error
            }

            if (operador.equals("/") && Semantico[i + 1].equals("0")) {
                txtAnalizarSeman.setText("No se puede dividir por cero");
                txtAnalizarSeman.setForeground(Color.blue);
                return; // Terminar el método si hay un error
            }
            else {
                txtAnalizarSeman.setText("Sin errores semánticos");
                txtAnalizarSeman.setForeground(new Color(25, 111, 61));
            }
    }
}
}
    
    @SuppressWarnings("empty-statement")
    private void operaciones() throws IOException{
        String ope = (String) Entrada.getText();
        String[] operacion = ope.split(" ");
        
        //int num1 = Integer.parseInt(operacion[0]);
        //int num2 = Integer.parseInt(operacion[2]);
        //int num3 = Integer.parseInt(operacion[4]);
        
        double re = 0.0;
        double res = 0.0;
        double res1= 0.0;
        double res2= 0.0;
        double res3= 0.0;
        
         switch (operacion[0]){
                case "sqrt":
                        double num1 = Double.parseDouble(operacion[1]);
                        double raizCuadrada = Math.sqrt(num1);
                    txtOpe.setText(String.valueOf(raizCuadrada));
                    break;
            }
        switch (operacion[1]){
            case "+":
                if (operacion.length == 3) {
                    double num1 = Double.parseDouble(operacion[0]);
                    double num2 = Double.parseDouble(operacion[2]);
                    re = num1 + num2;
                    txtOpe.setText(String.valueOf(re));
                } else if (operacion.length > 3) {
                        double num1 = Double.parseDouble(operacion[0]);
                        double num2 = Double.parseDouble(operacion[2]);
                        double num3 = Double.parseDouble(operacion[4]);
                        
                        res = num1 + num2 + num3;
                        res1 = num1 + num2 - num3;
                        res2 = num1 + num2 * num3;
                        res3 = num1 + num2 / num3;
                       
                    txtOpe.setText(String.valueOf(res));  
                    txtOpe.setText(String.valueOf(res1));
                    txtOpe.setText(String.valueOf(res2));
                    txtOpe.setText(String.valueOf(res3));
                }
                    //txtOpe.setText(String.valueOf(re));
                    /*txtOpe.setText(String.valueOf(res));
                    txtOpe.setText(String.valueOf(res1));
                    txtOpe.setText(String.valueOf(res2));
                    txtOpe.setText(String.valueOf(res3));*/
                    break;
            case "-":
                if (operacion.length == 3) {
                    double num1 = Double.parseDouble(operacion[0]);
                    double num2 = Double.parseDouble(operacion[2]);
                    re = num1 - num2;
                    txtOpe.setText(String.valueOf(re));
                } else if (operacion.length > 3) {
                        double num1 = Double.parseDouble(operacion[0]);
                        double num2 = Double.parseDouble(operacion[2]);
                        double num3 = Double.parseDouble(operacion[4]);
                        res = num1 - num2 - num3;
                        res1 = num1 - num2 + num3;
                        res2 = num1 - num2 * num3;
                        res3 = num1 - num2 / num3;
                        
                    txtOpe.setText(String.valueOf(res));
                    txtOpe.setText(String.valueOf(res1));
                    txtOpe.setText(String.valueOf(res2));
                    txtOpe.setText(String.valueOf(res3));
                }

                    break;
                case "*":
                if (operacion.length == 3) {
                    double num1 = Double.parseDouble(operacion[0]);
                    double num2 = Double.parseDouble(operacion[2]);
                    re = num1 * num2;
                    txtOpe.setText(String.valueOf(re));
                } else if (operacion.length > 3) {
                        double num1 = Double.parseDouble(operacion[0]);
                        double num2 = Double.parseDouble(operacion[2]);
                        double num3 = Double.parseDouble(operacion[4]);
                        res = num1 * num2 * num3;
                        res1 = num2 * num2 + num3;
                        res2 = num2 * num2 - num3;
                        res3 = num2 * num2 / num3;
                        
                    txtOpe.setText(String.valueOf(res));
                    txtOpe.setText(String.valueOf(res1));
                    txtOpe.setText(String.valueOf(res2));
                    txtOpe.setText(String.valueOf(res3));
                }
                    
                    
                    break;
                case "/":
                if (operacion.length == 3) {
                    double num1 = Double.parseDouble(operacion[0]);
                    double num2 = Double.parseDouble(operacion[2]);
                    re = num1 / num2;
                    txtOpe.setText(String.valueOf(re));
                } else if (operacion.length > 3) {
                        double num1 = Double.parseDouble(operacion[0]);
                        double num2 = Double.parseDouble(operacion[2]);
                        double num3 = Double.parseDouble(operacion[4]);
                        res = num1 / num2 / num3;
                        res1 = num2 / num2 + num3;
                        res2 = num2 / num2 * num3;
                        res3 = num2 / num2 - num3;
                        
                    txtOpe.setText(String.valueOf(res));
                    txtOpe.setText(String.valueOf(res1));
                    txtOpe.setText(String.valueOf(res2));
                    txtOpe.setText(String.valueOf(res3));
                }
                   
                    
                    break;
                case "%":
                    if (operacion.length == 3) {
                        double num1 = Double.parseDouble(operacion[0]);
                        double num2 = Double.parseDouble(operacion[2]);
                        res = num1 * (num2 / 100);
                }
                    txtOpe.setText(String.valueOf(res));
                    break;
                //default:
                  //txtOpe.setText(txtOpe.getText()+ "\nVACIO");
         }
    }
    
            
        
        private void analizarLexico() throws IOException{
        int cont = 1;
        byte columna = 0;
        byte fila = -1;
        
        String ope = (String) Entrada.getText();
        String[] resu = ope.split(" ");
        
        String expr = (String) Entrada.getText();
        Lexer lexer = new Lexer(new StringReader(expr));
        String resultado = "LÍNEA " + cont + "\t\tSÍMBOLO\n";
        
        while (true){
        fila += 1;
        Token token = lexer.yylex();
        if (token == null){
            return;
        }
        switch (token){
            case LINEA:
                cont++;
                //Tabla_Lexica.setValueAt("Linea" + cont + "\n" , fila, columna);
                break;
            case NUMERO:
                Tabla_Lexica.setValueAt("#" + cont + "\n" , fila, columna);
                Tabla_Lexica.setValueAt(lexer.lexeme, fila, columna+1);
                Tabla_Lexica.setValueAt("Entero", fila, columna+2);
                break;
            case DECIMAL:
                Tabla_Lexica.setValueAt("#" + cont + "\n" , fila, columna);
                Tabla_Lexica.setValueAt(lexer.lexeme, fila, columna+1);
                Tabla_Lexica.setValueAt("Decimal", fila, columna+2);
                break;
            case SUMA:
                Tabla_Lexica.setValueAt("#" + cont + "\n" , fila, columna);
                Tabla_Lexica.setValueAt(lexer.lexeme, fila, columna+1);
                Tabla_Lexica.setValueAt("Suma", fila, columna+2);
                break;
            case RESTA:
                Tabla_Lexica.setValueAt("#" + cont + "\n" , fila, columna);
                Tabla_Lexica.setValueAt(lexer.lexeme, fila, columna+1);
                Tabla_Lexica.setValueAt("Resta", fila, columna+2);
                break;
            case MULT:
                Tabla_Lexica.setValueAt("#" + cont + "\n" , fila, columna);
                Tabla_Lexica.setValueAt(lexer.lexeme, fila, columna+1);
                Tabla_Lexica.setValueAt("Multiplicación", fila, columna+2);
                break;
            case DIV:
                Tabla_Lexica.setValueAt("#" + cont + "\n" , fila, columna);
                Tabla_Lexica.setValueAt(lexer.lexeme, fila, columna+1);
                Tabla_Lexica.setValueAt("División", fila, columna+2);
                break;
            case P_A:
                Tabla_Lexica.setValueAt("#" + cont + "\n" , fila, columna);
                Tabla_Lexica.setValueAt(lexer.lexeme, fila, columna+1);
                Tabla_Lexica.setValueAt("Parentesis de apertura", fila, columna+2);
                break;
            case P_C:
                Tabla_Lexica.setValueAt("#" + cont + "\n" , fila, columna);
                Tabla_Lexica.setValueAt(lexer.lexeme, fila, columna+1);
                Tabla_Lexica.setValueAt("Parentesis de cierre", fila, columna+2);
                break;
            case SQRT:
                Tabla_Lexica.setValueAt("#" + cont + "\n" , fila, columna);
                Tabla_Lexica.setValueAt(lexer.lexeme, fila, columna+1);
                Tabla_Lexica.setValueAt("Raiz cuadrada", fila, columna+2);
                break;
            case PORCENTAJE:
                Tabla_Lexica.setValueAt("#" + cont + "\n" , fila, columna);
                Tabla_Lexica.setValueAt(lexer.lexeme, fila, columna+1);
                Tabla_Lexica.setValueAt("Porcentaje", fila, columna+2);
                break;
            case IGUAL:
                Tabla_Lexica.setValueAt("#" + cont + "\n" , fila, columna);
                Tabla_Lexica.setValueAt(lexer.lexeme, fila, columna+1);
                Tabla_Lexica.setValueAt("Igual", fila, columna+2);
                break;
            default:
                resultado += "<"+ lexer.lexeme+">\n";
                
                switch (resu[0]){
                case "sqrt":
                        Tabla_Lexica.setValueAt("#" + cont + "\n" , fila, columna);
                        Tabla_Lexica.setValueAt("sqrt", fila, columna+1);
                        Tabla_Lexica.setValueAt("Raiz cuadrada", fila, columna+2);
                    break;
                }
                switch (resu[1]){
                case "%":
                        Tabla_Lexica.setValueAt("#" + cont + "\n" , fila, columna);
                        Tabla_Lexica.setValueAt("%", fila, columna+1);
                        Tabla_Lexica.setValueAt("Porcentaje", fila, columna+2);
                    break;
            }
        }
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        btnAnalizarLex = new javax.swing.JButton();
        btnLimpiarLex = new javax.swing.JButton();
        btnAnalizarSin = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAnalizarSin = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Entrada = new javax.swing.JEditorPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla_Lexica = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtOpe = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        btnOpRe = new javax.swing.JButton();
        btnAnalizarSeman = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtAnalizarSeman = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));

        btnAnalizarLex.setBackground(new java.awt.Color(255, 204, 255));
        btnAnalizarLex.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        btnAnalizarLex.setText("Analizador Léxico");
        btnAnalizarLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarLexActionPerformed(evt);
            }
        });

        btnLimpiarLex.setBackground(new java.awt.Color(255, 204, 255));
        btnLimpiarLex.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        btnLimpiarLex.setText("Limpiar");
        btnLimpiarLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarLexActionPerformed(evt);
            }
        });

        btnAnalizarSin.setBackground(new java.awt.Color(255, 204, 255));
        btnAnalizarSin.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        btnAnalizarSin.setText("Analizador Sintáctico");
        btnAnalizarSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarSinActionPerformed(evt);
            }
        });

        txtAnalizarSin.setEditable(false);
        txtAnalizarSin.setColumns(20);
        txtAnalizarSin.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        txtAnalizarSin.setRows(5);
        jScrollPane3.setViewportView(txtAnalizarSin);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel1.setText("Calculadora con analizador léxico, sintáctico y semántico");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel3.setText("Analizador Semántico");

        Entrada.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jScrollPane1.setViewportView(Entrada);

        Tabla_Lexica.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        Tabla_Lexica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Linea", "Token", "Lexema"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla_Lexica.setMaximumSize(new java.awt.Dimension(2147483647, 1200));
        Tabla_Lexica.setMinimumSize(new java.awt.Dimension(45, 1200));
        jScrollPane2.setViewportView(Tabla_Lexica);

        txtOpe.setColumns(20);
        txtOpe.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        txtOpe.setRows(5);
        jScrollPane4.setViewportView(txtOpe);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel2.setText("Ingresar operación");

        btnOpRe.setBackground(new java.awt.Color(255, 204, 255));
        btnOpRe.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        btnOpRe.setText("Calculadora");
        btnOpRe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpReActionPerformed(evt);
            }
        });

        btnAnalizarSeman.setBackground(new java.awt.Color(255, 204, 255));
        btnAnalizarSeman.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        btnAnalizarSeman.setText("Analizador Semántico");
        btnAnalizarSeman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarSemanActionPerformed(evt);
            }
        });

        txtAnalizarSeman.setColumns(20);
        txtAnalizarSeman.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        txtAnalizarSeman.setRows(5);
        jScrollPane5.setViewportView(txtAnalizarSeman);

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel5.setText("Analizador Sintático");

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel6.setText("Resultado");

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel7.setText("Analizador Léxico");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnOpRe)
                        .addGap(104, 104, 104)
                        .addComponent(btnLimpiarLex))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnAnalizarLex)
                        .addGap(80, 80, 80)
                        .addComponent(btnAnalizarSin)
                        .addGap(126, 126, 126)
                        .addComponent(btnAnalizarSeman, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(164, 164, 164)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3)
                                    .addComponent(jScrollPane3)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel6)
                    .addContainerGap(882, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel7))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(60, 60, 60)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAnalizarLex)
                            .addComponent(btnAnalizarSin)
                            .addComponent(btnAnalizarSeman)
                            .addComponent(btnOpRe)
                            .addComponent(btnLimpiarLex))
                        .addGap(34, 34, 34))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(349, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addGap(279, 279, 279)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarLexActionPerformed
        // TODO add your handling code here:
        Entrada.setText(null);
        txtAnalizarSin.setText(null);
        txtOpe.setText(null);
        txtAnalizarSeman.setText(null);
    }//GEN-LAST:event_btnLimpiarLexActionPerformed

    private void btnAnalizarLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarLexActionPerformed
        try {
            analizarLexico();
        } catch (IOException ex){
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAnalizarLexActionPerformed

    private void btnAnalizarSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarSinActionPerformed
        // TODO add your handling code here:
        String ST = Entrada.getText();
        int Correcto=0;
        Sintax s = new Sintax(new sintactico.LexerCup(new StringReader(ST)));
        
        try {
            s.parse();
            txtAnalizarSin.setText("Análisis correcto");
            txtAnalizarSin.setForeground(new Color(25, 111, 61));
        } catch (Exception ex) {
            Symbol sym = s.getS();
            txtAnalizarSin.setText("Error de sintaxis en - Línea: " + (sym.right + 1) + " , Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"");
            txtAnalizarSin.setForeground(Color.red);
            Correcto = 1;

        }
          if(Correcto == 1){
                btnOpRe.setEnabled(false);
            }else{
                btnOpRe.setEnabled(true);
            }

    }//GEN-LAST:event_btnAnalizarSinActionPerformed

    private void btnOpReActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpReActionPerformed
            try {
            operaciones();
        } catch (IOException ex){
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnOpReActionPerformed

    private void btnAnalizarSemanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarSemanActionPerformed
        try {
               analizarSemantico();
           } catch (Exception ex) {
               Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
           }
    }//GEN-LAST:event_btnAnalizarSemanActionPerformed

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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane Entrada;
    private javax.swing.JTable Tabla_Lexica;
    private javax.swing.JButton btnAnalizarLex;
    private javax.swing.JButton btnAnalizarSeman;
    private javax.swing.JButton btnAnalizarSin;
    private javax.swing.JButton btnLimpiarLex;
    private javax.swing.JButton btnOpRe;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea txtAnalizarSeman;
    private javax.swing.JTextArea txtAnalizarSin;
    private javax.swing.JTextArea txtOpe;
    // End of variables declaration//GEN-END:variables

   
}
