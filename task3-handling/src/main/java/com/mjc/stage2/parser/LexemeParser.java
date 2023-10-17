package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends AbstractTextParser {
    private static final String LEXEME_REGEX = "\\s+";
    private static final String WORD_REGEX = "\\w[\\w!=?():]+";

    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        TextComponent lexeme = (TextComponent) abstractTextComponent;
        String[] lexemes = string.split(LEXEME_REGEX);

        for (String lexemeText : lexemes) {
            // Create a TextComponent to represent the word.
            TextComponent word = new TextComponent(TextComponentType.WORD);

            // Use the WORD_REGEX to split the lexeme into words.
            Pattern wordPattern = Pattern.compile(WORD_REGEX);
            Matcher wordMatcher = wordPattern.matcher(lexemeText);

            while (wordMatcher.find()) {
                // Create a SymbolLeaf for each character in the word.
                String wordText = wordMatcher.group();
                for (char symbol : wordText.toCharArray()) {
                    AbstractTextComponent symbolLeaf = new SymbolLeaf(TextComponentType.SYMBOL, symbol);
                    word.add(symbolLeaf);
                }
            }
        }
    }
}
