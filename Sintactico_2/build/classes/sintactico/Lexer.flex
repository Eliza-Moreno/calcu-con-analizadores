package sintactico;
import static sintactico.Token.*;
%%
%class Lexer
%type Token
D = [0-9]+
NUMERO = {D}+
DECIMAL = {NUMERO}\.{NUMERO}*

ESPACIO = [ ,\t,\r]+
%{
    public String lexeme;
%}
%{
  List<Token> listaTokens = new ArrayList<>();
%}

%{
  // Pasar la lista de tokens a Java
  AnalizadorJavaNetBeans.setListaTokens(listaTokens);
%}

%%

// Reglas para cada token
SUMA { 
  Token token = new Token(yytext(), "Suma");
  listaTokens.add(token);
  return SUMA;
}
RESTA { 
  Token token = new Token(yytext(), "Resta");
  listaTokens.add(token);
  return RESTA;
}
MULT { 
  Token token = new Token(yytext(), "Multiplicacion");
  listaTokens.add(token);
  return MULT;
}
DIV { 
  Token token = new Token(yytext(), "Division");
  listaTokens.add(token);
  return DIV;
}
P_A { 
  Token token = new Token(yytext(), "Parentesis de apertura");
  listaTokens.add(token);
  return LPAREN;
}
P_C { 
  Token token = new Token(yytext(), "Parentesis de cierre");
  listaTokens.add(token);
  return RPAREN;
}
SQRT { 
  Token token = new Token(yytext(), "Raiz cuadrada");
  listaTokens.add(token);
  return SQRT;
}
PORCENTAJE { 
  Token token = new Token(yytext(), "Porcentaje");
  listaTokens.add(token);
  return PORCENTAJE;
}
IGUAL { 
  Token token = new Token(yytext(), "Igual");
  listaTokens.add(token);
  return IGUAL;
}
ESPACIO { 
  Token token = new Token(yytext(), "Espacio");
  listaTokens.add(token);
  return ESPACIO;
}
ERROR { 
  Token token = new Token(yytext(), "Error");
  listaTokens.add(token);
  return ERROR;
}

%%
{ESPACIO} {/*Ignore*/} /* Espacios en blanco */
"\n"            {return LINEA;}
"+"             {lexeme=yytext(); return SUMA;}
"-"             {lexeme=yytext(); return RESTA;}
"*"             {lexeme=yytext(); return MULT;}
"/"             {lexeme=yytext(); return DIV;}
"("             {lexeme=yytext(); return P_A;}
")"             {lexeme=yytext(); return P_C;}
"sqrt"          {lexeme=yytext(); return SQRT;}
"%"             {lexeme=yytext(); return PORCENTAJE;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return NUMERO;}
{DECIMAL}      {lexeme=yytext(); return DECIMAL;}
. {return ERROR;}