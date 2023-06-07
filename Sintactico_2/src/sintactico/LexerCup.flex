package sintactico;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type Symbol
%cup /* Regresar el análisis */
%full /* Retornar toda la cadena */
%line /* Regresa la línea */
%char /* Regresa la columna en la que se encuentra */
D = [0-9]+
NUMERO = {D}+
LETRA = [a-zA-Z_]
DECIMAL = {NUMERO}\.{NUMERO}*
ESPACIO = [ ,\t,\r,\n]+

%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%
{ESPACIO} {/*Ignore*/} /* Espacios en blanco */
("+") {return new Symbol(sym.SUMA, yychar, yyline, yytext());}
("-") {return new Symbol(sym.RESTA, yychar, yyline, yytext());}
("*") {return new Symbol(sym.MULT, yychar, yyline, yytext());}
("/") {return new Symbol(sym.DIV, yychar, yyline, yytext());}
("(") {return new Symbol(sym.P_A, yychar, yyline, yytext());}
(")") {return new Symbol(sym.P_C, yychar, yyline, yytext());}
("sqrt") {return new Symbol(sym.SQRT, yychar, yyline, yytext());}
("%") {return new Symbol(sym.PORCENTAJE, yychar, yyline, yytext());}
("(-"{D}+")")|{D}+ {return new Symbol(sym.NUMERO, yychar, yyline, yytext());}
{DECIMAL}+ {return new Symbol(sym.DECIMAL, yychar, yyline, yytext());}
. {return new Symbol(sym.ERROR, yychar, yyline, yytext());}
