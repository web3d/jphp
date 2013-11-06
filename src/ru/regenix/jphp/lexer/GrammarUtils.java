package ru.regenix.jphp.lexer;

import ru.regenix.jphp.lexer.tokens.expr.value.StringExprToken;

public class GrammarUtils {

    public final static String CLOSE_TAG = "?>";
    public final static String OPEN_TAG = "<?";
    public final static String CLOSE_COMMENT = "*/";

    public static boolean isVariableChar(char ch){
        return ch == '$';
    }

    public static boolean isSpace(char ch){
        return ch == ' ' || ch == '\t' || ch == '\n' || ch == '\r';
    }

    public static boolean isNumeric(char ch){
        return "0123456789".indexOf(ch) > -1;
    }

    public static boolean isFloatDot(char ch){
        return '.' == ch;
    }

    public static StringExprToken.Quote isQuote(char ch){
        if (ch == '\'')
            return StringExprToken.Quote.SINGLE;
        else if (ch == '"')
            return StringExprToken.Quote.DOUBLE;
        else if (ch == '`')
            return StringExprToken.Quote.SHELL;

        return null;
    }

    public static boolean isBackslash(char ch){
        return ch == '\\';
    }

    public static boolean isDelimiter(char ch){
        return "+-=/*:<>!?%@&^\\.|([{}]);,\t\n\r ".indexOf(ch) > -1;
    }

    public static boolean isNewline(char ch){
        return ch == '\n';
    }

    public static boolean isCloseTag(String word){
        return CLOSE_TAG.equals(word);
    }

    public static boolean isOpenTag(String word){
        return OPEN_TAG.equals(word);
    }

    public static boolean isCloseComment(String word){
        return CLOSE_COMMENT.equals(word);
    }
}
