package com.mjc.stage2.parser;

import java.util.ArrayList;
import java.util.List;

public class ChainParserBuilder {
    private List<AbstractTextParser> parsers = new ArrayList<>();

    public ChainParserBuilder() {
    }

    public ChainParserBuilder setParser(AbstractTextParser abstractTextParser) {
        parsers.add(abstractTextParser);
        return this;
    }

    public AbstractTextParser build() {
        // Write your code here!
        AbstractTextParser firstParser = null;
        AbstractTextParser previousParser = null;

        for (AbstractTextParser parser : parsers) {
            if (firstParser == null) {
                firstParser = parser;
                previousParser = parser;
            } else {
                previousParser.setNextParser(parser);
                previousParser = parser;
            }
        }

        return firstParser;
    }
}
