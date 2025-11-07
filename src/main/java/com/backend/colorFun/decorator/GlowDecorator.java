package com.backend.colorFun.decorator;

public class GlowDecorator extends SvgDecorator {
    @Override
    public String decorate(String svg) {
        String defs = """
            <defs>
              <filter id=\"glow\" x=\"-50%\" y=\"-50%\" width=\"220%\" height=\"220%\">
                <feGaussianBlur stdDeviation=\"5\" result=\"blur\"/>
                <feColorMatrix result=\"glowColor\" type=\"matrix\" values=\"0 0 0 0 1  0 0 0 0 0.85  0 0 0 0 0.2  0 0 0 1 0\"/>
                <feMerge>
                  <feMergeNode in=\"glowColor\"/>
                  <feMergeNode in=\"SourceGraphic\"/>
                </feMerge>
              </filter>
            </defs>
            <style>.region{filter:url(#glow)}</style>
            """;
        return svg.replaceFirst("(?i)(<svg[^>]*>)", "$1" + defs);
    }
}
